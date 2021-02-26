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

public class CActivity extends Activity {

    private Button finishC, dialog, startA, startB;
    private static final String TAG="QuizActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        MainActivity.lifecycle_text = (TextView) findViewById(R.id.lifecycle_text_c);
        MainActivity.lifecycle_text.setMovementMethod(ScrollingMovementMethod.getInstance());
        MainActivity.lifecycle_text.setScrollbarFadingEnabled(false);
        //lifecycle.append("Activity C.onCreate()\n");
        MainActivity.list += "Activity C.onCreate()\n";
        MainActivity.lifecycle_text.setText(MainActivity.list);

        MainActivity.status_text = (TextView) findViewById(R.id.status_text_c);
        MainActivity.status_text.setMovementMethod(ScrollingMovementMethod.getInstance());
        MainActivity.status_text.setScrollbarFadingEnabled(false);
        MainActivity.status = "Activity A:Stopped\nActivity C:Resumed\n";
        MainActivity.status_text.setText(MainActivity.status);

        finishC = (Button) findViewById(R.id.FinishC);
        finishC.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                CActivity.this.finish();
            }
        });

        startA = (Button) findViewById(R.id.StartA);
        startA.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(CActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        startB = (Button) findViewById(R.id.StartB);
        startB.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(CActivity.this, BActivity.class);
                startActivity(i);
            }
        });

        dialog = (Button) findViewById(R.id.dialog);
        dialog.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                MainActivity.status_text.setText("Activity C:Paused");
                Intent i = new Intent(CActivity.this, DialogActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        //lifecycle.append("Activity C.onStart()\n");
        MainActivity.list += "Activity C.onStart()\n";
        MainActivity.lifecycle_text.setText(MainActivity.list);
        Log.d(TAG, "onStart: C");
    }

    @Override
    public void onPause() {
        super.onPause();
        //lifecycle.append("Activity C.onPause()\n");
        MainActivity.list += "Activity C.onPause()\n";
        MainActivity.lifecycle_text.setText(MainActivity.list);
        Log.d(TAG, "onPause: C");
    }

    @Override
    public void onResume() {
        super.onResume();
        //lifecycle.append("Activity C.onResume()\n");
        MainActivity.list += "Activity C.onResume()\n";
        MainActivity.lifecycle_text.setText(MainActivity.list);
        Log.d(TAG, "onResume: C");
    }

    @Override
    public void onStop() {
        super.onStop();
        //lifecycle.append("Activity C.onStop()\n");
        MainActivity.list += "Activity C.onStop()\n";
        MainActivity.lifecycle_text.setText(MainActivity.list);
        Log.d(TAG, "onStop: C");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //lifecycle.append("Activity C.onDestroy()\n");
        MainActivity.list += "Activity C.onDestroy()\n";
        MainActivity.lifecycle_text.setText(MainActivity.list);
        Log.d(TAG, "onDestroy: C");
    }


}
