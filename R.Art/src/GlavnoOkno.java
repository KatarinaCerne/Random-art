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
	private JSlider rSlider;
	private JSlider gSlider;
	private JSlider bSlider;
	private JButton RazveljaviButton;

	//max, min in zaèetna vrednost za SvetlostSlider
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
		c.gridx = 4;
		c.gridy = 3;
		c.weightx = 2;
		c.weighty = 1;
		SivButton = new JButton("Siva!");
		SivButton.addActionListener(this);
		add(SivButton, c);
		
		//gumb za razveljavi
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 4;
		c.gridy = 2;
		c.weightx = 2;
		c.weighty = 1;
		RazveljaviButton = new JButton("Razveljavi spremembe!");
		RazveljaviButton.addActionListener(this);
		add(RazveljaviButton, c);
    
		//slider za svetlost
		c = new GridBagConstraints();
		c.gridx = 3;
		c.gridy = 5;
		c.weightx = 2;
		c.weighty = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		SvetlostSlider = new JSlider(JSlider.HORIZONTAL,
				FPS_MIN, FPS_MAX, FPS_INIT);
		SvetlostSlider.addChangeListener(this);
		SvetlostSlider.setMajorTickSpacing(10);
		SvetlostSlider.setMinorTickSpacing(10);
		SvetlostSlider.setPaintTicks(true);
		SvetlostSlider.setPaintLabels(true);
	
		//namesto številk pod SvetlostSliderjem napis "temna" in "svetla"
		Hashtable labelTable = new Hashtable();
		labelTable.put( new Integer( FPS_MIN ), new JLabel("Temna") );
		labelTable.put( new Integer( FPS_MAX ), new JLabel("Svetla") );
		SvetlostSlider.setLabelTable( labelTable );
		SvetlostSlider.setPaintLabels(true);
		
		//okvir z naslovom za SvetlostSlider
		TitledBorder title;
		title = BorderFactory.createTitledBorder("Svetlost");
		SvetlostSlider.setBorder(title);
	
		add(SvetlostSlider,c);
	
		//slider za rdeèo
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 6;
		c.weightx = 2;
		c.weighty = 1;
		rSlider = new JSlider(JSlider.HORIZONTAL,0,100,100);
		add(rSlider,c);
		rSlider.addChangeListener(this);
		rSlider.setMajorTickSpacing(20);
		rSlider.setMinorTickSpacing(10);
		rSlider.setPaintTicks(true);
		rSlider.setPaintLabels(true);
	
		//okvir z naslovom za rSlider
		TitledBorder titleR;
		titleR = BorderFactory.createTitledBorder("Rdeèa");
		rSlider.setBorder(titleR);
    
    
		//slider za zeleno
		c.gridx = 3;
		c.gridy = 6;
		c.weightx = 2;
		c.weighty = 1;
		gSlider = new JSlider(JSlider.HORIZONTAL,0,100,100);
		add(gSlider,c);
		gSlider.addChangeListener(this);
		gSlider.setMajorTickSpacing(20);
		gSlider.setMinorTickSpacing(10);
		gSlider.setPaintTicks(true);
		gSlider.setPaintLabels(true);
	
		//okvir z naslovom za gSlider
		TitledBorder titleG;
		titleG = BorderFactory.createTitledBorder("Zelena");
		gSlider.setBorder(titleG);
	

		//slider za modro
		c.gridx = 4;
		c.gridy = 6;
		c.weightx = 2;
		c.weighty = 1;
		bSlider = new JSlider(JSlider.HORIZONTAL,0,100,100);
		add(bSlider,c);
		bSlider.addChangeListener(this);
		bSlider.setMajorTickSpacing(20);
		bSlider.setMinorTickSpacing(10);
		bSlider.setPaintTicks(true);
		bSlider.setPaintLabels(true);
	
		//okvir z naslovom za bSlider
		TitledBorder titleB;
		titleB = BorderFactory.createTitledBorder("Modra");
		bSlider.setBorder(titleB);
	}

	public void stateChanged(ChangeEvent e) {
	    if (e.getSource()==SvetlostSlider){
	    if (!SvetlostSlider.getValueIsAdjusting()) {
	    	if (slika.crno_belo){
	    		//èrno-beli sliki ne bomo spreminjali svetlobe
	    		//naredimo error sporoèilo
	    		JOptionPane.showMessageDialog(null,
	    			    "Èrno-beli sliki ni dovoljeno spreminjati svetlobe.",
	    			    "Error",
	    			    JOptionPane.ERROR_MESSAGE);
	    		
	    	}
	    	else{
	        int svetl = (int)SvetlostSlider.getValue();
	        slika.svetl = svetl;
	        slika.svetlostINbarva(slika.original);
	    	}

	    }
	    }
	    else if (e.getSource()==rSlider){
	    	if (slika.crno_belo || slika.sivina){
	    		//èrno-beli in sivi sliki ne moremo spreminjati barv
	    		//naredimo error sporoèilo
	    		JOptionPane.showMessageDialog(null,
	    			    "Èrno-beli ali sivi sliki ni dovoljeno spreminjati barve.",
	    			    "Error",
	    			    JOptionPane.ERROR_MESSAGE);
	    		
	    	}
	    	else{
		    if (!rSlider.getValueIsAdjusting()) {
		        int rdeca = (int)rSlider.getValue();
		        slika.rdeca = rdeca;
		        slika.svetlostINbarva(slika.original);
		    	}
	    }
	    }
	    else if (e.getSource()==gSlider){
		    if (!gSlider.getValueIsAdjusting()) {
		    	if (slika.crno_belo || slika.sivina){
		    		//gSlider.setValue(100);
		    		JOptionPane.showMessageDialog(null,
		    			    "Èrno-beli ali sivi sliki ni dovoljeno spreminjati barve.",
		    			    "Error",
		    			    JOptionPane.ERROR_MESSAGE);
		    		
		    	}
		    	else{
		        int zelena = (int)gSlider.getValue();
		        slika.zelena = zelena;
		        slika.svetlostINbarva(slika.original);
		    	}
		    }
	    }
	    else if (e.getSource()==bSlider){
		    if (!bSlider.getValueIsAdjusting()) {
		    	if (slika.crno_belo || slika.sivina){
		    		//bSlider.setValue(100);
		    		JOptionPane.showMessageDialog(null,
		    			    "Èrno-beli ali sivi sliki ni dovoljeno spreminjati barve.",
		    			    "Error",
		    			    JOptionPane.ERROR_MESSAGE);
		    		
		    	}
		    	else{
		        int modra = (int)bSlider.getValue();
		        slika.modra = modra;
		        slika.svetlostINbarva(slika.original);
		    	}
		    }
	    }
	    }
	

	public void actionPerformed(ActionEvent event) {
		if (event.getSource()==NarisiButton){
			SvetlostSlider.setValue(0);
			rSlider.setValue(100);
			gSlider.setValue(100);
			bSlider.setValue(100);
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
			rSlider.setValue(100);
			gSlider.setValue(100);
			bSlider.setValue(100);
			slika.rdeca = 100;
			slika.zelena = 100;
			slika.modra = 100;
			slika.crnoBela(slika.slika);
		}
		else if (event.getSource() == SivButton){
			rSlider.setValue(100);
			gSlider.setValue(100);
			bSlider.setValue(100);
			slika.rdeca = 100;
			slika.zelena = 100;
			slika.modra = 100;
			slika.sivina(slika.slika);
		}
		
		else if (event.getSource() == RazveljaviButton){
			slika.crno_belo = false;
			slika.sivina = false;
			slika.rdeca = 100;
			slika.zelena = 100;
			slika.modra = 100;
			slika.svetl = 0;
			SvetlostSlider.setValue(0);
			rSlider.setValue(100);
			gSlider.setValue(100);
			bSlider.setValue(100);
			slika.razveljavi(slika.slika);
		}
	}



	

}
