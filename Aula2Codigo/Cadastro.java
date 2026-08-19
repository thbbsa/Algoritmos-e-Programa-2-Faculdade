package Aula2Codigo;

import javax.swing.JOptionPane;

public class Cadastro {

    public static void main(String args[]) {

        String nome = JOptionPane.showInputDialog(null, "Nome:");

        String p1str = JOptionPane.showInputDialog(null, "Digite N1:");

        double p1 = Double.parseDouble(p1str);

        Aluno2 a1 = new Aluno2();

        a1.setNome(nome);
        a1.setP1(p1);

        JOptionPane.showMessageDialog(
                null,
                a1.getNome() + " " + a1.getP1()
        );

        Aluno2 a2 = new Aluno2("Eliseu", 10, 10, 10);

        String saida = String.format(
                "%s sua média é %.2f",
                a2.getNome(),
                a2.getMedia()
        );

        JOptionPane.showMessageDialog(null, saida);
    }
}