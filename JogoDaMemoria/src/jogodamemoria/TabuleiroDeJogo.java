/**
 * Nome do Projeto: JogoDaMemoriaV2
 * Nome do Arquivo: TabuleiroDeJogo.java
 * Data de Criação: 08/07/2024
 * Autor: nfra9
 */
package jogodamemoria;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TabuleiroDeJogo extends JFrame implements ActionListener {
	private final int n = 4;
	private final int cj = 800, aj = 600;
	private ImageIcon icone;
	private final ArrayList<Icon> icones;
	private final ArrayList<Carta> cartas;
	private final int NR_PARES = 8;
	private JPanel painel;
	private LogicaDeJogo logicaDeJogo;

	public TabuleiroDeJogo() {
		icones = new ArrayList<>();
		cartas = new ArrayList<>();
		logicaDeJogo = new LogicaDeJogo(cartas, this);
	}

	public void criarJanela() {
		setTitle("JOGO DA MEMÓRIA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(cj, aj);
		painel = new JPanel(new GridLayout(n, n));
		add(painel);
		setVisible(true);
	}

	public void carregarImagens() {
		for (int i = 1; i <= NR_PARES; i++) {
			icone = new ImageIcon("recursos/" + i + ".png");
			icones.add(icone);
			icones.add(icone);
		}
	}

	public void baralhar() {
		Collections.shuffle(icones);
	}

	public void criarCartas() {
		for (Icon ic : icones) {
			Carta carta = new Carta(ic);
			carta.addActionListener(this);
			cartas.add(carta);
			painel.add(carta);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		logicaDeJogo.verificarCarta((Carta) e.getSource());
	}

	public void iniciarJogo() {
		criarJanela();
		carregarImagens();
		baralhar();
		criarCartas();
	}
	
	//getter para a variavel NR_PARES
	public int getNR_PARES() {
		return NR_PARES;
	}
}


