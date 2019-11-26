import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class FileManager{
	private JFileChooser fileManager;

	public File chooseFile(){
		fileManager = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		int returnValue = fileManager.showOpenDialog(null);

		if(returnValue == JFileChooser.APPROVE_OPTION){
			File selectedFile = fileManager.getSelectedFile();
			//System.out.println(selectedFile.getAbsolutePath());
			return selectedFile;
		}
		return null;
	}	

	public void saveFile(File file){
		fileManager = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		fileManager.setDialogTitle("Choose a directory to save your file: ");
		fileManager.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		int returnValue = fileManager.showSaveDialog(null);
		if(returnValue == JFileChooser.APPROVE_OPTION){
			System.out.println("You selected the directory: " + fileManager.getSelectedFile());
			
			/*try{
				File file = new File("compressed.zan");

				if(!file.exists()){
					file.createNewFile();
				}

				FileWriter writer = new FileWriter(directory);
				BufferedWriter bWriter = new BufferedWriter(writer);
				bWriter.write();
				bWriter.close();
			} catch(IOException e){
				e.printStackTrace();
			}*/
		}
	}
}