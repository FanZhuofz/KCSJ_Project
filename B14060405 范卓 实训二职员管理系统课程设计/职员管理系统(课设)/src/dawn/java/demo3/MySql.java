package dawn.java.demo3;

import java.sql.*;

import java.util.Vector;

import javax.swing.table.*;

@SuppressWarnings("serial")
public class MySql extends AbstractTableModel {
			
			@SuppressWarnings("rawtypes")
			Vector rowData ,columnName;		//rowData������������ݣ�columnName�����������
		
			//�������ݿ�����Ҫ�Ķ���
			PreparedStatement ps=null;
			Connection ct=null;
			ResultSet rs=null;

			//ͨ�����ݵ�sql������������ģ��
			@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
			public MySql(String sql){
				columnName=new Vector();
				//��������
				columnName.add("���");
				columnName.add("����");
				columnName.add("����");
				columnName.add("�Ա�");
				columnName.add("�绰");
				columnName.add("����");
				
				rowData=new Vector();
				//�������������Դ�Ŷ���
				Vector row=new Vector();
				String name; 
				String id ;
				try {                    
						Class.forName("com.mysql.jdbc.Driver");  
						// �������ݿ� 
						String url="jdbc:mysql://127.0.0.1:3306/mysqltest";
						String user="root";
						String pass="0211";
						Connection conn = DriverManager.getConnection(url, user, pass);  
						if(!conn.isClosed())          
							System.out.println("���ӳɹ���");  
						// statement����ִ��SQL���             
		                Statement stmt = conn.createStatement();
		                // �����       
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
		            System.out.println("����ʧ�ܣ�");              
		            e.printStackTrace();  
		           } catch(SQLException e) {  
		            e.printStackTrace();  
		           } catch(Exception e) {  
		            e.printStackTrace();  
		           }
				}
			
			//���캯�����ڳ�ʼ������ģ��
			@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
			public MySql(){
				//�������
				columnName=new Vector();
				//��������
				columnName.add("���");
				columnName.add("����");
				columnName.add("����");
				columnName.add("�Ա�");
				columnName.add("�绰");
				columnName.add("����");
				
				rowData=new Vector();
				//�������������Դ�Ŷ���
				Vector hang=new Vector();
				//�����ݿ�ȡ����
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
		                Statement statement = conn.createStatement();  
		                // Ҫִ�е�SQL���           
		                String sql = "SELECT * FROM user";  
		                // �����       
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
		            System.out.println("����ʧ�ܣ�");              
		            e.printStackTrace();  
		           } catch(SQLException e) {  
		            e.printStackTrace();  
		           } catch(Exception e) {  
		            e.printStackTrace();  
		           }
			}

			//�õ����ж�����
			public int getRowCount() {
				
				// TODO Auto-generated method stub
				return this.rowData.size();
			}
			//�õ����ж�����
			public int getColumnCount() {
				// TODO Auto-generated method stub
				return this.columnName.size();
			}
			
			//�õ�ĳ��ĳ�е�����
			@SuppressWarnings("rawtypes")
			public Object getValueAt(int row, int column) {
				// TODO Auto-generated method stub
				return ((Vector)this.rowData.get(row)).get(column);
			}
			//��ʾ�ֶ���
			public String getColumnName(int arg0) {
				// TODO Auto-generated method stub
				return (String)this.columnName.get(arg0);
			}
			
			public boolean updateStudent(String sql, String[] paras) {
				// TODO Auto-generated method stub
				return false;
			}

}
