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
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import subway.user.controller.OrderController;
import subway.user.model.dto.OrderDTO;

public class OrderListView extends JPanel implements ActionListener {

	private String[] name = { "�ֹ���ȣ", "����", "�޴��̸�", "�߰�����", "��", "�ҽ�" };
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
	private JComboBox comboCrud;
	private JButton btnHome = new JButton();
	List<Vector<Object>> list = new ArrayList<>();
	
	String ids[];
	int orderId;
	
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

		// mymenu�϶��� �ƴҶ� ����Ʈ ��� ����
		if (F.getCallBy().equals("mymenu")) {
			list = OrderController.orderSelectVector(F.getUserId(), true);
		} else {
			list = OrderController.orderSelectVector(F.getUserId(), false);

		}

		if (list != null && list.size() > 0) {
			this.addRowTable(list);
			jt.setRowSelectionInterval(0, 0);
		}

		// mymenu���� ����
		String[] crud = { "����", "����", "����", "�ֹ�" };
		comboCrud = new JComboBox(crud);

		// ��ġ����
		// ���̺� ����
		// jt.setRowSelectionInterval(0, 0);
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

		// ���̸޴����� ������ ����
		if (F.getCallBy().equals("mymenu")) {
			initMyMenu();

		}

		// �����гο� �߰�
		add(btnHome);
		add(imgPanel);
		add(jsp);
		add(labelTitle);
		add(labelSelect);
		add(btnOrder);
	}

	public void actionPerformed(ActionEvent e) {
		int result = 0;
		if (list != null && list.size() > 0) {
			
			int rows[] = jt.getSelectedRows();
			ids = new String[rows.length];
			for (int i = 0; i < rows.length; i++) {
				ids[i] = jt.getValueAt(rows[i], 0).toString();
			}
			orderId = Integer.parseInt(ids[0]);
		}
		if (e.getSource() == btnOrder && F.getCallBy().equals("mymenu")) {
			String selected = comboCrud.getSelectedItem().toString();
			if (selected.equals("����")) {
				// �ֹ��ϱ�(mymenu)
				F.setCallBy("create");
				// orderView���� init�ʿ�
				// F.add("OrderView", new OrderView(F));

				F.add("OrderView", new OrderView(F));
				F.getCardLayout().show(F.getContentPane(), "OrderView");
			} else if (selected.equals("����")) {
				// ������ addrow()�� �ʱ�ȭ �� ��
				int re = JOptionPane.showConfirmDialog(this, "���� �����ҷ�???");
				if (re == 0) {
					// �����ϴ°��

					result = OrderController.myMenuDelete(ids[0]);
					if (result != 0) {
						// ����
						SuccessView.successMessage("�����Ϸ�");
						list = OrderController.orderSelectVector(F.getUserId(), true);
						addRowTable(list);
					} else {
						FailView.errorMessage("��������");
					}

				}
			} else if (selected.equals("����")) {
				F.setCallBy("update");
				F.setOrderId(orderId);
				// orderView���� init�ʿ�
				F.add("OrderView", new OrderView(F));
				F.getCardLayout().show(F.getContentPane(), "OrderView");

			} else // �ֹ�
			{
			    OrderDTO order =OrderController.selectOrderById(orderId);
			    order.setOrderIsMyMenu("FALSE");
	            OrderController.orderInsert(order);
	            F.setCallBy("order");
	            F.setOrderId(orderId);
	            F.add("OrderResultView", new OrderResultView(F));
	            F.getCardLayout().show(F.getContentPane(), "OrderResultView");
			}
		} else if (e.getSource() == btnOrder) {
            OrderDTO order =OrderController.selectOrderById(orderId);
            OrderController.orderInsert(order);
            F.setCallBy("order");
            F.setOrderId(orderId);
            F.add("OrderResultView", new OrderResultView(F));
            F.getCardLayout().show(F.getContentPane(), "OrderResultView");
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

	/*
	 * initMyMenu ���̸޴� ��Ÿ�Ϸ� ��ҵ� ��迭
	 */
	private void initMyMenu() {
		// Ÿ��Ʋ �ٲ�
		labelTitle.setText("My_Menu");
		labelTitle.setBounds(340, 150, 300, 50);
		// ���� ��� ��迭 labelSelect.setBounds(200, 300, 300, 50);
		labelSelect.setBounds(50, 300, 300, 50);
		btnOrder.setBounds(600, 300, 200, 50);
		String[] arr = { "����", "����", "�ֹ�" };
		comboCrud = new JComboBox(arr);
		comboCrud.setBounds(400, 300, 100, 50);
		comboCrud.setFont(new Font("HeaderFont", Font.BOLD, 20));
		btnOrder.setEnabled(true);
		btnOrder.setText("����");
		add(comboCrud);
	}
}
