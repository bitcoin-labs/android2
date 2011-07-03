package com.bitcoinlabs.android2;

import com.google.bitcoin.core.Address;

import android.app.Activity;
import android.os.Bundle;

public class ConfirmActivity extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm);
        
        Bundle extras = getIntent().getExtras();
        BitcoinURI uri = (BitcoinURI)extras.get("BITCOIN_URI");
        Util.toastLong(this, "Address: " + uri.addresses.get(0));
    }
}
