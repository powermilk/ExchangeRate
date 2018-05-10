package com.powermilk;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.Contract;

public class RatePOJO {
    private final String no;
    private final String effectiveDate;
    private final double mid;

    public RatePOJO() {
        this.no = null;
        this.effectiveDate = null;
        mid = 0.0d;
    }

    public RatePOJO(String no, String effectiveDate, double mid) {
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.mid = mid;
    }

    public String getNo() {
        return no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    double getMid() {
        return mid;
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

        final RatePOJO ratePOJO = (RatePOJO) obj;

        return new EqualsBuilder()
                .append(this.no, ratePOJO.no)
                .append(this.effectiveDate, ratePOJO.effectiveDate)
                .append(this.mid, ratePOJO.mid)
                .build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(no).append(effectiveDate).append(mid).build();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
