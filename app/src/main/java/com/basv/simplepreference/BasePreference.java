package com.basv.simplepreference;

import android.content.SharedPreferences;

/**
 * Created by Sergey Bakhtiarov on 23.09.2014.
 */
abstract class BasePreference {

    protected final SharedPreferences preferences;
    protected final String key;

    public BasePreference(SharedPreferences preferences, String key) {
        this.preferences = preferences;
        this.key = key;
    }

    public boolean isSet() {
        return preferences.contains(key);
    }
    public void delete() {
        preferences.edit().remove(key).apply();
    }

}
