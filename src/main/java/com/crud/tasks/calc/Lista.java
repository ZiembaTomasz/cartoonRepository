package com.crud.tasks.calc;

import java.time.LocalDateTime;

abstract class Lista {
    abstract void calculate();

    public static void main(String[] args) {
        System.out.println("calculating");
        Lista x = null;
        x.calculate();
    }
}

//    Task description
//    Celem zadania jest dodanie implementacji metod w klasie Calculations.
//        Każda z metod przyjmuje mapę Map<Student, Grades> - kluczem jest obiekt typu Student, wartością jest obiekt typu Grades.
//        W klasie Student znajdują się dane studenta takie jak imię, nazwisko i wartość opcjonalna - język, jakim student się płynnie posługuje.
//        W klasie Grades znajdują się listy ocen z poszczególnych przedmiotów.
//
//        Metody z klasy Calculations:
//
//        calculateBestAverage - wyszukuje najlepszą średnią. Jeśli dany uczeń otrzymał oceny tylko z dwóch przedmiotów, średnia liczona jest na podstawie tylko tych dwóch list.
//        Przykład:
//        Oceny ucznia A z matematyki: 4, 4, 4.
//        Oceny ucznia A z fizyki: 3, 4, 2.
//        Oceny ucznia B z matematyki: 3, 5, 3.
//        Oceny ucznia B z języka angielskiego: 3, 3.
//        Oceny ucznia B z fizyki: 5, 2.
//        Średnia ocen ucznia A: (4 + 4 + 4 + 3 + 4 + 2) / 6 = 3.5
//        Średnia ocen ucznia b: (3 + 5 + 3 + 3 + 3 + 5 + 2) / 7 = 3.43
//        Wynik: 3.5.
//
//        findStudentsNamesWithBestAverage - zwraca listę studentów (String w formacie "imię nazwisko), którzy mają najwyższą średnią. Jest to lista, ponieważ kilku studentów może mieć taką samą średnią. Jeśli żaden student nie ma oceny (średnia 0.0), powinna być zwrócona pusta lista.
//
//        findStudentsWhichSpeakPolishWithAverageFromMathAbove4 - zwraca listę obiektów typu Student, którzy płynnie posługują się językiem polskim oraz ich średnia ocen z matematyki jest wyższa od 4.0.
//
//        Implementację należy dodać w klasie Calculations, można także dodać własne metody do klas Student i Grades.
//        Przed przystąpieniem do zadania, należy się zapoznać z całym kodem łącznie z testami.

