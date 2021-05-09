package com.hjhj.singletone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hjhj.singletone.model.BubbleWrap;

import java.util.Locale;

public class PopActivity extends AppCompatActivity {

    private BubbleWrap bubbleWrap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        bubbleWrap = BubbleWrap.getInstance();

        setupPopButton();
        updateUI();
    }

    private void setupPopButton() {
        Button btn = findViewById(R.id.btnPop);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                bubbleWrap.popBubble();
                Toast.makeText(PopActivity.this, "POP!!", Toast.LENGTH_SHORT).show();
                updateUI();
            }
        });
    }


    private void updateUI() {
        TextView tv = findViewById(R.id.tv_bubbleDisplay);
        String msg = String.format(
                Locale.getDefault(),
                "%d bubbles left!",
                bubbleWrap.getNumBubbles());
        tv.setText(msg);
    }
}