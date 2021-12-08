/Added CPU assist for mode1(two players)
import java.util.Scanner;
import java.util.Random;
public class TicTacToe {
	static char [][] gameBoard = {{'1','2','3'}, {'4','5','6'}, {'7','8','9'}};
	static String player = "Player 1";
	static Scanner input = new Scanner(System.in);
	static boolean gameOver=false;
	static int player1incorrect=0;
	static int player2incorrect=0;
	static String mode;
	static int modeNum;
	static int help1=0;
	static int help2=0;
	public static void main (String[] args) {
		System.out.println("Lets play Tic Tac Toe!");
		System.out.println("Enter 1 for 2 players mode or enter 2 for playing against the CPU or enter 0 to quit.");
		mode=input.nextLine();
		//handles invalid inputs for mode
		while((isValid(mode) == false)||mode.equals("000")) {
			System.out.println("Enter 1 for 2 players mode or enter 2 for playing against the CPU or enter 0 to quit.");
			mode = input.nextLine();
		}

		modeNum  = Integer.parseInt(mode);

//mode1-two players
		if (modeNum==1){
			printBoard();
			do{
				playerMove();
				changePlayer();
			}while((!isWinningPattern() && !isFull()) && !gameOver);
			//displays winning message
			if(isWinningPattern()){
				changePlayer();
				System.out.println("Game Over! "+player+ " Wins");
				}
			}
			//exit
		if(modeNum==0){
				System.out.println("Game Over!");
		}
		//mode2-against CPU
		if(modeNum==2){
			printBoard();
			do{
			playerMove();
			if(isWinningPattern()||gameOver||isFull()){
				break;}
			changePlayer();
			computerMove();
			if(isWinningPattern()){
				break;}
			changePlayer();}
			while((!isWinningPattern() && !isFull()) && !gameOver);
			//displays winning message
			if(isWinningPattern()){
				System.out.println("Game Over! "+player+ " Wins");
				}
		}
		}

//hadles invalid non-int and not "000" inputs for mode and moves
	public static boolean isValid(String s) {
		if(s.length() == 1 && Character.isDigit(s.charAt(0))||s.equals("000"))
			return true;
		else {
			return false;
		}

	}
//prints board
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
//updates board
	public static void updateBoard(int position) {

		char character;

		if(player.equals("Player 1")) {
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
//human player
	public static void playerMove() {

		System.out.println(player+ " turn: ");

		String moveS = input.nextLine();
//validation, counts incorrect moves
		boolean result = isValidMove(moveS);
		int incorrectinrow=0;
		while(!result) {
			if(isValidMove(moveS)){
					 result = isValidMove(moveS);
					 break;}
			incorrectinrow++;
			if (player.equals("Player 1")){
				player1incorrect++;
			}
			else{
				player2incorrect++;
			}
			if (incorrectinrow==3 || player1incorrect==5 || player2incorrect==5){
				gameOver=true;
				break;}
				System.out.println("Incorrect entry, please try again");
				moveS = input.nextLine();
				}
//game over due to incorrect inputs, displays message
    if(gameOver==true){

      System.out.println(player+ " forfeit the game due to reaching maximum incorrect entries.");
    }
		//CPU assist
		else if(moveS.equals("000")&&modeNum==1){
			if(player.equals("Player 1")&&(help1<2)){
				help1++;
				computerMove();}
			else if(player.equals("Player 2")&&(help2<2)){
				help2++;
				computerMove();}
			else{
				System.out.println(player+" reaches max CPU assists, please try again");
				changePlayer();
			}
		}
		//0 for quit
    else if(Integer.parseInt(moveS) == 0){
      gameOver=true;
			changePlayer();
      System.out.println("Game Over! "+player+ " Wins");
    }
    else{
			//displays the move
			int move=Integer.parseInt(moveS);
      updateBoard(move);

    }
	}
	//computer move
	public static void computerMove() {
		char ch1;
		char ch2;
		int count=0;
		int empty=0;

		boolean found=false;
		int move=0;
	if(modeNum==2){
		ch1='O';
		ch2='X';
	}
	//cpu assist part
	else if(player.equals("Player 1")){
		ch1='X';
		ch2='O';
	}
	else{
		ch1='O';
		ch2='X';
	}
	//checks if there is a winning move
		//winning row
		for(int i =0; i<3; i++){
			for(int j =0; j<3; j++){
				if(gameBoard[i][j]==ch1){
					count++;
				}
				if((gameBoard[i][j]!=ch1)&&(gameBoard[i][j]!=ch2)){
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
		//winning column
		if(!found){
			for(int i =0; i<3; i++){
			for(int j =0; j<3; j++){
				if(gameBoard[j][i]==ch1){
					count++;
				}
				if((gameBoard[j][i]!=ch1)&&(gameBoard[j][i]!=ch2)){
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
		//winning diagonal1
		if(!found){
			for(int i =0; i<3; i++){
				if(gameBoard[i][i]==ch1){
					count++;
				}
				if((gameBoard[i][i]!=ch1)&&(gameBoard[i][i]!=ch2)){
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
			//winning diagonal2
			if(!found){
				for(int i =0,j =2;i<3; i++){
					if(gameBoard[i][j]==ch1){
						count++;
					}
					if((gameBoard[i][j]!=ch1)&&(gameBoard[i][j]!=ch2)){
						empty++;
						move = (int)(gameBoard[i][j]-'0');
					}
					j--;
				}
			if(count==2 && empty==1){
				found=true;
				}
				else{
					count=0;
					empty=0;
				}
			}
			//checks if there is a cell to block opponent's winning move
				//block row
				if(!found){
				for(int i =0; i<3; i++){
					for(int j =0; j<3; j++){
						if(gameBoard[i][j]==ch2){
							count++;
						}
						if((gameBoard[i][j]!=ch2)&&(gameBoard[i][j]!=ch1)){
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
			}}
				//block column
				if(!found){
					for(int i =0; i<3; i++){
					for(int j =0; j<3; j++){
						if(gameBoard[j][i]==ch2){
							count++;
						}
						if((gameBoard[j][i]!=ch2)&&(gameBoard[j][i]!=ch1)){
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
				//block diagonal1
				if(!found){
					for(int i =0; i<3; i++){
						if(gameBoard[i][i]==ch2){
							count++;
						}
						if((gameBoard[i][i]!=ch2)&&(gameBoard[i][i]!=ch1)){
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
					//block diagonal2
					if(!found){
						for(int i =0,j =2;i<3; i++){
							if(gameBoard[i][j]==ch2){
								count++;
							}
							if((gameBoard[i][j]!=ch2)&&(gameBoard[i][j]!=ch1)){
								empty++;
								move = (int)(gameBoard[i][j]-'0');
							}
							j--;
						}
					if(count==2 && empty==1){
						found=true;
						}
						else{
							count=0;
							empty=0;
						}
					}
			//random move there is no winning or block move
		if(!found){
			Random rand = new Random();
			move = rand.nextInt(9)+1;
			String moveS=String.valueOf(move);
			boolean result = isValidMove(moveS);

			while(!result){
					move = rand.nextInt(9)+1;
					moveS=String.valueOf(move);
					result = isValidMove(moveS);
			}
		}
			System.out.println("Computer moved at position "+ move);
			updateBoard(move);
	}
//validation of input for the move
	public static boolean isValidMove(String moveS) {

		if((modeNum==2)&&moveS.equals("000"))
			return false;
		//int input validation
		if(isValid(moveS)){
			int move=Integer.parseInt(moveS);
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
		//non int input validation
		else{
			return false;
		}
		}
//looks for winning pattern
public static boolean isWinningPattern() {
  for(int i=0;i<3;i++){
		//rows
    if ((gameBoard[i][0]==gameBoard[i][1]) &&(gameBoard[i][1]==gameBoard[i][2]))
      return true;
			//columns
    if((gameBoard[0][i]==gameBoard[1][i]) &&(gameBoard[1][i]==gameBoard[2][i]))
      return true;
  }
	//diagonal1
  if ((gameBoard[0][0]==gameBoard[1][1]) &&(gameBoard[1][1]==gameBoard[2][2]))
    return true;
		//diagonal2
  if ((gameBoard[0][2]==gameBoard[1][1]) &&(gameBoard[1][1]==gameBoard[2][0]))
    return true;
  return false;
}
//checks if full and displays tie message
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
//changes current player
public static void changePlayer() {
	switch(modeNum){
		//mode1
	case 1:
				if (player.equals("Player 1")) {
						player = "Player 2";
				}
				else {
						player = "Player 1";
				}
				break;
				//mode2
	case 2:
		if (player.equals("Player 1")) {
			player = "CPU";
			}
		else {
			player = "Player 1";
		}
		break;
		}
	}
}
