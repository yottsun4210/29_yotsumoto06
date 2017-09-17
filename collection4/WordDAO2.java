package collection4;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class WordDAO2 {

	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	static String URL="jdbc:mysql://localhost/testdb?useUnicode=true&characterEncoding=utf8";
	static String USER="axizuser";
	static String PW="axiz";

	public int registWords(List<Word> words) {
		int result = 0;
		try {
			String SQL="INSERT INTO dictionary VALUES(?,?)";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL,USER,PW);

			for(Word tmp : words){
				st=con.prepareStatement(SQL);
				st.setString(1, tmp.getEnglish());
				st.setString(2, tmp.getJapanese());
				st.executeUpdate();
				result++;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if ( st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if ( con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

}
