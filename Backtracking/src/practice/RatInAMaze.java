package practice;

public class RatInAMaze {
	
	public static void ratInAMaze(int maze[][], int n) {
        int path[][] = new int[n][n];

        // Call the solveMaze function starting from the top-left corner (0,0)
        solveMaze(maze, 0, 0, path);
    }

    public static void solveMaze(int[][] maze, int i, int j, int[][] path) {
        int n = maze.length;

        // Check if i,j cell is valid or not.
        if (i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1) {
            return;
        }

        // Since the cell is valid, include this cell in the current path.
        path[i][j] = 1;

        // Base case: If the destination is reached, print the path
        if (i == n - 1 && j == n - 1) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    System.out.print(path[r][c] + " ");
                }
            }
            System.out.println(); // Add this line to print a newline after the path
            path[i][j]=0;
        }

        // Explore further in all directions
        solveMaze(maze, i - 1, j, path); // Move Up
        solveMaze(maze, i + 1, j, path); // Move Down
        solveMaze(maze, i, j - 1, path); // Move Left
        solveMaze(maze, i, j + 1, path); // Move Right

        // Backtrack: Mark this cell as unvisited when returning from recursion
        path[i][j] = 0;
    }

	public static void main(String[] args) {
		
		int maze[][]= {{1,1,0},{1,1,0},{1,1,1}};
		ratInAMaze(maze, maze.length);
		
	}

}
