class Cat {
	String color, name, breed;
	int old;
	Cat(String color,String name,String breed,int old) {
		this.color = color;
		this.name = name;
		this.breed = breed;
		this.old = old;
	}
	void UpdateCate(Cat cat, String color, String name, String breed,int old) {
		this.color = color;
		this.name = name;
		this.breed = breed;
		this.old = old;
	}
	void PrintCat(Cat cat) {
		System.out.println("Cat name - " + cat.name);
		System.out.println("Cat color - " + cat.color);
		System.out.println("Cat breed - " + cat.breed);
		System.out.println("Cat old - " + cat.old);
	}
	void CatMeow() {
		System.out.println("Meow");
	}
}
