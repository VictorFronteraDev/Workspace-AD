package exceptions;

public class ConnectionExeption extends RuntimeException{
	
	public ConnectionExeption() {
		super();
	}
	
	public ConnectionExeption(String msg) {
		super(msg);
	}

}
