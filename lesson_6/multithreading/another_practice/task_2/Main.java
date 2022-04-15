package another_practice_multithreading_2;

public class Main {
	public static void main(String[] args) {
		int[] numbers1 = {1,2,3,4,5};
		int[] numbers2 = {5,4,3,2,1};
		int[] numbers3 = {0,-1,-2,-3,-4};
		SaveAsThreads t1 = new SaveAsThreads(numbers1);
		SaveAsThreads t2 = new SaveAsThreads(numbers2);
		SaveAsThreads t3 = new SaveAsThreads(numbers3);
	}
}

/*
Заданы три целочисленных массива. Записать эти массивы в файл в паралельних потоках. 
Создать класс SaveAsThread для представления потока, который записывает целочисленный массив в файл. 
*/