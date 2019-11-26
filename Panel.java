import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class Panel extends JPanel implements ActionListener
{
	protected JButton fileButton, actionButton;
	private JPanel[] partPanel = new JPanel[3];
	protected JLabel imageLabel;
	protected BufferedImage imageIcon, defaultImage;
	protected File image;
	protected FileManager fileManager;

	public Panel(String action){
		setLayout(new BorderLayout());

		try{
			defaultImage = ImageIO.read(new File("DefaultImage.png"));
		} catch(IOException e){}

		for(int i = 0; i < partPanel.length; i++){
			partPanel[i] = new JPanel();

			Border border = BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY), 
									BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
			Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
			Font font = new Font("Courier", Font.BOLD, 20);

			partPanel[i].setBorder(lineBorder);

			switch(i){
				case 0:
					fileButton = new JButton(" Open File ");
					fileButton.setFont(font);
					fileButton.setBackground(Color.LIGHT_GRAY);
					fileButton.setForeground(Color.BLACK);
					fileButton.setBorder(border);
					partPanel[i].setLayout(new FlowLayout(FlowLayout.LEFT, 10, 35));
					partPanel[i].setPreferredSize(new Dimension(500,100));
					partPanel[i].setBackground(Color.GRAY);
					add(partPanel[i], BorderLayout.NORTH);
					partPanel[i].add(fileButton);
					break;
				case 1:
					imageLabel = new JLabel();
					partPanel[i].setBackground(Color.BLACK);
					add(partPanel[i], BorderLayout.CENTER);
					partPanel[i].setLayout(new BorderLayout());
					partPanel[i].add(imageLabel, BorderLayout.CENTER);
					imageLabel.setIcon(new ImageIcon(defaultImage));
					break;
				case 2:
					actionButton = new JButton(" " + action + " ");
					actionButton.setFont(font);
					actionButton.setBackground(Color.LIGHT_GRAY);
					actionButton.setForeground(Color.BLACK);
					actionButton.setBorder(border);
					partPanel[i].setLayout(new FlowLayout(FlowLayout.CENTER, 5, 35));
					partPanel[i].setPreferredSize(new Dimension(500,100));
					partPanel[i].setBackground(Color.gray);
					add(partPanel[i], BorderLayout.SOUTH);
					partPanel[i].add(actionButton);
					break;
			}
		}

		fileButton.addActionListener(this);
		actionButton.addActionListener(this);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event){}
}