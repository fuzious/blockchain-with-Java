package com.blockchainInit.webservice.entity;

import java.util.ArrayList;
import java.util.List;

public class Chain {

	private List<Block> chain;

	public Chain() {
		chain = new ArrayList<>();
	}

	public void addBlock(Block x) {
		chain.add(x);
	}

	public List<Block> getChain() {
		return chain;
	}

}
