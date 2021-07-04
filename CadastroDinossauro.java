
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
        return false; 

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

