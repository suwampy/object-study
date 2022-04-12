package ch02.discountPolicy;

import ch02.Money;
import ch02.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
