package com.vilyever.contextholder;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * VDContextHolder
 * AndroidContextHolder <com.vilyever.vdcontextholder>
 * Created by vilyever on 2015/9/15.
 * Feature:
 */
public class VDContextHolder {
    private final VDContextHolder self = this;

    static Context ApplicationContext;

    /* Public Methods */
    public static void initial(Context context) {
        ApplicationContext = context;
    }

    public static Context getContext() {
        if (ApplicationContext == null) {
            try {
                Application application = (Application) Class.forName("android.app.ActivityThread")
                        .getMethod("currentApplication").invoke(null, (Object[]) null);
                if (application != null) {
                    Log.e(VDContextHolder.class.getName(), "ContextHolder is not initialed, it is recommend to initial with application context.");
                    ApplicationContext = application;
                    return application;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Application application = (Application) Class.forName("android.app.AppGlobals")
                        .getMethod("getInitialApplication").invoke(null, (Object[]) null);
                if (application != null) {
                    Log.e(VDContextHolder.class.getName(), "ContextHolder is not initialed, it is recommend to initial with application context.");
                    ApplicationContext = application;
                    return application;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            throw new IllegalStateException("ContextHolder is not initialed, it is recommend to initial with application context.");
        }
        return ApplicationContext;
    }
}