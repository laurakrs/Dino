public class Report{

    private CadastroDinossauro cadastro; 

    public Report(CadastroDinossauro cadastro){

        this.cadastro = cadastro; 
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


       for(int i = 0; i < this.cadastro.getProxPosicao(); i++){ //Nossa que confusao mas funcionou!!!!
           if(this.cadastro.getListaDinossauros()[i].getCategoria() == 1){ //Pequeno porte
               if(this.cadastro.getListaDinossauros()[i].getTipo() == 1){//carnivoro
                   carnivorosPP++;
               } else{
                   herbivorosPP++;//herbivoro
               }
           } else if(this.cadastro.getListaDinossauros()[i].getCategoria() == 2){//Medio porte
               if(this.cadastro.getListaDinossauros()[i].getTipo() == 1){//carnivoro
                   carnivorosMP++;
               } else{
                   herbivorosMP++;//herbivoro
               }
           } else{// 3 Grande Porte
               if(this.cadastro.getListaDinossauros()[i].getTipo() == 1){//carnivoro
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

       for(int i = 0; i < this.cadastro.getProxPosicao() ; i++){
           if(this.cadastro.getListaDinossauros()[i].getTipo() == tipo){
               if(this.cadastro.getListaDinossauros()[i].getCategoria() == categoria){
                   if(this.cadastro.getListaDinossauros()[i].getPeso() > maiorPeso){
                       maiorPeso = this.cadastro.getListaDinossauros()[i].getPeso();
                       idMaisPesado = i; 
                   } 
               }
               
           }
       }
       if (maiorPeso == 0.0) {
           System.out.println("Ainda não há dinossauros desse tipo e categoria.");
           return null;
       } else {
           return this.cadastro.getListaDinossauros()[idMaisPesado]; 
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

       for(int i = 0; i < this.cadastro.getProxPosicao(); i++){
           if(this.cadastro.getListaDinossauros()[i].getTipo() == 1){//carnivoro
               if(this.cadastro.getListaDinossauros()[i].getCategoria() == 1){ //pequeno porte
                   totalCarne = totalCarne + (this.cadastro.getListaDinossauros()[i].getPeso() * 0.10 * 30);
               } else if(this.cadastro.getListaDinossauros()[i].getCategoria() == 2){//Medio porte
                   totalCarne = totalCarne + (this.cadastro.getListaDinossauros()[i].getPeso() * 0.15 * 30);
               } else{// 3 Grande Porte
                   totalCarne = totalCarne + (this.cadastro.getListaDinossauros()[i].getPeso() * 0.20 * 30);
               }
           }
       }


       return totalCarne; 

   }

   public boolean relatorioDaTempoDeFugir(int idDino, double distanciaDinoBunker, double distanciaPessoaBunker){
      
       double tempoDinossauro = 0.0;
       double tempoPessoa = 0.0;
       double veloDino = 0.0;
       

       
       for(int i=0; i < this.cadastro.getProxPosicao(); i++){
            if(this.cadastro.getListaDinossauros()[i].getId() == idDino){
                veloDino = this.cadastro.getListaDinossauros()[i].getVelocidade();
                
        }
    }

       tempoDinossauro = (distanciaDinoBunker / veloDino);
       tempoPessoa = (distanciaPessoaBunker / 20);

           if (tempoPessoa > tempoDinossauro) {
               return false;
           } else if (tempoPessoa < tempoDinossauro) {
               return true;
            } else {
               System.out.println("O tempo que a pessoa e o dinossauro levam até o bunker é o mesmo.");
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
        Dinossauro vetorNovo[]  = new Dinossauro[tamanho];

        for(int i = 0; i < tamanho; i++){
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
 


}



