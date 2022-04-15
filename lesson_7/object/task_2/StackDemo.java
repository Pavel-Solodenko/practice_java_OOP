import java.util.Stack;

public class StackDemo {
	Stack <Object> stack= new Stack<Object>();
	private BlackList blackList;
	
	public StackDemo(BlackList blacklist) {
		this.blackList = blacklist;
	}
	
	public void addToStack(Object obj) {
		Class<?> cls = obj.getClass();
		if (!blackList.Check(cls)) {
			stack.push(obj);
		}
		else {
			System.out.println(obj.getClass()+" in black list!");
		}
	}
	
	public Object takeFromStackAndDelete() {
		return stack.pop();
	}
	
	public Object takeFromStackNotDelete() {
		return stack.peek();
	}
	
}
