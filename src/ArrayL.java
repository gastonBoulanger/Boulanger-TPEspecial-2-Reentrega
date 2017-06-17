
public class ArrayL implements IList{
	private User[] users = new User[10000];
	private Integer lastInsert = 0;
	private Boolean exist = false;
	private Boolean isSort = false;
	
	public Boolean isSort() {
		return isSort;
	}

	public void setIsSort(Boolean isSort) {
		this.isSort = isSort;
	}

	@Override
	public void addUser(User user) {
		if(user.getUserId() != null){
			if(lastInsert >= this.users.length){
				duplicateArrayLength();
			}
			this.users[lastInsert] = user;
			lastInsert++;
		}
	}
	
	private void duplicateArrayLength(){
		User[] usersTemp = new User[this.users.length*2]; 
		for (int i = 0; i < this.users.length; i++) {
			usersTemp[i] = this.users[i];
		}
		users = usersTemp;
	}
	
	public User[] userList(){
		return users;
	}
	
	public int length(){
		return lastInsert;
	}
	
	public Boolean searchUser(User user, int min, int max){
		int tot = min + max;
		int mid = tot/2;
		int resultUser = users[mid].compareTo(user);
		if(resultUser == 0){
			System.out.println(users[mid].getUserId() + " " + user.getUserId());
			exist = true;
		}
		else if(!(min >= max)){
			exist = false;
			if(resultUser < 0){
				searchUser(user, mid + 1, max);
			}
			else if(resultUser > 0){
				searchUser(user, min, mid);
			}
		}
		return exist;
	}
}
