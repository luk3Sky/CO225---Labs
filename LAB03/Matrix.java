public class Matrix extends Thread{

    private static int [][] a; 
    private static int [][] b; 
    private static int [][] c; 

	// private int [] tempRow, tempCol;
	// private int row_len;

    /* You might need other variables as well */

	public Matrix(int [] row, int [] col, int len) { // need to change this, might need some information
		// this.tempRow = row;
		// this.tempCol = col;
		// this.row_len = len;
    }

	public static int getMultipliedValue(int [][] matrix_a, int [][] matrix_b, int row, int column){
		int result = 0;
		int i;
		for(i = 0; i < matrix_a[0].length ; i++){
			result = result + matrix_a[row][i]*matrix_b[i][column];
		}

		return result;
	}

    public static int [][] multiply(int [][] a, int [][] b) {

		/* check if multipication can be done, if not 
		* return null 
		* allocate required memory 
		* return a * b
		*/

		int x = a.length; 
		int y = b[0].length; 

		int z1 = a[0].length; 
		int z2 = b.length; 

		// System.out.println("a.len : "+x+"\nb[0].len : "+y+"\na[0].len : "+z1+"\nb.len : "+z2);

		if(z1 != z2) { 
			System.out.println("Cannnot multiply");
			return null;
		}

		c = new int [x][y]; 
		int i, j, k, s; 

		for(i=0; i<x; i++){ 
			for(j=0; j<y; j++) {
				// System.out.println("New method " + getMultipliedValue(a, b, i, j));
				c[i][j] = getMultipliedValue(a, b, i, j);
				// for(s=0, k=0; k<z1; k++) 
				// 	s += a[i][k] * b[k][j];
			// c[i][j] = s;
			}
		}
		return c; 
    }

}