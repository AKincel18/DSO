package com.example.adam.dso.activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.adam.dso.utils.Data;
import com.example.adam.dso.R;

import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;


public class QuizActivity extends AppCompatActivity {

    Vector<Vector<String>> txt = new Vector<>();
    int questionNumber = 0;
    int[] inOrder = {0, 0, 0, 0};
    Data data = new Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        checkButtonListener();
        nextButtonListener();
        String title = getIntent().getStringExtra("title");
        this.setTitle(title);
        txt = data.getData(getIntent().getStringExtra("nameFile"), getApplicationContext());
        setQuestionAndAnswers();
    }

    private void nextButtonListener() {
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(view -> setQuestionAndAnswers());
    }

    private void checkButtonListener() {
        Button checkButton = findViewById(R.id.checkButton);
        checkButton.setOnClickListener(view -> {
            CheckBox checkBox1 = findViewById(R.id.checkbox1);
            CheckBox checkBox2 = findViewById(R.id.checkbox2);
            CheckBox checkBox3 = findViewById(R.id.checkbox3);
            CheckBox checkBox4 = findViewById(R.id.checkbox4);

            Vector<String> tmp1 = txt.get(questionNumber);
            String cutString;
            if (tmp1.get(inOrder[0]).charAt(0) == 'T') {
                cutString = tmp1.get(inOrder[0]).substring(2);
                checkBox1.setText(cutString);
                checkBox1.setTextColor(Color.GREEN);
            } else {
                cutString = tmp1.get(inOrder[0]).substring(2);
                checkBox1.setText(cutString);
                checkBox1.setTextColor(Color.RED);
            }


            if (tmp1.get(inOrder[1]).charAt(0) == 'T') {
                cutString = tmp1.get(inOrder[1]).substring(2);
                checkBox2.setText(cutString);
                checkBox2.setTextColor(Color.GREEN);
            } else {
                cutString = tmp1.get(inOrder[1]).substring(2);
                checkBox2.setText(cutString);
                checkBox2.setTextColor(Color.RED);
            }

            if (tmp1.get(inOrder[2]).charAt(0) == 'T') {
                cutString = tmp1.get(inOrder[2]).substring(2);
                checkBox3.setText(cutString);
                checkBox3.setTextColor(Color.GREEN);
            } else {
                cutString = tmp1.get(inOrder[2]).substring(2);
                checkBox3.setText(cutString);
                checkBox3.setTextColor(Color.RED);
            }

            if (tmp1.get(inOrder[3]).charAt(0) == 'T') {
                cutString = tmp1.get(inOrder[3]).substring(2);
                checkBox4.setText(cutString);
                checkBox4.setTextColor(Color.GREEN);
            } else {
                cutString = tmp1.get(inOrder[3]).substring(2);
                checkBox4.setText(cutString);
                checkBox4.setTextColor(Color.RED);
            }


        });

    }

    private void randomQuestion() {

        int numberOfAnswer;
        Vector<Integer> temp = new Vector<>();

        for (int i = 0; i < 4; i++) {
            temp.add(i + 1);
        }

        for (int i = 0; i < 4; i++) {
            numberOfAnswer = ThreadLocalRandom.current().nextInt(1, temp.size() + 1);
            inOrder[i] = temp.get(numberOfAnswer - 1);
            temp.remove(numberOfAnswer - 1);
        }
    }

    private void setQuestionAndAnswers() {
        questionNumber = ThreadLocalRandom.current().nextInt(0, txt.size());

        Vector<String> tmp1;
        tmp1 = txt.get(questionNumber);
        TextView questionTextView = findViewById(R.id.questionTextView);
        //question
        if (questionNumber == 0)
            questionTextView.setText(tmp1.get(0).substring(3));
        else
            questionTextView.setText(tmp1.get(0).substring(2));

        //answer
        randomQuestion();

        CheckBox checkBox1 = findViewById(R.id.checkbox1);
        CheckBox checkBox2 = findViewById(R.id.checkbox2);
        CheckBox checkBox3 = findViewById(R.id.checkbox3);
        CheckBox checkBox4 = findViewById(R.id.checkbox4);


        checkBox1.setChecked(false);
        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
        checkBox4.setChecked(false);

        String cutString = tmp1.get(inOrder[0]).substring(2);
        checkBox1.setText(cutString);
        checkBox1.setTextColor(Color.BLACK);

        cutString = tmp1.get(inOrder[1]).substring(2);
        checkBox2.setText(cutString);
        checkBox2.setTextColor(Color.BLACK);

        cutString = tmp1.get(inOrder[2]).substring(2);
        checkBox3.setText(cutString);
        checkBox3.setTextColor(Color.BLACK);

        cutString = tmp1.get(inOrder[3]).substring(2);
        checkBox4.setText(cutString);
        checkBox4.setTextColor(Color.BLACK);

    }

}
