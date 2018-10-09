package subway.user.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LoginPage extends JFrame implements ActionListener {
	BufferedImage img = null;
	// Container con;
	JPanel jp = new JPanel();
	JPanel innerJp = new JPanel();
	ImageIcon ic;
	JLabel image = new JLabel("SUBWAY(이미지)");
	JLabel labelId = new JLabel("ID");
	JLabel labelPass = new JLabel("PASSWORD");
	JTextField fieldId = new JTextField(20);
	JPasswordField fieldPass = new JPasswordField(20);
	JButton btnSignIn = new JButton("로그인");
	JButton btnSignUp = new JButton("회원가입");
	

	// 생성자
	public LoginPage() {
		super("subway");
		//이미지 세팅
		try {
		    img = ImageIO.read(new File("img/subway_main.png"));
		} catch (IOException e) {
		    System.out.println("이미지 불러오기 실패");
		    System.exit(0);
		}
		//테두리
		 Border lineBorderG = BorderFactory.createLineBorder(Color.decode("#00B54C"), 2);
		 //Border lineBorderG = BorderFactory.createLineBorder(Color.black, 2);
		 Border emptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		 Border lineBorderY = BorderFactory.createLineBorder(Color.decode("#FEED02"), 2);
		 
	
		//폰트
		Font labelFont = new Font("HeaderFont",Font.BOLD, 25);
		Font FieldFont = new Font("HeaderFont",Font.PLAIN, 25);
		
		//폰트색
		Color fontColor = Color.decode("#7A7A7A");
	
		// 레이아웃 설정
    
		ImgPanel imgPanel = new ImgPanel();
		imgPanel.setBounds(147,50,607,160);
		
		
		labelId.setFont(labelFont);
		labelPass.setFont(labelFont);
	
		innerJp.setBounds(200, 400, 500, 150);
		innerJp.setBackground(Color.WHITE);
		
		fieldId.setFont(FieldFont);
		//fieldId.set
		fieldPass.setFont(FieldFont);
		fieldId.setBorder(BorderFactory.createCompoundBorder(lineBorderG, emptyBorder));
		fieldPass.setBorder(BorderFactory.createCompoundBorder(lineBorderG, emptyBorder));
		
		btnSignIn.setFont(labelFont);
		btnSignIn.setBorderPainted(true);
		btnSignIn.setFocusPainted(false);
		btnSignIn.setBorder(BorderFactory.createCompoundBorder(lineBorderY, emptyBorder));
		btnSignIn.setContentAreaFilled(false);
		
		btnSignUp.setFont(labelFont);
		btnSignUp.setBorderPainted(true);
		btnSignUp.setFocusPainted(false);
		btnSignUp.setBorder(BorderFactory.createCompoundBorder(lineBorderY, emptyBorder));
		btnSignUp.setContentAreaFilled(false);
		
		innerJp.add(labelId);
		innerJp.add(fieldId);
		innerJp.add(labelPass);
		innerJp.add(fieldPass);
		innerJp.add(btnSignIn);
		innerJp.add(btnSignUp);
		
		
		innerJp.setLayout(new GridLayout(3,2));
		
		jp.setLayout(null);
		jp.setBackground(Color.white);
		
		
		add(jp,"Center");
		jp.add(imgPanel);
		jp.add(innerJp);
		
	

		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 윈도우 설정
		setSize(900, 800);
		setLocationRelativeTo(null);
		setVisible(true);

		//로그인 입력시 이벤트(controller로 정보 전송)
		btnSignIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//UserInfoController.userSignIn(fieldId.getText(), fieldPass.getText());
				System.out.println("id : "+fieldId.getText());
				System.out.println("pass : "+fieldPass.getText());
			}
		});
		btnSignUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	class ImgPanel extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(img, 0, 0, null);
        }
    }

}
