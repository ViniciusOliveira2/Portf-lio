package fatec.poo.controller;
import fatec.poo.database.DBContext;
import fatec.poo.model.Curso;
import fatec.poo.model.Instrutor;
import fatec.poo.model.Turma;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author vinicius
 */
public class InstrutorController {
    public static void CadastrarInstrutor(){
        String cpf;
        String nome;
        Instrutor aux;
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("\nCADASTRAR INSTRUTOR\n");
                            
        System.out.println("Informe o CPF do Instrutor(a):");
        cpf = entrada.nextLine();
        
        System.out.println("Informe o Nome do Instrutor(a):");
        nome = entrada.nextLine();

        aux = new Instrutor(cpf, nome);

        System.out.println("Informe a Data de Nascimento (dd-mm-aaaa)");
        aux.setDataNasc(entrada.nextLine());
        
        System.out.println("Informe o Endereço do Instrutor(a):");
        aux.setEndereco(entrada.nextLine());
        
        System.out.println("Informe o Número da Residência:");
        aux.setNumero(entrada.nextInt());
        entrada.nextLine();
        
        System.out.println("Informe o Bairro:");
        aux.setBairro(entrada.nextLine());
        
        System.out.println("Informe a Cidade:");
        aux.setCidade(entrada.nextLine());
        
        System.out.println("Informe o Estado:");
        aux.setEstado(entrada.nextLine());
        
        System.out.println("Informe o CEP:");
        aux.setCep(entrada.nextLine());
        
        System.out.println("Informe o Telefone do Instrutor(a):");
        aux.setTelefone(entrada.nextLine());
        
        System.out.println("Informe o Sexo do Instrutor(a) (M ou F):");
        aux.setSexo(entrada.nextLine());
        
        System.out.println("Informe o Estado Civil do Instrutor(a):");
        aux.setEstadoCivil(entrada.nextLine());
        
        System.out.println("Informe o RG do Instrutor(a):");
        aux.setRg(entrada.nextLine());
        
        System.out.println("Informe o E-Mail do Instrutor(a):");
        aux.setEmail(entrada.nextLine());

        System.out.println("Informe a Formação do Instrutor(a):");
        aux.setFormacao(entrada.nextLine());
        
        System.out.println("Informe a Área de Atuação do Instrutor(a):");
        aux.setAreaAtuacao(entrada.nextLine());

        DBContext.getInstance().addInstrutor(aux);                
    }
    
    public static void AlocarInstrutor(){
        int turma;
        int instrutor;
        int i;
        int j;
        boolean verificacao = false;
        boolean Prof = false;
        
        Scanner entrada = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,##0.00");
        
        System.out.println("\nALOCAR INSTRUTOR\n");
        
        System.out.println("\nINSTRUTORES DISPONÍVEIS\n");
        List<Instrutor> listInstrutor = DBContext.getInstance().listInstrutor();
        
        for(i = 0; i < listInstrutor.size(); i++){
            Instrutor temp = listInstrutor.get(i);
            
            System.out.println("|Código:       " + (i + 1) + "\nNome:         " + temp.getNome() + "\nFormacao:     " + temp.getFormacao() + "\n|Área Atuacao: " + temp.getAreaAtuacao() + "\n");
            verificacao = true;
        }
        
        if (verificacao){
            System.out.println("Informe o Instrutor que Será Alocado numa Turma:");
            instrutor = entrada.nextInt() - 1;
            
            if(instrutor >= 0 && instrutor < listInstrutor.size()){
                System.out.println("\nTURMAS DISPONÍVEIS\n");
                List<Turma> listTurmas = DBContext.getInstance().listTurma();
        
                for(j = 0; j < listTurmas.size(); j++){
                    Turma temp2 = listTurmas.get(j);
            
                    if(temp2.getProfessor() == false){
                        System.out.println("|Código:         " + (j + 1) + "\n|Descricao:      " + temp2.getDescricao() + "\n|Periodo:        " + temp2.getPeriodo() + "\n|Hora Instrutor: R$" + df.format(temp2.getCurso().getValorHoraInstrutor()) + "\n");
                        Prof = true;
                    }
                }
                
                if (Prof){
                    System.out.println("Informe a Turma que o Instrutor Será Alocado:");
                    turma = entrada.nextInt() - 1;
                    
                    if(turma >= 0 && turma < listTurmas.size()){
                        Turma temp2 = listTurmas.get(turma);
                        
                        if(temp2.getProfessor() == false){
                            DBContext.getInstance().addTurmaInstrutor(turma, instrutor);
                        }else{
                            System.out.println("Essa Turma Já Possui um Instrutor!");
                        }
                    } else{
                        System.out.println("Alocação Cancelada! Por Favor Informe uma Turma Válida na Próxima Vez!");
                    }
                } else{
                    System.out.println("Por Favor Cadastre uma Nova Turma!");
                }
            } else{
                System.out.println("Alocação Cancelada! Por Favor Informe um Instrutor Válido na Próxima Vez!");
            }
        } else{
            System.out.println("Por Favor Cadastre um Novo Instrutor!");
        }
    }
}
