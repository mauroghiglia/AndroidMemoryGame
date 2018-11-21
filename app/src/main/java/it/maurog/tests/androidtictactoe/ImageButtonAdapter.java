package it.maurog.tests.androidtictactoe;

/**
 * Created by mauro on 8/18/2016.
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//We use an adapter to display the game on the screen
public class ImageButtonAdapter extends BaseAdapter {

    public Context c;
    ImageButton[] buttons;
    private ArrayList<Integer> doubleButtonValues = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9));
    private boolean[] available = {true,true,true,true,true,true,true,true,true};
    public int previousValue = 0;
    public int previousIndex = 0;
    public boolean firstHit = true;

    //Constructor
    public ImageButtonAdapter(Context c) {
        this.c = c;
        //Sets the number of buttons
        buttons = new ImageButton[9];

        StartGame();
    }

    boolean CheckGameStatus(int value){

        String winningMessage = (c.getString(R.string.wins));
        boolean GameOver = false;


        if(GameOver){
            AlertDialog.Builder builder = new AlertDialog.Builder(c);
            builder.setMessage(winningMessage + "\nPlay Again?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //available.clear();
                            StartGame();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Activity a = (Activity)c;
                            a.setContentView(R.layout.activity_main);
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        if(GameOver) return false; else return true;
    }

    public void StartGame(){
        Collections.shuffle(doubleButtonValues);
        ArrayList<Integer> buttonValueSet = new ArrayList<>(doubleButtonValues.subList(0,9)) ;
        int pairs = checkPairs(buttonValueSet);

        for(int i=0;i<buttons.length;i++){
            if(buttons[i]==null) buttons[i] = new ImageButton(c);
            buttons[i].setOnClickListener(new ButtonOnClickListener(buttonValueSet.get(i), i, this));
        }

        closeAllAvailableButtons();
    }

    public boolean checkHit(int index, int value) {
        //Check if first or second strike
        if(firstHit == true){
            firstHit = false;
            Toast.makeText(c, "First hit!", Toast.LENGTH_SHORT).show();
            closeAllAvailableButtons();
        } else {
            Toast.makeText(c, "Second hit!", Toast.LENGTH_SHORT).show();

        }
        return true;
    }

    public void closeAllAvailableButtons(){
        for(int i=0;i<buttons.length;i++){
            if(available[i]){
                buttons[i].setBackgroundResource(R.drawable.xo4848);
                //Set button dimensions
                buttons[i].setLayoutParams(new GridView.LayoutParams(320, 320));
                buttons[i].setTag(0);
            }
        }
    }
    public int getCount() {
        return buttons.length;
    }
    public int checkPairs(ArrayList ar) {
        int doubleCount = 0;
        for (int i1 = 0; i1 < 9; i1++) {
            int doubleFirstCheck = 0;
            for (int i2 = 0; i2 < 9; i2++) {
                if (ar.get(i1) == ar.get(i2)) {
                    doubleFirstCheck++;
                }
                if (doubleFirstCheck == 2) {
                    doubleCount++;
                    doubleFirstCheck = 0;
                }
            }
        }
        doubleCount = doubleCount/2;
        return doubleCount;
    }
    public Object getItem(int arg0) {
        return buttons[arg0];
    }

    public long getItemId(int arg0) {
        return 0;
    }
    public View getView(int arg0, View arg1, ViewGroup arg2) {
        return buttons[arg0];
    }

    protected void onNewIntent(Intent intent){
        Toast.makeText(c, "Buh!", Toast.LENGTH_SHORT).show();
    }
    public void checkHit(int value){
        if(firstHit == true){
            previousValue = value;
            firstHit = false;
        } else if(value == previousValue){
            Toast.makeText(c, "You hit a pair!", Toast.LENGTH_SHORT).show();
            closeAllAvailableButtons();
        } else  {
            Toast.makeText(c, "This is not a pair!", Toast.LENGTH_SHORT).show();
            closeAllAvailableButtons();
        }
    }

}
