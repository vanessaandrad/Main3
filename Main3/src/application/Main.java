package application;

import java.util.Random;
import java.util.Scanner;

import entities.PlanoCartesiano;
import entities.Robo;
import entities.RoboInteligente;
import entities.Tela;

public class Main {

	public static void main(String[] args) {
		String ANSI_RESET = "\u001B[0m";
		String ANSI_GREEN = "\u001B[32m";
		
		Random random = new Random();
		Tela tela = new Tela();
		PlanoCartesiano plano = new PlanoCartesiano();
		Scanner scan = new Scanner(System.in);
		
		tela.printTela();
		System.out.print("Digite a cor do robô normal: ");
		String cor1 = scan.nextLine();
		Robo roboNormal = new Robo(0, 0, cor1);
		System.out.print("Digite a cor do robô inteligente: ");
		String cor2 = scan.nextLine();
		RoboInteligente roboInteligente = new RoboInteligente(0, 0, cor2);
		
		System.out.println();
		System.out.println("Digite a posição do alimento:");
		System.out.print("X: ");
		int xAlimento = scan.nextInt();
		System.out.print("Y: ");
		int yAlimento = scan.nextInt();
		scan.nextLine();
		int tamanho = 5;
		System.out.println();
		System.out.println("Os dois robôs iniciam na posição (0,0)!");
		plano.imprimirPlanoCartesianoInicial(tamanho, roboNormal.getX(), roboNormal.getY(), roboInteligente.getX(), roboInteligente.getY(), xAlimento, yAlimento, cor1, cor2);

		while (!(xAlimento == roboNormal.getX() && yAlimento == roboNormal.getY())
				|| !(xAlimento == roboInteligente.getX() && yAlimento == roboInteligente.getY())) {

			if(roboNormal.verificarPosicao(roboNormal.getX(), roboNormal.getY(), xAlimento, yAlimento) == false) {
				System.out.print("Jogada do robô normal: ");
				int movimentoRoboNormal = random.nextInt(4) + 1;
				roboNormal.informarDirecao(movimentoRoboNormal);
				roboNormal.moverRobo(movimentoRoboNormal);
				tela.mostrarTransicao(1000);
				System.out.println();
			
				if (roboNormal.verificarPosicao(roboNormal.getX(), roboNormal.getY(), xAlimento, yAlimento) == true) {
					plano.imprimirPlanoCartesiano(tamanho, roboNormal.getX(), roboNormal.getY(), roboInteligente.getX(), roboInteligente.getY(), xAlimento, yAlimento, cor1, cor2);
					System.out.println(ANSI_GREEN+"Alimento encontrado pelo robô normal!"+ANSI_RESET);
					System.out.printf(
						"O robô normal encontrou o alimento em %d movimentos válidos e %d movimentos inválidos",
						roboNormal.getContadorMovimentosValidosRobo(), roboNormal.getContadorMovimentosInvalidosRobo());
					System.out.println();
					System.out.println();
				}
			}
			
			if(roboInteligente.verificarPosicao(roboInteligente.getX(), roboInteligente.getY(), xAlimento, yAlimento) == false) {
				while (true) {
					System.out.print("Jogada do robô inteligente: ");
					int movimentoRoboInteligente = random.nextInt(4) + 1;
					roboInteligente.informarDirecao(movimentoRoboInteligente);
					roboInteligente.moverRobo(movimentoRoboInteligente);
					tela.mostrarTransicao(1000);
					System.out.println();

					if (roboInteligente.verificarPosicao(roboInteligente.getX(), roboInteligente.getY(), xAlimento, yAlimento) == true) {
					plano.imprimirPlanoCartesiano(tamanho, roboNormal.getX(), roboNormal.getY(), roboInteligente.getX(), roboInteligente.getY(), xAlimento, yAlimento, cor1, cor2);
					System.out.println(ANSI_GREEN+"Alimento encontrado pelo robô inteligente!"+ANSI_RESET);
					System.out.printf("O robô inteligente encontrou o alimento em %d movimentos válidos e %d movimentos inválidos", roboInteligente.getContadorMovimentosValidosRobo(), roboInteligente.getContadorMovimentosInvalidosRobo());
					System.out.println();
					System.out.println();
					}
					if (roboInteligente.getControle() == 1) {
					break;
					}
				}
			}
		}
		scan.close();
	}
}