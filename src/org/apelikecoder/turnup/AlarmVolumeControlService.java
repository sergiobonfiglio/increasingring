package org.apelikecoder.turnup;

import android.content.SharedPreferences;
import android.media.AudioManager;
import android.preference.PreferenceManager;

public class AlarmVolumeControlService extends VolumeControlService {

    private final static String TAG = "TurnUP/AlarmVolumeControlService";
    
    @Override
    protected void startVolumeIncrease() {
        int startUpVolume = 1;
        setCurrentVolume(startUpVolume);
        android.util.Log.d(TAG, "Current volume: " + getCurrentVolume());
        super.startVolumeIncrease();
    }

    @Override
    protected void reloadSettings() {
        setStreamType(AudioManager.STREAM_ALARM);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        setMaxVolume(sp.getInt(TurnUP.PREFS_KEY_MAX_ALARM_VOLUME, getStreamMaxVolume()));
        setDelay(Integer.valueOf(sp.getString(TurnUP.PREFS_KEY_ALARM_DELAY_INTREVAL, "0")));
    }

    @Override
    protected boolean shouldStop() {
        return !isRoomVolumeAvailable();
    }
}
