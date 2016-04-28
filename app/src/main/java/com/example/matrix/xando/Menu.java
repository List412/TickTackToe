package com.example.matrix.xando;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void newGame(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(MainActivity.player1, Player.getPlayer1());
        intent.putExtra(MainActivity.player2, Player.getPlayer2());
        startActivity(intent);
    }

    public void clickRename(View view)
    {
        Intent intent = new Intent(this, PlayerName.class);
        startActivity(intent);
    }

    public void Exit(View view)
    {
        System.exit(0);
    }
}
