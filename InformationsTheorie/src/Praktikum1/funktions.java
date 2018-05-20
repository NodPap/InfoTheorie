package Praktikum1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class funktions {

	public static double logfakulat(int n)
	{
		double result=0;
		for (int i = n; i > 0; i--) {
			result+=Math.log10(i);
		}
		return result;

	}
	public double binomialkoeffizient(int n, int k) {
		if (k == 0 || n == k)
		{
			return 1;
		}
		return logfakulat(n) - logfakulat(n-k) - logfakulat(k);
	}
	
	public static double log2(double x) {
		if(x == 0) {
			return 1;
		}
		return Math.log(x)/Math.log(2);
	}
	
	public static double bsc_kanal_fehler(double p) {
		return 1 + p * log2(p) + (1-p) * log2(1-p);
	}
	
	public static void writeFile_binomPlug(funktions f,int n, int k) throws IOException {
		try {

			OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream("binomPlug.dat"), "UTF-8");
			writer.write("# X Y \n");
			writer.flush();
			while (k>=0)
			{
				 writer.write(k+" "+f.binomialkoeffizient(n, k)+"\n");
				k--;
				writer.flush();
			}
			writer.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void writeFile_bscPlug(double p) throws IOException {
		try {

			OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream("bscPlug.dat"), "UTF-8");
			writer.write("# X Y \n");
			writer.flush();
			while (p>=0)
			{
				 writer.write(p+" "+bsc_kanal_fehler(p)+"\n");
				p-=0.111;
				writer.flush();
			}
			writer.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		funktions f = new funktions();
		int n = 1000;
		int k = 1000;
		//f.writeFile_binomPlug(f,n,k);
		writeFile_bscPlug(1.0);
	}
}
	