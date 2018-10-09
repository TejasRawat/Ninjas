package collectionframework.list.linkedlist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LinkedListTest {
    public static void main(String args[]) {

      /*  LinkedList<Integer> list = new LinkedList<>();

        String temp = "97 86 94 47 74 3 50 39 11 34 66 2 67 67 64 93 54 4 69 32 26 68 20 9 1 3 16 32 17 9" +
                " 32 13 46 77 59 19 80 60 57 42 94 74 43 12 40 58 4 45 62 73 28 39 92 100 47 92 2 62 24 18 22 55 " +
                "82 67 83 40 38 14 52 94 55 45 68 49 56 59 7 11 56 20 35 83 58 27 82 56 70 35 69 93 4 90 99 37";


        List<String> strings = Arrays.asList(temp.split(" "));

        for(String str : strings){
            list.add(Integer.parseInt(str));
        }


        Integer middle = list.getMiddle();*/


        LinkedList<Integer> list = new LinkedList<>();

        String temp = "5 4 3 2 1";


        List<String> strings = Arrays.asList(temp.split(" "));

        for(String str : strings){
            list.add(Integer.parseInt(str));
        }

        print(list);
        Node reverse = list.reverse(list.getFront(), 2);

        list.setFront(reverse);

        System.out.println("After");
        print(list);

    }

    public static boolean print(LinkedList<Integer> list){
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print("," + iterator.next());
        }
        //System.out.println("Done");

        return true;
    }

}
