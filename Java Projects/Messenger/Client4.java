import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

class Client4 extends Frame implements ActionListener,Runnable
{
	Label l1,l2;
	TextArea t1,t2;
	Button b1,b2;
	Thread th;
	Socket s;
	DataOutputStream dos;
	DataInputStream dis;
	String str;
	Client4()
	{
		super("Client");
		l1=new Label("From Server");
		l2=new Label("To Server");

		t1=new TextArea("",10,100,TextArea.SCROLLBARS_BOTH);
		t2=new TextArea("",10,100,TextArea.SCROLLBARS_BOTH);

		b1=new Button("Send");
		b2=new Button("Exit");

		b1.addActionListener(this);
		b2.addActionListener(this);

		setLayout(null);

		l1.setBounds(50,50,100,20);
		t1.setBounds(50,80,200,100);
		l2.setBounds(50,190,100,20);
		t2.setBounds(50,220,200,100);
		b1.setBounds(50,330,75,20);
		b2.setBounds(150,330,75,20);

		setSize(300,400);
	
		add(l1);
		add(l2);
		add(t1);
		add(t2);
		add(b1);
		add(b2);

		t1.setEditable(false);
		setVisible(true);

		try
		{
			s=new Socket("localhost",5055);
			dos=new DataOutputStream(s.getOutputStream());
			dis=new DataInputStream(s.getInputStream());
			th=new Thread(this);
			th.start();
		}
		catch(Exception e1){}
	}
	
	public void actionPerformed(ActionEvent e)	
	{
		Button b= (Button)e.getSource();
		if(b==b2)
		{
			System.exit(0);
		}
		else
		{
			try
			{
				str=t2.getText();
				dos.writeUTF(str);
			}
			catch(Exception e1){}
		}
	}
	public void run()
	{
		while(true)
		{
			try
			{
				str=dis.readUTF();
				str=t1.getText()+"\n"+str;
				t1.setText(str);
			}
			catch(Exception e1){}
		}
	}
	public static void main(String[]args)
	{
		Client4 a=new Client4();
	}
}
			

		
		