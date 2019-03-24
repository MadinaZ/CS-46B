package dna;

//
// FastqRecord contains the defline, sequence, and quality string
// from a record in a fastq file.
//


public class FastqRecord implements DNARecord
{
	//instance variables
	private String defline;
	private String sequence;
	private String quality;
	
	//ctor
	
	//
	// Add a precondition check: throw FastqException if the 1st char of the defline is 
	// not '@'. You will have to change the ctor declaration to say that it throws
	// the exception. The exception should contain a useful informative message.
	//
	public FastqRecord(String defline, String sequence, String quality) throws RecordFormatException{
		if (defline.startsWith("@")){
			this.defline = defline;
		}
		else
			throw new RecordFormatException("Bad 1st char in defline in fastq record: saw " + defline.substring(0, 1) + " expected @");
		this.sequence = sequence;
		this.quality = quality;
	}
	
	
	// 
	// Provide the 2 methods that satisfy the interface.
	//
	public String getDefline(){
		return defline;
	}
	
	public String getSequence(){
		return sequence;
	}
	

	//
	// Provide an equals() method that checks for deep equality of all 3 instance variables. 
	// When checking string variables, be sure to do it like this:  
	//              this.defline.equals(that.defline) 
	// and not like this:  
	//              this.defline == that.defline
	//
	public boolean equals(Object x){
		FastqRecord that = (FastqRecord)x;
		if (this.defline.equals(that.defline) &&
			this.sequence.equals(that.sequence) &&
			this.quality.equals(that.quality)){
			return true;
		}
		return false;
	}
	
	
	//
	// Complete this. Return true if quality contains at least one '!' char.
	//
	public boolean qualityIsLow()
	{
		if (quality.contains("!")){
			return true;
		}
		return false;
	}
	
	
	//
	// Complete this. Return the sum of the hash codes of defline, sequence, and quality.
	//
	public int hashCode()
	{
		return defline.hashCode() + sequence.hashCode() + quality.hashCode();
	}
}
