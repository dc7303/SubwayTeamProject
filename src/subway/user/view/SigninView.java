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
import subway.user.model.dto.UserInfoDTO;

public class SigninView extends JPanel implements ActionListener {
	BufferedImage img = null;
	// Container con;
	//JPanel jp = new JPanel();
	private JPanel innerJp = new JPanel();
	private ImageIcon ic;
	private JLabel image = new JLabel("SUBWAY(�̹���)");
	private JLabel labelId = new JLabel("ID");
	private JLabel labelPass = new JLabel("PASSWORD");
	private JTextField fieldId = new JTextField(20);
	private JPasswordField fieldPass = new JPasswordField(20);
	private JButton btnSignIn = new JButton("�α���");
	private JButton btnSignUp = new JButton("ȸ������");
	private MainFrame F;
	public SigninView(JFrame frame) {
		F = (MainFrame)frame;
		
		//�̹��� �ε�
		try {
			img = ImageIO.read(new File("img/subway_main.png"));
		} catch (IOException e) {
			FailView.errorMessage("�̹��� �ҷ����� ����");
			System.exit(0);
		}

		// ���̾ƿ� ����

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
		btnSignIn.setBorderPainted(false);
		btnSignIn.setFocusPainted(false);
		btnSignIn.setContentAreaFilled(true);
		btnSignIn.setBackground(MainFrame.sub_yellow);
		btnSignIn.setForeground(Color.white);

		btnSignUp.setFont(MainFrame.labelFont);
		btnSignUp.setBorderPainted(false);
		btnSignUp.setFocusPainted(false);
		btnSignUp.setContentAreaFilled(true);
		btnSignUp.setBackground(MainFrame.sub_green);
		btnSignUp.setForeground(Color.white);

		innerJp.add(labelId);
		innerJp.add(fieldId);
		innerJp.add(labelPass);
		innerJp.add(fieldPass);
		innerJp.add(btnSignIn);
		innerJp.add(btnSignUp);
		
		
		innerJp.setLayout(new GridLayout(3,2));
		
		setLayout(null);
		setBackground(Color.white);
		
		//�α��� �Է½� �̺�Ʈ(controller�� ���� ����)
				btnSignIn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						UserInfoDTO user = UserInfoController.userSignIn(fieldId.getText(), fieldPass.getText());
						if(user == null) {
							FailView.errorMessage("�Է��Ͻ� ������ ��ġ�� ȸ���� �����ϴ�.");
						}
						
						F.setUserId(user.getUserId());
						F.add("Home",new HomeView(F));
						F.getCardLayout().show(F.getContentPane(), "Home");
					}
				});
				btnSignUp.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						F.getCardLayout().show(F.getContentPane(), "Sign-up");
						
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
