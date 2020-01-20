package com.blockchainInit.Ethereum;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.utils.Convert;

import java.math.BigInteger;
import java.util.List;

public class LotteryRunner {
	static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
	static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
	private static final Logger log = LoggerFactory.getLogger(LotteryRunner.class);
	public static void main(String[] args) throws Exception {
		BasicConfigurator.configure();
		Web3j web3j=Web3j.build(new HttpService("HTTP://127.0.0.1:7545"));
		String contractAddress="0x8f9eaf556aF1B33874bFcd89147298Dff39bB3af";
		Credentials credentials1=Credentials.create("4d9b6a18dd42c142cce1784b36f97c2093176793c087bf1d96e13a8af63ef43d");
		Credentials credentials2=Credentials.create("e0299a26047efbafb650b1d697ea2095be4239d23ac1bbc8fdbb5ee39a91ae9c");
//		Lottery_sol_Lottery contract = Lottery_sol_Lottery.deploy(web3j, credentials,ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT).send();
//		Lottery lottery = Lottery.deploy(web3j,credentials, ManagedTransaction.GAS_PRICE,Contract.GAS_LIMIT,new BigInteger("0")).send();
//		lottery.enter(Convert.toWei("0.02", Convert.Unit.ETHER).toBigInteger());
		Lottery lottery1 = Lottery.load(contractAddress,web3j,credentials1,ManagedTransaction.GAS_PRICE,Contract.GAS_LIMIT);
		Lottery lottery2 = Lottery.load(contractAddress,web3j,credentials2,ManagedTransaction.GAS_PRICE,Contract.GAS_LIMIT);
//		lottery1.enter(Convert.toWei("2", Convert.Unit.ETHER).toBigInteger()).send();
		System.out.println("Balance : "+web3j.ethGetBalance(contractAddress, DefaultBlockParameterName.LATEST).send().getBalance());
		try {
//			web3j.ethGetBalance()
			lottery2.enter(Convert.toWei("0", Convert.Unit.ETHER).toBigInteger()).send()
					.getTransactionHash();
		}
		catch (Exception e) {
			System.out.println("Error occurred as expected due to insufficient entry fee");
			e.printStackTrace();
		}
		List playerList= lottery1.getPlayers().send();
		System.out.println(playerList.get(0)+" "+playerList.get(1));
//		try {
//			lottery2.pickWinner().send();
//		}
//		catch (Exception e) {
//			System.out.println("Lottery might not have been picked up by creator");
//			e.printStackTrace();
//		}
//		try {
//			lottery1.pickWinner().send();
//			System.out.println("final size of players array: "+ lottery1.getPlayers().send().size());
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
		System.out.println("Smart Contract Deployed");
	}
}
