package dawn.java.demo2;

import java.awt.*;

import javax.swing.*;

public class Author extends JFrame {

	private static final long serialVersionUID = 1L;

	//���췽������������
	public Author(){
		super("����");			//���û��๹�췽�������ô��ڱ���
		setSize(500,340);				//���ô��ڴ�С
		setLocation(500, 150);			//�����Ͼ���
		setVisible(true);				//��ʾ����
	}
	public void paint(Graphics g) {
	//��������Ĳ�����Graphics��Ķ���������������ݹ�����
		super.paint(g);		//�����䳬��JApplet���paint����
		
		g.setFont(new Font("���Ŀ���",Font.BOLD,20));		//��������
		g.drawString("��ѯ���", 120, 50);	//�����ַ���
		
		g.drawLine(20, 60, 280, 60);		//����ֱ��
		
		g.setFont(new Font("����",Font.BOLD,15));
		g.drawString("ϵ �𣺼������Ϣ�뼼��ϵ", 60, 90);
		
		g.setFont(new Font("����",Font.BOLD,15));
		g.drawString("�� ����B140604", 60, 120);
		
		g.setFont(new Font("����",Font.BOLD,15));
		g.drawString("ѧ �ţ�B14060405", 60, 150);
		
		g.setFont(new Font("����",Font.BOLD,15));
		g.drawString("�� ������  ׿", 60, 180);
		
		g.setFont(new Font("����",Font.BOLD,15));
		g.drawString("�������ԣ�Java", 60, 210);
		
		g.drawLine(20, 230, 280, 230);		//����ֱ��
		
		g.setFont(new Font("����",Font.BOLD,12));
		g.drawString("��Ȩ���У�Dawn", 100, 250);
		
		g.setFont(new Font("����",Font.BOLD,12));
		g.drawString("Email��fans@e-team.cn", 70, 270);
		
	}
	
	public static void main(String[] args) {
		extracted();
											//���ô��ڵ���۸о�ΪJavaĬ��
		Author application = new Author();
											//����GraphicsTester���һ��ʵ��
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

	private static void extracted() {
		JFrame.setDefaultLookAndFeelDecorated(true);
	}
}