public class VetorOrdenado {
    private Vertice[] vertices;
    private int capacidade;
    private int ultimaPosicao;

    public VetorOrdenado(int capacidade) {
        this.capacidade = capacidade;
        this.ultimaPosicao = -1;
        this.vertices = new Vertice[capacidade];
    }

    public void insere(Vertice vertice) {
        if (ultimaPosicao == capacidade - 1) {
            System.out.println("Capacidade máxima do vetor atingida!");
            return;
        }

        int pos;
        for (pos = 0; pos <= ultimaPosicao; pos++) {
            if (vertices[pos].getDistanciaObjetivo() > vertice.getDistanciaObjetivo()) {
                break;
            }
        }

        for (int k = ultimaPosicao; k >= pos; k--) {
            vertices[k + 1] = vertices[k];
        }

        vertices[pos] = vertice;
        ultimaPosicao++;
    }

    public Vertice getPrimeiro() {
        if (ultimaPosicao == -1) {
            return null;
        }
        return vertices[0];
    }

    public void imprime() {
        if (ultimaPosicao == -1) {
            System.out.println("  (Nenhum vizinho não visitado disponível)");
        } else {
            System.out.println("  +-------+--------------------+---------------------+");
            System.out.println("  | Ordem | Cidade Vizinha     | Dist. em linha reta |");
            System.out.println("  +-------+--------------------+---------------------+");
            for (int i = 0; i <= ultimaPosicao; i++) {
                System.out.printf("  |  %-4d | %-18s | %-19d |\n",
                        (i + 1),
                        vertices[i].getRotulo(),
                        vertices[i].getDistanciaObjetivo());
            }
            System.out.println("  +-------+--------------------+---------------------+");
        }
    }

    public int getUltimaPosicao() {
        return ultimaPosicao;
    }
}