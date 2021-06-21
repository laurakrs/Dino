/*Implemente uma classe CadastroDinossauro que armazena uma lista de dinossauros na forma de
um vetor com tamanho máximo 100 posições. Esta classe deve conter os seguintes métodos */


public class CadastroDinossauro{

    Dinossauro ListaDinossauros [] = new Dinossauro [100];

    int dinosOcupados = 0; 

    public boolean adicionarDinoussauro(Dinossauro dino){ 
        //public boolean adicionarDinossauro(Dinossauro dino): 
        //adiciona um objeto Dinossauro na última posição disponível no vetor. 
        //Retorna true em caso de sucesso ou false caso o vetor já esteja cheio.
        return true;

    }

    public Dinossauro pesquisarDinossauro(int id){
        //public Dinossauro pesquisarDinossauro(int id): 
        //pesquisa no vetor por um objeto Dinossauro com o id recebido como parâmetro. 
        //Se não encontrar, retorna null;

        for(int i=0; i < dinosOcupados ; i++){
            if(ListaDinossauros[i].getId() == id){
                return ListaDinossauros[i];
            }
        }
        return null; //acho que vai retornar null sempre???
    }
    
    public boolean removerDinossauro(int id){
        
        //remove do vetor o objeto Dinossauro que contém o id indicado. 
        //Retorna true em caso de sucesso ou false se não encontrar o objeto.*/
        for(int i = 0; i < dinosOcupados ; i++){
            if(ListaDinossauros[i].getId() == id){
                ListaDinossauros[i].toString(); //remover o dino 
                // reordenar o vetor
                return true; 
            }
        }
        return true;

    }

    public String relatorioQtdAnimais(){ //Relatório “Quantidade de animais de cada tipo e categoria”:
         /*   O método deve retornar uma String na qual devem aparecer as informações referentes a
        quantidade de animais para cada tipo e categoria.
        Exemplo: Carnívoros: PP: 52, MP: 20, GP: 12. Herbívoros: PP: 68, MP: 38, GP: 30.*/
        return "oi";
    }
   
    public Dinossauro relatorioPesoPesado(int tipo, int categoria){ //Relatório “Peso pesado”:
    /*
    Escreva um método que receba por parâmetro o tipo e categoria de um dinossauro 
    e retorne o dinossauro (objeto) mais pesado do tipo e da categoria.*/

        return ListaDinossauros[0]; 
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