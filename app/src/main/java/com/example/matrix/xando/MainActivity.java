package com.example.matrix.xando;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        player1 = intent.getStringExtra(player1);
        player2 = intent.getStringExtra(player2);
    }

    public boolean Value = true;
    public static String player1 = "player1";
    public static String player2 = "player2";
    public static int Winner = -1;

    public String setValue()
    {
        TextView message = (TextView)findViewById(R.id.txtGo);
        Value = !Value;
        if (Value) {
            message.setText("Go, "+player2+" (O)");
            return "X";
        }
        else {
            message.setText("Go, "+player1+" (X)");
            return "O";
        }
    }

    public boolean CheckValue(String str)
    {
        if ( str !="X" && str !="O") return true;
        return false;
    }

    public void butn1Click(View view)
    {
        Button button = (Button)findViewById(R.id.button1);
        if (CheckValue(button.getText().toString()))
            button.setText(setValue());
        isVictory();
    }

    public void butn2Click(View view)
    {
        Button button = (Button)findViewById(R.id.button2);
        if (CheckValue(button.getText().toString()))
        button.setText(setValue());
        isVictory();
    }

    public void butn3Click(View view)
    {
        Button button = (Button)findViewById(R.id.button3);
        if (CheckValue(button.getText().toString()))
            button.setText(setValue());
        isVictory();
    }

    public void butn4Click(View view)
    {
        Button button = (Button)findViewById(R.id.button4);
        if (CheckValue(button.getText().toString()))
            button.setText(setValue());
        isVictory();
    }

    public void butn5Click(View view)
    {
        Button button = (Button)findViewById(R.id.button5);
        if (CheckValue(button.getText().toString()))
            button.setText(setValue());
        isVictory();
    }

    public void butn6Click(View view)
    {
        Button button = (Button)findViewById(R.id.button6);
        if (CheckValue(button.getText().toString()))
            button.setText(setValue());
        isVictory();
    }

    public void butn7Click(View view)
    {
        Button button = (Button)findViewById(R.id.button7);
        if (CheckValue(button.getText().toString()))
            button.setText(setValue());
        isVictory();
    }

    public void butn8Click(View view)
    {
        Button button = (Button)findViewById(R.id.button8);
        if (CheckValue(button.getText().toString()))
            button.setText(setValue());
        isVictory();
    }

    public void butn9Click(View view)
    {
        Button button = (Button)findViewById(R.id.button9);
        if (CheckValue(button.getText().toString()))
            button.setText(setValue());
        isVictory();
    }

    public void resetClick(View view)
    {
        for (int butnId = R.id.button1; butnId <= R.id.button9; butnId++) {
            Button butn = (Button)findViewById(butnId);
            butn.setBackgroundColor(Color.rgb(255,152,0));
            butn.setText("");
            butn.setEnabled(true);
            Winner = -1;
            TextView message = (TextView)findViewById(R.id.txtGo);
            if (Value)
                message.setText("Go, "+player2+" (O)");
            else
                message.setText("Go, "+player1+" (X)");
        }
    }

    public int XorO(String str)
    {
        if (str == "X") return 1;
        if (str == "O") return 0;
        else return -1;
    }

    public void isVictory()
    {
        int[][] matr = new int[3][3];
        int i = 0, j=0;
        for (int id1 = R.id.button1; id1 <= R.id.button9; id1++)
        {
            if (j>2)
            {
                j=0;
                i++;
            }
            Button butn = (Button)findViewById(id1);
            String btnText = butn.getText().toString();
            matr[i][j] = XorO(btnText);
            j++;
        }
        int[] winnerPosition = null;
        int cross = 1; //крестик
        int toe = 0;   //и нолик
        winnerPosition = checkVariant(matr, cross);
        if (winnerPosition == null)
        {
            winnerPosition = checkVariant(matr, toe);
        }
        if (winnerPosition != null) Attention(winnerPosition);
        if (isDraw() && Winner == -1) {
            AlertDialog.Builder sucsesMEssage = new AlertDialog.Builder(MainActivity.this);
            sucsesMEssage.setTitle("End Game")
                    .setMessage("Draw");
            TextView message = (TextView)findViewById(R.id.txtGo);
            message.setText("Draw");
            AlertDialog alert = sucsesMEssage.create();
            alert.show();
        }
    }

    public int[] checkVariant(int[][] matr, int checkValue)
    {
        Boolean hasWinner = false;
        int winCounter = 0;
        int[] winner = null;
        for (int i=0; i<3 && !hasWinner; i++) {
            winCounter = 0;
            for (int j = 0; j < 3 && !hasWinner; j++) {
                if (matr[i][j] == checkValue) winCounter++;
            }
            if (winCounter==3) {
                winner = new int[3];
                winner = matr[i];
                for (int a = 1; a <= matr[i].length; a++)
                    winner[a-1] = 3*i+a;
                hasWinner = true;
                Winner = checkValue;
                }
        }

        for (int i=0; i<3 && !hasWinner; i++) {
            winCounter = 0;
            for (int j = 0; j < 3 && !hasWinner; j++) {
                if (matr[j][i] == checkValue) winCounter++;
                if (winCounter==3) {
                    winner = new int[3];
                    for (int a = 0; a < matr[j].length; a++)
                        winner[a] =3*a+i+1;
                    hasWinner = true;
                    Winner = checkValue;
                }
            }
        }
        winCounter = 0;
        for (int i = 0; i < 3 && !hasWinner; i++)
            if (matr[i][i] == checkValue) winCounter++;

        if (winCounter==3)
        {
            winner = new int[3];
            winner[0] = 1; winner[1] = 5; winner[2] = 9;
            hasWinner = true;
            Winner = checkValue;
        }
        winCounter = 0;
        for (int i = 0; i<3 && !hasWinner; i++)
            if (matr[2-i][i] == checkValue) winCounter++;

        if (winCounter==3)
        {
            winner = new int[3];
            winner[0] = 3; winner[1] = 5; winner[2] = 7;
            hasWinner = true;
            Winner = checkValue;
        }
        return winner;
    }

    public Boolean isDraw()
    {
        Boolean res = false;
        int count = 0;
        for (int id = R.id.button1; id <= R.id.button9; id++)
        {
            Button butn = (Button)findViewById(id);
            String value = butn.getText().toString();
            if (value == "X" || value == "O") count++;
        }
        if (count == 9)
            res = true;
        return res;
    }

    public void Attention(int[]winnerPosition)
    {
        int j = 0;
        Button butn = (Button)findViewById(R.id.button1);
        for (int id1 = R.id.button1, i = 1; id1 <= R.id.button9; id1++, i++)
        {
            butn = (Button)findViewById(id1);
            butn.setEnabled(false);
            if (winnerPosition[j] == i) {
                if(j!=2)j++;
                butn.setBackgroundColor(Color.rgb(76,175,80));
            }
        }

        String winner = "";
        if (Winner == 1) winner = player1;
        else if (Winner == 0) winner = player2;
        winner = winner+" wins";
        AlertDialog.Builder sucsesMEssage = new AlertDialog.Builder(MainActivity.this);
        sucsesMEssage.setTitle("End Game")
                .setMessage(winner);
        TextView message = (TextView)findViewById(R.id.txtGo);
        message.setText(winner);
        AlertDialog alert = sucsesMEssage.create();
        alert.show();
    }
}
