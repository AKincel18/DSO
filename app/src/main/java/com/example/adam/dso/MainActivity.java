package com.example.adam.dso;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String nameFileLinux = "", nameFileWindows = "";
    Context context;
    String text, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.name, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        final Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.name2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            //spinner LINUX
            case R.id.spinner:
                text = parent.getItemAtPosition(position).toString();
                switch (text) {
                    case "RAID":
                        nameFileLinux = "l3.txt";
                        break;
                    case "Usługi graficzne Xwindow":
                        nameFileLinux = "l1.txt";
                        break;
                    case "Linux ACL":
                        nameFileLinux = "l2.txt";
                        break;
                    case "LAMP":
                        nameFileLinux = "l4.txt";
                        break;
                    case "Linux Kernel":
                        nameFileLinux = "l6.txt";
                        break;
                    case "Wielosystemowość":
                        nameFileLinux = "l5.txt";
                        break;


                }
                break;

            //spinner2 WINDOWS
            case R.id.spinner2:
                text2 = parent.getItemAtPosition(position).toString();
                switch (text2) {
                    case "AD":
                        nameFileWindows = "w1.txt";
                        break;
                    case "GPO":
                        nameFileWindows = "w2.txt";
                        break;
                    case "Instalacja zdalna":
                        nameFileWindows = "w3.txt";
                        break;
                    case "RAID":
                        nameFileWindows = "w4.txt";
                        break;
                    case "PowerShell":
                        nameFileWindows = "w5.txt";
                        break;
                    case "API":
                        nameFileWindows = "w6.txt";
                        break;
                }
                break;

        }
        //QUIZ button LINUX
        Button b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                context = getApplicationContext();
                Intent intent = new Intent(context, Quiz.class);
                intent.putExtra("nameFile", nameFileLinux);
                intent.putExtra("title", "LINUX: " + text);
                startActivity(intent);
            }
        });

        //QUIZ button WINDOWS
        Button b2 = findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = getApplicationContext();
                Intent intent = new Intent(context, Quiz.class);
                intent.putExtra("nameFile", nameFileWindows);
                intent.putExtra("title", "WINDOWS: " + text2);
                startActivity(intent);
            }


        });

        //ALL button LINUX
        Button b3 = findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                context = getApplicationContext();
                Intent intent = new Intent(context, AllQuestions.class);
                intent.putExtra("nameFile", nameFileLinux);
                intent.putExtra("title", "LINUX: " + text);
                startActivity(intent);


            }
        });

        //ALL button WINDOWS
        Button b4 = findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                context = getApplicationContext();
                Intent intent = new Intent(context, AllQuestions.class);
                intent.putExtra("nameFile", nameFileWindows);
                intent.putExtra("title", "WINDOWS: " + text2);
                startActivity(intent);


            }
        });

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
