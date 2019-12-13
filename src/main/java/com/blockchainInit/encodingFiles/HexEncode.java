package com.blockchainInit.encodingFiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class HexEncode {
	private final static String[] hexSymbols = { "0", "1", "2", "3", "4", "5", "6", "7" , "8", "9", "a", "b", "c", "d", "e", "f" };

	public final static int BITS_PER_HEX_DIGIT = 4;

	public static String toHexFromByte(final byte b) {
		byte leftSymbol = (byte)((b >>> BITS_PER_HEX_DIGIT) & 0x0f);
		byte rightSymbol = (byte)(b & 0x0f);

		return (hexSymbols[leftSymbol] + hexSymbols[rightSymbol]);
	}

	public static String toHexFromBytes(final byte[] bytes) {
		if(bytes == null || bytes.length == 0)
		{
			return ("");
		}

		// there are 2 hex digits per byte
		StringBuilder hexBuffer = new StringBuilder(bytes.length * 2);

		// for each byte, convert it to hex and append it to the buffer
		for(int i = 0; i < bytes.length; i++) {
			hexBuffer.append(toHexFromByte(bytes[i]));
		}

		return (hexBuffer.toString());
	}

	public static void main(String[] args) throws IOException {
		try {
			FileInputStream fis = new FileInputStream(new File("input.jpg"));
			BufferedWriter fos = new BufferedWriter(new FileWriter(new File("output.txt")));
			byte[] bytes = new byte[800];
			int value = 0;
			do {
				value = fis.read(bytes);
				fos.write(toHexFromBytes(bytes));

			}while(value != -1);

			fos.flush();
			fos.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
