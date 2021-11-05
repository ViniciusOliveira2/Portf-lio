package fatec.poo.database;
import fatec.poo.model.Aluno;
import fatec.poo.model.Curso;
import fatec.poo.model.Instrutor;
import fatec.poo.model.Matricula;
import fatec.poo.model.Turma;
import java.util.ArrayList;

/**
 *
 * @author vinicius
 */
public class DBContext {
    private static DBContext instance;
    private ArrayList<Curso> curso;
    private ArrayList<Instrutor> instrutor;
    private ArrayList<Aluno> aluno;
    private ArrayList<Turma> turma;
    private ArrayList<Matricula> matricula;
    
    public static DBContext getInstance(){
        if (instance == null){
            instance = new DBContext();
        }
        return instance;
    }
    
    public void destroy(){
        instance = null;
    }
    
    private DBContext(){
        curso = new ArrayList<Curso>();
        instrutor = new ArrayList<Instrutor>();
        aluno = new ArrayList<Aluno>();
        turma = new ArrayList<Turma>();
        matricula = new ArrayList<Matricula>();
    }
    
    public void addCurso(Curso curso){
        this.curso.add(curso);
    }
    
    public void updateCurso(Curso curso, Curso oldCurso){
        for(Curso aux : this.curso){
            if(aux.getSigla() == oldCurso.getSigla() && aux.getNome() == oldCurso.getNome()){
                aux.setCargaHoraria(curso.getCargaHoraria());
            }
        }
    }
    
    public ArrayList<Curso> listCurso(){
        ArrayList<Curso> temp = new ArrayList<Curso>();
        
        for(Curso aux : this.curso){
            temp.add(aux);
        }
        
        return temp;
    }
    
    public void addInstrutor(Instrutor instrutor){
        this.instrutor.add(instrutor);
    }
    
    public ArrayList<Instrutor> listInstrutor(){
        ArrayList<Instrutor> temp = new ArrayList<Instrutor>();
        
        for(Instrutor aux : this.instrutor){
            temp.add(aux);
        }
        
        return temp;
    }
    
    public void addTurmaInstrutor(int indiceTurma, int indiceInstrutor){
        this.instrutor.get(indiceInstrutor).addTurma(this.turma.get(indiceTurma));
    }
    
    public void addAluno(Aluno aluno){
        this.aluno.add(aluno);
    }
    
    public ArrayList<Aluno> listAluno(){
        ArrayList<Aluno> temp = new ArrayList<Aluno>();
        
        for(Aluno aux : this.aluno){
            temp.add(aux);
        }
        
        return temp;
    }
    
    public void addTurma(Turma turma){
        this.turma.add(turma);
    }
    
    public void addTurmaCurso(Turma turma, int indice){
        this.curso.get(indice).addTurma(turma);
    }
    
    public ArrayList<Turma> listTurma(){
        ArrayList<Turma> temp = new ArrayList<Turma>();
        
        for(Turma aux : this.turma){
            temp.add(aux);
        }
        
        return temp;
    }
    
    public void addMatricula(Matricula matricula){
        this.matricula.add(matricula);
    }
    
    public void addMatriculaTurma(Matricula matricula, int indice){
        this.turma.get(indice).addMatricula(matricula);
    }
}
