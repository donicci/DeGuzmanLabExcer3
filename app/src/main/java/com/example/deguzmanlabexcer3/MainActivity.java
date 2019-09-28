package com.example.deguzmanlabexcer3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText sv_01, sv_02, sv_03, sv_04, sv_05, sv_06, sv_07, sv_08;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sv_01 = findViewById(R.id.sv1);
        sv_02 = findViewById(R.id.sv2);
        sv_03 = findViewById(R.id.sv3);
        sv_04 = findViewById(R.id.sv4);
        sv_05 = findViewById(R.id.sv5);
        sv_06 = findViewById(R.id.sv6);
        sv_07 = findViewById(R.id.sv7);
        sv_08 = findViewById(R.id.sv8);

    }
    public void writeData (View v){
        String data1 = sv_01.getText().toString()+ " ";
        String data2 = sv_02.getText().toString()+ " ";
        String data3 = sv_03.getText().toString()+ " ";
        String data4 = sv_04.getText().toString()+ " ";
        String data5 = sv_05.getText().toString()+ " ";
        String data6 = sv_06.getText().toString()+ " ";
        String data7 = sv_07.getText().toString()+ " ";
        String data8 = sv_08.getText().toString()+ " ";


        FileOutputStream writer = null;
        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);

            writer.write(data1.getBytes());                                                       //writes io exception
            writer.write(data2.getBytes());
            writer.write(data3.getBytes());
            writer.write(data4.getBytes());
            writer.write(data5.getBytes());
            writer.write(data6.getBytes());
            writer.write(data7.getBytes());
            writer.write(data8.getBytes());

        } catch (FileNotFoundException e) {
            Log.d("error", "file not found.");
        } catch (IOException e) {
            Log.d("error", "IO Error.");
        } finally {
            try {
                writer.close();

            } catch (IOException e) {
                Log.d("error", "File not found");
            }
        }
        Toast.makeText(this, "data saved in internal storage..", Toast.LENGTH_LONG).show();
    }





    public void verify(View v) {
        startActivity(new Intent(MainActivity.this, DisplayPg.class));
    }

}
