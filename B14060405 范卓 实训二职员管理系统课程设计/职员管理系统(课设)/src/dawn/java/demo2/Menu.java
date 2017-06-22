package dawn.java.demo2;

import java.sql.*;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;//���¼���Ӧ

import dawn.java.demo3.*;

public class Menu extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	//����ؼ�����
	JPanel jp1,jp2;
	JLabel jl1,jl2,jl3;
	JTable jt;
	JButton jbt,jbt1,jbt2,jbt3,jbt4,jbt5,jbt6,jbt7;
	JScrollPane jsp;
	JTextField jtf;
	MySql sm;

	//�������ݿ������������ֵΪ��
	PreparedStatement pstm=null;
	Connection conn=null;
	ResultSet res=null;
		
	//���캯��
	public Menu (){
		//���ô���
		jp1=new JPanel();
		jp1.setBackground(Color.GREEN);
		//����Ų�ѯְԱ��Ϣ
		jl1=new JLabel("������ְԱ���");
		jp1.add(jl1);
		jtf=new JTextField(10);
		jp1.add(jtf);
		jbt1=new JButton("��ѯ");
		jbt1.setBackground(Color.GRAY);
		jp1.add(jbt1);
		jbt1.addActionListener(this);
		
		jbt=new JButton("��ʾ����ְԱ");
		jbt.setBackground(Color.GRAY);
		jp1.add(jbt);
		jbt.addActionListener(this);
		
		//��������һ�����壬����Ӱ�ť
		jp2=new JPanel();
		jp2.setBackground(Color.CYAN);
		
		jl2=new JLabel(">> ְԱ���� <<");
		jl2.setBounds(10, 50, 100, 30);
		jp2.add(jl2);
	
		jbt2=new JButton("��  �� ->");
		jbt2.setBounds(10, 90, 90, 30);
		jbt2.setBackground(Color.GRAY);
		jp2.add(jbt2);
		jbt2.addActionListener( this);
		
		jbt3=new JButton("��  �� ->");
		jbt3.setBounds(10, 150, 90, 30);
		jbt3.setBackground(Color.GRAY);
		jp2.add(jbt3);
		jbt3.addActionListener( this);
		
		jbt4=new JButton("ɾ  �� ->");
		jbt4.setBounds(10, 210, 90, 30);
		jbt4.setBackground(Color.GRAY);
		jp2.add(jbt4);
		jbt4.addActionListener( this);
		
		jl3=new JLabel("----------------------------");
		jp2.add(jl3);
		
		jbt5=new JButton("��  �� ->");
		jbt5.setBounds(10, 320, 90, 30);
		jbt5.setBackground(Color.GRAY);
		jp2.add(jbt5);
		jbt5.addActionListener( this);
		
		jbt6=new JButton("ͳ  �� ->");
		jbt6.setBounds(10, 380, 90, 30);
		jbt6.setBackground(Color.GRAY);
		jp2.add(jbt6);
		jbt6.addActionListener( this);
		
		jbt7=new JButton("��  �� ->");
		jbt7.setBounds(10, 440, 90, 30);
		jbt7.setBackground(Color.GRAY);
		jp2.add(jbt7);
		jbt7.addActionListener( this);
		
		//����һ��ģ�Ͷ���
		sm=new MySql();
		//��ʼ��JTable
		jt=new JTable(sm);
		//��ʼ��jsp JScrollPane
		jsp=new JScrollPane(jt);
		//��jsp���뵽JFrame��ȥ
		this.add(jsp);
		//���ô���Ͱ�ťλ��
		this.add(jp1,"North");
		this.add(jp2,"West");
		this.add(jl2,"West");
		this.add(jbt2,"West");
		this.add(jbt3,"West");
		this.add(jbt4,"West");
		this.add(jl3,"West");
		this.add(jbt5,"West");
		this.add(jbt6,"West");
		this.add(jbt7,"West");
		this.add(jl3,"West");
		this.setSize(800,550);//���ô��ڴ�С

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�ر�ʱ���Զ��˳�
		this.setVisible(true);
	
	}
	
	//��������
	@SuppressWarnings("unused")
	public void actionPerformed(ActionEvent arg0) {
		//�ж��ĸ���ť�����
		if(arg0.getSource()==jbt){		//�����ѯ��ť
			//��ʾ����ְԱ
			String sql = "SELECT * FROM user"; 
			//�����µ�����ģ���࣬������
			sm=new MySql(sql);
			jtf.setText("");	//���ҿ����
			//����JTable
			jt.setModel(sm);
		}
		
		if(arg0.getSource()==jbt1){		//�����ѯ��ť
			
			//��ȡ�ı����е�id
			String id=this.jtf.getText().trim();
			String sql = "SELECT * FROM user WHERE id='"+id+"'"; 
			//�����µ�����ģ���࣬������
			sm=new MySql(sql);
			//����JTable
			jt.setModel(sm);
		}
		else if(arg0.getSource()==jbt2){	//�����Ӱ�ť
			Insert root=new Insert(this,"���ְԱ",true);
			//�����µ�����ģ���࣬������
			sm=new MySql();
			//����JTable
			jt.setModel(sm);
		}
		else if(arg0.getSource()==jbt3){	//����޸İ�ť
			//getSelectedRow�����û����е�һ����Ϣ
			int rowNum=this.jt.getSelectedRow();
			//��Ҫѡ��һ����Ϣ�����ûѡ�ͷ���-1����rowNum����
			if(rowNum==-1){
				//��ʾ��Ϣ
				JOptionPane.showMessageDialog(this, "��ѡ����Ҫ�޸ĵ�һ����Ϣ��");
				return;
			}
			//��ʾ�޸ĶԻ���
			new Update(this,"�޸�ְԱ",true,sm,rowNum);
			//�����µ�����ģ���࣬������
			sm=new MySql();
			//����JTable
			jt.setModel(sm);
		}
		else if(arg0.getSource()==jbt4){	//���ɾ����ť,ɾ��ֱ��д�ڴ˴�
			//getSelectedRow�����û����е���
			//����û�ʲô��ûѡ�ͻ᷵��-1
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				//��ʾ��Ϣ
				JOptionPane.showMessageDialog(this, "��ѡ����Ҫɾ����һ����Ϣ��");
				return;
			}
			//��ȡְԱid���ŵ�zyid
			String zyid=(String)sm.getValueAt(rowNum, 0);
			System.out.println("id="+zyid);
			MySql temp=new  MySql();
			String id=this.jtf.getText().trim();
			//�������ݿ����ɾ��
			try{
				//�������ݿ�     
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://127.0.0.1:3306/mysqltest";
				String user="root";
				String pass="0211";
				conn=DriverManager.getConnection(url,user,pass); 
				//ɾ�����
				pstm=conn.prepareStatement("DELETE FROM user WHERE id=?");
				pstm.setString(1, zyid);
				pstm.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				//�ر���Դ
				try{
					if(res!=null) res.close();
					if(pstm!=null) pstm.close();
					if(conn!=null) conn.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			System.out.println("ɾ���ɹ���");
			{JOptionPane.showMessageDialog(null, "ɾ���ɹ�", "��ʾ",
					JOptionPane.INFORMATION_MESSAGE);}
			//��������ģ��
			//�����µ�����ģ���࣬������
			sm=new MySql();
			//����JTable
			jt.setModel(sm);
		}
		else if(arg0.getSource()==jbt5){		//������ڰ�ť
			new Author();
		}
		else if(arg0.getSource()==jbt6){		//���ͳ�ư�ť
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1:3306/mysqltest";
			String user = "root"; 
			String password = "0211";  
			String name; 
			String id ;
			try {                 
					Class.forName(driver);  
					// �������ݿ�       
					Connection conn = DriverManager.getConnection(url, user, password);  
					if(!conn.isClosed())          
						System.out.println("���ӳɹ���");  
					// statement����ִ��SQL���             
	                Statement stmt = conn.createStatement();  
	                // Ҫִ�е�SQL���           
	                String sql = "SELECT * FROM user";  
	                // �����       
	                ResultSet rs = stmt.executeQuery(sql);
	                int i=0;
	                while(rs.next()){
	                	i=i+1;
	                }
	                System.out.println("��ǰ������  " +i+ " ��ְԱ��");
	                {JOptionPane.showMessageDialog(null, "��ǰ������  " +i+ "  ��ְԱ��", "ͳ��",
	    					JOptionPane.INFORMATION_MESSAGE);}
	                stmt.close();
	                conn.close();//�ر����ݿ�����
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(arg0.getSource()==jbt7){		//����˳���ť
			System.exit(0);
		}
	
	}
	//������
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Menu();
	}

}