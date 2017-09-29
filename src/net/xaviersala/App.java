package net.xaviersala;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		TicTacToe toe = new TicTacToe();
		
		String[][] tauler = toe.generar(4,4);
		
		// System.out.println(Arrays.deepToString(tauler));
		
		for(int i=0; i < tauler.length; i++) {
			System.out.println(Arrays.toString(tauler[i]));
		}

	}

}
