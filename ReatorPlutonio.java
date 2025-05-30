public class ReatorPlutonio extends PecaTecnologica {
    public ReatorPlutonio(int linha, int coluna) {
        super("Reator de Plutônio", linha, coluna, 500);
    }

    @Override
    public void efeito() {
        System.out.println("Energia da nave restaurada! Pontos extras ganhos.");
    }
}