package com.example.deguzmanlabexcer3;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DisplayPg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        FileInputStream reader = null;
        String msg="";
        try{
            int token;
            StringBuffer buffer = new StringBuffer();
            reader = openFileInput("data1.txt");
            while((token=reader.read())!=-1){
                buffer.append((char)token);
                msg=msg+(char)token;
            }
            reader.close();
            String list[]=msg.split(" ");
            ((Button)(findViewById(R.id.b1))).setText(list[0]);
            ((Button)(findViewById(R.id.b2))).setText(list[1]);
            ((Button)(findViewById(R.id.b3))).setText(list[2]);
            ((Button)(findViewById(R.id.b4))).setText(list[3]);
            ((Button)(findViewById(R.id.b5))).setText(list[4]);
            ((Button)(findViewById(R.id.b6))).setText(list[5]);
            ((Button)(findViewById(R.id.b7))).setText(list[6]);
            ((Button)(findViewById(R.id.b8))).setText(list[7]);



        }catch (FileNotFoundException e){
            Log.d("error", "File not found error msg");
        }catch (IOException e){
            Log.d("error", "file not found");
        }

    }

    public void previous(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}
