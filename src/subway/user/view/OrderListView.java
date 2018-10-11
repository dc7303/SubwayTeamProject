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
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import subway.user.model.dto.OrderDTO;
import subway.user.view.HomeView.ImgPanel;

public class OrderListView extends JPanel implements ActionListener {
	private String[] name = { "�ֹ���ȣ", "�޴��̸�", "����", "Į�θ�" };
	BufferedImage img = null;
	private DefaultTableModel dt = new DefaultTableModel(name, 0) {
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	private JTable jt = new JTable(dt);
	private JScrollPane jsp = new JScrollPane(jt);
	private MainFrame F;
	private JLabel labelTitle = new JLabel("�ֱ��ֹ�");
	private JLabel labelSelect = new JLabel("�ֹ��� �������ּ���");
	private JButton btnOrder = new JButton("���ֹ�");

	private JButton btnHome = new JButton();
	List<Vector<Object>> list = new ArrayList<>();
	

	public OrderListView(JFrame frame) {
		F = (MainFrame) frame;
		// �̹��� �ε�
		try {
			img = ImageIO.read(new File("img/subway_title.png"));

		} catch (IOException e) {
			FailView.errorMessage("�̹��� �ҷ����� ����");
			System.exit(0);
		}
		ImgPanel imgPanel = new ImgPanel();
		imgPanel.setBounds(340, 50, 204, 40);

		setLayout(null);
		setBackground(Color.white);

		// dt.addrow
		/**
		 * ���� ������ ���� list = OrderController.insertVecor(F.getUserid); // ��ü���ڵ�
		 * �˻��ϱ�->dtm�� �߰� List<Vector<Object>> list = UserListController.getSelectAll();
		 * if (list != null && list.size() > 0) { this.addRowTable(list);
		 * jt.setRowSelectionInterval(0, 0); }
		 */

		OrderDTO orderDTO = new OrderDTO(1, 30, "��Ƽ���� ġŲ", "���׸���", "��Ͽ�Ʈ", "��ġ����", 9000, 1035, "C62", "��ް���?", "TRUE",
				2, "2");
		OrderDTO orderDTO2 = new OrderDTO(2, 30, "���׸���", "���׸���", "��Ͽ�Ʈ", "��ġ����", 9000, 1035, "C62", "��ް���?", "TRUE", 2,
				"2");
		Vector<Object> vec = new Vector<>();
		vec.add(orderDTO.getOrderId());
		vec.add(orderDTO.getOrderMenu());
		vec.add(orderDTO.getOrderPrice());
		vec.add(orderDTO.getOrderCalorie());
		list.add(vec);

		Vector<Object> vec2 = new Vector<>();
		vec2.add(orderDTO2.getOrderId());
		vec2.add(orderDTO2.getOrderMenu());
		vec2.add(orderDTO2.getOrderPrice());
		vec2.add(orderDTO2.getOrderCalorie());
		// System.out.println(vec.get(5));
		list.add(vec2);

		for (Vector<Object> v : list) {
			dt.addRow(v);
		}

		// ��ġ����
		// ���̺� ����
		jt.setRowSelectionInterval(0, 0);
		jt.getTableHeader().setReorderingAllowed(false);
		jt.getTableHeader().setResizingAllowed(false);

		// �� ��ġ
		labelTitle.setBounds(340, 150, 200, 50);
		labelTitle.setFont(MainFrame.titleFont);

		labelSelect.setBounds(200, 300, 300, 50);
		labelSelect.setFont(MainFrame.labelFont);

		btnOrder.setBounds(500, 300, 200, 50);
		btnOrder.setFont(MainFrame.labelFont);
		btnOrder.setBorderPainted(false);
		btnOrder.setFocusPainted(false);
		btnOrder.setBackground(MainFrame.sub_green);
		btnOrder.setForeground(Color.white);
		btnOrder.setEnabled(false);

		jsp.setBounds(0, 450, 900, 1000);

		// �ΰ�Ȩ��ư
		btnHome.setBounds(340, 50, 204, 40);
		btnHome.setBorderPainted(false);
		btnHome.setContentAreaFilled(false);
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
				F.getCardLayout().show(F.getContentPane(), "Home");
			}
		});
		jt.addMouseListener(new MouseListener() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				int rows[] = jt.getSelectedRows();
				String items[] = new String[rows.length];
				for (int i = 0; i < rows.length; i++) {
					items[i] = jt.getValueAt(rows[i], 0).toString();
				}

				for (String item : items) {
					labelSelect.setText("���õ� �ֹ���ȣ " + item + " ��");
					F.setOrderId(Integer.parseInt(item));
				}
				btnOrder.setEnabled(true);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btnOrder.addActionListener(this);
		
		
		// �����гο� �߰�
		add(btnHome);
		add(imgPanel);
		add(jsp);
		add(labelTitle);
		add(labelSelect);
		add(btnOrder);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOrder) {
			F.setCallBy("order");
			F.add("OrderView", new OrderView(F));
			F.getCardLayout().show(F.getContentPane(), "OrderView");
		}
	}

	class ImgPanel extends JPanel {
		public void paint(Graphics g) {

			g.drawImage(img, 0, 0, null);

		}
	}

	public void addRowTable(List<Vector<Object>> list) {
		// ���� ������ ����� 0������ �����
		/*
		 * while(dt.getRowCount()>0) { dt.removeRow(0); }
		 */
		dt.setNumRows(0); // �హ���� 0���� -> �� ����

		for (Vector<Object> v : list) {
			dt.addRow(v);
		}
	}

}
