package ch02;

import ch02.discountPolicy.DefaultDiscountPolicy;
import ch02.discountPolicy.DiscountPolicy;

import java.time.Duration;

// 영화 : 영화에 대한 기본 정보를 표현
public class Movie {
    private String title; // 제목
    private Duration runningTime; // 상영 시간
    private Money fee; // 기본 요금
    private DefaultDiscountPolicy defaultDiscountPolicy; // 할인 정책
    private DiscountPolicy discountPolicy;

    // 단 하나의 할인 정책만 설정할 수 있도록 제약을 강제
    public Movie(String title, Duration runningTime, Money fee, DefaultDiscountPolicy defaultDiscountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.defaultDiscountPolicy = defaultDiscountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    /**
     * discountPolicy에 calculateDiscountAmount 메시지를 전송해 할인 요금을 반환받음
     * Movie는 기본 요금인 fee에서 반환된 할인 요금을 차감함
     * */
    public Money calculateMovieFee(Screening screening) {
        return fee.minus(defaultDiscountPolicy.calculateDiscountAmount(screening));
    }

    public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
}
