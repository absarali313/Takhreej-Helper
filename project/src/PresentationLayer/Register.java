package PresentationLayer;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import TransferObjects.User;
import BusinessLogicLayer.EmailService;
import BusinessLogicLayer.RegistrationService;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nameTextField;
	private JTextField emailTextField;
	private JTextField phoneTextField;
	private JPasswordField passTextField;
	private JPasswordField confirmTextField;
	private JTextField otpTextField;
	private JButton submitOtp;
	private RegistrationService registerService;
	private JTextField otptextField;
	/**
	 * Create the panel.
	 */
	public Register() {
		registerService = new RegistrationService();
		setBackground(new Color(101, 109, 74));
		setLayout(new MigLayout("", "[][][][][][][grow][grow]", "[][][][][][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("\u0627\u0634\u062A\u0631\u0627\u0643");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		add(lblNewLabel, "cell 6 2,alignx center");
		
		otpTextField = new JTextField(25);
		
		JLabel nameLbl = new JLabel("\u0627\u0633\u0645");
		nameLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nameLbl.setForeground(Color.WHITE);
		add(nameLbl, "cell 6 4,alignx right");
		
		nameTextField = new JTextField();
		add(nameTextField, "cell 6 5,alignx center");
		nameTextField.setColumns(25);
		
		JLabel emailLbl = new JLabel("\u0627\u0633\u0645\u0628\u0631\u064A\u062F \u0625\u0644\u0643\u062A\u0631\u0648\u0646\u064A");
		emailLbl.setForeground(Color.WHITE);
		emailLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(emailLbl, "cell 6 7,alignx right");
		
		emailTextField = new JTextField();
		emailTextField.setColumns(25);
		add(emailTextField, "cell 6 8,alignx center");
		
		JLabel emailLbl_1 = new JLabel("\u0647\u0627\u062A\u0641");
		emailLbl_1.setForeground(Color.WHITE);
		emailLbl_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(emailLbl_1, "cell 6 10,alignx right");
		
		phoneTextField = new JTextField();
		phoneTextField.setColumns(25);
		add(phoneTextField, "cell 6 11,alignx center");
		
		JLabel emailLbl_1_1 = new JLabel("\u0643\u0644\u0645\u0629 \u0627\u0644\u0645\u0631\u0648\u0631");
		emailLbl_1_1.setForeground(Color.WHITE);
		emailLbl_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(emailLbl_1_1, "cell 6 13,alignx right");
		
		passTextField = new JPasswordField();
		passTextField.setColumns(25);
		add(passTextField, "cell 6 14,alignx center");
		
		JLabel emailLbl_1_1_1 = new JLabel("\u062A\u0623\u0643\u064A\u062F \u0643\u0644\u0645\u0629 \u0627\u0644\u0645\u0631\u0648\u0631");
		emailLbl_1_1_1.setForeground(Color.WHITE);
		emailLbl_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(emailLbl_1_1_1, "cell 6 16,alignx right");
		
		confirmTextField = new JPasswordField();
		confirmTextField.setColumns(25);
		add(confirmTextField, "cell 6 17,alignx center");
		
		JButton submitBtn = new JButton("يُقدِّم");
		submitBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(submitBtn, "cell 6 22,alignx center");
		submitBtn.setVisible(false);
		
		JButton registerBtn = new JButton("الحصول على رمز التحقق");
		registerBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(registerService.validateFields(nameTextField.getText(),emailTextField.getText(),phoneTextField.getText(),passTextField.getText(),confirmTextField.getText())) {
					System.out.println("Sending Email");
					EmailService emailService = new EmailService();
					if(emailService.sendVerificationEmail(emailTextField.getText()))
					{
						otptextField.setVisible(true);
						submitBtn.setVisible(true);
						
					}
					
					else {
						
						JOptionPane.showMessageDialog(null, "Email failed to send! Make sure you entered the correct email. ");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Please fill all fields");
				}
			}
			
		});
		add(registerBtn, "cell 6 19,alignx center,growy");
		
		otptextField = new JTextField();
		otptextField.setColumns(25);
		add(otptextField, "cell 6 21,alignx center");
		otptextField.setVisible(false);
		
		
		
		submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(registerService.registerUser(nameTextField.getText(), emailTextField.getText(), passTextField.getText(), phoneTextField.getText(), otpTextField.getText())) {
					JOptionPane.showMessageDialog(null, "Registered Successfully! Please Login ");
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid user information or verification code. Registration failed.");
				}
			}
				
			
		});

	}


}
