import javax.swing.*;

public class Cadastro {
    private String [] nomes = new String[5];
    private int[] senhas = new int[5];
    private int  quantidade = 0 ;

    public Cadastro () {}

    public void cadastrar() {
        if (quantidade >= 5 ) {
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
    
    public String buscarNome(String nome) {
        if (quantidade == 0) {
            return "Nenhum cadastro realizado!";
        }
        
        for (int i = 0; i < quantidade; i++) {
            if (nomes[i].equalsIgnoreCase(nome)) {
            return nomes[i];
            }
        }
        return "Nome não encontrado!";
    }
    
    public int buscarSenha(int senha) {
    
        for (int i = 0; i < quantidade; i++) {
            if (senhas[i] == senha) {
                return i;
            }
        }
        return -1;
    }

    public void classificarPorNome() {
        String auxNome = "";
        int auxSenha = 0;
        boolean troca = true;
        
        while (troca) {
            troca = false;
            
            for (int j = 0; j < quantidade - 1; j++) {
                if (nomes[j].compareToIgnoreCase(nomes[j + 1]) > 0) {
                    auxNome = nomes[j];
                    nomes[j] = nomes[j + 1];
                    nomes[j + 1] = auxNome;
                    
                    auxSenha = senhas[j];
                    senhas[j] = senhas[j + 1];
                    senhas[j + 1] = auxSenha;
                    
                    troca = true;
                }
            }
        }
        
        String mensagem = "";
        
        for (int i = 0; i < quantidade; i++) {
            mensagem += "Nome: " + nomes[i]
                    + " | Senha: " + senhas[i] + "\n";
        }
        
        JOptionPane.showMessageDialog(null, mensagem);
        
    }
    
    
     public void classificarPorSenha() {
        String auxNome = "";
        int auxSenha = 0;
        boolean troca = true;
        
        while (troca) {
            troca = false;
            
            for (int j = 0; j < quantidade - 1; j++) {
                if (senhas[j] > senhas[j + 1]) {
                    auxSenha = senhas[j];
                    senhas[j] = senhas[j + 1];
                    senhas[j + 1] = auxSenha;
                    
                    auxNome = nomes[j];
                    nomes[j] = nomes[j + 1];
                    nomes[j + 1] = auxNome;
                    
                    troca = true;
                }
            }
        }
        
        String mensagem = "";
        
        for (int i = 0; i < quantidade; i++) {
            mensagem += "Nome: " + nomes[i]
                    + " | Senha: " + senhas[i] + "\n";
        }
        
        JOptionPane.showMessageDialog(null, mensagem);
        
    }
}
