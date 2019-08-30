package pl.tomaszziemba.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuGame {
    public static void main(String[] args) {


        SudokuBoards table;

        table = new SudokuGame().createTable();
        SudokuGame sudokuGame = new SudokuGame();
        sudokuGame.sudokuAlgorithm(table);
        printTable(table);
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

    private boolean resolveSudoku(SudokuBoards sudokuBoards) {
        List<Integer> noEmpty = new ArrayList<>();

        for (int x = 0; x < sudokuBoards.getRows().size(); x++) {
            for (int y = 0; y < sudokuBoards.getRows().size(); y++) {
                SudokuElement checkedElement = sudokuBoards.getRows().get(x).getElements().get(y);
                if (checkedElement.getValue() != 0) {
                    noEmpty.add(checkedElement.getValue());
                    if (noEmpty.size() == 81) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public SudokuBoards sudokuAlgorithm(SudokuBoards sudokuBoards) {
        int counter = 0;
        while (!resolveSudoku(sudokuBoards)) {

            if (counter++ > 100) {
                break;
            }
            for (SudokuRow row : sudokuBoards.getRows()) {
                clearRow(row);
                clearColumns(sudokuBoards, row);
            }
            clearSquare(sudokuBoards);
        }
        return sudokuBoards;
    }

    public void clearRow(SudokuRow row) {
        for (int i = 0; i < row.getElements().size(); i++) {
            SudokuElement myElement = row.getElements().get(i);
            clearElementsForRow(row, myElement);
        }
    }

    public void clearColumns(SudokuBoards sudokuBoards, SudokuRow row) {
        for (int i = 0; i < row.getElements().size(); i++) {
            SudokuElement myElement = row.getElements().get(i);
            clearElementsForColumn(sudokuBoards, i, myElement);
        }
    }

    public void clearElementsForColumn(SudokuBoards sudokuBoards, int i, SudokuElement myElement) {
        if (myElement.isEmpty()) {
            for (SudokuRow row1 : sudokuBoards.getRows()) {
                SudokuElement nextElement = row1.getElements().get(i);
                myElement.removePossibleValue(nextElement);
            }
            myElement.expectedValue();

        }
    }

    public void clearElementsForRow(SudokuRow row, SudokuElement myElement) {
        if (myElement.isEmpty()) {
            removeElements(myElement, row.getElements());
            myElement.expectedValue();
        }
    }

    public void clearSquare(SudokuBoards sudokuBoards) {

        for (int i = 0; i < sudokuBoards.getRows().size(); i++) {
            SudokuRow row = sudokuBoards.getRows().get(i);

            for (int j = 0; j < row.getElements().size(); j++) {

                int a = i / 3 * 3;
                int b = j / 3 * 3;
                SudokuElement checkedElement = row.getElements().get(j);
                if (checkedElement.isEmpty()) {
                    List<SudokuElement> squareElements = getElementsForSquare(sudokuBoards, a, b);
                    removeElements(checkedElement, squareElements);
                }

            }
        }

    }

    public List<SudokuElement> getElementsForSquare(SudokuBoards sudokuBoards, int a, int b) {
        List<SudokuElement> squareElements = new ArrayList<>();
        for (int n = a; n <= a + 2; n++) {
            for (int m = b; m <= b + 2; m++) {
                SudokuElement elementToRemove = sudokuBoards.getRows().get(n).getElements().get(m);
                squareElements.add(elementToRemove);

            }
        }
        return squareElements;
    }

    public void removeElements(SudokuElement checkedElement, List<SudokuElement> elementsToRemove) {
        for (SudokuElement elementToRemove : elementsToRemove) {
            checkedElement.removePossibleValue(elementToRemove);
        }
    }

    private SudokuBoards createTable() {
        List<SudokuElement> row1 = new ArrayList<>();
        row1.add(new SudokuElement(0));
        row1.add(new SudokuElement(0));
        row1.add(new SudokuElement(2));
        row1.add(new SudokuElement(0));
        row1.add(new SudokuElement(5));
        row1.add(new SudokuElement(0));
        row1.add(new SudokuElement(6));
        row1.add(new SudokuElement(9));
        row1.add(new SudokuElement(7));
        List<SudokuElement> row2 = new ArrayList<>();
        row2.add(new SudokuElement(0));
        row2.add(new SudokuElement(1));
        row2.add(new SudokuElement(0));
        row2.add(new SudokuElement(0));
        row2.add(new SudokuElement(0));
        row2.add(new SudokuElement(7));
        row2.add(new SudokuElement(3));
        row2.add(new SudokuElement(0));
        row2.add(new SudokuElement(0));
        List<SudokuElement> row3 = new ArrayList<>();
        row3.add(new SudokuElement(3));
        row3.add(new SudokuElement(0));
        row3.add(new SudokuElement(0));
        row3.add(new SudokuElement(0));
        row3.add(new SudokuElement(6));
        row3.add(new SudokuElement(0));
        row3.add(new SudokuElement(0));
        row3.add(new SudokuElement(8));
        row3.add(new SudokuElement(0));
        List<SudokuElement> row4 = new ArrayList<>();
        row4.add(new SudokuElement(9));
        row4.add(new SudokuElement(2));
        row4.add(new SudokuElement(0));
        row4.add(new SudokuElement(0));
        row4.add(new SudokuElement(0));
        row4.add(new SudokuElement(5));
        row4.add(new SudokuElement(0));
        row4.add(new SudokuElement(0));
        row4.add(new SudokuElement(8));
        List<SudokuElement> row5 = new ArrayList<>();
        row5.add(new SudokuElement(0));
        row5.add(new SudokuElement(4));
        row5.add(new SudokuElement(5));
        row5.add(new SudokuElement(3));
        row5.add(new SudokuElement(0));
        row5.add(new SudokuElement(2));
        row5.add(new SudokuElement(9));
        row5.add(new SudokuElement(1));
        row5.add(new SudokuElement(0));
        List<SudokuElement> row6 = new ArrayList<>();
        row6.add(new SudokuElement(1));
        row6.add(new SudokuElement(0));
        row6.add(new SudokuElement(0));
        row6.add(new SudokuElement(9));
        row6.add(new SudokuElement(0));
        row6.add(new SudokuElement(0));
        row6.add(new SudokuElement(0));
        row6.add(new SudokuElement(5));
        row6.add(new SudokuElement(2));
        List<SudokuElement> row7 = new ArrayList<>();
        row7.add(new SudokuElement(0));
        row7.add(new SudokuElement(3));
        row7.add(new SudokuElement(0));
        row7.add(new SudokuElement(0));
        row7.add(new SudokuElement(2));
        row7.add(new SudokuElement(0));
        row7.add(new SudokuElement(0));
        row7.add(new SudokuElement(0));
        row7.add(new SudokuElement(5));
        List<SudokuElement> row8 = new ArrayList<>();
        row8.add(new SudokuElement(0));
        row8.add(new SudokuElement(0));
        row8.add(new SudokuElement(1));
        row8.add(new SudokuElement(7));
        row8.add(new SudokuElement(0));
        row8.add(new SudokuElement(0));
        row8.add(new SudokuElement(0));
        row8.add(new SudokuElement(4));
        row8.add(new SudokuElement(0));
        List<SudokuElement> row9 = new ArrayList<>();
        row9.add(new SudokuElement(6));
        row9.add(new SudokuElement(9));
        row9.add(new SudokuElement(4));
        row9.add(new SudokuElement(0));
        row9.add(new SudokuElement(8));
        row9.add(new SudokuElement(0));
        row9.add(new SudokuElement(2));
        row9.add(new SudokuElement(0));
        row9.add(new SudokuElement(0));
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
        row1.add(new SudokuElement(0));
        row1.add(new SudokuElement(2));
        row1.add(new SudokuElement(1));
        List<SudokuRow> sudokuRows = new ArrayList<>();
        sudokuRows.add(new SudokuRow(row1));
        SudokuBoards sudokuBoards = new SudokuBoards(sudokuRows);
        return sudokuBoards;
    }
}
