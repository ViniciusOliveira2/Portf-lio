package fatec.poo.controller;
import fatec.poo.database.DBContext;
import fatec.poo.model.Aluno;
import java.util.Scanner;

/**
 *
 * @author vinicius
 */
public class AlunoController {
    public static void CadastrarAluno(){
        String cpf;
        String nome;
        Aluno aux;

        Scanner entrada = new Scanner(System.in);

        System.out.println("\nCADASTRAR ALUNO\n");

        System.out.println("Informe o CPF do Aluno(a):");
        cpf = entrada.nextLine();
        
        System.out.println("Informe o Nome do Aluno(a):");
        nome = entrada.nextLine();

        aux = new Aluno(cpf, nome);

        System.out.println("Informe a Data de Nascimento (dd-mm-aaaa)");
        aux.setDataNasc(entrada.nextLine());
        
        System.out.println("Informe o Endereço do Aluno(a):");
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
        
        System.out.println("Informe o Telefone do Aluno(a):");
        aux.setTelefone(entrada.nextLine());
        
        System.out.println("Informe o Sexo do Aluno(a) (M ou F):");
        aux.setSexo(entrada.nextLine());
        
        System.out.println("Informe o Estado Civil do Aluno(a):");
        aux.setEstadoCivil(entrada.nextLine());
        
        System.out.println("Informe o RG do Aluno(a):");
        aux.setRg(entrada.nextLine());
        
        System.out.println("Informe o E-Mail do Aluno(a):");
        aux.setEmail(entrada.nextLine());

        System.out.println("Informe a Escolaridade do Aluno(a):");
        aux.setEscolaridade(entrada.nextLine());

        DBContext.getInstance().addAluno(aux);
    }
}
