package fr.xebia.blog;

import java.math.BigDecimal;
import java.util.Currency;

import com.google.common.base.Optional;

import org.fest.assertions.api.AbstractAssert;

public class OptionalAmountAsserter extends AbstractAssert<OptionalAmountAsserter, Optional<Amount>> {

    private static final String NULL_ERROR = "The amount should not be null";
    private static final String ABSENCE_ERROR = "The amount should exists";
    private static final String PRESENCE_ERROR = "The amount should exists";
    private static final String CURRENCY_ERROR = "Currency of the amount";
    private static final String VALUE_ERROR = "Value of the amount";

    OptionalAmountAsserter(Optional<Amount> actual) {
        super(actual, OptionalAmountAsserter.class);
    }

    public OptionalAmountAsserter isAbsent() {
        Assertions.assertThat(actual).overridingErrorMessage(NULL_ERROR).isNotNull();
        Assertions.assertThat(actual.isPresent()).overridingErrorMessage(ABSENCE_ERROR).isFalse();

        return this;
    }

    public OptionalAmountAsserter isPresent() {
        Assertions.assertThat(actual).overridingErrorMessage(NULL_ERROR).isNotNull();
        Assertions.assertThat(actual.isPresent()).overridingErrorMessage(PRESENCE_ERROR).isTrue();

        return this;
    }

    public OptionalAmountAsserter hasCurrency(Currency expected) {
        Assertions.assertThat(actual).overridingErrorMessage(NULL_ERROR).isNotNull();
        isPresent();
        Currency actualCurrency = actual.get().getCurrency();

        Assertions.assertThat(actualCurrency).describedAs(CURRENCY_ERROR).isEqualTo(expected);

        return this;
    }

    public OptionalAmountAsserter hasValue(BigDecimal expected) {
        Assertions.assertThat(actual).overridingErrorMessage(NULL_ERROR).isNotNull();
        isPresent();
        BigDecimal actualValue = actual.get().getValue();

        Assertions.assertThat(actualValue).describedAs(VALUE_ERROR).isEqualTo(expected);

        return this;
    }
}
