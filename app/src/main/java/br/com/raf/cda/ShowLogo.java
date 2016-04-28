package br.com.raf.cda;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;

public class ShowLogo extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		setContentView(R.layout.splash);
		
		
		View v = findViewById(R.id.imglogo);
		ObjectAnimator animation = ObjectAnimator.ofFloat(v, "rotationY", 0.0f, 360f);
		//animation.setStartDelay(2000);
		animation.setStartDelay(1500);
		animation.setDuration(200);
		animation.setRepeatCount(5);
		animation.setInterpolator(new AccelerateDecelerateInterpolator());
		animation.start();
		
		// Thread do splash
		Thread splashLogo = new Thread() {
			public void run() {
				try {
					sleep(7000);
					startActivity(new Intent(getBaseContext(),
							br.com.raf.cda.MenuPrincipal.class));
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					finish();
				}
			}
		};
		splashLogo.start();
	}
}
