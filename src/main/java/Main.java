package main.java;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static main.java.PickerReader.readPickers;
import static main.java.OrderReader.readOrders;

public class Main {

    static ArrayList<Order> orders = new ArrayList<>();
    static ArrayList<Picker> pickers = new ArrayList<>();
    public static Picker findPicker(ArrayList<Picker> pickers, Order order) {
        Picker nextPicker = null;
        LocalTime minPicker = pickers.get(0).getFinishOrderTime();
        for (Picker picker : pickers) {
            if (!picker.getFinishOrderTime().isAfter(minPicker)) {
                if (picker.getFinishOrderTime().plus(order.getPickingTime()).isAfter(order.getCompleteBy())) {
                    continue;
                }
                minPicker = picker.getFinishOrderTime();
                nextPicker = picker;
            }
        }
        return nextPicker;
    }

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Program requires exactly two arguments: store file path and orders file path");
            return;
        }

        Gson gson = new GsonBuilder().registerTypeAdapter(LocalTime.class, new LocalTimeAdapter()).create();
        PickerReader pickerList = readPickers(args[0], gson);
        List<OrderReader> orderList = readOrders(args[1], gson);
        //taking orders and pickers from json file


        for (OrderReader orderReader : orderList) {
            orders.add(new Order(orderReader.getOrderId(), orderReader.getOrderValue(), orderReader.getPickingTime(), orderReader.getCompleteBy()));
        }
        //making orders from file as an Order objects

        List<String> reversedPickers = new ArrayList<>(pickerList.pickers());
        Collections.reverse(reversedPickers);
        pickers.sort(Comparator.comparing(Picker::getPickerId));
        for (String pickerId : reversedPickers) {
            pickers.add(new Picker(pickerId, pickerList.pickingStartTime(), pickerList.pickingEndTime()));
        }

        orders.sort(Comparator.comparing(Order::getPriorityStartTime));

        for (Order order : orders) {
            Picker nextPicker = findPicker(pickers, order);
            if (nextPicker == null){
                continue;
            }
            nextPicker.addOrder(order);
            System.out.println(nextPicker.getPickerId() + " " + order.getOrderId() + " " + order.getStartPicking());
        }
    }
}
