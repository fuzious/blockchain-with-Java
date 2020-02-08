package com.blockchainInit.Ethereum;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;

import java.math.BigInteger;
import java.util.List;

public class CampaignRunner {

	private static final Logger log = LoggerFactory.getLogger(LotteryRunner.class);

	public static void main(String[] args) throws Exception {

		BasicConfigurator.configure();
		Web3j web3j=Web3j.build(new HttpService("HTTP://127.0.0.1:7545"));
		Credentials credentials1=Credentials.create("4d9b6a18dd42c142cce1784b36f97c2093176793c087bf1d96e13a8af63ef43d");
		Credentials credentials2=Credentials.create("e0299a26047efbafb650b1d697ea2095be4239d23ac1bbc8fdbb5ee39a91ae9c");
		CampaignFactory campaignFactory=CampaignFactory.deploy(web3j,credentials1,ManagedTransaction.GAS_PRICE,Contract.GAS_LIMIT).send();
		campaignFactory.createCampaign(new BigInteger("1")).send();
		List deployedCampaigns=campaignFactory.getDeployedCampaigns().send();
		Campaign campaignFactory1=Campaign.load(deployedCampaigns.get(0).toString(),web3j,credentials2,ManagedTransaction.GAS_PRICE,Contract.GAS_LIMIT); 
		System.out.println(campaignFactory1.manager().send());
	}

}
