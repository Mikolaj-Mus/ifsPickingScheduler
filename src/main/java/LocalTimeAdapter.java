package main.java;

import java.lang.reflect.Type;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import com.google.gson.*;

public class LocalTimeAdapter implements JsonSerializer<LocalTime>, JsonDeserializer<LocalTime> {
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public LocalTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String timeString = json.getAsString();
        return LocalTime.parse(timeString, TIME_FORMAT);
    }

    @Override
    public JsonElement serialize(LocalTime time, Type typeOfSrc, JsonSerializationContext context) {
        String timeString = time.format(TIME_FORMAT);
        return new JsonPrimitive(timeString);
    }
}