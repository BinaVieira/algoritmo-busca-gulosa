import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private String rotulo;
    private int distanciaObjetivo;
    private boolean visitado;
    private List<Adjacente> adjacentes;

    public Vertice(String rotulo, int distanciaObjetivo) {
        this.rotulo = rotulo;
        this.distanciaObjetivo = distanciaObjetivo;
        this.visitado = false;
        this.adjacentes = new ArrayList<>();
    }

    public void adicionaAdjacente(Adjacente adjacente) {
        this.adjacentes.add(adjacente);
    }

    public void exibeAdjacentes() {
        for (Adjacente adj : adjacentes) {
            System.out.println(adj.getVertice().getRotulo() + " - custo: " + adj.getCusto());
        }
    }

    public String getRotulo() {
        return rotulo;
    }

    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }

    public int getDistanciaObjetivo() {
        return distanciaObjetivo;
    }

    public void setDistanciaObjetivo(int distanciaObjetivo) {
        this.distanciaObjetivo = distanciaObjetivo;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public List<Adjacente> getAdjacentes() {
        return adjacentes;
    }
}