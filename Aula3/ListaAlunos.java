import javax.swing.*;

public class ListaAlunos {
    public int n; // total máximo de alunos;
    public Aluno list_alunos [];
    public int indice = -1;

    public ListaAlunos( int totalAlunos ) {
        this.n = totalAlunos; // seta o total de alunos
        this.list_alunos = new Aluno[this.n]; // criar a lista
        this.indice = -1; // ainda n tem alunos
    }

    public void setAlunos(String nome, double p1, double p2, double ado) {
        if (indice >= n) return; // filtro de total maximo de alunos

        this.indice++; // cria um espaço no vetor indice = indice + 1
        this.list_alunos[indice] = new Aluno();
        this.list_alunos[indice].nome = nome;
        this.list_alunos[indice].p1 = p1;
        this.list_alunos[indice].p2 = p2;
        this.list_alunos[indice].ado = ado;
    }

    public void listar() {
        String saida = "";

        for (Aluno aluno : list_alunos) {
            saida += aluno.nome + " - " + aluno.p1 + " - " + aluno.p2 + " - " + aluno.ado+"\n";
        }

        JOptionPane.showMessageDialog(null, saida);
    }

    public static void main(String[] args) {
        String totstr = JOptionPane.showInputDialog(null, "Quantos Alunos tem ?");
        int tot = Integer.parseInt(totstr);

        ListaAlunos l1 = new ListaAlunos(2);
        l1.setAlunos("Eliseu", 10, 5, 5);
        l1.setAlunos("Sara", 5, 6, 7);

        l1.listar();
    }
}
