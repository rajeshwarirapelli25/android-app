package fr.gaulupeau.apps.Poche.data;

import android.content.Context;
import android.content.SharedPreferences;

import fr.gaulupeau.apps.InThePoche.BuildConfig;

/**
 * @author Victor Häggqvist
 * @since 10/20/15
 */
public class Settings {

    private static final String PREFS_NAME = "InThePoche"; // keeping prefname for backwards compat

    public static final String URL = "pocheUrl";
    public static final String USER_ID = "APIUsername";
    public static final String TOKEN = "APIToken";
    public static final String ALL_CERTS = "all_certs";
    public static final String HIGH_CONTRAST = "high_contrast";
    public static final String LIST_LIMIT = "list_limit";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String HTTP_AUTH_USERNAME = "http_auth_username";
    public static final String HTTP_AUTH_PASSWORD = "http_auth_password";
    public static final String VERSION_CODE = "version_code";

    private SharedPreferences pref;

    public Settings(Context context) {
        pref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void setString(String key, String value) {
        pref.edit().putString(key, value).commit();
    }

    public void setInt(String key, int value) {
        pref.edit().putInt(key, value).commit();
    }

    public void setBoolean(String key, boolean value) {
        pref.edit().putBoolean(key, value).commit();
    }

    public String getUrl() {
        return pref.getString(URL, null);
    }

    public String getKey(String key) {
        return pref.getString(key, null);
    }

    public String getString(String key, String defValue) {
        return pref.getString(key, defValue);
    }

    public int getInt(String key, int defValue) {
        return pref.getInt(key, defValue);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return pref.getBoolean(key, defValue);
    }

    public void setAppVersion(int versionCode) {
        pref.edit().putInt(VERSION_CODE, versionCode).commit();
    }

    public int getPrevAppVersion() {
        return pref.getInt(VERSION_CODE, BuildConfig.VERSION_CODE);
    }

    public boolean hasUpdateChecker() {
        return pref.getInt("update_checker", -1) != -1;
    }
}