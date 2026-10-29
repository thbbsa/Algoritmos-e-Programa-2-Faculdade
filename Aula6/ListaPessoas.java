package Aula6;

import javax.swing.*;

public class ListaPessoas {

    public int n; // total máximo de pessoas
    public Pessoa list_pessoas[];
    public int indice = -1;

    public ListaPessoas(int totalPessoas) {
        this.n = totalPessoas;              // seta o total de pessoas
        this.list_pessoas = new Pessoa[this.n]; // cria a lista
        this.indice = -1;                   // ainda não tem pessoas
    }

    public void setPessoas(String nome, String email, String rg) {
        if (indice >= n - 1) {
            JOptionPane.showMessageDialog(null, "Limite de cadastros atingido!");
            return;
        }

        this.indice++; // abre um espaço no vetor
        this.list_pessoas[indice] = new Pessoa();
        this.list_pessoas[indice].nome = nome;
        this.list_pessoas[indice].email = email;
        this.list_pessoas[indice].rg = rg;
    }

    public void listar() {
        String saida = "";

        for (int i = 0; i <= indice; i++) {
            saida += list_pessoas[i].nome + " - " + list_pessoas[i].email + " - " + list_pessoas[i].rg + "\n";
        }

        JOptionPane.showMessageDialog(null, saida);
    }

    // ---------- Selection Sort por Nome ----------
    public void selectionSortNome() {
        for (int i = 0; i < indice; i++) {
            int menor = i;
            for (int j = i + 1; j <= indice; j++) {
                if (list_pessoas[j].nome.compareToIgnoreCase(list_pessoas[menor].nome) < 0) {
                    menor = j;
                }
            }
            if (menor != i) trocar(i, menor);
        }
    }

    // ---------- Insertion Sort por Nome ----------
    public void insertionSortNome() {
        for (int i = 1; i <= indice; i++) {
            Pessoa temp = list_pessoas[i];
            int j = i - 1;

            while (j >= 0 && list_pessoas[j].nome.compareToIgnoreCase(temp.nome) > 0) {
                list_pessoas[j + 1] = list_pessoas[j];
                j--;
            }
            list_pessoas[j + 1] = temp;
        }
    }

    // ---------- Selection Sort por RG ----------
    public void selectionSortRG() {
        for (int i = 0; i < indice; i++) {
            int menor = i;
            for (int j = i + 1; j <= indice; j++) {
                if (list_pessoas[j].rg.compareTo(list_pessoas[menor].rg) < 0) {
                    menor = j;
                }
            }
            if (menor != i) trocar(i, menor);
        }
    }

    // ---------- Insertion Sort por RG ----------
    public void insertionSortRG() {
        for (int i = 1; i <= indice; i++) {
            Pessoa temp = list_pessoas[i];
            int j = i - 1;

            while (j >= 0 && list_pessoas[j].rg.compareTo(temp.rg) > 0) {
                list_pessoas[j + 1] = list_pessoas[j];
                j--;
            }
            list_pessoas[j + 1] = temp;
        }
    }

    public void trocar(int i, int j) {
        Pessoa temp = list_pessoas[i];
        list_pessoas[i] = list_pessoas[j];
        list_pessoas[j] = temp;
    }

