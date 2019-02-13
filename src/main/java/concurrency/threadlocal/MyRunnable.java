package concurrency.threadlocal;

public class MyRunnable implements Runnable {

    private static final ThreadLocal<String> threadLocal =
            new ThreadLocal<String>() {
                @Override
                protected String initialValue() {
                    return "Apple";
                }
            };

    @Override
    public void run() {
        threadLocal.set(threadLocal.get() + "Mango");
        System.out.println(threadLocal.get());
    }

}
