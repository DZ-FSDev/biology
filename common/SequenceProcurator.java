package com.dz_fs_dev.biology.common;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.biojava.nbio.core.sequence.ProteinSequence;
import org.biojava.nbio.core.sequence.io.FastaReaderHelper;

/**
 * Contains various utility methods for loading sequences.
 *
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public final class SequenceProcurator {
	private SequenceProcurator() {}

	/**
	 * 
	 * 
	 * @param uniProtId
	 * @return
	 * @throws IOException
	 * @since 0.0.1
	 */
	public static ProteinSequence getProteinSequenceForId(String uniProtId) throws IOException {
		URL uniprotFasta = new URL(String.format("https://www.uniprot.org/uniprot/%s.fasta", uniProtId));
		return getProteinSequenceForIdFromInputStream(uniprotFasta.openStream(), uniProtId);
	}

	/**
	 * 
	 * 
	 * @param uniProtId
	 * @return
	 * @throws IOException
	 * @since 0.0.1
	 */
	public static ProteinSequence getProteinSequenceForIdVerbose(String uniProtId) throws IOException {
		ProteinSequence seq = getProteinSequenceForId(uniProtId);
		System.out.printf("id : %s%n%s%n%s%n", uniProtId, seq, seq.getOriginalHeader());
		return seq;
	}

	/**
	 * Helper method
	 * 
	 * @param inputStream
	 * @param uniProtId
	 * @return
	 * @throws IOException
	 * @since 0.0.1
	 */
	private static ProteinSequence getProteinSequenceForIdFromInputStream(InputStream inputStream, String uniProtId) throws IOException {
		return FastaReaderHelper.readFastaProteinSequence(inputStream).get(uniProtId);
	}
}
