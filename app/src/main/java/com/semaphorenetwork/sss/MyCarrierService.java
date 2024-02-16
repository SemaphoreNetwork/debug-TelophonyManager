package com.semaphorenetwork.sss;

import android.os.Build;
import android.os.PersistableBundle;
import android.service.carrier.CarrierIdentifier;
import android.service.carrier.CarrierService;
import android.telephony.CarrierConfigManager;
import android.util.Log;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.M)
public class MyCarrierService extends CarrierService {
        private static final String TAG = "MyCarrierService";

        public MyCarrierService() {
            Log.d(TAG, "kdd, Service created");
        }

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public PersistableBundle onLoadConfig(CarrierIdentifier id) {
            Log.d(TAG, "kdd, Config being fetched");
            PersistableBundle config = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                config = new PersistableBundle();
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                config.putBoolean(
                        CarrierConfigManager.KEY_CARRIER_VOLTE_AVAILABLE_BOOL, true);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                config.putBoolean(
                        CarrierConfigManager.KEY_CARRIER_VOLTE_TTY_SUPPORTED_BOOL, false);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                config.putInt(CarrierConfigManager.KEY_VOLTE_REPLACEMENT_RAT_INT, 6);
            }
            // Check CarrierIdentifier and add more config if needed…
            return config;
        }
}
