package ru.itis.Task1;

import java.util.Scanner;

public class Main {
    static int[][] chessBoard;

    public static void main(String[] args) {
        fillBoard();

        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();

        char[] inputChr = input.toCharArray();
        int n1 = inputChr[0] - 'a';
        int n2 = inputChr[1] - '0' - 1;

        if (chessBoard[n1][n2] == 1){
            System.out.println("Black");
        }else {
            System.out.println("White");
        }


    }

    private static void fillBoard(){
        chessBoard = new int[8][8];
        int l = chessBoard[1].length;
        for (int i = 0; i < chessBoard.length; i++){
            for (int k = 0; k < chessBoard.length; k++){
                if (i % 2 == 0){
                    if (k % 2 == 0){
                        chessBoard[i][k] = 1;
                    }else {
                        chessBoard[i][k] = 0;
                    }
                }else {
                    if (k % 2 == 0){
                        chessBoard[i][k] = 0;
                    }else {
                        chessBoard[i][k] = 1;
                    }

                }
            }
        }
    }
}
