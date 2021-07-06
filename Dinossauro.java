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

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id; 
    }

    public String getNomeRaca(){
        return this.nomeRaca;
    }

    public void setNomeRaca(String nomeRaca){
        this.nomeRaca = nomeRaca;
    }

    public int getTipo(){
         return this.tipo;
    }

    public void setTipo(int tipo){
        this.tipo = tipo;
    }

    public int getCategoria(){
        return this.categoria;
    }
    
    public void setCategoria(int categoria){
        this.categoria = categoria;
    }

    public double getPeso(){
        return this.peso;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    public double getVelocidade(){
        return this.velocidade;
    }

    public void setVelocidade(double velocidade){
        this.velocidade = velocidade;
    }

    @Override //toString
    public String toString(){
        return ("ID do dinossauro: " + this.id + " | Nome da raca: " + this.nomeRaca + " | Tipo " + this.tipo  + " | Categoria: " + this.categoria + " | Peso " + this.peso + " kg" + " | Velocidade " + this.velocidade + " km/h");
    
    }

}