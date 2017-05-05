package com.basv.simplepreference;

import android.content.SharedPreferences;

/**
 * Created by Sergey Bakhtiarov on 11.07.2014.
 */
public class BooleanPreference extends BasePreference {
    private final boolean defaultValue;

    public BooleanPreference(SharedPreferences preferences, String key) {
        this(preferences, key, false);
    }

    public BooleanPreference(SharedPreferences preferences, String key, boolean defaultValue) {
        super(preferences, key);
        this.defaultValue = defaultValue;
    }

    public boolean get() {
        return preferences.getBoolean(key, defaultValue);
    }

    public void set(boolean value) {
        preferences.edit().putBoolean(key, value).apply();
    }
}
