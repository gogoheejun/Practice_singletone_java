package com.hjhj.singletone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hjhj.singletone.model.BubbleWrap;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private BubbleWrap bubbleWrap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bubbleWrap = BubbleWrap.getInstance();
        
        setupAddMoreButton();
        setupPopActivityButton();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }

    private void setupAddMoreButton() {
        Button btn = findViewById(R.id.btn_addMoreButton);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                bubbleWrap.addMoreBubbles();
                updateUI();
            }
        });
    }

    private void setupPopActivityButton() {
        Button btn = findViewById(R.id.btn_startPopping);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PopActivity.class);
                startActivity(intent);
            }
        });
    }

    private void updateUI() {
        TextView tv = findViewById(R.id.tv);
        String msg = String.format(
                Locale.getDefault(),
                "%d bubbles left!",
                bubbleWrap.getNumBubbles());
        tv.setText(msg);
    }
}