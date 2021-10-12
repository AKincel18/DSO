package com.example.adam.dso.activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.adam.dso.utils.Data;
import com.example.adam.dso.R;

import java.util.Vector;

public class AllQuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allquestion);
        Data data = new Data();

        String title = getIntent().getStringExtra("title");
        this.setTitle(title);

        Vector<Vector<String>> txt = data.getData(getIntent().getStringExtra("nameFile"),
                getApplicationContext());


        Vector<String> vec;
        setContentView(R.layout.activity_allquestion);
        LinearLayout linearLayout = findViewById(R.id.ll);


        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        llp.setMargins(30, 5, 30, 5);


        for (int i = 0; i < txt.size(); i++) {
            vec = txt.get(i);
            for (int j = 0; j < vec.size(); j++) {
                TextView textView = new TextView(this);
                textView.setLayoutParams(llp);
                String dod = "Question " + (i + 1) + "\n";
                if (j == 0 && i == 0) {
                    textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
                    String tmp = dod + (vec.get(j).substring(3));
                    textView.setText(tmp);

                } else {
                    if (j == 0) {
                        textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
                        String tmp = dod + (vec.get(j).substring(2));
                        textView.setText(tmp);
                    } else {
                        if (vec.get(j).charAt(0) == 'T') {
                            textView.setTextColor(Color.GREEN);

                        } else if (vec.get(j).charAt(0) == 'N') {
                            textView.setTextColor(Color.RED);
                        }
                        if (vec.size() - 1 == j) {
                            String tmp = (vec.get(j).substring(2)) + "\n";
                            textView.setText(tmp);
                        } else
                            textView.setText((vec.get(j).substring(2)));
                    }


                }

                linearLayout.addView(textView);
            }
        }


    }
}
