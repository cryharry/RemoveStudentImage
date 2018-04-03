package application;

import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RemoveImageController implements Initializable {
	ResultSet rs;
	DBQue db = new DBQue();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			rs = db.getRS("SELECT st_id FROM student WHERE class=1");
			while(rs.next()) {
				String st_id = rs.getString("st_id");
				File f = new File("D:\\FTP\\unicool\\image\\"+st_id+".jpg");
				f.delete();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Alert al = new Alert(AlertType.INFORMATION);
			al.setTitle("삭제 완료");
			al.setHeaderText("Complete");
			al.setContentText("삭제완료되었습니다.");
			al.showAndWait();
		}
	}
	
	
}
