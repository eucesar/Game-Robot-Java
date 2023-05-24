package sprint1;

import java.util.Scanner;

public class JogoDoRoboSprint1 {

	public static void main(String[] args) {
		
		//apresentação
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("------------------------------------------------------BEM-VINDO----------------------------------------------------------------");
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("---------------------------------------JOGO: CHEGUE ATÉ O TROFEU COM SEU ROBÔ--------------------------------------------------");
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("");
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("-----------------------------------------------------INSTRUÇÕES:---------------------------------------------------------------");
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("------------------PARA ACERTAR QUAL O CAMINHO CORRETO ULTILIZE A IMAGEM (mapa.png) DENTRO DESSE ARQUIVO------------------------");
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("----------CONTE A QUANTIDADE DE QUADRADOS E INFORME A DIREÇÃO E QUANTIDADE DE PASSOS PARA CHEGAR ATÉ O TROFEU------------------");
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("");
				
				//var
				Scanner teclado = new Scanner(System.in);
				String direcao;
				int passos;
				boolean errou = false;
				
				System.out.println("-------> DIREÇÃO: 'FRENTE, TRAS, ESQUERDA, DIREITA'");
				System.out.println("-------> PASSOS: 'CONTE A QUANTIDADE DE QUADRADOS NA IMAGEM - A IMAGEM DO ROBÔ NÃO CONTA(PULE) - O QUADRADO DO TROFEU CONTA'");

				//PAR DE COMANDO 1 :
				System.out.print("-------> Informe a direção: ");
				direcao = teclado.next();
				
				//verifica se a entrada é um número ou uma string
				if (direcao.matches("[0-9]+")) {
					System.out.println("Erro: a direção deve ser uma palavra.");
				    System.out.println("GAMER-OVER");
				    System.out.println("REINICIE PARA JOGAR NOVAMENTE");
					return;
				}
				
				System.out.print("-------> informe a quantidade de passos: ");
				//verifica se a entrada é um número ou uma string
				if (!teclado.hasNextInt()) {
					System.out.println("Erro: a quantidade de passos deve ser um número.");
				    System.out.println("GAMER-OVER");
				    System.out.println("REINICIE PARA JOGAR NOVAMENTE");
					return;
				}
				passos = teclado.nextInt();
				
				
				// converte a direção para maiúscula
				direcao = direcao.toUpperCase();
				//MAPA :
				if(direcao.equals("DIREITA")) {
					System.out.println("ACERTOU A 1° DIREÇÃO");
					
				}else {
					System.out.println("ERROU A 1° DIREÇÃO");
					errou = true;
					
					
				}if (passos == 5) {
					System.out.println("ACERTOU O 1° PASSO");
					
				}else {
					System.out.println("ERROU O 1° PASSO");
					errou = true;
				}
				
				if (errou) {
				    System.out.println("GAMER-OVER");
				    System.out.println("REINICIE PARA JOGAR NOVAMENTE");
				    return;
				}
				
				System.out.println("");
				
				//PARES DE COMANDO 2:
				System.out.print("-------> Informe a direção: ");
				
				direcao = teclado.next();
				if (direcao.matches("[0-9]+")) {
					System.out.println("Erro: a direção deve ser uma palavra.");
				    System.out.println("GAMER-OVER");
				    System.out.println("REINICIE PARA JOGAR NOVAMENTE");
					return;
				}
				
				System.out.print("-------> informe a quantidade de passos: ");
				if (!teclado.hasNextInt()) {
					System.out.println("Erro: a quantidade de passos deve ser um número.");
				    System.out.println("GAMER-OVER");
				    System.out.println("REINICIE PARA JOGAR NOVAMENTE");
					return;
				}
				passos = teclado.nextInt();
				
				
				direcao = direcao.toUpperCase();
				//MAPA :
				if(direcao.equals("FRENTE")) {
					System.out.println("ACERTOU A 2° DIREÇÃO");
				}else {
					System.out.println("ERROU A 2° DIREÇÃO");
					errou = true;
					
				}if (passos == 4) {
					System.out.println("ACERTOU O 2° PASSO");
				}else {
					System.out.println("ERROU O 2° PASSO");
					errou = true;
				}
				
				if (errou) {
				    System.out.println("GAMER-OVER");
				    System.out.println("REINICIE PARA JOGAR NOVAMENTE");
				    return;
				}
				
				System.out.println("");
				
				//PARES DE COMANDO 3:
				System.out.print("-------> Informe a direção: ");
				
				direcao = teclado.next();
				if (direcao.matches("[0-9]+")) {
					System.out.println("Erro: a direção deve ser uma palavra.");
				    System.out.println("GAMER-OVER");
				    System.out.println("REINICIE PARA JOGAR NOVAMENTE");
					return;
				}
				
				System.out.print("-------> informe a quantidade de passos: ");
				if (!teclado.hasNextInt()) {
					System.out.println("Erro: a quantidade de passos deve ser um número.");
				    System.out.println("GAMER-OVER");
				    System.out.println("REINICIE PARA JOGAR NOVAMENTE");
					return;
				}
				passos = teclado.nextInt();
				
				
				direcao = direcao.toUpperCase();
				//MAPA :
				if(direcao.equals("DIREITA")) {
					System.out.println("ACERTOU A 3° DIREÇÃO");
				}else {
					System.out.println("ERROU A 3° DIREÇÃO");
					errou = true;
					
				}if (passos == 7) {
					System.out.println("ACERTOU O 3° PASSO");
				}else {
					System.out.println("ERROU O 3° PASSO");
					errou = true;
				}
				
				if (errou) {
				    System.out.println("GAMER-OVER");
				    System.out.println("REINICIE PARA JOGAR NOVAMENTE");
				    return;
				}
				
				System.out.println("");
				
				//PARES DE COMANDO 4:
				System.out.print("-------> Informe a direção: ");
				
				direcao = teclado.next();
				if (direcao.matches("[0-9]+")) {
					System.out.println("Erro: a direção deve ser uma palavra.");
				    System.out.println("GAMER-OVER");
				    System.out.println("REINICIE PARA JOGAR NOVAMENTE");
					return;
				}
				
				System.out.print("-------> informe a quantidade de passos: ");
				if (!teclado.hasNextInt()) {
					System.out.println("Erro: a quantidade de passos deve ser um número.");
				    System.out.println("GAMER-OVER");
				    System.out.println("REINICIE PARA JOGAR NOVAMENTE");
					return;
				}
				passos = teclado.nextInt();
				
				direcao = direcao.toUpperCase();
				//MAPA :
				if(direcao.equals("TRAS")) {
					System.out.println("ACERTOU A 4° DIREÇÃO");
				}else {
					System.out.println("ERROU A 4° DIREÇÃO");
					errou = true;
					
				}if (passos == 6) {
					System.out.println("ACERTOU O 4° PASSO");
				}else {
					System.out.println("ERROU O 4° PASSO");
					errou = true;
				}
				
				if (errou) {
				    System.out.println("GAMER-OVER");
				    System.out.println("REINICIE PARA JOGAR NOVAMENTE");
				    return;
				}
				
				System.out.println("");
				
				//PARES DE COMANDO 5:
				System.out.print("-------> Informe a direção: ");
				
				direcao = teclado.next();
				if (direcao.matches("[0-9]+")) {
					System.out.println("Erro: a direção deve ser uma palavra.");
				    System.out.println("GAMER-OVER");
				    System.out.println("REINICIE PARA JOGAR NOVAMENTE");
					return;
				}
				
				System.out.print("-------> informe a quantidade de passos: ");
				if (!teclado.hasNextInt()) {
					System.out.println("Erro: a quantidade de passos deve ser um número.");
				    System.out.println("GAMER-OVER");
				    System.out.println("REINICIE PARA JOGAR NOVAMENTE");
					return;
				}
				passos = teclado.nextInt();
				
				
				direcao = direcao.toUpperCase();
				//MAPA :
				if(direcao.equals("DIREITA")) {
					System.out.println("ACERTOU A 5° DIREÇÃO");
					
				}else {
					System.out.println("ERROU A 5° DIREÇÃO");
					errou = true;
					
				}if (passos == 8) {
					System.out.println("ACERTOU O 5° PASSO");
				}else {
					System.out.println("ERROU O 5° PASSO");
					errou = true;
				}
				
				if (errou) {
				    System.out.println("GAMER-OVER");
				    System.out.println("REINICIE PARA JOGAR NOVAMENTE");
				    return;
				}
				
				System.out.println("");
				
				//PARES DE COMANDO 6:
				System.out.print("-------> Informe a direção: ");
				
				direcao = teclado.next();
				if (direcao.matches("[0-9]+")) {
					System.out.println("Erro: a direção deve ser uma palavra.");
				    System.out.println("GAMER-OVER");
				    System.out.println("REINICIE PARA JOGAR NOVAMENTE");
					return;
				}
				
				System.out.print("-------> informe a quantidade de passos: ");
				if (!teclado.hasNextInt()) {
					System.out.println("Erro: a quantidade de passos deve ser um número.");
				    System.out.println("GAMER-OVER");
				    System.out.println("REINICIE PARA JOGAR NOVAMENTE");
					return;
				}
				passos = teclado.nextInt();
				
				
				direcao = direcao.toUpperCase();
				//MAPA :
				if(direcao.equals("TRAS")) {
					System.out.println("ACERTOU A 6° DIREÇÃO");
				}else {
					System.out.println("ERROU A 6° DIREÇÃO");
					errou = true;
					
				}if (passos == 4) {
					System.out.println("ACERTOU O 6° PASSO");
				}else {
					System.out.println("ERROU O 6° PASSO");
					errou = true;
				}
				
				if (errou) {
				    System.out.println("GAMER-OVER");
				    System.out.println("REINICIE PARA JOGAR NOVAMENTE");
				    return;
				}
				
				System.out.println("");
				
				//PARES DE COMANDO 7:
				System.out.print("-------> Informe a direção: ");
				
				direcao = teclado.next();
				if (direcao.matches("[0-9]+")) {
					System.out.println("Erro: a direção deve ser uma palavra.");
				    System.out.println("GAMER-OVER");
				    System.out.println("REINICIE PARA JOGAR NOVAMENTE");
					return;
				}
				
				System.out.print("-------> informe a quantidade de passos: ");
				if (!teclado.hasNextInt()) {
					System.out.println("Erro: a quantidade de passos deve ser um número.");
				    System.out.println("GAMER-OVER");
				    System.out.println("REINICIE PARA JOGAR NOVAMENTE");
					return;
				}
				passos = teclado.nextInt();
				
				
				direcao = direcao.toUpperCase();
				//MAPA :
				if(direcao.equals("DIREITA")) {
					System.out.println("ACERTOU A 7° DIREÇÃO");
				}else {
					System.out.println("ERROU A 7° DIREÇÃO");
					errou = true;
					
				}if (passos == 6) {
					System.out.println("ACERTOU O 7° PASSO");
				}else {
					System.out.println("ERROU O 7° PASSO");
					errou = true;
				}
				
				if (errou) {
				    System.out.println("GAMER-OVER");
				    System.out.println("REINICIE PARA JOGAR NOVAMENTE");
				    return;
				}
				
				System.out.println("");
				
				System.out.println("-------> VOCÊ GANHOU !");
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
					
	}

}

