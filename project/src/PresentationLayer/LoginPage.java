package PresentationLayer;

import net.miginfocom.swing.MigLayout;


import java.awt.*;
import javax.swing.*;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import BusinessLogicLayer.LoginService;
import CustomException.AuthenticationException;
import javaswingdev.drawer.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LoginPage {

	private DrawerController drawer;
	private DrawerController drawer2;
	private LoginService loginService;
	private JFrame frame;
	private JTextField emailTextField;
	private JTextField passTextField;
	private JPanel loginPanel;
	private JPanel panel_1;
	private JPanel sidePanel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel emailLbl;
	private JLabel passwordLbl;
	private JCheckBox rememberMeCheck;
	private JButton loginBtn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {
					    UIManager.setLookAndFeel( new FlatLightLaf() );
					} catch( Exception ex ) {
					    System.err.println( "Failed to initialize LaF" );
					}
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws AuthenticationException 
	 * @throws HeadlessException 
	 */
	public LoginPage() throws HeadlessException, AuthenticationException {
		loginService = new LoginService();
		initialize();
		drawer = Drawer.newDrawer(frame)
				.drawerWidth(400)
				.header(new Register())
				.leftDrawer(false)
				.build();
		
		
		 if(loginService.autoLogin())
	        {
				JOptionPane.showMessageDialog(null, "Logged In Successfully !");
	        }
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 839, 552);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		loginPanel = new JPanel();
		loginPanel.setBackground(new Color(96, 108, 56));
		frame.getContentPane().add(loginPanel, "name_8185318832800");
		loginPanel.setLayout(new MigLayout("", "[][10px][grow][][][][][][][][][][][][][][]", "[10px][grow][grow][][][][][][][][][][][][][][][][][]"));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(166, 138, 100));
		loginPanel.add(panel_1, "flowx,cell 9 0 8 20,grow");
		panel_1.setLayout(new MigLayout("", "[][][][][][][][][][][][]", "[][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("\u062A\u0633\u062C\u064A\u0644 \u0627\u0644\u062F\u062E\u0648\u0644");
		panel_1.add(lblNewLabel, "cell 11 3,alignx center");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		emailLbl = new JLabel("\u0628\u0631\u064A\u062F \u0625\u0644\u0643\u062A\u0631\u0648\u0646\u064A");
		emailLbl.setHorizontalAlignment(SwingConstants.CENTER);
		emailLbl.setForeground(Color.WHITE);
		emailLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(emailLbl, "cell 11 6,alignx right");
		
		emailTextField = new JTextField();
		panel_1.add(emailTextField, "cell 11 7,alignx center");
		emailTextField.setColumns(30);
		
		passwordLbl = new JLabel("\u0643\u0644\u0645\u0629 \u0627\u0644\u0645\u0631\u0648\u0631");
		passwordLbl.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLbl.setForeground(Color.WHITE);
		passwordLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(passwordLbl, "cell 11 10,alignx right");
		
		passTextField = new JTextField();
		panel_1.add(passTextField, "cell 11 11,alignx center");
		passTextField.setColumns(30);
		
		rememberMeCheck = new JCheckBox("\u062A\u0633\u062C\u064A\u0644 \u0627\u0644\u062F\u062E\u0648\u0644 \u0627\u0644\u062A\u0644\u0642\u0627\u0626\u064A");
		panel_1.add(rememberMeCheck, "flowx,cell 11 14,alignx right");
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBackground(Color.WHITE);
		panel_1.add(btnNewButton, "cell 11 14,alignx right");
		
		loginBtn = new JButton("\u062A\u0633\u062C\u064A\u0644 \u0627\u0644\u062F\u062E\u0648\u0644");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean rememberMe = rememberMeCheck.isEnabled();
		        /*boolean isAuthenticated = loginService.login(emailTextField.getText(),passTextField.getText());
				
		        if(isAuthenticated){
		        	if(rememberMe) {
		        		loginService.rememberMe(emailTextField.getText(),passTextField.getText(), rememberMe);
		        	}
					JOptionPane.showMessageDialog(null, "Logged In Successfully !");
				}
				
			}
		});*/
				 try {
			            boolean isAuthenticated = loginService.login(emailTextField.getText(), passTextField.getText());

			            if (isAuthenticated) {
			                if (rememberMe) {
			                    loginService.rememberMe(emailTextField.getText(), passTextField.getText(), rememberMe);
			                }
			                JOptionPane.showMessageDialog(null, "Logged In Successfully !");
			            }
			        } catch (AuthenticationException ex) {
			            // Handle the authentication exception (e.g., show an error dialog or log the error)
			            ex.printStackTrace();
			        }
			    }
			});
		loginBtn.setBackground(Color.WHITE);
		panel_1.add(loginBtn, "cell 11 17 1 2,growx,aligny bottom");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(drawer.isShow()) {
					drawer.hide();
				}
				else
					drawer.show();
			}
		});
		
		sidePanel = new JPanel();
		sidePanel.setBackground(new Color(88, 47, 14));
		loginPanel.add(sidePanel, "cell 0 0 9 20,grow");
		sidePanel.setLayout(new MigLayout("", "[46px][][][][][][][][]", "[14px][][][][][][][][][][][][]"));
		
		lblNewLabel_2 = new JLabel("\u062A\u062E\u0631\u064A\u062C \u0645\u0633\u0627\u0639\u062F");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		sidePanel.add(lblNewLabel_2, "cell 4 2,growx");
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginPage.class.getResource("/Image/bookImg.jpg")));
		sidePanel.add(lblNewLabel_1, "cell 4 6,growx,aligny top");
		
		lblNewLabel_3 = new JLabel("\u062A\u062C\u0639\u0644 \u0627\u0644\u062A\u062E\u0631\u064A\u062C \u0623\u0633\u0647\u0644 \u0645\u0646 \u0623\u064A \u0648\u0642\u062A \u0645\u0636\u0649");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		sidePanel.add(lblNewLabel_3, "cell 4 8");
	}

}

class ImagePanel extends JPanel {
    private Image backgroundImage;

    public ImagePanel(String imagePath) {
        this.backgroundImage = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image at (0, 0) with the size of the panel
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}