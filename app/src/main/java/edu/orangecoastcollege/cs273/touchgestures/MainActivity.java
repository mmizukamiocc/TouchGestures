package edu.orangecoastcollege.cs273.touchgestures;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
        implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener {

    private ScrollView gesturesScrollView;

    private TextView gesturesLogTextView;
    private TextView singleTapTextView;
    private TextView doubleTapTextView;
    private TextView longPressTextView;
    private TextView scrollTextView;
    private TextView flingTextView;

    private int singleTaps = 0, doubleTaps = 0, longPresses = 0, scrolls = 0, flings = 0;

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gesturesScrollView = (ScrollView) findViewById(R.id.gesturesScrollView);
        gesturesLogTextView = (TextView) findViewById(R.id.gesturesLogTextView);

        singleTapTextView = (TextView) findViewById(R.id.singleTapTextView);
        doubleTapTextView = (TextView)findViewById(R.id.doubleTapTextView);
        longPressTextView = (TextView)findViewById(R.id.longPressTextView);
        scrollTextView = (TextView)findViewById(R.id.scrollTextView);
        flingTextView = (TextView)findViewById(R.id.flingTextView);


        gestureDetector = new GestureDetector(gesturesScrollView.getContext(),this);
        //
        gestureDetector.setOnDoubleTapListener(this);
    }

    //Any touch event is now dispatched from Activity to the ScrollView
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        super.dispatchTouchEvent(ev);
        return gestureDetector.onTouchEvent(ev);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent ev)
    {
        singleTaps++;
        singleTapTextView.setText(singleTaps);
        gesturesLogTextView.append("\nonSingleTapConfirmed touch event");
        return true;

    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        gesturesLogTextView.append("\nonDoubleTap touch event");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        doubleTaps++;
        doubleTapTextView.setText(doubleTaps);
        gesturesLogTextView.append("\nonDoubleTapEvent touch event");

        return true;
    }


    @Override
    public boolean onDown(MotionEvent motionEvent) {
        gesturesLogTextView.append("\nonDown touch event");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

        gesturesLogTextView.append("\nonShowPress touch event");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        gesturesLogTextView.append("\nonSingleTap touch event");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        scrolls++;
        scrollTextView.setText(scrolls);
        gesturesLogTextView.append("\nonScroll touch event");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
    longPresses++;
        longPressTextView.setText(longPresses);
        gesturesLogTextView.append("\nonLongPress touch event");
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        flings++;
        flingTextView.setText(flings);
        gesturesLogTextView.append("\nonFling touch event");
        return true;
    }

    public void clearAll(View view)
    {
        gesturesLogTextView.setText("");

        singleTaps = 0;
        doubleTaps = 0;
        longPresses = 0;
        scrolls = 0;
        flings = 0;
        singleTapTextView.setText(singleTaps);
        doubleTapTextView.setText(doubleTaps);
        longPressTextView.setText(longPresses);
        scrollTextView.setText(scrolls);
        flingTextView.setText(flings);

    }
}

