import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class CompressPanel extends Panel
{
	public CompressPanel(String action){
		super(action);
		//CompressPanel specific things
	}

	@Override
	public void actionPerformed(ActionEvent event){
		fileManager = new FileManager();

		if(event.getSource() == fileButton){			
			image = fileManager.chooseFile();
			if(image != null){
				try{
					imageIcon = ImageIO.read(image);
				} catch(IOException e){}

				imageLabel.setIcon(new ImageIcon(imageIcon));
				imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
			}
		}else if(event.getSource() == actionButton){
			
			//compress image
			
			fileManager.saveFile(image);
		}
	}
}