package dawn.java.demo2;

import java.awt.*;

import javax.swing.*;

public class Author extends JFrame {

	private static final long serialVersionUID = 1L;

	//构造方法，创建窗口
	public Author(){
		super("关于");			//调用基类构造方法，设置窗口标题
		setSize(500,340);				//设置窗口大小
		setLocation(500, 150);			//距左、上距离
		setVisible(true);				//显示窗口
	}
	public void paint(Graphics g) {
	//这个方法的参数是Graphics类的对象，是由浏览器传递过来的
		super.paint(g);		//调用其超类JApplet类的paint方法
		
		g.setFont(new Font("华文楷体",Font.BOLD,20));		//设置字体
		g.drawString("查询结果", 120, 50);	//绘制字符串
		
		g.drawLine(20, 60, 280, 60);		//绘制直线
		
		g.setFont(new Font("宋体",Font.BOLD,15));
		g.drawString("系 别：计算机信息与技术系", 60, 90);
		
		g.setFont(new Font("宋体",Font.BOLD,15));
		g.drawString("班 级：B140604", 60, 120);
		
		g.setFont(new Font("宋体",Font.BOLD,15));
		g.drawString("学 号：B14060405", 60, 150);
		
		g.setFont(new Font("宋体",Font.BOLD,15));
		g.drawString("姓 名：范  卓", 60, 180);
		
		g.setFont(new Font("宋体",Font.BOLD,15));
		g.drawString("开发语言：Java", 60, 210);
		
		g.drawLine(20, 230, 280, 230);		//绘制直线
		
		g.setFont(new Font("宋体",Font.BOLD,12));
		g.drawString("版权所有：Dawn", 100, 250);
		
		g.setFont(new Font("宋体",Font.BOLD,12));
		g.drawString("Email：fans@e-team.cn", 70, 270);
		
	}
	
	public static void main(String[] args) {
		extracted();
											//设置窗口的外观感觉为Java默认
		Author application = new Author();
											//创建GraphicsTester类的一个实例
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

	private static void extracted() {
		JFrame.setDefaultLookAndFeelDecorated(true);
	}
}