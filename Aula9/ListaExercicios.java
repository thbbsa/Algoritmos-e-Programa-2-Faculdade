package Aula9;

public class ListaExercicios {
    public static void listarNumerosDivisiveisPorTres(int x, int y) {
        if (x > y) {
            return;
        }
        if (x % 3 == 0) {
            System.out.println("Numero divisivel por 3: " + x);
        }

        listarNumerosDivisiveisPorTres(x + 1, y);
    }


    public static void listarNumerosNaoDivisiveisPorDoisETres(int x, int y) {
        if (x > y) {
            return;
        }
        if (x % 2 != 0 && x % 3 != 0) {
            System.out.println("Numero nao divisivel por 2 e 3: " + x);
        }

        listarNumerosNaoDivisiveisPorDoisETres(x + 1, y);
    }

    public static double mediaSequencia(int n) {
        if (n < 0) {
            return 0;
        }
        return (double) somaSequencia(n) / (n + 1);
    }


    private static int somaSequencia(int n) {
        if (n == 0) {
            return 0;
        }
        return n + somaSequencia(n - 1);
    }

    public static void main(String[] args) {
        listarNumerosDivisiveisPorTres(5, 20);
        listarNumerosNaoDivisiveisPorDoisETres(1, 15);
        System.out.println(mediaSequencia(4));
    }
}
