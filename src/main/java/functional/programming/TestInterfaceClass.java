package functional.programming;

import java.util.function.*;

public class TestInterfaceClass {
    public static void main(String args[]) {


    }
}


class Test<T> implements Supplier<T>,Consumer<T>{

    T data;

    @Override
    public T get() {
        return null;
    }

    @Override
    public void accept(T t) {

    }
}