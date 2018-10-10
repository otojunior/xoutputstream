/**
 * 
 */
package br.org.otojunior.xoutputstream;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
public class MultipleWriter extends Writer {
	private Writer[] writers; 
	
	/**
	 * 
	 * @param outputStream
	 */
	public MultipleWriter(Writer... writer) {
		this.writers = writer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		for (Writer w : writers) w.write(cbuf, off, len);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void flush() throws IOException {
		for (Writer w : writers) w.flush();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void close() throws IOException {
		for (Writer w : writers) w.close();
	}
}
