package fatec.poo.model;
import java.util.ArrayList;

/**
 *
 * @author vinicius
 */
public class Turma {
    private String siglaTurma;
    private String descricao;
    private String dataInicio;
    private String dataTermino;
    private String periodo;
    private String observacoes;
    private int qtdVagas;
    private ArrayList<Matricula> matriculas;
    private Curso curso;
    private Instrutor instrutor;
    private boolean professor = false;
    
    public Turma (String siglaTurma, String descricao){
        this.siglaTurma = siglaTurma;
        this.descricao = descricao;
        matriculas = new ArrayList<Matricula>();
    }
    
    public void addMatricula(Matricula m){
        matriculas.add(m);
        m.setTurma(this);
        qtdVagas--;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
        professor = true;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void setQtdVagas(int qtdVagas) {
        this.qtdVagas = qtdVagas;
    }
    
    public void EmitirListaFrequencia(){
        //NÃO IMPLEMENTAR
    }

    public String getSiglaTurma() {
        return siglaTurma;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public int getQtdVagas() {
        return qtdVagas;
    }
    
    public boolean getProfessor() {
        return professor;
    }

    public Curso getCurso() {
        return curso;
    }
}
