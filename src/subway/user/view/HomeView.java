package subway.user.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeView extends JPanel implements ActionListener{
	private MainFrame F;
	String UserName;
	JLabel labelId = new JLabel("ID");
	public HomeView(JFrame frame) {
		F = (MainFrame)frame;
		UserName = F.getUserId();
		labelId.setText(UserName+"님 환영합니다");
		
		add(labelId);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
