import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVWritter {
	BufferedWriter bw = null;
	public void createWritter(String path) {
		String folderPath = "C:/Users/USER/Documents/Universidad/Tudai/2017/Programacion3/Boulanger-TPEspecial/datasets/"+path+".csv";
		try {
			File file = new File(folderPath);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void write(ArrayList<String> lines) {
		
		for (String line : lines) {
			try {
				bw.write(line);
				bw.newLine();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}