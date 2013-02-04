package fr.xebia.blog;

import com.google.common.base.Optional;

public class Assertions extends org.fest.assertions.api.Assertions {

  public static OptionalAmountAsserter assertThat(Optional<Amount> actual) {
    return new OptionalAmountAsserter(actual);
  }
}
