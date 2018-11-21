package it.maurog.tests.androidtictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class PlayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Button btnPlay = (Button) findViewById(R.id.btn_play);
        Button btnBackToMain = (Button) findViewById(R.id.btn_backtomain);

        btnBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(backToMain);
            }
        });
    }

}
