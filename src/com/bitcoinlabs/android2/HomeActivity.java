package com.bitcoinlabs.android2;

import android.app.Activity;
import android.content.Intent;
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
				startActivity(new Intent(getApplicationContext(), ConfirmActivity.class));
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
}