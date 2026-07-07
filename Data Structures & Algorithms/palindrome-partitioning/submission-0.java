class Solution {
    public List<List<String>> partition(String s) {
        List<String> current = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, current, result);
        return result;
    }

    private boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    private void backtrack(String str, int start, List<String> current, List<List<String>> result) {
        if (start == str.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < str.length(); i++) {
            String part = str.substring(start, i + 1);

            if (isPalindrome(part)) {
                current.add(part);
                backtrack(str, i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}
