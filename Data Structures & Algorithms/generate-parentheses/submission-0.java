class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        backtrack(current, 0, 0, result, n);
        return result;
    }

    private void backtrack(StringBuilder current, int open, int close, List<String> result, int n) {
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        if (open < n) {
            current.append('(');
            backtrack(current, open + 1, close, result, n);
            current.deleteCharAt(current.length() - 1);
        }

        if (close < open) {
            current.append(')');
            backtrack(current, open, close + 1, result, n);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
