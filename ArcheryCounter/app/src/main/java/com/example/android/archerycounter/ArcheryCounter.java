package com.example.android.archerycounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ArcheryCounter extends AppCompatActivity {

    private int scoreArcherA = 0;
    private int scoreArcherB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archery_counter);
        displayForArcherA(0);
        displayForArcherB(0);
    }

    /**
     * Add points to team A.
     */

    public void addOneForArcherA(View view) {
        scoreArcherA = scoreArcherA + 1;
        displayForArcherA(scoreArcherA);
    }
    public void addTwoForArcherA(View view) {
        scoreArcherA = scoreArcherA + 2;
        displayForArcherA(scoreArcherA);
    }
    public void addThreeForArcherA(View view) {
        scoreArcherA = scoreArcherA + 3;
        displayForArcherA(scoreArcherA);
    }
    public void addFourForArcherA(View view) {
        scoreArcherA = scoreArcherA + 4;
        displayForArcherA(scoreArcherA);
    }
    public void addFiveForArcherA(View view) {
        scoreArcherA = scoreArcherA + 5;
        displayForArcherA(scoreArcherA);
    }
    public void addSixForArcherA(View view) {
        scoreArcherA = scoreArcherA + 6;
        displayForArcherA(scoreArcherA);
    }
    public void addSevenForArcherA(View view) {
        scoreArcherA = scoreArcherA + 7;
        displayForArcherA(scoreArcherA);
    }
    public void addEightForArcherA(View view) {
        scoreArcherA = scoreArcherA + 8;
        displayForArcherA(scoreArcherA);
    }
    public void addNineForArcherA(View view) {
        scoreArcherA = scoreArcherA + 9;
        displayForArcherA(scoreArcherA);
    }
    public void addTenForArcherA(View view) {
        scoreArcherA = scoreArcherA + 10;
        displayForArcherA(scoreArcherA);
    }

    /**
     * Add points to team B.
     */

    public void addOneForArcherB(View view) {
        scoreArcherB = scoreArcherB + 1;
        displayForArcherB(scoreArcherB);
    }
    public void addTwoForArcherB(View view) {
        scoreArcherB = scoreArcherB + 2;
        displayForArcherB(scoreArcherB);
    }
    public void addThreeForArcherB(View view) {
        scoreArcherB = scoreArcherB + 3;
        displayForArcherB(scoreArcherB);
    }
    public void addFourForArcherB(View view) {
        scoreArcherB = scoreArcherB + 4;
        displayForArcherB(scoreArcherB);
    }
    public void addFiveForArcherB(View view) {
        scoreArcherB = scoreArcherB + 5;
        displayForArcherB(scoreArcherB);
    }
    public void addSixForArcherB(View view) {
        scoreArcherB = scoreArcherB + 6;
        displayForArcherB(scoreArcherB);
    }
    public void addSevenForArcherB(View view) {
        scoreArcherB = scoreArcherB + 7;
        displayForArcherB(scoreArcherB);
    }
    public void addEightForArcherB(View view) {
        scoreArcherB = scoreArcherB + 8;
        displayForArcherB(scoreArcherB);
    }
    public void addNineForArcherB(View view) {
        scoreArcherB = scoreArcherB + 9;
        displayForArcherB(scoreArcherB);
    }
    public void addTenForArcherB(View view) {
        scoreArcherB = scoreArcherB + 10;
        displayForArcherB(scoreArcherB);
    }

    /**
     * Displays the given score for Team A.
     */
    private void displayForArcherA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    private void displayForArcherB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Resets score for both teams.
     */
    public void resetScores(View view) {
        scoreArcherA = 0;
        scoreArcherB = 0;
        displayForArcherA(scoreArcherA);
        displayForArcherB(scoreArcherB);
    }
}
