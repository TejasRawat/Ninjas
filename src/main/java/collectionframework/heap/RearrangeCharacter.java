package collectionframework.heap;

import java.util.*;

/**
 * Given a string with repeated characters, task is to rearrange characters in a string such that no two adjacent characters are same.
 * <p>
 * <p>
 * Note : It may be assumed that the string has only lowercase English alphabets.
 * <p>
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test
 * case contains a single line containing a string of lowercase english alphabets.
 * <p>
 * Output:
 * For each test case in a new line print 1 if the generated sting doesn't contains any same adjacent characters,
 * else if no such string is possible to be made print 0.
 */

public class RearrangeCharacter {
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int testCase = sc.nextInt();
            List<String> inputs = new ArrayList<>();

            for (int i = 0; i < testCase; i++) {
                String input = sc.next();
                inputs.add(input);
            }
            List<Integer> outputs = new ArrayList<>();

          //  inputs.add("axiqenxohssbtwwwwwwwwwwwwwww");
         /*   inputs.add("bbbabaaacd");
            inputs.add("bbb");
    */

            for (int i = 0; i < inputs.size(); i++) {
                String input = inputs.get(i);
                boolean isRearrangeable = isRearrangeable(input);
                if (isRearrangeable) {
                    outputs.add(1);
                } else {
                    outputs.add(0);
                }
            }

            for (int i = 0; i < outputs.size(); i++) {
                System.out.println(outputs.get(i));
            }

        }

        private static boolean isRearrangeable(String input) {
            Map<Character, Integer> alphBtOccurence = new HashMap<Character, Integer>();
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (!alphBtOccurence.containsKey(new Character(ch))) {
                    alphBtOccurence.put(new Character(ch), getCharOccurInStr(ch, input, i));
                }
            }

            Iterator<Map.Entry<Character, Integer>> iterator = alphBtOccurence.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<Character, Integer> next = iterator.next();
                Integer value = next.getValue();
                if(value >= input.length()/2+1){
                    return false;
                }
            }

            return true;
        }

        private static Integer getCharOccurInStr(char ch, String input, int idx) {
            int count = 0;
            for (int i = idx; i < input.length(); i++) {
                if (input.charAt(i) == ch) {
                    count++;
                }
            }
            return count;
        }

    }
