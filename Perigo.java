public class Perigo {
    private int[] posicao;
    private int dano;

    public Perigo(int linha, int coluna, int dano) {
        this.posicao = new int[] { linha, coluna };
        this.dano = dano;
    }

    public int[] getPosicao() {
        return posicao;
    }

    public int getDano() {
        return dano;
    }
}