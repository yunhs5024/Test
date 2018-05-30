package com.malldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class Person{
	
	String jumincd = null;
	String pname   = null;
	String gender  = null;
	int age = 0;
	
	public Person()//기본 생성자
	{ 
		this.jumincd="주민번호 입력 누락";
		this.pname="이름 입력 누락";
		this.gender="성별 입력 누락";
		this.age=0;
	
	}
	
	public String getJumincd() {
		return jumincd;
	}
	public void setJumincd(String jumincd) {// "800511-1574310"
		this.jumincd = jumincd;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//메뉴[Source] 선택후 [generate to string]
}



public class JDBC_Person_ArrayList {
    public static void main(String args[]) {
	
    	ArrayList<Person> listPerson = new ArrayList<Person>(3);

    	//한줄로 Person person =new Person();
    
    	////////////////////JDBC 연결문 시작/////////////////////
        Connection conn = null;//1단계 연결 위한 인터페이스
        Statement stmt = null;//실행
        ResultSet rs = null;//실행 결과저장
    
        try {//예외발생검사
        	String jumincd = null;
        	String pname = null;
        	String gender = null;
        	int age = 0;        
            Class.forName("com.mysql.jdbc.Driver");//2단계JDBC드라이버를 로드        
            conn = DriverManager.getConnection(//3단계            		
               "jdbc:mysql://localhost:3306/mysql", "root", "12345");
        
            System.out.println("데이터베이스에 접속했습니다.");
        
            //커넥션 객체가 Statement 객체를 생성
            stmt = conn.createStatement();
            
            //DML SQL 쿼리 실행후 결과를 저장
            rs= stmt.executeQuery("select jumincd, pname, gender, age from person");
            
            System.out.println("주민번호		이름	성별	나이");
            
            while(rs.next()) {
            	
            	Person person;
            	person = new Person();
            	
            	person.setJumincd(rs.getString(1));//=person.setGender(rs.getString("Jumincd"));
            	person.setPname(rs.getString(2));//=person.setGender(rs.getString("Pname"));
            	person.setGender(rs.getString(3));//=person.setGender(rs.getString("gender"));
            	person.setAge(rs.getInt(4));//=person.setGender(rs.getInt("Age"));
            	
            	listPerson.add(person);

            }
            //4단계 DB연결종료
        conn.close();
       
        System.out.println("__________________________________________");
        for (int i=0; i<listPerson.size();i++) {
        	System.out.println(listPerson.get(i).getJumincd()+" ");
        	System.out.println(listPerson.get(i).getPname()+" ");
        	System.out.println(listPerson.get(i).getGender()+" ");
        	System.out.println(listPerson.get(i).getAge()+" ");
        	System.out.println();
        }

        
        
        
/*    	for(i= 0; i<persons.length; i++) {
    		System.out.println("주민번호:"+persons[i].getJumincd());
    		System.out.println("이름:"   +persons[i].getPname());
    		System.out.println("성별:"   +persons[i].getGender());
    		System.out.println("나이:"   +persons[i].getAge());
    	
    	}*/
        
        //System.out.println(jumincd + "	"+pname+"	"+gender+"	"+age);
        
            }
        catch (ArrayIndexOutOfBoundsException arye) {
            System.out.println("해당 클래스를 찾을 수 없습니다." + 
                               arye.getMessage());
            }
        catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스를 찾을 수 없습니다." + 
                               cnfe.getMessage());
        }
        catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }
////////////////////JDBC 연결문 종료/////////////////////
    
}