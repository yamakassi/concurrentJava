package sync;

import java.util.Objects;

public class Student {
    private int id;
    private int score;


    public Student(int id) {
        this.id = id;
    }

    public Student(int id, int score) {
        this.id = id;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && score == student.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, score);
    }
}