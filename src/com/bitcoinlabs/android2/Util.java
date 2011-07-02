package com.bitcoinlabs.android2;

import android.app.Activity;
import android.widget.Toast;

public class Util {
	
	public static void toast(Activity activity, String text) {
		Toast.makeText(activity.getApplicationContext(), text, Toast.LENGTH_SHORT).show();
	}

	public static void toastLong(Activity activity, String text) {
		Toast.makeText(activity.getApplicationContext(), text, Toast.LENGTH_LONG).show();
	}
}
