package com.myRetailService.poc.service.model;

public class CurrentPrice {

    private String currency_code;
    private String value;

    public CurrentPrice(String currency_code, String value) {
        this.currency_code = currency_code;
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

}
