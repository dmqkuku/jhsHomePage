package com.home.jhshome.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.impl.ClaimsHolder;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.RSAKeyProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JwtTokenUtil implements Serializable, IJwtTokenUtil {

    private static final int JWT_MAX_AGE = 5 * 60 * 60;

    @Value("${jwt.secret}")
    private String salt;

    @Override
    public String doGenerateToken(UserDetails userDetails) {
        return generateToken(userDetails.getUsername());
    }

    @Override
    public boolean isTokenExpired(String token) {
        return false;
    }

    @Override
    public boolean isValidToken(String token) {
        return false;
    }

    private DecodedJWT decodeJwt(String token) {
        try{
            DecodedJWT jwt = JWT.decode(token);
            return jwt;
        }catch(JWTDecodeException ex){
            ex.printStackTrace();
        }
        return null;
    }

    private String generateToken(String subject){
        return JWT.create()
                .withIssuer(subject)
                .withIssuedAt(new Date())
                .sign(Algorithm.RSA512(new CustomRSAKeyProvider(this.salt)));
    }

    class CustomRSAKeyProvider implements RSAKeyProvider {

        private RSAPrivateKey privateKey;
        private RSAPublicKey publicKey;
        private String privateKeyId;

        CustomRSAKeyProvider(String privateKeyId) {
            this.privateKeyId = privateKeyId;

        }
        public CustomRSAKeyProvider keyProviderFactory (String privateKeyId){
            try {
                KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
                generator.initialize(2048);
                KeyPair pair = generator.generateKeyPair();
                this.privateKey = (RSAPrivateKey) pair.getPrivate();
                this.publicKey = (RSAPublicKey) pair.getPublic();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return new CustomRSAKeyProvider(privateKeyId);
        }

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
            return this.privateKeyId;
        }

    }


}
