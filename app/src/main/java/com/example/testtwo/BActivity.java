package com.example.testtwo;

import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class BActivity extends Activity {

    private Button finishB, dialog, startA, startC;
    private static final String TAG="QuizActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        MainActivity.lifecycle_text = (TextView) findViewById(R.id.lifecycle_text_b);
        MainActivity.lifecycle_text.setMovementMethod(ScrollingMovementMethod.getInstance());
        MainActivity.lifecycle_text.setScrollbarFadingEnabled(false);
        MainActivity.list += "Activity B.onCreate()\n";
        MainActivity.lifecycle_text.setText(MainActivity.list);

        MainActivity.status_text = (TextView) findViewById(R.id.status_text_b);
        MainActivity.status_text.setMovementMethod(ScrollingMovementMethod.getInstance());
        MainActivity.status_text.setScrollbarFadingEnabled(false);
        MainActivity.status += "Activity A:Stopped\nActivity B:Resumed\n";
        MainActivity.status_text.setText(MainActivity.status);

        finishB = (Button) findViewById(R.id.FinishB);
        finishB.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                BActivity.this.finish();
            }
        });

        startA = (Button) findViewById(R.id.StartA);
        startA.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(BActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        startC = (Button) findViewById(R.id.StartC);
        startC.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(BActivity.this, CActivity.class);
                startActivity(i);
            }
        });

        dialog = (Button) findViewById(R.id.dialog);
        dialog.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                MainActivity.status_text.setText("Activity B:Paused");
                Intent i = new Intent(BActivity.this, DialogActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        MainActivity.list += "Activity B.onStart()\n";
        MainActivity.lifecycle_text.setText(MainActivity.list);
        Log.d(TAG, "onStart: B");

    }

    @Override
    public void onPause() {
        super.onPause();
        MainActivity.list += "Activity B.onPause()\n";
        MainActivity.lifecycle_text.setText(MainActivity.list);
        Log.d(TAG, "onPause: B");

    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity.list += "Activity B.onResume()\n";
        MainActivity.lifecycle_text.setText(MainActivity.list);
        Log.d(TAG, "onResume: B");

    }

    @Override
    public void onStop() {
        super.onStop();
        MainActivity.list += "Activity B.onStop()\n";
        MainActivity.lifecycle_text.setText(MainActivity.list);
        Log.d(TAG, "onStop: B");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MainActivity.list += "Activity B.onDestroy()\n";
        MainActivity.lifecycle_text.setText(MainActivity.list);
        Log.d(TAG, "onDestroy: B");

    }


}
