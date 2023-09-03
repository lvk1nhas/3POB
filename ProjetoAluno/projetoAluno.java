import java.util.Scanner;

public class projetoAluno{
    public static void main(String[] args) throws Exception{  

        Scanner leitor = new Scanner(System.in);
        Aluno aluno1 = new Aluno();
        
        System.out.println("Digite o nome do aluno:");
        aluno1.nome = leitor.nextLine();

        System.out.println("Digite a turma do aluno:");
        aluno1.turma = leitor.nextLine();

        System.out.println("Digite a idade do aluno:");
        aluno1.idade = leitor.nextInt();

        System.out.println("Digite a matricula do aluno:");
        aluno1.matricula= leitor.nextInt();

        System.out.format("O nome do aluno é %s, sua turma é %s, sua idade é %d e sua matrícula é %d.", aluno1.nome, aluno1.turma, aluno1.idade, aluno1.matricula);

        leitor.close();
    }
}   
