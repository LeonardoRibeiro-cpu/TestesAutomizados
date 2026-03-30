package br.edu.testes.tdd.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FuncionarioTercerizadoTeste {
     private FuncionarioTercerizado ft;
    @BeforeEach
    public  void setup(){
      String nome = "Leonardo";
      ft = new FuncionarioTercerizado(nome);
    }


    @Test
    public void testeCalcularSalarioAbaixoDoMinimoComDespesas(){
      int horasTrabalhadas = 5;
      double valorHora = 50.00;
      double despesasAdicionais = 2.00;
      double valorIncorreto = 998.00;
      String mensagemEsperada = "Salario abaixo do minimo";

      ft.setHorasTrabalhadas(horasTrabalhadas);
      ft.setValorHora(valorHora);
      ft.setDespesasAdicionais(despesasAdicionais);

      IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,() ->{
        ft.calcularPagamento();
      });
 
      assertEquals(mensagemEsperada, erro.getMessage());
    }

    @Test
    public void testeCalcularSalarioAcimaDoPermitidoComDespesas(){
      int horasTrabalhadas = 40;
      double valorHora = 80.00;
      double despesasAdicionais = 0;
      double valorIncorreto = 12800.00;
      String mensagemEsperada = "Salario acima do permitido";

      ft.setHorasTrabalhadas(horasTrabalhadas);
      ft.setValorHora(valorHora);
      ft.setDespesasAdicionais(despesasAdicionais);

      IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,() ->{
        ft.calcularPagamento();
      });
 
      assertEquals(mensagemEsperada, erro.getMessage());
    }
   
    @Test
    public void testarSalarioValidoComDespesas(){
      int horasTrabalhadas = 40;
      double valorHora = 50.00;
      double despesasAdicionais = 500.00;
      double valorEsperado = 7500.00;

      ft.setHorasTrabalhadas(horasTrabalhadas);
      ft.setValorHora(valorHora);
      double salarioRecebido = f.calcularPagamento();

      assertEquals(valorEsperado, salarioRecebido);
    }



    @Test
    public void testarSetDespesasAdicionaisAcimaDoLimite(){
        double despesasAdicionais = 1500.00;
        String mensagemEsperada = "Despesa adicional não pode ser acima de R$ 1000.00";

        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, ()->{
        ft.setDespesasAdicionais(despesasAdicionais);
        });

        assertEquals(mensagemEsperada, erro.getMessage());
    }

    @Test
    public void testarSetDespesasAdicionaisNegativa(){
        double despesasAdicionais = -1500.00;
        String mensagemEsperada = "Despesa adicional não pode ser um número negativo";

        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, ()->{
        ft.setDespesasAdicionais(despesasAdicionais);
        });

        assertEquals(mensagemEsperada, erro.getMessage());
    }
}
