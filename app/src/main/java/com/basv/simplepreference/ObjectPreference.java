package com.basv.simplepreference;

import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by Sergey Bakhtiarov on 23.09.2014.
 */
public class ObjectPreference <T> extends BasePreference {
    private final T defaultValue;
    private final Class<T> classOfObject;

    public ObjectPreference(SharedPreferences preferences, String key, Class<T> classOfObject) {
        this(preferences, key, null, classOfObject);
    }

    public ObjectPreference(SharedPreferences preferences, String key, T defaultValue, Class<T> classOfObject) {
        super(preferences, key);
        this.defaultValue = defaultValue;
        this.classOfObject = classOfObject;
    }

    public T get() {
        String json = preferences.getString(key, null);
        if (json == null) {
            return defaultValue;
        }

        return new Gson().fromJson(json, classOfObject);
    }

    public T get(Gson gson) {
        String json = preferences.getString(key, null);
        if (json == null) {
            return defaultValue;
        }

        return gson.fromJson(json, classOfObject);
    }

    public void set(T value) {
        String json = new Gson().toJson(value);
        preferences.edit().putString(key, json).apply();
    }
}
