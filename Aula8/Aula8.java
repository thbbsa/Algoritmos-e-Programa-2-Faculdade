
package Aula8;

import javax.swing.JOptionPane;

public class Aula8 {

    public static int potRecur(int b, int e) {
        if (e == 0) {
            return 1;
        }
        return b * potRecur(b, e - 1);
    }

    public static int potIter(int b, int e) {
        int potencia = 1;

        for (int i = 1; i <= e; i++) {
            potencia *= b;
        }

        return potencia;
    }

    public static int somaInt(int x, int y) {
        if (x == y) {
            return y;
        }
        return x + somaInt(x + 1, y);
    }

    public static int somaIter(int x, int y) {
        int soma = 0;

        for (int i = x; i <= y; i++) {
            soma += i;
        }

        return soma;
    }

    public static double somaReais(double[] lista, int x, int y) {
        if (x == y) {
            return lista[x];
        }
        return lista[x] + somaReais(lista, x + 1, y);
    }

    public static int fatoDuplo(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fatoDuplo(n - 2);
    }

    public static String gerarFibo(int a, int b, int limite) {
        if (a > limite) {
            return "";
        }

        return a + " " + gerarFibo(b, a + b, limite);
    }

    public static void main(String[] args) {
        int opcao = -1;

        while (opcao != 0) {
            String entrada = JOptionPane.showInputDialog(
                    "===== MENU DE RECURSIVIDADE =====\n\n"
                            + "1 - Potenciacao recursiva e iterativa\n"
                            + "2 - Soma de inteiros recursiva e iterativa\n"
                            + "3 - Soma de numeros reais de uma lista\n"
                            + "4 - Fatorial duplo\n"
                            + "5 - Fibonacci\n"
                            + "0 - Sair\n\n"
                            + "Escolha uma opcao:"
            );

            if (entrada == null) {
                break;
            }

            try {
                opcao = Integer.parseInt(entrada);

                switch (opcao) {
                    case 1:
                        int b = Integer.parseInt(
                                JOptionPane.showInputDialog("Digite a base:")
                        );

                        int e = Integer.parseInt(
                                JOptionPane.showInputDialog("Digite o expoente:")
                        );

                        if (e < 0) {
                            JOptionPane.showMessageDialog(
                                    null, "Expoente deve ser nao negativo."
                            );
                            break;
                        }

                        JOptionPane.showMessageDialog(
                                null,
                                "Potencia recursiva: " + potRecur(b, e)
                                        + "\nPotencia iterativa: " + potIter(b, e)
                        );
                        break;

                    case 2:
                        int x = Integer.parseInt(
                                JOptionPane.showInputDialog("Digite x:")
                        );

                        int y = Integer.parseInt(
                                JOptionPane.showInputDialog("Digite y:")
                        );

                        if (x > y) {
                            JOptionPane.showMessageDialog(
                                    null, "x deve ser menor ou igual a y."
                            );
                            break;
                        }

                        JOptionPane.showMessageDialog(
                                null,
                                "Soma recursiva: " + somaInt(x, y)
                                        + "\nSoma iterativa: " + somaIter(x, y)
                        );
                        break;

                    case 3:
                        int tamanho = Integer.parseInt(
                                JOptionPane.showInputDialog(
                                        "Quantos numeros tera a lista?"
                                )
                        );

                        if (tamanho <= 0) {
                            JOptionPane.showMessageDialog(
                                    null, "Quantidade invalida."
                            );
                            break;
                        }

                        double[] lista = new double[tamanho];

                        for (int i = 0; i < tamanho; i++) {
                            String valor = JOptionPane.showInputDialog(
                                    "Digite o numero da posicao " + i + ":"
                            );
                            lista[i] = Double.parseDouble(
                                    valor.replace(",", ".")
                            );
                        }

                        int inicio = Integer.parseInt(
                                JOptionPane.showInputDialog(
                                        "Digite a posicao inicial x:"
                                )
                        );

                        int fim = Integer.parseInt(
                                JOptionPane.showInputDialog(
                                        "Digite a posicao final y:"
                                )
                        );

                        if (inicio < 0 || fim >= tamanho || inicio > fim) {
                            JOptionPane.showMessageDialog(
                                    null, "Posicoes invalidas."
                            );
                            break;
                        }

                        JOptionPane.showMessageDialog(
                                null,
                                "Soma dos numeros reais: "
                                        + somaReais(lista, inicio, fim)
                        );
                        break;

                    case 4:
                        int n = Integer.parseInt(
                                JOptionPane.showInputDialog(
                                        "Digite um numero para o fatorial duplo:"
                                )
                        );

                        if (n < 0) {
                            JOptionPane.showMessageDialog(
                                    null, "Digite um numero nao negativo."
                            );
                            break;
                        }

                        JOptionPane.showMessageDialog(
                                null,
                                "Fatorial duplo de " + n + " = " + fatoDuplo(n)
                        );
                        break;

                    case 5:
                        int limite = Integer.parseInt(
                                JOptionPane.showInputDialog(
                                        "Digite o limite de Fibonacci:"
                                )
                        );

                        if (limite < 0) {
                            JOptionPane.showMessageDialog(
                                    null, "Limite invalido."
                            );
                            break;
                        }

                        JOptionPane.showMessageDialog(
                                null,
                                "Serie de Fibonacci:\n"
                                        + gerarFibo(0, 1, limite)
                        );
                        break;

                    case 0:
                        JOptionPane.showMessageDialog(
                                null, "Programa encerrado."
                        );
                        break;

                    default:
                        JOptionPane.showMessageDialog(
                                null, "Opcao invalida."
                        );
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        null, "Digite um numero valido."
                );
            }
        }
    }
}
