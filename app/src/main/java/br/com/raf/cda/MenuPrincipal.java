package br.com.raf.cda;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import br.com.raf.cda.controllers.MainActivity;

public class MenuPrincipal extends Activity {
	private Button bMapa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.entrada);

		bMapa = (Button) findViewById(R.id.bMapa);
		bMapa.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getBaseContext(), MapaActivity.class));
			}
		});

		bMapa = (Button) findViewById(R.id.bTest);
		bMapa.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getBaseContext(), MainActivity.class));
			}
		});
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
}
