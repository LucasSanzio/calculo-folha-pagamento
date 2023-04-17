import java.util.Scanner;
import java.time.LocalDateTime;

class Main {
  public static void main(String[] args) {
  Scanner entrada = new Scanner(System.in);
    // Entrada de dados
    double adicionalPericulosidade = 0;
    double adicionalInsalubridade = 0;
    double recebidohoraex = 0;
    int qtfaltas = 0;
    int qtatrasos = 0;
    double valoratrasos = 0;
    double valorfaltas = 0;
    String nome, cargo, mes, resposta;
    double salarioBruto, bonificacoes, valorValeTransporte, salariototal, salarioHora, valorhoraex, totaldeducoes, salarioLiquido, pensaoAlimenticia, outrasDeducoes, baseCalculoir, deducaoDependentes, irrf, fgts, aliquotaEfetiva, tetoMaximo, descontoVT, descontomaxValeTransporte, valorTotal, valorDiario, deducaoatraso, deducaofalta;
    int cargaHorariaDiaria, cargaHorariaSemanal, cargaHorariaMensal, diasTrabalhadosSemana, horasextras, semanastrabalhadas, numDependentes, diasTrabalhados, grauInsalubridade;

    
    System.out.print("Digite o nome do Funcionário: ");
   nome = entrada.next();

    System.out.print("Digite o cargo do Funcionário: ");
  cargo = entrada.next();

    System.out.print("Digite o mês em relação a folha de pagamento: ");
  mes = entrada.next();
    
    System.out.print("Digite o valor do salário bruto: R$ ");
  salarioBruto = entrada.nextDouble();

    System.out.print("Digite o valor de bonificações ou comissões extras (Se não tiver digite 0): ");
   bonificacoes = entrada.nextDouble();
    
    System.out.print("Digite a carga horária diária em horas: ");
  cargaHorariaDiaria = entrada.nextInt();

    System.out.print("Digite a quantidade de dias trabalhados na semana: ");
  diasTrabalhadosSemana = entrada.nextInt();

    System.out.print("Digite a quantidade de horas extras trabalhadas no mês: ");
    horasextras = entrada.nextInt();

    System.out.print("Digite o valor pago por hora extra: ");
    valorhoraex = entrada.nextDouble();
    
    System.out.print("Digite a quantidade de semanas trabalhadas no mês: ");
    semanastrabalhadas = entrada.nextInt();

    System.out.print("Digite o valor do vale transporte recebido: R$ ");
    valorValeTransporte = entrada.nextDouble();

  System.out.print("O funcionário faltou? (S/N): ");
        resposta = entrada.next();
        if (resposta.equalsIgnoreCase("S")) {
           System.out.print("Digite a quantidade de faltas: ");
    qtfaltas = entrada.nextInt();
          System.out.print("Qual o valor a ser deduzido por falta: ");
    valorfaltas = entrada.nextInt();
           }
System.out.print("O funcionário chegou atrasado? (S/N): ");
        resposta = entrada.next();
        if (resposta.equalsIgnoreCase("S")) {
           System.out.print("Digite a quantidade de horas atrasadas: ");
    qtatrasos = entrada.nextInt();
          System.out.print("Qual o valor a ser deduzido por hora atrasada: ");
    valoratrasos = entrada.nextInt();
           }
    
deducaofalta = qtfaltas * valorfaltas;
deducaoatraso = qtatrasos * valoratrasos;    


   salariototal = ((salarioBruto + adicionalPericulosidade + adicionalInsalubridade + bonificacoes + recebidohoraex) - deducaoatraso) - deducaofalta;

    // Cálculo de salário hora
   cargaHorariaSemanal = cargaHorariaDiaria * diasTrabalhadosSemana;
   cargaHorariaMensal = (cargaHorariaSemanal * semanastrabalhadas) + horasextras;
   salarioHora = salariototal / cargaHorariaMensal;
    recebidohoraex = horasextras * valorhoraex;
    

    // Cálculo de periculosidade
    System.out.print("O funcionário recebe adicional de periculosidade? (S/N): ");
       resposta = entrada.next();
        if (resposta.equalsIgnoreCase("S")) {
         
           adicionalPericulosidade = salarioBruto * 0.3; // adicional de 30%
            
        }
    // Cálculo de insalubridade
System.out.print("O funcionário recebe adicional de insalubridade? (S/N): ");
        resposta = entrada.next();
        if (resposta.equalsIgnoreCase("S")) {
           System.out.print("Digite o grau de insalubridade (baixo = 10, médio = 20, alto = 40): ");
    grauInsalubridade = entrada.nextInt();
         

    if (grauInsalubridade == 10) {
      adicionalInsalubridade = salarioBruto * 0.1;
    } else if (grauInsalubridade == 20) {
      adicionalInsalubridade = salarioBruto * 0.2;
    } else {
      adicionalInsalubridade = salarioBruto * 0.4;
    }
      

        }
    
    // Cálculo de desconto de vale transporte
     descontomaxValeTransporte = salarioBruto * 0.06;
     
    
    if (valorValeTransporte >= descontomaxValeTransporte) { descontoVT = 
      descontomaxValeTransporte;
    } else{ descontoVT = valorValeTransporte;
      
    }
  


    //Cálculo vale alimentação
System.out.print("Digite o valor diário do vale-alimentação: ");
        valorDiario = entrada.nextDouble();

        
        diasTrabalhados = diasTrabalhadosSemana * semanastrabalhadas;
    

        valorTotal = valorDiario * diasTrabalhados;

        
    
    
    //Cáculo INSS
 // Definir valores das faixas salariais e alíquotas
        double faixa1 = 1302.00;
        double faixa2 = 2571.29;
        double faixa3 = 3856.94;
        double faixa4 = 7507.49;
        double aliquota1 = 0.075;
        double aliquota2 = 0.09;
        double aliquota3 = 0.12;
        double aliquota4 = 0.14;

    // Calcular o valor do INSS a ser recolhido pelo empregador
        double valorINSS = 0;
        if (salariototal<= faixa1) {
            valorINSS = salariototal * aliquota1;
        } else if (salariototal <= faixa2) {
            valorINSS = (faixa1 * aliquota1) + ((salariototal - faixa1) * aliquota2);
        } else if (salariototal <= faixa3) {
            valorINSS = (faixa1 * aliquota1) + ((faixa2 - faixa1) * aliquota2) + ((salariototal - faixa2) * aliquota3);
        } else if (salariototal <= faixa4) {
            valorINSS = (faixa1 * aliquota1) + ((faixa2 - faixa1) * aliquota2) + ((faixa3 - faixa2) * aliquota3) + ((salariototal - faixa3) * aliquota4);
        } else {
            valorINSS = (faixa1 * aliquota1) + ((faixa2 - faixa1) * aliquota2) + ((faixa3 - faixa2) * aliquota3) + ((faixa4 - faixa3) * aliquota4);
        }
        
        // Verificar se o valor do INSS ultrapassa o teto máximo
        tetoMaximo = 7507.49;
        if (valorINSS > tetoMaximo) {
            valorINSS = tetoMaximo;
        }
        
        // Calcular a alíquota efetiva
         aliquotaEfetiva = valorINSS / salarioBruto * 100;
        
      
      // Calcular FGTS
     fgts = salariototal * 0.08;


        
        
        System.out.print("Informe o número de dependentes: ");
        numDependentes = entrada.nextInt();

        

        // Calcula a dedução por dependentes
        deducaoDependentes = numDependentes * 189.59;

        System.out.print("Informe o valor da pensão alimentícia: R$ ");
        pensaoAlimenticia = entrada.nextDouble();

        System.out.print("Informe o valor de outras deduções (Plano de Saúde): R$ ");
        outrasDeducoes = entrada.nextDouble();

        // Calcula a base de cálculo
        baseCalculoir = salariototal - valorINSS - deducaoDependentes - pensaoAlimenticia - outrasDeducoes;

        // Calcula o IRRF
        if (baseCalculoir <= 1903.98) {
            irrf = 0;
        } else if (baseCalculoir <= 2826.65) {
            irrf = baseCalculoir * 0.075 - 142.8;
        } else if (baseCalculoir <= 3751.05) {
            irrf = baseCalculoir * 0.15 - 354.8;
        } else if (baseCalculoir <= 4664.68) {
            irrf = baseCalculoir * 0.225 - 636.13;
        } else {
            irrf = baseCalculoir * 0.275 - 869.36;
        }

   // Calcular o valor do salário líquido
         totaldeducoes = valorINSS + deducaoDependentes + pensaoAlimenticia + outrasDeducoes + irrf + descontoVT + deducaoatraso + deducaofalta;
         salarioLiquido = salariototal - totaldeducoes;


        System.out.println("-------------------FOLHA-DE-PAGAMENTO----------------------");
        System.out.println("Nome do funcionário: " + nome);
        System.out.println("Data de emissão:" + LocalDateTime.now().getDayOfMonth() + "/" + LocalDateTime.now().getMonthValue() + "/" + LocalDateTime.now().getYear());
        System.out.println("Mês de referência: " + mes);
        System.out.println("Cargo do funcionário: " + cargo);
    System.out.println("");
    
        System.out.println("Todos os proventos:");
        System.out.println("Salário bruto: R$ " + salarioBruto);
        System.out.println("Bonificações ou comissões extras recebidas: R$ " + bonificacoes);
        System.out.println("Valor recebido por horas extras trabalhadas: R$ " + recebidohoraex);
        System.out.println("Valor do vale transporte recebido: R$ " + valorValeTransporte);
        System.out.println("Valor do vale-alimentação recebido: R$" + valorTotal);
        System.out.printf("Adicional de periculosidade: R$ %.2f%n", adicionalPericulosidade);
        System.out.printf("Adicional de Insalubridade: R$ %.2f\n", adicionalInsalubridade);
    System.out.println("O valor bruto total do salário é: R$ " + salariototal);
        System.out.println("O salário hora é: R$ " + salarioHora);
    System.out.println("");
    
        System.out.println("Lista de todos os descontos:");
        System.out.printf("Desconto de Vale Transporte: R$ %.2f\n", descontoVT);
        System.out.println("Desconto do FGTS: R$ " + fgts);
        System.out.println("Pensão alimentícia: R$ " + pensaoAlimenticia);
        System.out.println("Desconto do INSS: R$ " + valorINSS);
        System.out.println("Alíquota efetiva: " + aliquotaEfetiva + "%");
        System.out.println("Outras deduções: R$ " + outrasDeducoes);
        System.out.println("Desconto do IRRF: R$ " + irrf);
     System.out.println("Dedução por falta: R$ " + deducaofalta);
      System.out.println("Dedução por atraso: R$ " + deducaoatraso);
        System.out.println("Total de deduções: R$ " + totaldeducoes);
    
    System.out.println("");
        
    System.out.println("Bases de cáculo utilizadas:");
        System.out.println("Base de cálculo do IRRF: R$ " + baseCalculoir);
        System.out.println("Base de cálculo do INSS: R$ " + salariototal);
        System.out.println("Base de cálculo do FGTS: R$ " + salariototal);
         System.out.println("");

        System.out.println("Salário líquido: R$ " + salarioLiquido);

  }
}