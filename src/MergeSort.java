
public class MergeSort {
	private static int size;
	public static void sort(ArrayL users) {
		size = users.length();
		if(!users.isSort()){
			mergesort(users.userList(), 0, size - 1);
		}
		users.setIsSort(true);
	}

	private static void mergesort(User[] users, int min, int max) {
		if (min < max) {
			int mid = (min + max) / 2;
			mergesort(users, min, mid);
			mergesort(users, mid + 1, max);
			merge(users, min, mid, max);
		}
	}

	private static void merge(User[] users, int min, int mid, int max) {
		try{
			User[] aux = new User[size];
			for (int i = min; i <= max; i++) {
				aux[i] = users[i];
			}
			int i = min;
			int j = mid + 1;
			int k = min;
			while (i <= mid && j <= max) {
				if (aux[i].getUserId() <= aux[j].getUserId()) {
					users[k] = aux[i];
					i++;
				} else {
					users[k] = aux[j];
					j++;
				}
				k++;
			}

			while (i <= mid) {
				users[k] = aux[i];
				k++;
				i++;
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
