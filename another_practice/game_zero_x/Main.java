package game_zero_x;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Desk desk = new Desk();
		boolean player_figure = prepereGame(sc);
		boolean machine_figure = !player_figure;
		stepByStep(player_figure,machine_figure,sc,desk);		
	}
	static void stepByStep(boolean player_figure,boolean machine_figure,Scanner sc,Desk desk) {
		boolean end_game = false;
		//if firs player = true, machine = false
		boolean who_step_first;
		desk.printDesk();
		if (player_figure == false) {
			stepFull(player_figure,sc,desk,false);
			who_step_first = true;
		}
		else {
			stepFull(machine_figure,sc,desk,true); 
			who_step_first = false;
		}
		desk.printDesk();
		while (end_game != true) {
			if (who_step_first == true) {
				stepFull(machine_figure,sc,desk,true);
				desk.printDesk();
				if (desk.checkWinOrNo() == true) {
					break;
				}
				stepFull(player_figure,sc,desk,false);
				desk.printDesk();
				if (desk.checkWinOrNo() == true) {
					break;
				}
			}
			else {
				stepFull(player_figure,sc,desk,false);
				desk.printDesk();
				if (desk.checkWinOrNo() == true) {
					break;
				}
				stepFull(machine_figure,sc,desk,true);
				desk.printDesk();
				if (desk.checkWinOrNo() == true) {
					break;
				}
			}
			if (desk.checkGameOver() == 0) {
				System.out.println("GAME OVER!");
				break;
			}
		}
	}
	static boolean prepereGame(Scanner sc) {
		boolean x_or_zero = false,a = false;
		System.out.println("Enter yuor figure - X or O");
		while (a != true) {
			String text = sc.nextLine();
			if (text.equals("X") == true) {
				x_or_zero = false;
				break;
			}
			else {
				if (text.equals("O") == true) {
					x_or_zero = true;
					break;
				}
			}
			System.out.println("Incorrect input! Try again");
		}
		return x_or_zero;
	}
	static int[] step(Scanner sc, boolean wrong,boolean machine) {
		int[] x_y = new int[2];
		boolean a = false,c=false,b=false;
		if (machine == false) {
			if (wrong == false) {
				System.out.println("Enter x,y cordinats yours step" + "\n" + "(Coordinates begin on 0,0 to 2,2");
			}
			else {
				System.out.println("Figure already is on this coordinates!"+"\n"+"Try again");
			}
		}
		while(a != true) {
			if (machine == false) {
				x_y[0] = sc.nextInt();
				x_y[1] = sc.nextInt();
			}
			else {
				x_y[0] = (int) (Math.random() * 3.1);
				x_y[1] = (int) (Math.random() * 3.1);
			}
			if(x_y[0] < 3 && x_y[0] > -1) {
				b = true;
			}
			if (x_y[1] < 3 && x_y[1] > -1) {
				c = true;
			}
			if (b == true && c == true) {
				break;
			}
			else {
				c = false;
				b = false;
			}
			if (machine == false) {
				System.out.println("Incorrect input!  Try again");
			}
		}
		return x_y;
	}
	static boolean check_already_is(Figure[][] figures,int x,int y) {
		boolean check = false;
		for (int i = 0;i < figures.length;++i) {
			for (int j = 0;j < figures.length;++j) {
				if (figures[i][j] == null && x == i && j == y) {
					check = true;
					break;
				}
			}
		}
		return check;
	}
	static void stepFull(boolean what_figure,Scanner sc,Desk desk,boolean machine) {
		int[] x_y = step(sc,false,machine);
		boolean a = false;
		boolean check_already_is;
		while (a != true) {
			check_already_is = check_already_is(desk.getFigures(),x_y[0],x_y[1]);
			if (check_already_is == true) {
				desk.addFigureToDesk(x_y[0], x_y[1], what_figure);
				break;
			}
			else {
				int[] b = step(sc,true,machine);
				x_y[0] = b[0];
				x_y[1] = b[1];
			}
		}
	}
	static void stepMachine(boolean what_figure,Desk desk,Scanner sc) {
		boolean machine = true;
		stepFull(what_figure,sc,desk,machine);
	}
}
