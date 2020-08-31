package com.movieservice.models.enums;

public enum PaymentMethod {
    CASH(1),
    CARD(2);

    private int code;
    private PaymentMethod(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }

    public static PaymentMethod valueOf(int code){
        for (PaymentMethod value: PaymentMethod.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Payment Method code");
    }
}
