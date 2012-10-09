package com.example.piano;

import java.util.Timer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Path;
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
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.onResume();
	}

	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return false;
	}
	
	public void makeRegions() {
		int kw,kh,bkw,bkh;
		
		//��ʃT�C�Y����L�[�̑傫�����v�Z����
		kw = (int) (sw / numWk);
		kh = (int) (sh * 0.8);
		bkw = (int) (kw * 0.6);
		bkh = (int) (sh * 0.5);
		
		//�L�[�̌`�ɍ��킹��path�I�u�W�F�N�g�̍쐬
		Path[] path = new Path[4];
		path[0] = new Path();
		path[1] = new Path();
		path[2] = new Path();
		path[3] = new Path();
		
		//�E�ɍ����̂��锒��
		path[0].lineTo(0, kh);
		path[0].lineTo(kw, kh);
		path[0].lineTo(kw, bkh);
		path[0].lineTo(kw - (bkw / 2), bkh);
		path[0].lineTo(kw - (bkw / 2), 0);
		path[0].close();
		
		//���E�ɍ����̂��锒��
		path[1].moveTo(bkw / 2, 0);
		path[1].lineTo(bkw / 2, bkh);
		path[1].lineTo(0, bkh);
		path[1].lineTo(0, kh);
		path[1].lineTo(kw, kh);
		path[1].lineTo(kw, bkh);
		
	}

  
}