    // ---------- Busca Binária por RG ----------
    public void buscarRG(String rgBusca) {
        if (indice == -1) {
            JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada.");
            return;
        }

        insertionSortRG();

        int inicio = 0;
        int fim = indice;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            int comparacao = list_pessoas[meio].rg.compareTo(rgBusca);

            if (comparacao == 0) {
                JOptionPane.showMessageDialog(null,
                        "Pessoa encontrada!\n" +
                                "Nome : " + list_pessoas[meio].nome + "\n" +
                                "Email: " + list_pessoas[meio].email + "\n" +
                                "RG   : " + list_pessoas[meio].rg);
                return;
            } else if (comparacao < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        JOptionPane.showMessageDialog(null, "RG não encontrado.");
    }

    // ---------- Busca Binária por Nome ----------
    public void buscarNome(String nomeBusca) {
        if (indice == -1) {
            JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada.");
            return;
        }

        insertionSortNome();

        int inicio = 0;
        int fim = indice;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            int comparacao = list_pessoas[meio].nome.compareToIgnoreCase(nomeBusca);

            if (comparacao == 0) {
                JOptionPane.showMessageDialog(null,
                        "Pessoa encontrada!\n" +
                                "Nome : " + list_pessoas[meio].nome + "\n" +
                                "Email: " + list_pessoas[meio].email + "\n" +
                                "RG   : " + list_pessoas[meio].rg);
                return;
            } else if (comparacao < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        JOptionPane.showMessageDialog(null, "Nome não encontrado.");
    }

    public void quickSortEmail() {
        int[] inicio = new int[indice + 1];
        int[] fim = new int[indice + 1];
        int topo = -1;

        if (indice <= 0) return;

        inicio[++topo] = 0;
        fim[topo] = indice;

        while (topo >= 0) {
            int esquerda = inicio[topo];
            int direita = fim[topo--];

            int i = esquerda;
            int j = direita;
            String pivo = list_pessoas[(esquerda + direita) / 2].email;

            while (i <= j) {
                while (list_pessoas[i].email.compareToIgnoreCase(pivo) < 0) i++;
                while (list_pessoas[j].email.compareToIgnoreCase(pivo) > 0) j--;

                if (i <= j) {
                    trocar(i, j);
                    i++;
                    j--;
                }
            }

            if (esquerda < j) {
                inicio[++topo] = esquerda;
                fim[topo] = j;
            }

            if (i < direita) {
                inicio[++topo] = i;
                fim[topo] = direita;
            }
        }
    }


    public void mergeSortRG() {
        if (indice <= 0) return;

        Pessoa[] auxiliar = new Pessoa[indice + 1];

        for (int tamanho = 1; tamanho <= indice; tamanho *= 2) {
            for (int inicio = 0; inicio <= indice - tamanho; inicio += 2 * tamanho) {
                int meio = inicio + tamanho - 1;
                int fim = Math.min(inicio + 2 * tamanho - 1, indice);

                int i = inicio;
                int j = meio + 1;
                int k = inicio;

                while (i <= meio && j <= fim) {
                    if (list_pessoas[i].rg.compareTo(list_pessoas[j].rg) <= 0) {
                        auxiliar[k++] = list_pessoas[i++];
                    } else {
                        auxiliar[k++] = list_pessoas[j++];
                    }
                }

                while (i <= meio) auxiliar[k++] = list_pessoas[i++];
                while (j <= fim) auxiliar[k++] = list_pessoas[j++];

                for (int p = inicio; p <= fim; p++) {
                    list_pessoas[p] = auxiliar[p];
                }
            }

            if (tamanho > indice / 2) break;
        }
    }

    public static void main(String[] args) {

        String totstr = JOptionPane.showInputDialog(null, "Quantas pessoas serão cadastradas?");
        int tot = Integer.parseInt(totstr);

        ListaPessoas lista = new ListaPessoas(tot);

        String opcaoStr;
        int opcao;

        do {
            opcaoStr = JOptionPane.showInputDialog(null,
                    "SISTEMA DE CADASTRO DE PESSOAS\n\n" +
                            "1 - Cadastrar Nome, Email e RG\n" +
                            "2 - Exibir tudo lado a lado\n" +
                            "3 - Classificar por Nome - Selection Sort\n" +
                            "4 - Classificar por Nome - Insertion Sort\n" +
                            "5 - Classificar por RG - Selection Sort\n" +
                            "6 - Classificar por RG - Insertion Sort\n" +
                            "7 - Buscar um RG - Busca Binária\n" +
                            "8 - Buscar um Nome - Busca Binária\n" +
                            "9 - Classificar por Email - QuickSort\n" +
                            "10 - Classificar por RG - MergeSort\n" +
                            "11 - Finalizar programa\n\n" +
                            "Escolha uma opção:");

            opcao = Integer.parseInt(opcaoStr);

            switch (opcao) {

                case 1:
                    String nome = JOptionPane.showInputDialog(null, "Nome completo:");
                    String email = JOptionPane.showInputDialog(null, "E-mail:");
                    String rg = JOptionPane.showInputDialog(null, "RG:");
                    lista.setPessoas(nome, email, rg);
                    JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso!");
                    break;

                case 2:
                    lista.listar();
                    break;

                case 3:
                    lista.selectionSortNome();
                    JOptionPane.showMessageDialog(null, "Nomes classificados com Selection Sort!");
                    lista.listar();
                    break;

                case 4:
                    lista.insertionSortNome();
                    JOptionPane.showMessageDialog(null, "Nomes classificados com Insertion Sort!");
                    lista.listar();
                    break;

                case 5:
                    lista.selectionSortRG();
                    JOptionPane.showMessageDialog(null, "RGs classificados com Selection Sort!");
                    lista.listar();
                    break;

                case 6:
                    lista.insertionSortRG();
                    JOptionPane.showMessageDialog(null, "RGs classificados com Insertion Sort!");
                    lista.listar();
                    break;

                case 7:
                    String rgBusca = JOptionPane.showInputDialog(null, "Digite o RG que deseja buscar:");
                    lista.buscarRG(rgBusca);
                    break;

                case 8:
                    String nomeBusca = JOptionPane.showInputDialog(null, "Digite o nome que deseja buscar:");
                    lista.buscarNome(nomeBusca);
                    break;

                case 9:
                    lista.quickSortEmail();
                    JOptionPane.showMessageDialog(null,
                            "E-mails classificados com QuickSort!");
                    lista.listar();
                    break;

                case 10:
                    lista.mergeSortRG();
                    JOptionPane.showMessageDialog(null,
                            "RGs classificados com MergeSort!");
                    lista.listar();
                    break;

                case 11:
                    JOptionPane.showMessageDialog(null,
                            "Programa finalizado.");
                    break;


                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }

        } while (opcao != 11);
    }
}
