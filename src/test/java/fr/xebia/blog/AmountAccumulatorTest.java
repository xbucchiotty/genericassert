package fr.xebia.blog;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class AmountAccumulatorTest {

    @Test
    public void should_get_absent_for_empty_accumulator() {
        assertThat(new AmountAccumulator().getAmount().isPresent()).isEqualTo(false);
    }
}
