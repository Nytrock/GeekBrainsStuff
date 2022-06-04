package Homework1;

public class Homework {
    public static void main(String[] args) {
        System.out.println( ); //введите название любого метода, многие требуют переменную (где нужна строка не забудьте "")
    }
    static String AllTypes1() {
        byte z = 5;
        short s = 4388;
        int i = 894578437;
        long l = 5678L;
        float f = 700.6f;
        double t = 4.38921;
        boolean bool = false;
        char h = 'H';
        return z + " " + s + " " + i + " " + l + " " + f + " " + t + " " + t + " " + bool + " " + h;
    }
    static double Arifmetika2(double a, double b, double c, double d){
        return a * (b + (c / d));
    }
    static boolean TwoNumbers3(double a, double b){
        return 10 <= a + b && a + b <= 20;
    }
    static String PolozhAndOtr4(int a){
        if(a >= 0) {
            return "Число положительное";
        }
        else {
            return "Число отрицательное";
        }
    }
    static boolean Otr5(int a){
        return a < 0;
    }
    static String Name6(String name){
        return "Привет, " + name + "!";
    }
    static String Year7(int year){
        if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)){
            return "Год високосный";
        }
        else {
            return "Год не високосный";
        }
    }
}
