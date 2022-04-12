package ch02.discountPolicy;

import ch02.Money;
import ch02.Screening;
import ch02.discountCondition.DiscountCondition;

// 금액 할인 정책
public class AmountDiscountPolicy extends DefaultDiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
