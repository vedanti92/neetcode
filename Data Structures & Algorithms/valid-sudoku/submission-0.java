class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char number = board[r][c];

                if (number != '.') {
                    int boxIndex = (r / 3) * 3 + (c / 3);

                    if (!seen.add(number + "in row" + r) || !seen.add(number + "in column" + c)
                        || !seen.add(number + "in box" + boxIndex)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
