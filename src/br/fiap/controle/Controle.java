package br.fiap.controle;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.*;

public class Controle {

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

    private void pesquisar() { }

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
