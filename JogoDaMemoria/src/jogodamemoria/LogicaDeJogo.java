/**
 * Nome do Projeto: JogoDaMemoriaV2
 * Nome do Arquivo: LogicaDeJogo.java
 * Data de Criação: 08/07/2024
 * Autor: nfra9
 */
package jogodamemoria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class LogicaDeJogo {
	private Carta primeiraCarta, segundaCarta;
	private Timer temporizador;
	private int contPar = 0;
	private final int tempo = 1000;
	private final ArrayList<Carta> cartas;
	private final TabuleiroDeJogo tabuleiroDeJogo;
	//private final int NR_PARES;

	public LogicaDeJogo(ArrayList<Carta> cartas, TabuleiroDeJogo tabuleiroDeJogo) {
		this.cartas = cartas;
		this.tabuleiroDeJogo = tabuleiroDeJogo;
		//this.NR_PARES = NR_PARES;

		temporizador = new Timer(tempo, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				primeiraCarta.esconderIcone();
				segundaCarta.esconderIcone();

				for (Carta carta : cartas) {
					if (carta.isParEncontrado()) {
						carta.setEnabled(false);
					} else {
						carta.setEnabled(true);
					}
				}
				primeiraCarta = null;
				segundaCarta = null;
			}
		});
		temporizador.setRepeats(false);
	}

	public void verificarCarta(Carta cartaClicada) {
		if (cartaClicada == primeiraCarta || cartaClicada == segundaCarta) {
			return;
		}

		cartaClicada.revelarIcone();
		if (primeiraCarta == null) {
			primeiraCarta = cartaClicada;
		} else if (segundaCarta == null) {
			segundaCarta = cartaClicada;

			if (primeiraCarta.getIcone().equals(segundaCarta.getIcone())) {
				primeiraCarta.setEnabled(false);
				segundaCarta.setEnabled(false);
				primeiraCarta.setParEncontrado(true);
				segundaCarta.setParEncontrado(true);
				contPar++;

				if (contPar == tabuleiroDeJogo.getNR_PARES()) {
					int opcao = mostrarMsgFimJogo();
					if (opcao == 0) {
						tabuleiroDeJogo.dispose();
						new TabuleiroDeJogo().iniciarJogo();
					} else {
						System.exit(0);
					}
				}

				primeiraCarta = null;
				segundaCarta = null;
			} else {
				for (Carta carta : cartas) {
					carta.setEnabled(false);
				}
				primeiraCarta.setEnabled(true);
				segundaCarta.setEnabled(true);
				temporizador.start();
			}
		}
	}

	public int mostrarMsgFimJogo() {
		Object[] opcoes = { "Reiniciar jogo", "Sair" };
		return JOptionPane.showOptionDialog(null, "Ganhou!! Deseja reiniciar o jogo ou sair?", "Fim do Jogo",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, null);
	}
}



