package wwibe123.aufgabe6;


import wwibe123.aufgabe5.MyQueue;

public class MessageStream {

	private static MyQueue<String> stream;
	
	public static void build() {
		stream = new MyQueue<String>();
	}
	
	public static MyQueue<String> getInstance(){
		if(stream!=null) {
			return stream;
		}else {
			throw new NullPointerException();
		}
	}
}
