package DBLesson02;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WordDAO2 {

	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	static String URL="jdbc:mysql://localhost/testdb?useUnicode=true&characterEncoding=utf8";
	static String USER="root";
	static String PW="";

	public int registWords(List<Word> words) {
		int result = 0;
		try {
			String SQL="INSERT INTO dictionary VALUES(?,?)";
			Class.forName("jdbc:mysql://localhost/testdb?useUnicode=true&characterEncoding=utf8");
			con = DriverManager.getConnection(URL,USER,PW);

			for(Word tmp : words){
				st=con.prepareStatement(SQL);
				st.setString(0, tmp.getEnglish());
				st.setString(1, tmp.getJapanese());
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

	public List<Word> getWords(){
		List<Word> words =new ArrayList<>();
		try{
			String SQL="SELECT english, japanese FROM dictionary";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL,USER,PW);

		st = con.prepareStatement(SQL);
		rs = st.executeQuery();

		while(rs.next()){
			Word wd = new Word(rs.getString("english"),rs.getString("japanese"));
			words.add(wd);
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
		return words;
	}

	}
