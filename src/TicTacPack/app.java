package TicTacPack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class app {
	
	static Set<List<Integer>> wins = new HashSet<>();

	public static void main(String[] args) {
		//make board using map
		//make win map
		
		Map<Integer,Character> board = new HashMap<Integer,Character>();
				
		for(int i = 1 ; i <= 9; i++) {
			board.put(i, null);
		}
		
		System.out.println(board.toString());
	
		// 1 2 3
		// 4 5 6
		// 7 8 9
		
		//win 1 = 123
		//win 2 = 456
		//win 3 = 789
		//win 4 = 147
		//win 5 = 258
		//win 6 = 369
		//win 7 - 159
		//win 8 = 357
	
		addWin(1,2,3);
		addWin(4,5,6);
		addWin(7,8,9);
		addWin(1,4,7);
		addWin(2,5,8);
		addWin(3,6,9);
		addWin(1,5,9);
		addWin(3,5,7);
		
		System.out.println(wins);
	}
	
	private static void addWin(int one, int two, int three) {
		List<Integer> win = new ArrayList<Integer>();
		win.add(one);
		win.add(two);
		win.add(three);
		
		wins.add(win);
	}
	
	
}
