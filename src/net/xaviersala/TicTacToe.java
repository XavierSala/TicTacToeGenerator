package net.xaviersala;

import java.util.Random;

public class TicTacToe {

	Random aleatori = new Random(); 
	
	private static final int TRES = 3;
	private static final String[] FITXES = { "X", "O" };

	/**
	 * Genera un tauler de fitxes de mida 3x3.
	 * 
	 * @return tauler amb les fitxes generades
	 */
	public String[][] generar() {
					
		return generar(TRES, TRES);
	}
	

	/**
	 * Genera un tauler de tres en ratlla i l'emplena de fitxes
	 * @param files files del tauler
	 * @param columnes columnes del tauler
	 * @return tauler bidimensional amb les fitxes posades
	 */
	public String[][] generar(int files, int columnes) {
		String[][] tauler = new String[files][columnes];		
		
		int quantesTirades = aleatori.nextInt(files*columnes) + 1;
		
		int fitxaQueTira = 0;
		int fitxesPossibles = files*columnes;
		
		for(int i=0; i < quantesTirades; i++) {
			tauler = tira(tauler, fitxesPossibles, FITXES[fitxaQueTira]);
			fitxaQueTira = (fitxaQueTira + 1) % 2;
			fitxesPossibles--;
		}
				
		return senseNull(tauler);
	}

	private String[][] senseNull(String[][] tauler) {
		for(int fila=0; fila < tauler.length; fila++) {
			for(int columna=0; columna < tauler[fila].length; columna++) {
				if (tauler[fila][columna] == null) {
					tauler[fila][columna] = " ";
				}
			}
		}
		return tauler;
	}

	private String[][] tira(String[][] tauler, int fitxesPossibles, String fitxa) {
		
		if (fitxesPossibles == 0) return tauler;
		
		int tiraA = aleatori.nextInt(fitxesPossibles);
		
		int compta = 0;
		for(int fila = 0; fila < tauler.length; fila ++) {
			for(int columna = 0; columna < tauler[fila].length; columna++) {
				if (tauler[fila][columna] == null) {
					if (compta == tiraA) {
						tauler[fila][columna] = fitxa;
						return tauler;
					} else {
						compta++;
					}
				}
			}
		}
		
		return tauler;
		
	}
}
