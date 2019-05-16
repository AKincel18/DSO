package com.example.adam.dso;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Vector;

public class AllQuestions extends AppCompatActivity {

    Data gD = new Data();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allquestion);



            String title = getIntent().getStringExtra("title");
            this.setTitle(title);


        Vector<Vector<String>> txt = gD.getData(getIntent().getStringExtra("nameFile"), getApplicationContext());


            String all="";
            Vector<String> vec = new Vector<String>();
            setContentView(R.layout.activity_allquestion);
            LinearLayout linearLayout = (LinearLayout)findViewById(R.id.ll);


            LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            llp.setMargins(30,5,30,5);


            for (int i=0;i<txt.size();i++){
                vec = txt.get(i);
                for (int j=0; j< vec.size();j++){
                    TextView textView = new TextView(this);
                    textView.setLayoutParams(llp);
                    String dod="PYTANIE " + (i+1)+"\n";
                            if (j==0 && i==0) {
                                textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
                                textView.setText(dod + (vec.get(j).substring(3, vec.get(j).length())));

                               // t.append((vec.get(j).substring(3, vec.get(j).length())) + "\n");

                            } else {
                                if (j==0){
                                    textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
                                    textView.setText(dod + (vec.get(j).substring(2, vec.get(j).length())));
                                } else {
                                    if (vec.get(j).charAt(0) == 'T') {
                                        textView.setTextColor(Color.GREEN);

                                    } else if (vec.get(j).charAt(0) == 'N') {
                                        textView.setTextColor(Color.RED);
                                    }
                                    if (vec.size()-1 == j)

                                        textView.setText((vec.get(j).substring(2, vec.get(j).length())) + "\n");
                                    else
                                        textView.setText((vec.get(j).substring(2, vec.get(j).length())));
                                }


                            }

                            linearLayout.addView(textView);
                }
            }



    }
}
