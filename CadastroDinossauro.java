import jdk.javadoc.internal.tool.resources.javadoc_zh_CN;

/*Implemente uma classe CadastroDinossauro que armazena uma lista de dinossauros na forma de
um vetor com tamanho máximo 100 posições. Esta classe deve conter os seguintes métodos */


public class CadastroDinossauro{



    public static final int TOTAL_DINOS = 100; 

    private Dinossauro [] ListaDinossauros;
    private int proxPosicao; 


    public CadastroDinossauro(){
        this.ListaDinossauros = new Dinossauro [TOTAL_DINOS];
        this.proxPosicao = 0;
       
    }

    public boolean adicionarDinossauro(Dinossauro dino){ 
        //public boolean adicionarDinossauro(Dinossauro dino): 
        //adiciona um objeto Dinossauro na última posição disponível no vetor. 
        //Retorna true em caso de sucesso ou false caso o vetor já esteja cheio.
        if(this.proxPosicao == TOTAL_DINOS){
            System.out.println("O vetor de dinossauros já está cheio! Não é possível adicionar mais dinossauros.");
            return false;
        }else{
            this.ListaDinossauros[proxPosicao] = dino;
            this.proxPosicao++;
            System.out.println("Sucesso! Dinossauro adicionado!");
            return true;
        }
    }

    public Dinossauro pesquisarDinossauro(int id){ //o que significa esse static que eu coloquei aqui pra fucnionar?
        //public Dinossauro pesquisarDinossauro(int id): 
        //pesquisa no vetor por um objeto Dinossauro com o id recebido como parâmetro. 
        //Se não encontrar, retorna null;

        for(int i=0; i < proxPosicao ; i++){
            if(ListaDinossauros[i].getId() == id){
                return ListaDinossauros[i];
            }
        }
        return null; //será que vai retornar null sempre??? Espero que não! Testar
    }
    
    public boolean removerDinossauro(int id){
        
        //remove do vetor o objeto Dinossauro que contém o id indicado. 
        //Retorna true em caso de sucesso ou false se não encontrar o objeto.*/
        for(int i = 0; i < this.proxPosicao ; i++){
            if(ListaDinossauros[i].getId() == id){
                ListaDinossauros[i] = null;
                // reordenar o vetor. qual forma de reordenar vamos escolher? todo mundo depois do ListaDinossauros[i] tem que andar um pra trás
                for(int j = i+1; j < proxPosicao; j++){ //fiz uma loucura aqui que acho que não funciona
                    ListaDinossauros[j-1] = ListaDinossauros[j]; //não deve estar certo 
                }
                this.proxPosicao = this.proxPosicao - 1; 
                return true; 
            }
        }
        return false; ////será que vai retornar false sempre??? Espero que não! Testar. Não encontrou o objeto

    }

    public String relatorioQtdAnimais(){ //Relatório “Quantidade de animais de cada tipo e categoria”:
         /*   O método deve retornar uma String na qual devem aparecer as informações referentes a
        quantidade de animais para cada tipo e categoria.
        Exemplo: Carnívoros: PP: 52, MP: 20, GP: 12. Herbívoros: PP: 68, MP: 38, GP: 30.*/
        String listaFinal = " ";
        int carnivorosPP = 0;
        int carnivorosMP = 0;
        int carnivorosGP = 0; 
        int herbivorosPP = 0;
        int herbivorosMP = 0;
        int herbivorosGP = 0;


        for(int i = 0; i < proxPosicao; i++){
            if(ListaDinossauros[i].getCategoria() == 1){ //Pequeno porte
                if(ListaDinossauros[i].getTipo() == 1){//carnivoro
                    carnivorosPP++;
                } else{
                    herbivorosPP++;//herbivoro
                }
            } else if(ListaDinossauros[i].getCategoria() == 2){//Medio porte
                if(ListaDinossauros[i].getTipo() == 1){//carnivoro
                    carnivorosMP++;
                } else{
                    herbivorosMP++;//herbivoro
                }
            } else{// 3 Grande Porte
                if(ListaDinossauros[i].getTipo() == 1){//carnivoro
                    carnivorosGP++;
                } else{
                    herbivorosGP++;//herbivoro
                }
            }
         }

        listaFinal = "Carnivoros: PP: " + carnivorosPP + ", MP: " + carnivorosMP + ", GP: " + carnivorosGP + ". Herbivoros: PP: " + herbivorosPP + ", MP: " + herbivorosMP + ", GP: " + herbivorosGP;
        
        return listaFinal;
    }
   
