package fr.preslavtenev.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CookieActivity extends AppCompatActivity {

    private TextView points;
    private ImageView boss;
    private int clicks = 0;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookie);

        this.points = findViewById(R.id.points);
        this.boss = findViewById(R.id.boss);
        this.mp = MediaPlayer.create(getApplicationContext(), R.raw.jump);

        boss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(v);
                clicks++;
                points.setText("Points : " + clicks);
                if(clicks==100){
                    Intent otherActivity = new Intent(getApplicationContext(), Victoire.class);
                    startActivity(otherActivity);
                    finish();
                }
            }
        });
    }

    public void playSound(View view) {
        mp.start();
    }
}
