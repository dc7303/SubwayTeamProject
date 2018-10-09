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
	private static String UserId;
	
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
		
		//카드추가
		add("Sign-in",new SigninView(this));
		//add("Home",new HomeView(this));
		add("Sign-up",new SignupView(this));
		
		cards.show(this.getContentPane(), "Sign-in");
		setSize(900,800);
		setLocationRelativeTo(null);
		setVisible(true);	

	}
	public CardLayout getCardLayout() {
		 return cards;
		}
	
	public static String getUserId() {
		return UserId;
	}
	public static void setUserId(String userId) {
		UserId = userId;
	}
}
