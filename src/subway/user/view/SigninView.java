package subway.user.view;

import java.awt.Color;
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

import subway.user.controller.UserInfoController;

public class SigninView extends JPanel implements ActionListener {
	BufferedImage img = null;
	// Container con;
	//JPanel jp = new JPanel();
	JPanel innerJp = new JPanel();
	ImageIcon ic;
	JLabel image = new JLabel("SUBWAY(이미지)");
	JLabel labelId = new JLabel("ID");
	JLabel labelPass = new JLabel("PASSWORD");
	JTextField fieldId = new JTextField(20);
	JPasswordField fieldPass = new JPasswordField(20);
	JButton btnSignIn = new JButton("로그인");
	JButton btnSignUp = new JButton("회원가입");
	private MainFrame F;
	public SigninView(JFrame frame) {
		F = (MainFrame)frame;
		
		//이미지 로드
		try {
			img = ImageIO.read(new File("img/subway_main.png"));
		} catch (IOException e) {
			System.out.println("이미지 불러오기 실패");
			System.exit(0);
		}

		// 레이아웃 설정

		ImgPanel imgPanel = new ImgPanel();
		imgPanel.setBounds(147, 50, 607, 160);

		labelId.setFont(MainFrame.labelFont);
		labelPass.setFont(MainFrame.labelFont);

		innerJp.setBounds(200, 400, 500, 150);
		innerJp.setBackground(Color.WHITE);

		fieldId.setFont(MainFrame.FieldFont);
		// fieldId.set
		fieldPass.setFont(MainFrame.FieldFont);
		fieldId.setBorder(BorderFactory.createCompoundBorder(MainFrame.lineBorderG, MainFrame.emptyBorder));
		fieldPass.setBorder(BorderFactory.createCompoundBorder(MainFrame.lineBorderG, MainFrame.emptyBorder));

		btnSignIn.setFont(MainFrame.labelFont);
		btnSignIn.setBorderPainted(true);
		btnSignIn.setFocusPainted(false);
		btnSignIn.setBorder(BorderFactory.createCompoundBorder(MainFrame.lineBorderY, MainFrame.emptyBorder));
		btnSignIn.setContentAreaFilled(false);

		btnSignUp.setFont(MainFrame.labelFont);
		btnSignUp.setBorderPainted(true);
		btnSignUp.setFocusPainted(false);
		btnSignUp.setBorder(BorderFactory.createCompoundBorder(MainFrame.lineBorderY, MainFrame.emptyBorder));
		btnSignUp.setContentAreaFilled(false);

		innerJp.add(labelId);
		innerJp.add(fieldId);
		innerJp.add(labelPass);
		innerJp.add(fieldPass);
		innerJp.add(btnSignIn);
		innerJp.add(btnSignUp);
		
		
		innerJp.setLayout(new GridLayout(3,2));
		
		setLayout(null);
		setBackground(Color.white);
		
		//로그인 입력시 이벤트(controller로 정보 전송)
				btnSignIn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						UserInfoController.userSignIn(fieldId.getText(), fieldPass.getText());

						F.getCardLayout().show(F.getContentPane(), "Home");
					}
				});
				btnSignUp.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						
					}
				});
				
		add(imgPanel);
		add(innerJp);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
	class ImgPanel extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(img, 0, 0, null);
        }
    }

}
