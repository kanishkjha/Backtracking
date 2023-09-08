package practice;

public class NQueens {

	public static void placeNQueens(int n){
		
		int[][] board= new int[n][n];
		
		placeNQueens(n, board, 0);
	}
	
	public static void placeNQueens(int n, int[][] board, int row){

		if(row==n){
			
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					System.out.print(board[i][j]+" ");
				}
			}
			System.out.println();
		}


		for(int j=0; j<n; j++){
			if(isItSafe(board, row, j )){
				board[row][j]=1;
				placeNQueens(n, board, row+1);
				board[row][j]=0;
			}
		}

	}

	public static boolean isItSafe(int[][] board, int row, int column){

		int n=board.length;

		for(int i=row-1; i>=0; i--){
			if(board[i][column]==1){
				return false;
			}
		}

		for(int i=row+1; i<n; i++){
			if(board[i][column]==1){
				return false;
			}
		}

		for(int j=column+1; j<n; j++){
			if(board[row][column]==1){
				return false;
			}
		}

		for(int j=column-1; j>=0; j--){
			if(board[row][j]==1){
				return false;
			}
		}

		for(int i=row-1, j=column-1; i>=0 && j>=0; i--, j--){
			
			if(board[i][j]==1){
				return false;
			}
		}

		for(int i=row+1, j=column+1; i<n && j<n; i++, j++){
			
			if(board[i][j]==1){
				return false;
			}
		}

		for(int i=row-1, j=column+1; i>=0 && j<n; i--, j++){

			if(board[i][j]==1){
				return false;
			}
		}

		for( int i=row+1, j=column-1; i<n && j>=0; i++, j--){

			if(board[i][j]==1){
				return false;
			}
		}

		return true;
	}
	
	public static void main(String[] args) {
		
		int n=5;
		placeNQueens(n);
	}
}
