package pl.tomaszziemba.sudoku;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class SudokuBoards {
    private List<SudokuRow>rows = new ArrayList<>();

}
