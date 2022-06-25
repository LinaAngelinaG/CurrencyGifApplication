package com.example.currencygifproviding.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;

@Getter
@Entity
@NoArgsConstructor
public class HistoricalCurrency {
    @EmbeddedId
    private HistoricalCurrencyId id;
    private double price;
    @Column(name = "has_price_inreased_from_yesterday")
    private boolean inreased;

    public HistoricalCurrency(String date, String currencyName,double price, boolean increased){
        id = new HistoricalCurrencyId(date,currencyName);
        this.price = price;
        this.inreased = increased;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        HistoricalCurrency that = (HistoricalCurrency) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
