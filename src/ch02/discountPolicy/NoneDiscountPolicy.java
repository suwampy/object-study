package ch02.discountPolicy;

import ch02.Money;
import ch02.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {

//    @Override
//    protected Money getDiscountAmount(Screening screening) {
//        return Money.ZERO;
//    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return null;
    }
}
