package fr.xebia.blog;

import com.google.common.base.Optional;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class AmountAccumulatorTest {

    @Test
    public void should_get_absent_for_empty_accumulator() {
        Optional<Amount> actualAmount = new AmountAccumulator().getAmount();

        assertThat(actualAmount.isPresent()).isFalse();
    }
}
