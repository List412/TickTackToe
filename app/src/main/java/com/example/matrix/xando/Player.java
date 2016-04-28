package com.example.matrix.xando;

/**
 * Created by Matrix on 18.04.2016.
 */
public class Player {

    private static String player1 = "Player one";
    private static String player2 = "Player two";

    private int count;

    public static void setPlayer1(String value)
    {
        player1 = value;
    }

    public static String getPlayer1()
    {
        return player1;
    }

    public static void setPlayer2(String value)
    {
        player2 = value;
    }

    public static String getPlayer2()
    {
        return player2;
    }

    public static boolean PlayersNamesAreEqual()
    {
        if (player1.equals(player2))return true;
        else return false;
    }
}
