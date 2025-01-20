/**
 * Nome do Projeto: JogoDaMemoriaV2
 * Nome do Arquivo: JogoDaMemoria.java
 * Data de Criação: 08/07/2024
 * Autor: nfra9
 */
package jogodamemoria;

import javax.swing.SwingUtilities;

public class JogoDaMemoria {

	public static void main(String[] args) {

		// Esse código serve para garantir que determinadas ações ou atualizações da
		// interface gráfica sejam realizadas
		SwingUtilities.invokeLater(new Runnable() { // new Runnable() criação de uma instância de uma classe anônima que
													// implementa a interface Runnable.
			// a anotação Override permite indicar ao compilador que o método run() da
			// interface Runnable está a ser sobreescrito
			// e que não se trata da definição de um método novo
			@Override
			public void run() {
				// tarefa a ser executada. criar e atualizar tabuleiro de jogo.
				TabuleiroDeJogo tj = new TabuleiroDeJogo();
				tj.iniciarJogo();
			}
		});
	}

}


