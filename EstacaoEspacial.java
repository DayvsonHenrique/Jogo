
import java.util.ArrayList;

public class EstacaoEspacial {
    private ArrayList<PecaTecnologica> pecas;
    private ArrayList<Perigo> perigos;
    private ArrayList<KitMedico> kits;
    private int[] easterEggPosicao;

    public EstacaoEspacial(int linhas, int colunas) {
        pecas = new ArrayList<>();
        perigos = new ArrayList<>();
        kits = new ArrayList<>();
    }

    public void adicionarPeca(PecaTecnologica peca) {
        pecas.add(peca);
    }

    public void removerPeca(PecaTecnologica peca) {
        pecas.remove(peca);
    }

    public void adicionarPerigo(Perigo perigo) {
        perigos.add(perigo);
    }

    public ArrayList<PecaTecnologica> getPecas() {
        return pecas;
    }

    public ArrayList<Perigo> getPerigos() {
        return perigos;
    }

    public void setEasterEggPosicao(int[] pos) {
        this.easterEggPosicao = pos;
    }

    public int[] getEasterEggPosicao() {
        return easterEggPosicao;
    }

    public void adicionarKit(KitMedico kit) {
        kits.add(kit);
    }

    public void removerKit(KitMedico kit) {
        kits.remove(kit);
    }

    public ArrayList<KitMedico> getKits() {
        return kits;
    }
}
