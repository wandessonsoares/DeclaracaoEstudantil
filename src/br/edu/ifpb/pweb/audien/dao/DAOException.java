package br.edu.ifpb.pweb.audien.dao;

public class DAOException extends RuntimeException {

	public DAOException() {
		super();
	}

	public DAOException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DAOException(String arg0) {
		super(arg0);
	}

	public DAOException(Throwable arg0) {
		super(arg0);
	}

}
