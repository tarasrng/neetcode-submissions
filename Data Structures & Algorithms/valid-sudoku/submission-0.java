class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set[] boxes = new Set[9];
        Set[] rows = new Set[9];
        Set[] cols = new Set[9];
        for (int rowIdx = 0; rowIdx < 9; rowIdx++) {
            
            rows[rowIdx] = new HashSet<Character>();
            
            for (int colIdx = 0; colIdx < 9; colIdx++) {
                int boxIdx = (rowIdx / 3) * 3 + (colIdx / 3);
                if (boxes[boxIdx] == null) {
                    boxes[boxIdx] = new HashSet<Character>();
                }
                if (cols[colIdx] == null) {
                    cols[colIdx] = new HashSet<Character>();
                }
                Character c = board[rowIdx][colIdx];
                if (!c.equals('.')) {
                    
                    if (boxes[boxIdx].contains(c) 
                    || rows[rowIdx].contains(c)
                    || cols[colIdx].contains(c)) {
                        return false;
                    }
                    boxes[boxIdx].add(c);
                    cols[colIdx].add(c);
                    rows[rowIdx].add(c);
                }
            }
        }
        return true;
    }
}
