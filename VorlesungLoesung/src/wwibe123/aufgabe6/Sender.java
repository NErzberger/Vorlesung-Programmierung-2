package wwibe123.aufgabe6;

import wwibe123.aufgabe5.MyQueue;

public class Sender implements Runnable{

	private int nr;
	
	private int messageNr;
	
	private int waitTime;
	
	private boolean run;
	
	public Sender(int nr, int waitTime) {
		super();
		this.nr = nr;
		this.waitTime = waitTime;
		run = true;
	}

	public void stop() {
		run = false;
	}

	@Override
	public void run() {
		while(run) {
			sendMessage();
			
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void sendMessage() {
		messageNr++;
		String message = "Sender ("+nr+"): "+ messageNr;
		MyQueue<String> queue = MessageStream.getInstance();
		queue.enqueue(message);
	}

}
