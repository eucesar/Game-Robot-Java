package sprint2;

import java.util.Scanner;

public class JogoDoRoboSprint2 {

	  public static void main(String[] args) {
	        Scanner teclado = new Scanner(System.in);
	        reiniciarJogo(teclado);
	    }
	  
	   public static void reiniciarJogo(Scanner teclado) {
	   boolean jogarNovamente = true;
		   
		   while (jogarNovamente) {
	        String direcao;
	        int passos, quadrados;
	        int potenciaBateria = 2000;
	        boolean ganhou = false;
	        boolean loop = false;
	        
            //apresentação
            System.out.println("");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("------------------------------------------------------BEM-VINDO----------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("----------------------------------------JOGO: CHEGUE ATÉ O TROFEU COM SEU ROBÔ-------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("-----------------------------------------------------INSTRUÇÕES:---------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("------------------PARA ACERTAR QUAL O CAMINHO CORRETO ULTILIZE A IMAGEM (mapa.png) DENTRO DESSE ARQUIVO------------------------");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("----------CONTE A QUANTIDADE DE QUADRADOS E INFORME A DIREÇÃO E QUANTIDADE DE PASSOS PARA CHEGAR ATÉ O TROFEU------------------");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------VOCÊ TERÁ UMA POTENCIA DE BATERIA VALENDO 2000---------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("--------------------------------QUANDO A POTENCIA DA BATERIA CHEGAR A ZERAR VOCÊ PERDE-----------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("------QUANDO VOCÊ GANHA PERDE 10 DE POTENCIA | A CADA VEZ QUE ACERTA PERDE 10 DE POTENCIA| AO ERRAR PERDE 20 DE POTENCIA-------");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("-----------------------CADA 'ERRO' SÃO 20 PONTOS (COLOCAR LETRA NO LUGAR DO NUMERO - VICE-VERSA)-------------------------------");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("-----------------------------------A CADA QUADRADO ANDADO VOCÊ PERDE 10 DE POTENCIA--------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("-------> DIREÇÃO: 'FRENTE, TRAS, ESQUERDA, DIREITA'");
            System.out.println("-------> PASSOS: 'CONTE A QUANTIDADE DE QUADRADOS NA IMAGEM - A IMAGEM DO ROBÔ NÃO CONTA(PULE) - O QUADRADO DO TROFEU CONTA'");
            System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + potenciaBateria);

            	while (potenciaBateria > 0 && !ganhou) {
				boolean errou = false;
				
				//1°
				while(!loop) {
				System.out.println("");
				System.out.print("-------> Informe a direção: ");
				direcao = teclado.next();
				if (direcao.matches("[0-9]+")) {
					System.out.println("Erro: a direção deve ser uma palavra.");
					errou = true;
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					System.out.println("Voltando para o início do loop...");
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						jogarNovamente = true;
						loop = true;
						break;
					}
					continue;
					
				}
				
				System.out.print("-------> Informe a quantidade de passos: ");
				while (!teclado.hasNextInt()) {
					System.out.println("Erro: a quantidade de passos deve ser um número.");
					errou = true;
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					System.out.println("Voltando para o início do loop...");
					System.out.print("-------> Informe a quantidade de passos: ");
					teclado.next(); // Limpar o valor inválido do teclado
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						jogarNovamente = true;
						loop = true;
						break;
					}
					continue;
				}
				passos = teclado.nextInt();
				passos = passos * 10;
				potenciaBateria -= passos;
				

				direcao = direcao.toUpperCase();

				if (direcao.equals("DIREITA")) {
					System.out.println("ACERTOU A 1° DIREÇÃO");
					potenciaBateria -= 10;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					
				} else {
					System.out.println("ERROU A 1° DIREÇÃO");
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					errou = true; //
				}

				if (passos / 10 == 5) {
					System.out.println("ACERTOU O 1° PASSO");
					potenciaBateria -= 10;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						break;
					}
					break;
				} else {
					System.out.println("ERROU O 1° PASSO");
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					errou = true;
				}
				if (errou) { //
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						jogarNovamente = true;
						loop = true;
						break;
					} else {
						System.out.println("TENTE NOVAMENTE");
						System.out.println("Voltando para o início do loop...");
					}
					continue;
				}
				}
				// 2°
				while(!loop) {
				System.out.println("");
				System.out.print("-------> Informe a direção: ");
				direcao = teclado.next();

				if (direcao.matches("[0-9]+")) {
					System.out.println("Erro: a direção deve ser uma palavra.");
					errou = true;
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					System.out.println("Voltando para o início do loop...");
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						jogarNovamente = true;
						loop = true;
						break;
					}
					continue;
				}

				System.out.print("-------> Informe a quantidade de passos: ");
				while (!teclado.hasNextInt()) {
					System.out.println("Erro: a quantidade de passos deve ser um número.");
					errou = true;
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					System.out.println("Voltando para o início do loop...");
					System.out.print("-------> Informe a quantidade de passos: ");
					teclado.next(); // Limpar o valor inválido do teclado
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						jogarNovamente = true;
						loop = true;
						break;
					}
					continue;
				}
				passos = teclado.nextInt();
				passos = passos * 10;
				potenciaBateria -= passos;

