
public class GroupFullException extends ArrayIndexOutOfBoundsException{
	@Override 
	public String getMessage() {
		return "Group is full!";
	}
}
