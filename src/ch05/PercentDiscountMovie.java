package ch05;

import java.time.Duration;

public class PercentDiscountMovie extends Movie {
    private double percent;

    public PercentDiscountMovie(String title, Duration runningTIme, Money fee, double percent, DiscountCondition... discountConditions) {
        super(title, runningTIme, fee, discountConditions);
        this.percent = percent;
    }
    @Override
    protected Money calculateDiscountAmount() {
        return getFee().times(percent);
    }
}
