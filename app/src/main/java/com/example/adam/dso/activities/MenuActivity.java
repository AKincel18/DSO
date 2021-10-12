package com.example.adam.dso.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.adam.dso.model.Package;
import com.example.adam.dso.R;
import com.example.adam.dso.model.Type;
import com.example.adam.dso.utils.Utils;

import java.util.List;
import java.util.stream.Collectors;

public class MenuActivity extends AppCompatActivity {

    private Context context;
    private List<Package> packages;
    private Spinner linuxSpinner, windowsSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        context = getApplicationContext();
        packages = Utils.buildPackages();

        initSpinners();
        initButtons();
    }

    private void initSpinners() {
        linuxSpinner = findViewById(R.id.linuxSpinner);
        ArrayAdapter<String> linuxAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getThemes(Type.Linux));
        linuxAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        linuxSpinner.setAdapter(linuxAdapter);

        windowsSpinner = findViewById(R.id.windowsSpinner);
        ArrayAdapter<String> windowsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getThemes(Type.Windows));
        windowsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        windowsSpinner.setAdapter(windowsAdapter);
    }

    private void initButtons() {
        //QUIZ button LINUX
        Button quizLinuxButton = findViewById(R.id.quizLinuxButton);
        quizLinuxButton.setOnClickListener(view -> {
            Intent intent = new Intent(context, QuizActivity.class);
            String selectedTheme = linuxSpinner.getSelectedItem().toString();
            intent.putExtra("nameFile", getNameFile(Type.Linux, selectedTheme));
            intent.putExtra("title", "LINUX: " + selectedTheme);
            startActivity(intent);
        });

        //QUIZ button WINDOWS
        Button quizWindowsButton = findViewById(R.id.quizWindowsButton);
        quizWindowsButton.setOnClickListener(view -> {
            Intent intent = new Intent(context, QuizActivity.class);
            String selectedTheme = windowsSpinner.getSelectedItem().toString();
            intent.putExtra("nameFile", getNameFile(Type.Windows, selectedTheme));
            intent.putExtra("title", "WINDOWS: " + selectedTheme);
            startActivity(intent);
        });

        //ALL button LINUX
        Button allLinuxButton = findViewById(R.id.allLinuxButton);
        allLinuxButton.setOnClickListener(view -> {
            Intent intent = new Intent(context, AllQuestionsActivity.class);
            String selectedTheme = linuxSpinner.getSelectedItem().toString();
            intent.putExtra("nameFile", getNameFile(Type.Linux, selectedTheme));
            intent.putExtra("title", "LINUX: " + selectedTheme);
            startActivity(intent);


        });

        //ALL button WINDOWS
        Button allWindowsButton = findViewById(R.id.button4);
        allWindowsButton.setOnClickListener(view -> {
            Intent intent = new Intent(context, AllQuestionsActivity.class);
            String selectedTheme = windowsSpinner.getSelectedItem().toString();
            intent.putExtra("nameFile", getNameFile(Type.Windows, selectedTheme));
            intent.putExtra("title", "WINDOWS: " + selectedTheme);
            startActivity(intent);


        });
    }

    private List<String> getThemes(Type type) {
        return packages
                .stream()
                .filter(pack -> pack.getType() == type)
                .map(Package::getTheme)
                .collect(Collectors.toList());
    }

    private String getNameFile(final Type type, String theme) {
        return packages
                .stream()
                .filter(pack -> pack.getType() == type)
                .filter(pack -> pack.getTheme().equals(theme))
                .findFirst()
                .orElse(new Package())
                .getFileName();
    }

}
