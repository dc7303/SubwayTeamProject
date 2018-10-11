package subway.user.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import subway.user.controller.OrderController;
import subway.user.model.dto.OrderDTO;
import subway.user.view.OrderView.ImgPanel;

public class OrderResultView extends JPanel implements ActionListener {
	private MainFrame F = null;
	private JLabel labelTitle = new JLabel("주문결과");
	private JLabel labelMenu = new JLabel("메뉴");
	private JLabel labelLength = new JLabel("길이");
	private JLabel labelBread = new JLabel("빵");
	private JLabel labelExtra = new JLabel("추가토핑");
	private JLabel labelSauce = new JLabel("소스");
	private JLabel labelRequire = new JLabel("추가요구사항");
	private JLabel labelPredict = new JLabel();
	private JLabel comboMenu = new JLabel();
	private JLabel comboLength = new JLabel();
	private JLabel comboBread = new JLabel();
	private JLabel comboExtra = new JLabel();
	private JLabel comboSauce = new JLabel();
	private JTextArea fieldText = new JTextArea(4, 20);
	private JButton btnOrder = new JButton("추가주문");
	BufferedImage img = null;
	private JButton btnHome = new JButton();
	private List<OrderDTO> list;
	private OrderDTO orderDTO;

	public OrderResultView(JFrame frame) {
		F = (MainFrame) frame;

		setLayout(null);
		setBackground(Color.WHITE);

		// 폰트
		Font labelFont = new Font("HeaderFont", Font.BOLD, 20);
		Font comboFont = new Font("HeaderFont", Font.PLAIN, 20);

		// 이미지 로드
		try {
			img = ImageIO.read(new File("img/subway_title.png"));
		} catch (IOException e) {
			FailView.errorMessage("이미지 불러오기 실패");
			System.exit(0);
		}
		// 레이아웃 설정

		ImgPanel imgPanel = new ImgPanel();
		imgPanel.setBounds(340, 50, 204, 40);

		btnHome.setBounds(340, 50, 204, 40);
		btnHome.setBorderPainted(false);
		btnHome.setContentAreaFilled(false);
		// 해당 주문select & 값입력
		/*
		 * list = OrderController.orderSelect(F.getUserId()); orderDTO =list.get(0);
		 * public OrderDTO(int orderId, int orderBreadLength, String orderMenu, String
		 * orderExtra, String orderBread, String orderSauce, int orderPrice, int
		 * orderCalorie, String orderUser, String orderText, String orderIsMyMenu, int
		 * orderQuantity, String orderBasket)
		 */
		orderDTO = new OrderDTO(1, 30, "로티세리 치킨", "에그마요", "허니오트", "리치시저", 9000, 1035, "C62", "배달가능?", "TRUE", 2, 2);
		System.out.println(orderDTO.getOrderMenu());
		comboMenu.setText(orderDTO.getOrderMenu());
		comboLength.setText(Integer.toString(orderDTO.getOrderBreadLength()) + "cm");
		comboBread.setText(orderDTO.getOrderBread());
		comboExtra.setText(orderDTO.getOrderExtra());
		comboSauce.setText(orderDTO.getOrderSauce());
		fieldText.setText(orderDTO.getOrderText());
		labelPredict.setText("총 " + orderDTO.getOrderCalorie() + "kcal " + orderDTO.getOrderPrice() + "원");

		// 위치등록
		labelTitle.setBounds(340, 150, 200, 50);
		labelTitle.setFont(MainFrame.titleFont);
		labelMenu.setBounds(50, 250, 100, 30);
		labelMenu.setFont(labelFont);
		labelLength.setBounds(50, 300, 100, 30);
		labelLength.setFont(labelFont);
		labelBread.setBounds(50, 350, 100, 30);
		labelBread.setFont(labelFont);
		labelExtra.setBounds(50, 400, 100, 30);
		labelExtra.setFont(labelFont);
		labelSauce.setBounds(50, 450, 100, 30);
		labelSauce.setFont(labelFont);
		labelRequire.setBounds(50, 500, 150, 30);
		labelRequire.setFont(labelFont);
		labelPredict.setBounds(300, 750, 300, 50);
		labelPredict.setForeground(Color.BLACK);
		labelPredict.setFont(MainFrame.labelFont);

		comboMenu.setBounds(250, 250, 500, 30);
		comboMenu.setFont(comboFont);
		comboLength.setBounds(250, 300, 500, 30);
		comboLength.setFont(comboFont);
		comboBread.setBounds(250, 350, 500, 30);
		comboBread.setFont(comboFont);
		comboExtra.setBounds(250, 400, 500, 30);
		comboExtra.setFont(comboFont);
		comboSauce.setBounds(250, 450, 200, 30);
		comboSauce.setFont(comboFont);

		fieldText.setBounds(50, 550, 700, 150);
		fieldText.setFont(comboFont);
		fieldText.setBackground(MainFrame.sub_grey);
		fieldText.setEditable(false);

		btnOrder.setBounds(300, 850, 250, 50);
		btnOrder.setFont(MainFrame.labelFont);
		btnOrder.setBorderPainted(false);
		btnOrder.setFocusPainted(false);
		btnOrder.setBackground(MainFrame.sub_green);
		btnOrder.setForeground(Color.white);

		// 이벤트추가
		btnOrder.addActionListener(this);
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
				// 홈으로 이동
				F.getCardLayout().show(F.getContentPane(), "Home");
			}
		});

		// 패널추가
		// add(comboLength);
		add(btnHome);
		add(imgPanel);
		add(labelTitle);
		add(labelMenu);
		add(labelLength);
		add(labelBread);
		add(labelExtra);
		add(labelSauce);
		add(labelRequire);
		add(labelPredict);
		add(comboMenu);
		add(comboLength);
		add(comboBread);
		add(comboExtra);
		add(comboSauce);
		add(fieldText);
		add(btnOrder);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOrder) {
			F.getCardLayout().show(F.getContentPane(), "OrderView");
		}
	}

	class ImgPanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}

}
