package main.java;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class OrderReader {
    private final String orderId;
    private final double orderValue;
    private final String pickingTime;
    private final LocalTime completeBy;

    public OrderReader(String orderId, double orderValue, String pickingTime, LocalTime completeBy) {
        this.orderId = orderId;
        this.orderValue = orderValue;
        this.pickingTime = pickingTime;
        this.completeBy = completeBy;
    }
    public static List<OrderReader> readOrders(String filename, Gson gson) {
        List<OrderReader> orders = null;
        try (FileReader reader = new FileReader(filename)) {
            orders = gson.fromJson(reader, new TypeToken<List<OrderReader>>(){}.getType());
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public String getOrderId() {
        return orderId;
    }
    public double getOrderValue() {
        return orderValue;
    }

    public Duration getPickingTime() {
        return Duration.ofMinutes(Integer.parseInt(pickingTime.substring(2, pickingTime.length() - 1)));
    }

    public LocalTime getCompleteBy() {
        return completeBy;
    }

}
