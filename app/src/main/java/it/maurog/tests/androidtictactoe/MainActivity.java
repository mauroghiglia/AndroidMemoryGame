package it.maurog.tests.androidtictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAbout = (Button) findViewById(R.id.btn_about);
        Button btnPlay = (Button) findViewById(R.id.btn_play);

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToAbout = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(goToAbout);
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToPlay = new Intent(getApplicationContext(), PlayActivity.class);
                startActivity(goToPlay);
            }
        });

    }
}
