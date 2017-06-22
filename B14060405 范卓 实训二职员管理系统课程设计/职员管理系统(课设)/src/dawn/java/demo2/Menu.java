package dawn.java.demo2;

import java.sql.*;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;//对事件响应

import dawn.java.demo3.*;

public class Menu extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	//定义控件变量
	JPanel jp1,jp2;
	JLabel jl1,jl2,jl3;
	JTable jt;
	JButton jbt,jbt1,jbt2,jbt3,jbt4,jbt5,jbt6,jbt7;
	JScrollPane jsp;
	JTextField jtf;
	MySql sm;

	//定义数据库变量，并赋初值为空
	PreparedStatement pstm=null;
	Connection conn=null;
	ResultSet res=null;
		
	//构造函数
	public Menu (){
		//设置窗体
		jp1=new JPanel();
		jp1.setBackground(Color.GREEN);
		//按编号查询职员信息
		jl1=new JLabel("请输入职员编号");
		jp1.add(jl1);
		jtf=new JTextField(10);
		jp1.add(jtf);
		jbt1=new JButton("查询");
		jbt1.setBackground(Color.GRAY);
		jp1.add(jbt1);
		jbt1.addActionListener(this);
		
		jbt=new JButton("显示所有职员");
		jbt.setBackground(Color.GRAY);
		jp1.add(jbt);
		jbt.addActionListener(this);
		
		//设置另外一个窗体，并添加按钮
		jp2=new JPanel();
		jp2.setBackground(Color.CYAN);
		
		jl2=new JLabel(">> 职员操作 <<");
		jl2.setBounds(10, 50, 100, 30);
		jp2.add(jl2);
	
		jbt2=new JButton("添  加 ->");
		jbt2.setBounds(10, 90, 90, 30);
		jbt2.setBackground(Color.GRAY);
		jp2.add(jbt2);
		jbt2.addActionListener( this);
		
		jbt3=new JButton("修  改 ->");
		jbt3.setBounds(10, 150, 90, 30);
		jbt3.setBackground(Color.GRAY);
		jp2.add(jbt3);
		jbt3.addActionListener( this);
		
		jbt4=new JButton("删  除 ->");
		jbt4.setBounds(10, 210, 90, 30);
		jbt4.setBackground(Color.GRAY);
		jp2.add(jbt4);
		jbt4.addActionListener( this);
		
		jl3=new JLabel("----------------------------");
		jp2.add(jl3);
		
		jbt5=new JButton("关  于 ->");
		jbt5.setBounds(10, 320, 90, 30);
		jbt5.setBackground(Color.GRAY);
		jp2.add(jbt5);
		jbt5.addActionListener( this);
		
		jbt6=new JButton("统  计 ->");
		jbt6.setBounds(10, 380, 90, 30);
		jbt6.setBackground(Color.GRAY);
		jp2.add(jbt6);
		jbt6.addActionListener( this);
		
		jbt7=new JButton("退  出 ->");
		jbt7.setBounds(10, 440, 90, 30);
		jbt7.setBackground(Color.GRAY);
		jp2.add(jbt7);
		jbt7.addActionListener( this);
		
		//创建一个模型对象
		sm=new MySql();
		//初始化JTable
		jt=new JTable(sm);
		//初始化jsp JScrollPane
		jsp=new JScrollPane(jt);
		//把jsp放入到JFrame中去
		this.add(jsp);
		//设置窗体和按钮位置
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
		this.setSize(800,550);//设置窗口大小

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭时候自动退出
		this.setVisible(true);
	
	}
	
	//监听操作
	@SuppressWarnings("unused")
	public void actionPerformed(ActionEvent arg0) {
		//判断哪个按钮被点击
		if(arg0.getSource()==jbt){		//点击查询按钮
			//显示所有职员
			String sql = "SELECT * FROM user"; 
			//构建新的数据模型类，并更新
			sm=new MySql(sql);
			jtf.setText("");	//查找框清空
			//更新JTable
			jt.setModel(sm);
		}
		
		if(arg0.getSource()==jbt1){		//点击查询按钮
			
			//获取文本框中的id
			String id=this.jtf.getText().trim();
			String sql = "SELECT * FROM user WHERE id='"+id+"'"; 
			//构建新的数据模型类，并更新
			sm=new MySql(sql);
			//更新JTable
			jt.setModel(sm);
		}
		else if(arg0.getSource()==jbt2){	//点击添加按钮
			Insert root=new Insert(this,"添加职员",true);
			//构建新的数据模型类，并更新
			sm=new MySql();
			//更新JTable
			jt.setModel(sm);
		}
		else if(arg0.getSource()==jbt3){	//点击修改按钮
			//getSelectedRow返回用户点中的一行信息
			int rowNum=this.jt.getSelectedRow();
			//需要选择一行信息，如果没选就返回-1，用rowNum接收
			if(rowNum==-1){
				//提示信息
				JOptionPane.showMessageDialog(this, "请选择需要修改的一行信息！");
				return;
			}
			//显示修改对话框
			new Update(this,"修改职员",true,sm,rowNum);
			//构建新的数据模型类，并更新
			sm=new MySql();
			//更新JTable
			jt.setModel(sm);
		}
		else if(arg0.getSource()==jbt4){	//点击删除按钮,删除直接写在此处
			//getSelectedRow返回用户点中的行
			//如果用户什么都没选就会返回-1
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				//提示信息
				JOptionPane.showMessageDialog(this, "请选择需要删除的一行信息！");
				return;
			}
			//获取职员id，放到zyid
			String zyid=(String)sm.getValueAt(rowNum, 0);
			System.out.println("id="+zyid);
			MySql temp=new  MySql();
			String id=this.jtf.getText().trim();
			//连接数据库完成删除
			try{
				//连续数据库     
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://127.0.0.1:3306/mysqltest";
				String user="root";
				String pass="0211";
				conn=DriverManager.getConnection(url,user,pass); 
				//删除语句
				pstm=conn.prepareStatement("DELETE FROM user WHERE id=?");
				pstm.setString(1, zyid);
				pstm.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				//关闭资源
				try{
					if(res!=null) res.close();
					if(pstm!=null) pstm.close();
					if(conn!=null) conn.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			System.out.println("删除成功！");
			{JOptionPane.showMessageDialog(null, "删除成功", "提示",
					JOptionPane.INFORMATION_MESSAGE);}
			//更新数据模型
			//构建新的数据模型类，并更新
			sm=new MySql();
			//更新JTable
			jt.setModel(sm);
		}
		else if(arg0.getSource()==jbt5){		//点击关于按钮
			new Author();
		}
		else if(arg0.getSource()==jbt6){		//点击统计按钮
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1:3306/mysqltest";
			String user = "root"; 
			String password = "0211";  
			String name; 
			String id ;
			try {                 
					Class.forName(driver);  
					// 连续数据库       
					Connection conn = DriverManager.getConnection(url, user, password);  
					if(!conn.isClosed())          
						System.out.println("连接成功！");  
					// statement用来执行SQL语句             
	                Statement stmt = conn.createStatement();  
	                // 要执行的SQL语句           
	                String sql = "SELECT * FROM user";  
	                // 结果集       
	                ResultSet rs = stmt.executeQuery(sql);
	                int i=0;
	                while(rs.next()){
	                	i=i+1;
	                }
	                System.out.println("当前共计有  " +i+ " 名职员！");
	                {JOptionPane.showMessageDialog(null, "当前共计有  " +i+ "  名职员！", "统计",
	    					JOptionPane.INFORMATION_MESSAGE);}
	                stmt.close();
	                conn.close();//关闭数据库连接
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(arg0.getSource()==jbt7){		//点击退出按钮
			System.exit(0);
		}
	
	}
	//主函数
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Menu();
	}

}