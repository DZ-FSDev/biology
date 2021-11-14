package com.dz_fs_dev.biology.genetics.interfaces;

import org.biojava.nbio.core.exceptions.CompoundNotFoundException;
import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.ProteinSequence;
import org.biojava.nbio.core.sequence.RNASequence;

/**
 * The user of this interface should implement functionality such that it
 * represents the different polymers that may be found in biological cells;
 * and allows for the forward and reverse transcription and translation
 * to other genetic biological polymers.
 * 
 * @author DZ-FSDev
 * @since 16.0.1
 * @version 0.0.1
 */
public interface GeneticBioPolymer {
	/**
	 * Returns the DNA Coding sequence responsible for the current BioPolymer.
	 * 
	 * @return The DNA Coding sequence responsible for the current BioPolymer.
	 */
	public DNASequence getCodingSequence() throws CompoundNotFoundException;
	
	/**
	 * Returns the DNA Coding sequence responsible for the current BioPolymer.
	 * 
	 * @return The DNA Non-Coding sequence responsible for the current BioPolymer.
	 */
	public DNASequence getNonCodingSequence() throws CompoundNotFoundException;
	
	/**
	 * Returns the mRNA sequence responsible for the current BioPolymer.
	 * 
	 * @return The mRNA sequence responsible for the current BioPolymer.
	 */
	public RNASequence getMessengerSequence() throws CompoundNotFoundException;
	
	/**
	 * Returns the mRNA sequence responsible for the current BioPolymer.
	 * 
	 * @return The mRNA sequence responsible for the current BioPolymer.
	 */
	public ProteinSequence getProteinSequence() throws CompoundNotFoundException;
}
