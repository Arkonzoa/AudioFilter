package gti310.tp2.audio;

import java.util.Arrays;

import gti310.tp2.io.FileSource;

public class WaveFilter implements AudioFilter{
	@Override
	public void process(FileSource file) {
		// TODO Auto-generated method stub
		byte[] pop = file.pop(44);
		
		
		byte[] headerWav = Arrays.copyOfRange(pop, 8, 12);
		int wave = byteArrayToInt(headerWav);
		byte[] headerAudioFormat = Arrays.copyOfRange(pop, 20, 22);
		int audioFormat = byteToInt(headerAudioFormat);
		byte[] headerChannels = Arrays.copyOfRange(pop, 22, 24);
		int channel = byteToInt(headerChannels);
		byte[] headerSampleRate = Arrays.copyOfRange(pop, 24, 28);
		int sampleRate = byteArrayToInt(headerSampleRate);
		byte[] headerBits = Arrays.copyOfRange(pop, 34, 36);
		int bits = byteToInt(headerBits);
		if(checkWave(wave, audioFormat, channel, sampleRate, bits)){
			
		}
		else {
			System.out.print("File is not valid");
		}
//		for(int i = 0; i < pop.length; i++){
//			System.out.println(pop[i]);
//		}
		
	}
	public boolean checkWave(int wave, int audioFormat, int channel, int sampleRate, int bits){
		boolean flag = false;
		
		if (wave == 1163280727){
			flag = true;
		}
		else {
			flag = false;
		}
		
		//java.nio.ByteBuffer.wrap(headerAudioFormat).getInt();
		if (audioFormat == 1){
			flag = true;
		}
		else {
			flag = false;
		}
		
		
		if (channel == 1 || channel == 2){
			flag = true;
		}
		else {
			flag = false;
		}
		
		
		if (sampleRate == 44100){
			flag = true;
		}
		else {
			flag = false;
		}
		
		
		if (bits == 8 || bits == 16){
			flag = true;
		}
		else
		{
			flag = false;
		}
		return flag;
	}
	public static int byteArrayToInt(byte[] b) 
	{
	    return   b[0] & 0xFF |
	            (b[1] & 0xFF) << 8 |
	            (b[2] & 0xFF) << 16 |
	            (b[3] & 0xFF) << 24;
	}
	
	public static int byteToInt(byte[] b){
		return b[0] & 0xFF |
				(b[1] & 0xFF) << 8;
	}
}
