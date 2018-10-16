package collectionframework.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextLargeElement {
    public static void main(String args[]){
        int a [] = {4,2,1,3,5};
        Map<Integer,Integer>  nextLgrMap = getNextLgrMap(a);
    }

    private static Map<Integer, Integer> getNextLgrMap(int[] a) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(a[0]);

        for (int i = 1; i < a.length; i++) {
            if (a[i] < stack.peek()) {
                stack.push(a[i]);
            } else {
                while (!stack.isEmpty()) {
                    if (stack.peek() < a[i]) {
                        map.put(stack.peek(), a[i]);
                        stack.pop();
                    } else {
                        stack.push(a[i]);
                        break;
                    }
                }
            }
        }
        return map;
    }

}
