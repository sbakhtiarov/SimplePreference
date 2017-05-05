package com.basv.simplepreference;

import android.content.SharedPreferences;

/**
 * Created by Sergey Bakhtiarov on 11.07.2014.
 */
public class LongPreference extends BasePreference {
    private final long defaultValue;

    public LongPreference(SharedPreferences preferences, String key) {
        this(preferences, key, 0);
    }

    public LongPreference(SharedPreferences preferences, String key, long defaultValue) {
        super(preferences, key);
        this.defaultValue = defaultValue;
    }

    public long get() {
        return preferences.getLong(key, defaultValue);
    }

    public void set(long value) {
        preferences.edit().putLong(key, value).apply();
    }
}
