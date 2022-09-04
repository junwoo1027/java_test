package me.junwoo.javatest.junit;

public class Study {
    private StudyStatus studyStatus;
    private int limit  = -10;

    private String name;

    public Study() {
    }

    public Study(int limit) {
        if (limit < 0) throw new IllegalArgumentException("limit은 0보다 커야한다.");
        this.limit = limit;
    }

    public Study(int limit, String name) {
        if (limit < 0) throw new IllegalArgumentException("limit은 0보다 커야한다.");
        this.limit = limit;
        this.name = name;
    }

    public StudyStatus getStatus() {
        return this.studyStatus;
    }

    public int getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        return "Study{" +
                "studyStatus=" + studyStatus +
                ", limit=" + limit +
                ", name='" + name + '\'' +
                '}';
    }

    public StudyStatus getStudyStatus() {
        return studyStatus;
    }

    public String getName() {
        return name;
    }
}
