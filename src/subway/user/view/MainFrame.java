package subway.user.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MainFrame extends JFrame {
	public static Border lineBorderG;
	public static Border emptyBorder;
	public static Border lineBorderY;
	public static Font labelFont;
	public static Font FieldFont;
	private CardLayout cards = new CardLayout();
	public MainFrame() {
		super("subway");
		
		//SigninView signIn = new SigninView();
		//테두리
		 lineBorderG = BorderFactory.createLineBorder(Color.decode("#00B54C"), 2);
		 //Border lineBorderG = BorderFactory.createLineBorder(Color.black, 2);
		 emptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		lineBorderY = BorderFactory.createLineBorder(Color.decode("#FEED02"), 2);
		 
	
		//폰트
		labelFont = new Font("HeaderFont",Font.BOLD, 25);
		FieldFont = new Font("HeaderFont",Font.PLAIN, 25);
		
		
		
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(cards);
		add("sign-in",new SigninView(this));
		add("Home",new HomeView(this));
		cards.show(this.getContentPane(), "sign-in");
		setSize(900,800);
		setLocationRelativeTo(null);
		setVisible(true);	

	}
	public CardLayout getCardLayout() {
		 return cards;
		}
}
