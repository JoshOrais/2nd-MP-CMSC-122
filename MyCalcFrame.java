import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;

public class MyCalcFrame extends JFrame
{
    private BufferedImage myImage;
    private JPanel mypanel;
    private Compressor compressor = new Compressor();
    private Decompressor decompressor = new Decompressor();
    private Node root = null;
    private File file;

    public MyCalcFrame()
    {
        this.setBounds(410, 110, 600, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(true);
        this.setAlwaysOnTop(true);

        file = new File("sample.png");
        root = compressor.compress(file);
        this.myImage=decompressor.decompress("COMPRESSED.data", root);
        
        this.mypanel=new JPanel();
        this.mypanel.setBackground(Color.black);
        this.setContentPane(new ImagePanel(myImage));

        this.setVisible(true);
    }//end MyCalcFrame constructor


    class ImagePanel extends JComponent 
    {
        private Image image;

        public ImagePanel(Image image)
        {
            this.image = image;
        }//end constructor
        @Override
        protected void paintComponent(Graphics g)
        {
            g.drawImage(image, 0, 0, null);
            g.setColor(Color.BLACK);
            g.fillRect(10, 10, 100, 100);
        }//en paintComponent
    }

    public static void main(String[] args)
    {
        new MyCalcFrame();
    }
}