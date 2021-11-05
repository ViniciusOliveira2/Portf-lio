package fatec.poo.controller;
import fatec.poo.database.DBContext;
import fatec.poo.model.Curso;
import fatec.poo.model.Turma;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author vinicius
 */
public class TurmaController {
    public static void MontarTurma(){
        String siglaTurma;
        String descricao;
        Turma aux;
        int i;
        int escolha;
        boolean verificacao = false;
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("\nMONTAR TURMA\n");
        
        System.out.println("Informe a Sigla da Turma:");
        siglaTurma = entrada.nextLine();
        
        System.out.println("Informe a Descrição da Turma");
        descricao = entrada.nextLine();
        
        aux = new Turma(siglaTurma, descricao);
        
        System.out.println("Informe a Data de Início:");
        aux.setDataInicio(entrada.nextLine());
        
        System.out.println("Informe a Data de Término:");
        aux.setDataTermino(entrada.nextLine());
        
        System.out.println("Informe o Período Letivo:");
        aux.setPeriodo(entrada.nextLine());
        
        System.out.println("Informe a Quantidade de Vagas Disponíveis:");
        aux.setQtdVagas(entrada.nextInt());
        entrada.nextLine();
        
        System.out.println("Informe as Observações Adicionais:");
        aux.setObservacoes(entrada.nextLine());
        
        System.out.println("\nCURSOS DISPONÍVEIS\n");
        List<Curso> listCursos = DBContext.getInstance().listCurso();
                            
        for(i = 0; i < listCursos.size(); i++){
            Curso temp = listCursos.get(i);
            System.out.println("|Código: " + (i + 1) + "\n|Nome:   " + temp.getNome() + "\n");
            verificacao = true;
        }
        
        if (verificacao){
            System.out.println("Informe o Valor do Curso ao Qual Será Atribuido a Turma:");
            escolha = entrada.nextInt() - 1;
            
            if(escolha >= 0 && escolha < listCursos.size()){
                DBContext.getInstance().addTurmaCurso(aux, escolha);
                
                DBContext.getInstance().addTurma(aux);
            } else{
                System.out.println("Montagem de Turma Cancelada! Por Favor Informe um Curso Válido na Próxima Vez!");
            }
        } else{
            System.out.println("Por Favor Cadastre um Novo Curso!");
        }
    }
}
