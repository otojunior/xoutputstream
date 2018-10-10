/**
 * 
 */
package br.org.otojunior.xoutputstream;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
public class MultipleWriterTest {
	private MultipleWriter multipleWriter;
	
	/**
	 * Test method for {@link br.org.otojunior.xoutputstream.MultipleWriter#write(char[], int, int)}.
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testWriteCharArrayIntInt() throws FileNotFoundException {
		multipleWriter = new MultipleWriter(
			new PrintWriter("saida/teste1_1.log"),
			new PrintWriter("saida/teste1_2.log"),
			new PrintWriter("saida/teste1_3.log"));
		
		PrintWriter p = new PrintWriter(multipleWriter);
		p.println("lin001");
		p.println("lin002");
		p.println("lin003");
		p.close();
	}
	
	/**
	 * Test method for {@link br.org.otojunior.xoutputstream.MultipleWriter#write(char[], int, int)}.
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testWriteMuitosArquivos() throws FileNotFoundException {
		List<Writer> lst = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			lst.add(new PrintWriter("saida/teste2_" + i + ".log"));
		}
		
		multipleWriter = new MultipleWriter(lst.toArray(new Writer[0]));
		
		PrintWriter p = new PrintWriter(multipleWriter);
		for (int j = 1; j <= 10000; j++) {
			p.println("lin_" + j);
		}
		p.close();
	}
}
