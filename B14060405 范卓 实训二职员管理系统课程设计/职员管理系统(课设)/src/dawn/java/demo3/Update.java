package dawn.java.demo3;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JLabel.*;
import javax.swing.JPanel.*;
import javax.swing.JButton.*;
@SuppressWarnings({ "unused", "serial" })
public class Update extends JDialog implements ActionListener {
	//定义所需要的组建
	JLabel jl1, jl2,jl3, jl4, jl5 ,jl6; 
	JButton jb1,jb2; 
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6; 
	JPanel jp1,jp2,jp3;
	//owner它的父窗口
	//title窗口名
	//modal指定模态窗口，还是非模态窗口
	public Update(Frame owner,String title,boolean modal,MySql sm,int rowNums){
		super (owner,title, modal); //调用父类构造方法,达到模式对话框效果
		
		jl1=new  JLabel("编 号");
		jtf1=new  JTextField();
		//初始化数据
		jtf1.setText((String)sm.getValueAt(rowNums, 0));
		//让jtf1不能修改.false不能修改，true可以修改
		jtf1.setEditable(false);
		
		jl2=new  JLabel("姓 名");
		jtf2=new  JTextField();
		jtf2.setText((String)sm.getValueAt(rowNums, 1));
		
		jl3=new  JLabel("年 龄");
		jtf3=new  JTextField();
		jtf3.setText(sm.getValueAt(rowNums, 2).toString());
		
		
		jl4=new  JLabel("性 别");
		jtf4=new  JTextField();
		jtf4.setText((String)sm.getValueAt(rowNums, 3));
		
		jl5=new  JLabel("电 话");
		jtf5=new  JTextField();
		jtf5.setText((String)sm.getValueAt(rowNums, 4));
		
		jl6=new  JLabel("部 门");
		jtf6=new  JTextField();
		jtf6.setText((String)sm.getValueAt(rowNums, 5));

		jb1=new  JButton ("修 改");
		jb1.addActionListener( this); 
		jb2=new  JButton ("取 消");
		jb2.addActionListener(this);
		
		//设置窗体，添加组件
		jp1=new  JPanel();
		jp1.add(jl1);
		jp1.add(jl2); 
		jp1.add(jl3); 
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		
		jp2=new  JPanel();
		jp2.add(jtf1); 
		jp2.add(jtf2); 
		jp2.add(jtf3);
		jp2.add(jtf4); 
		jp2.add(jtf5); 
		jp2.add(jtf6);
		
		jp3=new  JPanel();
		jp3.add(jb1); 
		jp3.add(jb2);
		
		//设置布局 
		jp1.setLayout(new  GridLayout(6,1)); 
		jp2.setLayout(new  GridLayout(6,1));

		//设置位置
		this.add(jp1,BorderLayout. WEST ); 
		this.add(jp2,BorderLayout. CENTER ); 
		this.add(jp3,BorderLayout. SOUTH );
		
		this.setSize(250,230);		//设置窗口大小 
		jp1.setBackground(Color.CYAN);
		jp2.setBackground(Color.CYAN);
		jp3.setBackground(Color.CYAN);
		this.setLocation(500, 150); 		//设置左、上边距
		this.setVisible( true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1){
			PreparedStatement pstmt=null;
			Connection conn=null;
			ResultSet rs=null;
			Statement stmt=null;	
	        try {  
	        	 //从数据库取数据
	 			 Class.forName("com.mysql.jdbc.Driver"); 
		 		 String url="jdbc:mysql://127.0.0.1:3306/mysqltest";
				 String user="root";
				 String pass="0211";
	           	 conn = DriverManager.getConnection(url, user, pass);  
	             stmt=conn.createStatement();
	             MySql temp =new  MySql(); 
	             String sql="UPDATE user SET name=?,age=?,sex=?,tel=?,work=? where id=?";
	             pstmt=conn.prepareStatement(sql);
	             //给？赋值
	             pstmt.setString(1, jtf2.getText());
	             pstmt.setString(2, jtf3.getText());
	             pstmt.setString(3, jtf4.getText());
	             pstmt.setString(4, jtf5.getText());
	             pstmt.setString(5, jtf6.getText());
	             pstmt.setString(6, jtf1.getText());
	             pstmt.executeUpdate();
	             this.dispose();

	             //在控制台和外部窗口显示修改成功
	             System.out.println("修改成功！");
				 {JOptionPane.showMessageDialog(null, "修改成功", "提示",
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
	            	 		} catch(Exception ex) {
	            	 			ex.printStackTrace();
	            	 		}
	             }
	      }else if(e.getSource()==jb2){		//点击取消按钮,关闭窗口
	    	  this.dispose();
	  	  }
	}
}