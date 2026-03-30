package br.edu.testes.tdd.entities;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FuncionarioTeste {
    private Funcionario f;
    @BeforeEach
    public  void setup(){
      String nome = "Leonardo";
      f = new Funcionario(nome);
    }

    @Test
    public void testeCalcularSalarioAbaixoDoMinimo(){
      int horasTrabalhadas = 5;
      double valorHora = 50.00;
      double valorIncorreto = 1000.00;
      String mensagemEsperada = "Salario abaixo do minimo";

      f.setHorasTrabalhadas(horasTrabalhadas);
      f.setValorHora(valorHora);

      IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,() ->{
        f.calcularPagamento();
      })
 
      assertEquals(mensagemEsperada, erro.getMessage());
    }

    @Test
    public void testeCalcularSalarioAcimaDoPermitido(){
      int horasTrabalhadas = 40;
      double valorHora = 80.00;
      double valorIncorreto = 12800.00;
      String mensagemEsperada = "Salario acima do permitido";

      f.setHorasTrabalhadas(horasTrabalhadas);
      f.setValorHora(valorHora);

      IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,() ->{
        f.calcularPagamento();
      })
 
      assertEquals(mensagemEsperada, erro.getMessage());
    }
   
    @Test
    public void testarSalarioValido(){
      int horasTrabalhadas = 40;
      double valorHora = 50.00;
      double valorEsperado = 8000.00;

      f.setHorasTrabalhadas(horasTrabalhadas);
      f.setValorHora(valorHora);
      double salarioRecebido = f.calcularPagamento();

      assertEquals(valorEsperado, salarioRecebido);
    }


    @Test
    public void testarSetHorasTrabalhadasInvalidoAbaixoDoLimite(){
      int horasTrabalhadas = 3;
      String mensagemEsperada = "O numero de horas de um funcionario tem que ser maior ou igual a 5  e menor ou igual a 40";

      IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,()->{
       f.setHorasTrabalhadas(horasTrabalhadas);
      });
      assertEquals(mensagemEsperada, erro.getMessage());
    }


    @Test
    public void testarSetHorasTrabalhadasInvalidoAcimaDoLimite(){
      int horasTrabalhadas = 43;
      String mensagemEsperada = "O numero de horas de um funcionario tem que ser maior ou igual a 5  e menor ou igual a 40";

      IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,()->{
       f.setHorasTrabalhadas(horasTrabalhadas);
      });
      assertEquals(mensagemEsperada, erro.getMessage());
    }


    @Test 
    public void testarSetValorPorHorasInvalidoAbaixoDoMinimo(){
       double valorHora = 5.00;
       String mensagemEsperada = "O valor de horas trabalhadas tem que ser no minimo 1% do salario minimo e no maximo 10%";

       IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,()->{
        f.setValorHora(valorHora);
       });
       assertEquals(mensagemEsperada, erro.getMessage());
    }

    
    @Test 
    public void testarSetValorPorHorasInvalidoAcimaDoLimite(){
       double valorHora = 170.00;
       String mensagemEsperada = "O valor de horas trabalhadas tem que ser no minimo 1% do salario minimo e no maximo 10%";

       IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,()->{
        f.setValorHora(valorHora);
       });
       assertEquals(mensagemEsperada, erro.getMessage());
    }
}
