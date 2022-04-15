
public class BlackList {
	private Class<?>[] classes = new Class<?>[0];
	
	public BlackList() {
	}
	
	public void AddToBlackList(Class<?> cls) {
		Class<?>[] c = new Class<?>[classes.length+1];
		System.arraycopy(classes, 0, c, 0, classes.length);
		c[c.length-1] = cls;
		classes = c;
	}
	
	public void printList() {
		for(Class<?> k : classes) {
			System.out.println(k);
		}
	}
	
	public boolean Check(Class<?> cls) {
		for (int i = 0; i < classes.length;++i) {
			if (classes[i].equals(cls)) {
				return true;
			}
		}
		return false;
	}
	
}
