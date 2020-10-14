package DemoJoin;

public class MainDemoJoin {

	public static void main(String[] args) {
		Vector a = new Vector(50, "a");
		Vector b = new Vector(50, "b");
		a.start();
		b.start();
		try {
			a.join();
			b.join();
		}
		catch(InterruptedException e) {}
		System.out.println("Suma x a: " +a.getSuma());
		System.out.println("Suma x b: " +b.getSuma());
		System.out.println("Suma x^2 a: " +a.getSumaSqr());
		System.out.println("Suma x^2 b: " +b.getSumaSqr());
		System.out.println("Media a: " +a.getMedia());
		System.out.println("Media b: " +b.getMedia());
	}
}
