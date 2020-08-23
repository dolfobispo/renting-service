package com.movieservice.models.enums;

public enum RentStatus {
    RETURNED(0),
    RENTED(1);

    private int code;
    private RentStatus(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }

    public static RentStatus valueOf(int code){
        for (RentStatus value: RentStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }


}
