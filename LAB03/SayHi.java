/* Example of a thread
 * Each object has a none-static variable 
 */

class SayHiThread extends Thread {

    private String name;
    private static int howmanytimes = 10;

    public SayHiThread(String name) {
		this.name = name;
    }
    public void run() {
		int i;
		for(i=0; i < howmanytimes; i ++)
			System.out.println(this.name + " says hi, running as thread "+
					Thread.currentThread().getId());
    }
}


/* the main function */
public class SayHi {
    public static void main(String [] args) {
	System.out.println("I am Main, my id " +
			   Thread.currentThread().getId());
	
	SayHiThread t = new SayHiThread("Main");
	t.run();// I will have access to sam
	System.out.println("Now creating threads"); 
	
	/* now lets create some threads */
	Thread t0 = new SayHiThread("Sam");
	Thread t1 = new SayHiThread("Ann");
	
	t0.start(); // this will create a new thread, and run the
	// public void run() function in that new thread
	SayHiThread t2 = new SayHiThread("Ann");
	t1.start(); 
    }
}
	
