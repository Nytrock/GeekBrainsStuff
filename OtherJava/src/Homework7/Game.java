package Homework7;

import javax.swing.*;

public class Game {
    private final GameBoard board;
    private final GamePlayer[] gamePlayers = new GamePlayer[2];
    private  int playersTurn = 0;

    public Game(){
        this.board = new GameBoard(this);
    }

    public void initGame() {
        gamePlayers[0] = new GamePlayer('X');
        gamePlayers[1] = new GamePlayer('O');
    }

    void PassTurn(){
        playersTurn ^= 1;
    }

    GamePlayer getCurrentPlayer(){
        return gamePlayers[playersTurn];
    }

    void showMessage(String messageText){
        JOptionPane.showMessageDialog(board, messageText);
    }
}