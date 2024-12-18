package TicTacPack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TicTacApp {
	
	static String[] board = new String[9];
	static Set<List<Integer>> wins = new HashSet<>();
	static int turnCount = 0;
	
	public static void main(String[] args) {
		//Logic Setup
		createWinCombos();
		fillBoard();
		
		//User Setup
		welcomeMessage();
		while(true) {
			visualizeBoard();
			nextTurn(); //Start with X turn
			
			if (turnCount >= 5) {
				String whoWon = checkForWin();
				if (!whoWon.equals(" ")) {
					displayWin(whoWon);
					break;
				}
			}
			if (turnCount == 9) {
				displayDraw();
				break;
			}
		}
	}

	
	public static void welcomeMessage() {
		System.out.println("-------------------------------------------");
		System.out.println("   Welcome to Tic-Tac-Toe!");
		System.out.println("        X goes first!");
		System.out.println("-------------------------------------------");
	}
	public static void visualizeBoard() {
		System.out.println("+---+---+---+" 											 	+ "   +---+---+---+");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |" + "   | 1 | 2 | 3 |");
		System.out.println("+---+---+---+" 											 	+ "   +---+---+---+");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |" + "   | 4 | 5 | 6 |");
		System.out.println("+---+---+---+" 											 	+ "   +---+---+---+");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |" + "   | 7 | 8 | 9 |");
		System.out.println("+---+---+---+" 											 	+ "   +---+---+---+");
	}
	public static void displayWin(String whoWon) {
		System.out.println();
		System.out.println("-------------------------");
		System.out.println("         " + whoWon +" WINS");
		System.out.println("-------------------------");
		visualizeBoard();
	}
	public static void displayDraw() {
		System.out.println();
		System.out.println("-------------------------");
		System.out.println("          DRAW!");
		System.out.println("-------------------------");
		visualizeBoard();
	}
	
	public static void nextTurn() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number for ");
		
		String whosTurn;
		if (turnCount % 2 == 0) {
			whosTurn = "X";
		} else {
			whosTurn = "O";
		}
		System.out.println(whosTurn);
		
		//Gets and checks input
		String input = scan.nextLine();
		int correctInput = isCorrectInput(input);
		
		if (correctInput != -1) {
			//Sets X or O in correct number space
			board[correctInput] = whosTurn;
			turnCount++;
		} else {
			System.out.println("Invalid input. Enter a number 1 - 9");
			nextTurn();
			return;
		}
		System.out.println("End of Turn");
	}
	
	public static int isCorrectInput(String input) {
		for(int i = 0; i < 9; i++) {
			if(input.equals(Integer.toString(i + 1))) {
				return i;
			}
		}
		return -1;
	}
	
	public static void fillBoard() {
		for (int i = 0; i < board.length; i++) {
			board[i] = " ";
		}
	}
	
	//Compares each list of combinations with the the board and checks for a win
	public static String checkForWin() {
		//iterate through winning combinations, check if board contains same value for all 3 positions in that combination
		for (List<Integer> combo : wins) {
			String one = board[combo.get(0)];
			String two = board[combo.get(1)];
			String three = board[combo.get(2)];
			
			if (one.equals("X") && two.equals("X") && three.equals("X")) {
				return "X";
			} else if (one.equals("O") && two.equals("O") && three.equals("O")) {
				return "O";
			}
		}
		System.out.println("No win yet.");
		return " ";
	}
	
	//adds each list of combination to a set  
	public static void addWin(int one, int two, int three) {
		List<Integer> win = new ArrayList<Integer>();
		win.add(one);
		win.add(two);
		win.add(three);
		
		wins.add(win);
	}
	
	//adds all possible win combinations to game
	public static void createWinCombos() {
		addWin(0,1,2);
		addWin(3,4,5);
		addWin(6,7,8);
		addWin(0,3,6);
		addWin(1,4,7);
		addWin(2,5,8);
		addWin(0,4,8);
		addWin(2,4,6);
	}
		
}
