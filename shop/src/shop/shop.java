package shop;
import java .util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

 

public class shop extends JFrame {
	 
	 
	JFrame jf = new JFrame();
	JPanel p;

	JButton b1;
	JButton b2;

	public shop() {
		gui();
	}

	public void gui() {

		///////////////// font
		Font f = new Font("Serif", Font.BOLD, 30);

		/////////////////////////////// head

		JPanel head;
		head = new JPanel();

		head.setBackground(new Color(0, 0, 0, 90));

		head.setBounds(0, 0, 960, 100);
		JLabel text = new JLabel("second hand shop");
		text.setForeground(Color.WHITE);
		text.setBounds(200, 50, 400, 50); 
		
		text.setFont(f);
		head.add(text);
		// buttn xxxxx
		JPanel bo = new JPanel();
		bo.setLayout(null);
		bo.setSize(400, 350);
		bo.setBackground(new Color(0, 0, 0, 90));
		bo.setBounds(300, 150, 400, 350);
		JLabel text2 = new JLabel("what you will do :");
		
		text2.setForeground(Color.WHITE);
		text2.setBounds(70, 0, 400, 50);
		text2.setFont(f);
		JRadioButton buy =new JRadioButton("buy");
		JRadioButton sell =new JRadioButton("sell");
		buy.setBounds(0, 60, 400, 50);
		sell.setBounds(0, 120, 400, 50);
		buy.setForeground(Color.DARK_GRAY);
		sell.setForeground(Color.DARK_GRAY);
		buy.setFont(f);
		sell.setFont(f);
		buy.setBackground( Color.white);
		sell.setBackground(Color.white);
		ButtonGroup bg =new ButtonGroup();
		bg.add(buy);
		bg.add(sell);
		bo.add(sell);
		bo.add(buy);
		bo.add(text2);
  
		
		 
		JButton accept = new JButton("accept");
		accept.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (buy.isSelected()) {
					 
						try {
							buy();
						} catch ( Exception e1) {
							 
							 System.out.println(e);
						}
					 
					
				   }
				 else if (sell.isSelected()) {
					try {
						sell();
					} catch (FileNotFoundException e1) {
						 
						System.out.println(e1);
					}
				   }
				else {
					
					JOptionPane.showMessageDialog(null, "plese salect an option :)");
				}
				}
		});
		accept.setForeground(Color.white);
		accept.setBackground(new Color(54, 117, 150));
		accept.setBounds(150, 175, 100, 50);
		bo.add(accept);
		 
		  

		/////////// frame
		setTitle("second hand shop");

		setSize(960, 670);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//////////////////// back

		ImageIcon bki = new ImageIcon("x.jpg");

		Image img = bki.getImage();
		Image temp = img.getScaledInstance(960, 670, Image.SCALE_SMOOTH);
		bki = new ImageIcon(temp);
		JLabel j = new JLabel("", bki, JLabel.CENTER);
		j.setBounds(100, 1000, 960, 540);
		j.add(head);
		j.add(bo);
		
		 
		add(j);
		setVisible(true);

	}

	public static void main(String[] args) {
		shop x = new shop();
	}

	public static void sell() throws FileNotFoundException     {
		  
			 
			 
		
		FileOutputStream as = new FileOutputStream("my_file.txt" ,true );
		PrintWriter pr = new PrintWriter(as);
		String a = JOptionPane.showInputDialog("input your item name pleas:");
		 
		try {
			
			
			
			
			
			String b = JOptionPane.showInputDialog("input your item price pleas:");
		int price=Integer.parseInt(b);
		String d="item name is "+a+" and price is "+b +"$";
		String c = "this item inserted successfully \n name- (" + a + ") \n price- (" +  price + "$) \n thanks  ;) ";
		JOptionPane.showMessageDialog(null, c);
		pr.println(d);
		pr.close();
		}catch (NumberFormatException e) {
			try {
				
			
			 JOptionPane.showMessageDialog(null, "input your item price in number:");
				String b = JOptionPane.showInputDialog("input your item price pleas:");
				int price=Integer.parseInt(b);
				String d="item name is "+a+" and price is "+b+"$" ;
				String c = "this item inserted successfully \n name- (" + a + ") \n price- (" +  price + "$) \n thanks  ;) ";
				JOptionPane.showMessageDialog(null, c);
				pr.println(d);
				pr.close();
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "input your item price in number:");
				String b = JOptionPane.showInputDialog("input your item price pleas:");
				int price=Integer.parseInt(b);
				String d="item name is "+a+" and price is "+b +"$";
				String c = "this item inserted successfully \n name- (" + a + ") \n price- (" +  price + "$) \n thanks  ;) ";
				JOptionPane.showMessageDialog(null, c);
				pr.println(d);
				pr.close();
			}
		 
		}
		 

		 
	}
    public static void buy() throws FileNotFoundException  {
    	File ff=new File("my_file.txt");
    	FileInputStream fos = new FileInputStream( ff);
    	 Scanner in = new Scanner(fos);
    	 
    	 
    		 while (in.hasNext() ) {
    			 
    			 String sas=in.nextLine();
    			 
    			 JOptionPane.showMessageDialog(null, "this items are avelable \n"+sas );
    		}
		 
     
    	 
    	 
         
        
    }
}
