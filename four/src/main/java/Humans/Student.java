package Humans;

import java.util.Objects;

public class Student extends Human {
    private String university;
    private String faculty;
    private String specialization;

    public Student(String surname, String name, String patronymic, int year, Gender gender,
                   String university, String faculty, String specialization) throws BadYearException {
        super(surname, name, patronymic, year, gender);
        this.faculty = faculty;
        this.university = university;
        this.specialization = specialization;
    }

    public Student(Student Vasya) throws BadYearException {
        super(Vasya);
        this.faculty = Vasya.faculty;
        this.university = Vasya.university;
        this.specialization = Vasya.specialization;
    }

    public String getUniversity(){
        return university;
    }

    public void setUniversity(String university){
        this.university = university;
    }

    public String getFaculty(){
        return faculty;
    }

    public void setFaculty(String faculty){
        this.faculty = faculty;
    }

    public String getSpecialization(){
        return specialization;
    }

    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(university, student.university) &&
                Objects.equals(faculty, student.faculty) &&
                Objects.equals(specialization, student.specialization);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), university, faculty, specialization);
    }
}
