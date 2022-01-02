/*  Original Licensing Copyright
 * 
 *  Utility methods for loading BioInformatics sequences.
 *  Copyright (C) 2022  DZ-FSDev
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.dz_fs_dev.biology.common;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Logger;

import org.biojava.nbio.core.sequence.ProteinSequence;
import org.biojava.nbio.core.sequence.io.FastaReaderHelper;

/**
 * Contains various utility methods for loading sequences from BioInformatics
 * Databases.
 *
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.2
 */
public final class SequenceProcurator {
	private SequenceProcurator() {}

	/**
	 * Returns a requested ProteinSequence given a specified uniProtId.
	 * 
	 * @param uniProtId The specified uniProtId.
	 * @return The requested ProteinSequence.
	 * @throws IOException Thrown if procurement failed.
	 * @since 0.0.2
	 */
	public static ProteinSequence getProteinSequenceForId(String uniProtId)
			throws IOException {
		URL uniprotFasta = new URL(
				String.format("https://www.uniprot.org/uniprot/%s.fasta",
						uniProtId));
		return getProteinSequenceForIdFromInputStream(uniprotFasta.openStream(),
				uniProtId);
	}

	/**
	 * Returns a requested ProteinSequence given a specified uniProtId logging
	 * the procurement.
	 * 
	 * @param uniProtId The specified uniProtId.
	 * @param logger Where the procurement is logged.
	 * @return The requested ProteinSequence.
	 * @throws IOException Thrown if procurement failed.
	 * @since 0.0.2
	 */
	public static ProteinSequence getProteinSequenceForIdVerbose(String uniProtId,
			Logger logger) throws IOException {
		ProteinSequence seq = getProteinSequenceForId(uniProtId);
		logger.info(String.format("id : %s%n%s%n%s%n", uniProtId, seq,
				seq.getOriginalHeader()));
		return seq;
	}

	/**
	 * Returns a requested ProteinSequence given a specified uniProtId and
	 * Input Stream to read from.
	 * 
	 * @param inputStream The specified InputStream to load the
	 *                    Protein Sequence from.
	 * @param uniProtId The specified uniProtId.
	 * @return The requested ProteinSequence.
	 * @throws IOException Thrown if procurement failed.
	 * @since 0.0.2
	 */
	public static ProteinSequence getProteinSequenceForIdFromInputStream(
			InputStream inputStream, String uniProtId) throws IOException {
		return FastaReaderHelper.readFastaProteinSequence(inputStream)
				.get(uniProtId);
	}
}
