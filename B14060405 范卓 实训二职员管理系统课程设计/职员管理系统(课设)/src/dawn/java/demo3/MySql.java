package dawn.java.demo3;

import java.sql.*;

import java.util.Vector;

import javax.swing.table.*;

@SuppressWarnings("serial")
public class MySql extends AbstractTableModel {
			
			@SuppressWarnings("rawtypes")
			Vector rowData ,columnName;		//rowData用来存放行数据，columnName用来存放列名
		
			//定义数据库所需要的东西
			PreparedStatement ps=null;
			Connection ct=null;
			ResultSet rs=null;

			//通过传递的sql语句来获得数据模型
			@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
			public MySql(String sql){
				columnName=new Vector();
				//设置列名
				columnName.add("编号");
				columnName.add("姓名");
				columnName.add("年龄");
				columnName.add("性别");
				columnName.add("电话");
				columnName.add("部门");
				
				rowData=new Vector();
				//设置行名，可以存放多行
				Vector row=new Vector();
				String name; 
				String id ;
				try {                    
						Class.forName("com.mysql.jdbc.Driver");  
						// 连续数据库 
						String url="jdbc:mysql://127.0.0.1:3306/mysqltest";
						String user="root";
						String pass="0211";
						Connection conn = DriverManager.getConnection(url, user, pass);  
						if(!conn.isClosed())          
							System.out.println("连接成功！");  
						// statement用来执行SQL语句             
		                Statement stmt = conn.createStatement();
		                // 结果集       
		                ResultSet rs = stmt.executeQuery(sql);
		                while(rs.next()){
			            	Vector row1=new Vector();
			            	row1.add(rs.getString(1));
			            	row1.add(rs.getString(2));
			            	row1.add(rs.getInt(3));
			            	row1.add(rs.getString(4));
			            	row1.add(rs.getString(5));
			            	row1.add(rs.getString(6));
			            	rowData.add(row1);
		                }
		                rs.close();
		                conn.close();
		           }catch(ClassNotFoundException e) {  
		            System.out.println("连接失败！");              
		            e.printStackTrace();  
		           } catch(SQLException e) {  
		            e.printStackTrace();  
		           } catch(Exception e) {  
		            e.printStackTrace();  
		           }
				}
			
			//构造函数用于初始化数据模型
			@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
			public MySql(){
				//内容设计
				columnName=new Vector();
				//设置列名
				columnName.add("编号");
				columnName.add("姓名");
				columnName.add("年龄");
				columnName.add("性别");
				columnName.add("电话");
				columnName.add("部门");
				
				rowData=new Vector();
				//设置行名，可以存放多行
				Vector hang=new Vector();
				//从数据库取数据
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
		                Statement statement = conn.createStatement();  
		                // 要执行的SQL语句           
		                String sql = "SELECT * FROM user";  
		                // 结果集       
		                ResultSet rs = statement.executeQuery(sql);
		                while(rs.next()){
			            	Vector row1=new Vector();
			            	row1.add(rs.getString(1));
			            	row1.add(rs.getString(2));
			            	row1.add(rs.getInt(3));
			            	row1.add(rs.getString(4));
			            	row1.add(rs.getString(5));
			            	row1.add(rs.getString(6));
			            	rowData.add(row1);
		                }
		                rs.close();
		                conn.close();
				   }catch(ClassNotFoundException e) {  
		            System.out.println("连接失败！");              
		            e.printStackTrace();  
		           } catch(SQLException e) {  
		            e.printStackTrace();  
		           } catch(Exception e) {  
		            e.printStackTrace();  
		           }
			}

			//得到共有多少行
			public int getRowCount() {
				
				// TODO Auto-generated method stub
				return this.rowData.size();
			}
			//得到共有多少列
			public int getColumnCount() {
				// TODO Auto-generated method stub
				return this.columnName.size();
			}
			
			//得到某行某列的数据
			@SuppressWarnings("rawtypes")
			public Object getValueAt(int row, int column) {
				// TODO Auto-generated method stub
				return ((Vector)this.rowData.get(row)).get(column);
			}
			//显示字段名
			public String getColumnName(int arg0) {
				// TODO Auto-generated method stub
				return (String)this.columnName.get(arg0);
			}
			
			public boolean updateStudent(String sql, String[] paras) {
				// TODO Auto-generated method stub
				return false;
			}

}
