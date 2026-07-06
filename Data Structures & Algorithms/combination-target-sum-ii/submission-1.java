class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, current, result, target);
        return result;
    }

    private void backtrack(
        int[] nums, int start, List<Integer> current, List<List<Integer>> result, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result, target - nums[i]);
            current.remove(current.size() - 1);
        }
    }
}
