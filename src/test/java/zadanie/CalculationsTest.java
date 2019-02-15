package zadanie;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculationsTest {
    private Map<Student, Grades> prepareData() {
        Map<Student, Grades> entries = new HashMap<>();
        List<Integer> example1 = Arrays.asList(2, 3, 4, 5, 1);
        List<Integer> example2 = Arrays.asList(2, 5, 5, 5, 5);
        List<Integer> example3 = Arrays.asList(2, 3, 4, 5, 5, 5, 2);
        entries.put(new Student("Jan", "Kowalski"), new Grades(example1, example2, example3));
        entries.put(new Student("Magda", "Nowak", "EN"), new Grades(example3, example3, example1));
        entries.put(new Student("Kamila", "Los", "PL"), new Grades(example2, example2, example3));
        return entries;
    }

    @Test
    public void testCalculateBestAverage() {
        //given
        Calculations calculations = new Calculations();
        Map<Student, Grades> entries = prepareData();

        //when
        double result = calculations.calculateBestAverage(entries);

        //then
        Assert.assertEquals(4.117, result, 0.001);
    }

    @Test
    public void testFindStudentsNamesWithBestAverage() {
        //given
        Calculations calculations = new Calculations();
        Map<Student, Grades> entries = prepareData();

        //when
        List<String> studentsNamesWithBestAverage = calculations.findStudentsNamesWithBestAverage(entries);

        //then
        Assert.assertEquals(1, studentsNamesWithBestAverage.size());
        Assert.assertEquals("Kamila Los", studentsNamesWithBestAverage.get(0));
    }

    @Test
    public void findStudentsWhichSpeakPolishWithAverageFromMathAbove4() {
        //given
        Calculations calculations = new Calculations();
        Map<Student, Grades> entries = prepareData();

        //when
        List<Student> result = calculations.findStudentsWhichSpeakPolishWithAverageFromMathAbove4(entries);

        //then
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("Los", result.get(0).getLastName());
    }
}
