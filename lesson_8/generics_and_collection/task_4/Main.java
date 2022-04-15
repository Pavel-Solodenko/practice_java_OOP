import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) {
		ArrayDeque<String> que = new ArrayDeque<String>();
		int countColas = 0;
		que.push("Volovitc");
		que.push("Kutrapali");
		que.push("Penny");
		que.push("Sheldon");
		que.push("Leonard");
		for(int i = 0; i < 7;i++) {
			countColas = giftCola(que,countColas);
		}
		
		printDeque(que,countColas);
		
	}
	public static int giftCola(ArrayDeque<String> que,int countColas) {
		String temp = que.poll();
		String temp_clone = temp;
		que.add(temp_clone);
		que.add(temp);
		return ++countColas;
	}
	public static void printDeque(ArrayDeque<String> que,int countColas) {
		System.out.println("Count gift cola - "+countColas);
		System.out.println(que.toString()+"\n"+"\n");
	}
}

/*
 * Шелдон,Леонард,Воловиц, Кутрапалли и Пенни стоят в очереди за "двойной колой".
 * Как только человек выпьет такой колы, он раздваивается и оба становятся в конец очереди,чтобы выпить еще.
 * Напишите программу,которая выведет на экран сотсояние очереди в зависимости от того,сколько стаканов колы выдал апарат.
 * Например, если выдано два : [Volovitc,Kutrapali,Penny,Sheldon,Sheldon,Leonard,Leonard].
 */
