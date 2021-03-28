package project;

/*Online Java Paper Test*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JAVA_QUIZ_TOOL extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[] = new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];
	
//-----------------------------------------------------------------------------	
	JAVA_QUIZ_TOOL(String s)
	{
		super(s);
		l = new JLabel();
		add(l);
		bg = new ButtonGroup();
		
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		
		b1=new JButton("Next");
		b1.addActionListener(this);
	
		b2=new JButton("Bookmark");
		b2.addActionListener(this);
		
		l.setBounds(20,30,650,25);
		jb[0].setBounds(50,80,350,30);
		jb[1].setBounds(50,110,350,20);
		jb[2].setBounds(50,140,350,20);
		jb[3].setBounds(50,170,350,20);
		b1.setBounds(40,240,200,40);
		b2.setBounds(380,240,200,40);
		
		add(b1); add(b2);
		set();

		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(720,350);
	}
//--------------------------------------------------------------------------	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();	
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();	
			if(current==9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		
		for(int i=0,y=1; i<x; i++,y++)
		{
			if(e.getActionCommand().equals("Bookmark"+y))
			{
				if(check())
				{
				count=count+1;
				now=current;
				current=m[y];
				set();
				((JButton)e.getSource()).setEnabled(false);
				current=now;
				}
		    }
		}
	
		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			current++;
			//System.out.println("correct ans="+count);
			JOptionPane.showMessageDialog(this,"Correct answers: "+count);
			System.exit(0);
		}
	}
//-------------------------------------------------------------------------------------
	
	void set()
	{
		jb[4].setSelected(true);  // 4 OPTIONS.
		
		if(current==0)
		{
			l.setText("Q.1): Who develepoed Java, and in which Year?");
			Font f1 = new Font("Italian",Font.BOLD,20);
			l.setFont(f1);
			jb[0].setText("Dennis Ritchie, 1995");jb[1].setText("James Gosling, 1995");jb[2].setText("James Gosling, 1991");jb[3].setText("Dennis Ritchie, 1991");	
		}
		
		if(current==1)
		{
			l.setText("Q.2): Which Among the following is 'Not an Primitive Data Type'?");
			Font f2 = new Font("Italian",Font.BOLD,20);
			l.setFont(f2);
			jb[0].setText("float");jb[1].setText("char");jb[2].setText("int");jb[3].setText("Byte");
		}
		
		if(current==2)
		{
			l.setText("Q.3): Which Among the Following has 'Same Name as Class Name'?");
			Font f3 = new Font("Italian",Font.BOLD,20);
			l.setFont(f3);
			jb[0].setText("Block");jb[1].setText("Abstract");jb[2].setText("Method");jb[3].setText("Constructor");
		}
		
		if(current==3)
		{
			l.setText("Q.4): First Java Version Called as?");
			Font f4 = new Font("Italian",Font.BOLD,20);
			l.setFont(f4);
			jb[0].setText("Java Alpha and Beta");jb[1].setText("Java 1.0");jb[2].setText("Java SE 1.0");jb[3].setText("Java Begin 1.0");
		}
		
		if(current==4)
		{
			l.setText("Q.5): String Variables Stored in?");
			Font f5 = new Font("Italian",Font.BOLD,20);
			l.setFont(f5);
			jb[0].setText("Stack");jb[1].setText("String Memory");jb[2].setText("String Constant Pool");jb[3].setText("Register");
		}
		
		if(current==5)
		{
			l.setText("Q.6): Which one among these is 'Not a keyword'?");
			Font f6 = new Font("Italian",Font.BOLD,20);
			l.setFont(f6);
			jb[0].setText("class");jb[1].setText("int");jb[2].setText("null");jb[3].setText("if");
		}
		
		if(current==6)
		{
			l.setText("Q.7): In Java 'Multiple Interference' is Achieved Through?");
			Font f7 = new Font("Italian",Font.BOLD,20);
			l.setFont(f7);
			jb[0].setText("Methods");jb[1].setText("String");jb[2].setText("Arrays");jb[3].setText("Inferface");
		}
		
		if(current==7)
		{
			l.setText("Q.8): Which among these is not a function of Object class?");
			Font f8 = new Font("Italian",Font.BOLD,20);
			l.setFont(f8);
			jb[0].setText("toString");jb[1].setText("finalize");jb[2].setText("equals");jb[3].setText("getDocumentBase");		
		}
		
		if(current==8)
		{
			l.setText("Q.9): 'Interface' is an Part of Which Concept?");
			Font f9 = new Font("Italian",Font.BOLD,20);
			l.setFont(f9);
			jb[0].setText("Constructor");jb[1].setText("Abstraction");jb[2].setText("String");jb[3].setText("Arrays");
		}
		
		if(current==9)
		{
			l.setText("Q.10): Which one among these is not a Valid Component?");
			Font f10 = new Font("Italian",Font.BOLD,20);
			l.setFont(f10);
			jb[0].setText("JButton");jb[1].setText("JList");jb[2].setText("JButtonGroup");jb[3].setText("JTextArea");
		}
	
		for(int i=0,j=0; i<=90; i+=30,j++)
		{	
			jb[j].setBounds(50,80+i,200,20);
		}
	}
//-----------------------------------------------------
	boolean check()
	{
		if(current==0)
			return(jb[2].isSelected());
		if(current==1)
			return(jb[3].isSelected());
		if(current==2)
			return(jb[3].isSelected());
		if(current==3)
			return(jb[0].isSelected());
		if(current==4)
			return(jb[2].isSelected());
		if(current==5)
			return(jb[2].isSelected());
		if(current==6)
			return(jb[3].isSelected());
		if(current==7)
			return(jb[3].isSelected());
		if(current==8)
			return(jb[1].isSelected());
		if(current==9)
			return(jb[2].isSelected());
		return false;
	}
//---------------------------------------------------------------------	
	public static void main(String s[])
	{
		new JAVA_QUIZ_TOOL("Test Tool for 'Java Quiz':");
	}


}
