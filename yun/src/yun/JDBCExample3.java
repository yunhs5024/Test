package yun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample3
{
    public static void main(String args[]) {
        Connection conn = null;//1단계 연결 위한 인터페이스
        Statement stmt = null;//실행
        ResultSet rs = null;//실행 결과저장
        
        try {//예외발생검사
            Class.forName("com.mysql.jdbc.Driver");//2단계JDBC드라이버를 로드
            
            conn = DriverManager.getConnection(//3단계DriverManager클래스는 getConnection메소드로 DB를 연결
            		
               "jdbc:mysql://localhost:3306/mysql", "root", "12345");
            
            System.out.println("데이터베이스에 접속했습니다.");
            //커넥션 객체가 Statement 객체를 생성
            stmt = conn.createStatement();
            
            //DML SQL 쿼리 실행후 결과를 저장
            rs= stmt.executeQuery("select Goodsintocode, Goodsintoname, price, maker from goodsinfo");
            
            System.out.println("상품코드	상품명	가격	제조사");
            
            while(rs.next()) {
            	
            String Goodsintocode  = rs.getString(1);//rs.getString("Goodsintocode");
            String Goodsintoname  = rs.getString(2);//rs.getString("Goodsintoname");
            int price 			  = rs.getInt(3);//rs.getInt("price");
            String maker 	 	  = rs.getString(4);//rs.getString("maker");
            
            System.out.println(Goodsintocode + "	"+Goodsintoname+""+price+"	"+maker);
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