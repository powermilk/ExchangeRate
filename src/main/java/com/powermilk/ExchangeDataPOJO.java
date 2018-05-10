package com.powermilk;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.jetbrains.annotations.Contract;

import java.util.List;

public class ExchangeDataPOJO {
    private final String table;
    private final String currency;
    private final String code;
    private final List<RatePOJO> rates;

    ExchangeDataPOJO(String table, String currency, String code, List<RatePOJO> rates) {
        this.table = table;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }

    ExchangeDataPOJO() {
        this.table = null;
        this.currency = null;
        this.code = null;
        this.rates = null;
    }

    public String getTable() {
        return table;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    List<RatePOJO> getRates() {
        return rates;
    }

    @Override
    @Contract(value = "null -> false", pure = true)
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final ExchangeDataPOJO exchangeDataPOJO = (ExchangeDataPOJO) obj;

        return new EqualsBuilder()
                .append(this.table, exchangeDataPOJO.table)
                .append(this.currency, exchangeDataPOJO.currency)
                .append(this.code, exchangeDataPOJO.code)
                .append(this.rates, exchangeDataPOJO.rates)
                .build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(table).append(currency).append(code).append(rates).build();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}