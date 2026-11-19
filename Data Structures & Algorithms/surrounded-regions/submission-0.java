class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                boolean isBorder = (i==0 || j ==0 || i == row-1||j==col-1);
                if(isBorder&&board[i][j]=='O'){
                    bfs(board,i,j);
                }
            }
        }

        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                     board[i][j]='X';
                }
            }
        }
    }
    public void bfs(char[][] board, int row, int col){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row,col});
        board[row][col]='#';
        
        while(!q.isEmpty()){
            int[]cell = q.poll();

            int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

            for(int[] d: dir){
                int r = cell[0]+d[0];
                int c= cell[1]+d[1];

                if(r>=0&&r<board.length&&c>=0&&c<board[0].length&&board[r][c]=='O'){
                    board[r][c]='#';
                    q.add(new int[]{r,c});
                }
            }
        }
    }
}
