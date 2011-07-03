package com.bitcoinlabs.android2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import android.net.Uri;

import com.google.bitcoin.core.*;

@SuppressWarnings("serial")
public class BitcoinURI implements Serializable {

	public static final int ADDRESSES_URI = 1;
	//public static final int TRANSACTIONS_URI = 2;
	//public static final int KEYS_URI = 3;
	
	int type;
	String text;
	
	List<String> addresses;
	BigDecimal amount;
	
	List<byte[]> transactions;
	
	List<String> privateKeys58;
	
	public BitcoinURI(String text) throws InvalidURIException {
		
		// Before the first "?" (if any):
		// 		bitcoin:ADDRESS
		// 		ADDRESS
		// 		http://blockexplorer.com/address/ADDRESS
		
		// If there is a /"\?.*/, parse it as a query string
		// 		amount=0.10

		addresses = new ArrayList<String>();
		
		String[] bits = text.split("\\?");
		
		String firstPart = bits[0];
		
		String[] firstPartBits = firstPart.split("[:/]");
		String address58 = firstPartBits[firstPartBits.length - 1];
		address58 = StringUtils.strip(address58, " \t\r\n");
		
		try {
			new Address(NetworkParameters.prodNet(), address58);
			addresses.add(address58);
		} catch (AddressFormatException e) {
			throw new InvalidURIException(e);
		}
		
		// query string
		if (bits.length > 1) {
			if (bits.length > 2) {
				throw new InvalidURIException("Multiple \"?\"s");
			}
			Uri uri = Uri.parse("http://example.com/?" + bits[1]);
			String amountStr = uri.getQueryParameter("amount");
			if (amountStr != null) {
				try {
					amount = new BigDecimal(amountStr);
					if ( ! Util.isValidBitcoinAmount(amount)) {
						throw new InvalidURIException("Invalid bitcoin amount");
					}
				}
				catch (NumberFormatException e) {
					throw new InvalidURIException("Invalid amount format");
				}
			}
		}
	}
}
