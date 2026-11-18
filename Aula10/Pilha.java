package Aula10;

import javax.swing.*;

public class Pilha {
    /* Atributo topo */
    public RegPilha topo;
    public int cont;
    Pilha() {topo = null; cont = 0;}

    public void push( Object dado ) {
        RegPilha newRegPilha = new RegPilha ();
        newRegPilha.dado = dado;
        if ( topo == null ) {
            newRegPilha.ant = null;
        } else {
            newRegPilha.ant = topo;
        }
        topo = newRegPilha ;
    }

    public void pop () {
        if ( topo == null) return;
        /*Armazena o topo para excluir depois*/
        RegPilha temp = topo;
        /* topo será o objeto anterior do temp */
        topo = temp.ant;
        /* apaga o temp que guardou o topo anterior*/
        temp = null;
    }

    public void plotar() {
        if ( topo == null ) return;
        String saida = "";
        RegPilha temp = topo;

        while ( temp != null ) {
            saida += temp.dado + "\n";
            temp = temp.ant;
        }
        JOptionPane.showMessageDialog(null,saida);
    }

    public void destruir(RegPilha temp) {
        if (temp == null) {
            topo = null;
            cont = 0;
            return;
        }

        destruir(temp.ant);
        temp = null;
    }

    public static void main(String[] args) {
        Pilha pil = new Pilha ();

        int op = Integer.parseInt(JOptionPane.showInputDialog(
                "**** MENU PILHA HEAP ****\n1 - Push\n2 - Pop\n3 - Plotar\n4 - Destruir\n5 - Sair"
        ));

        while (op != 5) {
            switch (op) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Digite um nome: ");
                    pil.push(nome);
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