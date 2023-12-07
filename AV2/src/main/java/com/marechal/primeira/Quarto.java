// Quarto.java
package primeira;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quarto {
    private static List<Quarto> quartos = new ArrayList<>();

    private int id;
    private String nomeQuarto;
    private int qtdeCamas;
    private boolean temBanheiro;
    private String descricao;

    public Quarto(int id, String nomeQuarto, int qtdeCamas, boolean temBanheiro, String descricao) {
        this.id = id;
        this.nomeQuarto = nomeQuarto;
        this.qtdeCamas = qtdeCamas;
        this.temBanheiro = temBanheiro;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeQuarto() {
        return nomeQuarto;
    }

    public void setNomeQuarto(String nomeQuarto) {
        this.nomeQuarto = nomeQuarto;
    }

    public int getQtdeCamas() {
        return qtdeCamas;
    }

    public void setQtdeCamas(int qtdeCamas) {
        this.qtdeCamas = qtdeCamas;
    }

    public boolean isTemBanheiro() {
        return temBanheiro;
    }

    public void setTemBanheiro(boolean temBanheiro) {
        this.temBanheiro = temBanheiro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static List<Quarto> getQuartos() {
        return quartos;
    }

    // Função para incluir um novo quarto
    public static void incluirQuarto() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do quarto: ");
        String nomeQuarto = sc.nextLine();

        System.out.println("Digite a quantidade de camas no quarto: ");
        int qtdeCamas = sc.nextInt();

        if (qtdeCamas <= 0) {
            System.out.println("A quantidade de camas deve ser maior que zero. Quarto não cadastrado.");
            return;
        }

        System.out.println("O quarto tem banheiro? (sim/nao): ");
        String respostaBanheiro = sc.next();
        boolean temBanheiro = respostaBanheiro.equalsIgnoreCase("sim");

        System.out.println("Digite a descrição do quarto: ");
        sc.nextLine(); // Consumir a quebra de linha pendente
        String descricao = sc.nextLine();

        int novoId = quartos.size() + 1;
        Quarto novoQuarto = new Quarto(novoId, nomeQuarto, qtdeCamas, temBanheiro, descricao);
        quartos.add(novoQuarto);

        System.out.println("Quarto cadastrado com sucesso!");
    }

    // Função para alterar os dados de um quarto existente
    public static void alterarQuarto() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o ID do quarto que deseja alterar: ");
        int idQuarto = sc.nextInt();

        Quarto quartoExistente = buscarQuartoPorId(idQuarto);

        if (quartoExistente == null) {
            System.out.println("Quarto não encontrado.");
            return;
        }

        System.out.println("Digite o novo nome do quarto (ou pressione Enter para manter o mesmo): ");
        String novoNomeQuarto = sc.nextLine(); // Consumir a quebra de linha pendente
        novoNomeQuarto = sc.nextLine();

        if (!novoNomeQuarto.isEmpty()) {
            quartoExistente.nomeQuarto = novoNomeQuarto;
        }

        System.out.println("Digite a nova quantidade de camas no quarto: ");
        int novaQtdeCamas = sc.nextInt();

        if (novaQtdeCamas <= 0) {
            System.out.println("A quantidade de camas deve ser maior que zero. Quarto não cadastrado.");
            return;
        }
        
        quartoExistente.qtdeCamas = novaQtdeCamas;

        System.out.println("O quarto tem banheiro? (sim/nao - ou pressione Enter para manter o mesmo): ");
        String respostaBanheiro = sc.nextLine(); // Consumir a quebra de linha pendente
        respostaBanheiro = sc.nextLine();
        if (!respostaBanheiro.isEmpty()) {
            quartoExistente.temBanheiro = respostaBanheiro.equalsIgnoreCase("sim");
        }

        System.out.println("Digite a nova descrição do quarto (ou pressione Enter para manter a mesma): ");
        String novaDescricao = sc.nextLine();
        if (!novaDescricao.isEmpty()) {
            quartoExistente.descricao = novaDescricao;
        }

        System.out.println("Quarto alterado com sucesso!");
    }

    // Função para excluir um quarto existente
    public static void excluirQuarto() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o ID do quarto que deseja excluir: ");
        int idQuarto = sc.nextInt();

        Quarto quartoExistente = buscarQuartoPorId(idQuarto);

        if (quartoExistente == null) {
            System.out.println("Quarto não encontrado.");
            return;
        }

        quartos.remove(quartoExistente);
        System.out.println("Quarto excluído com sucesso!");
    }

    // Função para listar todos os quartos
    public static void listarQuartos() {
        System.out.println("Lista de Quartos:");
        for (Quarto quarto : quartos) {
            System.out.println("ID: " + quarto.getId());
            System.out.println("Nome do Quarto: " + quarto.getNomeQuarto());
            System.out.println("Quantidade de Camas: " + quarto.getQtdeCamas());
            System.out.println("Tem Banheiro: " + (quarto.isTemBanheiro() ? "sim" : "nao"));
            System.out.println("Descrição: " + quarto.getDescricao());
            System.out.println();
        }
    }

    // Função para buscar um quarto pelo ID
    public static Quarto buscarQuartoPorId(int idQuarto) {
        for (Quarto quarto : quartos) {
            if (quarto.getId() == idQuarto) {
                return quarto;
            }
        }
        return null;
    }
}
