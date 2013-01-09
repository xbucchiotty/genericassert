package fr.xebia.blog;

import com.google.common.base.Optional;

import static com.google.common.base.Optional.absent;
import static com.google.common.base.Optional.of;

public class AmountAccumulator {

    private final Optional<Amount> amount;

    public AmountAccumulator() {
        this.amount = absent();
    }

    public AmountAccumulator(Amount accumulate) {
        this.amount = of(accumulate);
    }

    public AmountAccumulator accumulate(final Amount amount) {
        AmountAccumulator nextState;

        if (!this.amount.isPresent()) {
            nextState = new AmountAccumulator(amount);
        } else {
            Amount currentState = this.amount.get();

            nextState = new AmountAccumulator(currentState.add(amount.getValue()));
        }

        return nextState;
    }

    public Optional<Amount> getAmount() {
        return amount;
    }
}
