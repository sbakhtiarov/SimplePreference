package com.basv.simplepreference;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Sergey Bakhtiarov on 23.09.2014.
 */
public class ObjectListPreference<T> extends BasePreference {
    private final List<T> defaultValue;
    private final Class<T> classOfObject;

    public ObjectListPreference(SharedPreferences preferences, String key, Class<T> classOfObject) {
        this(preferences, key, null, classOfObject);
    }

    public ObjectListPreference(SharedPreferences preferences, String key, List<T> defaultValue, Class<T> classOfObject) {
        super(preferences, key);
        this.defaultValue = defaultValue;
        this.classOfObject = classOfObject;
    }

    public List<T> get() {
        String json = preferences.getString(key, null);
        if (json == null) {
            return defaultValue;
        }

        return new Gson().fromJson(json, new ListOfJson<>(classOfObject));
    }

    public List<T> get(Gson gson) {
        String json = preferences.getString(key, null);
        if (json == null) {
            return defaultValue;
        }

        return gson.fromJson(json, new ListOfJson<>(classOfObject));
    }

    public void set(List<T> value) {
        String json = new Gson().toJson(value);
        preferences.edit().putString(key, json).apply();
    }

    private static class ListOfJson<E> implements ParameterizedType {
        private Class<?> wrapped;

        ListOfJson(Class<E> wrapper) {
            this.wrapped = wrapper;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return new Type[] { wrapped };
        }

        @Override
        public Type getRawType() {
            return List.class;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }
    }
}
