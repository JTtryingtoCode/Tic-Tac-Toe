import java.util.Scanner;
import java.util.Random;
public class TicTacToe {

	static char [][] gameBoard = {{'1','2','3'}, {'4','5','6'}, {'7','8','9'}};
  static String player = "1";
	static Scanner input = new Scanner(System.in);
  static boolean gameOver=false;
  static int player1incorrect=0;
  static int player2incorrect=0;
	static int mode;

	public static void main (String[] args) {


		System.out.println("Lets play Tic Tac Toe!");
		System.out.println("Enter 1 for 2 players mode or enter 2 for playing against the CPU or enter 0 to quit.");
		mode=input.nextInt();

		if (mode==1){
			printBoard();
			while((!isWinningPattern() && !isFull()) && !gameOver){

				playerMove();
				changePlayer();
			}

			if(isWinningPattern()){
				changePlayer();
				System.out.println("Game Over! Player "+player+ " Wins");
			}}
		if(mode==0){
				System.out.println("Game Over!");
		}
		if(mode==2){
			printBoard();
			playerMove();
			while((!isWinningPattern() && !isFull()) && !gameOver){
				computerMove();
				if(isWinningPattern())
					break;
				changePlayer();
				playerMove();
			}
			if(isWinningPattern()){
				System.out.println("Game Over! Player "+player+ " Wins");
		}
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

		if(player.equals("1")) {
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
    int incorrectinrow=0;
		while(!result) {
			if(isValidMove(move)){
					 result = isValidMove(move);
					 break;}
			incorrectinrow++;
			if (player.equals("1")){
				player1incorrect++;
			}
			else{
				player2incorrect++;
			}
			if (incorrectinrow==3 || player1incorrect==5 || player2incorrect==5){
				gameOver=true;
				break;}
				System.out.println("Incorrect entry, please try again");
				move = input.nextInt();
}

    if(gameOver==true){

      System.out.println("Player "+player+ " forfeit the game due to reaching maximum incorrect entries.");
    }
    else if(move == 0){
      gameOver=true;
			changePlayer();
      System.out.println("Game Over! Player "+player+ " Wins");
    }
    else{
      updateBoard(move);

    }
	}
	public static void computerMove() {
		int count=0;
		int empty=0;

		boolean found=false;
		int move=0;
		for(int i =0; i<3; i++){
			for(int j =0; j<3; j++){
				if(gameBoard[i][j]=='O'){
					count++;
				}
				if((gameBoard[i][j]!='O')&&(gameBoard[i][j]!='X')){
					empty++;
					move = (int)(gameBoard[i][j]-'0');
				}
			}
		if(count==2 && empty==1){
			found=true;
			break;
			}
		else{
			count=0;
			empty=0;
		}
		}
		if(!found){
			for(int i =0; i<3; i++){
			for(int j =0; j<3; j++){
				if(gameBoard[j][i]=='O'){
					count++;
				}
				if((gameBoard[j][i]!='O')&&(gameBoard[j][i]!='X')){
					empty++;
					move = (int)(gameBoard[j][i]-'0');
				}
			}
		if(count==2 && empty==1){
			found=true;
			break;
			}
		else{
			count=0;
			empty=0;
		}
		}}
		if(!found){
			for(int i =0; i<3; i++){
				if(gameBoard[i][i]=='O'){
					count++;
				}
				if((gameBoard[i][i]!='O')&&(gameBoard[i][i]!='X')){
					empty++;
					move = (int)(gameBoard[i][i]-'0');
				}
			}
		if(count==2 && empty==1){
			found=true;
			}
		else{
			count=0;
			empty=0;
		}
			}
			if(!found){
				for(int i =0,j =2;i<3; i++){
					if(gameBoard[i][j]=='O'){
						count++;
					}
					if((gameBoard[i][j]!='O')&&(gameBoard[i][j]!='X')){
						empty++;
						move = (int)(gameBoard[i][j]-'0');
					}
					j--;
				}
			if(count==2 && empty==1){
				found=true;
				}

			}
		if(!found){
			Random rand = new Random();
			move = rand.nextInt(9)+1;

			boolean result = isValidMove(move);

			while(!result){
					move = rand.nextInt(9)+1;
					result = isValidMove(move);
			}
		}
			System.out.println("Computer moved at position "+ move);
			changePlayer();
			updateBoard(move);
	}

	public static boolean isValidMove(int move) {

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
	switch(mode){
	case 1:
				if (player.equals("1")) {
						player = "2";
				}
				else {
						player = "1";
				}
				break;
	case 2:
		if (player.equals("1")) {
			player = "CPU";
			}
		else {
			player = "1";
		}
		break;
}
}}

