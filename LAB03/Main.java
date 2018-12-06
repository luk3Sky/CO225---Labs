class Main { 
    public static int [][] a = {{1, 2, 1}, {1, 3, 1}, {9, 1, 1}};
    
    public static int [][] b = {{1 }, {1 }, {1 }};


    public static void print_matrix(int [][] a) {
		for(int i=0; i < a.length; i++) {
			for(int j=0; j< a[i].length; j++) 
			System.out.print(a[i][j] + " "); 
			System.out.println();
		}
	}

    public static void main(String [] args) { 
		final float startTime = System.nanoTime();
		try {
			int [][] x = Matrix.multiply(a, a); 
			print_matrix(x);
		} catch (NullPointerException e) {
			return;
		}
		final float duration = System.nanoTime() - startTime;
		System.out.println("Elapsed time : " + duration/1000000);
	}
}