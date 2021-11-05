package fatec.poo.controller;
import fatec.poo.database.DBContext;
import fatec.poo.model.Aluno;
import fatec.poo.model.Matricula;
import fatec.poo.model.Turma;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author vinicius
 */
public class MatriculaController {
    public static void MatricularAluno(){
        int i;
        int j;
        int aluno;
        int turma;
        String data;
        Matricula aux;
        boolean verificacao = false;
        boolean vagas = false;
        
        Scanner entrada = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,##0.00");
        
        System.out.println("\nMATRICULAR ALUNO\n");
        
        System.out.println("\nALUNOS DISPONÍVEIS\n");
        List<Aluno> listAluno = DBContext.getInstance().listAluno();
        
        for(i = 0; i < listAluno.size(); i++){
            Aluno temp = listAluno.get(i);
            
            if(temp.isMatriculado() == false){
                System.out.println("|Código:       " + (i + 1) + "\n|Nome:         " + temp.getNome() + "\n|Escolaridade: " + temp.getEscolaridade() + "\n");
                verificacao = true;
            }
        }
        
        if(verificacao == false){
            System.out.println("Por Favor Cadastre um Novo Aluno!");
            return;
        }
        
        System.out.println("Informe Qual Aluno Será Matriculado:");
        aluno = entrada.nextInt() - 1;
        
        if(aluno >= 0 && aluno < listAluno.size()){
            System.out.println("\nTURMAS DISPONÍVEIS\n");
            List<Turma> listTurmas = DBContext.getInstance().listTurma();
                
            for(j = 0; j < listTurmas.size(); j++){
                Turma temp2 = listTurmas.get(j);

                if(temp2.getQtdVagas() > 0){
                    System.out.println("|Código:    " + (j + 1) + "\n|Descricao: " + temp2.getDescricao() + "\n|Qtd Vagas: " + temp2.getQtdVagas() + "\n|Valor:     R$" + df.format(temp2.getCurso().getValor()) + "\n");
                    vagas = true;
                }
            }
            
            if (vagas){
                System.out.println("Informe a Turma que o Aluno Será Matriculado:");
                turma = entrada.nextInt() - 1;

                if(turma >= 0 && turma < listTurmas.size()){
                    Turma temp2 = listTurmas.get(turma);

                    if(temp2.getQtdVagas() > 0){
                        System.out.println("Informe a Data da Matricula:");
                        data = entrada.nextLine();
        
                        aux = new Matricula(data);
                        
                        DBContext.getInstance().addMatriculaTurma(aux, turma);
                        DBContext.getInstance().addMatricula(aux);
                    }else{
                        System.out.println("Não Há Vagas Nessa Turma!");
                    }
                } else{
                    System.out.println("Matricula Cancelada! Por Favor Informe uma Turma Válida na Próxima Vez!");
                }
            } else{
                System.out.println("Por Favor Cadastre uma Nova Turma!");
            }
        }
    }
}
