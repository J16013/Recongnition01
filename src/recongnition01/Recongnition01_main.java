package recongnition01;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Recongnition01_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Recongnition01_lib rlib = new Recongnition01_lib();
		MySQL mysql = new MySQL();
		ResultSet rs = mysql.getID();
		try {
			while(rs.next()){
				int id = rs.getInt("id");
				//String path = "/home/ms000/www/oc/app/webroot/img/image/" + rs.getString("picture");
				String path = "img/" + rs.getString("picture");
				rlib.getFaceRecognition(path);
				MySQL mysql1 = new MySQL();
				mysql1.updateImage(rlib.getAge_min(), rlib.getAge_max(), rlib.getAge_score(), rlib.getGender(), rlib.getGender_score(), id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
