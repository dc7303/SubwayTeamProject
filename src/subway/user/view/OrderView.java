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

import subway.admin.dto.IngredientDTO;
import subway.user.controller.OrderController;
import subway.user.model.dto.OrderDTO;

public class OrderView extends JPanel implements ActionListener {

    private MainFrame F = null;
    private JLabel labelTitle = new JLabel("�ֹ��ϱ�");
    private JLabel labelMenu = new JLabel("�޴�");
    private JLabel labelLength = new JLabel("����");
    private JLabel labelBread = new JLabel("��");
    private JLabel labelExtra = new JLabel("�߰�����");
    private JLabel labelSauce = new JLabel("�ҽ�");
    private JLabel labelRequire = new JLabel("�߰��䱸����");
    private JLabel labelPredict = new JLabel();
    private JLabel labelReSauceTitle = new JLabel("��õ�ҽ� -> ");
    private JLabel labelReSauce = new JLabel();
    private JComboBox comboMenu;
    private JComboBox comboLength;
    private JComboBox comboBread;
    private JComboBox comboExtra;
    private JComboBox comboSauce;
    private JTextArea fieldText = new JTextArea(4, 20);
    private JButton btnPredict = new JButton("������ & Į�θ� ����");
    private JButton btnOrder = new JButton("�ֹ��ϱ�");
    BufferedImage img = null;
    private JButton btnHome = new JButton();
    private OrderDTO orderDTO;
    private int orderId;
    List<IngredientDTO> list = null;

