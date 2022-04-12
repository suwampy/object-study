package ch02.discountCondition;

import ch02.Screening;

// 할인 조건
public interface DiscountCondition {
    // 인자로 전달된 screening이 할인이 가능할 경우 true 반환, 불가능한 경우 false 반환
    boolean isSatisfiedBy(Screening screening);
}
