import java.util.Scanner;

public class App {
   public static void main(String args[]) {

      Scanner in = new Scanner(System.in);
      boolean running = true;
      boolean running2 = true;
      String opcao1;
      String opcao2;

      CadastroDinossauro cadastroDinossauro1 = new CadastroDinossauro();
      Report report1 = new Report(cadastroDinossauro1);

      Dinossauro dino1 = new Dinossauro(1, "Tiranossauro Rex", 1, 3, 6000.0, 72.0);
      Dinossauro dino2 = new Dinossauro(2, "Velociraptor", 1, 1, 90.0, 100.0);
      Dinossauro dino3 = new Dinossauro(3, "Estegossauro", 2, 2, 4000.0, 15.0);
      Dinossauro dino4 = new Dinossauro(4, "Triceratops", 2, 2, 8000.0, 32.0);
      Dinossauro dino5 = new Dinossauro(5, "Braquiossauro", 2, 3, 80000.0, 20.0);
      Dinossauro dino6 = new Dinossauro(6, "Pterodactilo", 1, 1, 2.0, 1.0);
      Dinossauro dino7 = new Dinossauro(7, "Alossauro", 1, 3, 2000.0, 55.0);
      Dinossauro dino8 = new Dinossauro(8, "Giganotossauro", 1, 3, 8200.0, 50.0);
      Dinossauro dino9 = new Dinossauro(9, "Anquilossauro", 2, 2, 9000.0, 8.0);

      cadastroDinossauro1.adicionarDinossauro(dino1);
      cadastroDinossauro1.adicionarDinossauro(dino2);
      cadastroDinossauro1.adicionarDinossauro(dino3);
      cadastroDinossauro1.adicionarDinossauro(dino4);
      cadastroDinossauro1.adicionarDinossauro(dino5);
      cadastroDinossauro1.adicionarDinossauro(dino6);
      cadastroDinossauro1.adicionarDinossauro(dino7);
      cadastroDinossauro1.adicionarDinossauro(dino8);
      cadastroDinossauro1.adicionarDinossauro(dino9);

      System.out.println("\nBem-vindo ao Jurassic Zoo!\n");

      System.out.println("Esses são os dinossauros que já fazem parque do parque: \n");
      cadastroDinossauro1.imprimeLista();

      while (running) {
         System.out
               .println("\nMenu de opcoes: \nEntre com a opcao desejada: \n1 - Adicionar, remover ou pesquisar um dinossauro \n2 - Relatorios \n3 - Sair");
         opcao1 = in.nextLine();
         switch (opcao1) {
            case "1":// Menu de opções
               running2 = true;
               while (running2) {
                  System.out.println("\nMenu de cadastros: \nEntre com a opcao desejada:");
                  System.out.println(
                        "1 - Adicionar dinossauro \n2 - Pesquisar dinossauro \n3 - Remover dinossauro \n4 - Voltar ");
                  opcao2 = in.nextLine();
                  switch (opcao2) {
                     case "1": // Adicionar dinossauro

                        int id = 0;
                        String nome = "";
                        int tipo = 0;
                        int categoria = 0;
                        double peso = 0.0;
                        double velocidade = 0.0;
                        boolean confereAdicionaDino = true;

                        System.out.println("\nVamos adicionar um novo dinossauro!\n");

                        while (confereAdicionaDino) {
                           System.out.println("Número de identificacao do dinossauro: \n"); // Tipo: int
                           id = Integer.parseInt(in.nextLine());
                           if (cadastroDinossauro1.pesquisarDinossauro(id) != null) {
                              System.out.println("Já existe um dinossauro com esse ID. Tente novamente. \n");
                              continue;
                           }

                           System.out.println("Nome da raca: \n"); // Tipo: String
                           nome = in.nextLine();

                           System.out.println("Tipo - Digite 1 para carnívoros e 2 para herbívoros: \n"); // Tipo: int
                           tipo = Integer.parseInt(in.nextLine());
                           if (cadastroDinossauro1.verificaTipo(tipo) == false) {
                              continue;
                           }

                           System.out.println(
                                 "Categoria - Digite 1 para Pequeno Porte, 2 para Medio Porte e 3 para Grande Porte: \n"); // Tipo: int
                           categoria = Integer.parseInt(in.nextLine());
                           if (cadastroDinossauro1.verificaCategoria(categoria) == false) {
                              continue;
                           }

                           System.out.println("Peso em kg: \n"); // Tipo: double
                           peso = Double.parseDouble(in.nextLine());
                           if (cadastroDinossauro1.verificaEntradaPositiva(peso) == false) {
                              continue;
                           }

                           System.out.println("Velocidade maxima em km/h: \n"); // Tipo: double
                           velocidade = Double.parseDouble(in.nextLine());
                           if (cadastroDinossauro1.verificaEntradaPositiva(velocidade) == false) {
                              continue;
                           }

                           Dinossauro novoDino = new Dinossauro(id, nome, tipo, categoria, peso, velocidade);
                           cadastroDinossauro1.adicionarDinossauro(novoDino);
                           confereAdicionaDino = false;
                           cadastroDinossauro1.imprimeLista();

                        }
                        running2 = false;
                        break;

                     case "2": // Pesquisar dinossauro
                        int search_id = 0;

                        System.out
                              .println("Qual é o numero de identificacao do dinossauro que voce deseja pesquisar? \n");
                        search_id = Integer.parseInt(in.nextLine());
                        System.out.println(cadastroDinossauro1.pesquisarDinossauro(search_id));
                        running2 = false;
                        break;

                     case "3": // Remover dinossauro
                        System.out.println("Qual é o numero de identificacao do dinossauro que voce deseja remover? \n");
                        id = Integer.parseInt(in.nextLine());
                        System.out.println("\n" + cadastroDinossauro1.removerDinossauro(id) + "\n");
                        System.out.println("Esses são os dinossauros que seguem cadastrados no banco de dados do parque: \n");
                        cadastroDinossauro1.imprimeLista();
                        running2 = false;
                        break;

                     case "4": // Voltar
                        running2 = false;
                        continue;

                     default:
                        System.out.println("Entrada invalida. Tente novamente.\n");
                        continue;
                  }
               }

               continue;

            case "2": // Menu de relatorios
               running2 = true;
               while (running2) {
                  System.out.println(
                        "\nMenu de relatorios: \nEntre com a opcao desejada: \n1 - Quantidade de animais de cada tipo e categoria \n2 - Peso Pesado \n3 - Quantidade de carne para carnívoros \n4 - Dá tempo de fugir? \n5 - Top 10 mais velozes \n6 - Voltar\n");
                  opcao2 = in.nextLine();
                  switch (opcao2) {
                     case "1": // Relatório 'Quantidade de animais de cada tipo e categoria'
                        System.out.println(report1.relatorioQtdAnimais());
                        running2 = false;
                        break;
                     case "2": // Relatório 'Peso pesado'
                        int tipoPesado;
                        int categoriaPesado;
                        System.out.println("Bem vindo ao relatório 'Peso Pesado'. Qual é o tipo? 1 - Carnívoros ou 2 - Herbívoros\n");
                        tipoPesado = Integer.parseInt(in.nextLine());
                        System.out.println("Qual é a categoria? 1 - PP | 2 - MP | 3 - GP\n");
                        categoriaPesado = Integer.parseInt(in.nextLine());
                        System.out.println(
                              "O dinossauro mais pesado é: " + report1.relatorioPesoPesado(tipoPesado, categoriaPesado));
                        running2 = false;
                        break;
                     case "3": // Relatório 'Quantidade de carne para carnívoros'
                        System.out.println("A quantidade de carne necessária é: " + report1.relatorioQtdDeCarne() + " kg.");
                        running2 = false;
                        break;

                     case "4": // Relatório 'Da tempo de fugir?''

                        int idDino = 0;
                        double distanciaDinoBunker = 0;
                        double distanciaPessoaBunker = 0;
                        boolean checkEntradas = true;

                        while(checkEntradas){
                        System.out.println(
                              "Bem vindo ao relatório 'Da tempo de fugir?'. Escolha um dos dinossauros abaixo inserindo o seu ID:\n");
                        cadastroDinossauro1.imprimeLista();
                        idDino = Integer.parseInt(in.nextLine());

                        if (cadastroDinossauro1.pesquisarDinossauro(idDino) == null) {
                           System.out.println("Não existe dinossauro com esse ID. Tente novamente.\n");
                           continue;
                        }

                        System.out.println("Qual é distância (em km) do dinossauro até o bunker? \n");
                        distanciaDinoBunker = Double.parseDouble(in.nextLine());
                        if (cadastroDinossauro1.verificaEntradaPositiva(distanciaDinoBunker) == false) {
                           continue;
                        }

                        System.out.println("Qual é distância (em km) da pessoa até o bunker? \n");
                        distanciaPessoaBunker = Double.parseDouble(in.nextLine());
                        if (cadastroDinossauro1.verificaEntradaPositiva(distanciaPessoaBunker) == false) {
                           continue;
                        }
                        
                        checkEntradas = false;
                     }

                        System.out.println("A pessoa conseguiu fugir? "
                              + report1.relatorioDaTempoDeFugir(idDino, distanciaDinoBunker, distanciaPessoaBunker));
                        running2 = false;
                        break;

                     case "5": // Relatório 'Top 10 mais velozes'
                        Dinossauro vetorOrdenado[] = new Dinossauro[10];
                        vetorOrdenado = report1.relatorioTop10(cadastroDinossauro1.getListaDinossauros(),
                              cadastroDinossauro1.getProxPosicao());

                        System.out.println("\nVetor Ordenado");
                        for (int i = 0; i < vetorOrdenado.length; i++) {
                           System.out.println(" " + vetorOrdenado[i]);
                        }
                        running2 = false;
                        break;

                     case "6": // Voltar
                        running2 = false;
                        continue;
                     default:
                        System.out.println("Entrada invalida. Tente novamente.");
                        continue;
                  }

               }
               continue;

            case "3": // Sair
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
