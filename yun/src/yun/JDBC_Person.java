package yun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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



public class JDBC_Person {
    public static void main(String args[]) {
    	
    	Person[] persons = new Person[6];//배열객체
    	
    	
    	System.out.println(persons);
    	for(int i= 0; i<persons.length; i++) { 
    		persons[i]= new Person();  //생성자 호출하여 배열레퍼런스 대입
    	}
    	
    	/*
    	for(int i= 0; i<persons.length; i++) {
    		System.out.println("주민번호:"+persons[i].getJumincd());
    		System.out.println("이름:"   +persons[i].getPname());
    		System.out.println("성별:"   +persons[i].getGender());
    		System.out.println("나이:"   +persons[i].getAge());
    	}*/
    	
    	/*
    	Person person; //레퍼런스 변수선언
    	person =new Person(); //객체 생성 - new 연산자(생성자) 이용
    	*/
    	
    	
    	
    	//person객체에 멤버필들을 셋팅
    	
    	/*person.setJumincd("800511-1574310");
    	person.setPname("홍길동");
    	person.setGender("남자");
    	person.setAge(20);*/
    	
    	
    	
    	
//    	
//    	int age=person.getAge();
//    	System.out.println(age);
//    	
//    	System.out.println(person.getAge());
    	
    	/*
    	System.out.println(person.jumincd);// "800511-1574310"
    	System.out.println(person.pname);
    	System.out.println(person.gender);
    	System.out.println(person.age);
    	*/
    	
    	//한줄로 Person person =new Person();
    
    	////////////////////JDBC 연결문 시작/////////////////////
        Connection conn = null;//1단계 연결 위한 인터페이스
        Statement stmt = null;//실행
        ResultSet rs = null;//실행 결과저장
    
        try {//예외발생검사
//        	String jumincd = null;
//        	String pname = null;
//        	String gender = null;
        	int age = 0;        
            Class.forName("com.mysql.jdbc.Driver");//2단계JDBC드라이버를 로드        
            conn = DriverManager.getConnection(//3단계            		
               "jdbc:mysql://localhost:3306/mysql2", "root", "12345");
        
            System.out.println("데이터베이스에 접속했습니다.");
        
            //커넥션 객체가 Statement 객체를 생성
            stmt = conn.createStatement();
            
            //DML SQL 쿼리 실행후 결과를 저장
            rs= stmt.executeQuery("select jumincd, pname, gender, age from person");
            
            System.out.println("주민번호		이름	성별	나이");
            
            int i=0;
            while(rs.next()) {
            	
            
            	persons[i].setJumincd(rs.getString(1));
            	persons[i].setPname(rs.getString(2));
            	persons[i].setGender(rs.getString(3));
            	persons[i].setAge(rs.getInt(4));

            	i++;
//             jumincd= rs.getString(1);//rs.getString("jumincd");
//             pname  = rs.getString(2);//rs.getString("pname");
//             gender = rs.getString(3);//rs.getString("gender");
//             age 	  = rs.getInt(4);//rs.getInt("age");
            
           // System.out.println(jumincd + "	"+pname+"	"+gender+"	"+age);
            }
            //4단계 DB연결해제
        conn.close();
       
        System.out.println("__________________________________________");

    	for(i= 0; i<persons.length; i++) {
    		System.out.println("주민번호:"+persons[i].getJumincd());
    		System.out.println("이름:"   +persons[i].getPname());
    		System.out.println("성별:"   +persons[i].getGender());
    		System.out.println("나이:"   +persons[i].getAge());
    	
    	}
        
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