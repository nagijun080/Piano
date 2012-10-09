package com.example.piano;

import java.util.Timer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.support.v4.app.NavUtils;

public class PianoActivity extends Activity implements OnTouchListener{

	
	public static final int numWk = 11, numBk = 7, numKeys = numWk + numBk;
	Region[] kb = new Region[numKeys];
	MediaPlayer[] key = new MediaPlayer[numKeys];
	int sw,sh;
	int[] activePointers = new int[numKeys];
	Drawable drawable_white,drawable_black,drawable_white_pressed,drawable_black_pressed;
	Timer timer;
	Bitmap bitmap_keyboard;
	ImageView iv;
	boolean[] lastPlayingNotes;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
	protected void onPause() {
		// TODO 自動生成されたメソッド・スタブ
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
	}

	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
	
	public void makeRegions() {
		int kw,kh,bkw,bkh;
		
		//画面サイズからキーの大きさを計算する
		kw = (int) (sw / numWk);
		kh = (int) (sh * 0.8);
		bkw = (int) (kw * 0.6);
		bkh = (int) (sh * 0.5);
		
		//キーの形に合わせたpathオブジェクトの作成
		Path[] path = new Path[4];
		path[0] = new Path();
		path[1] = new Path();
		path[2] = new Path();
		path[3] = new Path();
		
		//右に黒鍵のある白鍵
		path[0].lineTo(0, kh);
		path[0].lineTo(kw, kh);
		path[0].lineTo(kw, bkh);
		path[0].lineTo(kw - (bkw / 2), bkh);
		path[0].lineTo(kw - (bkw / 2), 0);
		path[0].close();
		
		//左右に黒鍵のある白鍵
		path[1].moveTo(bkw / 2, 0);
		path[1].lineTo(bkw / 2, bkh);
		path[1].lineTo(0, bkh);
		path[1].lineTo(0, kh);
		path[1].lineTo(kw, kh);
		path[1].lineTo(kw, bkh);
		path[1].lineTo(kw - (bkw /2), bkh);
		path[1].lineTo(kw - (bkw /2), 0);
		path[1].close();
		
		//左に黒鍵のある白鍵
		path[2].moveTo(bkw / 2, 0);
		path[2].moveTo(bkw / 2, bkh);
		path[2].moveTo(0, bkh);
		path[2].moveTo(0, kh);
		path[2].moveTo(kw, kh);
		path[2].moveTo(kw, 0);
		path[2].close();
		
		//黒鍵
		path[3].addRect(0, 0, bkw, bkh, Direction.CCW);
		
		//Pathオブジェクトの情報を使用してRegionオブジェクトを作成し、キーごとに割り当てる
		Region region = new Region (0, 0, sw, sh);
		int kt[] = new int[] {0,1,2,0,1,1,2,0,3,3,-1,3,3,3,-1,3,3};
		
		for (int i = 0;i < numWk;i++) {
			kb[i] = new Region();
			Path pathtmp = new Path();
			pathtmp.addPath(path[kt[i]], i * kw, 0);
			kb[i].setPath(pathtmp, region);
		}
		int j = numWk;
		for (int i = numWk;i < kt.length;i++) {
			if(kt[i] != -1) {
				kb[j] = new Region();
				Path pathtmp = new Path();
				pathtmp.addPath(path[kt[i]],(i - numWk + 1) * kw - (bkw / 2), 0);
				kb[j].setPath(pathtmp, region);
				j = j + 1;
			}
		}
	}
	
	public Bitmap drawKeys() {
		
		
		return null;
	}
  
}

