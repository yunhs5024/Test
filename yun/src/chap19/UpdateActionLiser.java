package chap19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import com.kosea.kmove30.JDBC_Manager;

public class UpdateActionLiser implements ActionListener {

	JDBC_Manager jdbcManager;
	JTextField  text1,text2;// JTextField  textAge; 나이
	
	
	
	public UpdateActionLiser(JDBC_Manager jdbcManager, JTextField text1,JTextField text2) {
		super();
		this.jdbcManager = jdbcManager;
		this.text1 = text1;
		this.text2 = text2;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
				//DB수정 작업
	
		/*String name = text1.getText()
		String age = text2.getText()*/
		try {
			jdbcManager.updateTable(text1.getText(),text2.getText());
		} catch (Exception ex) {
		System.out.println(ex.getMessage());
		
	}
	}
}
