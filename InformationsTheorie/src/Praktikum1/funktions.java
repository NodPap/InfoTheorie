package Praktikum1;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
	
	public static void writeFile1(funktions f,int n, int k) throws IOException {
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
	public static void main(String[] args) throws IOException {
		funktions f = new funktions();
		int n = 1000;
		int k = 1000;
		f.writeFile1(f,n,k);
		
	}
}
	