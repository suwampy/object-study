package ch02.discountPolicy;

import ch02.Money;
import ch02.Screening;
import ch02.discountCondition.DiscountCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 할인 정책
 * - 금액 할인 정책 (AmountDiscountPolicy)
 * - 비율 할인 정책 (PercentDiscountPolicy)
 *  -> 두 클래스는 대부분의 코드가 유사하고 할인 요금을 계산하는 방식만 조금 다름
 *  -> 두 클래스 사이의 중복 코드를 제거하기 위해 공통 코드를 보관할 장소가 필요 = DiscountPolicy
 *  -> 할인 여부와 요금 계산에 필요한 전체적인 흐름 정의
 **/
public abstract class DefaultDiscountPolicy implements DiscountPolicy {
    /**
     * 하나의 할인 정책은 여러 개의 할인 조건을 포함할 수 있다
     * */
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        for(DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) { // 해당 할인 조건에 만족 하는가?
                // 할인 조건을 만족하는 DiscountCondition이 하나라도 존재하는 경우에는
                // 추상 메서드인 getDiscountAmount 메서드를 호출해 할인 요금을 계산한다.
                return getDiscountAmount(screening);
            }
        }

        // 만족하는 할인 조건이 하나도 존재하지 않는다면 할인 요금으로 0원을 반환한다.
        return Money.ZERO;
    }

    /**
     * 할인 정책에 따라 계산
     * - 실제로 요금을 계산하는 부분은 추상 메서드인 getDiscountAmount 메서드에 위임
     * - 실제로는 DiscountPolicy를 상속 받은 자식 클래스에서 오버라이딩한 메서드가 실행될 것이다
     * */
    abstract protected Money getDiscountAmount(Screening screening);
}
