package ch05;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Money calculateMovieFee(Screening screening) {
        /**
         * 요금 계산을 위해서는
         * - 기본 금액 (fee)
         * - 할인 조건(discountConditions)
         * - 할인 정책 등의 정보를 알아야함
         * */
        if (isDiscountalbe(screening)) {
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    private Money calculateDiscountAmount() {
        // movietype의 값에 따라 적절한 메서드를 호출한다
        switch(movieType) {
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountAmount();
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountAmount();
            case NONE_DISCOUNT:
                return calculateNoneDiscountAmount();
        }

        throw new IllegalStateException();
    }

    private Money calculateAmountDiscountAmount() {
        return discountAmount;
    }

    private MOney calculatePercentDiscountAmount() {
        return fee.times(discountPercent);
    }

    private MOney calculateNoneDiscountAmount() {
        return Money.ZERO;
    }
}
