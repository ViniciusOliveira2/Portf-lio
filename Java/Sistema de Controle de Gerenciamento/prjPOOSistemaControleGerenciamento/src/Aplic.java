import fatec.poo.controller.AlunoController;
import fatec.poo.controller.CursoController;
import fatec.poo.controller.InstrutorController;
import fatec.poo.controller.MatriculaController;
import fatec.poo.controller.TurmaController;
import java.util.Scanner;

/**
 *
 * @author vinicius
 */
public class Aplic {
    public static void main(String[] args) {
        int usuario, opcao;
        
        Scanner entrada = new Scanner(System.in);
        
        do {
            System.out.println("Informe o tipo de usuário que utilizará o sistema\n");
            System.out.println("1 - Setor de Planejamento de Cursos\n2 - Setor de Recrutamento");
            System.out.println("3 - Instrutor\n4 - Secretaria de Cursos");
            System.out.println("5 - Aluno\n6 - Sair\n");
            System.out.println("Por favor informe o tipo de Usuário : ");
            
            usuario = entrada.nextInt();

            if (usuario != 6){
                do {
                    System.out.println("\nInforme qual função deverá ser executada\n");
                    
                    switch (usuario){
                        case 1:
                            System.out.println("1 - Cadastrar Curso\n2 - Montar Turma");
                            System.out.println("3 - Alocar Instrutor\n0 - Voltar\n");
                            System.out.println("Por favor informe a Opção: ");

                            opcao = entrada.nextInt();
                            break;
                        case 2:
                            System.out.println("1 - Cadastrar Instrutor\n0 - Voltar\n");
                            System.out.println("Por favor informe a Opção: ");

                            opcao = entrada.nextInt();
                            break;
                        case 3:
                            System.out.println("1 - Cadastrar Instrutor\n0 - Voltar\n");
                            System.out.println("Por favor informe a Opção: ");

                            opcao = entrada.nextInt();
                            break;
                        case 4:
                            System.out.println("1 - Emitir Controle de Frequencia\n2 - Cadastrar Aluno");
                            System.out.println("3 - Matricular Aluno\n4 - Definir Forma de Pagamento\n0 - Voltar\n");
                            System.out.println("Por favor informe a Opção: ");

                            opcao = entrada.nextInt();
                            break;
                        case 5:
                            System.out.println("1 - Cadastrar Aluno\n2 - Matricular Aluno");
                            System.out.println("3 - Definir Forma de Pagamento\n0 - Voltar\n");
                            System.out.println("Por favor informe a Opção: ");

                            opcao = entrada.nextInt();
                            break;
                        default:
                            System.out.println("\nUsuário Inválido!!!\n");
                            opcao = 0;
                            break;
                    }
                    
                    entrada.nextLine();
                    opcao = permissao(usuario, opcao);
                    
                    switch (opcao){
                        case -1:
                            System.out.println("\nPermissões Insuficientes para Executar o Comando!!!\n");
                            break;
                        case 0:
                            break;
                        case 1:
                            CursoController.CadastrarCurso();
                            break;
                        case 2:
                            TurmaController.MontarTurma();
                            break;
                        case 3:
                            InstrutorController.AlocarInstrutor();
                            break;
                        case 4:
                            InstrutorController.CadastrarInstrutor();
                            break;
                        case 5:
                            System.out.println("Desculpe a Função do Controle de Frequência Está Indisponível no Momento!");
                            break;
                        case 6:
                            AlunoController.CadastrarAluno();
                            break;
                        case 7:
                            MatriculaController.MatricularAluno();
                            break;
                        case 8:
                            System.out.println("Desculpe a Função de Definição de Forma de Pagamento Está Indisponível no Momento!");
                            break;
                        default:
                            break;
                    }
                } while(opcao != 0);
            }
        } while(usuario != 6);
    }

    public static int permissao(int usuario, int opcao){
        switch (opcao){
            case 0:
                return 0;
            case 1:
                switch (usuario){
                    case 1:
                        return opcao;
                    case 2:
                        return opcao + 3;
                    case 3:
                        return opcao + 3;
                    case 4:
                        return opcao + 4;
                    case 5:
                        return opcao + 5;
                }
                break;
            case 2:
                switch (usuario){
                    case 1:
                        return opcao;
                    case 2:
                        return -1;
                    case 3:
                        return -1;
                    case 4:
                        return opcao + 4;
                    case 5:
                        return opcao + 5;
                }
                break;
            case 3:
                switch (usuario){
                    case 1:
                        return opcao;
                    case 2:
                        return -1;
                    case 3:
                        return -1;
                    case 4:
                        return opcao + 4;
                    case 5:
                        return opcao + 5;
                }
                break;
            case 4:
                switch (usuario){
                    case 1:
                        return -1;
                    case 2:
                        return -1;
                    case 3:
                        return -1;
                    case 4:
                        return opcao + 4;
                    case 5:
                        return -1;
                }
                break;
        }
        return 0;
    }
}