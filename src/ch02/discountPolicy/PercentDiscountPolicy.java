package ch02.discountPolicy;

import ch02.Money;
import ch02.Screening;
import ch02.discountCondition.DiscountCondition;

// 비율 할인 정책
public class PercentDiscountPolicy extends DefaultDiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    // 고정 금액이 아닌 일정 비율을 차감함
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
