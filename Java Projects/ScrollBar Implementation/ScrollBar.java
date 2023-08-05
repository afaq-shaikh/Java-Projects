import java.awt.*;
import java.awt.event.*;

public class ScrollBar extends Frame implements AdjustmentListener, FocusListener, ActionListener{
	Label lr, lg, lb, lclr;
	Scrollbar sr, sg, sb;
	TextField tr, tg, tb;
	Panel pr, pg, pb, pclr;
	Button bc, bx;
	int r, g, b;
	Color cr, cg, cb, cclr;

	ScrollBar()
	{
		super("Scrollbar");
		lr = new Label("R");
		lg = new Label("G");
		lb = new Label("B");
		lclr = new Label("Colour");
			

		sr = new Scrollbar(Scrollbar.VERTICAL, 0, 5, 0, 255);
		sg = new Scrollbar(Scrollbar.VERTICAL, 0, 5, 0, 255);
		sb = new Scrollbar(Scrollbar.VERTICAL, 0, 5, 0, 255);
		sr.addAdjustmentListener(this);
		sg.addAdjustmentListener(this);
		sb.addAdjustmentListener(this);

		tr = new TextField(5);
		tg = new TextField(5);
		tb = new TextField(5);
		tr.addFocusListener(this);
		tg.addFocusListener(this);
		tb.addFocusListener(this);

		pr = new Panel();
		pg = new Panel();
		pb = new Panel();
		pclr = new Panel();

		bc = new Button("Colour");
		bx = new Button("Exit");
		bx.addActionListener(this);
		bc.addActionListener(this);

		setLayout(null);

		lr.setBounds(50,50,50,20);
		lg.setBounds(110,50,50,20);
		lb.setBounds(170,50,50,20);
		lclr.setBounds(230,50,100,20);

		sr.setBounds(50,80,50,100);
		sg.setBounds(110,80,50,100);
		sb.setBounds(170,80,50,100);
		pclr.setBounds(230,80,100,100);
		tr.setBounds(50,190,50,20);
		tg.setBounds(110,190,50,20);
		tb.setBounds(170,190,50,20);
		bc.setBounds(230,190,100,20);
		pr.setBounds(50,220,50,20);
		pg.setBounds(110,220,50,20);
		pb.setBounds(170,220,50,20);
		bx.setBounds(230,220,100,20);

		add(lr);
		add(lg);
		add(lb);
		add(lclr);
		add(sr);
		add(sg);
		add(sb);
		add(pclr);
		add(tr);
		add(tg);
		add(tb);
		add(bc);
		add(pr);
		add(pg);
		add(pb);
		add(bx);
		

		setSize(380,290);
		setVisible(true);
		
	}

	public void focusGained(FocusEvent e)
	{

	}

	public void focusLost(FocusEvent e)
	{
		try
		{
			r = Integer.parseInt(tr.getText());
		}
		catch(Exception e1) {
			tr.requestFocus();
			return;
		}
		try
		{
			g = Integer.parseInt(tg.getText());
		}
		catch(Exception e3) {
			tg.requestFocus();
			return;
		}
		try
		{
			b = Integer.parseInt(tb.getText());
		}
		catch(Exception e4) {
			tb.requestFocus();
			return;
		}
		if(r<0||r>255)
		{
			tr.requestFocus();
			return;
		}
		if(g<0||g>255)
		{
			tg.requestFocus();
			return;
		}
		if(b<0||b>255)
		{
			tb.requestFocus();
			return;
		}
		sr.setValue(r);
		sg.setValue(g);
		sb.setValue(b);
		cr = new Color(r, 0, 0);
		cg = new Color(0,g,0);
		cb = new Color(0,0,b);
		cclr = new Color(r,g,b);
		pr.setBackground(cr);
		pg.setBackground(cg);
		pb.setBackground(cb);
		pclr.setBackground(cclr);
	}

	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		r = sr.getValue();
		g = sg.getValue();
		b = sb.getValue();
		
		tr.setText(""+r);
		tg.setText(""+g);
		tb.setText(""+b);

		cr = new Color(r,0,0);
		cg = new Color(0,g,0);
		cb = new Color(0, 0, b);
		cclr = new Color(r,g,b);
		pr.setBackground(cr);
		pg.setBackground(cg);
		pb.setBackground(cb);
		pclr.setBackground(cclr);
	}

	public void actionPerformed(ActionEvent e)
	{
		Button b1 = (Button)e.getSource();
		if(b1==bx)
		{
			System.exit(0);
		}
		else
		{
			cclr = new Color(r,g,b);
		}
	}
	public static void main(String[]args)
	{
		ScrollBar a = new ScrollBar();
	}
}