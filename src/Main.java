import java.util.ArrayList;

public class Main {
	final static String path3m = "C:/Users/USER/Documents/Universidad/Tudai/2017/Programacion3/Boulanger-TPEspecial/datasets/dataset_500000.csv";
	final static String pathSearch = "C:/Users/USER/Documents/Universidad/Tudai/2017/Programacion3/Boulanger-TPEspecial/datasets/dataset_busqueda_10000.csv";
	public static void main(String[] args) {
		// Se agregan 10 mil de  usuarios y se realizan 3 millones de búsquedas
		execute(pathSearch, path3m , "Boulanger-3en10");
		System.out.println("End 3en10");
        // Se agregan 3 millones de  usuarios y se realizan 10 mil de búsquedas
		execute(path3m, pathSearch, "Boulanger-10en3");
		System.out.println("End 10en3");
	}

	private static void execute(String users, String search, String path) {
		ArrayL preload = new ArrayL();
		ArrayL searchUsers = new ArrayL();
		//Se precargan los archivos
		CSVReader csvr = new CSVReader();
		preload = csvr.reader(users);
		searchUsers = csvr.reader(search);
		System.out.println("End reader");
		//Se ordena la lista de precarga
		MergeSort.sort(preload);
		System.out.println("End sort");
		searchUsers(preload, searchUsers, path);
	}

	private static void searchUsers(ArrayL preload, ArrayL searchUsers, String path) {
		ArrayList<String> lines = new ArrayList<String>();
		lines.add("id;exist;time");
		User[] users = searchUsers.userList();
		for(int i = 0; i < searchUsers.length()-1; i++){
			long startTime = System.nanoTime();
			boolean result = preload.searchUser(users[i], 0, preload.length()-1);
			long resultTime = System.nanoTime() - startTime;
			String line = users[i].getUserId().toString() + ";" + result + ";" + resultTime;
			lines.add(line);
		}
		printResult(lines, path);
	}

	private static void printResult(ArrayList<String> lines, String path) {
		CSVWritter csvw = new CSVWritter();
		csvw.createWritter(path);
		csvw.write(lines);
	}
}
