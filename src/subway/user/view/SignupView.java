package subway.user.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import subway.user.controller.UserInfoController;
import subway.user.model.dto.UserInfoDTO;

public class SignupView extends JPanel implements ActionListener{
	BufferedImage img = null;
	private MainFrame F;
	private JLabel labelId = new JLabel("ID");
	private JLabel labelPass = new JLabel("��й�ȣ");
	private JLabel labelCheck = new JLabel("��й�ȣ Ȯ��");
	private JLabel labelName = new JLabel("�̸�");
	private JLabel labelPhone = new JLabel("��ȭ��ȣ");
	private JLabel labelEmail = new JLabel("�̸���");
	private JLabel labelTitle = new JLabel("ȸ������");
	private JButton btnSubmit = new JButton("����");
	private JButton btnLogin = new JButton("�α��� ������");
	private JButton btnDup = new JButton("�ߺ�Ȯ��");
	private JTextField fieldId = new JTextField();
	private JPasswordField fieldPass = new JPasswordField();
	private JPasswordField fieldCheck = new JPasswordField();
	private JTextField fieldName = new JTextField();
	private JTextField fieldPhone = new JTextField();
	private JTextField fieldEmail = new JTextField();
	private boolean idFlag = false;
	private UserInfoDTO user;
	
	public SignupView(JFrame frame) {
		F = (MainFrame)frame;
		setLayout(null);
		setBackground(Color.white);
		
		//������ ��ġ����
		labelTitle.setBounds(350, 50, 200, 50);
		labelTitle.setFont(MainFrame.titleFont);

		//�� ��ġ
		labelId.setBounds(100, 200, 100, 50);
		labelId.setFont(MainFrame.labelFont);
		labelPass.setBounds(100, 270, 100, 50);
		labelPass.setFont(MainFrame.labelFont);
		labelCheck.setBounds(100, 340, 200, 50);
		labelCheck.setFont(MainFrame.labelFont);
		labelName.setBounds(100, 410, 100, 50);
		labelName.setFont(MainFrame.labelFont);
		labelPhone.setBounds(100, 480, 100, 50);
		labelPhone.setFont(MainFrame.labelFont);
		labelEmail.setBounds(100, 550, 100, 50);
		labelEmail.setFont(MainFrame.labelFont);
		
		//�ʵ� ��ġ
		fieldId.setBounds(300, 200, 300, 50);
		fieldId.setFont(MainFrame.FieldFont);
		fieldId.setBackground(MainFrame.sub_grey);
		fieldId.setBorder(BorderFactory.createCompoundBorder(MainFrame.lineBorderW, MainFrame.emptyBorder));
		fieldPass.setBounds(300, 270, 300, 50);
		fieldPass.setFont(MainFrame.FieldFont);
		fieldPass.setBackground(MainFrame.sub_grey);
		fieldPass.setBorder(BorderFactory.createCompoundBorder(MainFrame.lineBorderW, MainFrame.emptyBorder));
		fieldCheck.setBounds(300, 340, 300, 50);
		fieldCheck.setFont(MainFrame.FieldFont);
		fieldCheck.setBackground(MainFrame.sub_grey);
		fieldCheck.setBorder(BorderFactory.createCompoundBorder(MainFrame.lineBorderW, MainFrame.emptyBorder));
		fieldName.setBounds(300, 410, 300, 50);
		fieldName.setFont(MainFrame.FieldFont);
		fieldName.setBackground(MainFrame.sub_grey);
		fieldName.setBorder(BorderFactory.createCompoundBorder(MainFrame.lineBorderW, MainFrame.emptyBorder));
		fieldPhone.setBounds(300, 480, 300, 50);
		fieldPhone.setFont(MainFrame.FieldFont);
		fieldPhone.setBackground(MainFrame.sub_grey);
		fieldPhone.setBorder(BorderFactory.createCompoundBorder(MainFrame.lineBorderW, MainFrame.emptyBorder));
		fieldEmail.setBounds(300, 550, 300, 50);
		fieldEmail.setFont(MainFrame.FieldFont);
		fieldEmail.setBackground(MainFrame.sub_grey);
		fieldEmail.setBorder(BorderFactory.createCompoundBorder(MainFrame.lineBorderW, MainFrame.emptyBorder));
		
		btnDup.setBounds(650, 200, 150, 50);
		btnDup.setFont(MainFrame.labelFont);
		btnDup.setBackground(MainFrame.sub_green);
		btnDup.setForeground(Color.white);
		btnDup.setFocusable(false);
		btnDup.setBorderPainted(false);
		btnSubmit.setBounds(230, 650, 200, 50);
		btnSubmit.setFont(MainFrame.labelFont);
		btnSubmit.setBackground(MainFrame.sub_yellow);
		btnSubmit.setForeground(Color.white);
		btnSubmit.setFocusable(false);
		btnSubmit.setBorderPainted(false);
		btnLogin.setBounds(470, 650, 200, 50);
		btnLogin.setFont(MainFrame.labelFont);
		btnLogin.setBackground(MainFrame.sub_green);
		btnLogin.setForeground(Color.white);
		btnLogin.setFocusable(false);
		btnLogin.setBorderPainted(false);
		
		btnDup.addActionListener(this);
		btnSubmit.addActionListener(this);
		btnLogin.addActionListener(this);
		
		//�гο� �߰�
		add(labelTitle);
		add(labelId);
		add(labelPass);
		add(labelCheck);
		add(labelName);
		add(labelPhone);
		add(labelEmail);
		
		add(fieldId);
		add(fieldPass);
		add(fieldCheck);
		add(fieldName);
		add(fieldPhone);
		add(fieldEmail);
		
		add(btnDup);
		add(btnSubmit);
		add(btnLogin);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSubmit) {
			if(fieldId.getText().trim().equals("")||fieldPass.getText().trim().equals("")||	fieldCheck.getText().trim().equals("")||fieldName.getText().trim().equals("")||
					fieldPhone.getText().trim().equals("")) {
				FailView.errorMessage("�Է��ʼ� �����Դϴ�.");
			}
			else if(fieldPass.getText().equals(fieldCheck.getText().trim())&&(idFlag==true)) {
				user = new UserInfoDTO(fieldId.getText().trim(),fieldPass.getText().trim(),
						fieldName.getText().trim(),fieldPhone.getText().trim(),
						fieldEmail.getText().trim());
				if(UserInfoController.userSignUp(user)!=0) {
					SuccessView.successMessage("ȸ�����Կ� �����Ͽ����ϴ�.");
					F.getCardLayout().show(F.getContentPane(), "Sign-in");
				}
			}
			else {
				FailView.errorMessage("�Է������� �ٽ� Ȯ�����ּ���");
			}
		}
		else if(e.getSource() == btnDup) {
			String id = fieldId.getText().trim();
			//�ߺ�üũ -> ��Ʈ�ѷ� ����� ����
			user=null;
			if(id.equals("")||id.length() >20||user!=null) {
				FailView.errorMessage("�Ұ����� id�Դϴ�.");
			}
			else {
				SuccessView.successMessage("��밡���� id�Դϴ�");
				idFlag = true;
			}
		}
		else if(e.getSource() == btnLogin) {
			F.getCardLayout().show(F.getContentPane(), "Sign-in");
		}
		 
	}
}
