package com.example.testtwo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    public static TextView lifecycle_text, status_text;
    private Button dialog, startB, startC, finishA;
    public static String list = "", status = "";
    private static final String TAG="QuizActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lifecycle_text = (TextView) findViewById(R.id.lifecycle_text_a);
        //增加滚轮
        lifecycle_text.setMovementMethod(ScrollingMovementMethod.getInstance());
        lifecycle_text.setScrollbarFadingEnabled(false);
        list += "Activity A.onCreate()\n";
        lifecycle_text.setText(list);

        status_text = (TextView) findViewById(R.id.status_text_a);
        status_text.setMovementMethod(ScrollingMovementMethod.getInstance());
        status_text.setScrollbarFadingEnabled(false);
        status_text.setText(status);

        dialog = (Button) findViewById(R.id.dialog);
        dialog.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                status_text.setText("Activity A:Paused");
                Intent i = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(i);
            }
        });

        // startB按钮
        startB = (Button) findViewById(R.id.StartB);
        startB.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                status_text.setText("");
                Intent i = new Intent(MainActivity.this, BActivity.class);
                startActivityForResult(i, 0);
            }
        });

        // finishA按钮
        finishA = (Button) findViewById(R.id.FinishA);
        finishA.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                MainActivity.this.finish();
            }
        });

        // startC按钮
        startC = (Button) findViewById(R.id.StartC);
        startC.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CActivity.class);
                startActivityForResult(i, 0);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        list += "Activity A.onStart()\n";
        lifecycle_text.setText(list);
        Log.d(TAG, "onStart: A");
    }

    @Override
    public void onPause() {
        super.onPause();
        list += "Activity A.onPause()\n";
        lifecycle_text.setText(list);
        Log.d(TAG, "onPause: A");
    }

    @Override
    public void onResume() {
        super.onResume();
        list += "Activity A.onResume()\n";
        lifecycle_text.setText(list);
        status = "Activity A:Resumed\n";
        status_text.setText(status);
        Log.d(TAG, "onResume: A");
    }

    @Override
    public void onStop() {
        super.onStop();
        list += "Activity A.onStop()\n";
        lifecycle_text.setText(list);
        Log.d(TAG, "onStop: A");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        list += "Activity A.onDestroy()\n";
        lifecycle_text.setText(list);
        Log.d(TAG, "onDestroy: A");
    }


}
