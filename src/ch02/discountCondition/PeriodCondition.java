package ch02.discountCondition;

import ch02.Screening;
import ch02.discountCondition.DiscountCondition;

import java.time.DayOfWeek;
import java.time.LocalTime;

// 할인 조건 - 기간 조건
// 상영 시작 시간이 특정한 기간 안에 포함되는지 여부를 판단해 할인 여부를 결정
public class PeriodCondition implements DiscountCondition {
    private DayOfWeek dayOfWeek; // 조건에 사용할 요일
    private LocalTime startTime; // 시작 시간
    private LocalTime endTime; // 종료 시작

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) && // 상영 요일이 dayOfWeek와 같고
                startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0 && // 상영 시작 시간이 startTime과
                endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;     // endTime 사이에 있을 경우 true
    }
}
