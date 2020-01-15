package com.blockchainInit.Ethereum;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.utils.Convert;

import java.math.BigInteger;

public class LotteryRunner {
	static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
	static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
	private static final Logger log = LoggerFactory.getLogger(LotteryRunner.class);
	public static void main(String[] args) throws Exception {
		BasicConfigurator.configure();
		Web3j web3j=Web3j.build(new HttpService("HTTP://127.0.0.1:7545"));
		Credentials credentials=Credentials.create("4d9b6a18dd42c142cce1784b36f97c2093176793c087bf1d96e13a8af63ef43d");
//		Lottery_sol_Lottery contract = Lottery_sol_Lottery.deploy(web3j, credentials,ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT).send();
		Lottery contract = Lottery.deploy(web3j,credentials, ManagedTransaction.GAS_PRICE,Contract.GAS_LIMIT,new BigInteger("0")).send();


		System.out.println("Smart Contract Deployed");

	}
}
