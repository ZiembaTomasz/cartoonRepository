package pl.sudoku;

import org.junit.Test;
import pl.tomaszziemba.sudoku.SudokuBoards;
import pl.tomaszziemba.sudoku.SudokuElement;
import pl.tomaszziemba.sudoku.SudokuGame;
import pl.tomaszziemba.sudoku.SudokuRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
public class SudokuGameTest {
    @Test
    public void testClearRow(){
        //Given
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
        List<SudokuRow>sudokuRows = new ArrayList<>();
        sudokuRows.add(new SudokuRow(row1));
        SudokuBoards sudokuBoards = new SudokuBoards(sudokuRows);
        SudokuGame sudokuGame = new SudokuGame();
        //When
        sudokuGame.sudokuAlgorithm(sudokuBoards);
        //Then
        assertEquals(9,row1.get(0).getValue());
        assertEquals(8,row1.get(1).getValue());
        assertEquals(6,row1.get(2).getValue());
        assertEquals(5,row1.get(3).getValue());
        assertEquals(4,row1.get(4).getValue());
        assertEquals(3,row1.get(5).getValue());
        assertEquals(7,row1.get(6).getValue());
        assertEquals(2,row1.get(7).getValue());
        assertEquals(1,row1.get(8).getValue());


    }

        @Test
    public void createTestTableOne2(){
        //Given
        List<SudokuElement> row1 = new ArrayList<>();
        row1.add(new SudokuElement(0));
        row1.add(new SudokuElement(8));
        row1.add(new SudokuElement(6));
        row1.add(new SudokuElement(5));
        row1.add(new SudokuElement(4));
        row1.add(new SudokuElement(3));
        row1.add(new SudokuElement(0));
        row1.add(new SudokuElement(2));
        row1.add(new SudokuElement(1));
        List<SudokuRow>sudokuRows = new ArrayList<>();
        SudokuRow sudokuRow = new SudokuRow(row1);
        sudokuRows.add(new SudokuRow(row1));
        SudokuBoards sudokuBoards = new SudokuBoards(sudokuRows);
        SudokuGame sudokuGame = new SudokuGame();
        //When
        sudokuGame.clearRow(sudokuRow);
        //Then
        assertEquals(0,row1.get(0).getValue());
        assertEquals(8,row1.get(1).getValue());
        assertEquals(6,row1.get(2).getValue());
        assertEquals(5,row1.get(3).getValue());
        assertEquals(4,row1.get(4).getValue());
        assertEquals(3,row1.get(5).getValue());
        assertEquals(0,row1.get(6).getValue());
        assertEquals(2,row1.get(7).getValue());
        assertEquals(1,row1.get(8).getValue());


    }

    @Test
    public void createTestTableColumnOne1(){
        //Given
        List<SudokuRow>sudokuRows = new ArrayList<>();
        sudokuRows.add(new SudokuRow(asList(new SudokuElement(9))));
        sudokuRows.add(new SudokuRow(asList(new SudokuElement(8))));
        sudokuRows.add(new SudokuRow(asList(new SudokuElement(6))));
        sudokuRows.add(new SudokuRow(asList(new SudokuElement(5))));
        sudokuRows.add(new SudokuRow(asList(new SudokuElement(4))));
        sudokuRows.add(new SudokuRow(asList(new SudokuElement(3))));
        sudokuRows.add(new SudokuRow(asList(new SudokuElement(0))));
        sudokuRows.add(new SudokuRow(asList(new SudokuElement(2))));
        sudokuRows.add(new SudokuRow(asList(new SudokuElement(1))));
        SudokuBoards sudokuBoards = new SudokuBoards(sudokuRows);
        SudokuGame sudokuGame = new SudokuGame();
        //When
        sudokuGame.sudokuAlgorithm(sudokuBoards);
        //Then
        assertEquals(9,sudokuRows.get(0).getElements().get(0).getValue());
        assertEquals(8,sudokuRows.get(1).getElements().get(0).getValue());
        assertEquals(6,sudokuRows.get(2).getElements().get(0).getValue());
        assertEquals(5,sudokuRows.get(3).getElements().get(0).getValue());
        assertEquals(4,sudokuRows.get(4).getElements().get(0).getValue());
        assertEquals(3,sudokuRows.get(5).getElements().get(0).getValue());
        assertEquals(7,sudokuRows.get(6).getElements().get(0).getValue());
        assertEquals(2,sudokuRows.get(7).getElements().get(0).getValue());
        assertEquals(1,sudokuRows.get(8).getElements().get(0).getValue());


    }

}
