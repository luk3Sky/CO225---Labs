import java.lang.Exception.*;

public class Matrix extends Thread{

    public static int [][] a; 
    public static int [][] b; 
    public static int [][] c; 
	public static int x, y, z1, z2;

	public Matrix() {
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

    public static int [][] multiply(int [][] array_1, int [][] array_2) {
		a = array_1;
		b = array_2;
		x = a.length;
		y = b[0].length;
		z1 = a[0].length; 
		z2 = b.length; 
		int no_Of_Threads = x;
		Thread[] threads = new Thread[no_Of_Threads];
		try {
			for (int i = 0; i < no_Of_Threads ; i++) {
				threads[i] = new Matrix();
				threads[i].start();
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("Thread Creation Error!");
			return null;
		}
		
		try {
			for (Thread var : threads) {
				var.join();
			}
		} catch (InterruptedException e) {
			System.out.println("Joining Error!");
			e.printStackTrace();
			return null;
		}
		return c; 
    }

}