
package br.edu.testes.tdd.entities;


public class Funcionario {
    private String nome;
    private int horasTrabalhadas;
    private static final double SALARIO_MINIMO = 1518.00;
    private double valorHora;
    public Funcionario(String nome) {
        this.nome = nome;
    }
    public double calcularPagamento() {
        double salario = (horasTrabalhadas * valorHora)*4;
        if(salario < SALARIO_MINIMO){
           throw new IllegalArgumentException("Salario abaixo do minimo");
        }
        if(salario > 10000.00){
            throw new IllegalArgumentException("Salario acima do permitido");
        }
        return salario;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        if(horasTrabalhadas < 5 || horasTrabalhadas > 40){
            throw new IllegalArgumentException("O numero de horas de um funcionario tem que ser maior ou igual a 5 e menor ou igual a 40");
        }
        this.horasTrabalhadas = horasTrabalhadas;
    }

   
    public void setValorHora(double valorHora) {
        double minimo = (SALARIO_MINIMO * 1) / 100.0;
        double maximo = (SALARIO_MINIMO * 10) / 100.0;
    
        if (valorHora < minimo|| valorHora > maximo) {
            throw new IllegalArgumentException("O valor de horas trabalhadas tem que ser no minimo 1% do salario minimo e no maximo 10%");
        }
        this.valorHora = valorHora;
    }

}
