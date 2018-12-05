import java.lang.Exception.*;

public class Matrix extends Thread{

    private static int [][] a; 
    private static int [][] b; 
    private static int [][] c; 
	private static int x, y, z1, z2;

	public Matrix(int [][] new_a, int [][] new_b) {
		a = new_a;
		b = new_b;
		x = a.length; 
		y = b[0].length;
		z1 = a[0].length; 
		z2 = b.length; 
    }

	// A function for get one of the elements of the result matrix (c)
	public static int getMultipliedValue(int [][] a, int [][] b, int row, int column){
		int result = 0, i;
		for(i = 0; i < z1 ; i++){
			result = result + (a[row][i])*(b[i][column]);
		}
		return result;
	}


	public void run(){
		if(z1 != z2) { 
			System.out.println("Cannnot multiply");
			throw new NullPointerException();
		}
		c = new int [x][y]; 
		int i, j, k; 
		for(i=0; i<x; i++){ 
			for(j=0; j<y; j++) {
				c[i][j] = getMultipliedValue(a, b, i, j);
			}
		}
	}

    public static int [][] multiply(int [][] a, int [][] b) {
		int no_Of_Threads = a[0].length;
		Thread[] t = new Thread[no_Of_Threads];
		System.out.println(no_Of_Threads);
		try {
			for (int i = 0; i < no_Of_Threads ; i++) {
				System.out.println(i);
				t[i] = new Matrix(a, b);
				// t[i].run();
				t[i].start();
			}
		} catch (NullPointerException e) {
			return null;
		}
		
		try {
			for (Thread var : t) {
				var.join();
				System.out.println("ID : "+var.getId());
			}
		} catch (InterruptedException e) {
			System.out.println("Joining Error!");
		}
		return c; 
    }

}