package com.example.android.quizapp;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


class QuizWord {
    public String word;
    public String gender;

    QuizWord(String word, String gender) {
        this.word = word;
        this.gender = gender;
    }
}

public class MainActivity extends AppCompatActivity {

    public QuizWord[] allQuizWords = {
        new QuizWord("Tisch", "m"),
        new QuizWord("Lampe", "f"),
        new QuizWord("Buch", "n"),
        new QuizWord("Kuhlschrank", "m"),
        new QuizWord("Kino", "n"),
        new QuizWord("Sache", "f"),
        new QuizWord("Zeit", "f"),
        new QuizWord("Mensch", "m"),
        new QuizWord("Paar", "n"),
        new QuizWord("Welt", "f"),
        new QuizWord("Gesicht", "n"),
        new QuizWord("Bett", "n"),
        new QuizWord("Zeitschrift", "f"),
        new QuizWord("Berg", "m"),
        new QuizWord("Fork", "f"),
        new QuizWord("Löffel", "m"),
        new QuizWord("Messer", "n"),
        new QuizWord("Geld", "n"),
        new QuizWord("Kasse", "f"),
        new QuizWord("Tüte", "f"),
        new QuizWord("Einkaufswagen", "m"),
        new QuizWord("Pass", "m"),
        new QuizWord("Visum", "n"),
        new QuizWord("Stadtplan", "m"),
        new QuizWord("Sehenwürdigkeit", "n"),
        new QuizWord("Stein", "m"),
        new QuizWord("Wolle", "f"),
        new QuizWord("Holz", "n"),
        new QuizWord("Verein", "m"),
        new QuizWord("Kohle", "f"),
        new QuizWord("Sarg", "m"),
        new QuizWord("Ball", "m"),
        new QuizWord("Gedanke", "m"),
        new QuizWord("Filosofie", "f"),
        new QuizWord("Batterie", "f"),
        new QuizWord("Tor", "n"),
        new QuizWord("Fenster", "n"),
        new QuizWord("Anwalt", "m"),
        new QuizWord("Aufsatz", "m"),
        new QuizWord("Braut", "f"),
        new QuizWord("Umschlag", "m"),
        new QuizWord("Dauerglotze", "m"),
        new QuizWord("Deckel", "m"),
        new QuizWord("Durcheinander", "n"),
        new QuizWord("Gardine", "f"),
        new QuizWord("Gafängnis", "n"),
        new QuizWord("Gefäß", "n"),
        new QuizWord("Schädel", "m"),
        new QuizWord("Soldat", "m"),
        new QuizWord("Kamin", "m"),
    };

    public QuizWord[] quizWords;


    public int round = 0;
    public int rights = 0;
    public int wrongs = 0;

    public View game;
    public View welcome;

    public String chosenGender;

    public CheckBox checkbox;
    public EditText numberOfQuestions;

    public TextView quizzWordView;
    public TextView yayNayView;
    public TextView rightCounterView;
    public TextView wrongCounterView;
    public RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prestart();
    }

    public void prestart() {
        Log.d("Number of questions", "******************** PRESTARTING *****************");
        welcome = (View) findViewById(R.id.welcome);
        game = (View) findViewById(R.id.game);

        checkbox = (CheckBox) findViewById(R.id.checkbox);
        numberOfQuestions = (EditText) findViewById(R.id.number_of_questions);

        quizzWordView = (TextView) findViewById(R.id.quizzWord);
        yayNayView = (TextView) findViewById(R.id.yayNay);
        rightCounterView = (TextView) findViewById(R.id.rightValue);
        wrongCounterView = (TextView) findViewById(R.id.wrongValue);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);


        game.setVisibility(View.INVISIBLE);
        numberOfQuestions.setVisibility(View.INVISIBLE);
        welcome.setVisibility(View.VISIBLE);

        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                numberOfQuestions.setVisibility(View.VISIBLE);
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        Log.d("Radio buton clicked", "**************************************");
        Log.d("Round", "" + round);


        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioDer:
                if (checked) {
                    chosenGender = "m";
                    compareGenders(chosenGender, quizWords[round].gender);
                }
                break;
            case R.id.radioDie:
                if (checked) {
                    chosenGender = "f";
                    compareGenders(chosenGender, quizWords[round].gender);
                }
                break;
            case R.id.radioDas:
                if (checked) {
                    chosenGender = "n";
                    compareGenders(chosenGender, quizWords[round].gender);
                }
                break;
        }
    }

    public void compareGenders(String answer, String chosen) {
        Log.d("answer", answer);
        Log.d("chosen", chosen);

        if (answer.equals(chosen)) {
            onRight();
        } else {
            onWrong();
        }
    }

    public void onRight() {
        Log.d("Running", "on right");
        rights = rights + 1;
        placeCompleteWord();
        quizzWordView.setTextColor(getResources().getColor(R.color.green));
        goToNextRound();
    }

    public void onWrong() {
        Log.d("Running", "on wrong");
        wrongs = wrongs + 1;
        placeCompleteWord();
        quizzWordView.setTextColor(getResources().getColor(R.color.red));
        goToNextRound();
    }

    public void placeCompleteWord() {
        if (quizWords[round].gender.equals("m")) {
            quizzWordView.setText("Der " + quizWords[round].word);
        }
        if (quizWords[round].gender.equals("f")) {
            quizzWordView.setText("Die " + quizWords[round].word);
        }
        if (quizWords[round].gender.equals("n")) {
            quizzWordView.setText("Das " + quizWords[round].word);
        }
    }

    public void goToNextRound() {
        rightCounterView.setText(String.valueOf(rights));
        wrongCounterView.setText(String.valueOf(wrongs));


        if (round < quizWords.length - 1) {
            round = round + 1;
        }

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                quizzWordView.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                radioGroup.clearCheck();

                if (round == quizWords.length - 1) {
                    quizzWordView.setText(quizWords[round].word);
                } else {
                    endGame();
                }
            }
        }, 1000);
    }

    public void endGame() {
        Log.d("Number of questions", "ENDING GAME");
        radioGroup.setVisibility(View.GONE);

        if (rights > quizWords.length / 2) {
            yayNayView.setText("Congratulations! You kind of know your Deutsch");
        } else {
            yayNayView.setText("Ooops! You didn't get too many. Try again!");
        }
    }


    public void reset(View view) {
        Log.d("Number of questions", numberOfQuestions.getText().toString());

        numberOfQuestions.getText();

        quizWords = new QuizWord[10];

        System.arraycopy(allQuizWords, 0, quizWords, 0, 10);

        game.setVisibility(View.VISIBLE);
        welcome.setVisibility(View.INVISIBLE);
        radioGroup.setVisibility(View.VISIBLE);

        round = 0;
        rights = 0;
        wrongs = 0;

        quizzWordView.setText(quizWords[round].word);
        yayNayView.setText("");
        rightCounterView.setText(String.valueOf(rights));
        wrongCounterView.setText(String.valueOf(wrongs));
    }



}
