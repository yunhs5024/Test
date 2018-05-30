package chap19;


import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import com.kosea.kmove30.JDBC_Manager;

import jdk.nashorn.internal.ir.CatchNode;

public class AddActionListener implements ActionListener {
	JTable table;
	JTextField text1, text2,text3;
	JDBC_Manager jdbcManager;
	
	public AddActionListener(JDBC_Manager jdbcManager,JTable table, JTextField text1,JTextField text2, JTextField text3) {
	
		this.jdbcManager = jdbcManager;
		this.table = table;
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String arr[] = new String[3];
		arr[0]= text1.getText();
		arr[1]= text2.getText();
		arr[2]= text3.getText();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
	
		boolean isCheck = false;//체크
		
		for(int i=0; i<arr.length; i++) {

			if(arr[i].length() > 0)
				isCheck = true;
			else 
				isCheck = false;
			
			System.out.println("arr["+i+"]:"+arr[i]);
		}
		if(isCheck)
		model.addRow(arr);//레코드에 데이터 추가
		try {
		jdbcManager.inserttable(arr);
	   }
		catch(Exception  ex){
		ex.getMessage();
		
	   }
	
	
		//입력창 빈칸만들기****************
		text1.setText("");
		text2.setText("");
		text3.setText("");
		
		
	}
}
