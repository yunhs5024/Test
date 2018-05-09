package yun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Delete{
    public static void main(String args[]) {
        Connection conn = null;
        Statement stmt = null;//실행
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/mysql", "root", "12345");
            System.out.println("데이터베이스에 접속했습니다.");
            //DB SQL 수정작업
            stmt =conn.createStatement();
            String sql="delete from person where pname='"+ args[0]+"'";//홍길동'
            //String sql="delete from person where pname='유관순3';
            int chageRecord = stmt.executeUpdate(sql);
            
            
            //int chageRecord = stmt.executeUpdate("update person\r\n"+
            		//"set age= 23\r\n"+
            		//"where jumincd ='9111014123456'");
            
            
            conn.close();
            System.out.println(chageRecord+"건이 수정 되었습니다.");
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스를 찾을 수 없습니다." + 
                               cnfe.getMessage());
        }
        catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }
}

