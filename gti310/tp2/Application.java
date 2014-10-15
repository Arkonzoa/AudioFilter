package gti310.tp2;

import java.io.FileNotFoundException;

import gti310.tp2.audio.WaveFilter;
import gti310.tp2.io.FileSource;

public class Application {

	/**
	 * Launch the application
	 * @param args This parameter is ignored
	 */
	public static void main(String args[]) {
		if(args.length != 1) {
			  System.err.println("Invalid command line, exactly one argument required");
			}
		else
		{	
			try {
				FileSource input = new FileSource(args[0]);
				WaveFilter filter = new WaveFilter();
				filter.process(input);
				
				input.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Audio Resample project!");
	}
}
