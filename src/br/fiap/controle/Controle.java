package br.fiap.controle;

import br.fiap.assento.Assento;
import br.fiap.cliente.Cliente;
import br.fiap.cliente.PessoaFisica;
import br.fiap.cliente.PessoaJuridica;
import br.fiap.reserva.Reserva;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.*;

public class Controle {

    private static List<Cliente> listaCliente = new ArrayList<>();
    private static List<Assento> listaAssento = new ArrayList<>();
    private List<Reserva> listaReserva = new ArrayList<>();

    static {
        // lista de cliente
        listaCliente.add(new PessoaJuridica("ClienteA", "a@a", "cnpja"));
        listaCliente.add(new PessoaFisica("ClienteB", "b@b", "cpfb"));
        listaCliente.add(new PessoaJuridica("ClienteC", "c@c", "cnpjc"));
        listaCliente.add(new PessoaFisica("ClienteD", "d@d", "cpfd"));

        // lista de assento
        for(int i = 1; i <= 10; i++) {
            listaAssento.add(new Assento(i));
        }
    }

    public void menu() {
        int opcao;

        while(true) {
            try {
                opcao = parseInt(showInputDialog(gerarMenu()));
                switch(opcao) {
                    case 1:
                        reservar();
                        break;
                    case 2:
                        pesquisar();
                        break;
                    case 3:
                        cancelar();
                        break;
                    case 4:
                        return;
                    default:
                        showMessageDialog(null, "Opção inválida");
                }
            }
            catch(NumberFormatException e) {
                showMessageDialog(null, "você deve digitar um número");
            }
        }
    }

    private void cancelar() { }

    private void pesquisar() {
        String identificador = showInputDialog("CPF/CNPJ para pesquisa");
        for(Reserva reserva : listaReserva) {
            if(reserva.getCliente().getIdentificador().equals(identificador)) {
                showMessageDialog(null, reserva);
                return;
            }
        }
        showMessageDialog(null, "Reserva não encontrada");
    }

    private void reservar() { }

    private String gerarMenu() {
        String aux = "SISTEMA DE RESERVA DE PASSAGEM AÉREA\n";
        aux += "1. Reservar\n";
        aux += "2. Pesquisar reserva\n";
        aux += "3. Cancelar reserva\n";
        aux += "4. Finalizar";
        return aux;
    }
}
