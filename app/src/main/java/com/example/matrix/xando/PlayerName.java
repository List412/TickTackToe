package com.example.matrix.xando;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;

public class PlayerName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name);
        Intent intent = getIntent();

        final EditText editPlayer1 = (EditText)findViewById(R.id.editPlayer1);
        editPlayer1.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                Player.setPlayer1(editPlayer1.getText().toString());
                checkNames();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

        });

        final EditText editPlayer2 = (EditText)findViewById(R.id.editPlayer2);
        editPlayer2.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                Player.setPlayer2(editPlayer2.getText().toString());
                checkNames();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

        });

        editPlayer1.setText(Player.getPlayer1());
        editPlayer2.setText(Player.getPlayer2());
    }

    public void setNames(String player1, String player2)
    {
        EditText editPlayer1 = (EditText)findViewById(R.id.editPlayer1);
        EditText editPlayer2 = (EditText)findViewById(R.id.editPlayer2);
        editPlayer1.setText(Player.getPlayer1());
        editPlayer2.setText(Player.getPlayer2());
    }

    public void checkNames()
    {
        if (Player.PlayersNamesAreEqual())
        {
            AlertDialog.Builder notice = new AlertDialog.Builder(PlayerName.this);
            notice.setTitle("Attention")
                    .setMessage("The names of the players are the same.\n" +
                            "Recommended for a comfortable game to make them different.");
            AlertDialog alert = notice.create();
            alert.show();
        }
    }
}
