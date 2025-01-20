/**
 * Nome do Projeto: JogoDaMemoriaV2
 * Nome do Arquivo: Carta.java
 * Data de Criação: 08/07/2024
 * Autor: nfra9
 */
package jogodamemoria;

import javax.swing.Icon;
import javax.swing.JButton;

public class Carta extends JButton {
	private final Icon icone;
	private boolean parEncontrado;

	public Carta(Icon icone) {
		this.icone = icone;
		this.parEncontrado = false;
		esconderIcone();
	}

	public void revelarIcone() {
		setIcon(icone);
	}

	public void esconderIcone() {
		setIcon(null);
	}

	public Icon getIcone() {
		return icone;
	}

	public boolean isParEncontrado() {
		return parEncontrado;
	}

	public void setParEncontrado(boolean parEncontrado) {
		this.parEncontrado = parEncontrado;
	}
}