    public Dinossauro relatorioPesoPesado(int tipo, int categoria){ //Relatório “Peso pesado”:
    /*
    Escreva um método que receba por parâmetro o tipo e categoria de um dinossauro 
    e retorne o dinossauro (objeto) mais pesado do tipo e da categoria.*/

        int idMaisPesado = 0; 
        double maiorPeso = 0.0; 

        for(int i = 0; i < proxPosicao ; i++){
            if(ListaDinossauros[i].getTipo() == tipo){
                if(ListaDinossauros[i].getCategoria() == categoria){
                    if(ListaDinossauros[i].getPeso() > maiorPeso){
                        maiorPeso = ListaDinossauros[i].getPeso();
                        idMaisPesado = i; 
                    } 
                }
                
            }
        }
        if (maiorPeso == 0.0) {
            System.out.println("Ainda não há dinossauros desse tipo e categoria.");
            return null;
        } else {
            return ListaDinossauros[idMaisPesado]; 
        }
    } 

    public double relatorioQtdDeCarne(){
  /* Relatório “Quantidade de carne para carnívoros”:
Cada carnívoro come um valor relacionado ao seu peso e de acordo com sua categoria. 
Raças de pequeno porte comem cerca de 10% de seu peso por dia. 
Raças de médio porte comem cerca de 15% de seu peso por dia. 
Raças de grande porte comem cerca de 20$ de seu peso por dia. 
O método deve retornar à quantidade (em Kg) de carne que 
deve ser comprado no mês (considere o mês por 30 dias).*/

        double totalCarne = 0.0; 

        for(int i = 0; i < proxPosicao; i++){
            if(ListaDinossauros[i].getTipo() == 1){//carnivoro
                if(ListaDinossauros[i].getCategoria() == 1){ //pequeno porte
                    totalCarne = totalCarne + (ListaDinossauros[i].getPeso() * 0.10 * 30);
                } else if(ListaDinossauros[i].getCategoria() == 2){//Medio porte
                    totalCarne = totalCarne + (ListaDinossauros[i].getPeso() * 0.15 * 30);
                } else{// 3 Grande Porte
                    totalCarne = totalCarne + (ListaDinossauros[i].getPeso() * 0.20 * 30);
                }
            }
        }


        return totalCarne; 

    }

    public boolean relatorioDaTempoDeFugir(int id, double distanciaDinoBunker, double distanciaPessoaBunker,boolean fugiu, int i){
       
        double tempoDinossauro = 0.0;
        double tempoPessoa = 0.0;

        distanciaDinoBunker = 0.0; //vamos pedir pro usuário essas infos?
        distanciaPessoaBunker = 0.0;

        System.out.println("Escolha um dinossauro abaixo pelo ID:");

        for( i = 0; i < proxPosicao ; i++){
               System.out.println(ListaDinossauros);
            }

        tempoDinossauro = (distanciaDinoBunker / (ListaDinossauros[i].getVelocidade()));
        tempoPessoa = (distanciaPessoaBunker / 20);

            if (tempoPessoa > tempoDinossauro) {
                fugiu = false;
                return false;
            } else if (tempoPessoa < tempoDinossauro) {
                fugiu = true;
                return true;
             } else {
                System.out.println("O tempo que a pessoa e o dinossauro levam até o bunker é o mesmo.");
                fugiu = false;
                return false;
            }
        }
        
            
    
