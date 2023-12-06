// Cama.java
package primeira;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cama {
    private static List<Cama> camas = new ArrayList<>();

    private int id;
    private String codigoCama;
    private boolean ehBeliche;
    private String posicao;
    private String descricao;

    public Cama(int id, String codigoCama, boolean ehBeliche, String posicao, String descricao) {
        this.id = id;
        this.codigoCama = codigoCama;
        this.ehBeliche = ehBeliche;
        this.posicao = posicao;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getCodigoCama() {
        return codigoCama;
    }

    public boolean isEhBeliche() {
        return ehBeliche;
    }

    public String getPosicao() {
        return posicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static List<Cama> getCamas() {
        return camas;
    }

    // Função para incluir uma nova cama
    public static void incluirCama() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o código da cama: ");
        String codigoCama = sc.nextLine();

        // Adicionando validação para a posição (pode ser mais complexa dependendo dos requisitos)
        System.out.println("Digite a posição da cama (ex: norte, sul, perto da porta, longe, diagonal): ");
        String posicao = sc.nextLine();

        System.out.println("A cama é beliche? (sim/nao): ");
        String respostaBeliche = sc.next();
        boolean ehBeliche = respostaBeliche.equalsIgnoreCase("sim");

        System.out.println("Digite a descrição da cama: ");
        sc.nextLine(); // Consumir a quebra de linha pendente
        String descricao = sc.nextLine();

        int novoId = camas.size() + 1;
        Cama novaCama = new Cama(novoId, codigoCama, ehBeliche, posicao, descricao);
        camas.add(novaCama);

        System.out.println("Cama cadastrada com sucesso!");
    }

    // Função para alterar os dados de uma cama existente
    public static void alterarCama() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o ID da cama que deseja alterar: ");
        int idCama = sc.nextInt();

        Cama camaExistente = buscarCamaPorId(idCama);

        if (camaExistente == null) {
            System.out.println("Cama não encontrada.");
            return;
        }

        System.out.println("Digite o novo código da cama (ou pressione Enter para manter o mesmo): ");
        String novoCodigoCama = sc.nextLine(); // Consumir a quebra de linha pendente
        novoCodigoCama = sc.nextLine();

        if (!novoCodigoCama.isEmpty()) {
            camaExistente.codigoCama = novoCodigoCama;
        }

        // Adicionando validação para a posição e mantendo a posição existente se a nova for inválida
        System.out.println("Digite a nova posição da cama (ou pressione Enter para manter a mesma): ");
        String novaPosicao = sc.nextLine();
        if (!novaPosicao.isEmpty()) {
            camaExistente.posicao = novaPosicao;
        }

        System.out.println("A cama é beliche? (sim/nao - ou pressione Enter para manter o mesmo): ");
        String respostaBeliche = sc.nextLine(); // Consumir a quebra de linha pendente
        respostaBeliche = respostaBeliche.trim().toLowerCase(); // Remover espaços e converter para minúsculas
        if (!respostaBeliche.isEmpty()) {
            if (respostaBeliche.equals("sim")) {
                camaExistente.ehBeliche = true;
            } else if (respostaBeliche.equals("nao")) {
                camaExistente.ehBeliche = false;
            } else {
                System.out.println("Opção inválida. Mantendo o valor existente.");
            }
        }

        System.out.println("Digite a nova descrição da cama (ou pressione Enter para manter a mesma): ");
        String novaDescricao = sc.nextLine();
        if (!novaDescricao.isEmpty()) {
            camaExistente.descricao = novaDescricao;
        }

        System.out.println("Cama alterada com sucesso!");
    }

    // Função para excluir uma cama existente
    public static void excluirCama() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o ID da cama que deseja excluir: ");
        int idCama = sc.nextInt();

        Cama camaExistente = buscarCamaPorId(idCama);

        if (camaExistente == null) {
            System.out.println("Cama não encontrada.");
            return;
        }

        camas.remove(camaExistente);
        System.out.println("Cama excluída com sucesso!");
    }

    // Função para listar todas as camas
    public static void listarCamas() {
        System.out.println("Lista de Camas:");
        for (Cama cama : camas) {
            System.out.println("ID: " + cama.getId());
            System.out.println("Código da Cama: " + cama.getCodigoCama());
            System.out.println("Beliche: " + (cama.isEhBeliche() ? "sim" : "nao"));
            System.out.println("Posição: " + cama.getPosicao());
            System.out.println("Descrição: " + cama.getDescricao());
            System.out.println();
        }
    }

    // Função para buscar uma cama pelo ID
    public static Cama buscarCamaPorId(int idCama) {
        for (Cama cama : camas) {
            if (cama.getId() == idCama) {
                return cama;
            }
        }
        return null;
    }
}
