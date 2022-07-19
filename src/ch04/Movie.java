package ch04;

import ch02.Money;
import ch02.Screening;
import ch02.discountCondition.DiscountCondition;

import java.time.Duration;
import java.util.List;

public abstract class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
    }

    // discountConditons의 원소를 차례대로 순화하며 할인 여부를 판다하도록 요청
    private boolean isDiscountable(Screening screeing) {
        return discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screeing));
    }

    abstract protected Money calculateDiscountAmount();
//    private Money calculateDiscountAmount() {
//        switch(movieType) {
//            case AMOUNT_DISCOUNT:
//                return calculateAmountDiscountAmount();
//            case PERCENT_DISCOUNT:
//                return calculatePercentDiscountAmount();
//            case NONE_DISCOUNT:
//                return calculateNoneDiscountAmount();
//        }
//
//        throw new IllegalStateException();
//    }

    private Money calculateAmountDiscountAmount() {
        return discountAmount;
    }

    private Money calculatePercentDiscountAmount() {
        return fee.times(discountPercent);
    }

    private Money calculateNoneDiscountAmount() {
        return Money.ZERO;
    }
}
