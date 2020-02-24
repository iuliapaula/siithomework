package exceptions_and_logging;

import java.time.LocalDate;

public class Student{
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String cnp;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String gender, String cnp)  throws CustomValidationException {
        if (firstName == null || firstName.trim().equals("")) {
            throw new CustomValidationException("First name is empty");
        }
        if (lastName == null || lastName.trim().equals("")) {
            throw new CustomValidationException("Last name is empty");
        }
        if (!gender.toUpperCase().equals("MALE") && !gender.toUpperCase().equals("FEMALE")) {
            throw new CustomValidationException("Invalid gender entered; valid values are MALE or FEMALE");
        }
        if (!validateAgeAbove18(dateOfBirth)) {
            throw new CustomValidationException("Invalid date of birth entered. Age should be above 18");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender.toUpperCase();
        this.cnp = cnp;
    }


    private boolean validateAgeAbove18 (LocalDate dateOfBirth) {
        if (dateOfBirth.getYear() < 1900) {
            return false;
        }
        return dateOfBirth.getYear() <= LocalDate.now().getYear() - 18;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getCnp() {
        return cnp;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender=" + gender +
                ", cnp='" + cnp + '\'' +
                '}';
    }
}
