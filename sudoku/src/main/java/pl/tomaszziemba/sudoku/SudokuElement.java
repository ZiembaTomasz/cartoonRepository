package pl.tomaszziemba.sudoku;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter

public class SudokuElement {
    public static final int EMPTY = 0;

    private int value;
    private List<Integer> possibleValues = new ArrayList<>();

    public SudokuElement(int value) {
        this.value = value;
        for(int i = 1; i<10; i++){
            possibleValues.add(i);
        }

    }

    public void expectedValue() {
        if(getPossibleValues().size() == 1 ){
            int x = getPossibleValues().get(0);
            value = x;
        }
    }

    public boolean isEmpty(){
        return value == EMPTY;
    }
    public void removePossibleValue( SudokuElement checkedElement) {
        if(checkedElement.getValue() != -1){
            possibleValues.remove(Integer.valueOf(checkedElement.getValue()));
        }
    }

}
