package helpers;


public class RandomStudentDataGenerator {
    DataStudentHelper dataStudentHelper = new DataStudentHelper();
    public final String
            firstName = dataStudentHelper.generateFirstName(),
            lastName = dataStudentHelper.generateLastName(),
            userEmail = dataStudentHelper.generateEmail(),
            gender = dataStudentHelper.generateGender(),
            phone = dataStudentHelper.generatePhone(10),
            subjects = dataStudentHelper.getSubject(),
            hobby = dataStudentHelper.getHobby(),
            fileName = dataStudentHelper.getFilename(),
            address = dataStudentHelper.generateFullAddress(),
            state = dataStudentHelper.getState(),
            city = dataStudentHelper.getCity(state);
    public final String[] dateOfBirth = dataStudentHelper.generateDateOfBirthFaker();

}