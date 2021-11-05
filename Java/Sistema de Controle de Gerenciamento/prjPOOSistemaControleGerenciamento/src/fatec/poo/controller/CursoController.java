package fatec.poo.controller;
import fatec.poo.database.DBContext;
import fatec.poo.model.Curso;
import java.util.Scanner;

/**
 *
 * @author vinicius
 */
public class CursoController {
    public static void CadastrarCurso(){
        String sigla;
        String nome;
        Curso aux;
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("\nCADASTRAR CURSO\n");
                            
        System.out.println("Informe a Sigla do Curso:");
        sigla = entrada.nextLine();

        System.out.println("Informe o Nome do Curso:");
        nome = entrada.nextLine();

        aux = new Curso(sigla, nome);

        System.out.println("Informe a Caraga Horaria (h):");
        aux.setCargaHoraria(entrada.nextInt());

        System.out.println("Informe o Valor do Curso (R$):");
        aux.setValor(entrada.nextDouble());
        entrada.nextLine();

        System.out.println("Informe a Data de Vigencia (dd/mm/aaaa):");
        aux.setDataVigencia(entrada.nextLine());
        
        System.out.println("Informe o Valor da Hora do Instrutor (R$):");
        aux.setValorHoraInstrutor(entrada.nextDouble());
        entrada.nextLine();

        System.out.println("Informe o Programa do Curso:");
        aux.setPrograma(entrada.nextLine());

        DBContext.getInstance().addCurso(aux);
    }
}
