import java.util.Scanner;

public class Ranking {

	public static void main(String[] args) {
		
        Scanner teclado = new Scanner(System.in);
        int numEquipes;
        boolean reiniciar = true; // Variável para controlar se o usuário deseja reiniciar

        do {
            boolean start = false;
            int numCombatesPrimeiraEquipe = 0;

            int[] equipes;
            char[][] resultados;
            int[] notasDesign; // Array para armazenar as notas de design
            int[] pontuacaoEquipes;

            System.out.println("\n");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("-------------------------------Bem - Vindo(a)-----------------------------");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("--------------Ranking das equipes participantes da RoboCup----------------");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println();

         // 1° Parte
            do {
                System.out.print("Digite a quantidade de equipes: ");
                numEquipes = teclado.nextInt();

                if (numEquipes > 0) {
                    start = true;
                } else {
                    System.out.println("O número de equipes deve ser maior que 0. Informe um número válido para prosseguir.");
                    System.out.println("Reiniciando...");
                }

            //COMEÇA AQUI
            } while (!start);

            equipes = new int[numEquipes];
            resultados = new char[numEquipes][];
            notasDesign = new int[numEquipes];

            // Variável para armazenar o número de combates da primeira equipe

            for (int i = 0; i < equipes.length; i++) {
                boolean numeroValido = false;
                do {
                    System.out.print("Número da " + (i + 1) + "ª equipe (de 11 a 99): ");
                    int numCadaEquipe = teclado.nextInt();

                    if (numCadaEquipe >= 11 && numCadaEquipe <= 99) {
                        boolean numeroJaUsado = false;

                        // Verifica se o número já foi usado
                        for (int j = 0; j < i; j++) {
                            if (equipes[j] == numCadaEquipe) {
                                numeroJaUsado = true;
                                break;
                            }
                        }

                        if (!numeroJaUsado) {
                            equipes[i] = numCadaEquipe;
                            numeroValido = true;
                        } else {
                            System.out.println("Número já em uso. Informe um número válido e único.");
                        }
                    } else {
                        System.out.println("Número inválido. Informe um número válido (de 11 a 99).");
                    }
                } while (!numeroValido);

                // 2° Parte
                if (i == 0) {
                    System.out.print("Quantidade de combates da equipe " + (i + 1) + ": ");
                    numCombatesPrimeiraEquipe = teclado.nextInt();
                } else {
                    int numCombates;
                    do {
                        System.out.print("Quantidade de combates da equipe " + (i + 1) + ": ");
                        numCombates = teclado.nextInt();

                        if (numCombates != numCombatesPrimeiraEquipe) {
                            System.out.println("O número de combates deve ser igual ao da primeira equipe ('" + numCombatesPrimeiraEquipe + "').");
                        }
                    } while (numCombates != numCombatesPrimeiraEquipe);

                }
                resultados[i] = new char[numCombatesPrimeiraEquipe];

                //3° Parte
                do {
                    System.out.print("Nota de design da equipe " + (i + 1) + " (0 a 10): ");
                    notasDesign[i] = teclado.nextInt();

                    if (notasDesign[i] < 0 || notasDesign[i] > 10) {
                        System.out.println("Nota inválida. Por favor, informe uma nota de 0 a 10.");
                    }
                } while (notasDesign[i] < 0 || notasDesign[i] > 10);

                
                // 2° Parte...
                for (int j = 0; j < numCombatesPrimeiraEquipe; j++) {
                    do {
                        System.out.print("Resultado do " + (j + 1) + "° combate (V para Vitória, E para Empate, D para Derrota): ");
                        resultados[i][j] = teclado.next().charAt(0);

                        if (resultados[i][j] != 'V' && resultados[i][j] != 'E' && resultados[i][j] != 'D') {
                            System.out.println("Valor inválido. Por favor, informe 'V', 'E' ou 'D' (maiúsculo).");
                        }
                    } while (resultados[i][j] != 'V' && resultados[i][j] != 'E' && resultados[i][j] != 'D');
                }
            }

            // 4° Parte
            // Calcula a pontuação de cada equipe
            pontuacaoEquipes = new int[numEquipes];
            for (int i = 0; i < numEquipes; i++) {
                for (int j = 0; j < resultados[i].length; j++) {
                    if (resultados[i][j] == 'V') {
                        pontuacaoEquipes[i] += 5;
                    } else if (resultados[i][j] == 'E') {
                        pontuacaoEquipes[i] += 3;
                    }
                    
                    // Derrotas não somam pontos
                }
            }

            // Classifica as equipes com base na pontuação (e na nota de design em caso de empate)
            for (int i = 0; i < numEquipes - 1; i++) {
                for (int j = i + 1; j < numEquipes; j++) {
                    if (pontuacaoEquipes[i] < pontuacaoEquipes[j] || (pontuacaoEquipes[i] == pontuacaoEquipes[j] && notasDesign[i] < notasDesign[j])) {
                        // Troca de posição
                        int tempPontuacao = pontuacaoEquipes[i];
                        pontuacaoEquipes[i] = pontuacaoEquipes[j];
                        pontuacaoEquipes[j] = tempPontuacao;

                        int tempEquipe = equipes[i];
                        equipes[i] = equipes[j];
                        equipes[j] = tempEquipe;

                        char[] tempResultados = resultados[i];
                        resultados[i] = resultados[j];
                        resultados[j] = tempResultados;

                        int tempDesign = notasDesign[i];
                        notasDesign[i] = notasDesign[j];
                        notasDesign[j] = tempDesign;
                    }
                }
            }

            // Exibe a lista classificada
            System.out.println("\n--- Classificação Final ---");
            for (int i = 0; i < numEquipes; i++) {
                System.out.println("Equipe " + equipes[i] + ": Pontuação = " + pontuacaoEquipes[i] + ", Nota de Design = " + notasDesign[i]);
            }

            // Encontra as equipes que empataram na quantidade de combates e nota de design
            System.out.println("\n--- Equipes que EMPATARAM ---");
            for (int i = 0; i < numEquipes - 1; i++) {
                for (int j = i + 1; j < numEquipes; j++) {
                    if (pontuacaoEquipes[i] == pontuacaoEquipes[j] && notasDesign[i] == notasDesign[j]) {
                        System.out.println("Empate entre Equipe " + equipes[i] + " e Equipe " + equipes[j]);
                    }
                }
            }
            
            // Pergunta ao usuário se deseja reiniciar
            System.out.println("\n");
            System.out.print("\nDeseja reiniciar o sistema? (S para Sim, N para Não): ");
            char reiniciarEscolha = teclado.next().charAt(0);
            if (reiniciarEscolha == 'N' || reiniciarEscolha == 'n') {
                reiniciar = false; // Define como falso para encerrar o loop
            }

        } while (reiniciar);
    }

}
		


