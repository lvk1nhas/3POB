// Cliente.java
package primeira;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    private static List<Cliente> clientes = new ArrayList<>();

    private int id;
    private String nome;
    private String endereco;
    private String postalCode;
    private String pais;
    private String cpf;
    private String passaporte;
    private String email;
    private Date dataNascimento;

    public Cliente(int id, String nome, String endereco, String postalCode, String pais,
                   String cpf, String passaporte, String email, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.postalCode = postalCode;
        this.pais = pais;
        this.cpf = cpf;
        this.passaporte = passaporte;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPais() {
        return pais;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public String getEmail() {
        return email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public static List<Cliente> getClientes() {
        return clientes;
    }

    // Função para incluir um novo cliente
    public static void incluirCliente() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do cliente: ");
        String nome = sc.nextLine();

        // Adicionando validação para o CPF (pode ser mais complexa dependendo dos requisitos)
        System.out.println("Digite o CPF do cliente (sem ponto): ");
        String cpf = sc.nextLine();
        if (!validarCPF(cpf)) {
            System.out.println("CPF inválido. Cliente não cadastrado.");
            return;
        }

        // Adicionando validação para o e-mail (pode ser mais complexa dependendo dos requisitos)
        System.out.println("Digite o e-mail do cliente: ");
        String email = sc.nextLine();
        if (!validarEmail(email)) {
            System.out.println("E-mail inválido. Cliente não cadastrado.");
            return;
        }

        System.out.println("Digite a data de nascimento do cliente (dd/MM/yyyy): ");
        String dataNascimentoStr = sc.nextLine();
        Date dataNascimento = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataNascimento = sdf.parse(dataNascimentoStr);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Cliente não cadastrado.");
            return;
        }

        int novoId = clientes.size() + 1;
        Cliente novoCliente = new Cliente(novoId, nome, null, null, null, cpf, null, email, dataNascimento);
        clientes.add(novoCliente);

        System.out.println("Cliente cadastrado com sucesso!");
    }

    // Função para alterar os dados de um cliente existente
    public static void alterarCliente() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o ID do cliente que deseja alterar: ");
        int idCliente = sc.nextInt();

        Cliente clienteExistente = buscarClientePorId(idCliente);

        if (clienteExistente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.println("Digite o novo nome do cliente (ou pressione Enter para manter o mesmo): ");
        String novoNome = sc.nextLine(); // Consumir a quebra de linha pendente
        novoNome = sc.nextLine();

        if (!novoNome.isEmpty()) {
            clienteExistente.nome = novoNome;
        }

        // Adicionando validação para o CPF e mantendo o CPF existente se o novo for inválido
        System.out.println("Digite o novo CPF do cliente (ou pressione Enter para manter o mesmo): ");
        String novoCpf = sc.nextLine();
        if (!novoCpf.isEmpty() && validarCPF(novoCpf)) {
            clienteExistente.cpf = novoCpf;
        } else {
            System.out.println("CPF inválido. Mantendo o CPF existente.");
        }

        // Adicionando validação para o e-mail e mantendo o e-mail existente se o novo for inválido
        System.out.println("Digite o novo e-mail do cliente (ou pressione Enter para manter o mesmo): ");
        String novoEmail = sc.nextLine();
        if (!novoEmail.isEmpty() && validarEmail(novoEmail)) {
            clienteExistente.email = novoEmail;
        } else {
            System.out.println("E-mail inválido. Mantendo o e-mail existente.");
        }

        System.out.println("Digite a nova data de nascimento do cliente (dd/MM/yyyy) " +
                "(ou pressione Enter para manter a mesma): ");
        String novaDataNascimentoStr = sc.nextLine();
        if (!novaDataNascimentoStr.isEmpty()) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date novaDataNascimento = sdf.parse(novaDataNascimentoStr);
                clienteExistente.dataNascimento = novaDataNascimento;
            } catch (ParseException e) {
                System.out.println("Formato de data inválido. Mantendo a data de nascimento existente.");
            }
        }

        System.out.println("Cliente alterado com sucesso!");
    }

    // Função para excluir um cliente existente
    public static void excluirCliente() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o ID do cliente que deseja excluir: ");
        int idCliente = sc.nextInt();

        Cliente clienteExistente = buscarClientePorId(idCliente);

        if (clienteExistente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        clientes.remove(clienteExistente);
        System.out.println("Cliente excluído com sucesso!");
    }

    // Função para listar todos os clientes
    public static void listarClientes() {
        System.out.println("Lista de Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("E-mail: " + cliente.getEmail());
            System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
            System.out.println();
        }
    }

    // Função para buscar um cliente pelo ID
    public static Cliente buscarClientePorId(int idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == idCliente) {
                return cliente;
            }
        }
        return null;
    }

    // Função para validar o CPF (simplificada)
    private static boolean validarCPF(String cpf) {
        // Implementação básica de validação de CPF
        // Pode ser substituída por uma lógica mais robusta se necessário
        return cpf.matches("\\d{11}");
    }

    // Função para validar o e-mail (simplificada)
    private static boolean validarEmail(String email) {
        // Implementação básica de validação de e-mail
        // Pode ser substituída por uma lógica mais robusta se necessário
        return email.matches(".+@.+\\..+");
    }
}
