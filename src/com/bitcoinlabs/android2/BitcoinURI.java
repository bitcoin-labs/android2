package com.bitcoinlabs.android2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class BitcoinURI implements Serializable {

	public static final int ADDRESSES_URI = 1;
	public static final int TRANSACTIONS_URI = 2;
	public static final int KEYS_URI = 3;
	
	int type;
	
	List<String> addresses;
	BigDecimal amount;
	
	List<byte[]> transactions;
	
	List<String> privateKeys;
	
	public BitcoinURI(String text) throws InvalidURIException {
		throw new InvalidURIException("TODO");
	}
}
