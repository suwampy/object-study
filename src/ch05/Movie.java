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
        return discountCOnditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }
}
