package com.project.lunchTime.dto;

import java.util.Date;
import java.util.Objects;

public class HistoricDTO {

    public Date date;
    public int week;
    public Long restaurantId;
    public int monthNumber;
    public Long userId;

    public boolean hasDate() {
        return Objects.nonNull(date);
    }

    public boolean hasWeek() {
        return Objects.nonNull(week);
    }

    public boolean hasRestaurantId() {
        return Objects.nonNull(restaurantId);
    }

    public boolean hasMonthNumber() {
        return Objects.nonNull(monthNumber);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
