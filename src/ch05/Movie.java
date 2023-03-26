package ch05;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public abstract class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;

    public Movie(String title, Duration runningTime, Money fee, DiscountCondition... discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = Arrays.asList(discountConditions);
    }

    /**
     * DiscountCondition -> 순번 조건, 기간 조건 두 개의 독립적 타입이 공존하고 있다
     * 이를 해결하기 위해 두 타입을 두 개의 클래스로 분리
     * -> 근데 이에 따라 결합도가 높아지는 문제 발생
     * -> 할인 조건을 추가하기 위해서는 또 변수 만들야 함...
     * */
    //private List<DiscountCondition> discountConditions;
//    private List<PeriodCondition> periodConditions;
//    private List<SequenceCondition> sequenceConditions;

    // 인터페이스 사용
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
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
    }

    private boolean isDiscountable(Screening screening) {
//        return discountConditions.stream()
//                .anyMatch(condition -> condition.isSatisfiedBy(screening));
        //return checkPeriodConditions(screening) || checkSequenceConditions(screening);
        return discountConditions.stream()
                .anyMatch(c->c.isSatisfiedBy(screening));
    }

//    private boolean checkPeriodConditions(Screening screening) {
//        return periodConditions.stream()
//                .anyMatch(condition -> condition.isSatisfiedBy(screening));
//    }
//
//    private boolean checkSequenceConditions(Screening screening) {
//        return sequenceConditions.stream()
//                .anyMatch(condition -> condition.isSatisfiedBy(screening));
//    }

//    private Money calculateDiscountAmount() {
//        // movietype의 값에 따라 적절한 메서드를 호출한다
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

//    private Money calculateAmountDiscountAmount() {
//        return discountAmount;
//    }
//
//    private Money calculatePercentDiscountAmount() {
//        return fee.times(discountPercent);
//    }
//
//    private Money calculateNoneDiscountAmount() {
//        return Money.ZERO;
//    }
//

    // 서브클래스에서만 사용해야 하므로 protected로 제한
    protected Money getFee() {
        return this.fee;
    }
    abstract protected Money calculateDiscountAmount();
}
