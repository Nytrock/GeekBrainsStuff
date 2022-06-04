package Homework2;

import java.util.Arrays;

public class Homework2 {
    public static void main(String[] args) {
        System.out.print("Первый массив: ");
        int[] dvoich = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for(int i: dvoich) {
            if (i == 0){
                i = 1;
                System.out.print(i + " ");
            }
            else {
                i = 0;
                System.out.print(i + " ");
            }
        }
        System.out.print("\nВторой массив: ");
        int[] three = new int[8];
        for(int i = 0, m = 0; i <= 7; i++){
            three[i] = m;
            System.out.print(three[i] + " ");
            m += 3;
        }
        System.out.print("\nТретий массив: ");
        int[] six = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for(int i: six) {
            if (i > 6){
                System.out.print(i + " ");
            }
            else {
                i *= 2;
                System.out.print(i + " ");
            }
        }
        System.out.print("\nЧетвертый массив:");
        int[][] diag = new int[5][5]; //можете заменить размер массива, главное чтобы был квадратным
        for(int i = 0; i <= diag.length - 1; i++){
            System.out.print("\n");
            for(int j = 0; j <= diag.length - 1; j++){
                if(j == i || i + j == diag.length - 1){
                    diag[i][j] = 1;
                    System.out.print(diag[i][j] + " ");
                }
                else {
                    diag[i][j] = 0;
                    System.out.print(diag[i][j] + " ");
                }
            }
        }
        System.out.print("\nПятый массив: ");
        int[] minmax = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9 };
        int min = 0;
        int max = 0;
        for(int i: minmax){
            if(i > max){
                max = i;
            }
        }
        int fmax = max;
        for(int i: minmax){
            if(i < fmax){
                fmax = i;
                min = i;
            }
        }
        System.out.print("Максимум: " + max + ". Минимум: " + min);
        System.out.print("\nШестой массив: ");
        int[] arr = {10,3,2,1,4};
        int[] toArr = {2,1,5,4,2,2};
        int[] nextArr = {1,2,4,2,5};
        int[] toNextArr = {2,1,5,8};
        int[] falseArr = {1,2,4,5};
        System.out.print(checkBalance(arr) + " ");
        System.out.print(checkBalance(toArr) + " ");
        System.out.print(checkBalance(nextArr) + " ");
        System.out.print(checkBalance(toNextArr) + " ");
        System.out.print(checkBalance(falseArr) + " ");
        System.out.print("\nСедьмой массив:  ");
        int[] mass = {1, 2, 3, 4, 5, 6, 7};
        System.out.print(Arrays.toString(checkBalance1(mass, 1))); // можете заменить массив или n для проверки
    }
    static boolean checkBalance(int[] arr) {
        int leftArSum;
        int rigthArSum;
        for (int i = 0; i < arr.length - 1; i++) {
            leftArSum = 0;
            rigthArSum = 0;
            for (int v = 0; v <= i; v++)
                leftArSum += arr[v];
            for (int t = i + 1; t < arr.length; t++)
                rigthArSum += arr[t];
            if (leftArSum == rigthArSum)
                return true;
        }
        return false;
    }
    static int[] checkBalance1(int[] arr, int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int tmp = arr[arr.length-1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j-1];
                }
                arr[0] = tmp;
            }
        }
        else {
            n = -n;
            for (int i = 0; i < n; i++) {
                int tmp = arr[0];
                for (int j = 0; j < arr.length - 1; j++)
                    arr[j] = arr[j + 1];
                arr[arr.length-1] = tmp;
            }
        }
        return arr;
    }
}
