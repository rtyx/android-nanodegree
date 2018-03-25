package com.example.android.geoquizzapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public int numberOfQuestions = 5;
    public int correctAnswers;
    public int incorrectAnswers;
    public String userName;

    public EditText nameInput;
    public RadioGroup knowledgeInput;
    public RadioGroup biggestByPopulationInput;
    public RadioGroup biggestBySurfaceInput;
    public CheckBox franceCheckbox;
    public CheckBox texasCheckbox;
    public CheckBox hiltonCheckbox;

    public RadioButton mexicoCity;
    public RadioButton losAngeles;

    public RadioButton guessYes;
    public RadioButton guessNope;


    public View questionsContainer;

    public View endScreen;
    public TextView endMessage;
    public TextView selfKnowledgeComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = (EditText) findViewById(R.id.name_input);
        knowledgeInput = (RadioGroup) findViewById(R.id.knowledge_input);
        biggestByPopulationInput = (RadioGroup) findViewById(R.id.biggest_by_population_input);
        biggestBySurfaceInput = (RadioGroup) findViewById(R.id.biggest_by_surface_input);
        franceCheckbox = (CheckBox) findViewById(R.id.five_checkbox_france);
        texasCheckbox = (CheckBox) findViewById(R.id.five_checkbox_texas);
        hiltonCheckbox = (CheckBox) findViewById(R.id.five_checkbox_hilton);
        mexicoCity = (RadioButton) findViewById(R.id.three_mexico_city);
        losAngeles = (RadioButton) findViewById(R.id.four_radio_los_angeles);

        guessYes = (RadioButton) findViewById(R.id.two_radio_yes);
        guessNope = (RadioButton) findViewById(R.id.two_radio_no);

        questionsContainer = (View) findViewById(R.id.questions_container);

        endScreen = (View) findViewById(R.id.end_screen);
        endMessage = (TextView) findViewById(R.id.end_message);
        selfKnowledgeComment = (TextView) findViewById(R.id.self_knowledge_comment);

        this.onStartQuiz();
    }

    public void onStartQuiz() {
        this.questionsContainer.setVisibility(View.VISIBLE);
        this.endScreen.setVisibility(View.GONE);

        knowledgeInput.clearCheck();
        biggestByPopulationInput.clearCheck();
        biggestBySurfaceInput.clearCheck();

        franceCheckbox.setChecked(false);
        hiltonCheckbox.setChecked(false);
        texasCheckbox.setChecked(false);

        this.correctAnswers = 0;
        this.incorrectAnswers = 0;

    }

    public void onReset(View view) {
        this.onStartQuiz();
    }

    public void evaluateFirstQuestion() {
        this.userName = this.nameInput.getText().toString();
        Log.d("1", "User name: " + this.userName);
        if (!this.userName.matches("")) {
            this.correctAnswers = this.correctAnswers + 1;
        }
        Log.d("COUNTER", "Correct answers: " + this.correctAnswers);
    }

    public void evaluateSecondQuestion() {
        int radioButtonID = this.knowledgeInput.getCheckedRadioButtonId();
        int guessYesID = this.guessYes.getId();
        int guessNopeID = this.guessNope.getId();

        this.incorrectAnswers = this.numberOfQuestions - this.correctAnswers;
        if (this.correctAnswers > this.incorrectAnswers) {
            if (radioButtonID == guessYesID) {
                this.selfKnowledgeComment.setText(R.string.guess_win_and_win);
            } else {
                this.selfKnowledgeComment.setText(R.string.guess_lose_but_win);
            }
        } else {
            if (radioButtonID == guessYesID) {
                this.selfKnowledgeComment.setText(R.string.guess_win_but_lose);
            } else {
                this.selfKnowledgeComment.setText(R.string.guess_lose_and_lose);
            }
        }
        Log.d("COUNTER", "Correct answers: " + this.correctAnswers);
    }

    public void evaluateThirdQuestion() {
        int correctAnswerID = this.mexicoCity.getId();
        int radioButtonID = this.biggestByPopulationInput.getCheckedRadioButtonId();
        Log.d("3", "Correct answer: " + correctAnswerID);
        Log.d("3", "Answer selected: " + radioButtonID);
        if (correctAnswerID == radioButtonID) {
            this.correctAnswers = this.correctAnswers + 1;
        }
        Log.d("COUNTER", "Correct answers: " + this.correctAnswers);
    }

    public void evaluateFourthQuestion() {
        int correctAnswerID = this.losAngeles.getId();
        int radioButtonID = this.biggestBySurfaceInput.getCheckedRadioButtonId();
        Log.d("4", "Correct answer: " + correctAnswerID);
        Log.d("4", "Answer selected: " + radioButtonID);
        if (correctAnswerID == radioButtonID) {
            this.correctAnswers = this.correctAnswers + 1;
        }
        Log.d("COUNTER", "Correct answers: " + this.correctAnswers);
    }

    public void evaluateFifthQuestion() {
        if (this.franceCheckbox.isChecked() && this.texasCheckbox.isChecked() && !this.hiltonCheckbox.isChecked()) {
            this.correctAnswers = this.correctAnswers + 1;
        }
        Log.d("COUNTER", "Correct answers: " + this.correctAnswers);
    }

    public void onSubmit(View view) {
        this.evaluateFirstQuestion();
        this.evaluateThirdQuestion();
        this.evaluateFourthQuestion();
        this.evaluateFifthQuestion();
        this.evaluateSecondQuestion();

        questionsContainer.setVisibility(View.GONE);

        Log.d("RESULT", "Correct answers: " + this.correctAnswers);
        Log.d("RESULT", "Incorrect answers: " + this.incorrectAnswers);

        if (this.correctAnswers > this.incorrectAnswers) {
            this.endMessage.setText(R.string.win_message);
            this.endMessage.setTextColor(Color.GREEN);
        } else {
            this.endMessage.setText(R.string.lose_message);
            this.endMessage.setTextColor(Color.RED);
        }

        this.endScreen.setVisibility(View.VISIBLE);
    }
}
