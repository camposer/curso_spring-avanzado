package springavanzado.ejercicio1.task;

public class TestTask implements Runnable {

	@Override
	public void run() {
		while(true) {
			System.out.println("Hola: " + Thread.currentThread().getId());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Thread(new TestTask()).start();
		new Thread(new TestTask()).start();
		new Thread(new TestTask()).start();
	}
}
