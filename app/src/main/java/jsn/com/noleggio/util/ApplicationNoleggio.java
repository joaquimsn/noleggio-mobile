package jsn.com.noleggio.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by joaquimsn on 11/12/15.
 */
public class ApplicationNoleggio extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getAppContext() {
        return context;
    }
}
