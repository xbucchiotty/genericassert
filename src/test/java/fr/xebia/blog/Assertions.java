package fr.xebia.blog;

import com.google.common.base.Optional;

public class Assertions extends org.fest.assertions.Assertions{

    public static OptionalAmountAsserter assertThat(Optional<Amount> actual) {
        return new OptionalAmountAsserter(actual);
    }
}
