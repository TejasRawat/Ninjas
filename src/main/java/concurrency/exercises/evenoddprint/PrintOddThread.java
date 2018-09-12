package concurrency.exercises.evenoddprint;

public class PrintOddThread implements Runnable {

	private PrintNumber printNumber;

	public PrintOddThread(PrintNumber printNumber) {
		this.printNumber = printNumber;
	}

	@Override
	public void run() {

		while (true) {
			if(!printNumber.isEven()) {
				printNumber.printOddNumber();
				printNumber.setEven(true);
			}
		}
	}

}
