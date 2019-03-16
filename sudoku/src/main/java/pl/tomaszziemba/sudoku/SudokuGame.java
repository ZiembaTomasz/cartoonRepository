package pl.tomaszziemba.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuGame {
    public static void main(String[] args) {

//        System.out.println("Hello World!");
//        Random random = new Random();
//        List<SudokuRow>rows = new ArrayList<>();
//        SudokuBoards table = new SudokuBoards(rows);
//        for(int i =0; i<9; i++){
//
//            List<SudokuElement>elements = new ArrayList<>();
//            for (int j =0; j<9; j++){
//                SudokuElement element = new SudokuElement(random.nextInt(9)+ 1);
//                elements.add(element);
//            }
//            SudokuRow row = new SudokuRow(elements);
//            rows.add(row);
//
//
//        }
        SudokuBoards table;

        table = new SudokuGame().createTable();
        SudokuGame sudokuGame = new SudokuGame();
        sudokuGame.findIndex(table);
        //table = new SudokuGame().createTable();
        //printTable(table);
        //new SudokuGame().sudokuAlgorithm(table);
        //printTable(table);

//        boolean gameFinished = false;
        //       while(!gameFinished) {
        //          SudokuGame theGame = new SudokuGame();
        //         gameFinished = theGame.resolveSudoku();
        //    }
    }

    private static void printTable(SudokuBoards table) {
        int i = 0;
        for (SudokuRow sudokuRow : table.getRows()) {

            if (i++ % 3 == 0) {
                System.out.println(" ");
            }
            printRow(sudokuRow);

        }

    }

    private static void printRow(SudokuRow sudokuRow) {
        int i = 0;
        for (SudokuElement sudokuElement : sudokuRow.getElements()) {
            if (i++ % 3 == 0) {
                System.out.print("  ");
            }
            System.out.print(sudokuElement.getValue() + " ");
        }
        System.out.println();
    }

    private boolean resolveSudoku() {
        return true;
    }

    public SudokuBoards sudokuAlgorithm(SudokuBoards sudokuBoards) {

        for (SudokuRow row : sudokuBoards.getRows()) {
            for (int i = 0; i < row.getElements().size(); i++) {
                SudokuElement myElement = row.getElements().get(i);
                clearRow(row, myElement);
            }
            for (int i = 0; i < row.getElements().size(); i++) {
                SudokuElement myElement = row.getElements().get(i);
                clearColumn(sudokuBoards, i, myElement);
            }
        }
        return sudokuBoards;
    }

    public void clearColumn(SudokuBoards sudokuBoards, int i, SudokuElement myElement) {
        if (myElement.isEmpty()) {
            for (SudokuRow row1 : sudokuBoards.getRows()) {
                SudokuElement nextElement = row1.getElements().get(i);
                myElement.removePossibleValue(nextElement);
            }
            myElement.expectedValue();

        }
    }

    public void clearRow(SudokuRow row, SudokuElement myElement) {
        if (myElement.isEmpty()) {
            for (SudokuElement checkedElement : row.getElements()) {
                myElement.removePossibleValue(checkedElement);
            }
            myElement.expectedValue();
        }
    }
    public void findIndex(SudokuBoards sudokuBoards){

        for(int i = 0; i < sudokuBoards.getRows().size(); i++){
            int elements = 8;
            for(int j = 0; j <=elements;   j++){
                System.out.println(sudokuBoards.getRows().get(i).getElements().get(j).getValue());
                int a = i/3 * 3;
                int b = j/3 * 3;

                System.out.println(i + "," + j + "->" + (a + "." +b));

            }
        }

    }

// jezeli mam tam isEmpty to jest empty wiec juz nie robie kolejnego ifa w tym

    private SudokuBoards createTable() {
        List<SudokuElement> row1 = new ArrayList<>();
        row1.add(new SudokuElement(-1));
        row1.add(new SudokuElement(-1));
        row1.add(new SudokuElement(1));
        row1.add(new SudokuElement(-1));
        row1.add(new SudokuElement(8));
        row1.add(new SudokuElement(7));
        row1.add(new SudokuElement(-1));
        row1.add(new SudokuElement(-1));
        row1.add(new SudokuElement(-1));
        List<SudokuElement> row2 = new ArrayList<>();
        row2.add(new SudokuElement(3));
        row2.add(new SudokuElement(5));
        row2.add(new SudokuElement(-1));
        row2.add(new SudokuElement(1));
        row2.add(new SudokuElement(6));
        row2.add(new SudokuElement(9));
        row2.add(new SudokuElement(-1));
        row2.add(new SudokuElement(-1));
        row2.add(new SudokuElement(-1));
        List<SudokuElement> row3 = new ArrayList<>();
        row3.add(new SudokuElement(7));
        row3.add(new SudokuElement(-1));
        row3.add(new SudokuElement(-1));
        row3.add(new SudokuElement(-1));
        row3.add(new SudokuElement(-1));
        row3.add(new SudokuElement(5));
        row3.add(new SudokuElement(3));
        row3.add(new SudokuElement(1));
        row3.add(new SudokuElement(-1));
        List<SudokuElement> row4 = new ArrayList<>();
        row4.add(new SudokuElement(6));
        row4.add(new SudokuElement(-1));
        row4.add(new SudokuElement(-1));
        row4.add(new SudokuElement(-1));
        row4.add(new SudokuElement(5));
        row4.add(new SudokuElement(-1));
        row4.add(new SudokuElement(1));
        row4.add(new SudokuElement(4));
        row4.add(new SudokuElement(8));
        List<SudokuElement> row5 = new ArrayList<>();
        row5.add(new SudokuElement(4));
        row5.add(new SudokuElement(-1));
        row5.add(new SudokuElement(-1));
        row5.add(new SudokuElement(-1));
        row5.add(new SudokuElement(-1));
        row5.add(new SudokuElement(-1));
        row5.add(new SudokuElement(-1));
        row5.add(new SudokuElement(-1));
        row5.add(new SudokuElement(5));
        List<SudokuElement> row6 = new ArrayList<>();
        row6.add(new SudokuElement(5));
        row6.add(new SudokuElement(9));
        row6.add(new SudokuElement(2));
        row6.add(new SudokuElement(-1));
        row6.add(new SudokuElement(4));
        row6.add(new SudokuElement(-1));
        row6.add(new SudokuElement(-1));
        row6.add(new SudokuElement(-1));
        row6.add(new SudokuElement(6));
        List<SudokuElement> row7 = new ArrayList<>();
        row7.add(new SudokuElement(-1));
        row7.add(new SudokuElement(4));
        row7.add(new SudokuElement(9));
        row7.add(new SudokuElement(6));
        row7.add(new SudokuElement(-1));
        row7.add(new SudokuElement(-1));
        row7.add(new SudokuElement(-1));
        row7.add(new SudokuElement(-1));
        row7.add(new SudokuElement(2));
        List<SudokuElement> row8 = new ArrayList<>();
        row8.add(new SudokuElement(-1));
        row8.add(new SudokuElement(-1));
        row8.add(new SudokuElement(-1));
        row8.add(new SudokuElement(5));
        row8.add(new SudokuElement(1));
        row8.add(new SudokuElement(8));
        row8.add(new SudokuElement(-1));
        row8.add(new SudokuElement(9));
        row8.add(new SudokuElement(3));
        List<SudokuElement> row9 = new ArrayList<>();
        row9.add(new SudokuElement(-1));
        row9.add(new SudokuElement(-1));
        row9.add(new SudokuElement(-1));
        row9.add(new SudokuElement(2));
        row9.add(new SudokuElement(9));
        row9.add(new SudokuElement(-1));
        row9.add(new SudokuElement(6));
        row9.add(new SudokuElement(-1));
        row9.add(new SudokuElement(-1));
        List<SudokuRow> sudokuRows = new ArrayList<>();
        sudokuRows.add(new SudokuRow(row1));
        sudokuRows.add(new SudokuRow(row2));
        sudokuRows.add(new SudokuRow(row3));
        sudokuRows.add(new SudokuRow(row4));
        sudokuRows.add(new SudokuRow(row5));
        sudokuRows.add(new SudokuRow(row6));
        sudokuRows.add(new SudokuRow(row7));
        sudokuRows.add(new SudokuRow(row8));
        sudokuRows.add(new SudokuRow(row9));
        SudokuBoards sudokuBoards = new SudokuBoards(sudokuRows);
        return sudokuBoards;
    }

    public SudokuBoards createTestTableOne() {
        List<SudokuElement> row1 = new ArrayList<>();
        row1.add(new SudokuElement(9));
        row1.add(new SudokuElement(8));
        row1.add(new SudokuElement(6));
        row1.add(new SudokuElement(5));
        row1.add(new SudokuElement(4));
        row1.add(new SudokuElement(3));
        row1.add(new SudokuElement(-1));
        row1.add(new SudokuElement(2));
        row1.add(new SudokuElement(1));
        List<SudokuRow> sudokuRows = new ArrayList<>();
        sudokuRows.add(new SudokuRow(row1));
        SudokuBoards sudokuBoards = new SudokuBoards(sudokuRows);
        return sudokuBoards;
    }
}
