package com.example.scientia;

import android.app.Activity;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Contact extends Activity implements OnClickListener
{
	LocationManager lm ;
	Animation myAnimation,myAnimation2;
	double lat= 28.6993231;
	double lon=77.1109416;
	ImageView iv1,iv2,iv3;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact);
		iv1=(ImageView)findViewById(R.id.imageView1);
		iv2=(ImageView)findViewById(R.id.imageView2);
		iv3=(ImageView)findViewById(R.id.imageView3);
		
		iv1.setOnClickListener(this);
		iv2.setOnClickListener(this);
		iv3.setOnClickListener(this);
	
		myAnimation = AnimationUtils.loadAnimation(Contact.this, R.anim.fade_in);
		myAnimation2 = AnimationUtils.loadAnimation(Contact.this, R.anim.flip);

	
	}
	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		if(v==iv1)
		{
			Intent i6=new Intent(Intent.ACTION_CALL);
			i6.setData(Uri.parse("tel: +918800455439"));
			startActivity(i6);
			
		}
		if(v==iv2)
		{
			Intent i2 = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
			i2.setType("text/plain");
			i2.setData(Uri.parse("mailto:"));
			i2.putExtra(Intent.EXTRA_CC, "udgeeth96@gmail.com");
			i2.putExtra(Intent.EXTRA_SUBJECT, "udgeeth96@gmail.com");
			i2.putExtra(Intent.EXTRA_TEXT, "ENTER TEXT HERE");

			startActivity(i2);
		}
		
		if(v==iv3)
		{
			String label="MY LOCATION";
			String mloc="geo:"+lat+","+lon;
			String mloc1=lat+","+lon+"("+label+")";
			String mloc2=Uri.encode(mloc1);
			String x= mloc+"?q="+mloc2+"&z=16";
			Uri muri=Uri.parse(x);
				
			Intent i=new Intent(android.content.Intent.ACTION_VIEW,muri);
			startActivity(i);
		}
	}

}
