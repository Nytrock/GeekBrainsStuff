package Homework3;

import java.util.Scanner;
import java.util.Random;

public class Homework3 {

    private static char[][] map;
    private static int Size = 3;

    private static final char krestik = 'X';
    private static final char nolik = 'O';
    private static final char pysto = '*';

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        initMass();
        print();
        while (true) {
            hodChel();

            print();

            if (prPobed(krestik)) {
                break;
            }

            hodKomp();
            System.out.println();
            print();

            if (prPobed(nolik)) {
                break;
            }
        }
    }

    private static void initMass() {
        map = new char[Size][Size];
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                map[i][j] = pysto;
            }
        }
    }

    private static void print() {
        for (int i = 0; i <= Size; i++) {
            System.out.print(i + " ");
        }
        for (int i = 0; i < Size; i++) {
            System.out.println();
            System.out.print(i + 1 + " ");
            for (int j = 0; j < Size; j++) {
                System.out.print(map[i][j] + " ");
            }
        }
    }

    private static void hodChel() {
        int x, y;
        do {
            System.out.print("\nВведите координаты хода: ");
            y = scanner.nextInt() - 1;
            x = scanner.nextInt() - 1;
        } while (Validnost(x, y));
        map[y][x] = krestik;
    }

    private static boolean Validnost(int x, int y) {
        return x < 0 || x >= Size || y < 0 || y >= Size || map[y][x] != pysto;
    }

    public static boolean prPobed(char symbol) {
        if (Win(symbol)) {
            System.out.println("\nПобедили " + symbol + "!!!");
            return true;
        }
        else if (Nichia()) {
            System.out.println("\nНичья");
            return true;
        }
        else {
            return false;
        }
    }

    private static boolean Nichia(){
        boolean result = true;
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                if(map[i][j] == pysto){
                    result = false;
                }
            }
        }
        return result;
    }

    private static boolean Win(char symbol){
        if(map[0][0] == symbol && map[1][0] == symbol && map[2][0] == symbol ||
           map[0][1] == symbol && map[1][1] == symbol && map[2][1] == symbol ||
           map[0][2] == symbol && map[1][2] == symbol && map[2][2] == symbol ||
           map[0][0] == symbol && map[0][1] == symbol && map[0][2] == symbol ||
           map[1][0] == symbol && map[1][1] == symbol && map[1][2] == symbol ||
           map[2][0] == symbol && map[2][1] == symbol && map[2][2] == symbol ||
           map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol ||
           map[0][2] == symbol && map[1][1] == symbol && map[2][0] == symbol){
            return true;
        }
        else{
            return false;
        }
    }
    private static void hodKomp(){
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                if(map[i][j] == pysto){
                    if(i+1 < Size && map[i+1][j] == nolik){
                            map[i][j] = nolik;
                            System.out.print("\nКомпьютер сходил на " + (i + 1) + ", " + (j + 1));
                            i += Size;
                            break;
                    }
                    else if(i+1 < Size && j+1 < Size && map[i+1][j+1] == nolik){
                            map[i][j] = nolik;
                            System.out.print("\nКомпьютер сходил на " + (i + 1) + ", " + (j + 1));
                            i += Size;
                            break;
                    }
                    else if(i+1 < Size && j - 1 >= 0 && map[i+1][j-1] == nolik){
                            map[i][j] = nolik;
                            System.out.print("\nКомпьютер сходил на " + (i + 1) + ", " + (j + 1));
                            i += Size;
                            break;
                    }
                    else if(i+1 < Size && j + 1 < Size && map[i][j+1] == nolik){
                            map[i][j] = nolik;
                            System.out.print("\nКомпьютер сходил на " + (i + 1) + ", " + (j + 1));
                            i += Size;
                            break;
                    }
                    else if(j - 1 >= 0 && map[i][j-1] == nolik){
                            map[i][j] = nolik;
                            System.out.print("\nКомпьютер сходил на " + (i + 1) + ", " + (j + 1));
                            i += Size;
                            break;
                    }
                    else if(i - 1 >= 0 && map[i-1][j] == nolik){
                            map[i][j] = nolik;
                            System.out.print("\nКомпьютер сходил на " + (i + 1) + ", " + (j + 1));
                            i += Size;
                            break;
                    }
                    else if(i - 1 >= 0 && j + 1 < Size && map[i-1][j+1] == nolik){
                            map[i][j] = nolik;
                            System.out.print("\nКомпьютер сходил на " + (i + 1) + ", " + (j + 1));
                            i += Size;
                            break;
                    }
                    else if(i - 1 >= 0 && j - 1 >= 0 && map[i-1][j-1] == nolik){
                            map[i][j] = nolik;
                            System.out.print("\nКомпьютер сходил на " + (i + 1) + ", " + (j + 1));
                            i += Size;
                            break;
                    }
                    else{
                        int x = -1;
                        int y = -1;
                        do {
                            x = random.nextInt(Size);
                            y = random.nextInt(Size);
                        } while (Validnost(x, y));
                        map[y][x] = nolik;
                        System.out.print("\nКомпьютер сходил на " + (y + 1) + ", " + (x + 1));
                        i += Size;
                        break;
                    }
                }
            }
        }
    }
}