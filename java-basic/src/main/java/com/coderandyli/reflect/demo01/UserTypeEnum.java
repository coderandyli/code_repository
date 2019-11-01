package com.coderandyli.reflect.demo01;

/**
 * Created by lizhen on 2019-10-30
 */
public enum UserTypeEnum {
    Geek("0","geek"),
    Boss("1","boss"),
    Other("2","other-userType");

    String value;
    String meaning;

    UserTypeEnum(String value,String meaning){
        this.value=value;
        this.meaning=meaning;
    }

    public static String getMeaning(String value){

        for(UserTypeEnum userType : UserTypeEnum.values()){
            if(userType.value.equals(value)){
                return userType.meaning;
            }
        }
        return "error";
    }
}
