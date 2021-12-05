import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
	
	static char [][] gameBoard = {{'1','2','3'}, {'4','5','6'}, {'7','8','9'}};
	static int player = 1;
	static int computer = 2;
	static Scanner input = new Scanner(System.in);
	static boolean gameOver=false;
	static int player1incorrect=0;
	static int player2incorrect=0;
	
	public static void main (String[] args) {
		System.out.println("Lets play Tic Tac Toe!");
		
		System.out.println("Enter 1 for 2 players mode or enter 2 for playing against the CPU or enter 0 to quit.");
		
		printBoard();
		
		while((!isWinningPattern() && !isFull()) && !gameOver) {
			playerMove();
			}
		
		if(isWinningPattern()){
			changePlayer();
			System.out.println("Game Over! Player "+player+ " Wins");
			}
		}
	public static void printBoard(){
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
	public static void updateBoard(int position, int i, char[][] gameBoard2) {
		char character;

		if(player==1) {
			character = 'X';
		
		}else{
			character = 'O';
		}
		
		switch (position) {
			case 1:
				gameBoard[0][0] = character;
				printBoard();
				break;
			case 2:
				gameBoard[0][1] = character;
				printBoard();
				break;
			case 3:
				gameBoard[0][2] = character;
				printBoard();
				break;
			case 4:
				gameBoard[1][0] = character;
				printBoard();
				break;
			case 5:
				gameBoard[1][1] = character;
				printBoard();
				break;
			case 6:
				gameBoard[1][2] = character;
				printBoard();
				break;
			case 7:
				gameBoard[2][0] = character;
				printBoard();
				break;
			case 8:
				gameBoard[2][1] = character;
				printBoard();
				break;
			case 9:
				gameBoard[2][2] = character;
				printBoard();
				break;
			default:
				break;

		}

	}
	
	public static void playerMove() {

		System.out.println("Player "+player+ " turn: ");

		int move = input.nextInt();

		boolean result = isValidMove(move, gameBoard);
		int incorrectinrow=1;
		while(!result) {
			System.out.println("Incorrect entry, please try again");
			move = input.nextInt();
			if(isValidMove(move, gameBoard)) {
			     result = isValidMove(move, gameBoard);
			     break;
			}
			incorrectinrow++;
			if (player==1) {
				player1incorrect++;
				}
			else{
				player2incorrect++;
				}
			if (incorrectinrow==3 || player1incorrect==4 || player2incorrect==4) {
				gameOver=true;
				break;
				}
			}
		if(gameOver==true) {
			System.out.println("Player "+player+ " forfeit the game due to reaching maximum incorrect entries.");
			}
		else if(move == 0) {
			gameOver=true;
			changePlayer();
			System.out.println("Game Over! Player "+player+ " Wins");
			}
		else{
			updateBoard(move, incorrectinrow, gameBoard);
			changePlayer();
			}
		}
	
	
	public static void computerMove(char [][] gameBoard) {

	    Random rand = new Random();
	    int move = rand.nextInt(9)+1;

	    boolean result = isValidMove(move, gameBoard);

	    while(!result){
	        move = rand.nextInt(9)+1;
	        result = isValidMove(move, gameBoard);
	    }

	    System.out.println("Computer moved at position "+ move);
	    updateBoard(move,2,gameBoard);
	}
	
	
	public static boolean isValidMove(int move, char[][] gameboard) {
		switch (move) {
		case 0:
			return true;
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
			if(gameBoard[2][0] == '7') {
				return true;
			}else{
				return false;
				}
		case 8:
			if(gameBoard[2][1] == '8') {
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
	
	public static boolean isWinningPattern() {
		for(int i=0;i<3;i++){
			if ((gameBoard[i][0]==gameBoard[i][1]) &&(gameBoard[i][1]==gameBoard[i][2]))
				return true;
			if((gameBoard[0][i]==gameBoard[1][i]) &&(gameBoard[1][i]==gameBoard[2][i]))
				return true;
			}
		if ((gameBoard[0][0]==gameBoard[1][1]) &&(gameBoard[1][1]==gameBoard[2][2]))
			return true;
		if ((gameBoard[0][2]==gameBoard[1][1]) &&(gameBoard[1][1]==gameBoard[2][0]))
			return true;
		return false;
		}
	
	public static boolean isFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if ((gameBoard[i][j] <='9') && (gameBoard[i][j] >='1')) {
					return false;
					}
				}
			}
		System.out.println("Game Over! It is tie");
		return true;
		}
	public static void changePlayer() {
		if (player == 1) {
			player = 2;
			}
		else {
			player = 1;
			}
	}
}
