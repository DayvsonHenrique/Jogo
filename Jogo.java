import java.util.*;

public class Jogo {

    public static void main(String[] args) {
        EstacaoEspacial estacao = new EstacaoEspacial(8, 7);
        Astronauta astronauta = new Astronauta("Dayvson", 3, 3);

        Random rand = new Random();
        Set<String> ocupados = new HashSet<>();
        ocupados.add("3,3");

        // Adiciona 6 peças tecnológicas em posições aleatórias
        for (int i = 0; i < 6; i++) {
            int[] pos = posicaoAleatoria(ocupados, 8, 7);
            estacao.adicionarPeca(new ReatorPlutonio(pos[0], pos[1]));
        }

        // Adiciona 14 perigos aleatórios
        for (int i = 0; i < 14; i++) {
            int[] pos = posicaoAleatoria(ocupados, 8, 7);
            int dano = rand.nextInt(4) * 5 + 10; // 10, 15, 20, 25
            estacao.adicionarPerigo(new Perigo(pos[0], pos[1], dano));
        }

        // Adiciona o easter egg
        int[] easterEgg = posicaoAleatoria(ocupados, 8, 7);
        estacao.setEasterEggPosicao(easterEgg);

        Scanner scanner = new Scanner(System.in);
        String comando = "";

        System.out.println("=========== MISSÃO: ESTAÇÃO ESPACIAL ===========");
        System.out.println("Você é o único sobrevivente de uma missão da NASA.");
        System.out.println("Após uma explosão em um asteroide, a equipe foi destruída e a estação danificada.");
        System.out.println("Colete 3 peças tecnológicas escondidas para restabelecer comunicação com a Terra!");
        System.out.println("Use W (cima), S (baixo), A (esquerda), D (direita) para se mover.");

        while (!comando.equalsIgnoreCase("sair")) {
            if (astronauta.getPecasColetadas().size() >= 3) {
                System.out.println("\n*** Comunicação restabelecida com a NASA! ***");
                System.out.println("Comandos recebidos. A missão de resgate está a caminho. Você venceu!");
                break;
            }

            int[] pos = astronauta.getPosicaoAtual();
            System.out.println("\nPosição atual: [" + pos[0] + ", " + pos[1] + "]");
            System.out.print("Comando (w/a/s/d ou sair): ");
            comando = scanner.nextLine();

            if (comando.equalsIgnoreCase("sair"))
                break;

            try {
                astronauta.mover(comando, 8, 7);
                astronauta.interagir(estacao);
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        System.out.println("\nJogo encerrado. Peças coletadas:");
        for (PecaTecnologica p : astronauta.getPecasColetadas()) {
            System.out.println("- " + p.getNome() + " (" + p.getValor() + " pts)");
        }
        scanner.close();
    }

    public static int[] posicaoAleatoria(Set<String> ocupados, int linhas, int colunas) {
        Random rand = new Random();
        int lin, col;
        do {
            lin = rand.nextInt(linhas);
            col = rand.nextInt(colunas);
        } while (ocupados.contains(lin + "," + col));
        ocupados.add(lin + "," + col);
        return new int[] { lin, col };
    }
}
