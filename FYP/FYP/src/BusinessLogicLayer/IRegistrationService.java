/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BusinessLogicLayer;

import CustomException.RegisterationException;

/**
 *
 * @author Remal
 */
public interface IRegistrationService {

    boolean confirmPass(String pass, String confirmPass);

    boolean isEmailRegistered(String email);

    boolean isValidVerificationCode(String verificationCode);

    boolean registerUser(String name, String email, String password, String phoneNumber, String verificationCode) throws RegisterationException;

    void userAlreadyExists(String email) throws RegisterationException;

    boolean validateFields(String name, String email, String phone, String password, String confirmPassword) throws RegisterationException;
    
}
