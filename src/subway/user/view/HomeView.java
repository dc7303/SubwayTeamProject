package subway.user.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeView extends JPanel implements ActionListener{
	private JFrame F;
	JLabel labelId = new JLabel("ID");
	public HomeView(JFrame frame) {
		F = frame;
		labelId.setText("홈이다 인마");
		
		add(labelId);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
