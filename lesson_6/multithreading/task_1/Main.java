public class Main {
  public static void main(String[] args) {
    NewThread[] threads = new NewThread[101];
		for (int i = 1; i < threads.length; ++i) {
			String name = "Thread" + i;
			threads[i] = new NewThread(i,name);
			threads[i].run();
		}
  }
}