    public OrderView(JFrame frame) {
        list = OrderController.menuList();

        F = (MainFrame) frame;
        String[] menuArr = this.comboList("�޴�");
        String[] breadArr = this.comboList("��");
        String[] extraArr = this.comboList("�߰�����");
        String[] sauceArr = this.comboList("�ҽ�");
        String[] langthArr = { "15", "30" };

        setLayout(null);
        setBackground(Color.WHITE);

        // ��Ʈ
        Font labelFont = new Font("HeaderFont", Font.BOLD, 20);
        Font comboFont = new Font("HeaderFont", Font.PLAIN, 20);

        // �̹��� �ε�
        try {
            img = ImageIO.read(new File("img/subway_title.png"));
        } catch (IOException e) {
            FailView.errorMessage("�̹��� �ҷ����� ����");
            System.exit(0);
        }
        // orderid�� ���ο� ���� �ʱ�ȭ

        orderId = F.getOrderId();
        // �ֹ� id�� ��� �ֹ��� ���(�ֱ��ֹ�����, my_menu(�ֹ�)����)
        if (orderId != 0 && F.getCallBy().equals("order")) {
            initOrder(orderId);
        }
        // �ֹ� id�� ��� ������ ���
        else if (orderId != 0 && F.getCallBy().equals("update")) {
            initOrder(orderId);
            btnOrder.setText("����");
        }
        // my_menu����
        else if (F.getCallBy().equals("create")) {
            init();
            btnOrder.setText("����");
        }

        // �޺��� �����߰�
        comboMenu = new JComboBox(menuArr);
        comboBread = new JComboBox(breadArr);
        comboExtra = new JComboBox(extraArr);
        comboSauce = new JComboBox(sauceArr);
        comboLength = new JComboBox(langthArr);

        // ���̾ƿ� ����

        ImgPanel imgPanel = new ImgPanel();
        imgPanel.setBounds(340, 50, 204, 40);

        btnHome.setBounds(340, 50, 204, 40);
        btnHome.setBorderPainted(false);
        btnHome.setContentAreaFilled(false);

        // ��ġ���
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
        labelReSauceTitle.setBounds(470, 450, 200, 30);
        labelReSauceTitle.setFont(labelFont);
        labelReSauceTitle.setForeground(MainFrame.sub_yellow);
        labelReSauceTitle.setVisible(false);
        labelReSauce.setBounds(590, 450, 180, 30);
        labelReSauce.setFont(labelFont);
        labelReSauce.setForeground(MainFrame.sub_green);
        labelPredict.setBounds(450, 750, 300, 50);
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

        btnPredict.setBounds(100, 750, 300, 50);
        btnPredict.setFont(MainFrame.labelFont);
        btnPredict.setBorderPainted(false);
        btnPredict.setFocusPainted(false);
        btnPredict.setBackground(MainFrame.sub_yellow);
        btnPredict.setForeground(Color.white);

        btnOrder.setBounds(300, 850, 250, 50);
        btnOrder.setFont(MainFrame.labelFont);
        btnOrder.setBorderPainted(false);
        btnOrder.setFocusPainted(false);
        btnOrder.setBackground(MainFrame.sub_green);
        btnOrder.setForeground(Color.white);
        btnOrder.setEnabled(false);

        // �̺�Ʈ�߰�
        comboMenu.addActionListener(this);
        btnPredict.addActionListener(this);
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
                // Ȩ���� �̵�
                F.getCardLayout().show(F.getContentPane(), "Home");
            }
        });

        // �г��߰�
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
        add(labelReSauce);
        add(labelReSauceTitle);
        add(labelPredict);
        add(comboMenu);
        add(comboLength);
        add(comboBread);
        add(comboExtra);
        add(comboSauce);
        add(fieldText);
        add(btnPredict);
        add(btnOrder);

        // ������ ��
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboMenu) {
            String combo = comboMenu.getSelectedItem().toString();
            List<IngredientDTO> list = OrderController.menuList("�޴�");
            String[] comboBoolean = comboList(list);
            for(int i = 0; i < comboBoolean.length; i++) {
                if (combo.equals(comboBoolean[i])) {
                    labelReSauceTitle.setVisible(true);
                    labelReSauce.setText(list.get(i).getIngredRecommendSauce() + "!!");
                }
            }
        } else if (e.getSource() == btnPredict) {
            List<IngredientDTO> menuList = OrderController.menuList("�޴�");
            List<IngredientDTO> breadList = OrderController.menuList("��");
            List<IngredientDTO> extraList = OrderController.menuList("�߰�����");
            List<IngredientDTO> sauceList = OrderController.menuList("�ҽ�");
            
            String[] menuBoolean = comboList(menuList);
            String[] breadBoolean = comboList(breadList);
            String[] extraBoolean = comboList(extraList);
            String[] sauceBoolean = comboList(sauceList);
            
            String menu = comboMenu.getSelectedItem().toString();
            String bread = comboBread.getSelectedItem().toString();
            String extra = comboExtra.getSelectedItem().toString();
            String sauce = comboSauce.getSelectedItem().toString();
            String length = comboLength.getSelectedItem().toString();
            
            int menuCal = 0;
            int menuPri = 0;
            int breadCal = 0;
            int extraCal = 0;
            int extraPri = 0;
            int sauceCal = 0;

            /*
             * �޴� Į�θ�, ���� ���� ����
             */
            for(int i = 0; i < menuList.size(); i++) {
                if(menu.equals(menuBoolean[i])) {
                   menuCal = menuList.get(i).getIngredCalorie();
                   if(length.equals("15")) {
                       menuPri = menuList.get(i).getIngredPrice15();
                   }else if(length.equals("30")) {
                       menuPri = menuList.get(i).getIngredPrice30();
                   }
                }
            }
            /*
             * �� Į�θ� ����
             */
            for(int i = 0; i < breadList.size(); i++) {
                if(bread.equals(breadBoolean[i])) {
                    breadCal = breadList.get(i).getIngredCalorie();
                }
            }
            /*
             * ����Ʈ�� Į�θ�, �������� ����
             */
            for(int i = 0; i < extraList.size(); i++) {
                if(extra.equals(extraBoolean[i])) {
                   extraCal = extraList.get(i).getIngredCalorie();
                   if(length.equals("15")) {
                       extraPri = extraList.get(i).getIngredPrice15();
                   }else if(length.equals("30")) {
                       extraPri = extraList.get(i).getIngredPrice30();
                   }
                }
            }
            /*
             * �ҽ� Į�θ� ����
             */
            for(int i = 0; i < sauceList.size(); i++) {
                if(sauce.equals(sauceBoolean[i])) {
                    sauceCal = sauceList.get(i).getIngredCalorie();
                }
            }
            labelPredict.setText((menuCal + breadCal + extraCal + sauceCal) + "Į�θ� " + (menuPri + extraPri) + "��");
            btnOrder.setEnabled(true);
            
            
            
        } else if (e.getSource() == btnOrder) {
            int result = 1;
            if (btnOrder.getText().equals("����")) {
                // ���̿��� ����
                // result=OrderController.orderUpdate
                if (result != 0) {
                    SuccessView.successMessage("������ �����߽��ϴ�.");
                    F.getCardLayout().show(F.getContentPane(), "OrderListView");
                }
                FailView.errorMessage("������ �����߽��ϴ�.");

            } else if (btnOrder.getText().equals("����")) {
                // ���̸޴� ����

            } else {
                // ���� �ֹ���
                // insertOrder -> new OrderDTO()�� �����ؼ� �־���ߵ�
                orderDTO = null;
                if (OrderController.orderInsert(orderDTO) == 0) {
                    FailView.errorMessage("�ֹ��� �����Ͽ����ϴ�.");
                } else {
                    SuccessView.successMessage("�ֹ��� �Ϸ��߽��ϴ�.");
                    init();
                    F.add("orderResultView", new OrderResultView(F));
                    F.getCardLayout().show(F.getContentPane(), "orderResultView");
                }
            }
        }

    }

    private void init() {
        comboMenu.setSelectedIndex(0);
        comboLength.setSelectedIndex(0);
        comboBread.setSelectedIndex(0);
        comboExtra.setSelectedIndex(0);
        comboSauce.setSelectedIndex(0);
        fieldText.setText("");
        labelPredict.setText("");
        labelReSauce.setText("");
        labelReSauceTitle.setVisible(false);
        btnOrder.setEnabled(false);
        // ��ư�ʱ�ȭ�� �߰�

    }

    /*
     * initOrder();
     */
    // orderId�� ���޵Ȱ�� �ֹ������� �ʱ�ȭ
    private void initOrder(int orderId) {
        // �޺��ڽ�, text�� ����

    }

    private String[] comboList(String category) {
        List<IngredientDTO> list = OrderController.menuList(category);
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (category.equals("�޴�")) {
                result[i] = list.get(i).getIngredName() + " || " + list.get(i).getIngredCalorie() + " || "
                        + list.get(i).getIngredPrice15() + " || " + list.get(i).getIngredPrice30() + " || "
                        + list.get(i).getIngredRecommendSauce();
            } else if (category.equals("�߰�����")) {
                result[i] = list.get(i).getIngredName() + " || " + list.get(i).getIngredCalorie() + " || "
                        + list.get(i).getIngredPrice15() + " || " + list.get(i).getIngredPrice30();
            } else {
                result[i] = list.get(i).getIngredName() + " || " + list.get(i).getIngredCalorie();
            }
        }
        return result;
    }

    private String[] comboList(List<IngredientDTO> list) {
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIngredCategory().equals("�޴�")) {
                result[i] = list.get(i).getIngredName() + " || " + list.get(i).getIngredCalorie() + " || "
                        + list.get(i).getIngredPrice15() + " || " + list.get(i).getIngredPrice30() + " || "
                        + list.get(i).getIngredRecommendSauce();
            } else if (list.get(i).getIngredCategory().equals("�߰�����")) {
                result[i] = list.get(i).getIngredName() + " || " + list.get(i).getIngredCalorie() + " || "
                        + list.get(i).getIngredPrice15() + " || " + list.get(i).getIngredPrice30();
            } else {
                result[i] = list.get(i).getIngredName() + " || " + list.get(i).getIngredCalorie();
            }
        }
        return result;
    }

    // orderID�� ���޵Ǿ��� ���̸޴� ������ �ʱ�ȭ
    class ImgPanel extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(img, 0, 0, null);
        }
    }

}
