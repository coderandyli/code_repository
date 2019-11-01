package com.coderandyli.reflect.demo01;

/**
 * Created by lizhen on 2019-10-30
 */
public enum SegmentStatusEnum {
    UNARRIVAL("300","在路上"),
    ARRIVAL("700","已到港"),
    DEPARTURE("1500","已离港");

    String value;
    String msg;

    SegmentStatusEnum(String value, String msg){
        this.value=value;
        this.msg=msg;
    }

    public static String getMeaning(String value){

        for(SegmentStatusEnum userType : SegmentStatusEnum.values()){
            if(userType.value.equals(value)){
                return userType.msg;
            }
        }
        return "error";
    }
}
