import java.util.Scanner;
//import java.util.Arrays;

public class App
{
   public static void main(String args[]){
   
   Scanner in = new Scanner(System.in);
   boolean running = true;
   boolean running2 = true;
   String opcao1; 
   String opcao2;

   

   CadastroDinossauro cadastroDinossauro1 = new CadastroDinossauro(); 
   Report report1 = new Report(cadastroDinossauro1); //se for assim acho que tem que inicializar um report e associá-lo ao cadastro né :(

   Dinossauro dino1 = new Dinossauro(1, "Tiranossauro Rex", 1, 1, 10.0, 10.0); 
   Dinossauro dino2 = new Dinossauro(2, "Galinha", 2, 3, 15.0, 35.0); 
   Dinossauro dino3 = new Dinossauro(3, "Laura", 2, 2, 30.0, 30.0); 

   cadastroDinossauro1.adicionarDinossauro(dino1);
   cadastroDinossauro1.adicionarDinossauro(dino2);
   cadastroDinossauro1.adicionarDinossauro(dino3);
 
   
   

   System.out.println("Bem-vindo ao Jurassic Zoo!");


   cadastroDinossauro1.imprimeLista();
   //System.out.println(cadastroDinossauro1.getListaDinossauros()[1].toString());



   
   while (running){
   System.out.println("\nMenu de opcoes: \nEntre com a opcao desejada: \n1 - Cadastro \n2 - Relatorio \n3 - Sair");
      opcao1 = in.nextLine(); 
      switch(opcao1){
         case "1"://Menu de cadastros 
            running2 = true; 
            while(running2){
               System.out.println("\nMenu de cadastros: \nEntre com a opcao desejada:");
               System.out.println("1 - Adicionar dinossauro \n2 - Pesquisar dinossauro \n3 - Remover dinossauro \n4 - Voltar ");
               opcao2 = in.nextLine();
               switch(opcao2){
                  case "1": //Adicionar dino. Pedir entradas do usuário

                     int id = 0; 
                     String nome = ""; 
                     int tipo = 0; 
                     int categoria = 0; 
                     double peso = 0.0;
                     double velocidade = 0.0; 
                     boolean confereAdicionaDino = true;


                     System.out.println("Vamos adicionar um novo dinossauro!");

                     while(confereAdicionaDino){
                     System.out.println("Número de identificacao do dinossauro: "); //int
                     id = Integer.parseInt(in.nextLine()); 
                     if(cadastroDinossauro1.pesquisarDinossauro(id) != null){
                        System.out.println("Já existe um dinossauro com esse ID. Tente novamente. "); 
                        continue;
                     }

                     System.out.println("Nome da raca: "); //String
                     nome = in.nextLine(); 

                     System.out.println("Tipo - Digite 1 para carnívoros e 2 para herbívoros: "); //int
                     tipo = Integer.parseInt(in.nextLine());
                     if(cadastroDinossauro1.verificaTipo(tipo) == false){
                        continue;
                     }
                     

                     System.out.println("Categoria - Digite 1 para Pequeno Porte, 2 para Medio Porte e 3 para Grande Porte: "); //int
                     categoria = Integer.parseInt(in.nextLine());
                     if(cadastroDinossauro1.verificaCategoria(categoria) == false){
                        continue;
                     } 

                     System.out.println("Peso em kg: ");  //double
                     peso = Double.parseDouble(in.nextLine());
                     if(cadastroDinossauro1.verificaEntradaPositiva(peso) == false){
                        continue;
                     }

                     System.out.println("Velocidade maxima em km/h: "); //velocidade
                     velocidade = Double.parseDouble(in.nextLine());
                     if(cadastroDinossauro1.verificaEntradaPositiva(velocidade) == false){
                        continue;
                     }

                     Dinossauro novoDino = new Dinossauro(id, nome, tipo, categoria, peso, velocidade);
                     cadastroDinossauro1.adicionarDinossauro(novoDino);
                     confereAdicionaDino = false;
                     cadastroDinossauro1.imprimeLista();

                     
                     }
                     running2 = false; //queremos voltar pro menu geral ou pro menu de cadastros
                    break;
                     
                  case "2": //Pesquisar dino
                     int search_id = 0;

                     System.out.println("Qual é o numero de identificacao do dinossauro que voce deseja pesquisar? ");
                     search_id = Integer.parseInt(in.nextLine());
                     System.out.println(cadastroDinossauro1.pesquisarDinossauro(search_id));  
                     break;

                  case "3": //Remover dino
                     System.out.println("Qual é o numero de identificacao do dinossauro que voce deseja remover? ");
                     id = Integer.parseInt(in.nextLine());
                     System.out.println(cadastroDinossauro1.removerDinossauro(id));
                     cadastroDinossauro1.imprimeLista();
                     break; 

                  case "4": //Voltar
                     running2 = false;
                     continue;

                  default: 
                     System.out.println("Entrada invalida. Tente novamente.");
                     continue;
               }
         }
            //check2 = false;
            continue;

         case "2": //Menu de relatorios
            running2 = true;
            while(running2) {
               System.out.println("Menu de relatorios: \nEntre com a opcao desejada: \n1 - Quantidade de animais de cada tipo e categoria \n2 - Peso Pesado \n3 - Quantidade de carne para carnívoros \n4 - Dá tempo de fugir? \n5 - Top 10 mais velozes \n6 - Voltar");
               opcao2 = in.nextLine();
               switch(opcao2){
                  case "1": //QTD de animais de cada tipo e categoria
                     //System.out.println(cadastroDinossauro1.relatorioQtdAnimais()); DECIDIR!
                     System.out.println(report1.relatorioQtdAnimais());
                     running2 = false;
                     break;
                  case "2": //Peso pesado
                     int tipoPesado;
                     int categoriaPesado; 
                     System.out.println("Bem vindo ao Peso Pesado. Qual é o tipo? 1 - Carnívoros ou 2 - Herbívoros");
                     tipoPesado = Integer.parseInt(in.nextLine());
                     System.out.println("Qual é a categoria? 1 - PP; 2 - MP; 3 - GP");
                     categoriaPesado = Integer.parseInt(in.nextLine());
                     System.out.println("O dinossauro mais pesado é" + cadastroDinossauro1.relatorioPesoPesado(tipoPesado, categoriaPesado));
                     running2 = false; 
                     break;
                  case "3": //QTD de carne
                     System.out.println("A qtd de carne necessaura é" + cadastroDinossauro1.relatorioQtdDeCarne());
                     continue; 

                  case "4": //tempo de fugir

                  int idDino;
                  double distanciaDinoBunker = 0;
                  double distanciaPessoaBunker = 0;
                  
                  System.out.println("Bem vindo ao Da tempo de fugir?. Escolha um dos dinossauros abaixo inserindo o seu ID:\n");
                  cadastroDinossauro1.imprimeLista();
                  idDino = Integer.parseInt(in.nextLine());

                  System.out.println("Qual é distância (em KM) do dinossauro até o bunker? \n");
                  distanciaDinoBunker = Double.parseDouble(in.nextLine());
                  
                  System.out.println("Qual é distância (em KM) da pessoa até o bunker? \n");
                  distanciaPessoaBunker = Double.parseDouble(in.nextLine());

                  System.out.println(report1.relatorioDaTempoDeFugir(idDino, distanciaDinoBunker, distanciaPessoaBunker));
                  
               break;

                  case "5": //top 10
                  //to testando o quicksort aqui e ta funcionandooo!!! so preciso aprender a colocar dentro do top10 
                  Dinossauro vetorOrdenado [] = new Dinossauro [cadastroDinossauro1.getProxPosicao()];
                  vetorOrdenado = report1.quickSort(cadastroDinossauro1.getListaDinossauros(), 0, cadastroDinossauro1.getProxPosicao()-1);
                  //vetorOrdenado = cadastroDinossauro1.relatorioTop10(cadastroDinossauro1.getListaDinossauros(), cadastroDinossauro1.getProxPosicao()-1);  
                 
                 
                  System.out.println("\n Vetor Ordenado");
                  for (int i = 0; i < cadastroDinossauro1.getProxPosicao(); i++) {  
                        System.out.println(" " + vetorOrdenado[i]);  
                  }  

                  System.out.println("Vetor antigo : ");
                  for (int i = 0; i < cadastroDinossauro1.getProxPosicao(); i++) {  
                     System.out.println(" " + cadastroDinossauro1.getListaDinossauros()[i]);  
               }  

                     //CadastroDinossauro1.relatorioTop10();
                     running2 = false;
                     break;

                  case "6": //voltar
                     running2 = false;
                     //check = true;
                     continue;
                  default: 
                     System.out.println("Entrada invalida. Tente novamente.");
                     continue;
               }

            }
            continue;

         case "3": //Sair
            System.out.println("Saindo...");
            running = false;
            break;

         default:
            System.out.println("Entrada invalida. Tente novamente.");
            continue;

            
            

             
         }
   }
   in.close();
}
}

