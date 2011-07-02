package com.bitcoinlabs.android2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends Activity implements OnClickListener {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ((Button)this.findViewById(R.id.scan_button)).setOnClickListener(this);
        ((Button)this.findViewById(R.id.receive_button)).setOnClickListener(this);
        ((Button)this.findViewById(R.id.check_balance_button)).setOnClickListener(this);
        ((Button)this.findViewById(R.id.settings_button)).setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			
			case R.id.scan_button:
				Intent intent = new Intent("com.google.zxing.client.android.SCAN");
		        intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
		        try {
		            startActivityForResult(intent, 0);
		        }
		        catch (Exception e) {
		            Toast.makeText(this, "Please install \"Barcode Scanner\" (from ZXing)", Toast.LENGTH_LONG).show();
		        }
				break;
			
			case R.id.receive_button:
				startActivity(new Intent(getApplicationContext(), ReceiveActivity.class));
				break;
			
			case R.id.check_balance_button:
				Toast.makeText(getApplicationContext(), "TODO check balance", Toast.LENGTH_SHORT).show();
				break;
			
			case R.id.settings_button:
				startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
				break;
		}
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String scanResult = intent.getStringExtra("SCAN_RESULT");
                Intent i = new Intent(getApplicationContext(), SettingsActivity.class);
                try {
                	BitcoinURI bitcoinUri = new BitcoinURI(scanResult);
                    i.putExtra("BITCOIN_URI", bitcoinUri);
                    startActivity(i);
                }
                catch (InvalidURIException e) {
                	Util.toastLong(this, "Invalid/unsupported URI!");
                }
            }
            else if (resultCode == RESULT_CANCELED) {
                
            }
        }
	}
}