package main.java;

import java.time.Duration;
import java.time.LocalTime;

class Order {

    private final String orderId;
    private final double value;
    private final Duration pickingTime;
    private final LocalTime completeBy;
    private LocalTime startPicking;
    private final LocalTime priorityStartTime;

    public Order(String orderId, double value, Duration pickingTime, LocalTime completeBy) {
        this.orderId = orderId;
        this.value = value;
        this.pickingTime = pickingTime;
        this.completeBy = completeBy;
        this.startPicking = null;
        this.priorityStartTime = completeBy.minus(pickingTime);
    }

    public Duration getPickingTime() {
        return this.pickingTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public LocalTime getCompleteBy() {
        return completeBy;
    }

    public LocalTime getPriorityStartTime() {
        return priorityStartTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + orderId + '\'' +
                ", value=" + value +
                ", pickingTime=" + pickingTime +
                ", completeBy=" + completeBy +
                ", startPicking=" + startPicking +
                '}';
    }

    public LocalTime getStartPicking() {
        return startPicking;
    }

    public void setStartPicking(LocalTime startPicking) {
        this.startPicking = startPicking;
    }


}