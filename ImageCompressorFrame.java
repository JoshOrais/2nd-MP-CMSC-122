import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageCompressorFrame extends JFrame
{
	private CompressPanel compressPanel;
	private DecompressPanel decompressPanel;

	public ImageCompressorFrame(){
		super("Image Compressor");
		setSize(1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new GridLayout(1,2));

		compressPanel = new CompressPanel("Compress");
		decompressPanel = new DecompressPanel("Decompress");

		add(compressPanel);
		add(decompressPanel);

		setVisible(true);
	}
}