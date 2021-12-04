import java.util.Scanner;

public class TicTacToe {

	static int playerScore = 0;
	static Scanner input = new Scanner(System.in);
	
	public static void main (String[] args) {
		char [][] gameBoard = {{'1','2','3'}, {'4','5','6'}, {'7','8','9'}};

		System.out.println("Lets play Tic Tac Toe!");

		printBoard(gameBoard);
		

		boolean gameOver = false;
		boolean playAgain = true;

	}

		

	public static void printBoard(char[][]gameboard){
               for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

            	System.out.print(" "+gameBoard[i][j]);
              if (j==2)
                break;
                System.out.print(" |");
            }
            System.out.println();
            if (i==2)
              break;
            System.out.println("---+---+---");
        }
    }

	public static void updateBoard(int position, int player, char[][] gameBoard) {
		
		char character;

		if(player==1) {
			character = 'X';
		}else{
			character = 'O';
		}

		switch (position) {
			case 1:
				gameBoard[0][0] = character;
				printBoard(gameBoard);
				break;
			case 2:
				gameBoard[0][1] = character;
				printBoard(gameBoard);
				break;
			case 3:
				gameBoard[0][2] = character;
				printBoard(gameBoard);
				break;
			case 4:
				gameBoard[1][0] = character;
				printBoard(gameBoard);
				break;
			case 5:
				gameBoard[1][1] = character;
				printBoard(gameBoard);
				break;
			case 6:
				gameBoard[1][2] = character;
				printBoard(gameBoard);
				break;
			case 7:
				gameBoard[2][0] = character;
				printBoard(gameBoard);
				break;
			case 8:
				gameBoard[2][1] = character;
				printBoard(gameBoard);
				break;
			case 9:
				gameBoard[2][2] = character;
				printBoard(gameBoard);
				break;
			default:
				break;

		}

	}

	public static void playerMove(char[][] gameBoard) {

		System.out.println("Make a move. Choose spot (1-9)");

		int move = input.nextInt();

		boolean result = isValidMove(move,gameBoard);

		while(!result) {
			System.out.println("Invalid move. Try again");
			move = input.nextInt();
			result = isValidMove(move,gameBoard);

		}

		System.out.println("Player moved at position " + move);
		updateBoard(move,1,gameBoard);

	}

	public static boolean isValidMove(int move, char[][] gameBoard) {

		switch (move) {
			case 1:
				if(gameBoard[0][0] == '1') {
					return true;
				}else{
					return false;
				}
			case 2:
				if(gameBoard[0][1] == '2') {
					return true;
				}else{
					return false;
				}
			case 3:
				if(gameBoard[0][2] == '3') {
					return true;
				}else{
					return false;
				}
			case 4:
				if(gameBoard[1][0] == '4') {
					return true;
				}else{
					return false;
				}
			case 5:
				if(gameBoard[1][1] == '5') {
					return true;
				}else{
					return false;
				}
			case 6:
				if(gameBoard[1][2] == '6') {
					return true;
				}else{
					return false;
				}
			case 7:
				if(gameBoard[2][1] == '7') {
					return true;
				}else{
					return false;
				}
			case 8:
				if(gameBoard[2][2] == '8') {
					return true;
				}else{
					return false;
				}
			case 9:
				if(gameBoard[2][2] == '9') {
					return true;
				}else{
					return false;
				}

				default:
					return false;

			}

		}
		

	public static void resetBoard(char[][] gameBoard) {
 	   gameBoard[0][0] = '1';
 	   gameBoard[0][1] = '2';
 	   gameBoard[0][2] = '3';
 	   gameBoard[1][0] = '4';
 	   gameBoard[1][1] = '5';
 	   gameBoard[1][2] = '6';
 	   gameBoard[2][0] = '7';
 	   gameBoard[2][1] = '8';
 	   gameBoard[2][2] = '9';
 	}


}
