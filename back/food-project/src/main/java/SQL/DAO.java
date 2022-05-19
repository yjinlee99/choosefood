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

	public static int countChar(String str, char ch) {
		return str.length() - str.replace(String.valueOf(ch), "").length();
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

	public static ArrayList<DTO> getTestQuery(String data) {
		try {
			String[] dataList = data.split(" ");
			ArrayList<DTO> dtosTest;
			Connection con = ConnectionPool.cp.getConnection();

//			getThemaQuery(dataList[0], con);
//			getTasteQuery(dataList[1], con);
//			getIngredientQuery(dataList[2], con);
//			dtosTest = getSituationQuery(dataList[3], con);
			dtosTest = getTest(dataList, con);

			if (con != null) {
				ConnectionPool.cp.releaseConnection(con);
			}
			return dtosTest;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static ArrayList<DTO> getTest(String[] dataList, Connection con) {
		try {
			String query, str;
			String [] list, ingredientList;
			PreparedStatement statement;
			if(!dataList[0].contains("_") && !dataList[1].contains("_") &&
					!dataList[2].contains("_") && !dataList[3].contains("_")) {
				query = "select * from 음식";
				statement = con.prepareStatement(query);
			} else {
				str = dataList[0] + dataList[1] + dataList[3];
				str = str.replaceAll(" ","");
				list = str.split("_");
				ingredientList = dataList[2].split("_");

				query = "select * from 음식 where (";
				query = query + themaQuery(dataList[0]);

				if(tasteQuery(dataList[1])!="") {
					query = query + "and " + tasteQuery(dataList[1]);
				} else {
					query = query + tasteQuery(dataList[1]);
				}
				if(ingredientQuery(dataList[2], ingredientList.length)!="") {
					query = query + "and " + ingredientQuery(dataList[2], ingredientList.length);
				} else {
					query = query + ingredientQuery(dataList[2], ingredientList.length);
				}
				if(situationQuery(dataList[3])!="") {
					query = query + "and " + situationQuery(dataList[3]);
				} else {
					query = query + situationQuery(dataList[3]);
				}
				query = query + ")";

				statement = con.prepareStatement(query);
				for(int i=1;i<list.length;i++) {
					statement.setString(i, "%" + list[i] + "%");
				}
			}
			ResultSet results = statement.executeQuery(query);
			ArrayList<DTO> dtosTest = new ArrayList<DTO>();
			dropTable("test");
			createTestTable();
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
				dtosTest.add(dto);
				addTestValues(title, intro, ingredient, step, thumbnail, stepimg, thema, taste, situation, con);
			}
			System.out.println("The data has been fetched");

			return dtosTest;

		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// 테마별 쿼리
	public static String themaQuery(String data) {
		String query;
		if(countChar(data, '_') == 1) {
			query = "(THEMA LIKE ?) ";
		} else if(countChar(data, '_') == 2) {
			query = "(THEMA LIKE ? OR THEMA LIKE ?) ";
		} else if(countChar(data, '_') == 3) {
			query = "(THEMA LIKE ? OR THEMA LIKE ? " +
					"OR THEMA LIKE ?) ";
		} else if(countChar(data, '_') == 4) {
			query = "(THEMA LIKE ? OR THEMA LIKE ? " +
					"OR THEMA LIKE ? OR THEMA LIKE ?) ";
		} else if(countChar(data, '_') == 5) {
			query = "(THEMA LIKE ? OR THEMA LIKE ? " +
					"OR THEMA LIKE ? OR THEMA LIKE ? OR THEMA LIKE ?) ";
		} else {
			query = "";
		}
		return query;
	}

	// 미각별 쿼리
	public static String tasteQuery(String data) {
		String query;
		if(countChar(data, '_') == 1) {
			query = "(TASTE LIKE ?) ";
		} else if(countChar(data, '_') == 2) {
			query = "(TASTE LIKE ? OR TASTE LIKE ?) ";
		} else if(countChar(data, '_') == 3) {
			query = "(TASTE LIKE ? OR TASTE LIKE ? " +
					"OR TASTE LIKE ?) ";
		} else {
			query = "";
		}
		return query;
	}

	// 재료별 쿼리
	public static String ingredientQuery(String data, int num) {
		String query = "";
		int cnt = 1;
		if(num == 1) {
			return query;
		} else {
			//query = query + "(";
			if(data.contains("고기")) {
				query = query + "(regexp_like(title, '고기|닭|만두|돼지') or " +
						"regexp_like(ingredient, '고기|닭|만두|돼지'))";
				cnt++;
				if(cnt != num)
					query = query + " or ";
			}
			if(data.contains("채소")) {
				query = query + "regexp_like(title, '감자|버섯|배추|김치|고추|나물|나베|고구마|상추|토마토')";
				cnt++;
				if(cnt != num)
					query = query + " or ";
			}
			if(data.contains("떡")) {
				query = query + "(regexp_like(title, '떡') or " +
						"regexp_like(ingredient, '떡'))";
				cnt++;
				if(cnt != num)
					query = query + " or ";
			}
			if(data.contains("밥")) {
				query = query + "(regexp_like(title, '밥') or " +
						"regexp_like(ingredient, '밥|쌀'))";
				cnt++;
				if(cnt != num)
					query = query + " or ";
			}
			if(data.contains("해물")) {
				query = query + "regexp_like(title, '미역|참치|낙지|쭈꾸미|주꾸미|우동|어묵|해물|새우|초밥|회')";
				cnt++;
				if(cnt != num)
					query = query + " or ";
			}
			if(data.contains("과일")) {
				query = query + "regexp_like(title, '딸기|토마토|사과|포도|메론|멜론|복숭아|귤|오렌지|망고|체리|블루베리')";
				cnt++;
				if(cnt != num)
					query = query + " or ";
			}
			if(data.contains("빵/과자")) {
				query = query + "(regexp_like(title, '토스트|피자|빵|밀가루|케이크|박력분|파우더|오레오|푸딩|쿠키') or " +
						"regexp_like(ingredient, '토스트|피자|빵|밀가루|케이크|박력분|파우더|오레오|푸딩|쿠키'))";
				cnt++;
				if(cnt != num)
					query = query + " or ";
			}
			if(data.contains("두부/계란/우유")) {
				query = query + "(regexp_like(title, '계란|달걀|두부|버터|치즈|분유|크림') or " +
						"regexp_like(ingredient, '계란|달걀|두부|버터|치즈|분유|크림'))";
				cnt++;
				if(cnt != num)
					query = query + " or ";
			}
			if(data.contains("면")) {
				query = query + "(regexp_like(title, '라멘|라면|면|국수') or " +
						"regexp_like(ingredient, '라멘|라면|면|국수'))";
				cnt++;
				if(cnt != num)
					query = query + " or ";
			}
			query = query + " ";
			return query;
		}
	}

	// 테마별 쿼리
	public static String situationQuery(String data) {
		String query;
		if(countChar(data, '_') == 1) {
			query = "(situation like ?)";
		} else if(countChar(data, '_') == 2) {
			query = "(situation like ? or situation like ?)";
		} else if(countChar(data, '_') == 3) {
			query = "(situation like ? or situation like ? " +
					"or situation like ?)";
		} else if(countChar(data, '_') == 4) {
			query = "(situation like ? or situation like ? " +
					"or situation like ? or situation like ?)";
		} else if(countChar(data, '_') == 5) {
			query = "(situation like ? or situation like ? " +
					"or situation like ? or situation like ? or situation like ?)";
		} else {
			query = "";
		}
		return query;
	}

	// 테마별 음식 정보 반환
	public static void getThemaQuery(String data, Connection con) {
		try {
			String query;
			PreparedStatement statement;
			String[] list;
			String[] dataList = data.split(" ");
			//Connection con = getConnection();
			//Connection con = ConnectionPool.cp.getConnection();
			if(countChar(dataList[0], '_') == 0) {
				query = "SELECT * FROM 음식";
				statement = con.prepareStatement(query);
			} else if(countChar(dataList[0], '_') == 1) {
				query = "SELECT * FROM 음식 WHERE THEMA LIKE ?";
				statement = con.prepareStatement(query);
				list = dataList[0].split("_");
				statement.setString(1, "%" + list[1] + "%");
			} else if(countChar(dataList[0], '_') == 2) {
				query = "SELECT * FROM 음식 WHERE THEMA LIKE ? OR THEMA LIKE ?";
				statement = con.prepareStatement(query);
				list = dataList[0].split("_");
				statement.setString(1, "%" + list[1] + "%");
				statement.setString(2, "%" + list[2] + "%");
			} else if(countChar(dataList[0], '_') == 3) {
				query = "SELECT * FROM 음식 WHERE THEMA LIKE ? OR THEMA LIKE ? " +
						"OR THEMA LIKE ?";
				statement = con.prepareStatement(query);
				list = dataList[0].split("_");
				statement.setString(1, "%" + list[1] + "%");
				statement.setString(2, "%" + list[2] + "%");
				statement.setString(3, "%" + list[3] + "%");
			} else if(countChar(dataList[0], '_') == 4) {
				query = "SELECT * FROM 음식 WHERE THEMA LIKE ? OR THEMA LIKE ? " +
						"OR THEMA LIKE ? OR THEMA LIKE ?";
				statement = con.prepareStatement(query);
				list = dataList[0].split("_");
				statement.setString(1, "%" + list[1] + "%");
				statement.setString(2, "%" + list[2] + "%");
				statement.setString(3, "%" + list[3] + "%");
				statement.setString(4, "%" + list[4] + "%");
			} else if(countChar(dataList[0], '_') == 5) {
				query = "SELECT * FROM 음식 WHERE THEMA LIKE ? OR THEMA LIKE ? " +
						"OR THEMA LIKE ? OR THEMA LIKE ? OR THEMA LIKE ?";
				statement = con.prepareStatement(query);
				list = dataList[0].split("_");
				statement.setString(1, "%" + list[1] + "%");
				statement.setString(2, "%" + list[2] + "%");
				statement.setString(3, "%" + list[3] + "%");
				statement.setString(4, "%" + list[4] + "%");
				statement.setString(5, "%" + list[5] + "%");
			} else {
				query = "SELECT * FROM 음식";
				statement = con.prepareStatement(query);
				list = dataList[0].split("_");
				statement.setString(1, "%" + list[1] + "%");
				statement.setString(2, "%" + list[2] + "%");
				statement.setString(3, "%" + list[3] + "%");
				statement.setString(4, "%" + list[4] + "%");
				statement.setString(5, "%" + list[5] + "%");
				statement.setString(6, "%" + list[6] + "%");
			}
			ResultSet results = statement.executeQuery();
			ArrayList<DTO> dtosTest = new ArrayList<DTO>();
			dropTable("test");
			createTestTable();
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
				dtosTest.add(dto);
				addTestValues(title, intro, ingredient, step, thumbnail, stepimg, thema, taste, situation, con);
			}
			System.out.println("The data has been fetched");

//			getTasteQuery(dataList[1], con);
//			getIngredientQuery(dataList[2], con);
//			getSituationQuery(dataList[3], con);

//			if (con != null) {
//				ConnectionPool.cp.releaseConnection(con);
//			}

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 미각별 음식 정보 반환
	public static void getTasteQuery(String data, Connection con) {
		try {
			String query;
			PreparedStatement statement;
			String[] list;
			//Connection con = getConnection();
			//Connection con = ConnectionPool.cp.getConnection();
			if(countChar(data, '_') == 0) {
				query = "SELECT * FROM test";
				statement = con.prepareStatement(query);
			} else if(countChar(data, '_') == 1) {
				query = "SELECT * FROM test WHERE TASTE LIKE ?";
				statement = con.prepareStatement(query);
				list = data.split("_");
				statement.setString(1, "%" + list[1] + "%");
			} else if(countChar(data, '_') == 2) {
				query = "SELECT * FROM test WHERE TASTE LIKE ? OR TASTE LIKE ?";
				statement = con.prepareStatement(query);
				list = data.split("_");
				statement.setString(1, "%" + list[1] + "%");
				statement.setString(2, "%" + list[2] + "%");
			} else if(countChar(data, '_') == 3) {
				query = "SELECT * FROM test WHERE TASTE LIKE ? OR TASTE LIKE ? " +
						"OR TASTE LIKE '%?%'";
				statement = con.prepareStatement(query);
				list = data.split("_");
				statement.setString(1, "%" + list[1] + "%");
				statement.setString(2, "%" + list[2] + "%");
				statement.setString(3, "%" + list[3] + "%");
			} else {
				query = "SELECT * FROM test WHERE TASTE LIKE ? OR TASTE LIKE ? " +
						"OR TASTE LIKE ? OR TASTE LIKE ?";
				statement = con.prepareStatement(query);
				list = data.split("_");
				statement.setString(1, "%" + list[1] + "%");
				statement.setString(2, "%" + list[2] + "%");
				statement.setString(3, "%" + list[3] + "%");
				statement.setString(4, "%" + list[4] + "%");
			}
			ResultSet results = statement.executeQuery();
			ArrayList<DTO> dtosTest = new ArrayList<DTO>();
			dropTable("test");
			createTestTable();
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
				dtosTest.add(dto);
				addTestValues(title, intro, ingredient, step, thumbnail, stepimg, thema, taste, situation, con);
			}
			System.out.println("The data has been fetched");
//			if (con != null) {
//				ConnectionPool.cp.releaseConnection(con);
//			}

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 재료별 음식 정보 반환
	public static void getIngredientQuery(String data, Connection con) {
		try {
			String query = "SELECT * FROM test WHERE";
			PreparedStatement statement;
			//Connection con = getConnection();
			//Connection con = ConnectionPool.cp.getConnection();
			if(countChar(data, '_') == 0) {
				query = query.replaceAll("WHERE","");
				statement = con.prepareStatement(query);
			} else if(countChar(data, '_') == 1) {
				query = query + ingredientQuery(data, 1);
				statement = con.prepareStatement(query);
			} else if(countChar(data, '_') == 2) {
				query = query + ingredientQuery(data, 2);
				statement = con.prepareStatement(query);
			} else if(countChar(data, '_') == 3) {
				query = query + ingredientQuery(data, 3);
				statement = con.prepareStatement(query);
			} else if(countChar(data, '_') == 4) {
				query = query + ingredientQuery(data, 4);
				statement = con.prepareStatement(query);
			} else if(countChar(data, '_') == 5) {
				query = query + ingredientQuery(data, 5);
				statement = con.prepareStatement(query);
			} else if(countChar(data, '_') == 6) {
				query = query + ingredientQuery(data, 6);
				statement = con.prepareStatement(query);
			} else if(countChar(data, '_') == 7) {
				query = query + ingredientQuery(data, 7);
				statement = con.prepareStatement(query);
			} else if(countChar(data, '_') == 8) {
				query = query + ingredientQuery(data, 8);
				statement = con.prepareStatement(query);
			} else {
				query = query + ingredientQuery(data, 9);
				statement = con.prepareStatement(query);
			}
			ResultSet results = statement.executeQuery();
			ArrayList<DTO> dtosTest = new ArrayList<DTO>();
			dropTable("test");
			createTestTable();
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
				dtosTest.add(dto);
				addTestValues(title, intro, ingredient, step, thumbnail, stepimg, thema, taste, situation, con);
			}
			System.out.println("The data has been fetched");
//			if (con != null) {
//				ConnectionPool.cp.releaseConnection(con);
//			}

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 테마별 음식 정보 반환
	public static ArrayList<DTO> getSituationQuery(String data, Connection con) {
		try {
			String query;
			PreparedStatement statement;
			String[] list;
			//Connection con = getConnection();
			//Connection con = ConnectionPool.cp.getConnection();
			if(countChar(data, '_') == 0) {
				query = "SELECT * FROM test";
				statement = con.prepareStatement(query);
			} else if(countChar(data, '_') == 1) {
				query = "SELECT * FROM test WHERE SITUATION LIKE ?";
				statement = con.prepareStatement(query);
				list = data.split("_");
				statement.setString(1, "%" + list[1] + "%");
			} else if(countChar(data, '_') == 2) {
				query = "SELECT * FROM test WHERE SITUATION LIKE ? OR SITUATION LIKE ?";
				statement = con.prepareStatement(query);
				list = data.split("_");
				statement.setString(1, "%" + list[1] + "%");
				statement.setString(2, "%" + list[2] + "%");
			} else if(countChar(data, '_') == 3) {
				query = "SELECT * FROM test WHERE SITUATION LIKE ? OR SITUATION LIKE ? " +
						"OR SITUATION LIKE '%?%'";
				statement = con.prepareStatement(query);
				list = data.split("_");
				statement.setString(1, "%" + list[1] + "%");
				statement.setString(2, "%" + list[2] + "%");
				statement.setString(3, "%" + list[3] + "%");
			} else if(countChar(data, '_') == 4) {
				query = "SELECT * FROM test WHERE SITUATION LIKE ? OR SITUATION LIKE ? " +
						"OR SITUATION LIKE ? OR SITUATION LIKE ?";
				statement = con.prepareStatement(query);
				list = data.split("_");
				statement.setString(1, "%" + list[1] + "%");
				statement.setString(2, "%" + list[2] + "%");
				statement.setString(3, "%" + list[3] + "%");
				statement.setString(4, "%" + list[4] + "%");
			} else if(countChar(data, '_') == 5) {
				query = "SELECT * FROM test WHERE SITUATION LIKE ? OR SITUATION LIKE ? " +
						"OR SITUATION LIKE ? OR SITUATION LIKE ? OR SITUATION LIKE ?";
				statement = con.prepareStatement(query);
				list = data.split("_");
				statement.setString(1, "%" + list[1] + "%");
				statement.setString(2, "%" + list[2] + "%");
				statement.setString(3, "%" + list[3] + "%");
				statement.setString(4, "%" + list[4] + "%");
				statement.setString(5, "%" + list[5] + "%");
			} else {
				query = "SELECT * FROM test";
				statement = con.prepareStatement(query);
				list = data.split("_");
				statement.setString(1, "%" + list[1] + "%");
				statement.setString(2, "%" + list[2] + "%");
				statement.setString(3, "%" + list[3] + "%");
				statement.setString(4, "%" + list[4] + "%");
				statement.setString(5, "%" + list[5] + "%");
				statement.setString(6, "%" + list[6] + "%");
			}
			ResultSet results = statement.executeQuery();
			ArrayList<DTO> dtosTest = new ArrayList<DTO>();
			dropTable("test");
			createTestTable();
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
				dtosTest.add(dto);
				addTestValues(title, intro, ingredient, step, thumbnail, stepimg, thema, taste, situation, con);
			}
			System.out.println("The data has been fetched");
//			if (con != null) {
//				ConnectionPool.cp.releaseConnection(con);
//			}
			return dtosTest;

		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// 전체 음식 정보 반환
	public static ArrayList<DTO> getFoods() {
		try {
			//Connection con = getConnection();
			Connection con = ConnectionPool.cp.getConnection();
			PreparedStatement statement = con.prepareStatement(
					"SELECT * FROM 음식");
			ResultSet results = statement.executeQuery();
			ArrayList<DTO> dtos = new ArrayList<DTO>();
			DAO.createFoodTable();
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
			if (con != null) {
				ConnectionPool.cp.releaseConnection(con);
			}
			return dtos;

		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// 해당하는 번호의 방이 있는지 체크
	public static Boolean checkLogin(String email, String passwd) {
		try {
			Connection con = ConnectionPool.cp.getConnection();
			String sql = "SELECT COUNT(*) cnt FROM users" +
					" where email = ? and passwd = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, passwd);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				int cnt = result.getInt("cnt");
				if (cnt>0)
					return true;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	// 값 추가
	public static void addUserValues(String email, String passwd, String name, String phone) {
		try {
			//Connection con = getConnection();
			Connection con = ConnectionPool.cp.getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO users VALUES "
					+ "('" + email + "', '" + passwd + "', '" + name + "', '" + phone + "')");
			insert.executeUpdate();
			if (con != null) {
				ConnectionPool.cp.releaseConnection(con);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 테스트 값 추가
	public static void addTestValues(String title, String intro,
								 String ingredient, String step, String thumbnail, String stepimg,
									 String thema, String taste, String situation, Connection con) {
		try {
			System.out.println(1);
			//Connection con = getConnection();
			//Connection con = ConnectionPool.cp.getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO test VALUES "
					+ "('" + title + "', '" + intro + "', '" + ingredient + "', '" + step + "', '"
					+ thumbnail + "', '" + stepimg + "', '" + thema + "','" + taste + "','" + situation + "')");
			insert.executeUpdate();
			//System.out.println("1");
//			if (con != null) {
//				ConnectionPool.cp.releaseConnection(con);
//			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 값 추가
	public static void addValues(String title, String intro,
								 String ingredient, String step, String thumbnail, String stepimg,
								 String thema, String taste, String situation) {
		try {
			//Connection con = getConnection();
			Connection con = ConnectionPool.cp.getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO 음식 VALUES "
					+ "('" + title + "', '" + intro + "', '" + ingredient + "', '" + step + "', '"
					+ thumbnail + "', '" + stepimg + "', '" + thema + "','" + taste + "','" + situation + "')");
			insert.executeUpdate();
			if (con != null) {
				ConnectionPool.cp.releaseConnection(con);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 테이블 삭제
	public static void dropTable(String name) {
		try {
			//Connection con = getConnection();
			Connection con = ConnectionPool.cp.getConnection();
			String sql = "DROP TABLE " + name;
			PreparedStatement statement = con.prepareStatement(sql);
			statement.execute();
			if (con != null) {
				ConnectionPool.cp.releaseConnection(con);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Table successfully deleted");
		}
	}

	// 사용자 테이블
	public static void createUserTable() {
		try {
			//Connection con = getConnection();
			Connection con = ConnectionPool.cp.getConnection();
			PreparedStatement statement = con
					.prepareStatement("CREATE TABLE IF NOT EXISTS users("
							+ "email varChar(255),"
							+ "passwd varChar(255),"
							+ "name varChar(255),"
							+ "phone varChar(255),"
							+ "PRIMARY KEY(email))");
			statement.execute();
			if (con != null) {
				ConnectionPool.cp.releaseConnection(con);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Table successfully created");
		}
	}

	// 테스트 테이블
	public static void createTestTable() {
		try {
			//Connection con = getConnection();
			Connection con = ConnectionPool.cp.getConnection();
			PreparedStatement statement = con
					.prepareStatement("CREATE TABLE IF NOT EXISTS test("
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
			if (con != null) {
				ConnectionPool.cp.releaseConnection(con);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Table successfully created");
		}
	}

	// 음식 테이블
	public static void createFoodTable() {
		try {
			//Connection con = getConnection();
			Connection con = ConnectionPool.cp.getConnection();
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
			if (con != null) {
				ConnectionPool.cp.releaseConnection(con);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Table successfully created");
		}
	}

	// DB 연결
	public static Connection getConnection() {
		try {
			String dbURL = "jdbc:mysql://capstone.cs6kilq1qdog.us-west-1.rds.amazonaws.com/capstone";
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