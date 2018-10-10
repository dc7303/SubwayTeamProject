package subway.user.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MainFrame extends JFrame {
	public static Border lineBorderG;
	public static Border emptyBorder;
	public static Border lineBorderY;
	public static Font labelFont;
	public static Font FieldFont;
	public static Color sub_green;
	public static Color sub_yellow;
	private CardLayout cards = new CardLayout();
	private static String UserId;
	
	public MainFrame() {
		super("subway");
		
		//SigninView signIn = new SigninView();
		//��
		sub_green =  Color.decode("#009132");
		sub_yellow =  Color.decode("#FFBF00");
		
		//�׵θ�
		 lineBorderG = BorderFactory.createLineBorder(sub_green, 2);
		 //Border lineBorderG = BorderFactory.createLineBorder(Color.black, 2);
		 emptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		lineBorderY = BorderFactory.createLineBorder(sub_yellow, 2);
		 
	
		//��Ʈ
		labelFont = new Font("HeaderFont",Font.BOLD, 25);
		FieldFont = new Font("HeaderFont",Font.PLAIN, 25);
		
		//favicon
		
		ImageIcon icon = new ImageIcon("img/subway_og.png");
		setIconImage(icon.getImage());
		
		
		
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setLayout(cards);
		
		//ī���߰�
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
