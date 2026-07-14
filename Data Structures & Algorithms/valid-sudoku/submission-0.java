class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> s = new HashSet<String>();

        for(int r =0; r < 9; r++){
            for(int c =0; c< 9; c++){
                int val = board[r][c];

                if (val == '.') continue;

                String rowkey = val + "in row" + r;
                String colkey = val + "in col" + c;
                String boxkey = val + "in box" + (r / 3)+ " " + (c / 3);

                if( !s.add(rowkey) || !s.add(colkey) || !s.add(boxkey)){
                    return false;
                }
            }
        }
        return true;
    }
}
