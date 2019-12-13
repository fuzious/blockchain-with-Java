package com.blockchainInit.encodingFiles;

import javax.xml.bind.DatatypeConverter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;

public class HexDecode {
	public static String read () {
		BufferedReader reader = null;
		StringBuilder text= new StringBuilder();
		try {
			File file = new File("output.txt");
			reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				text.append(line);
			}

			return text.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return text.toString();
		}
	}

	public static byte[] decodeHexString(String hexString) {
		if (hexString.length() % 2 == 1) {
			throw new IllegalArgumentException(
					"Invalid hexadecimal String supplied.");
		}

		byte[] bytes = new byte[hexString.length() / 2];
		for (int i = 0; i < hexString.length(); i += 2) {
			bytes[i / 2] = hexToByte(hexString.substring(i, i + 2));
		}
		return bytes;
	}

	public static byte hexToByte(String hexString) {
		int firstDigit = toDigit(hexString.charAt(0));
		int secondDigit = toDigit(hexString.charAt(1));
		return (byte) ((firstDigit << 4) + secondDigit);
	}

	private static int toDigit(char hexChar) {
		int digit = Character.digit(hexChar, 16);
		if(digit == -1) {
			throw new IllegalArgumentException(
					"Invalid Hexadecimal Character: "+ hexChar);
		}
		return digit;
	}

	public static void main(String[] args) {
		String text = read();
		System.out.println(text);
		byte[] bytes = DatatypeConverter.parseHexBinary(text);

		System.out.println(Arrays.toString(bytes));
		PrintWriter PW=null;
		try {
			String result=new String(bytes,"UTF-8");
			System.out.println(result);
			PW=new PrintWriter(new File("output.jpg"));
			PW.println(result);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			PW.close();
		}
	}

	static String hexToBin(String s) {
		return new BigInteger(s, 16).toString(2);
	}
}
