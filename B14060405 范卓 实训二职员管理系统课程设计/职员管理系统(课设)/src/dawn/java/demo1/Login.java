package dawn.java.demo1;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

//import dawn.java.demo2.*;

import dawn.java.demo2.Menu;

public class Login extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
		//声明变量
		final String admin = "Dawn";
		final String psw = "0211";
		
		JTextField jtf1,jtf2;
		JLabel jlb1,jlb2,jlb3;
		JButton jbt1,jbt2;
		
		//构造方法
		public Login() {
			JFrame jFrame = new JFrame("登陆界面");
			
			//定义显示文本
			jlb1 = new JLabel("用 户：");
			jlb1.setBounds(10, 10, 100, 30);
			jFrame.add(jlb1);
			
			jtf1 = new JTextField();
			jtf1.setBounds(50, 15, 130, 20);
			jFrame.add(jtf1);
			
			jlb2 = new JLabel("密 码：");
			jlb2.setBounds(10, 40, 100, 30);
			jFrame.add(jlb2);

			jtf2 = new JPasswordField();
			jtf2.setBounds(50, 45, 130, 20);
			jFrame.add(jtf2);
			
			//按钮
			jbt1 = new JButton("登 陆");
			jbt1.setBackground(Color.cyan);
			jbt1.setBounds(15, 90, 70, 25);
			
			jbt2 = new JButton("重 置");
			jbt2.setBackground(Color.cyan);
			jbt2.setBounds(105, 90, 70, 25);
			
			jlb3 = new JLabel("版权所有：Dawn");
			jlb3.setBounds(50,115,100,30);
			jFrame.add(jlb3);
			
			jbt1.addActionListener(this);
			jFrame.add(jbt1);
			jbt2.addActionListener(this);
			jFrame.add(jbt2);
			
			//界面大小及位置
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			jFrame.setBounds(((int) dimension.getWidth() - 200) / 2,
					((int) dimension.getHeight() - 300) / 2, 200, 170);
			jFrame.setResizable(false);	//设置宽高固定不可拖拽
			jFrame.setLayout(null);
			
			jFrame.getRootPane().setDefaultButton(jbt1);	//设置回车默认键
			jFrame.setVisible(true);
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		//监听操作
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jbt1){
				if(admin.equals(jtf1.getText())&& psw.equals(jtf2.getText())){
					JOptionPane.showMessageDialog(null, "登陆成功,进入职员管理系统！", "提示",
							JOptionPane.INFORMATION_MESSAGE);
		           
					new Menu(); //连接到菜单
					this.dispose();
					
				} else {
					JOptionPane.showMessageDialog(null, "账号或密码输入错误，请重新输入！", "提示",
							JOptionPane.ERROR_MESSAGE);
					//jtf1.setText("");
					jtf2.setText("");
				}
			}else if(e.getSource()==jbt2){
				jtf1.setText("");
				jtf2.setText("");
			}
		}
		//主函数
		public static void main(String[] args) {
			new Login();
		}			
}