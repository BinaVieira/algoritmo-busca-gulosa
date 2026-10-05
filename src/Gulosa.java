public class Gulosa {
    private Vertice objetivo;
    private boolean achou;
    private int passo;

    public Gulosa(Vertice objetivo) {
        this.objetivo = objetivo;
        this.achou = false;
        this.passo = 1;
    }

    public void busca(Vertice atual) {
        System.out.println("\n=======================================================");
        System.out.printf(" PASSO %d | Cidade Atual: %s (Heurística: %d km)\n",
                passo++, atual.getRotulo(), atual.getDistanciaObjetivo());
        System.out.println("=======================================================");

        atual.setVisitado(true);

        if (atual == objetivo || atual.getDistanciaObjetivo() == 0) {
            this.achou = true;
            System.out.println("\n OBJETIVO ALCANÇADO!");
            System.out.println(" Chegamos em " + objetivo.getRotulo() + " com sucesso!");
            System.out.println("=======================================================\n");
        } else {
            VetorOrdenado vetorOrdenado = new VetorOrdenado(atual.getAdjacentes().size());

            for (Adjacente adj : atual.getAdjacentes()) {
                if (!adj.getVertice().isVisitado()) {
                    adj.getVertice().setVisitado(true);
                    vetorOrdenado.insere(adj.getVertice());
                }
            }

            System.out.println(" Vizinhos avaliados (ordenados pela menor distância ao destino):");
            vetorOrdenado.imprime();

            Vertice proximo = vetorOrdenado.getPrimeiro();
            if (proximo != null) {
                System.out.println(" Decisão Gulosa: Ir para -> " + proximo.getRotulo());
                busca(proximo);
            } else {
                System.out.println(" Caminho sem saída encontrado!");
            }
        }
    }

    public boolean isAchou() {
        return achou;
    }
}