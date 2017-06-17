/*
 * Programación III - TPE
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public ArrayL reader(String path)  {
    	ArrayL users = new ArrayL();
    	String csvFile = path;
        String line = "";
        String csvSplitBy = ";";
        int numLine = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
            	if(numLine > 0){
            		User user = new User();
                    String[] items = line.split(csvSplitBy);
                    user.setUserId(items[0].toString());
                    for(int i=1; i < items.length-1; i++){
                    	user.addInterest(items[i].toString());
                    }
                    users.addUser(user);
            	}
            	numLine++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
   
}