package appexperts.alberto.com.adjustsdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustConfig;

import static android.app.Application.*;

/** Tutorial followed...
 * https://github.com/adjust/android_sdk
 * Register in ...https://www.adjust.com/
 * for tracking the data, subscribe and get the appToken and place it in the String below, also see extra information from the site .
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        String appToken = "macr3aqdszk0";
        String environment = AdjustConfig.ENVIRONMENT_SANDBOX;
       // String environment = AdjustConfig.ENVIRONMENT_PRODUCTION; //In case of testing purposes...
        AdjustConfig config = new AdjustConfig(this, appToken, environment);
        Adjust.onCreate(config);

        registerActivityLifecycleCallbacks(new AdjustLifeCycleCallBacks());
    }


}

     final class AdjustLifeCycleCallBacks implements ActivityLifecycleCallbacks {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {
            Adjust.onResume();
        }

        @Override
        public void onActivityPaused(Activity activity) {
            Adjust.onPause();

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {

        }
    }
