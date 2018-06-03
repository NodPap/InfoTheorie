package Praktikum1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Vector;
public class BSCKanal  {
public int[][] H_checkmatrix = 
		{ 
				{1,1,1,0,1,0,0},
				{1,1,0,1,0,1,0},
				{1,0,1,1,0,0,1}
		};
public int[][] G_matrix = 
		{ 
				{1,0,0,0},
				{0,1,0,0},
				{0,0,1,0},
				{0,0,0,1},
				{1,1,1,0},
				{1,1,0,1},
				{1,0,1,1}
		};
	Random generator = new Random();
	public funktions f = new funktions();
	public void hamming_encoder(int Ldata, int N_iteration, double p_bsc)
	{
		Vector<Integer> fehlervektor = f.channel_bsc(p_bsc,7);
		Vector<Integer> S = new Vector<Integer>();
		Vector<Integer> HammingCode = new Vector<Integer>();
		int n = Ldata/4;
		for (int i = 0; i < n; i++) {
			for(int j = 0; j < 4; j++) {
				S.add(generator.nextInt(2) + 0);
			}
		}
		for(int k = 0; k < S.size(); k++) {
			for (int v = 0; v < 7; v++) {
				HammingCode.add(S.get(0) * G_matrix[v][0]);
			}
		}
		
		System.out.println(S);
	}
	public void hamming_decoder() {
		
	}
	public static void main(String[] args) {
		BSCKanal b  = new BSCKanal();
		b.hamming_encoder(100, 100, 0.02);
	}
}
