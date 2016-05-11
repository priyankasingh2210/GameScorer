package com.priyankasingh.gamescorer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int SCORE2 = 2;
    public static final int SCORE3 = 3;
    public static final int FREEHIT = 1;
    private View teamA;
    private TextView teamScoreA;
    private TextView teamNameA;
    private Button team2PointerA;
    private Button team3PointerA;
    private Button teamFreeHitA;

    private View teamB;
    private TextView teamScoreB;
    private TextView teamNameB;
    private Button team2PointerB;
    private Button team3PointerB;
    private Button teamFreeHitB;

    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teamA = findViewById(R.id.teamA);
        teamScoreA = (TextView)     teamA.findViewById(R.id.tvScore);
        teamNameA = (TextView)      teamA.findViewById(R.id.tvTeamName);
        team2PointerA = (Button)    teamA.findViewById(R.id.btn2pointer);
        team3PointerA = (Button)    teamA.findViewById(R.id.btn3pointer);
        teamFreeHitA = (Button)     teamA.findViewById(R.id.btnFreeHit);
        teamNameA.setText("Team A");

        teamB = findViewById(R.id.teamB);
        teamScoreB = (TextView)     teamB.findViewById(R.id.tvScore);
        teamNameB = (TextView)      teamB.findViewById(R.id.tvTeamName);
        team2PointerB = (Button)    teamB.findViewById(R.id.btn2pointer);
        team3PointerB = (Button)    teamB.findViewById(R.id.btn3pointer);
        teamFreeHitB = (Button)     teamB.findViewById(R.id.btnFreeHit);
        teamNameB.setText("Team B");
        btnReset = (Button) findViewById(R.id.btnReset);
    }

    public void resetScore(View view){
        setScore(teamScoreA,0);
        setScore(teamScoreB,0);
    }

    public void score(View view){
        int id = view.getId();
        int parentId = ((View)view.getParent()).getId();
        switch (id){
            case R.id.btn2pointer:
                intCreaseScore(parentId, SCORE2);
                break;
            case R.id.btn3pointer:
                intCreaseScore(parentId, SCORE3);
                break;
            case R.id.btnFreeHit:
                intCreaseScore(parentId, FREEHIT);
                break;
            default:
                break;
        }
    }

    private void intCreaseScore(int parentId, int score) {
        switch (parentId){
            case R.id.teamA:
                setScore(teamScoreA,score);
                break;
            case R.id.teamB:
                setScore(teamScoreB,score);
                break;
            default:
                break;
        }
    }

    public void setScore(TextView textView,int score){
        try {
            int oldScore = Integer.parseInt(textView.getText().toString());
            if (score > 0) {
                oldScore += score;
            } else {
                oldScore = 0;
            }
            textView.setText(oldScore + "");
        }catch (NumberFormatException ex){
            textView.setText("0");
        }
    }
}