        /*Relatório “Dá tempo de fugir?”:
        Esse relatório, devido aos últimos acidentes, é considerado de extrema importância.
        Considera-se que, para corridas curtas em situação de extremo desespero, uma pessoa consiga correr em média a 20km/h. Sabemos que alguns dinossauros são corredores natos. Assim, as cercas para observação são construídas a determinada distância do dinossauro e bunkers de proteção são instalados próximo as cercas para pessoas se abrigarem em caso de fuga do animal.
        Crie um método que peça por parâmetro: o Iddodinossauro.
        o Distância entre o dinossauro e o bunker (em km). o Distância entre a pessoa e o bunker (em km).
        Seu método deverá retornar verdadeiro quando o tempo que a pessoa leva para correr até o bunker é menor que o tempo que o dinossauro leva para correr a mesma distância. Caso contrário, deve retornar falso.
        A fórmula para o cálculo do tempo é tempo = distância/velocidade. */
    

    public Dinossauro[] relatorioTop10(Dinossauro vetor[], int tamanho){
        /*Relatório “Top 10 mais velozes”:
    Escreva um método que retorna  um vetor contendo os 10 dinossauros mais velozes ordenados em ordem decrescente de velocidade (maior primeiro).*/
    
        Dinossauro top10 [] = sort(vetor, tamanho);
        //Ordenar o vetor em relacao a velocidade dos dinos e aí imprimir os 10 primeiros 
        
        return top10;
    }

    public Dinossauro [] sort(Dinossauro vetor[], int tamanho){
        Dinossauro vetorNovo[]  = new Dinossauro[proxPosicao];

        for(int i = 0; i < proxPosicao; i++){
            vetorNovo[i] = vetor[i];
        }

        return quickSort (vetorNovo, 0, tamanho);
    } 

    public Dinossauro[] quickSort (Dinossauro vetorNovo[], int esquerda, int direita){

        int esq = esquerda;
        int dir = direita; 
        double pivo = vetorNovo[(esq + dir) / 2].getVelocidade();  
        Dinossauro troca;  
  
        while (esq <= dir) {  
            while (vetorNovo[esq].getVelocidade() > pivo) {  
                esq = esq + 1;  
            }  
            while (vetorNovo[dir].getVelocidade() < pivo) {  
                dir = dir - 1;  
            }  
            if (esq <= dir) {  
                troca = vetorNovo[esq];  
                vetorNovo[esq] = vetorNovo[dir];  
                vetorNovo[dir] = troca;  
                esq = esq + 1;  
                dir = dir - 1;  
            }  
        }  
        if (dir > esquerda)  
            quickSort(vetorNovo, esquerda, dir);  
  
        if (esq < direita)  
            quickSort(vetorNovo, esq, direita);  

        return vetorNovo;     
    }
 

    public boolean verificaEntradaPositiva(double valor){

        if(valor <= 0){
            System.out.println("Valor inválido. Digite uma valor maior do que 0. ");
            return false;
        } else{
            return true;
        }
    }

    public boolean verificaTipo(int tipo){
        if(tipo != 1 && tipo != 2){
            System.out.println("Tipo de dinossauro inválido. Digite 1 para carnivoros e 2 para herbivoros. Tente novamente.");
            return false;
        } else{
            return true;
        }
    }

    public boolean verificaCategoria(int categoria){
        if (categoria != 1 && categoria != 2 && categoria != 3){ //categoria errada 
            System.out.println("Categoria de dinossauro inválido. Digite 1 para PP, 2 para MP e 3 para GP. Tente novamente.");
            return false;
        } else{
            return true;
        }
    }
  
    public Dinossauro[] getListaDinossauros(){
        return this.ListaDinossauros;
    }

    public int getProxPosicao(){
        return this.proxPosicao;
    }

    public void imprimeLista(){
        for(int i = 0; i < proxPosicao; i++){
            System.out.println(this.ListaDinossauros[i]);
            
        }
         
    }


    public String toString(){
        return (this.ListaDinossauros.toString());
    
    }

}