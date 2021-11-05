package fatec.poo.model;

/**
 *
 * @author vinicius
 */
public class Matricula {
    private String data;
    private int qtdeFaltas;
    private double nota;
    private Aluno aluno;
    private Turma turma;
    
    public Matricula (String data){
        this.data = data;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public void setQtdeFaltas(int qtdeFaltas) {
        this.qtdeFaltas = qtdeFaltas;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    public void EmitirCarne(){
        //NÃO IMPLEMENTAR
    }
}
