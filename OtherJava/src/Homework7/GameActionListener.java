package Homework7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameActionListener implements ActionListener {
    private final int row;
    private final int cell;
    private final GameButton button;
    static int t = 0;
    static int u = 0;

    public GameActionListener(int row, int cell, GameButton gButton){
        this.row = row;
        this.cell = cell;
        this.button = gButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameBoard board = button.getBoard();

        if (board.isTurnable(row, cell)){
            updateByPlayersData(board);

            if(board.isFull()){
                board.getGame().showMessage("Ничья!");
                board.emptyField();
                board.getGame().PassTurn();
            }
            else{
                if(t == 0){
                    updateByAiData(board);
                }
                else{
                    t = 0;
                }
            }
        }
        else {
            board.getGame().showMessage("Некорректный ход!");
        }
    }

    private void updateByPlayersData(GameBoard board){
        board.updateGameField(row, cell);

        button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayersSign()));

        if(board.checkWin()){
            button.getBoard().getGame().showMessage("Вы выиграли!");
            board.emptyField();
            t = 1;
        }
        else{
            board.getGame().PassTurn();
        }
    }

    private void updateByAiData(GameBoard board){
        for (int i = 0; i < (GameBoard.dimension * GameBoard.dimension); i++) {
            int x = i / GameBoard.dimension;
            int y = i % GameBoard.dimension;
            if (board.isTurnable(x, y)) {
                if (x - 1 >= 0 && GameBoard.gameField[y][x - 1] == board.getGame().getCurrentPlayer().getPlayersSign()) {
                    updateAI(x, y, board);
                    break;
                } else if (x - 1 >= 0 && y + 1 < GameBoard.dimension && GameBoard.gameField[y + 1][x - 1] == board.getGame().getCurrentPlayer().getPlayersSign()) {
                    updateAI(x, y, board);
                    break;
                } else if (x - 1 >= 0 && y - 1 >= 0 && GameBoard.gameField[y - 1][x - 1] == board.getGame().getCurrentPlayer().getPlayersSign()) {
                    updateAI(x, y, board);
                    break;
                } else if (y + 1 < GameBoard.dimension && GameBoard.gameField[y + 1][x] == board.getGame().getCurrentPlayer().getPlayersSign()) {
                    updateAI(x, y, board);
                    break;
                } else if (y - 1 >= 0 && GameBoard.gameField[y - 1][x] == board.getGame().getCurrentPlayer().getPlayersSign()) {
                    updateAI(x, y, board);
                    break;
                } else if (x + 1 < GameBoard.dimension && GameBoard.gameField[y][x + 1] == board.getGame().getCurrentPlayer().getPlayersSign()) {
                    updateAI(x, y, board);
                    break;
                } else if (x + 1 < GameBoard.dimension && y + 1 < GameBoard.dimension && GameBoard.gameField[y + 1][x + 1] == board.getGame().getCurrentPlayer().getPlayersSign()) {
                    updateAI(x, y, board);
                    break;
                } else if (x + 1 < GameBoard.dimension && y - 1 >= 0 && GameBoard.gameField[y - 1][x + 1] == board.getGame().getCurrentPlayer().getPlayersSign()) {
                    updateAI(x, y, board);
                    break;
                }
            }
        }
        if(u == 0){
            int x, y;
            Random rnd = new Random();

            do{
                x = rnd.nextInt(GameBoard.dimension);
                y = rnd.nextInt(GameBoard.dimension);
            }while(!board.isTurnable(x, y));
            u++;

            updateAI(x, y, board);
        }

        if(board.checkWin()){
            button.getBoard().getGame().showMessage("Компьютер выиграл!");
            board.emptyField();
        }
        board.getGame().PassTurn();
    }

    private void updateAI(int x, int y, GameBoard board) {
        board.updateGameField(x, y);
        int cellIndex = GameBoard.dimension * x + y;
        board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayersSign()));
    }
}