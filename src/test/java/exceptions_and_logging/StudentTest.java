package exceptions_and_logging;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class StudentTest {

    @Test(expected = CustomValidationException.class)
    public void createStudentWithInvalidFirstName() {
        Student student = new Student("", "Maria", LocalDate.of(2000,12,23), "Female", "1234567891234");
    }

    @Test(expected = CustomValidationException.class)
    public void createStudentWithInvalidSecondName() {
        Student student = new Student("Ana", "", LocalDate.of(2000,12,23), "Female", "1234567891234");
    }

    @Test(expected = CustomValidationException.class)
    public void createStudentWithInvalidBirthdate() {
        Student student = new Student("Ana", "Maria", LocalDate.now().plusDays(1), "Female", "1234567891234");
    }

    @Test(expected = CustomValidationException.class)
    public void createStudentWithInvalidBirthdate2() {
        Student student = new Student("Ana", "Maria", LocalDate.of(1899, 12, 31), "Female", "1234567891234");
    }

    @Test(expected = CustomValidationException.class)
    public void createStudentWithInvalidGender() {
        Student student = new Student("Ana", "Maria", LocalDate.of(2000,12,23), "Fmale", "1234567891234");
    }

}
