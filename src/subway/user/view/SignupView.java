package subway.user.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SignupView extends JPanel implements ActionListener{
	private MainFrame F;
	JLabel labelId = new JLabel("ID");
	public SignupView(JFrame frame) {
		F = (MainFrame)frame;
		labelId.setText("ȸ�������̴� �θ�");
		
		add(labelId);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
