package dawn.java.demo3;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import java.sql.*;

@SuppressWarnings({ "unused", "serial" })
public class Insert extends JDialog implements ActionListener {
	//�������
	JLabel jl1, jl2,jl3, jl4, jl5 ,jl6; 
	JButton jb1,jb2; 
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6; 
	JPanel jp1,jp2,jp3;
	
	public Insert(Frame owner,String title,boolean modal){		//owner���ĸ����ڣ�title��������modalָ��ģ̬����
		
		super (owner,title, modal); //���ø��๹�췽��,ʵ�ָ���
		
		jl1=new  JLabel("�� �ţ�");
		jtf1=new  JTextField();
		
		jl2=new  JLabel("�� ����");
		jtf2=new  JTextField();
		
		jl3=new  JLabel("�� �䣺");
		jtf3=new  JTextField();
		
		jl4=new  JLabel("�� ��");
		jtf4=new  JTextField();
		
		jl5=new  JLabel("�� ����");
		jtf5=new  JTextField();
		
		jl6=new  JLabel("�� �ţ�");
		jtf6=new  JTextField();

		jb1=new  JButton ("�� ��");
		jb1.addActionListener( this); 
		jb2=new  JButton ("ȡ ��");
		jb2.addActionListener(this);
		
		//���ô��岢��ʾ
		jp1=new JPanel();
		jp1.add(jl1);
		jp1.add(jl2); 
		jp1.add(jl3); 
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		
		jp2=new JPanel();
		jp2.add(jtf1); 
		jp2.add(jtf2); 
		jp2.add(jtf3);
		jp2.add(jtf4); 
		jp2.add(jtf5); 
		jp2.add(jtf6);
		
		jp3=new JPanel();
		jp3.add(jb1); 
		jp3.add(jb2);
		
		//���ò��� 
		jp1.setLayout(new  GridLayout(6,1)); 
		jp2.setLayout(new  GridLayout(6,1));
		
		//����λ��
		this.add(jp1,BorderLayout. WEST ); 
		this.add(jp2,BorderLayout. CENTER ); 
		this.add(jp3,BorderLayout. SOUTH );
		
		//��Ӵ�����ʾ 
		this .setSize(250,230);			//���ڴ�С
		//�������ɫ
		jp1.setBackground(Color.CYAN);
		jp2.setBackground(Color.CYAN);
		jp3.setBackground(Color.CYAN);
		this .setLocation(400, 150);	//�������ϱ߾�
		this .setVisible( true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1){					//�����Ӱ�ť
			PreparedStatement pstmt=null;
			Connection conn=null;
			ResultSet rs=null;
			Statement stmt=null;	
	        try {  
	        	  //�����ݿ� �������ݿ�ȡ����
	 			  Class.forName("com.mysql.jdbc.Driver");
	 			  String url="jdbc:mysql://127.0.0.1:3306/mysqltest";
				  String user="root";
				  String pass="0211";
	           	  conn = DriverManager.getConnection(url, user, pass);  
	              stmt=conn.createStatement();
	              MySql temp =new  MySql();
	              String sql="INSERT INTO user VALUES (?,?,?,?,?,?)"; 
	              pstmt=conn.prepareStatement(sql);
	              pstmt.setString(1, jtf1.getText());
	              pstmt.setString(2, jtf2.getText());
	              pstmt.setString(3, jtf3.getText());
	              pstmt.setString(4, jtf4.getText());
	              pstmt.setString(5, jtf5.getText());
	              pstmt.setString(6, jtf6.getText());
	              pstmt.setString(1, jtf1.getText());
	              pstmt.executeUpdate();
	              this.dispose();
	              //�ڿ���̨���ⴰ����ʾ��ӳɹ�
				  System.out.println("��ӳɹ���");
				  {JOptionPane.showMessageDialog(null, "��ӳɹ���", "��ʾ",
						JOptionPane.INFORMATION_MESSAGE);}
	        	 }catch(ClassNotFoundException el){
	            	el.printStackTrace();
	             }catch(SQLException ex){
	            	ex.printStackTrace();
	             }
	           	 finally{
	        	   try{
	        		   if(rs!=null) rs.close();
	        		   if(stmt!=null) stmt.close();
	        		   if(conn!=null) conn.close();
	        	   }catch(Exception ex){
	        		   ex.printStackTrace();
	        	   }
	           }
	      }else if(e.getSource()==jb2){		//���ȡ����ť
	    	  this.dispose();
	      }
	}
}