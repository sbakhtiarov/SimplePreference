package com.basv.simplepreference;

import android.content.SharedPreferences;

/**
 * Created by Sergey Bakhtiarov on 14.07.2014.
 */
public class StringPreference extends BasePreference {
    private final String defaultValue;

    public StringPreference(SharedPreferences preferences, String key) {
        this(preferences, key, null);
    }

    public StringPreference(SharedPreferences preferences, String key, String defaultValue) {
        super(preferences, key);
        this.defaultValue = defaultValue;
    }

    public String get() {
        return preferences.getString(key, defaultValue);
    }

    public void set(String value) {
        preferences.edit().putString(key, value).apply();
    }
}