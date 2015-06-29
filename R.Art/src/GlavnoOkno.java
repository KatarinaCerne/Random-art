//import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.Component;
import java.awt.FileDialog;
//import java.awt.Font;
import java.awt.Frame;
//import java.awt.GraphicsDevice;
//import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
//import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.WindowEvent;
//import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
//import java.util.Hashtable;


import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
//import javax.swing.BorderFactory;
//import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JSlider;
//import javax.swing.border.TitledBorder;
//import javax.swing.event.ChangeEvent;
//import javax.swing.event.ChangeListener;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GlavnoOkno extends JFrame implements ActionListener,ChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Slika slika;
	private JButton NarisiButton; 
	private JButton ShraniButton;
	private JButton CrnoBelButton;
	private JButton SivButton;
	private JSlider SvetlostSlider;

	static final int FPS_MIN = -80;
	static final int FPS_MAX = 80;
	static final int FPS_INIT = 0; 
	
	public GlavnoOkno() {
		super();
		this.getContentPane().setBackground(new Color(235, 255, 255));
		
		setTitle("Random Art");
		slika = new Slika(512, 512);
		// Nastavimo layout manager
		setLayout(new GridBagLayout());
		
		// Dodamo sliko
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridy = 0;
		c.gridx = 0;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.anchor = GridBagConstraints.CENTER;
		add(slika, c);
		slika.narisi();
		
		//gumb za risanje
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 2;
		c.weightx = 2;
		c.weighty = 1;
		NarisiButton = new JButton("Še enkrat!");
		NarisiButton.addActionListener(this);
		add(NarisiButton, c);
		
		//gumb za shranjevanje
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 3;
		c.gridy = 2;
		c.weightx = 2;
		c.weighty = 1;
		ShraniButton = new JButton("Shrani!");
		ShraniButton.addActionListener(this);
		add(ShraniButton, c);
		
		//gumb za èrno-belo
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 3;
		c.weightx = 2;
		c.weighty = 1;
		CrnoBelButton = new JButton("Èrno-bela!");
		CrnoBelButton.addActionListener(this);
		add(CrnoBelButton, c);
		
		//gumb za sivino
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 3;
		c.gridy = 3;
		c.weightx = 2;
		c.weighty = 1;
		SivButton = new JButton("Siva!");
		SivButton.addActionListener(this);
		add(SivButton, c);
    
	//slider za svetlost
	c = new GridBagConstraints();
	c.gridx = 2;
	c.gridy = 5;
	c.weightx = 2;
	c.weighty = 1;
	SvetlostSlider = new JSlider(JSlider.HORIZONTAL,
            FPS_MIN, FPS_MAX, FPS_INIT);
	SvetlostSlider.addChangeListener(this);
	SvetlostSlider.setMajorTickSpacing(10);
	SvetlostSlider.setMinorTickSpacing(10);
	SvetlostSlider.setPaintTicks(true);
	SvetlostSlider.setPaintLabels(true);
	
	
//	Font font = new Font("Serif", Font.ITALIC, 12);
//	SvetlostSlider.setFont(font);
	
	Hashtable labelTable = new Hashtable();
	labelTable.put( new Integer( FPS_MIN ), new JLabel("Temna") );
	//labelTable.put( new Integer( FPS_INIT ), new JLabel("Original") );
	labelTable.put( new Integer( FPS_MAX ), new JLabel("Svetla") );
	SvetlostSlider.setLabelTable( labelTable );
	SvetlostSlider.setPaintLabels(true);
	
    TitledBorder title;
    title = BorderFactory.createTitledBorder("Svetlost");
    SvetlostSlider.setBorder(title);
	
	add(SvetlostSlider,c);
	}

	public void stateChanged(ChangeEvent e) {
	    //JSlider source = (JSlider)e.getSource();
	    if (e.getSource()==SvetlostSlider){
	    if (!SvetlostSlider.getValueIsAdjusting()) {
	    	if (slika.crno_belo){
	    		//SvetlostSlider.setValue(0);
	    		JOptionPane.showMessageDialog(null,
	    			    "Èrno-beli sliki ni dovoljeno spreminjati svetlobe.",
	    			    "Error",
	    			    JOptionPane.ERROR_MESSAGE);
	    		
	    	}
	    	else{
	        int svetl = (int)SvetlostSlider.getValue();
	        slika.svetl = svetl;
	        slika.svetlost(slika.original);
	    	}

	    }
	    }
	}
	

	public void actionPerformed(ActionEvent event) {
		if (event.getSource()==NarisiButton){
			SvetlostSlider.setValue(0);
			slika.narisi();
			
		}
		else if (event.getSource() == ShraniButton){
			FileDialog fileDialog = new FileDialog(new Frame(), "Shrani", FileDialog.SAVE);
			fileDialog.setVisible(true);
			String ime_datoteke = fileDialog.getFile();
			if (ime_datoteke != null){
				File outputfile = new File(fileDialog.getDirectory(), fileDialog.getFile());
				try {
					ImageIO.write(slika.slika, "png", outputfile);
				} 
				
				catch (IOException event1) {
					event1.printStackTrace();
				}
			}
		}
		else if (event.getSource() == CrnoBelButton){
			slika.crnoBela(slika.slika);
		}
		else if (event.getSource() == SivButton){
			slika.sivina(slika.slika);
		}
	}



	

}
