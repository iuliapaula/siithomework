package exceptions_and_logging;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StudentRepository {
    private static Logger logger = Logger.getLogger(StudentRepository.class.getName());
    List<Student> studentRepository = new ArrayList<>();

    public void addStudent(String firstName, String lastName, LocalDate dateOfBirth, String gender, String cnp) {
        try {
            studentRepository.add(new Student(firstName, lastName, dateOfBirth, gender, cnp));
        } catch (CustomValidationException e) {
//            e.printStackTrace();
            logger.log(Level.SEVERE, "Validation error while trying to create a new student.", e);
//            System.out.println(e.getMessage());
        }
    }

    public void deleteStudent(String cnp) throws CustomValidationException {
        if (!isCnpToRemoveValid(cnp)) {
            throw new CustomValidationException("Invalid CNP; no records found in the Student repository for the provided CNP");
        }

        for (int i = 0; i < studentRepository.size(); i++) {
            if (studentRepository.get(i).getCnp().equals(cnp)) {
                studentRepository.remove(studentRepository.get(i));
                i--;
            }
        }
    }

    public void retrieveStudentsOfAge(int age) throws CustomValidationException {
        if (age < 0) {
            throw new CustomValidationException("Invalid age; less than 0");
        }
        for (Student student : studentRepository) {
            if (getAge(student.getDateOfBirth()) == age) {
                System.out.println(student.toString());
            }
        }
    }

    public List<Student> getStudentRepository() {
        return studentRepository;
    }

    private boolean isCnpToRemoveValid(String cnp) {
        if (cnp == null || cnp.trim().equals("")) {
            return false;
        }
        for (Student student : studentRepository) {
            if (cnp.equals(student.getCnp())) {
                return true;
            }
        }
        return false;
    }

    private int getAge(LocalDate dateOfBirth) {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}
