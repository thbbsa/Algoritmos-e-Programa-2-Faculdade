package Media;

import Aula10.Pilha;
import Aula10.RegPilha;

import javax.swing.*;

public class Pilha2 {
    public Media topo;
    public int cont;

    Pilha2() {
        topo = null;
        cont = 0;
    }


    public void push( String nome, double nota1, double nota2 ) {
        Media novo = new Media();

        novo.nome = nome;
        novo.nota1 = nota1;
        novo.nota2 = nota2;
        novo.media = (nota1 + nota2) / 2;

        if ( topo == null ) {
            novo.ant = null;
        } else {
            novo.ant = topo;
        }
        topo = novo ;
    }

    public void pop () {
        if ( topo == null) return;
        /*Armazena o topo para excluir depois*/
        Media temp = topo;
        /* topo será o objeto anterior do temp */
        topo = temp.ant;
        /* apaga o temp que guardou o topo anterior*/
        temp = null;
    }

    public void plotar() {
        if ( topo == null ) return;
        String saida = "";
        Media temp = topo;

        while ( temp != null ) {
            saida += "Nome: " + temp.nome +
                    "\nNota 1: " + temp.nota1 +
                    "\nNota 2: " + temp.nota2 +
                    "\nMédia: " + temp.media + "\n\n";
            temp = temp.ant;
        }
        JOptionPane.showMessageDialog(null,saida);
    }

    public void destruir(Media temp) {
        if (temp == null) {
            topo = null;
            cont = 0;
            return;
        }

        destruir(temp.ant);
        temp = null;
    }

    public static void main(String[] args) {
        Pilha2 pil = new Pilha2 ();

        int op = Integer.parseInt(JOptionPane.showInputDialog(
                "**** MENU PILHA HEAP ****\n1 - Push\n2 - Pop\n3 - Plotar\n4 - Destruir\n5 - Sair"
        ));

        while (op != 5) {
            switch (op) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Digite um nome:");

                    double nota1 = Double.parseDouble(
                            JOptionPane.showInputDialog("Digite a primeira nota:")
                    );

                    double nota2 = Double.parseDouble(
                            JOptionPane.showInputDialog("Digite a segunda nota:")
                    );

                    pil.push(nome, nota1, nota2);
                    break;
                case 2:
                    pil.pop();
                    break;
                case 3:
                    pil.plotar();
                    break;
                case 4:
                    pil.destruir(pil.topo);
            }

            op = Integer.parseInt(JOptionPane.showInputDialog(
                    "**** MENU PILHA HEAP ****\n1 - Push\n2 - Pop\n3 - Plotar\n4 - Destruir\n5 - Sair"
            ));
        }
    }
}
