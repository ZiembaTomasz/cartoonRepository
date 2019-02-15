package pl.tomaszziemba.sudoku;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class SudokuRow {
    private List<SudokuElement>elements = new ArrayList<>();
}
