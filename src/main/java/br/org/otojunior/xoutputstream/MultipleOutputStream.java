/**
 * 
 */
package br.org.otojunior.xoutputstream;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
public class MultipleOutputStream extends OutputStream {
	private OutputStream[] outputStream; 
	
	/**
	 * 
	 * @param outputStream
	 */
	public MultipleOutputStream(OutputStream... outputStream) {
		this.outputStream = outputStream;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write(int b) throws IOException {
		for (OutputStream o : outputStream) o.write(b);
	}
}
