
public class CadastroDinossauro{



    public static final int TOTAL_DINOS = 100; 

    private Dinossauro [] ListaDinossauros;
    private int proxPosicao; 


    public CadastroDinossauro(){
        this.ListaDinossauros = new Dinossauro [TOTAL_DINOS];
        this.proxPosicao = 0;
       
    }

    public Dinossauro[] getListaDinossauros(){
        return this.ListaDinossauros;
    }

    public int getProxPosicao(){
        return this.proxPosicao;
    }

    public boolean adicionarDinossauro(Dinossauro dino){ 

        // Adiciona um objeto Dinossauro na última posição disponível no vetor. 
        // Retorna true em caso de sucesso ou false caso o vetor já esteja cheio.
        if(this.proxPosicao == TOTAL_DINOS){
            System.out.println("\nO vetor de dinossauros já está cheio! Não é possível adicionar mais dinossauros.\n");
            return false;
        }else{
            this.ListaDinossauros[proxPosicao] = dino;
            this.proxPosicao++;
            System.out.println("\nSucesso! Dinossauro adicionado!\n");
            return true;
        }
    }

    public Dinossauro pesquisarDinossauro(int id){

        // Pesquisa no vetor por um objeto Dinossauro com o ID recebido como parametro
        // Se não encontrar, retorna null;

        for(int i=0; i < this.proxPosicao ; i++){
            if(this.ListaDinossauros[i].getId() == id){
                return this.ListaDinossauros[i];
            }
        }
        return null; 
    }
    
    public boolean removerDinossauro(int id){
        
        // Remove do vetor o objeto Dinossauro que contém o id indicado. 
        // Retorna true em caso de sucesso ou false se não encontrar o objeto.*/
        for(int i = 0; i < this.proxPosicao ; i++){
            if(this.ListaDinossauros[i].getId() == id){
                this.ListaDinossauros[i] = null;
                for(int j = i+1; j < this.proxPosicao; j++){ 
                    this.ListaDinossauros[j-1] = this.ListaDinossauros[j]; 
                }
                this.proxPosicao = this.proxPosicao - 1; 
                return true; 
            }
        }
        return false; 

    }

    public boolean verificaEntradaPositiva(double valor){

        if(valor <= 0){
            System.out.println("Valor inválido. Digite uma valor maior do que 0. \n");
            return false;
        } else{
            return true;
        }
    }

    public boolean verificaTipo(int tipo){
        if(tipo != 1 && tipo != 2){
            System.out.println("Tipo de dinossauro inválido. Digite 1 para carnivoros e 2 para herbivoros. Tente novamente.\n");
            return false;
        } else{
            return true;
        }
    }

    public boolean verificaCategoria(int categoria){
        if (categoria != 1 && categoria != 2 && categoria != 3){
            System.out.println("Categoria de dinossauro inválido. Digite 1 para PP, 2 para MP e 3 para GP. Tente novamente.\n");
            return false;
        } else{
            return true;
        }
    }

    public void imprimeLista(){
        for(int i = 0; i < this.proxPosicao; i++){
            System.out.println(this.ListaDinossauros[i]);
            
        }
         
    }
    public String toString(){
        return (this.ListaDinossauros.toString());
    
    }

}

