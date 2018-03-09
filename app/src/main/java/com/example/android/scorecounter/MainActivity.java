package com.example.android.scorecounter;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // setting up fields to manipulate textViews
    private TextView homeGoalsView;
    private TextView awayGoalsView;
    private TextView homeCornersView;
    private TextView awayCornersView;
    private TextView homeYellowsView;
    private TextView awayYellowsView;
    private TextView homeRedsView;
    private TextView awayRedsView;


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // saving current scores to outState
        outState.putString("home_goals", homeGoalsView.getText().toString());
        outState.putString("away_goals", awayGoalsView.getText().toString());
        outState.putString("home_corners", homeCornersView.getText().toString());
        outState.putString("away_corners", awayCornersView.getText().toString());
        outState.putString("home_yellows", homeYellowsView.getText().toString());
        outState.putString("away_yellows", awayYellowsView.getText().toString());
        outState.putString("home_reds", homeRedsView.getText().toString());
        outState.putString("away_reds", awayRedsView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //retrieving scores from  savedInstanceState
        super.onRestoreInstanceState(savedInstanceState);
        homeGoalsView.setText(savedInstanceState.getString("home_goals"));
        awayGoalsView.setText(savedInstanceState.getString("away_goals"));
        homeCornersView.setText(savedInstanceState.getString("home_corners"));
        awayCornersView.setText(savedInstanceState.getString("away_corners"));
        homeYellowsView.setText(savedInstanceState.getString("home_yellows"));
        awayYellowsView.setText(savedInstanceState.getString("away_yellows"));
        homeRedsView.setText(savedInstanceState.getString("home_reds"));
        awayRedsView.setText(savedInstanceState.getString("away_reds"));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setting variables to later apply listener to buttons
        final Button homeCorner = findViewById(R.id.bttnHomeCorner);
        final Button awayCorner = findViewById(R.id.bttnAwayCorner);
        final Button homeYellow = findViewById(R.id.bttnHomeYellowCard);
        final Button awayYellow = findViewById(R.id.bttnAwayYellowCard);
        final Button homeRed = findViewById(R.id.bttnHomeRedCard);
        final Button awayRed = findViewById(R.id.bttnAwayRedCard);
        final Button homeGoal = findViewById(R.id.bttnHomeGoal);
        final Button awayGoal = findViewById(R.id.bttnAwayGoal);
        final Button resetBttn = findViewById(R.id.resetBttn);

        // initialising textView fields
        homeCornersView = findViewById(R.id.corner_home_text);
        awayCornersView = findViewById(R.id.corner_away_text);
        homeYellowsView = findViewById(R.id.yellow_card_home_text);
        awayYellowsView = findViewById(R.id.yellow_card_away_text);
        homeRedsView = findViewById(R.id.red_card_home_text);
        awayRedsView = findViewById(R.id.red_card_away_text);
        homeGoalsView = findViewById(R.id.homeTeamScoreTextView);
        awayGoalsView = findViewById(R.id.awayTeamScoreTextView);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            // sorting method to identify button clicked and apply new score to relevant textView
            // also to deal with reset button click
            public void onClick(View view) {
                if (view.getId() == homeCorner.getId()) {
                    updateScores(homeCornersView);
                } else if (view.getId() == homeYellow.getId()) {
                    updateScores(homeYellowsView);
                } else if (view.getId() == homeRed.getId()) {
                    updateScores(homeRedsView);
                } else if (view.getId() == homeGoal.getId()) {
                    updateScores(homeGoalsView);
                } else if (view.getId() == awayCorner.getId()) {
                    updateScores(awayCornersView);
                } else if (view.getId() == awayYellow.getId()) {
                    updateScores(awayYellowsView);
                } else if (view.getId() == awayRed.getId()) {
                    updateScores(awayRedsView);
                } else if (view.getId() == awayGoal.getId()) {
                    updateScores(awayGoalsView);
                } else {
                    homeCornersView.setText("0");
                    awayCornersView.setText("0");
                    homeYellowsView.setText("0");
                    awayYellowsView.setText("0");
                    homeRedsView.setText("0");
                    awayRedsView.setText("0");
                    homeGoalsView.setText("0");
                    awayGoalsView.setText("0");
                }
            }
        };
        // applying listener to all buttons
        resetBttn.setOnClickListener(listener);
        homeCorner.setOnClickListener(listener);
        awayCorner.setOnClickListener(listener);
        homeYellow.setOnClickListener(listener);
        awayYellow.setOnClickListener(listener);
        homeRed.setOnClickListener(listener);
        awayRed.setOnClickListener(listener);
        homeGoal.setOnClickListener(listener);
        awayGoal.setOnClickListener(listener);

    }
    // method to update scores on all textViews
    private void updateScores(TextView textView) {
        textView.setText(String.valueOf(Integer.valueOf(textView.getText().toString()) + 1));
    }
}

