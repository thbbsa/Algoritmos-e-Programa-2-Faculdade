package Aula2Codigo;

public class Aluno {

    public String nome;
    public double[] notas;
    public double media = 0;

    // Construtor vazio
    public Aluno() {
    }

    // Construtor com nome
    public Aluno(String nome) {
        this.nome = nome;
    }

    // Construtor com notas
    public Aluno(double[] notas) {
        this.notas = notas;
    }

    // Método para calcular a média
    public double getMedia() {
        for (double x : notas) {
            media += x;
        }

        return media / notas.length;
    }

    public static void main(String[] args) {

        double notas[] = {10, 7, 4.4};

        // Cria um aluno usando o construtor com nome
        Aluno c1 = new Aluno("Eliseu");

        c1.notas = notas;

        System.out.println("Sua media: " + c1.getMedia());

        // Cria um aluno usando o construtor com notas
        Aluno c2 = new Aluno(notas);

        System.out.println("Sua media: " + c2.getMedia());
    }
}