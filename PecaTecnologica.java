public class PecaTecnologica {
    private String nome;
    private int[] posicao;
    private int valor;

    public PecaTecnologica(String nome, int linha, int coluna, int valor) {
        this.nome = nome;
        this.posicao = new int[] { linha, coluna };
        this.valor = valor;
    }

    public void efeito() {
        System.out.println(nome + " coletado!");
    }

    public String getNome() {
        return nome;
    }

    public int[] getPosicao() {
        return posicao;
    }

    public int getValor() {
        return valor;
    }
}