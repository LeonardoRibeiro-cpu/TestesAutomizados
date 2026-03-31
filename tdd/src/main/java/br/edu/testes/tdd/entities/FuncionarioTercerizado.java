
package br.edu.testes.tdd.entities;


class FuncionarioTercerizado extends Funcionario{
    private double despesasAdicionais;
    FuncionarioTercerizado(String nome) {
        super(nome);
    }
    
    @Override
    public double calcularPagamento() {
        double salarioDespesas = super.calcularPagamento();
        salarioDespesas = salarioDespesas - despesasAdicionais;
        return  salarioDespesas;
    }

    public void setDespesasAdicionais(double despesasAdicionais) {
        if(despesasAdicionais > 1000.00){
        throw new IllegalArgumentException("Despesa adicional não pode ser acima de R$ 1000.00");
        }
        
        if(despesasAdicionais < 0){
            throw new IllegalArgumentException("Despesa adicional não pode ser um número negativo");
        }
        this.despesasAdicionais = despesasAdicionais;
    }


}
