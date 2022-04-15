public class Main {
	public static void main(String[] args) {
		Cat cat1 = new Cat("Yellow", "Vasya", "Dvorovoi", 2);
		cat1.UpdateCate(cat1, "Grey", "Petr", "Egyptian", 4);
		cat1.PrintCat(cat1);
		cat1.CatMeow();
		cat1 = null;
		Runtime.getRuntime().gc();
	}
}
