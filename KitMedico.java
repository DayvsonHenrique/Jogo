
public class KitMedico {
    private int[] posicao;
    private int cura;

    public KitMedico(int linha, int coluna, int cura) {
        this.posicao = new int[]{linha, coluna};
        this.cura = cura;
    }

    public int[] getPosicao() {
        return posicao;
    }

    public int getCura() {
        return cura;
    }
}
