import java.util.Scanner;
public class App
{
   public static void main(String args[]){
   
   Scanner in = new Scanner(System.in);
   boolean check = true;
   String opcao1; 

   System.out.println("Bem-vindo ao Jurassic Zoo!");
   
   while (check){
   System.out.println("Menu de opcoes: \nEntre com a opcao desejada: \n1 - Cadastro \n2 - Relatorio");
      opcao1 = in.nextLine();
      switch(opcao1){
         case "1"://Menu de cadastros
            check = false;
            break;
         case "2": //Menu de relatorios
            check = false;
            break;
         default:
            System.out.println("Entrada invalida. Tente novamente.");
            continue;
      }
   }
 
} 
}