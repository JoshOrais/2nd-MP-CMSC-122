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
		String sizeType = "KB";

		if(event.getSource() == fileButton){
			image = fileManager.chooseFile();

			if(image != null){
				try{
					imageIcon = ImageIO.read(image);
				} catch(IOException e){}

				double size = image.length()/1024;
				if(size >= 1024){
					size = size/1024;
					sizeType = "MB";
				}
				sizeLabel.setText("size: " + Double.toString(size) + " " + sizeType);
				imageLabel.setIcon(new ImageIcon(imageIcon));
				imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
				scroller.setViewportView(imageLabel);
				partPanel[1].add(scroller, BorderLayout.CENTER);
			}
		}else if(event.getSource() == actionButton){
			
			//compress image
			
			fileManager.saveFile(image);
		}
	}
}