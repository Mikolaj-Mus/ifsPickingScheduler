package main.java;

import java.time.LocalTime;
import java.util.ArrayList;

class Picker {
    private final String pickerId;
    private LocalTime finishOrderTime;
    private final LocalTime finishWorkTime;
    private final ArrayList<Order> orders;


    public Picker(String pickerId, LocalTime startWorkTime, LocalTime finishWorkTime) {
        this.pickerId = pickerId;
        this.finishOrderTime = startWorkTime;
        this.finishWorkTime = finishWorkTime;
        this.orders = new ArrayList<>();
    }


    public void addOrder(Order order) {
        order.setStartPicking(finishOrderTime);
        this.finishOrderTime = this.finishOrderTime.plus(order.getPickingTime());
        this.orders.add(order);
    }



    public String getPickerId() {
        return pickerId;
    }

    public LocalTime getFinishOrderTime() {
        return finishOrderTime;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }


    @Override
    public String toString() {
        return "Picker{" +
                "pickerId='" + pickerId + '\'' +
                ", finishOrderTime=" + finishOrderTime +
                ", finishWorkTime=" + finishWorkTime +
                ", orders=" + orders +
                '}';
    }
}
