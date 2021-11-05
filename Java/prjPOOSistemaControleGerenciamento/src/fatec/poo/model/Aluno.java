package fatec.poo.model;

/**
 *
 * @author vinicius
 */
public class Aluno extends Pessoa {
    private String escolaridade;
    private Matricula matricula;
    private boolean matriculado = false;
    
    public Aluno (String cpf, String nome){
        super(cpf, nome);
    }
    
    public void setMatricula(Matricula matricula){
        this.matricula = matricula;
        matricula.setAluno(this);
        matriculado = true;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public boolean isMatriculado() {
        return matriculado;
    }

    public String getEscolaridade() {
        return escolaridade;
    }
}
