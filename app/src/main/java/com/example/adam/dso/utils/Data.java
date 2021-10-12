package com.example.adam.dso.utils;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class Data {

    public Vector<Vector<String>> getData(String fileName, Context Context) {
        Vector<Vector<String>> txt = new Vector<>();
        try {
            BufferedReader reader;
            reader = new BufferedReader(new InputStreamReader(Context.getAssets().open(fileName)));
            Vector<String> temp = new Vector<>();
            String mLine;
            StringBuilder question;
            StringBuilder answer;
            boolean endFile = false;
            int couter = 0;
            mLine = reader.readLine();

            while (!endFile) {
                couter++;

                if (mLine.charAt(1) == 'P' || mLine.charAt(0) == 'P') {
                    question = new StringBuilder(mLine);
                    mLine = reader.readLine();

                    while ((mLine.charAt(0) == ' ')) {
                        question.append(mLine);
                        mLine = reader.readLine();
                    }
                    temp.add(question.toString());
                }

                if (mLine.charAt(0) == 'T' || mLine.charAt(0) == 'N') {

                    answer = new StringBuilder(mLine);
                    if ((mLine = reader.readLine()) == null) {
                        endFile = true;
                        temp.add(answer.toString());
                        txt.add(temp);


                    } else {
                        while (!endFile && (mLine.charAt(0) == ' ')) {
                            answer.append(mLine);
                            if ((mLine = reader.readLine()) == null) {
                                endFile = true;

                            }
                        }
                        temp.add(answer.toString());
                        if (couter == 4) {
                            txt.add(temp);
                            couter = 0;
                            temp = new Vector<>();
                        }
                    }
                }

            }

        } catch (IOException ex) {
            Toast.makeText(Context, ex.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
        return txt;

    }


}
