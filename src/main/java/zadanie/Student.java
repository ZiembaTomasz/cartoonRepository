package zadanie;

public class Student {
    private String firstName;
    private String lastName;
    private String language;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String firstName, String lastName, String language) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.language = language;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Student student = (Student) o;

        if (!firstName.equals(student.firstName))
            return false;
        if (!lastName.equals(student.lastName))
            return false;
        return language != null ? language.equals(student.language) : student.language == null;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  firstName + " " + lastName + " " + language;
    }
}
