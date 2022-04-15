
public class NotFoundStudentException extends ArrayIndexOutOfBoundsException{
	@Override
	public String getMessage() {
		return "Student not found!";
	}
}
