import java.util.ArrayList;

public class User {

	private User next;
	private Integer userId;
	private ArrayList<String> userInterest = new ArrayList<String>();
	
	public Integer getUserId(){
		return userId;
	}
	
	public void setUserId(String id){
		userId = Integer.parseInt(id);
	}
	
	public void addInterest(String interest){
		if(!userInterest.contains(interest)){
			userInterest.add(interest);
		}
	}

	public int compareTo(User user) {
		return this.userId.compareTo(user.getId());
	}

	private Integer getId() {
		return userId;
	}

	public void setNext(User user) {
		this.next = user;
	}

	public User getNext() {
		return this.next;
	}
	
	public boolean hasNext() {
		if(next != null){
			return true;
		}
		else{
			return false;
		}
	}
}
