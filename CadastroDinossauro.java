/*Implemente uma classe CadastroDinossauro que armazena uma lista de dinossauros na forma de
um vetor com tamanho máximo 100 posições. Esta classe deve conter os seguintes métodos */


public class CadastroDinossauro{

    Dinossauro[] listaDinossauros; 
    int proxPosicao; 

    public CadastroDinossauro(){ //construtor. não sei se precisa mas to colocando
        this.listaDinossauros = new Dinossauro[100];
        this.proxPosicao = 0; 
    }

    public boolean adicionarDinoussauro(Dinossauro dino){ 
        //public boolean adicionarDinossauro(Dinossauro dino): 
        //adiciona um objeto Dinossauro na última posição disponível no vetor. 
        //Retorna true em caso de sucesso ou false caso o vetor já esteja cheio.
        if(proxPosicao == 100){
            System.out.println("O vetor de Dinossauros já está cheio!");
            return false;
        }else{
            listaDinossauros[proxPosicao] = dino; 
            System.out.println("Sucesso! Dinossauro adicionado ao vetor!");
            return true;
        }

    }

    public Dinossauro pesquisarDinossauro(int id){
        //public Dinossauro pesquisarDinossauro(int id): 
        //pesquisa no vetor por um objeto Dinossauro com o id recebido como parâmetro. 
        //Se não encontrar, retorna null;

        for(int i = 0; i < proxPosicao ; i++){
            if(listaDinossauros[i].getId() == id){
                return listaDinossauros[i];
            }
        }
        return null; //Funciona aqui? Testar
    }
    
    public boolean removerDinossauro(int id){
        
        //remove do vetor o objeto Dinossauro que contém o id indicado. 
        //Retorna true em caso de sucesso ou false se não encontrar o objeto.*/
        for(int i = 0; i < proxPosicao ; i++){
            if(listaDinossauros[i].getId() == id){
                listaDinossauros[i] = null; //é assim?
                // reordenar o vetor. Qual forma vamos escolher?
                for(int j = i+1; j < proxPosicao; j++){
                    listaDinossauros[j-1] = listaDinossauros[j]; //nao deve estar certo
                }
                System.out.println("Objeto removido com sucesso");
                proxPosicao--; //nao esquecer de decrementar proxPosicao
                return true; 
            }
        }
        System.out.println("Objeto não encontrado!");
        return false;

    }

    public String relatorioQtdAnimais(){ //Relatório “Quantidade de animais de cada tipo e categoria”:
         /*   O método deve retornar uma String na qual devem aparecer as informações referentes a
        quantidade de animais para cada tipo e categoria.
        Exemplo: Carnívoros: PP: 52, MP: 20, GP: 12. Herbívoros: PP: 68, MP: 38, GP: 30.*/

        String listaQtd = " "; 
        int carnivorosPP = 0;
        int carnivorosMP = 0;
        int carnivorosGP = 0; 
        int herbivorosPP = 0;
        int herbivorosMP = 0;
        int herbivorosGP = 0; 

        for(int i = 0; i < proxPosicao; i++){
            if(listaDinossauros[i].getCategoria() == 1){//Pequeno porte
                if(listaDinossauros[i].getTipo() == 1){//Carnivoro
                    carnivorosPP++;
                } else {
                    herbivorosPP++;//2 herbivoros
                }
            } else if(listaDinossauros[i].getCategoria() == 2){//Medio porte
                if(listaDinossauros[i].getTipo() == 1){//Carnivoro
                    carnivorosMP++;
                } else {
                    herbivorosMP++;//2 herbivoros
                }
            } else { // Grande Porte
                if(listaDinossauros[i].getTipo() == 1){//Carnivoro
                    carnivorosGP++;
                } else {
                    herbivorosGP++;//2 herbivoros
                }
            }

        }
        listaQtd = "Carnívoros: PP: " + carnivorosPP + ", MP: " + carnivorosMP + ", GP: " + carnivorosGP + ". Herbívoros: PP: " + herbivorosPP + ", MP: " + herbivorosMP + ", GP: " + herbivorosGP + ".";
        return listaQtd;
    }
   
    public Dinossauro relatorioPesoPesado(int tipo, int categoria){ //Relatório “Peso pesado”:
    /*
    Escreva um método que receba por parâmetro o tipo e categoria de um dinossauro 
    e retorne o dinossauro (objeto) mais pesado do tipo e da categoria.*/

        return listaDinossauros[0]; 
    } 

    public double relatorioQtdDeCarne(){
  /* Relatório “Quantidade de carne para carnívoros”:
Cada carnívoro come um valor relacionado ao seu peso e de acordo com sua categoria. 
Raças de pequeno porte comem cerca de 10% de seu peso por dia. 
Raças de médio porte comem cerca de 15% de seu peso por dia. 
Raças de grande porte comem cerca de 20$ de seu peso por dia. 
O método deve retornar à quantidade (em Kg) de carne que 
deve ser comprado no mês (considere o mês por 30 dias).*/
        return 0.0; 

    }

    public boolean relatorioDaTempoDeFugir(int id, double distanciaDinoBunker, double distanciaPessoaBunker){

        /*Relatório “Dá tempo de fugir?”:
        Esse relatório, devido aos últimos acidentes, é considerado de extrema importância.
        Considera-se que, para corridas curtas em situação de extremo desespero, uma pessoa consiga correr em média a 20km/h. Sabemos que alguns dinossauros são corredores natos. Assim, as cercas para observação são construídas a determinada distância do dinossauro e bunkers de proteção são instalados próximo as cercas para pessoas se abrigarem em caso de fuga do animal.
        Crie um método que peça por parâmetro: o Iddodinossauro.
        o Distância entre o dinossauro e o bunker (em km). o Distância entre a pessoa e o bunker (em km).
        Seu método deverá retornar verdadeiro quando o tempo que a pessoa leva para correr até o bunker é menor que o tempo que o dinossauro leva para correr a mesma distância. Caso contrário, deve retornar falso.
        A fórmula para o cálculo do tempo é tempo = distância/velocidade. */
        return true;
    }

    public Dinossauro[] relatorioTop10(){
        /*Relatório “Top 10 mais velozes”:
    Escreva um método que retorna 
    um vetor contendo os 10 dinossauros mais velozes ordenados 
    em ordem decrescente de velocidade (maior primeiro).*/
        Dinossauro oi [] = new Dinossauro [10];
        return oi;
    }

    


  

}