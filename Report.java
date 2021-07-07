
public class Report {

    private CadastroDinossauro cadastro;

    public Report(CadastroDinossauro cadastro) {

        this.cadastro = cadastro;
    }

    public String relatorioQtdAnimais() { // Relatório “Quantidade de animais de cada tipo e categoria”:

        String listaFinal = " ";
        int carnivorosPP = 0;
        int carnivorosMP = 0;
        int carnivorosGP = 0;
        int herbivorosPP = 0;
        int herbivorosMP = 0;
        int herbivorosGP = 0;

        for (int i = 0; i < this.cadastro.getProxPosicao(); i++) { 
            if (this.cadastro.getListaDinossauros()[i].getCategoria() == 1) { // Pequeno porte
                if (this.cadastro.getListaDinossauros()[i].getTipo() == 1) {// Carnivoro
                    carnivorosPP++;
                } else {
                    herbivorosPP++;// Herbivoro
                }
            } else if (this.cadastro.getListaDinossauros()[i].getCategoria() == 2) {// Medio porte
                if (this.cadastro.getListaDinossauros()[i].getTipo() == 1) {// Carnivoro
                    carnivorosMP++;
                } else {
                    herbivorosMP++;// Herbivoro
                }
            } else {// 3 Grande Porte
                if (this.cadastro.getListaDinossauros()[i].getTipo() == 1) {// Carnivoro
                    carnivorosGP++;
                } else {
                    herbivorosGP++;// Herbivoro
                }
            }
        }

        listaFinal = "Carnivoros: PP: " + carnivorosPP + ", MP: " + carnivorosMP + ", GP: " + carnivorosGP
                + ". Herbivoros: PP: " + herbivorosPP + ", MP: " + herbivorosMP + ", GP: " + herbivorosGP;

        return listaFinal;
    }

    public Dinossauro relatorioPesoPesado(int tipo, int categoria) { // Relatório “Peso pesado”:

        int idMaisPesado = 0;
        double maiorPeso = 0.0;

        for (int i = 0; i < this.cadastro.getProxPosicao(); i++) {
            if (this.cadastro.getListaDinossauros()[i].getTipo() == tipo) {
                if (this.cadastro.getListaDinossauros()[i].getCategoria() == categoria) {
                    if (this.cadastro.getListaDinossauros()[i].getPeso() > maiorPeso) {
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

    public double relatorioQtdDeCarne() {

        double totalCarne = 0.0;

        for (int i = 0; i < this.cadastro.getProxPosicao(); i++) {
            if (this.cadastro.getListaDinossauros()[i].getTipo() == 1) {// Carnivoro
                if (this.cadastro.getListaDinossauros()[i].getCategoria() == 1) { // Pequeno porte
                    totalCarne = totalCarne + (this.cadastro.getListaDinossauros()[i].getPeso() * 0.10 * 30);
                } else if (this.cadastro.getListaDinossauros()[i].getCategoria() == 2) {// Medio porte
                    totalCarne = totalCarne + (this.cadastro.getListaDinossauros()[i].getPeso() * 0.15 * 30);
                } else {// 3 Grande Porte
                    totalCarne = totalCarne + (this.cadastro.getListaDinossauros()[i].getPeso() * 0.20 * 30);
                }
            }
        }

        return totalCarne;

    }

    public boolean relatorioDaTempoDeFugir(int idDino, double distanciaDinoBunker, double distanciaPessoaBunker) {

        double tempoDinossauro = 0.0;
        double tempoPessoa = 0.0;
        double veloDino = 0.0;

        for (int i = 0; i < this.cadastro.getProxPosicao(); i++) {
            if (this.cadastro.getListaDinossauros()[i].getId() == idDino) {
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

    public Dinossauro[] relatorioTop10(Dinossauro vetor[], int tamanho) {

        Dinossauro topVelozes[] = sort(vetor, tamanho);
        Dinossauro top10[] = new Dinossauro[10];

        if (this.cadastro.getProxPosicao() >= 10) { //se tem mais de 10
            for (int i = 0; i < 10; i++) {
                top10[i] = topVelozes[i];
            }
            return top10;
        } else { //se tem menos de 10
            return topVelozes;  
        }

    }

    public Dinossauro[] sort(Dinossauro vetor[], int tamanho) {
        Dinossauro vetorNovo[] = new Dinossauro[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetorNovo[i] = vetor[i];
        }

        tamanho = tamanho - 1;

        return quickSort(vetorNovo, 0, tamanho);
    }

    public Dinossauro[] quickSort(Dinossauro vetorNovo[], int esquerda, int direita) {

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
