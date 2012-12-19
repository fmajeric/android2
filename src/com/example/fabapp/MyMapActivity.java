package com.example.fabapp;

import android.os.Bundle;
import android.view.KeyEvent;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class MyMapActivity extends MapActivity {

	private MapView mapView;
	private MapController mc;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_layout);
		mapView = (MapView) this.findViewById(R.id.map_view);
		mapView.setBuiltInZoomControls(true);
		mc = mapView.getController();
		mc.setZoom(21);
		Double lat = 43.2899584*1E6 ;
		Double lon=5.3883510*1E6 ;
		GeoPoint point = new GeoPoint(lat.intValue(), lon.intValue()) ;
		mc.setCenter(point);
		mc.animateTo(point);
	}
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
			mapView.setSatellite(true);
			return true;
		} else if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
			mapView.setSatellite(false);
			return true;
		} 
		return super.onKeyDown(keyCode, event);
	}
	
	
}
