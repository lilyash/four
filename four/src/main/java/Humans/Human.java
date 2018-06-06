package Humans;

import java.util.Objects;

public class Human {
    private String surname;
    private String name;
    private String patronymic;
    private int year;
    private Gender gender;

    public static final int CURRENT_YEAR = 2018;

    public Human(String surname, String name, String patronymic, int year, Gender gender) throws BadYearException {
        if(year<0 || year>CURRENT_YEAR){
            throw new BadYearException();
        }
        this.gender = gender;
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.year = year;
    }

    public Human(Human Jhonny){
        this.year = Jhonny.year;
        this.surname = Jhonny.surname;
        this.patronymic = Jhonny.patronymic;
        this.name = Jhonny.name;
        this.gender = Jhonny.gender;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getPatronymic(){
        return patronymic;
    }

    public void setPatronymic(String patronymic){
        this.patronymic = patronymic;
    }

    public int getYear(){
        return year;
    }
    public int getAge(){
        return CURRENT_YEAR - this.year;
    }

    public void setYear(int year)throws BadYearException{
        if(year<0 || year>CURRENT_YEAR){
            throw new BadYearException();
        }
        this.year = year;
    }

    public Gender getGender(){
        return gender;
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year &&
                Objects.equals(surname, human.surname) &&
                Objects.equals(name, human.name) &&
                Objects.equals(patronymic, human.patronymic) &&
                gender == human.gender;
    }

    @Override
    public int hashCode() {

        return Objects.hash(surname, name, patronymic, year, gender);
    }
}
