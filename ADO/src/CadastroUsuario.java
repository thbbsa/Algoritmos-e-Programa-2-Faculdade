import javax.swing.JOptionPane;

public class CadastroUsuario {

    private String[] nomes = new String[5];
    private int[] senhas = new int[5];
    private int quantidade = 0;

    // Opção 1 - Ler nome e senha
    public void cadastrar() {

        if (quantidade >= 5) {
            JOptionPane.showMessageDialog(
                    null,
                    "Cadastro cheio! Limite de 5 pessoas."
            );
            return;
        }

        nomes[quantidade] = JOptionPane.showInputDialog(
                null,
                "Digite o nome:"
        );

        senhas[quantidade] = Integer.parseInt(
                JOptionPane.showInputDialog(
                        null,
                        "Digite a senha numérica:"
                )
        );

        quantidade++;

        JOptionPane.showMessageDialog(
                null,
                "Nome e senha cadastrados com sucesso!"
        );
    }

    // Opção 2 - Listar nomes e senhas lado a lado
    public void listar() {

        if (quantidade == 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "Nenhum cadastro realizado!"
            );
            return;
        }

        String mensagem = "NOME\t\tSENHA\n\n";

        for (int i = 0; i < quantidade; i++) {
            mensagem += nomes[i] + "\t\t" + senhas[i] + "\n";
        }

        JOptionPane.showMessageDialog(
                null,
                mensagem
        );
    }

    // Opção 3 - Buscar nome de forma sequencial
    public void buscarNome() {

        if (quantidade == 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "Nenhum cadastro realizado!"
            );
            return;
        }

        String nomeBusca = JOptionPane.showInputDialog(
                null,
                "Digite o nome que deseja buscar:"
        );

        boolean encontrado = false;

        for (int i = 0; i < quantidade; i++) {

            if (nomes[i].equalsIgnoreCase(nomeBusca)) {

                JOptionPane.showMessageDialog(
                        null,
                        "Nome encontrado!\n\n" +
                                "Nome: " + nomes[i] + "\n" +
                                "Senha: " + senhas[i] + "\n" +
                                "Posição: " + i
                );

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(
                    null,
                    "Nome não encontrado!"
            );
        }
    }

    // Opção 4 - Buscar senha de forma sequencial
    public void buscarSenha() {

        if (quantidade == 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "Nenhum cadastro realizado!"
            );
            return;
        }

        int senhaBusca = Integer.parseInt(
                JOptionPane.showInputDialog(
                        null,
                        "Digite a senha que deseja buscar:"
                )
        );

        boolean encontrado = false;

        for (int i = 0; i < quantidade; i++) {

            if (senhas[i] == senhaBusca) {

                JOptionPane.showMessageDialog(
                        null,
                        "Senha encontrada!\n\n" +
                                "Nome: " + nomes[i] + "\n" +
                                "Senha: " + senhas[i] + "\n" +
                                "Posição: " + i
                );

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(
                    null,
                    "Senha não encontrada!"
            );
        }
    }

    // Opção 5 - Classificar por nome usando Bubble Sort
    public void ordenarPorNome() {

        if (quantidade == 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "Nenhum cadastro realizado!"
            );
            return;
        }

        String auxNome;
        int auxSenha;

        for (int i = 0; i < quantidade - 1; i++) {

            for (int j = 0; j < quantidade - 1 - i; j++) {

                if (nomes[j].compareToIgnoreCase(nomes[j + 1]) > 0) {

                    // Troca os nomes
                    auxNome = nomes[j];
                    nomes[j] = nomes[j + 1];
                    nomes[j + 1] = auxNome;

                    // Troca as senhas junto com os nomes
                    auxSenha = senhas[j];
                    senhas[j] = senhas[j + 1];
                    senhas[j + 1] = auxSenha;
                }
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "Nomes classificados em ordem alfabética!"
        );
    }

    // Opção 6 - Classificar senhas usando Bubble Sort
    public void ordenarPorSenha() {

        if (quantidade == 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "Nenhum cadastro realizado!"
            );
            return;
        }

        String auxNome;
        int auxSenha;

        for (int i = 0; i < quantidade - 1; i++) {

            for (int j = 0; j < quantidade - 1 - i; j++) {

                if (senhas[j] > senhas[j + 1]) {

                    // Troca as senhas
                    auxSenha = senhas[j];
                    senhas[j] = senhas[j + 1];
                    senhas[j + 1] = auxSenha;

                    // Troca os nomes junto com as senhas
                    auxNome = nomes[j];
                    nomes[j] = nomes[j + 1];
                    nomes[j + 1] = auxNome;
                }
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "Senhas classificadas em ordem crescente!"
        );
    }
}
