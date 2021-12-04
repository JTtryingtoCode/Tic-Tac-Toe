import java.util.Scanner;

public class TicTacToe {

	static char [][] gameBoard = {{'1','2','3'}, {'4','5','6'}, {'7','8','9'}};
  static int player = 1;
	static Scanner input = new Scanner(System.in);

	public static void main (String[] args) {


		System.out.println("Lets play Tic Tac Toe!");
    printBoard();
    while(!isWinningPattern() && !isFull()){
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

	public static void updateBoard(int position) {

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

		boolean result = isValidMove(move);

		while(!result) {
			System.out.println("Invalid move. Try again");
			move = input.nextInt();
			result = isValidMove(move);

		}

		updateBoard(move);
    changePlayer();

	}

	public static boolean isValidMove(int move) {

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
