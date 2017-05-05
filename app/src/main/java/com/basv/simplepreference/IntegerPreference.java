package com.basv.simplepreference;

import android.content.SharedPreferences;

/**
 * Created by Sergey Bakhtiarov on 11.07.2014.
 */
public class IntegerPreference extends BasePreference {
    private final int defaultValue;

    public IntegerPreference(SharedPreferences preferences, String key) {
        this(preferences, key, 0);
    }

    public IntegerPreference(SharedPreferences preferences, String key, int defaultValue) {
        super(preferences, key);
        this.defaultValue = defaultValue;
    }

    public int get() {
        return preferences.getInt(key, defaultValue);
    }

    public void set(int value) {
        preferences.edit().putInt(key, value).apply();
    }

    public void add(int value) {
        set(get() + value);
    }
}
