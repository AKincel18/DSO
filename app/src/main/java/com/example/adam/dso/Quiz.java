package com.example.adam.dso;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;


public class Quiz extends AppCompatActivity {
    //Fields
    Vector<Vector<String>> txt = new Vector<Vector<String>>();
    int numberOfQuestion = 0;
    int[] inOrder = {0, 0, 0, 0};
    Data gD = new Data();

    //Methods
    private void randomQuestion() {

        int numberOfAnswer;
        Vector<Integer> temp = new Vector<Integer>();

        for (int i = 0; i < 4; i++) {
            temp.add(i + 1);
        }

        for (int i = 0; i < 4; i++) {
            numberOfAnswer = ThreadLocalRandom.current().nextInt(1, temp.size() + 1);
            inOrder[i] = temp.get(numberOfAnswer - 1);
            temp.remove(numberOfAnswer - 1);
        }
    }

    private void writeQandA() {
        numberOfQuestion = ThreadLocalRandom.current().nextInt(0, txt.size());

        Vector<String> tmp1 = new Vector<String>();
        tmp1 = txt.get(numberOfQuestion);
        TextView t = (TextView) findViewById(R.id.textView3);
        //question
        if (numberOfQuestion == 0)
            t.setText(tmp1.get(0).substring(3, tmp1.get(0).length()));
        else
            t.setText(tmp1.get(0).substring(2, tmp1.get(0).length()));

        //answer
        randomQuestion();

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkbox3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkbox4);


        checkBox1.setChecked(false);
        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
        checkBox4.setChecked(false);

        String cutString = tmp1.get(inOrder[0]).substring(2, tmp1.get(inOrder[0]).length());
        checkBox1.setText(cutString);
        checkBox1.setTextColor(Color.BLACK);

        cutString = tmp1.get(inOrder[1]).substring(2, tmp1.get(inOrder[1]).length());
        checkBox2.setText(cutString);
        checkBox2.setTextColor(Color.BLACK);

        cutString = tmp1.get(inOrder[2]).substring(2, tmp1.get(inOrder[2]).length());
        checkBox3.setText(cutString);
        checkBox3.setTextColor(Color.BLACK);

        cutString = tmp1.get(inOrder[3]).substring(2, tmp1.get(inOrder[3]).length());
        checkBox4.setText(cutString);
        checkBox4.setTextColor(Color.BLACK);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        Button b = (Button) findViewById(R.id.button7);
        //------------------------------------------------------------------------------------------
        //CHECK BUTTON
        //------------------------------------------------------------------------------------------
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
                CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
                CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkbox3);
                CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkbox4);

                Vector<String> tmp1 = new Vector<String>();
                tmp1 = txt.get(numberOfQuestion);
                String cutString;
                if (tmp1.get(inOrder[0]).charAt(0) == 'T') {
                    cutString = tmp1.get(inOrder[0]).substring(2, tmp1.get(inOrder[0]).length());
                    checkBox1.setText(cutString);
                    checkBox1.setTextColor(Color.GREEN);
                } else {
                    cutString = tmp1.get(inOrder[0]).substring(2, tmp1.get(inOrder[0]).length());
                    checkBox1.setText(cutString);
                    checkBox1.setTextColor(Color.RED);
                }


                if (tmp1.get(inOrder[1]).charAt(0) == 'T') {
                    cutString = tmp1.get(inOrder[1]).substring(2, tmp1.get(inOrder[1]).length());
                    checkBox2.setText(cutString);
                    checkBox2.setTextColor(Color.GREEN);
                } else {
                    cutString = tmp1.get(inOrder[1]).substring(2, tmp1.get(inOrder[1]).length());
                    checkBox2.setText(cutString);
                    checkBox2.setTextColor(Color.RED);
                }

                if (tmp1.get(inOrder[2]).charAt(0) == 'T') {
                    cutString = tmp1.get(inOrder[2]).substring(2, tmp1.get(inOrder[2]).length());
                    checkBox3.setText(cutString);
                    checkBox3.setTextColor(Color.GREEN);
                } else {
                    cutString = tmp1.get(inOrder[2]).substring(2, tmp1.get(inOrder[2]).length());
                    checkBox3.setText(cutString);
                    checkBox3.setTextColor(Color.RED);
                }

                if (tmp1.get(inOrder[3]).charAt(0) == 'T') {
                    cutString = tmp1.get(inOrder[3]).substring(2, tmp1.get(inOrder[3]).length());
                    checkBox4.setText(cutString);
                    checkBox4.setTextColor(Color.GREEN);
                } else {
                    cutString = tmp1.get(inOrder[3]).substring(2, tmp1.get(inOrder[3]).length());
                    checkBox4.setText(cutString);
                    checkBox4.setTextColor(Color.RED);
                }


            }
        });

        //------------------------------------------------------------------------------------------
        //NEXT BUTTON
        //------------------------------------------------------------------------------------------
        Button b1 = (Button) findViewById(R.id.button8);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeQandA();
            }
        });

        //------------------------------------------------------------------------------------------
        //GET DATA FROM TEXT FILE'S
        //------------------------------------------------------------------------------------------

        String title = getIntent().getStringExtra("title");
        this.setTitle(title);
        txt = gD.getData(getIntent().getStringExtra("nameFile"), getApplicationContext());
        writeQandA();


    }
}
