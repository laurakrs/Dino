import java.util.Scanner;
public class App
{
   public static void main(String args[]){
   
   Scanner in = new Scanner(System.in);
   boolean check = true;
   boolean check2 = true;
   String opcao1; 
   String opcao2;

   System.out.println("Bem-vindo ao Jurassic Zoo!");
   
   while (check){
   System.out.println("Menu de opcoes: \nEntre com a opcao desejada: \n1 - Cadastro \n2 - Relatorio");
      opcao1 = in.nextLine();
      switch(opcao1){
         case "1"://Menu de cadastros
            while(check2){
               System.out.println("Menu de cadastros: \nEntre com a opcao desejada: \n1 - Adicionar dinossauro \n2 - Pesquisar dinossauro \n3 - Remover dinossauro ");
               opcao2 = in.nextLine();
               switch(opcao2){
                  case "1": //Adicionar dino
                     //CadastroDinossauro.adicionarDinossauro();
                     check2 = false;
                     break;
                  case "2": //Pesquisar dino
                     //CadastroDinossauro.pesquisarDinossauro();
                     check2 = false;
                     break;
                  case "3": //Remover dino
                     //CadastroDinossauro.removerDinossauro();
                     check2 = false;

                     break; 
                  default: 
                     System.out.println("Entrada invalida. Tente novamente.");
                     continue;
               }
         }
            check = false;
            break;
         case "2": //Menu de relatorios
            while(check2) {
               System.out.println("Menu de relatorios: \nEntre com a opcao desejada: \n1 - Quantidade de animais de cada tipo e categoria \n2 - Peso Pesado \n3 - Quantidade de carne para carnívoros \n4 - Dá tempo de fugir? \n5 - Top 10 mais velozes");
               opcao2 = in.nextLine();
               switch(opcao2){
                  case "1": //QTD de animais de cada tipo e categoria

                     //CadastroDinossauro.relatorioQtdAnimais();
                     check2 = false;
                     break;
                  case "2": //Peso pesado
                     //CadastroDinossauro.relatorioPesoPesado();
                     check2 = false;
                     break;
                  case "3": //QTD de carne
                     //CadastroDinossauro.relatorioQtdDeCarne();
                     check2 = false;
                     break; 
                  case "4": //tempo de fugir
                     //CadastroDinossauro.relatorioDaTempoDeFugir();
                     check2 = false;
                     break;
                  case "5": //top 10
                     //CadastroDinossauro.relatorioTop10();
                     check2 = false;
                     break;
                  default: 
                     System.out.println("Entrada invalida. Tente novamente.");
                     continue;
               }

            }
            check = false;
            break;
         default:
            System.out.println("Entrada invalida. Tente novamente.");
            continue;
      }
   }
 
} 
}