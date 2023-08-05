import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class newEditor extends Frame  implements ActionListener,Runnable
{
	Button bn, bo, bs, bx;
	TextArea ta;
	Panel ps;
 	newEditor()
	{
		super("newEditor");
		Thread th= new Thread(this);
 		ta = new TextArea("",10,70,TextArea.SCROLLBARS_BOTH);
		add(ta, BorderLayout.CENTER);
 		bn = new Button("New");
		bo = new Button("Open");
		bs = new Button("save");
		bx = new Button("Exit");
 		bn.addActionListener(this);
		bo.addActionListener(this);
		bs.addActionListener(this);
		bx.addActionListener(this);
 		ps = new Panel();
		ps.add(bn);
		ps.add(bo);
		ps.add(bs);
		ps.add(bx);
 		add(ps,BorderLayout.SOUTH);
		setSize(400,300);
		setVisible(true);
		th.start();
	}
 	public void actionPerformed(ActionEvent e)
	{
		Button b = (Button)e.getSource();
		if(b==bx)
		{
			System.exit(0);
		}
		if(b==bn)
		{
			ta.setText("");
		}
		if(b==bo)
		{
			open();
		}
		if(b==bs)
		{
			save();
		}
	}
 	void open()
	{
		int val = 0;
		FileReader fr = null;
		File f = null;
		String str = "";
		FileDialog fd = null;
		try
		{
			fd = new FileDialog(this, "Open", FileDialog.LOAD);
			fd.setVisible(true);
			String fnm = fd.getDirectory()+fd.getFile();
			f = new File(fnm);
			fr = new FileReader(f);
			while(true)
			{
				val = fr.read();
				if(val==-1)
					break;
				str = str + (char)val;
			}
			ta.setText(str);
			fr.close();
		}
		catch(Exception e) {}
	}
 	void save()
	{
		String str = "";
		FileDialog fd = null;
		FileWriter fw = null;
		File f = null;
		try
		{
			str = ta.getText();
			char[]a=new char[str.length()];
			a = str.toCharArray();
			fd = new FileDialog(this, "Save", FileDialog.SAVE);
			fd.setVisible(true);
			String fnm = fd.getDirectory()+fd.getFile();
			fw = new FileWriter(fnm);
			int i=0;
			int n = a.length;
			int val=0;
			while(i<n)
			{
				val = (int)a[i];
				fw.write(val);
				i++;
			}
			fw.close();
		}
		catch(Exception e) {}
	}
	void newsave()
	{
		String str = "";
		FileWriter fw = null;
		File f = new File("tmp.txt");
		try
		{
			str = ta.getText();
			char[]a=new char[str.length()];
			a = str.toCharArray();
			fw = new FileWriter(f);
			int i=0;
			int n = a.length;
			int val=0;
			while(i<n)
			{
				val = (int)a[i];
				fw.write(val);
				i++;
			}
			fw.close();
		}
		catch(Exception e) {}
	}
	public void run()
	{
		while(true)
		{
			try
			{
				Thread.sleep(60000);	
			}
			catch(Exception e){}
			newsave();
		}
	}
 	public static void main(String[]args)
	{
		newEditor a = new newEditor();
	}
}