package subway.user.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class MainFrame extends JFrame {
	public static Border lineBorderG;
	public static Border emptyBorder;
	public static Border lineBorderY;
	public static Border lineBorderW;
	public static Font labelFont;
	public static Font FieldFont;
	public static Font userFont;
	public static Font titleFont;
	public static Color sub_green;
	public static Color sub_yellow;
	public static Color sub_grey;
	private CardLayout cards = new CardLayout();
	private static String UserId = "";
	private static int orderId = 0;
	private static String callBy = "";
	
	
	public MainFrame() {
		super("subway");
		
		//SigninView signIn = new SigninView();
		//색
		sub_green =  Color.decode("#009132");
		sub_yellow =  Color.decode("#FFBF00");
		sub_grey = Color.decode("#F8F8F8");
		
		//테두리
		 lineBorderG = BorderFactory.createLineBorder(sub_green, 2);
		 //Border lineBorderG = BorderFactory.createLineBorder(Color.black, 2);
		 emptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		lineBorderY = BorderFactory.createLineBorder(sub_yellow, 2);
		lineBorderW = BorderFactory.createLineBorder(Color.white, 1);
		 
	
		//폰트
		labelFont = new Font("HeaderFont",Font.BOLD, 25);
		FieldFont = new Font("HeaderFont",Font.PLAIN, 25);
		userFont = new Font("HeaderFont",Font.BOLD, 15);
		titleFont = new Font("HeaderFont",Font.BOLD, 45);
		//favicon
		
		ImageIcon icon = new ImageIcon("img/subway_og.png");
		setIconImage(icon.getImage());
		
		
		
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setLayout(cards);
		
		//카드추가
		add("Sign-in",new SigninView(this));
		//add("Home",new HomeView(this));	-> user정보 유지를 위해 나중에 추가
		add("Sign-up",new SignupView(this));
		
		
		cards.show(this.getContentPane(), "Sign-in");
		setSize(900,1000);
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
	public static int getOrderId() {
		return orderId;
	}
	public static void setOrderId(int orderId) {
		MainFrame.orderId = orderId;
	}
	public static String getCallBy() {
		return callBy;
	}
	public static void setCallBy(String callBy) {
		MainFrame.callBy = callBy;
	}
	
}
