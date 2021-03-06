package concurrency.threadpoolexecutor;

import java.util.concurrent.*;

public class StarttUp {
	public static void main(String args[]) throws InterruptedException {
		// RejectedExecutionHandler implementation
		RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();
		ThreadFactory threadFactory = Executors.defaultThreadFactory();

		// creating the ThreadPoolExecutor
		ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(2), threadFactory, rejectionHandler);

		MyMonitorThread monitor = new MyMonitorThread(executorPool, 3);
		Thread monitorThread = new Thread(monitor);

		// monitorThread.start();

		// submit work to the thread pool
		for (int i = 0; i < 10; i++) {
			executorPool.execute(new WorkerThread("cmd" + i));
		}

		Thread.sleep(30000);
		// shut down the pool
		executorPool.shutdown();

		Thread.sleep(5000);
		monitor.shutdown();

	}
}
