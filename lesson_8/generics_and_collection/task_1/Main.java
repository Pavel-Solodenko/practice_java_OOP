import java.util.*;

public class Main {
  public static void main(String[] args) {
    public static void a(Number[] b ) {
		ArrayList<Number> list = new ArrayList<Number>();
		for (int i = 0; i < 10;++i) {
			list.add(b[i]);
		}
		list.remove(0);
		list.remove(0);
		list.remove(list.size()-1);
		
		Iterator<Number> itr = list.iterator();
		for(;itr.hasNext();) {
			System.out.println(itr.next());
		}
  }
}
