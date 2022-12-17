//
//  Sudoku.java
//  
//
//
//

import java.util.*;

class sudoku {
    private int[][] sudoku;
    public sudoku() {
        sudoku = new int[9][9];
    }
    public sudoku(int sudoku[][]) {
        this.sudoku = sudoku;
    }
    private int containsInRow(int row, int number) {
        int c = 0;
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == number) {
            c++;
            }
        }
        return c;
    }
    private int containsInCol(int col, int number) {
        int c = 0;
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == number) {
                c++;
            }
        }
        return c;
    }
    private int containsInBox(int row, int col, int number) {
        int count = 0;
        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (sudoku[i][j] == number) {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isAllowed(int row, int col, int number) {
        int checkforCol = containsInCol(col, number);
        int checkforBox = containsInBox(row, col, number);
        int checkforRow = containsInRow(row, number);

        return !( (checkforBox!=1) || (checkforCol!=1) || (checkforRow!=1) );
    }
    public static void main(String ar[]) {
        Scanner sc = new Scanner(System.in);
        int count = 0;

        int[][] board =
        {
            {6, 2, 4, 5, 3, 9, 1, 8, 7},
            {5, 1, 9, 7, 2, 8, 6, 3, 4},
            {8, 3, 7, 6, 1, 4, 2, 9, 5},
            {1, 4, 3, 8, 6, 5, 7, 2, 9},
            {9, 5, 8, 2, 4, 7, 3, 6, 1},
            {7, 6, 2, 3, 9, 1, 4, 5, 8},
            {3, 7, 1, 9, 5, 6, 8, 4, 2},
            {4, 9, 6, 1, 8, 2, 5, 7, 3},
            {2, 8, 5, 4, 7, 3, 9, 1, 6}
            };
    
        sudoku a = new sudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boolean c = a.isAllowed(i, j, board[i][j] ) ;
               if(c == true) {
                   count++;
               }
            }
        }
        if(count == 81) {
            System.out.print("Valid");
        }
        else {
            System.out.print("Invalid");
        }
    }
}




            
