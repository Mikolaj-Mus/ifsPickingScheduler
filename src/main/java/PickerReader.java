package main.java;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;


record PickerReader(List<String> pickers, LocalTime pickingStartTime, LocalTime pickingEndTime) {
    public static PickerReader readPickers(String filename, Gson gson) {
        PickerReader pickingSchedule = null;
        try (FileReader reader = new FileReader(filename)) {
            pickingSchedule = gson.fromJson(reader, PickerReader.class);
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }
        return pickingSchedule;
    }
}