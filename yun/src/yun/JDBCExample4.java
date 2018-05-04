package yun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample4
{
    public static void main(String args[]) {
        Connection conn = null;//1단계 연결 위한 인터페이스
        Statement stmt = null;//실행
        ResultSet rs = null;//실행 결과저장
        
        try {//예외발생검사
            Class.forName("com.mysql.jdbc.Driver");//2단계JDBC드라이버를 로드
            
            conn = DriverManager.getConnection(//3단계
            		
               "jdbc:mysql://localhost:3306/mysql", "root", "12345");
            
            System.out.println("데이터베이스에 접속했습니다.");
            //커넥션 객체가 Statement 객체를 생성
            stmt = conn.createStatement();
            
            //DML SQL 쿼리 실행후 결과를 저장
            rs= stmt.executeQuery("select cname, address, phoneno from custinfo");
            
            System.out.println("이름	주소						전화번호");
            
            while(rs.next()) {
            	
            String cname    = rs.getString(1);//rs.getString("cname");
            String address  = rs.getString(2);//rs.getString("address");
            String phoneno 	= rs.getString(3);//rs.getString("phoneno");
            
            System.out.println(cname + "	"+address+"			"+phoneno);
            }
            //4단계 DB연결종료
        conn.close();
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