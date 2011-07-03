package com.bitcoinlabs.android2;

import java.math.BigDecimal;

import android.app.Activity;
import android.widget.Toast;

public class Util {
	
	public static boolean isValidBitcoinAmount(BigDecimal amount) {
		
		// negative?
		if (amount.compareTo(new BigDecimal("0")) == -1)
			return false;
		
		// exceeding the maximum money supply? 
		if (amount.compareTo(new BigDecimal("21000000")) == 1)
			return false;
		
		// too precise?
		String[] bits = amount.toPlainString().split("\\.");
		if (bits.length == 2) {
			if (StringUtils.stripEnd(bits[1], "0").length() > 8) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void toast(Activity activity, String text) {
		Toast.makeText(activity.getApplicationContext(), text, Toast.LENGTH_SHORT).show();
	}

	public static void toastLong(Activity activity, String text) {
		Toast.makeText(activity.getApplicationContext(), text, Toast.LENGTH_LONG).show();
	}
}
