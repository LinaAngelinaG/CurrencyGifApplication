package com.example.currencygifproviding.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
@NoArgsConstructor
public class HistoricalCurrencyId implements Serializable {
    private String date;
    private String currencyName;
    public HistoricalCurrencyId(String date, String currencyName){
        this.date = date;
        this.currencyName = currencyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null  || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        HistoricalCurrencyId that = (HistoricalCurrencyId) o;
        return date == that.date && Objects.equals(currencyName, that.currencyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, currencyName);
    }
}
