import javax.swing.*;

public class Cadastro {
    private String [] nomes = new String[5];
    private int[] senhas = new int[5];
    private int  quantidade = 0 ;

    public Cadastro () {}

    public void cadastrar() {
        if (quantidade > 5 ) {
            JOptionPane.showMessageDialog(null, "Cadastro cheio!");
            return;
        }
        nomes[quantidade] = JOptionPane.showInputDialog(null, "Digite o seu nome: ");

        senhas[quantidade] = Integer.parseInt(
                JOptionPane.showInputDialog("Digite a senha:")
        );

        quantidade++;

        JOptionPane.showMessageDialog(null, "Cadastro realizado!");
    }

    public void listarNomesESenhas() {
        if (quantidade == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum cadastro realizado!");
            return;
        }

        String mensagem = "";

        for (int i = 0; i < quantidade; i++) {
            mensagem += "Nome: " + nomes[i] +
                    " | Senha: " + senhas[i] + "\n";
        }

        JOptionPane.showMessageDialog(null, mensagem);
    }
}
