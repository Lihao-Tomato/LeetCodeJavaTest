class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int[][] visited = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(visited[i][j] == 0){
                    max = Math.max(max, dfs(i, j, matrix, visited));
                }
            }
        }
        return max;
    }
    public int dfs(int i, int j, int[][] matrix, int[][] visited){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length){
            return 0;
        }
        if(visited[i][j] > 0){
            return visited[i][j];
        }
        int max = 0;
        if(i - 1 >= 0 && matrix[i-1][j] < matrix[i][j]){
            max = Math.max(max, dfs(i-1, j, matrix, visited));
        }
        if(i + 1 < matrix.length && matrix[i+1][j] < matrix[i][j]){
            max = Math.max(max, dfs(i+1, j, matrix, visited));
        }
        if(j - 1 >= 0 && matrix[i][j-1] < matrix[i][j]){
            max = Math.max(max, dfs(i, j-1, matrix, visited));
        }
        if(j + 1 < matrix[0].length && matrix[i][j+1] < matrix[i][j]){
            max = Math.max(max, dfs(i, j+1, matrix, visited));
        }
        
        visited[i][j] = max+1;
        return max+1;
    }
}