import java.util.Comparator;

public class GroupComparator implements Comparator<Human>{
	@Override
	public int compare(Human a,Human b) {
		return a.getName().compareTo(b.getName());
	}
}
