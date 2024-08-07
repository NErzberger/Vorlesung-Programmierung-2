package wwibe123.aufgabe6;

public class Aufgabe6 {

	public static void main(String[] args) {
		MessageStream.build();
		
		Sender sender1 = new Sender(1, 600);
		Sender sender2 = new Sender(2, 1000);
		Sender sender3 = new Sender(3, 500);

		Empfänger empfänger1 = new Empfänger(1, 800);
		Empfänger empfänger2 = new Empfänger(1, 1000);
		
		Thread thread1 = new Thread(sender1);
		Thread thread2 = new Thread(sender2);
		Thread thread3 = new Thread(sender3);
		
		Thread thread4 = new Thread(empfänger1);
		Thread thread5 = new Thread(empfänger2);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		
		try {
			Thread.sleep(120000); //120 Sekunden
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		sender1.stop();
		sender2.stop();
		sender3.stop();
		empfänger1.stop();
		empfänger2.stop();
	}

}
