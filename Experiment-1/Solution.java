import java.util.ArrayList;

class Solution {
    public int triangularSum(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < arr.size() - 1; j++) {
                int sum = (arr.get(j) + arr.get(j + 1)) % 10;
                temp.add(sum);
            }
            arr = new ArrayList<>(temp);
            temp = new ArrayList<>();
        }
        int val = arr.get(0);

        return val;
    }
}