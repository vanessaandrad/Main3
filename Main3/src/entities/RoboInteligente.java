package entities;

import Exception.MovimentoInvalidoException;

public class RoboInteligente extends Robo {
	String ANSI_RESET = "\u001B[0m";
	String ANSI_RED = "\u001B[31m";
	String ANSI_GREEN = "\u001B[32m";
	
	public RoboInteligente(int x, int y, String cor) {
		super(x, y, cor);
	}

	protected int controle = 0;
	
	public int getControle() {
		return controle;
	}


	public void setControle(int controle) {
		this.controle = controle;
	}
	
	@Override
	public void moverRobo(String direcao) {
		if (direcao.equalsIgnoreCase("up")) {
			try {
				if (y == 4) {
					contadorMovimentosInvalidosRobo++;
					throw new MovimentoInvalidoException(ANSI_RED+"Movimento inválido: você já está na posição mais alta"+ANSI_RESET);
				} else {
					y++;
					contadorMovimentosValidosRobo++;
					controle = 1;
					System.out.print("Posição atual: ");
					System.out.println("(" + x + "," + y + ")");
				}
			} catch (MovimentoInvalidoException erro) {
				System.out.println(erro.getMessage());
			}
		} else if (direcao.equalsIgnoreCase("down")) {
			try {
				if (y == 0) {
					contadorMovimentosInvalidosRobo++;
					throw new MovimentoInvalidoException(ANSI_RED+"Movimento inválido: você já está na posição mais baixa!"+ANSI_RESET);
				} else {
					y--;
					contadorMovimentosValidosRobo++;
					controle = 1;
					System.out.print("Posição atual: ");
					System.out.println("(" + x + "," + y + ")");
				}
			} catch (MovimentoInvalidoException erro) {
				System.out.println(erro.getMessage());
			}
		} else if (direcao.equalsIgnoreCase("right")) {
			try {
				if (x == 4) {
					contadorMovimentosInvalidosRobo++;
					throw new MovimentoInvalidoException(ANSI_RED+"Movimento inválido: você já está na posição mais à direita!"+ANSI_RESET);
				} else {
					x++;
					contadorMovimentosValidosRobo++;
					controle = 1;
					System.out.print("Posição atual: ");
					System.out.println("(" + x + "," + y + ")");
				}
			} catch (MovimentoInvalidoException erro) {
				System.out.println(erro.getMessage());
			}
		} else if (direcao.equalsIgnoreCase("left")) {
			try {
				if (x == 0) {
					contadorMovimentosInvalidosRobo++;
					throw new MovimentoInvalidoException(ANSI_RED+"Movimento inválido: você já está na posição mais à esquerda!"+ANSI_RESET);
				} else {
					x--;
					contadorMovimentosValidosRobo++;
					controle = 1;
					System.out.print("Posição atual: ");
					System.out.println("(" + x + "," + y + ")");
				}
			} catch (MovimentoInvalidoException erro) {
				System.out.println(erro.getMessage());
			}
		} else {
			System.out.println(ANSI_RED+"Movimento inválido!"+ANSI_RESET);
		}
	}
	
	@Override
	public void moverRobo(int numero) {
		controle = 0;
		if (numero == 1) {
			try {
				if (y == 4) {
					contadorMovimentosInvalidosRobo++;
					throw new MovimentoInvalidoException(ANSI_RED+"Movimento inválido: você já está na posição mais alta!"+ANSI_RESET);
				} else {
					y++;
					contadorMovimentosValidosRobo++;
					controle = 1;
					System.out.print("Posição atual: ");
					System.out.println("(" + x + "," + y + ")");
				}
			} catch (MovimentoInvalidoException erro) {
				System.out.println(erro.getMessage());
			}
		} else if (numero == 2) {
			try {
				if (y == 0) {
					contadorMovimentosInvalidosRobo++;
					throw new MovimentoInvalidoException(ANSI_RED+"Movimento inválido: você já está na posição mais baixa!"+ANSI_RESET);
				} else {
					y--;
					contadorMovimentosValidosRobo++;
					controle = 1;
					System.out.print("Posição atual: ");
					System.out.println("(" + x + "," + y + ")");
				}
			} catch (MovimentoInvalidoException erro) {
				System.out.println(erro.getMessage());
			}
		} else if (numero == 3) {
			try {
				if (x == 4) {
					contadorMovimentosInvalidosRobo++;
					throw new MovimentoInvalidoException(ANSI_RED+"Movimento inválido: você já está na posição mais à direita!"+ANSI_RESET);
				} else {
					x++;
					contadorMovimentosValidosRobo++;
					controle = 1;
					System.out.print("Posição atual: ");
					System.out.println("(" + x + "," + y + ")");
				}
			} catch (MovimentoInvalidoException erro) {
				System.out.println(erro.getMessage());
			}
		} else if (numero == 4) {
			try {
				if (x == 0) {
					contadorMovimentosInvalidosRobo++;
					throw new MovimentoInvalidoException(ANSI_RED+"Movimento inválido: você já está na posição mais à esquerda!"+ANSI_RESET);
				} else {
					x--;
					contadorMovimentosValidosRobo++;
					controle = 1;
					System.out.print("Posição atual: ");
					System.out.println("(" + x + "," + y + ")");
				}
			} catch (MovimentoInvalidoException erro) {
				System.out.println(erro.getMessage());
			}
		} else {
			System.out.println(ANSI_RED+"Movimento inválido!"+ANSI_RESET);
			contadorMovimentosInvalidosRobo++;
		}
	}
}