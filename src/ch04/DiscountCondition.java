package ch04;

import ch02.Screening;

import java.time.DayOfWeek;
import java.time.LocalTime;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
//public class DiscountCondition {
//    private DiscountConditionType type;
//    private int sequence;
//    private DayOfWeek dayOfWeek;
//    private LocalTime startTime;
//    private LocalTime endTime;
//
//    public boolean isSatisfiedBy(Screening screening) {
//        if (type == DiscountConditionType.PERIOD) {
//            return isSatisfiedByPeriod(screening);
//        }
//
//        return isSatisfiedBySequence(screening);
//    }
//
//    // 기간 조건건
//   private boolean isSatisfiedByPeriod(Screening screening) {
//        return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
//                startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
//                endTime.isAfter(screening.getWhenScreened().toLocalTime());
//    }
//
//    // 순번 조건
//    private boolean isSatisfiedBySequence(Screening screening) {
//        return sequence == screening.getSequence();
//    }
//}
