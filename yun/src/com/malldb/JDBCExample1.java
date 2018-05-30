package com.malldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample1 {
    public static void main(String args[]) {
        Connection conn = null;//1단계 연결 위한 인터페이스
        Statement stmt = null;//SQL 실행
        ResultSet rs = null;//SQL 결과저장
        
        try {
        	//2단계 JDBC드라이버를 로드
            Class.forName("com.mysql.jdbc.Driver");
            
            //3단계DriverManager클래스는 getConnection메소드로 DB를 연결
            conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/malldb", "root", "12345");
            System.out.println("데이터베이스에 접속했습니다.");
            //malldb 접속정보->show processlist;
            //select now();
          
            //커넥션 객체가 Statement 객체를 생성
            stmt = conn.createStatement();
            
            //DML SQL 쿼리 실행후 결과를 저장
            rs= stmt.executeQuery("select now()");

            if(rs.next())//레코드가 있으면 rs을 레코드에 첫줄로 이동한다.4줄이동// rs.next() 레코드가 있는지 확인
            	System.out.println(rs.getString(1));
            	System.out.println(rs.getString(2));
            	System.out.println(rs.getString(3));
            	System.out.println(rs.getString(4));

                   
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

