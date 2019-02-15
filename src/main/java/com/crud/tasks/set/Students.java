package com.crud.tasks.set;

import java.util.Objects;

public class Students {
    String title;
    String author;
    int year;

    public Students(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return year == students.year &&
                Objects.equals(title, students.title) &&
                Objects.equals(author, students.author);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return "Book" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
