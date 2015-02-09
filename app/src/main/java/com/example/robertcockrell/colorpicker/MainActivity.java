package com.example.robertcockrell.colorpicker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener {
SeekBar alphaSeek;
SeekBar redSeek;
SeekBar greenSeek;
SeekBar blueSeek;
FrameLayout colorshower;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alphaSeek = (SeekBar) findViewById(R.id.alpha);
        redSeek = (SeekBar) findViewById(R.id.red);
        greenSeek = (SeekBar) findViewById(R.id.green);
        blueSeek = (SeekBar) findViewById(R.id.blue);

        alphaSeek.setOnSeekBarChangeListener(changeColor);
        redSeek.setOnSeekBarChangeListener(changeColor);
        greenSeek.setOnSeekBarChangeListener(changeColor);
        blueSeek.setOnSeekBarChangeListener(changeColor);

        Spinner colorspinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.color_choices,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorspinner.setAdapter(adapter);
        colorspinner.setOnItemSelectedListener(this);

        colorshower = (FrameLayout) findViewById(R.id.colorSquare);
    }


    SeekBar.OnSeekBarChangeListener changeColor = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            int color = 0x1000000*alphaSeek.getProgress() + 0x10000*redSeek.getProgress() + 0x100*greenSeek.getProgress() + blueSeek.getProgress();
            colorshower.setBackgroundColor(color);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long id){
        String str = (String) parent.getItemAtPosition(pos);
        if(str.equalsIgnoreCase("Lavender")){
            alphaSeek.setProgress(255);
            redSeek.setProgress(171);
            greenSeek.setProgress(130);
            blueSeek.setProgress(255);
        }else if(str.equalsIgnoreCase("Kerbal")){
            alphaSeek.setProgress(255);
            redSeek.setProgress(186);
            greenSeek.setProgress(218);
            blueSeek.setProgress(85);
        }else if(str.equalsIgnoreCase("Sad Brown")){
            alphaSeek.setProgress(255);
            redSeek.setProgress(184);
            greenSeek.setProgress(134);
            blueSeek.setProgress(11);
        }else if(str.equalsIgnoreCase("Orange")){
            alphaSeek.setProgress(255);
            redSeek.setProgress(255);
            greenSeek.setProgress(165);
            blueSeek.setProgress(0);
        }else if(str.equalsIgnoreCase("Greek Blue")){
            alphaSeek.setProgress(255);
            redSeek.setProgress(24);
            greenSeek.setProgress(116);
            blueSeek.setProgress(205);
        }else if(str.equalsIgnoreCase("Earl Grey")){
            alphaSeek.setProgress(255);
            redSeek.setProgress(159);
            greenSeek.setProgress(182);
            blueSeek.setProgress(205);
        }else{
            //do nothing!!
            alphaSeek.setProgress(255);
            redSeek.setProgress(255);
            greenSeek.setProgress(255);
            blueSeek.setProgress(255);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

