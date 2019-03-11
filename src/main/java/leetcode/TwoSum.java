package leetcode;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:

 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].

 */
public class TwoSum {
    public static void main(String args[]) {

        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);

    }

    public static int[] twoSum(int[] nums, int target) {
        int lowIdx = 0;
        int highIdx = nums.length - 1;
        int solutionArray[] = new int[2];

        while (lowIdx < highIdx) {
            int total = nums[lowIdx] + nums[highIdx];
            if (target == total) {
                solutionArray[0] = lowIdx;
                solutionArray[1] = highIdx;
                break;
            } else if (target < total) {
                highIdx--;
            } else {
                lowIdx++;
            }
        }
        return solutionArray;
    }

}
