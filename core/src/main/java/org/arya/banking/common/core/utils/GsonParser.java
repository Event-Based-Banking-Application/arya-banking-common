package org.arya.banking.common.core.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;

public class GsonParser {

    private static final Gson gson;

    private GsonParser() {}

    static {
        // Configure Gson to handle CharSequence by delegating to String's handling
        // This addresses the "Interfaces can't be instantiated!" error.
        GsonBuilder gsonBuilder = new GsonBuilder();

        // TypeAdapter for CharSequence, delegates to String handling
        gsonBuilder.registerTypeAdapter(CharSequence.class, new TypeAdapter<CharSequence>() {
            @Override
            public void write(JsonWriter out, CharSequence value) throws IOException {
                if (value == null) {
                    out.nullValue();
                } else {
                    // Delegate to String's write method
                    out.value(value.toString());
                }
            }

            @Override
            public CharSequence read(JsonReader in) throws IOException {
                if (in == null) {
                    return null;
                }
                // Delegate to String's read method
                return in.nextString();
            }
        });

        gson = gsonBuilder.create();
    }

    /**
     * Converts a Java object to its JSON string representation.
     *
     * @param obj The object to convert.
     * @param <T> The type of the object.
     * @return The JSON string representation of the object, or null if the input is null.
     */
    public static <T> String toJson(T obj) {
        if (obj == null) {
            return null;
        }
        return gson.toJson(obj);
    }

    /**
     * Converts a JSON string to a Java object of the specified type.
     *
     * @param json The JSON string to convert.
     * @param classOfT The class of the object to convert to.
     * @param <T> The type of the object.
     * @return The Java object represented by the JSON string.
     * @throws JsonSyntaxException If the JSON string is not a valid representation of the object.
     */
    public static <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        if (json == null || json.trim().isEmpty()) {
            return null;
        }
        return gson.fromJson(json, classOfT);
    }

    /**
     * Converts a JSON string to a Java object of the specified type, using a Type object.
     * This is useful for handling generic types.
     *
     * @param json The JSON string to convert.
     * @param typeOfT The Type of the object to convert to (e.g., new TypeToken<List<MyObject>>(){}.getType()).
     * @param <T> The type of the object.
     * @return The Java object represented by the JSON string.
     * @throws JsonSyntaxException If the JSON string is not a valid representation of the object.
     */
    public static <T> T fromJson(String json, Type typeOfT) throws JsonSyntaxException {
        if (json == null || json.trim().isEmpty()) {
            return null;
        }
        return gson.fromJson(json, typeOfT);
    }
}