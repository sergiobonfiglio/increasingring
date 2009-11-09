package org.apelikecoder.turnup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class AlarmListener extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        android.util.Log.d("TurnUP/AlarmListener", "ALAAAAAAARM! " + intent.toString());
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        if (sp.getBoolean(TurnUP.PREFS_KEY_ENABLE_ALARM_SERVICE, false))
            context.startService(new Intent(context, AlarmVolumeControlService.class));
    }

}