				direcao = direcao.toUpperCase();

				if (direcao.equals("FRENTE")) {
					System.out.println("ACERTOU A 2° DIREÇÃO");
					potenciaBateria -= 10;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
				
				} else {
					System.out.println("ERROU A 2° DIREÇÃO");
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					errou = true;
				}

				if (passos / 10 == 4) {
					System.out.println("ACERTOU O 2° PASSO");
					potenciaBateria -= 10;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						break;
					}
					break;
				} else {
					System.out.println("ERROU O 2° PASSO");
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					errou = true;
				}
				if (errou) {
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						jogarNovamente = true;
						loop = true;
						break;
					} else {
						System.out.println("TENTE NOVAMENTE");
						System.out.println("Voltando para o início do loop...");
					}
					continue;
				}
				}
				// 3°
				while(!loop) {
				System.out.println("");
				System.out.print("-------> Informe a direção: ");
				direcao = teclado.next();

				if (direcao.matches("[0-9]+")) {
					System.out.println("Erro: a direção deve ser uma palavra.");
					errou = true;
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					System.out.println("Voltando para o início do loop...");
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						jogarNovamente = true;
						loop = true;
						break;
					}
					continue;
				}

				System.out.print("-------> Informe a quantidade de passos: ");
				while (!teclado.hasNextInt()) {
					System.out.println("Erro: a quantidade de passos deve ser um número.");
					errou = true;
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					System.out.println("Voltando para o início do loop...");
					System.out.print("-------> Informe a quantidade de passos: ");
					teclado.next(); // Limpar o valor inválido do teclado
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						jogarNovamente = true;
						loop = true;
						break;
					}
					continue;
				}
				passos = teclado.nextInt();
				passos = passos * 10;
				potenciaBateria -= passos;

				direcao = direcao.toUpperCase();

				if (direcao.equals("DIREITA")) {
					System.out.println("ACERTOU A 3° DIREÇÃO");
					potenciaBateria -= 10;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					errou = true;
					
				} else {
					System.out.println("ERROU A 3° DIREÇÃO");
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
				}

				if (passos / 10 == 7) {
					System.out.println("ACERTOU O 3° PASSO");
					potenciaBateria -= 10;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						break;
					}
					break;
				} else {
					System.out.println("ERROU O 3° PASSO");
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					errou = true;
				}

				if (errou) {
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						jogarNovamente = true;
						loop = true;
						break;
					} else {
						System.out.println("TENTE NOVAMENTE");
						System.out.println("Voltando para o início do loop...");
					}
					continue;
				}
				}
				// 4°
				while(!loop) {
				System.out.println("");
				System.out.print("-------> Informe a direção: ");
				direcao = teclado.next();

				if (direcao.matches("[0-9]+")) {
					System.out.println("Erro: a direção deve ser uma palavra.");
					errou = true;
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					System.out.println("Voltando para o início do loop...");
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						jogarNovamente = true;
						loop = true;
						break;
					}
					continue;
				}

				System.out.print("-------> Informe a quantidade de passos: ");
				while (!teclado.hasNextInt()) {
					System.out.println("Erro: a quantidade de passos deve ser um número.");
					errou = true;
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					System.out.println("Voltando para o início do loop...");
					System.out.print("-------> Informe a quantidade de passos: ");
					teclado.next(); // Limpar o valor inválido do teclado
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						jogarNovamente = true;
						loop = true;
						break;
					}
					continue;
				}
				passos = teclado.nextInt();
				passos = passos * 10;
				potenciaBateria -= passos;

				direcao = direcao.toUpperCase();

				if (direcao.equals("TRAS")) {
					System.out.println("ACERTOU A 4° DIREÇÃO");
					potenciaBateria -= 10;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					
					
				} else {
					System.out.println("ERROU A 4° DIREÇÃO");
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					errou = true;
				}

				if (passos / 10 == 6) {
					System.out.println("ACERTOU O 4° PASSO");
					potenciaBateria -= 10;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						break;
					}
					break;
				} else {
					System.out.println("ERROU O 4° PASSO");
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					errou = true;
				}

				if (errou) {
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						jogarNovamente = true;
						loop = true;
						break;
					} else {
						System.out.println("TENTE NOVAMENTE");
						System.out.println("Voltando para o início do loop...");
					}
					continue;
				}
				}
				// 5°
				while(!loop) {
				System.out.println("");
				System.out.print("-------> Informe a direção: ");
				direcao = teclado.next();

				if (direcao.matches("[0-9]+")) {
					System.out.println("Erro: a direção deve ser uma palavra.");
					errou = true;
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					System.out.println("Voltando para o início do loop...");
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						jogarNovamente = true;
						loop = true;
						break;
					}
					continue;
				}

				System.out.print("-------> Informe a quantidade de passos: ");
				while (!teclado.hasNextInt()) {
					System.out.println("Erro: a quantidade de passos deve ser um número.");
					errou = true;
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					System.out.println("Voltando para o início do loop...");
					System.out.print("-------> Informe a quantidade de passos: ");
					teclado.next(); // Limpar o valor inválido do teclado
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						jogarNovamente = true;
						loop = true;
						break;
					}
					continue;
				}
				passos = teclado.nextInt();
				passos = passos * 10;
				potenciaBateria -= passos;

				direcao = direcao.toUpperCase();

				if (direcao.equals("DIREITA")) {
					System.out.println("ACERTOU A 5° DIREÇÃO");
					potenciaBateria -= 10;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					
				} else {
					System.out.println("ERROU A 5° DIREÇÃO");
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					errou = true;
				}

				if (passos / 10 == 8) {
					System.out.println("ACERTOU O 5° PASSO");
					potenciaBateria -= 10;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						break;
					}
					break;
				} else {
					System.out.println("ERROU O 5° PASSO");
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					errou = true;
				}

				if (errou) {
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						jogarNovamente = true;
						loop = true;
						break;
					} else {
						System.out.println("TENTE NOVAMENTE");
						System.out.println("Voltando para o início do loop...");
					}
					continue;
				}
				}
				// 6°
				while(!loop) {
				System.out.println("");
				System.out.print("-------> Informe a direção: ");
				direcao = teclado.next();

				if (direcao.matches("[0-9]+")) {
					System.out.println("Erro: a direção deve ser uma palavra.");
					errou = true;
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					System.out.println("Voltando para o início do loop...");
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						jogarNovamente = true;
						loop = true;
						break;
					}
					continue;
				}

				System.out.print("-------> Informe a quantidade de passos: ");
				while (!teclado.hasNextInt()) {
					System.out.println("Erro: a quantidade de passos deve ser um número.");
					errou = true;
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					System.out.println("Voltando para o início do loop...");
					System.out.print("-------> Informe a quantidade de passos: ");
					teclado.next(); // Limpar o valor inválido do teclado
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						jogarNovamente = true;
						loop = true;
						break;
					}
					continue;
				}
				passos = teclado.nextInt();
				passos = passos * 10;
				potenciaBateria -= passos;

				direcao = direcao.toUpperCase();

				if (direcao.equals("TRAS")) {
					System.out.println("ACERTOU A 6° DIREÇÃO");
					potenciaBateria -= 10;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
				
				} else {
					System.out.println("ERROU A 6° DIREÇÃO");
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					errou = true;
				}

				if (passos / 10 == 4) {
					System.out.println("ACERTOU O 6° PASSO");
					potenciaBateria -= 10;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						break;
					}
					break;
				} else {
					System.out.println("ERROU O 6° PASSO");
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					errou = true;
				}

				if (errou) {
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						jogarNovamente = true;
						loop = true;
						break;
					} else {
						System.out.println("TENTE NOVAMENTE");
						System.out.println("Voltando para o início do loop...");
					}
					continue;
				}
				}
				// 7°
				while(!loop) {
				System.out.println("");
				System.out.print("-------> Informe a direção: ");
				direcao = teclado.next();

				if (direcao.matches("[0-9]+")) {
					System.out.println("Erro: a direção deve ser uma palavra.");
					errou = true;
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					System.out.println("Voltando para o início do loop...");
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						jogarNovamente = true;
						loop = true;
						break;
					}
					continue;
				}

				System.out.print("-------> Informe a quantidade de passos: ");
				while (!teclado.hasNextInt()) {
					System.out.println("Erro: a quantidade de passos deve ser um número.");
					errou = true;
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					System.out.println("Voltando para o início do loop...");
					System.out.print("-------> Informe a quantidade de passos: ");
					teclado.next(); // Limpar o valor inválido do teclado
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						jogarNovamente = true;
						loop = true;
						break;
					}
					continue;
				}
				passos = teclado.nextInt();
				passos = passos * 10;
				potenciaBateria -= passos;

				direcao = direcao.toUpperCase();

				if (direcao.equals("DIREITA")) {
					System.out.println("ACERTOU A 7° DIREÇÃO");
					potenciaBateria -= 10;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					
				} else {
					System.out.println("ERROU A 7° DIREÇÃO");
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					errou = true;
				}

				if (passos / 10 == 6) {
					System.out.println("ACERTOU O 7° PASSO");
					potenciaBateria -= 10;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
					}
					ganhou = true;
					// Se todos os passos estiverem corretos, o jogador vence
					System.out.println("");
					potenciaBateria -= 10;
					System.out.println("----------> VOCÊ GANHOU !");
					System.out.println("_______0__o_o__o_0_0_o_o__0");
					System.out.println("______0___o__o__o0_0__o_o__0");
					System.out.println("_____0___o__o_o__0_0__o___o__0");
					System.out.println("____0_o___o___o__0_0___o___o__0");
					System.out.println("____00o0000o00o0o0_0o00o00oo0oo0");
					System.out.println("___000o0o00000o000_000o00o0o000o0");
					System.out.println("___00000o000o000o0_000o000o00000o0");
					System.out.println("___0o00oo00o0o00o0__0000o0o0o00000");
					System.out.println("___0o0o00000o00o0___000o0o0o0o0o00");
					System.out.println("____0o0o0000o0o0_____0000o00o00o0");
					System.out.println("_____0000o0000________ 00o000o000");
					System.out.println("______0000000___________0000000");
					System.out.println("________00__________________00");
					System.out.println("_______00_______OBRIGADO_____00");
					System.out.println("______00________POR JOGAR!____00");
					System.out.println("_____00________________________00");
					System.out.println("____00__________________________00");
					System.out.println("_000000________________________000000");
					System.out.println("POTÊNCIA DA BATERIA FINAL: " + Math.max(0, potenciaBateria));
					jogarNovamente = perguntarJogarNovamente(teclado);
					break;
				} else {
					System.out.println("ERROU O 7° PASSO");
					potenciaBateria -= 20;
					System.out.println("POTÊNCIA DA BATERIA RESTANTE: " + Math.max(0, potenciaBateria));
					errou = true;
				}
				if (errou) {
					if (potenciaBateria <= 0) {
						System.out.println("GAME OVER");
						System.out.println("REINICIE PARA JOGAR NOVAMENTE");
						jogarNovamente = perguntarJogarNovamente(teclado);
						jogarNovamente = true;
						loop = true;
						break;
					} else if (errou) {
						System.out.println("TENTE NOVAMENTE");
						System.out.println("Voltando para o início do loop...");
						continue;
					}
				}
			}
		}
	}

}
	   public static boolean perguntarJogarNovamente(Scanner teclado) {
		    System.out.println("");
		    System.out.print("Deseja jogar novamente? (S/N): ");
		    String resposta = teclado.next().toUpperCase();

		    if (resposta.equals("S")) {
		        System.out.println("Jogando novamente...");
		        return true;
		    } else {
		        System.out.println("Obrigado por jogar! Até a próxima.");
		        return false;
		    }
	   }
	 }