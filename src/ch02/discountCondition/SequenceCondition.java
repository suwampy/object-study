package ch02.discountCondition;

import ch02.Screening;
import ch02.discountCondition.DiscountCondition;

// 할인 조건 -순번 조건
public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
