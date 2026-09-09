import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        CadastroUsuario cadastro = new CadastroUsuario();

        int opcao;

        do {

            opcao = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            null,
                            "MENU - ADO 1\n\n" +
                                    "1 - Ler nome e senha numérica\n" +
                                    "2 - Listar nomes e senhas\n" +
                                    "3 - Buscar nome de forma sequencial\n" +
                                    "4 - Buscar senha de forma sequencial\n" +
                                    "5 - Classificar por nome (Bubble Sort)\n" +
                                    "6 - Classificar por senha (Bubble Sort)\n" +
                                    "7 - Finalizar\n\n" +
                                    "Digite uma opção:"
                    )
            );

            switch (opcao) {

                case 1:
                    cadastro.cadastrar();
                    break;

                case 2:
                    cadastro.listar();
                    break;

                case 3:
                    cadastro.buscarNome();
                    break;

                case 4:
                    cadastro.buscarSenha();
                    break;

                case 5:
                    cadastro.ordenarPorNome();
                    break;

                case 6:
                    cadastro.ordenarPorSenha();
                    break;

                case 7:
                    JOptionPane.showMessageDialog(
                            null,
                            "Programa finalizado!"
                    );
                    break;

                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Opção inválida!"
                    );
            }

        } while (opcao != 7);
    }
}
