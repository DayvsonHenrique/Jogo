
import java.util.ArrayList;

public class Astronauta {
    private String nome;
    private int[] posicaoAtual;
    private ArrayList<PecaTecnologica> pecasColetadas;
    private boolean encontrouEasterEgg = false;
    private int vida = 100;

    public Astronauta(String nome, int linha, int coluna) {
        this.nome = nome;
        this.posicaoAtual = new int[]{linha, coluna};
        this.pecasColetadas = new ArrayList<>();
    }

    public void mover(String direcao, int maxLinhas, int maxColunas) throws Exception {
        int novaLinha = posicaoAtual[0];
        int novaColuna = posicaoAtual[1];

        switch (direcao.toLowerCase()) {
            case "w": novaLinha--; break;
            case "s": novaLinha++; break;
            case "a": novaColuna--; break;
            case "d": novaColuna++; break;
            default: throw new Exception("Comando inválido! Use W, A, S, D.");
        }

        if (novaLinha < 0 || novaLinha >= maxLinhas || novaColuna < 0 || novaColuna >= maxColunas) {
            throw new Exception("Movimento inválido: fora dos limites da estação!");
        }

        posicaoAtual[0] = novaLinha;
        posicaoAtual[1] = novaColuna;
    }

    public void interagir(EstacaoEspacial estacao) {
        for (PecaTecnologica peca : estacao.getPecas()) {
            if (mesmaPosicao(peca.getPosicao())) {
                coletarPeca(peca);
                estacao.removerPeca(peca);
                break;
            }
        }

        for (Perigo perigo : estacao.getPerigos()) {
            if (mesmaPosicao(perigo.getPosicao())) {
                System.out.println("⚠️ EXPLOSÃO! Você pisou em uma armadilha!");
                sofrerDano(perigo.getDano());
                break;
            }
        }

        for (KitMedico kit : estacao.getKits()) {
            if (mesmaPosicao(kit.getPosicao())) {
                recuperarVida(kit.getCura());
                estacao.removerKit(kit);
                break;
            }
        }

        if (!encontrouEasterEgg && mesmaPosicao(estacao.getEasterEggPosicao())) {
            encontrouEasterEgg = true;
            System.out.println("\n*** EASTER EGG DESBLOQUEADO! ***");
            System.out.println("Você encontrou um alienígena amigável!");
            coletarPeca(new PecaTecnologica("Artefato Alienígena", posicaoAtual[0], posicaoAtual[1], 999));
        }
    }

    public void sofrerDano(int valor) {
        vida -= valor;
        System.out.println("💥 Dano recebido: " + valor + " | Vida restante: " + vida);
        if (vida <= 0) {
            System.out.println("\n💀 GAME OVER! Você não resistiu aos danos...");
            System.exit(0);
        }
    }

    public void recuperarVida(int valor) {
        vida += valor;
        if (vida > 100) vida = 100;
        System.out.println("❤️ Recuperou " + valor + " de vida! Vida atual: " + vida);
    }

    private boolean mesmaPosicao(int[] pos) {
        return posicaoAtual[0] == pos[0] && posicaoAtual[1] == pos[1];
    }

    public void coletarPeca(PecaTecnologica peca) {
        pecasColetadas.add(peca);
        peca.efeito();
    }

    public String getNome() { return nome; }
    public int[] getPosicaoAtual() { return posicaoAtual; }
    public ArrayList<PecaTecnologica> getPecasColetadas() { return pecasColetadas; }
}
