package fr.xebia.blog;

import java.math.BigDecimal;
import java.util.Currency;

public class Amount {

    private final Currency currency;
    private final BigDecimal value;

    public Amount(BigDecimal value, Currency currency) {
        this.currency = currency;
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Amount add(BigDecimal value) {
        return new Amount(this.value.add(value), this.currency);
    }
}
