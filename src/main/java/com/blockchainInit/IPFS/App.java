package com.blockchainInit.IPFS;

import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {
		IPFS ipfs = new IPFS("/dnsaddr/ipfs.infura.io/tcp/5001/https");
		try {
			NamedStreamable.InputStreamWrapper is = new NamedStreamable.InputStreamWrapper(new FileInputStream("hello.txt"));
			MerkleNode response = ipfs.add(is).get(0);
			System.out.println("Hash (base 58): " + response.name.get() + " - " + response.hash.toBase58());
		} catch (IOException ex) {
			throw new RuntimeException("Error whilst communicating with the IPFS node", ex);
		}
	}

}
