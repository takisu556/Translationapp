package Translationapp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Graphical extends JFrame{
	public static void main(String[] args) {
		//int x=10;
		//int y=20;
		//int width=150;
		//int height=25;
		
		JFrame frame=new JFrame("英汉释义查询(v1.1)");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,300);
		frame.setLayout(new BorderLayout());
		
		//输入窗口定义（包括panel、label、textfield)--v1.1
		//JPanel panel=new JPanel();
		JPanel inputpanel=new JPanel();
		JLabel l1=new JLabel("输入要查询的单词或中文:");  //文本定义
		JTextField f1=new JTextField(20);  //输入框定义
		inputpanel.add(l1);
		inputpanel.add(f1);
		//frame.add(panel);
		
		//中英译switch按钮--v1.1
		JPanel option=new JPanel(new FlowLayout());
		JToggleButton tb=new JToggleButton("英译中");
		tb.addActionListener(e ->{
			if(tb.isSelected()) {
				tb.setText("中译英");
			}else {
				tb.setText("英译中");
			}
		});
		option.add(new JLabel("翻译方向："));
		option.add(tb);	
		
		JLabel l2=new JLabel("结果:");

		//返回窗口定义     v1.1新增--更改为area函数
		JTextArea rtA=new JTextArea(8,40);
		rtA.setEditable(false);
		rtA.setLineWrap(true);
		rtA.setWrapStyleWord(true);
		//滑动条定义,rtA包裹在scrollPane内（v1.1新增）
		JScrollPane scrollPane=new JScrollPane(rtA);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		 //查询按钮定义+加入监视器--v1.1
		JButton b1=new JButton("查询");
		b1.addActionListener((ActionEvent e) ->{
				String input=f1.getText();
		        boolean isEnglishToChinese=!tb.isSelected();
		        String result=WordQuery.queryWord(input, isEnglishToChinese);
		        rtA.setText(result);
		});
		
		//对textfield输入的文本引入监视器，并对监视器进行定义
	    b1.addActionListener( (ActionEvent e) -> {
		       String inputWord=f1.getText();
		       boolean isEnglishToChinese=! tb.isSelected();
		       String result=WordQuery.queryWord(inputWord,isEnglishToChinese);
		       rtA.setText(result);
	    });
	    
	    //public void setLocation(500,500) {
	    	
	   // }
	    JPanel bottomPanel=new JPanel(new FlowLayout());
	    bottomPanel.add(b1);
	    
	    option.add(l2);
	    
	    frame.add(inputpanel,BorderLayout.NORTH);
	    frame.add(option,BorderLayout.CENTER);
	    frame.add(bottomPanel,BorderLayout.SOUTH);
	    frame.add(scrollPane,BorderLayout.EAST);
	    
	    frame.setVisible(true);
	    
		
	}
	

}
