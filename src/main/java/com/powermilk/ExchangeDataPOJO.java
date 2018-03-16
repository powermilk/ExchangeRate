package com.powermilk;

import java.util.List;

public class ExchangeDataPOJO {
    private String table;
    private String currency;
    private String code;
    private List<RatePOJO> rates;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<RatePOJO> getRates() {
        return rates;
    }

    public void setRates(List<RatePOJO> rates) {
        this.rates = rates;
    }
}