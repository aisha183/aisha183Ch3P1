/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectdatabase;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author PC
 */
public class ConnectDataBase implements Initializable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
      

        String url = "jdbc:mysql://127.0.0.1:3306/School";
        String username = "'root'";
        String password = "";
        Connection conn = DriverManager.getConnection(url, username, password);
        
         Statement statement = conn.createStatement();
//        String sql = "Insert Into Student values(" + 13 + ",'" + "Aisha" + "','"
//                + "Software Engineering" + "'," + 69.9 + ")";
//        statement.executeUpdate(sql);

        String sql1 = "Update Student Set name='" + "hafsa" + "', Major='"
                + "iT" + "', Grade=" + 99.6 + " Where Id" + 11;
        statement.executeUpdate(sql1);

        ResultSet rs = statement.executeQuery("SELECT * FROM Student");
        String SQL = "DELETE FROM Student WHERE (Id = 9)" ;
        statement.executeUpdate(SQL);
        rs.deleteRow();
       
        
//        String sql2 = "Insert Into registration values(" + 9 + ",'" + 4 + "',"
//                +"'first'" + ")";
//        statement.executeUpdate(sql2);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
