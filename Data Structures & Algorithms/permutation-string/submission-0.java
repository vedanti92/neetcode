class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Counts = new int[26];
        int[] s2Counts = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Counts[s1.charAt(i) - 'a']++;
        }

        for (int right = 0; right < s2.length(); right++) {
            s2Counts[s2.charAt(right) - 'a']++;

            if (right >= s1.length()) {
                int left = right - s1.length();
                s2Counts[s2.charAt(left) - 'a']--;
            }

            if (right >= s1.length() - 1) {
                if (matches(s1Counts, s2Counts)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean matches(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }
}
