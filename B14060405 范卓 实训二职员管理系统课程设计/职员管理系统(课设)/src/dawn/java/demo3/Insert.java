package dawn.java.demo3;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import java.sql.*;

@SuppressWarnings({ "unused", "serial" })
public class Insert extends JDialog implements ActionListener {
	//定义变量
	JLabel jl1, jl2,jl3, jl4, jl5 ,jl6; 
	JButton jb1,jb2; 
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6; 
	JPanel jp1,jp2,jp3;
	
	public Insert(Frame owner,String title,boolean modal){		//owner它的父窗口，title窗口名，modal指定模态窗口
		
		super (owner,title, modal); //调用父类构造方法,实现更新
		
		jl1=new  JLabel("编 号：");
		jtf1=new  JTextField();
		
		jl2=new  JLabel("姓 名：");
		jtf2=new  JTextField();
		
		jl3=new  JLabel("年 龄：");
		jtf3=new  JTextField();
		
		jl4=new  JLabel("性 别：");
		jtf4=new  JTextField();
		
		jl5=new  JLabel("电 话：");
		jtf5=new  JTextField();
		
		jl6=new  JLabel("部 门：");
		jtf6=new  JTextField();

		jb1=new  JButton ("添 加");
		jb1.addActionListener( this); 
		jb2=new  JButton ("取 消");
		jb2.addActionListener(this);
		
		//设置窗体并显示
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
		
		//设置布局 
		jp1.setLayout(new  GridLayout(6,1)); 
		jp2.setLayout(new  GridLayout(6,1));
		
		//设置位置
		this.add(jp1,BorderLayout. WEST ); 
		this.add(jp2,BorderLayout. CENTER ); 
		this.add(jp3,BorderLayout. SOUTH );
		
		//添加窗口显示 
		this .setSize(250,230);			//窗口大小
		//窗体加颜色
		jp1.setBackground(Color.CYAN);
		jp2.setBackground(Color.CYAN);
		jp3.setBackground(Color.CYAN);
		this .setLocation(400, 150);	//设置左、上边距
		this .setVisible( true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1){					//点击添加按钮
			PreparedStatement pstmt=null;
			Connection conn=null;
			ResultSet rs=null;
			Statement stmt=null;	
	        try {  
	        	  //连数据库 ，从数据库取数据
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
	              //在控制台和外窗口提示添加成功
				  System.out.println("添加成功！");
				  {JOptionPane.showMessageDialog(null, "添加成功！", "提示",
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
	      }else if(e.getSource()==jb2){		//点击取消按钮
	    	  this.dispose();
	      }
	}
}