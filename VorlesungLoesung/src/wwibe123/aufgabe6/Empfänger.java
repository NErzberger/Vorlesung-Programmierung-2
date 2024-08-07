package wwibe123.aufgabe6;

import wwibe123.aufgabe5.MyQueue;

public class Empfänger implements Runnable{

	private int nr;
	
	private int waitTime;
	
	private boolean run;
	
	
	
	public Empfänger(int nr, int waitTime) {
		super();
		this.nr = nr;
		this.waitTime = waitTime;
		run = true;
	}

	@Override
	public void run() {
		while(run) {
			empfangen();
			
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			};
		}
		
	}
	
	public void empfangen() {
		String message = "";
		MyQueue<String> queue = MessageStream.getInstance();
		while(queue.size() > 0) {
			message = queue.dequeue();
			System.out.println("Empfänger ("+nr+"): " + message);
		}
	}
	
	public void stop() {
		run = false;
	}

}
