package com.home.jhshome.app.data.user;

public enum Role {
    SUPER_ADMIN,
    ADMIN,
    USER;

    public static boolean isValidRoleString(String input){
        if(input.equals(SUPER_ADMIN.name()) || input.equals(ADMIN.name()) || input.equals(USER.name())){
            return true;
        }
        return false;
    }
}
