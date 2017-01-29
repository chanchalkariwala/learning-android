package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int miScoreA = 0;

    private int miScoreB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addThreeToTeamA(View pView)
    {
        miScoreA += 3;
        displayForTeamA();
    }

    public void addTwoToTeamA(View pView)
    {
        miScoreA += 2;
        displayForTeamA();
    }

    public void addOneToTeamA(View pView)
    {
        miScoreA += 1;
        displayForTeamA();
    }

    public void displayForTeamA()
    {
        ((TextView) findViewById(R.id.team_a_score)).setText(""+miScoreA);
    }

    public void addThreeToTeamB(View pView)
    {
        miScoreB += 3;
        displayForTeamB();
    }

    public void addTwoToTeamB(View pView)
    {
        miScoreB += 2;
        displayForTeamB();
    }

    public void addOneToTeamB(View pView)
    {
        miScoreB += 1;
        displayForTeamB();
    }

    public void displayForTeamB()
    {
        ((TextView) findViewById(R.id.team_b_score)).setText(""+miScoreB);
    }

    public void reset(View pView)
    {
        miScoreA = 0;
        miScoreB = 0;
        displayForTeamA();
        displayForTeamB();
    }
}
