class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, current, result, target);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i, current, result, target - nums[i]);
            current.remove(current.size() - 1);
        }
    }
}
