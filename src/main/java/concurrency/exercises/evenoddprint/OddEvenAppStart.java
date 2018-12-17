package concurrency.exercises.evenoddprint;

public class OddEvenAppStart {
	public static void main(String[] args) {

		PrintNumber printNumber = new PrintNumber(20);
		
		PrintEvenThread printEvenThread = new PrintEvenThread(printNumber);
		PrintOddThread printOddThread   = new PrintOddThread(printNumber);

		Thread evenThread = new Thread(printEvenThread,"even");
		Thread oddThread  = new Thread(printOddThread,"odd");

		oddThread.start();
		evenThread.start();

	}
}
