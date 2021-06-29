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


       for(int i = 0; i < this.cadastro.getProxPosicao(); i++){ //Nossa que confusao
           if(this.cadastro.getListaDinossauros()[i].getCategoria() == 1){ //Pequeno porte
               if(this.cadastro.getListaDinossauros()[i].getTipo() == 1){//carnivoro
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
   

   public Dinossauro[] relatorioTop10(){
       /*Relatório “Top 10 mais velozes”:
   Escreva um método que retorna  um vetor contendo os 10 dinossauros mais velozes ordenados em ordem decrescente de velocidade (maior primeiro).*/
       Dinossauro top10 [] = new Dinossauro [10];
       //Ordenar o vetor em relacao a velocidade dos dinos e aí imprimir os 10 primeiros 

           

       return top10;
   }

   public Dinossauro[] quickSort (Dinossauro vetor[], int esquerda, int direita){
       
       Dinossauro vetorNovo[]  = new Dinossauro[proxPosicao];

       vetorNovo = vetor; 

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