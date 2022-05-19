package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	public static void main(String[] args) {

	}

	// 개인 별 친구 목록에서 친구 삭제
	public static void deleteFriend(String ID, String FID) {
		Connection con = getConnection();
		try {
			String sql = "DELETE FROM " + ID + " WHERE FID = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setNString(1, FID);
			int update = statement.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 전체 방에서 방 삭제
	public static void deleteRoom(String Room) {
		Connection con = getConnection();
		try {
			String sql = "DELETE FROM Room WHERE Room = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setNString(1, Room);
			int update = statement.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 개인 별 방 목록에서 방 삭제
	public static void deleteUserRoom(String ID, String Room) {
		Connection con = getConnection();
		try {
			String sql = "DELETE FROM " + ID + "_Room WHERE Room = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setNString(1, Room);
			int update = statement.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 방 안에 있는 ID 삭제
	public static void deleteRoomnum(String ID, String Roomnum) {
		Connection con = getConnection();
		try {
			String sql = "DELETE FROM Room" + Roomnum + " WHERE ID = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setNString(1, ID);
			int update = statement.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 개인 별 친구 목록에서 친구 추가
	public static void addFriend(String ID, String FID) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO " + ID
					+ "(FID) "
					+ "VALUES "
					+ "('" + FID + "')");
			insert.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 전체 방에서 방 추가
	public static void addRoom(String Room) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO Room"
					+ "(Room) "
					+ "VALUES "
					+ "('" + Room + "')");
			insert.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 개인 별 방 목록에 방 추가
	public static void addUserRoom(String ID, String Room) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO " + ID + "_Room"
					+ "(Room) "
					+ "VALUES "
					+ "('" + Room + "')");
			insert.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 전체 방 현황 체크
	public static Boolean checkRoom(String Room) {
		Connection con = getConnection();
		try {
			String sql = "SELECT COUNT(*) cnt FROM Room WHERE Room=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setNString(1, Room);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				int cnt = result.getInt("cnt");
				if (cnt>0)
					return true;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con=null;
		}
		return false;
	}

	// 해당하는 번호의 방이 있는지 체크
	public static Boolean checkRoomnum(String Roomnum) {
		Connection con = getConnection();
		try {
			String sql = "SELECT COUNT(*) cnt FROM Room" + Roomnum;
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				int cnt = result.getInt("cnt");
				if (cnt>1)
					return true;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con=null;
		}
		return false;
	}

	// 개인 별 친구 목록 반환
	public static String[][] getFriends(String ID) {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement(
					"SELECT * FROM " + ID);
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
						results.getString("FID")
				});
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][1];
			return list.toArray(arr);

		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// 전체 방 정보 반환
	public static String[][] getRooms() {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement(
					"SELECT * FROM Room");
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
						results.getString("Room")
				});
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][1];
			return list.toArray(arr);

		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// 개인 별 방 목록 반환
	public static String[][] getUserRooms(String ID) {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement(
					"SELECT * FROM " + ID + "_Room");
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
						results.getString("Room")
				});
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][1];
			return list.toArray(arr);

		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// 음식 썸네일 반환
	public static String[][] getThumbnail() {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement(
					"SELECT * FROM 음식");
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
						results.getString("thumbnail")
				});
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][1];
			return list.toArray(arr);

		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// 음식 타이틀 반환
	public static String[][] getTitle() {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement(
					"SELECT * FROM 음식");
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
						results.getString("title")
				});
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][1];
			return list.toArray(arr);

		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// 음식 정보 반환
	public static ArrayList<DTO> getFoods() {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement(
					"SELECT * FROM 음식");
			ResultSet results = statement.executeQuery();
			ArrayList<DTO> dtos = new ArrayList<DTO>();
			while(results.next()) {
				String title = results.getString("title");
				String intro = results.getString("intro");
				String ingredient =	results.getString("ingredient");
				String step = results.getString("step");
				String thumbnail = results.getString("thumbnail");
				String stepimg = results.getString("stepimg");
				String thema = results.getString("thema");
				String taste = results.getString("taste");
				String situation = results.getString("situation");
				DTO dto = new DTO(title, intro, ingredient, step, thumbnail, stepimg, thema, taste, situation);
				dtos.add(dto);
			}
			System.out.println("The data has been fetched");
			return dtos;

		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// 타이틀 추가
	public static void addTitle(String name, String title) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO " + name
					+ "(title) "
					+ "VALUES "
					+ "('" + title + "')");
			insert.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void addIntro(String name, String intro) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO " + name
					+ "(intro) "
					+ "VALUES "
					+ "('" + intro + "')");
			insert.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void addIngredient(String name, String ingredient) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO " + name
					+ "(ingredient) "
					+ "VALUES "
					+ "('" + ingredient + "')");
			insert.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void addStep(String name, String step) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO " + name
					+ "(step) "
					+ "VALUES "
					+ "('" + step + "')");
			insert.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void addThumbnail(String name, String thumbnail) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO " + name
					+ "(thumbnail) "
					+ "VALUES "
					+ "('" + thumbnail + "')");
			insert.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void addStepImg(String name, String stepimg) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO " + name
					+ "(stepimg) "
					+ "VALUES "
					+ "('" + stepimg + "')");
			insert.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 값 추가
	public static void addValues(String title, String intro,
								 String ingredient, String step, String thumbnail, String stepimg, String thema, String taste, String situation) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO 음식 VALUES "
					+ "('" + title + "', '" + intro + "', '" + ingredient + "', '" + step + "', '"
					+ thumbnail + "', '" + stepimg + "', '" + thema + "','" + taste + "','" + situation + "')");
			insert.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 테이블 삭제
	public static void dropTable(String name) {
		Connection con = getConnection();
		try {
			String sql = "DROP TABLE " + name;
			PreparedStatement statement = con.prepareStatement(sql);
			statement.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Table successfully deleted");
		}
	}

	// 음식 테이블
	public static void createFoodTable() {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con
					.prepareStatement("CREATE TABLE IF NOT EXISTS 음식("
							+ "title varChar(255),"
							+ "intro varChar(255),"
							+ "ingredient varChar(255),"
							+ "step text(10000),"
							+ "thumbnail varChar(255),"
							+ "stepImg text(10000),"
							+ "thema varChar(255),"
							+ "taste varChar(255),"
							+ "situation varChar(255),"
							+ "PRIMARY KEY(title))");
			statement.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Table successfully created");
		}
	}

	// DB 연결
	public static Connection getConnection() {
		try {
			String dbURL = "jdbc:mysql://capstone.cs6kilq1qdog.us-west-1.rds.amazonaws.com:3306/capstone";
			String dbID = "admin";
			String dbPW = "capstone"; // 개인 환경에 맞는 SQL 비밀번호 수정 필요
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbURL, dbID, dbPW);
			System.out.println("The Connection Successful");
			return con;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}