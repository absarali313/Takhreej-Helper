/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BusinessLogicLayer;

import CustomException.EmailServiceException;

/**
 *
 * @author Remal
 */
public interface IEmailService {

    // Existing code for generating verification code
    String generateVerificationCode();

    // Method for sending random OTP for forgot password
    String sendForgotPasswordOTP(String recipientEmail) throws EmailServiceException;

    // Method for sending verification code for user registration
    boolean sendVerificationEmail(String recipientEmail) throws EmailServiceException;

    boolean verifyCode(String userEnteredCode);
    
}
