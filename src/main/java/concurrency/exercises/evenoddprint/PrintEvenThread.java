package concurrency.exercises.evenoddprint;

public class PrintEvenThread implements Runnable {

	private PrintNumber printNumber;

	public PrintEvenThread(PrintNumber printNumber) {
		this.printNumber = printNumber;
	}

	@Override
	public void run() {

		while (true) {
			if (printNumber.isEven()) {
				printNumber.printEvenNumber();
				printNumber.setEven(false);
			}
		}

	}

}
