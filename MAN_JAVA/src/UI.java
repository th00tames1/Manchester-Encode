import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

public class UI extends JFrame {

	private JPanel contentPane;
	private int xpos=10, ypos=50;
	private int xpos2=10, ypos2=200;
	private String Man;
	private String DiffMan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		Encoding manenc=new Encoding();
		Man=manenc.ManEncoding();
		DiffMan=manenc.DiffManEncoding();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout());
	}
	
	@Override
	public void paint(Graphics g) {
//		super.paint(g);
		
		if(Man.charAt(0)=='0' && Man.charAt(1)=='1')
			ypos+=50;
		
		for(int i=0;i<Man.length()-1;i++) {
			if(Man.charAt(i)=='0' && Man.charAt(i+1)=='0') {
				g.drawLine(xpos, ypos, xpos+20, ypos);
				xpos+=20;
			}
			if(Man.charAt(i)=='0' && Man.charAt(i+1)=='1') {
				g.drawLine(xpos, ypos, xpos+10, ypos);
				xpos+=10;
				g.drawLine(xpos, ypos, xpos, ypos-50);
				ypos-=50;
				g.drawLine(xpos, ypos, xpos+10, ypos);
				xpos+=10;
			}
			if(Man.charAt(i)=='1' && Man.charAt(i+1)=='0') {
				g.drawLine(xpos, ypos, xpos+10, ypos);
				xpos+=10;
				g.drawLine(xpos, ypos, xpos, ypos+50);
				ypos+=50;
				g.drawLine(xpos, ypos, xpos+10, ypos);
				xpos+=10;
			}
			if(Man.charAt(i)=='1' && Man.charAt(i+1)=='1') {
				g.drawLine(xpos, ypos, xpos+20, ypos);
				xpos+=20;
			}
		}
		xpos=10; ypos=50;
		
		if(DiffMan.charAt(0)=='0') {
			g.drawLine(xpos2, ypos2, xpos2+0, ypos2+50);
			ypos2+=50;
		}
		
		for(int i=0;i<DiffMan.length()-1;i++) {
			if(DiffMan.charAt(i)=='0' && DiffMan.charAt(i+1)=='0') {
				g.drawLine(xpos2, ypos2, xpos2+20, ypos2);
				xpos2+=20;
			}
			if(DiffMan.charAt(i)=='0' && DiffMan.charAt(i+1)=='1') {
				g.drawLine(xpos2, ypos2, xpos2+10, ypos2);
				xpos2+=10;
				g.drawLine(xpos2, ypos2, xpos2, ypos2-50);
				ypos2-=50;
				g.drawLine(xpos2, ypos2, xpos2+10, ypos2);
				xpos2+=10;
			}
			if(DiffMan.charAt(i)=='1' && DiffMan.charAt(i+1)=='0') {
				g.drawLine(xpos2, ypos2, xpos2+10, ypos2);
				xpos2+=10;
				g.drawLine(xpos2, ypos2, xpos2, ypos2+50);
				ypos2+=50;
				g.drawLine(xpos2, ypos2, xpos2+10, ypos2);
				xpos2+=10;
			}
			if(DiffMan.charAt(i)=='1' && DiffMan.charAt(i+1)=='1') {
				g.drawLine(xpos2, ypos2, xpos2+20, ypos2);
				xpos2+=20;
			}
		}
		xpos2=10; ypos2=200;
	}
	
	@Override
	public void repaint() {
		super.repaint();
	}
//	
//	@Override
//	public void update(Graphics g) {
//		super.update(g);
//	}
}
