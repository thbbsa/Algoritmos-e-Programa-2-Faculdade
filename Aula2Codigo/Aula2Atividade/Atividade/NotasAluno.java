import javax.swing.*;

public class NotasAluno {
    public int n; // total máximo de alunos;
    public Aluno list_alunos [];
    public int indice = -1;

    public NotasAluno(int totalAlunos ) {
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
        NotasAluno l1 = null;

        int op;
        do {
            op = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "MENU\n" +
                                    "1 - Definir quantidade de alunos\n" +
                                    "2 - Inserir Aluno\n" +
                                    "3 - Listar alunos \n" +
                                    "4- Sair\n\n" +
                                    "Escolha uma opção:"
                    )
            );

            switch (op) {
                case 1:
                    String totstr = JOptionPane.showInputDialog(null, "Quantos Alunos tem ?");
                    int tot = Integer.parseInt(totstr);
                    l1 = new NotasAluno(tot);

                    JOptionPane.showMessageDialog(
                            null,
                            "Quantidade definida para " + tot + " alunos!"
                    );
                    break;
                case 2:
                    if (l1 == null) {
                        JOptionPane.showMessageDialog(null, "Primeiro precisa definir a quantidade!");
                    }
                    String nome = JOptionPane.showInputDialog(
                            null,
                            "Nome do aluno:"
                    );

                    double p1 = Double.parseDouble(
                            JOptionPane.showInputDialog(
                                    null,
                                    "Nota P1:"
                            )
                    );

                    double p2 = Double.parseDouble(
                            JOptionPane.showInputDialog(
                                    null,
                                    "Nota P2:"
                            )
                    );

                    double ado = Double.parseDouble(
                            JOptionPane.showInputDialog(
                                    null,
                                    "Nota ADO:"
                            )
                    );

                    l1.setAlunos(nome, p1, p2, ado);

                    break;

                case 3:
                    if (l1 == null) {
                        JOptionPane.showMessageDialog(null, "Primeiro precisa definir a quantidade!");
                    } else {
                        l1.listar();
                    }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Programa Encerrado!");
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
            }
        } while (op != 4);
    }
}
