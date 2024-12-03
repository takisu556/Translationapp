package Translationapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WordQuery {
	
	public static String queryWord(String input,boolean isEnglishToChinese) {
		String result="单词不存在或暂未收录";
		String sql= isEnglishToChinese ?
				"SELECT chinese_word FROM words WHERE english_word=?":
				"SELECT english_word FROM words WHERE chinese_word=?";
		
		try(Connection conn=DatabaseConnection.getConnection();
				PreparedStatement stmt=conn.prepareStatement(sql)){
			stmt.setString(1,input);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				result=isEnglishToChinese ? 
						rs.getString("chinese_word"):rs.getString("english_word");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
