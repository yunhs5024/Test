package com.kosea.kmove30;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class JDBC_Manager {

	////////////////속성(필드)
	////////////////////JDBC 연결문 시작/////////////////////
    Connection conn = null;//1단계 연결 위한 컨넥션 인터페이스
    Statement stmt = null;//Statement 인터페이스 SQL실행
    ResultSet rs = null;//ResultSet SQL실행 결과저장

    
    public JDBC_Manager(Connection conn, Statement stmt, ResultSet rs) {
		super();
		this.conn = conn;
		this.stmt = stmt;
		this.rs = rs;
	}

    public JDBC_Manager() {
    	System.out.println("JDBC_Manager()기본 생성자 호출");
    }
	
	
	
///////////////////기능(메소드)////////////////////////////////////////
	//DB연결
	public Connection DBConnection(String driver,String url, String user, String pass) throws /*(ClassNotFoundException, SQL)*/Exception {
		 Class.forName(driver);//2단계JDBC드라이버를 로드     
		 
		 conn = DriverManager.getConnection( url, user, pass);
     return conn;
	}
	
	
	
	//select-query: "select pname, age , gender from person"  조회
public ResultSet SelectTable(String query) throws Exception{
	  stmt = conn.createStatement();
      //DML SQL 쿼리 실행후 결과를 저장
      rs= stmt.executeQuery(query);
      return rs;
      
}


/* INSERT INTO Person(pname,	age,	gender)
VALUES('9111014123456',	'윤희소',28,		'm');              삽입*/            //  INSERT
public  void inserttable(String [] arr )throws SQLException{
	String name = arr[0];
	String age = arr[1];
	String gender = arr[2];
	
	String query = "INSERT INTO Person(pname,age,gender) VALUES"
			+ "('"+name+"',"+age+ ",'"+gender+"'"+")";
	System.out.println("query - "+ query);
	  stmt =conn.createStatement();
	 int insertCount = stmt.executeUpdate(query);
			
	 if (insertCount>0)
			System.out.println(insertCount+"건이 삽입 되었습니다");
				
}
//query  UPDATE person set age = 28 WHERE pname = '윤희소';                //   UPDATE
//UPDATE person set age = 28, pname = 윤희소  WHERE pname = '윤희소';
public void updateTable(String name, String age) throws SQLException {
	String query = "UPDATE Person "+
			"set age =" + age + 
			" where pname = '" + name + "'";
			
	System.out.println("query - "+ query);
	
	stmt =conn.createStatement();
	int updateCount = stmt.executeUpdate(query);
	 if (updateCount>0)
			System.out.println(updateCount+"건이 수정 되었습니다");

}


//delete from person  where pname = '홍길동'; 제거//                                     delete
public void deleteTable(String deleteName) throws SQLException {
	String query = "delete from person  where pname = '"+deleteName+"'";
	 stmt =conn.createStatement();
	 int deleteCount = stmt.executeUpdate(query);
	 
	 if (deleteCount>0)
	System.out.println(deleteCount+"건이 삭제 되었습니다");
}
	


	
	


			
	


	//DB연결해제
	
	 public void DBClose() throws SQLException {
		 conn.close();
	 }
}
