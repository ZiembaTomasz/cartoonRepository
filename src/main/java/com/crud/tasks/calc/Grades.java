package com.crud.tasks.calc;

public class Grades {
    int gradeOne;
    int gradeTwo;
    int gradeThree;

    public Grades(int gradeOne, int gradeTwo, int gradeThree) {
        this.gradeOne = gradeOne;
        this.gradeTwo = gradeTwo;
        this.gradeThree = gradeThree;
    }

    public int getGradeOne() {
        return gradeOne;
    }

    public int getGradeTwo() {
        return gradeTwo;
    }

    public int getGradeThree() {
        return gradeThree;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "gradeOne=" + gradeOne +
                ", gradeTwo=" + gradeTwo +
                ", gradeThree=" + gradeThree +
                '}';
    }
    public double getAverage(){
        double average = (gradeOne + gradeTwo + gradeThree) / 3;
        return average;
    }
}
