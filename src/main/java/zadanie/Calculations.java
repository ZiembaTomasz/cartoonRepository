package zadanie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Calculations {

    public double calculateBestAverage(Map<Student, Grades> scores) {
        double best = 0.0;
        for (Grades grades: scores.values()) {
            double avg = getAvg(grades);
            if (avg > best) {
                best = avg;
            }
        }
        return best;
    }

    public List<String> findStudentsNamesWithBestAverage(Map<Student, Grades> scores) {
        List<String> bestStudents = new ArrayList<>();
        double best = calculateBestAverage(scores);
        for (Map.Entry<Student, Grades> entry: scores.entrySet()) {
            double avg = getAvg(entry.getValue());
            if (best == avg) {
                bestStudents.add(entry.getKey().getFirstName() + " " + entry.getKey().getLastName());
            }
        }
        return bestStudents;
    }

    public List<Student> findStudentsWhichSpeakPolishWithAverageFromMathAbove4(Map<Student, Grades> scores) {
        List<Student> students = new ArrayList<>();
        for (Map.Entry<Student, Grades> entry: scores.entrySet()) {
            if ("PL".equals(entry.getKey().getLanguage())) {
                double avgMath = sum(entry.getValue().getMaths());
                if (avgMath >= 0) {
                    students.add(entry.getKey());
                }
            }
        }
        return students;
    }

    private double getAvg(Grades grades) {
        double suma = 0.0;
        suma += sum(grades.getEnglish());
        suma += sum(grades.getMaths());
        suma += sum(grades.getPhysics());
        double ilosc = grades.getEnglish().size() + grades.getMaths().size() + grades.getPhysics().size();
        return suma / ilosc;
    }


    private int sum(List<Integer> grades) {
        int sum = 0;
        for (int grade: grades) {
            sum += grade;
        }
        return sum;
    }
}
