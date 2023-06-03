package edu.zhangmolei.zhangmolei.ui;

import android.app.Activity;
import android.os.Bundle;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.TextOptions;
import com.baidu.mapapi.model.LatLng;

import edu.zhangmolei.zhangmolei.R;

public class zhangMolei_Map extends Activity {

    private BaiduMap baiduMap;
    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhangmolei_map);

        mapView = (MapView) findViewById(R.id.bmapView);
        baiduMap = mapView.getMap();

        Double lng = 105.172915;
        Double lat = 37.497521;
        LatLng point = new LatLng(lat, lng);

        MapStatus mMapStatus = new MapStatus.Builder()
                .target(point)
                .zoom(11)
                .build();

        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);

        baiduMap.setMapStatus(mMapStatusUpdate);
        baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        //baiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);

        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.drawable.marker);

        OverlayOptions markerOptions = new MarkerOptions()
                .position(point)
                .icon(bitmap);

        OverlayOptions textOptions = new TextOptions()
                .text("标记点")
                .bgColor(0xAAFFFF00)
                .fontSize(24)
                .fontColor(0xFFFF00FF)
                .rotate(0)
                .position(point);

        baiduMap.addOverlay(markerOptions);
        baiduMap.addOverlay(textOptions);

    }

        @Override
        protected void onResume(){
            super.onResume();
            mapView.onResume();
        }

        @Override
        protected void onPause(){
            super.onPause();
            mapView.onPause();
        }

        @Override
        protected void onDestroy(){
            super.onDestroy();
            mapView.onDestroy();
        }

}
