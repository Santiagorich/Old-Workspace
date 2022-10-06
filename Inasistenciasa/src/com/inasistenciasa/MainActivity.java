package com.inasistenciasa;


import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.*;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;



public class MainActivity extends Activity {

	private LinearLayout linear1;
	private TextView textview1;
	private Button button1;
	private Button button2;
	private WebView webview2;

	private java.lang.String url = "";




	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		textview1 = (TextView) findViewById(R.id.textview1);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		webview2 = (WebView) findViewById(R.id.webview2);
		webview2.getSettings().setJavaScriptEnabled(true);
		webview2.getSettings().setSupportZoom(true);
		webview2.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _view,final String _url, Bitmap _favicon) {

				super.onPageStarted(_view, _url, _favicon);
			}
			@Override
			public void onPageFinished(WebView _view,final String _url) {

				super.onPageFinished(_view, _url);
			}
		});


		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				url = "www.google.com";
				webview2.loadUrl("http://www.google.com/");
			}
		});
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 

			}
		});

	}

	private void  initializeLogic() {

	}




	// created automatically
	private void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}

	private int getRandom(int _minValue ,int _maxValue){
		Random random = new Random();
		return random.nextInt(_maxValue - _minValue + 1) + _minValue;
	}

	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
				_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}

}
