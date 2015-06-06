import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;




public class GlavnoOkno extends JFrame {

	private Slika slika;

	public GlavnoOkno() {
		super();
		setTitle("BitnaSlika");
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
		// Slika naj se nariše
		slika.narisi();
	}
}
