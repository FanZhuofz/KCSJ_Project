package dawn.java.demo1;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

//import dawn.java.demo2.*;

import dawn.java.demo2.Menu;

public class Login extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
		//��������
		final String admin = "Dawn";
		final String psw = "0211";
		
		JTextField jtf1,jtf2;
		JLabel jlb1,jlb2,jlb3;
		JButton jbt1,jbt2;
		
		//���췽��
		public Login() {
			JFrame jFrame = new JFrame("��½����");
			
			//������ʾ�ı�
			jlb1 = new JLabel("�� ����");
			jlb1.setBounds(10, 10, 100, 30);
			jFrame.add(jlb1);
			
			jtf1 = new JTextField();
			jtf1.setBounds(50, 15, 130, 20);
			jFrame.add(jtf1);
			
			jlb2 = new JLabel("�� �룺");
			jlb2.setBounds(10, 40, 100, 30);
			jFrame.add(jlb2);

			jtf2 = new JPasswordField();
			jtf2.setBounds(50, 45, 130, 20);
			jFrame.add(jtf2);
			
			//��ť
			jbt1 = new JButton("�� ½");
			jbt1.setBackground(Color.cyan);
			jbt1.setBounds(15, 90, 70, 25);
			
			jbt2 = new JButton("�� ��");
			jbt2.setBackground(Color.cyan);
			jbt2.setBounds(105, 90, 70, 25);
			
			jlb3 = new JLabel("��Ȩ���У�Dawn");
			jlb3.setBounds(50,115,100,30);
			jFrame.add(jlb3);
			
			jbt1.addActionListener(this);
			jFrame.add(jbt1);
			jbt2.addActionListener(this);
			jFrame.add(jbt2);
			
			//�����С��λ��
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			jFrame.setBounds(((int) dimension.getWidth() - 200) / 2,
					((int) dimension.getHeight() - 300) / 2, 200, 170);
			jFrame.setResizable(false);	//���ÿ�߹̶�������ק
			jFrame.setLayout(null);
			
			jFrame.getRootPane().setDefaultButton(jbt1);	//���ûس�Ĭ�ϼ�
			jFrame.setVisible(true);
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		//��������
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jbt1){
				if(admin.equals(jtf1.getText())&& psw.equals(jtf2.getText())){
					JOptionPane.showMessageDialog(null, "��½�ɹ�,����ְԱ����ϵͳ��", "��ʾ",
							JOptionPane.INFORMATION_MESSAGE);
		           
					new Menu(); //���ӵ��˵�
					this.dispose();
					
				} else {
					JOptionPane.showMessageDialog(null, "�˺Ż���������������������룡", "��ʾ",
							JOptionPane.ERROR_MESSAGE);
					//jtf1.setText("");
					jtf2.setText("");
				}
			}else if(e.getSource()==jbt2){
				jtf1.setText("");
				jtf2.setText("");
			}
		}
		//������
		public static void main(String[] args) {
			new Login();
		}			
}