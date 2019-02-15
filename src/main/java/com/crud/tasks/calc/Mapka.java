package com.crud.tasks.calc;

import java.util.Objects;

public class Mapka {
    String name;
    public Mapka(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mapka mapka = (Mapka) o;
        return Objects.equals(name, mapka.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Student "+ name;
    }
}
