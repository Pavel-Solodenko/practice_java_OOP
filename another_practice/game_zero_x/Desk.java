package game_zero_x;

public class Desk {
	private Figure[][] figures = new Figure[3][3];
	final private String vertical = "|";
	final private String horizontal = "-";
	public Desk() {
	}
	protected void printDeskClear() {
		for (int i = 0; i != 4;++i) {
			for (int j = 0; j != 9; ++j) {
				if (j % 3 ==0 && j >= 3) {
					System.out.print(vertical);
				}
				System.out.print(horizontal);
			}
			if (i != 3) {
				System.out.println("");
				for (int k = 0; k != 2;++k) {
					System.out.print("   " + vertical);
				}
				System.out.println();
			}
		}
		System.out.println("\n");
	}
	protected int checkGameOver() {
		int a = 0;
		for (int i = 0; i < figures.length;++i) {
			for (int j = 0; j < figures.length;++j) {
				if (figures[i][j] == null) {
						++a;
					}
				}
			}
		return a;
	}
	public void printDesk() {
		int a = checkGameOver();
		if (a == 9) {
			printDeskClear();
		}
		else {
			if (a == 0) {
			}
			else {
				printDeskWithFigures();
			}
		}
	}
	protected void printDeskWithFigures() {
		for (int i = 0; i != 4;++i) {
			for (int j = 0; j != 9; ++j) {
				if (j % 3 ==0 && j >= 3) {
					System.out.print(vertical);
				}
				System.out.print(horizontal);
			}
			if (i != 3) {
				System.out.println("");
				for (int k = 0; k != 3;++k) {
					if (figures[i][k] != null) {
						System.out.print(" "+figures[i][k].getZeroOrX()+" ");
						if (k != 2) {
							System.out.print("|");
						}
					}
					if (k != 2 && figures[i][k] == null) {
						System.out.print("   " + vertical);
					}
				}
				System.out.println();
			}
		}
		System.out.println("\n");
	}
	public boolean checkWinOrNo() {
		boolean end_game = false;
		if (comb0_0() == true) {
			System.out.println("\n"+"\n"+"Who play by " + figures[0][0].getZeroOrX()+" WIN THE GAME!");
			end_game = true;
		}
		if (comb0_1() == true) {
			System.out.println("\n"+"\n"+"Who play by " + figures[0][1].getZeroOrX()+" WIN THE GAME!");
			end_game = true;
		}
		if (comb0_2() == true) {
			System.out.println("\n"+"\n"+"Who play by " + figures[0][2].getZeroOrX()+" WIN THE GAME!");
			end_game = true;
		}
		if (comb1_0() == true) {
			System.out.println("\n"+"\n"+"Who play by " + figures[1][0].getZeroOrX()+" WIN THE GAME!");
			end_game = true;
		}
		if (comb2_0() == true) {
			System.out.println("\n"+"\n"+"Who play by " + figures[2][0].getZeroOrX()+" WIN THE GAME!");
			end_game = true;
		}
		return end_game;
	}
	public void addFigureToDesk(int x,int y,boolean type) {
		for (int i = 0; i < figures.length;++i) {
			for (int j = 0; j < figures.length;++j) {
				if (figures[i][j] == null && i == x && j == y) {
					figures[i][j] = new Figure(x,y,type);
				}
			}
		}
	}
	public void reloadDesk() {
		for (int i = 0; i < figures.length;++i) {
			for (int j = 0; j < figures.length;++j) {
				figures[i][j] = null;
			}
		}
	}
	public Figure getFigure(int x, int y) {
		return figures[x][y];
	}
	protected boolean comb0_0() {
		boolean win = false;
		if (figures[0][0] != null && figures[0][1] != null && figures[0][2] != null &&
			figures[0][0].getZeroOrX().equals(figures[0][1].getZeroOrX()) == true &&
			figures[0][2].getZeroOrX().equals(figures[0][1].getZeroOrX()) == true 
			) {
			win = true;
		}
		else {
			if (figures[0][0] != null && figures[1][0] != null && figures[2][0] != null &&
				figures[0][0].getZeroOrX().equals(figures[1][0].getZeroOrX()) == true &&
				figures[2][0].getZeroOrX().equals(figures[1][0].getZeroOrX()) == true 
				) {
					win = true;
				}
			else {
				if (figures[0][0] != null && figures[1][1] != null && figures[2][2] != null &&
					figures[0][0].getZeroOrX().equals(figures[1][1].getZeroOrX()) == true &&
					figures[2][2].getZeroOrX().equals(figures[1][1].getZeroOrX()) == true 
						) {
						win = true;
					}
			}
		}
		return win;
	}
	protected boolean comb0_1() {
		boolean win = false;
		if (figures[0][1] != null && figures[1][1] != null && figures[2][1] != null &&
			figures[0][1].getZeroOrX().equals(figures[1][1].getZeroOrX()) == true &&
			figures[2][1].getZeroOrX().equals(figures[1][1].getZeroOrX()) == true 
			) {
				win = true;
			}
		return win;
	}
	protected boolean comb0_2() {
		boolean win = false;
		if (figures[0][2] != null && figures[1][1] != null && figures[2][0] != null &&
			figures[0][2].getZeroOrX().equals(figures[1][1].getZeroOrX()) == true &&
			figures[2][0].getZeroOrX().equals(figures[1][1].getZeroOrX())== true 
			) {
				win = true;
			}
		if (figures[0][2] != null && figures[1][2] != null && figures[2][2] != null &&
			figures[0][2].getZeroOrX().equals(figures[1][2].getZeroOrX()) == true &&
			figures[2][2].getZeroOrX().equals(figures[1][2].getZeroOrX()) == true 
				) {
				win = true;
			}
		return win;
	}
	protected boolean comb1_0() {
		boolean win = false;
		if (figures[1][0] != null && figures[1][1] != null && figures[1][2] != null &&
			figures[1][0].getZeroOrX().equals(figures[1][1].getZeroOrX()) == true &&
			figures[1][2].getZeroOrX().equals(figures[1][1].getZeroOrX()) == true 
			) {
				win = true;
			}
		return win;
	}
	protected boolean comb2_0() {
		boolean win = false;
		if (figures[2][0] != null && figures[2][1] != null && figures[2][2] != null &&
			figures[2][0].getZeroOrX().equals(figures[2][1].getZeroOrX()) == true &&
			figures[2][2].getZeroOrX().equals(figures[2][1].getZeroOrX()) == true 
				) {
				win = true;
			}
		return win;
	}
	public Figure[][] getFigures() {
		return figures;
	}
}