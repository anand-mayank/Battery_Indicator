package br.br;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Menu;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private BroadcastReceiver mybatterychange=new BroadcastReceiver() {
		
		@Override
		public void onReceive(Context obj, Intent i) {
			// TODO Auto-generated method stub
			TextView tv=(TextView)findViewById(R.id.textView1);
			ProgressBar pg=(ProgressBar)findViewById(R.id.progressBar1);
			int level=i.getIntExtra("level",0);
			tv.setText("battery is "+level+"% charge");
			tv.setTextColor(Color.GREEN);
			pg.setProgress(level);
			tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
			}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		registerReceiver(mybatterychange,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
