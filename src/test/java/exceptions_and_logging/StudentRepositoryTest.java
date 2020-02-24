package exceptions_and_logging;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class StudentRepositoryTest {
StudentRepository studentRepository = new StudentRepository();

@Test
public void testAddStudentWithIncorrectGender() {
    int oldSize = studentRepository.getStudentRepository().size();
    studentRepository.addStudent("Maria", "Ana", LocalDate.of(2000, 12, 10), "Femle", "1234567891234");
    assertEquals(oldSize, studentRepository.getStudentRepository().size());
}

@Test(expected = CustomValidationException.class)
    public void testDeleteStudentWithIncorrectCnp() {
    studentRepository.deleteStudent("1234567891234");
}

@Test(expected = CustomValidationException.class)
    public void testRetrieveStudentsByInvalidAge() {
    studentRepository.retrieveStudentsOfAge(-2);
}
}
