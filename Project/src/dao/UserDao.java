package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;



public class UserDao {

	public User findByLoginInfo(String loginId, String password) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn=null;

		try {
			conn=DBmanager.getConnection();

			String sql="SELECT * FROM user WHERE login_id=? and password=?";

			PreparedStatement pStmt=conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, password);
			ResultSet rs=pStmt.executeQuery();

			if(!rs.next()) {
				return null;
			}
			String loginIdData = rs.getString("login_id");
			String nameData=rs.getString("name");
			return new User(loginIdData,nameData);

		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			if (conn!=null) {
				try {
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
					return null;
				}
			}
		}
	}

	public List<User> findAll() {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn=null;
		List<User> userList=new ArrayList<User>();

		try {
			conn=DBmanager.getConnection();

			String sql="SELECT * FROM user WHERE login_id != 'admin' ";

			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);

			while (rs.next()) {
				String id = rs.getString("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");
				User user = new User(id,loginId,name, birthDate, password, createDate, updateDate);

				userList.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;

				}
			}
		}
		return userList;
	}

	public List<User> select(String loginId,String name,String birthDateS,String birthDateE) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn=null;
		List<User> userList=new ArrayList<User>();

		try {
			conn=DBmanager.getConnection();

			String sql="SELECT * FROM user WHERE login_id != 'admin' ";

			if(!loginId.isEmpty()) {
				sql  += "AND login_id= '" + loginId + "' ";
			}
			if(!name.isEmpty()) {
				sql += "AND name LIKE '%" + name + "%' ";
			}
			if(!birthDateS.isEmpty()) {
				sql += "AND birth_date >=  '" + birthDateS + "' ";
			}
			if(!birthDateE.isEmpty()) {
				sql += "AND  birth_date <=  '" + birthDateE + "' ";
			}



			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);



				while (rs.next()) {
					String id = rs.getString("id");
					String loginId1 = rs.getString("login_id");
					String name1 = rs.getString("name");
					Date birthDate = rs.getDate("birth_date");
					String password = rs.getString("password");
					String createDate = rs.getString("create_date");
					String updateDate = rs.getString("update_date");
					User user = new User(id,loginId1,name1, birthDate, password, createDate, updateDate);


				userList.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;

				}
			}
		}
		return userList;
	}

	public void signUp(String login_id, String name, String password, String pwc, String birthDate)throws SQLException{
		// TODO 自動生成されたメソッド・スタブ
		Connection conn=null;

		conn=DBmanager.getConnection();


		try {
			conn=DBmanager.getConnection();

			String sql="insert into user(login_id,name,password,birth_date,create_date,update_date)Values(?,?,?,?,now(),now())";

			PreparedStatement pStmt=conn.prepareStatement(sql);
			pStmt.setString(1, login_id);
			pStmt.setString(2, name);
			pStmt.setString(3, password);
			pStmt.setString(4, birthDate);



			pStmt.executeUpdate();


		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if (conn!=null) {
				try {
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	}



	public User findByid(String id) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBmanager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM user WHERE id = ?";

			// SELECTを実行し、結果表を取得

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,id);
			ResultSet rs = pStmt.executeQuery();

			// 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
			if (!rs.next()) {
				return null;
			}


			String loginId = rs.getString("login_id");
			String name = rs.getString("name");
			Date birthDate = rs.getDate("birth_date");
			String password = rs.getString("password");
			String createDate = rs.getString("create_date");
			String updateDate = rs.getString("update_date");
			return new User(id,loginId, name, birthDate, password, createDate, updateDate);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}

	public void Update(String name, String password, String birthDate,String id) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn=null;

		conn=DBmanager.getConnection();


		try {
			conn=DBmanager.getConnection();

			String sql="UPDATE user SET name = ?,password=?,birth_date=?,update_date=now() WHERE id = ?;";


			PreparedStatement pStmt=conn.prepareStatement(sql);

			pStmt.setString(1, name);
			pStmt.setString(2, password);
			pStmt.setString(3, birthDate);
			pStmt.setString(4, id);




			pStmt.executeUpdate();


		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if (conn!=null) {
				try {
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	}



public void Delete(String id) {
	// TODO 自動生成されたメソッド・スタブ
	Connection conn=null;

	conn=DBmanager.getConnection();


	try {
		conn=DBmanager.getConnection();

		String sql="DELETE FROM user WHERE id=?";



		PreparedStatement pStmt=conn.prepareStatement(sql);


		pStmt.setString(1, id);

		pStmt.executeUpdate();


	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		if (conn!=null) {
			try {
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}

public void Update(String name, String birthDate, String id) {
	// TODO 自動生成されたメソッド・スタブ
	Connection conn=null;

	conn=DBmanager.getConnection();


	try {
		conn=DBmanager.getConnection();

		String sql="UPDATE user SET name = ?,birth_date=?,update_date=now() WHERE id = ?;";


		PreparedStatement pStmt=conn.prepareStatement(sql);

		pStmt.setString(1, name);
		pStmt.setString(2, birthDate);
		pStmt.setString(3, id);




		pStmt.executeUpdate();


	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		if (conn!=null) {
			try {
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}

}



