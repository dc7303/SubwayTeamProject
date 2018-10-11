package subway.user.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import subway.user.controller.UserInfoController;
import subway.user.model.dto.UserInfoDTO;

public class HomeView extends JPanel implements ActionListener {
	BufferedImage img = null;
	private MainFrame F;
	private String UserName;
	private JButton btnOrder = new JButton("주문하기");
	private JButton btnRecent = new JButton("최근주문");
	private JButton btnMyMenu = new JButton("나의메뉴");
	private JButton btnHome = new JButton();
	private JLabel labelId;
	private JLabel labelWelcome;

	public HomeView(JFrame frame) {
		F = (MainFrame) frame;
		UserName = F.getUserId();
		labelId = new JLabel(UserName);
		labelWelcome = new JLabel("님 환영합니다.");
		// 이미지 로드
		try {
			img = ImageIO.read(new File("img/subway_title.png"));

		} catch (IOException e) {
			FailView.errorMessage("이미지 불러오기 실패");
			System.exit(0);
		}
		ImgPanel imgPanel = new ImgPanel();
		imgPanel.setBounds(340, 50, 204, 40);

		setLayout(null);
		setBackground(Color.white);

		labelId.setBounds(50, 0, 100, 50);
		labelId.setFont(MainFrame.userFont);
		labelWelcome.setBounds(150, 0, 100, 50);
		labelWelcome.setFont(MainFrame.userFont);

		btnOrder.setBounds(340, 300, 200, 50);
		btnRecent.setBounds(340, 400, 200, 50);
		btnMyMenu.setBounds(340, 500, 200, 50);

		btnOrder.setFont(MainFrame.labelFont);
		btnOrder.setBorderPainted(false);
		btnOrder.setFocusPainted(false);
		btnOrder.setContentAreaFilled(true);
		btnOrder.setBackground(Color.white);

		btnRecent.setFont(MainFrame.labelFont);
		btnRecent.setBorderPainted(false);
		btnRecent.setFocusPainted(false);
		btnRecent.setContentAreaFilled(true);
		btnRecent.setBackground(Color.white);

		btnMyMenu.setFont(MainFrame.labelFont);
		btnMyMenu.setBorderPainted(false);
		btnMyMenu.setFocusPainted(false);
		btnMyMenu.setContentAreaFilled(true);
		btnMyMenu.setBackground(Color.white);

		// 로고홈버튼
		btnHome.setBounds(340, 50, 204, 40);
		btnHome.setBorderPainted(false);
		btnHome.setContentAreaFilled(false);

		// 이벤트리스너
		btnOrder.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnOrder.setBackground(Color.white);
				btnOrder.setForeground(Color.BLACK);
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				btnOrder.setBackground(MainFrame.sub_green);
				btnOrder.setForeground(Color.white);
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				F.add("OrderView", new OrderView(F));
				F.getCardLayout().show(F.getContentPane(), "OrderView");

			}
		});
		btnRecent.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnRecent.setBackground(Color.white);
				btnRecent.setForeground(Color.BLACK);
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnRecent.setBackground(MainFrame.sub_green);
				btnRecent.setForeground(Color.white);
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				F.setCallBy("recent");
				F.add("OrderListView", new OrderListView(F));
				F.getCardLayout().show(F.getContentPane(), "OrderListView");
			}
		});
		btnMyMenu.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMyMenu.setBackground(Color.white);
				btnMyMenu.setForeground(Color.BLACK);
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnMyMenu.setBackground(MainFrame.sub_green);
				btnMyMenu.setForeground(Color.white);
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				F.setCallBy("mymenu");
				F.add("OrderListView", new OrderListView(F));
				F.getCardLayout().show(F.getContentPane(), "OrderListView");
			}
		});
		btnHome.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				repaint();
			}
		});

		add(btnHome);
		add(imgPanel);
		add(btnOrder);
		add(btnRecent);
		add(btnMyMenu);
		add(labelId);
		add(labelWelcome);

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
