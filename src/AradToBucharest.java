public class AradToBucharest {
    public static void main(String[] args) {
        Grafo mapa = new Grafo();
        Gulosa gulosa = new Gulosa(mapa.bucharest);
        gulosa.busca(mapa.arad);
    }
}