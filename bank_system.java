import java.util.Scanner;
import java.time.LocalTime;

public class bank_system {

    public static void main(String[] args) {

        // Definição de variaveis + Criação do scanner

        String CPF = "", nome = "", telefone = "", email = "", saudacao;
        double saldo = 0 , saque, deposito;
        int opcao, opcaoA, opcaoB, hora = LocalTime.now().getHour();

        Scanner scanner = new Scanner(System.in);

        // Estrutura horário

        if(hora >= 5 && hora < 12){
            saudacao = "Bom dia";
        }else if(hora >= 12 && hora < 18){
            saudacao = "Boa tarde";
        }else{
            saudacao = "Boa noite";
        }

        // Estrutura de registro

        while (true) {

            System.out.println(saudacao + ", REGISTRO DE CONTA" +
                    "\ntodas as opções disponiveis estão abaixo:\n ");

            System.out.println("1- Registrar nome.\n" +
                    "2- Registrar CPF.\n" +
                    "3- Registrar telefone." +
                    "\n" +
                    "4- Registrar email.\n" +
                    "5- Conferir dados.\n" +
                    "6- Sair das opções de registro.\n");

            System.out.print("Digite uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            // Opção para sair do registro

            if (opcao == 6) {
                System.out.println("Encerrando sessão de registro, movendo para funções bancarias");
                break;
            }

            switch (opcao) {

                case 1:

                    System.out.print("Informe seu nome completo: ");
                    nome = scanner.nextLine();

                    System.out.printf(saudacao + " %s, seu nome foi registrado ! \n", nome);
                    continue;

                case 2:

                    System.out.print("Informe seu CPF: ");
                    CPF = scanner.nextLine();

                    if(CPF.length() != 11) {
                        System.out.println("Formato de CPF invalido, CPF deve ter 11 digitos");
                        continue;
                    } else {
                        System.out.println(saudacao + " CPF Registrado !");
                        continue;
                    }

                case 3:

                    System.out.print("Informe seu numero de telefone: (DDD + numero) ");
                    telefone = scanner.nextLine();

                    if (telefone.length() != 11) {
                        System.out.println("Telefone invalido, telefone deve ter 11 digitos");
                    } else {
                        System.out.println(saudacao + " Telefone registrado !");
                        continue;
                    }

                case 4:

                    System.out.print("Informe seu e-mail: ");
                    email = scanner.nextLine();
                    System.out.println(saudacao + " E-mail registrado !");
                    break;

                case 5:

                    System.out.println(saudacao + " Dados consultados: ");
                    System.out.printf("Seu nome completo: %s\nSeu CPF: %s\n" +
                            "Seu telefone: %s\nSeu email: %s \n ", nome, CPF, telefone, email);
                    break;

                default:

                    System.out.println("Opção invalida, use uma das opções do menu!");

            }
        }

        // Estrutura de funções bancarias

        while (true) {
            System.out.println(saudacao +" Funções bancarias:\n \n1-Consultar saldo.\n2-Realizar deposito.\n3-Realizar saque.\n4-Encerrar sessão.");
            System.out.print("Digite uma opção: ");
            opcaoA = scanner.nextInt();

            if (opcaoA == 4) {
                System.out.println("Encerrando sessão, obrigado por usar o nosso sistema bancário...");
                break;
            }

            switch (opcaoA) {

                case 1:

                    System.out.printf("Seu saldo atual: R$ %.2f\n", saldo);
                    break;

                case 2:

                    System.out.println("Insira o valor que deseja depositar: ");
                    deposito = scanner.nextFloat();

                    if(deposito <= 0 ){
                        System.out.println("Valor invalido ! O deposito deve ser maior que zero !\n");
                    }else{
                        saldo += deposito;
                        System.out.printf(saudacao + nome + ", foram depositados R$ %.2f com sucesso !\n", deposito);
                    }
                    break;

                case 3:

                    if (saldo == 0) {
                        System.out.println("Você não tem valor em conta para realizar um saque !");
                        break;
                    }

                    System.out.print("Insira o valor que deseja sacar: ");
                    saque = scanner.nextFloat();

                    if(saque > saldo) {
                        System.out.println("Você não tem este valor na sua conta !");
                        continue;
                    }

                    saldo -= saque;
                    System.out.printf(saudacao + " saque de R$ %.2f realizado, seu novo saldo: R$ %.2f\n", saque, saldo);
                    break;

                default:
                    System.out.println("Opcão invalida, insira uma opcão valida !\n");

            }
        }
        scanner.close();
    }
}