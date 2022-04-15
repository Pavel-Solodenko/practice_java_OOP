
public class Main {
	public static void main(String[] args) {
		Integer a = 0;
		boolean b = false;
		String c = "oas";
		
		BlackList blacklist = new BlackList();
		blacklist.AddToBlackList(a.getClass());
		StackDemo stack = new StackDemo(blacklist);
		stack.addToStack(a);
		stack.addToStack(b);
		stack.addToStack(c);
		
		Object obj = new Object();
		
		
//		blacklist.printList();
	}
}
