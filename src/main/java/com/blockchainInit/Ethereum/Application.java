package com.blockchainInit.Ethereum;

// reference : https://medium.com/coinmonks/ethereum-blockchain-hello-world-smart-contract-with-java-9b6ae2961ad1
// compiled solidity using solcjs
// then used web3j to generate wrapper class

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

//	public static void main(String[] args) throws Exception {
//		new Application().run();
//	}

	public HelloWorld_sol_HelloWorld run() throws Exception {
		BasicConfigurator.configure();
		// We start by creating a new web3j instance to connect to remote nodes on the network.
//		Web3j web3j = Web3j.build(new HttpService(""));
		Web3j web3j=Web3j.build(new HttpService("HTTP://127.0.0.1:7545"));

		log.info("Connected to Ethereum client version: "
				+ web3j.web3ClientVersion().send().getWeb3ClientVersion());
//		Credentials credentials = WalletUtils.loadCredentials("password", "chaindata\\keystore\\UTC--2018-06-21T06-34-32.658490800Z--5ade9a7f8f57ab3995ac4d56c78a22649d3b1686");
		Credentials credentials=Credentials.create("4d9b6a18dd42c142cce1784b36f97c2093176793c087bf1d96e13a8af63ef43d");
		log.info("Credentials loaded");
		log.info("Sending Ether ..");
//
//		TransactionReceipt transferReceipt = Transfer.sendFunds(web3j, credentials, "0xDc1Fb60F7E1eF6ef052A014EFbDF82debd803D06",  // you can put any address here
//				BigDecimal.valueOf(100), Convert.Unit.ETHER)  // 1 wei = 10^-18 Ether
//				.sendAsync().get();
//		log.info("Transaction complete : "
//				+ transferReceipt.getTransactionHash());
//
//
//		 Now lets deploy a smart contract
		log.info("Deploying smart contract");

		HelloWorld_sol_HelloWorld contract = HelloWorld_sol_HelloWorld.deploy(web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT).send();
			System.out.println("Smart Contract Deployed");
		return contract;
	}

	public String action(HelloWorld_sol_HelloWorld contract,String x) throws Exception {
//		String contractAddress = contract.getContractAddress();
//		log.info("Smart contract deployed to address " + contractAddress);
//
//		log.info("Initial value of counter in Smart contract: " + contract.getCounter().send());
//		log.info("Incrementing counter in Smart contract");
//		contract.add().send();
//		log.info("Value of counter in Smart contract after increment : " + contract.getCounter().send());
//		log.info("Decrementing counter in Smart contract");
//		contract.subtract().send();
//		log.info("Final value of counter in Smart contract : " + contract.getCounter().send());

		if(x.equals("increment")) {
			contract.add().sendAsync();
		}
		else if (x.equals("decrement")) {
			contract.subtract().sendAsync();
		}
		String get = contract.getCounter().sendAsync().get().toString();
		System.out.println(x+" "+get);
		return get;
	}
}


