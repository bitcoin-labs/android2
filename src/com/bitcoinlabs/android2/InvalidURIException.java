package com.bitcoinlabs.android2;

@SuppressWarnings("serial")
public class InvalidURIException extends Exception {

	public InvalidURIException() {
		super();
	}

	public InvalidURIException(String detailMessage) {
		super(detailMessage);
	}

	public InvalidURIException(Throwable throwable) {
		super(throwable);
	}

	public InvalidURIException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}
}
