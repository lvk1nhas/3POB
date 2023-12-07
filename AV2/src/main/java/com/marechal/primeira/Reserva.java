// Reserva.java
package primeira;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Reserva {
    private static List<Reserva> reservas = new ArrayList<>();

    private int id;
    private int idQuarto;
    private int idCama;
    private int idCliente;
    private Date dataEntrada;
    private Date dataSaida;

    public Reserva(int id, int idQuarto, int idCama, int idCliente, Date dataEntrada, Date dataSaida) {
        this.id = id;
        this.idQuarto = idQuarto;
        this.idCama = idCama;
        this.idCliente = idCliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }
    
    public int getIdCama() {
        return idCama;
    }

    public void setIdCama(int idCama) {
        this.idCama = idCama;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public static List<Reserva> getReservas() {
        return reservas;
    }

    // Função para incluir uma nova reserva
    public static void incluirReserva() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o ID do quarto da reserva: ");
        int idQuarto = sc.nextInt();

        Quarto quartoExistente = Quarto.buscarQuartoPorId(idQuarto);

        if (quartoExistente == null) {
            System.out.println("Quarto não encontrado. Reserva não cadastrada.");
            return;
        }

        System.out.println("Digite o ID da cama da reserva: ");
        int idCama = sc.nextInt();

        Cama camaExistente = Cama.buscarCamaPorId(idCama);

        if (camaExistente == null) {
            System.out.println("Cama não encontrada. Reserva não cadastrada.");
            return;
        }

        System.out.println("Digite o ID do cliente da reserva: ");
        int idCliente = sc.nextInt();

        Cliente clienteExistente = Cliente.buscarClientePorId(idCliente);

        if (clienteExistente == null) {
            System.out.println("Cliente não encontrado. Reserva não cadastrada.");
            return;
        }

        System.out.println("Digite a data de entrada da reserva (dd/MM/yyyy): ");
        String dataEntradaStr = sc.next();
        Date dataEntrada = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataEntrada = sdf.parse(dataEntradaStr);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Reserva não cadastrada.");
            return;
        }
    
        System.out.println("Digite a data de saída da reserva (dd/MM/yyyy): ");
        String dataSaidaStr = sc.next();
        Date dataSaida = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataSaida = sdf.parse(dataSaidaStr);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Reserva não cadastrada.");
            return;
        }
    
        if (dataEntrada.after(dataSaida)) {
            System.out.println("Data de entrada deve ser anterior à data de saída. Reserva não cadastrada.");
            return;
        }

        int novoId = reservas.size() + 1;
        Reserva novaReserva = new Reserva(novoId, idQuarto, idCama, idCliente, dataEntrada, dataSaida);
        reservas.add(novaReserva);

        System.out.println("Reserva cadastrada com sucesso!");
    }

    // Função para alterar os dados de uma reserva existente
    public static void alterarReserva() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o ID da reserva que deseja alterar: ");
        int idReserva = sc.nextInt();

        Reserva reservaExistente = buscarReservaPorId(idReserva);

        if (reservaExistente == null) {
            System.out.println("Reserva não encontrada.");
            return;
        }

        System.out.println("Digite o novo ID do quarto da reserva (ou pressione Enter para manter o mesmo): ");
        int novoIdQuarto = sc.nextInt();
        if (novoIdQuarto != 0) {
            Quarto quartoExistente = Quarto.buscarQuartoPorId(novoIdQuarto);
            if (quartoExistente != null) {
                reservaExistente.idQuarto = novoIdQuarto;
            } else {
                System.out.println("Quarto não encontrado. Mantendo o ID do quarto existente.");
            }
        }

        System.out.println("Digite o novo ID da cama da reserva (ou pressione Enter para manter o mesmo): ");
        int novoIdCama = sc.nextInt();
        if (novoIdCama != 0) {
            Cama camaExistente = Cama.buscarCamaPorId(novoIdCama);
            if (camaExistente != null) {
                reservaExistente.idCama = novoIdCama;
            } else {
                System.out.println("Cama não encontrada. Mantendo o ID da cama existente.");
            }
        }

        System.out.println("Digite o novo ID do cliente da reserva (ou pressione Enter para manter o mesmo): ");
        int novoIdCliente = sc.nextInt();
        if (novoIdCliente != 0) {
            Cliente clienteExistente = Cliente.buscarClientePorId(novoIdCliente);
            if (clienteExistente != null) {
                reservaExistente.idCliente = novoIdCliente;
            } else {
                System.out.println("Cliente não encontrado. Mantendo o ID do cliente existente.");
            }
        }

        System.out.println("Digite a nova data de entrada da reserva (dd/MM/yyyy) " +
            "(ou pressione Enter para manter a mesma): ");
    String novaDataEntradaStr = sc.next();
    if (!novaDataEntradaStr.isEmpty()) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date novaDataEntrada = sdf.parse(novaDataEntradaStr);

            // Adiciona validação para garantir que a nova data de entrada seja anterior à data de saída
            if (novaDataEntrada.after(reservaExistente.dataSaida)) {
                System.out.println("Data de entrada deve ser anterior à data de saída. Mantendo a data de entrada existente.");
                return;
            }

            reservaExistente.dataEntrada = novaDataEntrada;
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Mantendo a data de entrada existente.");
        }
    }

        System.out.println("Digite a nova data de saída da reserva (dd/MM/yyyy) " +
        "(ou pressione Enter para manter a mesma): ");
        String novaDataSaidaStr = sc.next();
        if (!novaDataSaidaStr.isEmpty()) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date novaDataSaida = sdf.parse(novaDataSaidaStr);

                // Adiciona validação para garantir que a nova data de saída seja posterior à data de entrada
                if (novaDataSaida.before(reservaExistente.dataEntrada)) {
                    System.out.println("Data de saída deve ser posterior à data de entrada. Mantendo a data de saída existente.");
                    return;
                }

                reservaExistente.dataSaida = novaDataSaida;
            } catch (ParseException e) {
                System.out.println("Formato de data inválido. Mantendo a data de saída existente.");
            }
}

System.out.println("Reserva alterada com sucesso!");
}

    // Função para excluir uma reserva existente
    public static void excluirReserva() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o ID da reserva que deseja excluir: ");
        int idReserva = sc.nextInt();

        Reserva reservaExistente = buscarReservaPorId(idReserva);

        if (reservaExistente == null) {
            System.out.println("Reserva não encontrada.");
            return;
        }

        reservas.remove(reservaExistente);
        System.out.println("Reserva excluída com sucesso!");
    }

    // Função para listar todas as reservas
    public static void listarReservas() {
        System.out.println("Lista de Reservas:");
        for (Reserva reserva : reservas) {
            System.out.println("ID: " + reserva.getId());
            System.out.println("ID do Quarto: " + reserva.getIdQuarto());
            System.out.println("ID da Cama: " + reserva.getIdCama());
            System.out.println("ID do Cliente: " + reserva.getIdCliente());
            System.out.println("Data de Entrada: " + reserva.getDataEntrada());
            System.out.println("Data de Saída: " + reserva.getDataSaida());
            System.out.println();
        }
    }

    // Função para buscar uma reserva pelo ID
    private static Reserva buscarReservaPorId(int idReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == idReserva) {
                return reserva;
            }
        }
        return null;
    }
}
