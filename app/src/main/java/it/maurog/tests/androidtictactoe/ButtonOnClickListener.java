package it.maurog.tests.androidtictactoe;

import android.content.Context;
import android.content.Intent;
import android.sax.StartElementListener;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by mauro on 3/18/2017.
 */

public class ButtonOnClickListener implements View.OnClickListener {
    int value;
    int index;
    ImageButtonAdapter adapter;
    int foundPairs;
    int previousValue;
    boolean firstClick = true;
    int firstNumber;
    private Context context;

    //Constructor
    public ButtonOnClickListener(int value, int index, ImageButtonAdapter adapter) {
        this.value = value;
        this.index = index;
        this.adapter = adapter;
    }

    @Override
    public void onClick(View v) {
        ImageButton btn = (ImageButton) v;
        switch (value) {
            case 1:
                btn.setBackgroundResource(R.drawable.n_1);
                break;
            case 2:
                btn.setBackgroundResource(R.drawable.n_2);
                break;
            case 3:
                btn.setBackgroundResource(R.drawable.n_3);
                break;
            case 4:
                btn.setBackgroundResource(R.drawable.n_4);
                break;
            case 5:
                btn.setBackgroundResource(R.drawable.n_5);
                break;
            case 6:
                btn.setBackgroundResource(R.drawable.n_6);
                break;
            case 7:
                btn.setBackgroundResource(R.drawable.n_7);
                break;
            case 8:
                btn.setBackgroundResource(R.drawable.n_8);
                break;
            case 9:
                btn.setBackgroundResource(R.drawable.n_9);
                break;
            default:
                btn.setBackgroundResource(R.drawable.n_0);
        }
        adapter.checkHit(value);
    }
}
