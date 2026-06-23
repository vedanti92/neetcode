class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return -1;
        }

        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        for (int num = 0; num < nums.length; num++) {
            if (nums[num] != num + 1) {
                return nums[num];
            }
        }

        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
