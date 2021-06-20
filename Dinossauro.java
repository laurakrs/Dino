public class Dinossauro {

    private int id; //id: número de identificação único do dinossauro (int).
    private String nomeRaca; 
    private int tipo; //tipo do dinossauro (int), sendo 1 para carnívoros e 2 para herbívoros.
    private int categoria; // categoria do dinossauro (int), sendo 1 para Pequeno Porte, 2 para Médio Porte e 3 para Grande Porte.
    private double peso; //peso do dinossauro em Kg (double).
    private double velocidade; //velocidade máxima que o dinossauro consegue correr em km/h (double).

    public Dinossauro(int id, String nomeRaca, int tipo, int categoria, double peso, double velocidade){ //construtor
        this.id = id;
        this.nomeRaca = nomeRaca;
        this.tipo = tipo;
        this.categoria = categoria;
        this.peso = peso;
        this.velocidade = velocidade;


    }



}