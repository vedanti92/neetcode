class Solution {
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                boolean[][] visited = new boolean[r][c];

                if (backtrack(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(
        char[][] board, String word, boolean[][] visited, int row, int col, int index) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]
            || board[row][col] != word.charAt(index)) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        visited[row][col] = true;

        boolean found = backtrack(board, word, visited, row + 1, col, index + 1)
            || backtrack(board, word, visited, row - 1, col, index + 1)
            || backtrack(board, word, visited, row, col + 1, index + 1)
            || backtrack(board, word, visited, row, col - 1, index + 1);

        visited[row][col] = false;

        return found;
    }
}
