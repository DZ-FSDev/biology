package com.dz_fs_dev.biology.genetics.interfaces;

import org.biojava.nbio.core.exceptions.CompoundNotFoundException;
import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.ExonSequence;
import org.biojava.nbio.core.sequence.GeneSequence;
import org.biojava.nbio.core.sequence.IntronSequence;
import org.biojava.nbio.core.sequence.ProteinSequence;
import org.biojava.nbio.core.sequence.RNASequence;
import org.biojava.nbio.core.sequence.TranscriptSequence;

/**
 * The user of this interface should implement functionality such that it
 * represents the different polymers that may be found in biological cells;
 * and allows for the forward and reverse transcription and translation
 * to other genetic biological polymers.
 * 
 * @param <T> The data type wrapped by the genetic polymer. The toString()
 *            or equivalent functionality should be implemented by the wrapped
 *            data type.
 * 
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.3
 */
public interface GeneticBioPolymer<T> {
	/**
	 * Returns the DNA Coding sequence responsible for the current BioPolymer.
	 * Includes both introns and exons where applicable.
	 * 
	 * @return The DNA Coding sequence responsible for the current BioPolymer.
	 */
	public DNASequence getCodingSequence() throws CompoundNotFoundException;
	
	/**
	 * Returns the DNA Non-Coding sequence responsible for the current BioPolymer.
	 * Includes both introns and exons where applicable.
	 * 
	 * @return The DNA Non-Coding sequence responsible for the current BioPolymer.
	 */
	public DNASequence getNonCodingSequence() throws CompoundNotFoundException;
	
	/**
	 * Returns the DNA Coding intron sequence responsible for the current BioPolymer.
	 * 
	 * @return The DNA Coding intron sequence responsible for the current BioPolymer.
	 */
	public IntronSequence getIntronSequence() throws CompoundNotFoundException;
	
	/**
	 * Returns the DNA Coding exon sequence responsible for the current BioPolymer.
	 * 
	 * @return The DNA Coding exon sequence responsible for the current BioPolymer.
	 */
	public ExonSequence getExonSequence() throws CompoundNotFoundException;
	
	/**
	 * Returns the DNA transcription sequence responsible for the current BioPolymer.
	 * 
	 * @return The DNA transcription sequence responsible for the current BioPolymer.
	 */
	public TranscriptSequence getTranscriptSequence() throws CompoundNotFoundException;
	
	/**
	 * Returns the DNA gene sequence responsible for the current BioPolymer.
	 * 
	 * @return The DNA gene sequence responsible for the current BioPolymer.
	 */
	public GeneSequence getGeneSequence() throws CompoundNotFoundException;
	
	/**
	 * Returns the mRNA sequence responsible for the current BioPolymer.
	 * 
	 * @return The mRNA sequence responsible for the current BioPolymer.
	 */
	public RNASequence getMessengerSequence() throws CompoundNotFoundException;
	
	/**
	 * Returns the amino acid sequence responsible for the current BioPolymer.
	 * 
	 * @return The amino acid sequence responsible for the current BioPolymer.
	 */
	public ProteinSequence getProteinSequence() throws CompoundNotFoundException;
	
	/**
	 * Returns the original sequence that was used to create this genetic BioPolymer instance.
	 * 
	 * @return The original sequence that was used to create this genetic BioPolymer instance.
	 */
	public T getSequence();
}
