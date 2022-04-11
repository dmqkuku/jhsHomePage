package com.home.jhshome.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.RSAKeyProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;


@Component
public class JwtTokenUtil implements Serializable, IJwtTokenUtil {

    private static final int JWT_MAX_AGE = 5 * 60 * 60;

    @Value("${jwt.salt}")
    private String salt;

    @Override
    public String doGenerateToken(UserDetails userDetails) {
        return generateToken(userDetails.getUsername());
    }

    @Override
    public boolean isTokenExpired(String token) {
        var jwt = decodeJwt(token);
        if(jwt == null) return false;
        final Date expiresAt = jwt.getExpiresAt();
        return expiresAt.before(new Date());
    }

    public boolean isTokenExpired(DecodedJWT jwt){
        final Date expiresAt = jwt.getExpiresAt();
        return expiresAt.before(new Date());
    }

    @Override
    public boolean isValidToken(String token, UserDetails userDetails) {
        var jwt = decodeJwt(token);
        if(jwt == null) return false;
        final String userName = jwt.getIssuer();

        return userName != null && (userName.equals(userDetails.getUsername()) && !isTokenExpired(jwt));
    }

    private DecodedJWT decodeJwt(String token) {

        try{
            return JWT.decode(token);
        }catch(JWTDecodeException ex){
            ex.printStackTrace();
        }
        return null;
    }

    private String generateToken(String subject){
        /*
        * payloadclaim : iss, sub, aud, exp, nbf, iat, jti
        * headerclaim : alg, typ, cty, kid
        * */
        var keyProvider = new CustomRSAKeyProvider(this.salt).initKeyProvider();

        System.out.println("pk1 : " + keyProvider.getPrivateKey());
        System.out.println("pk2 : " + keyProvider.getPublicKeyById(""));
        return JWT.create()
                .withIssuer(subject)
                .withClaim("exp", new Date(System.currentTimeMillis() + JWT_MAX_AGE * 1000))
                .withIssuedAt(new Date())
                .sign(Algorithm.RSA512(keyProvider));
    }

    class CustomRSAKeyProvider implements RSAKeyProvider {

        private RSAPrivateKey privateKey;
        private RSAPublicKey publicKey;
        private final String privateKeyId;

        //private?
        CustomRSAKeyProvider(String privateKeyId) {
            this.privateKeyId = privateKeyId;

        }
        public CustomRSAKeyProvider initKeyProvider (){
            try {
                KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
                generator.initialize(1024);
                KeyPair pair = generator.generateKeyPair();
                this.privateKey = (RSAPrivateKey) pair.getPrivate();
                this.publicKey = (RSAPublicKey) pair.getPublic();
                System.out.println("pk : " + privateKey);
                System.out.println("public : " + publicKey);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return this;
        }

        //kid is optional. useful when you have multiple keys to sign the tokens.
        @Override
        public RSAPublicKey getPublicKeyById(String keyId) {
            return this.publicKey;
        }

        @Override
        public RSAPrivateKey getPrivateKey() {
            return this.privateKey;
        }

        @Override
        public String getPrivateKeyId() {
            return null;
        }

    }


}
