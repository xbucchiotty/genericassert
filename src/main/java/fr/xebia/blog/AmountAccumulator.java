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
        final AmountAccumulator nextState;

        if (!this.amount.isPresent()) {
            nextState = new AmountAccumulator(amount);
        } else {
            final Amount currentState = this.amount.get();

            if (currentState.getCurrency().equals(amount.getCurrency())) {
                nextState = new AmountAccumulator(currentState.add(amount.getValue()));
            } else {
                nextState = new AmountAccumulator();
            }
        }

        return nextState;
    }

    public Optional<Amount> getAmount() {
        return amount;
    }
}
