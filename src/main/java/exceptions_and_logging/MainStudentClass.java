package exceptions_and_logging;

import java.time.LocalDate;

public class MainStudentClass {
    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        System.out.println("Test add===============================");
        studentRepository.addStudent("Ana", "Maria", LocalDate.of(2001, 12, 10), "Female", "11143232");
        studentRepository.addStudent("Ion", "Ion", LocalDate.of(2000, 12, 10), "Male", "343232");
        studentRepository.getStudentRepository().forEach(System.out::println);
        System.out.println("Test retrieve============================");
        studentRepository.retrieveStudentsOfAge(18);
        System.out.println("Test delete==========================");
        studentRepository.deleteStudent("343232");
        studentRepository.getStudentRepository().forEach(System.out::println);
    }
}
