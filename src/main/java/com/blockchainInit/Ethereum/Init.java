package com.blockchainInit.Ethereum;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.BasicConfigurator;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.Response;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Init {

	final static String sendingAddress = "0x72363dA88398E4aED3d6Ff532F19aDC4b1C21655";
	final static String receivingAddress = "0xFA8B224177372647A987B1933868353234fD9ac5";

	public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
//		test1();
		test2();
//		test3();
	}

	static void test1() throws IOException {
		BasicConfigurator.configure();

		Web3j web3a=Web3j.build(new HttpService("https://rinkeby.infura.io/v3/5ead597854fc415d97a3626c3fa39fb3"));
		System.out.println();
		EthGetBalance balanceWei = web3a.ethGetBalance("0x8E21D1CE02fD6Cec455Da473b9D969424bAa9678", DefaultBlockParameterName.LATEST).send();
		BigDecimal balanceInEther = Convert.fromWei(balanceWei.getBalance().toString(), Convert.Unit.ETHER);
		System.out.println("balance in ether: " + balanceInEther + "wei balance : "+balanceWei.getBalance() );

		EthGetTransactionCount txnCount = web3a.ethGetTransactionCount("0x742d35Cc6634C0532925a3b844Bc454e4438f44e"
				,DefaultBlockParameterName.LATEST).send();
		BigInteger nonce = txnCount.getTransactionCount();
		System.out.println("Transaction Count "+ nonce);

		ObjectMapper objectMapper=new ObjectMapper();
		//		String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
		String abi ="[{\"constant\":true,\"inputs\":[],\"name\":\"batFundDeposit\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"name\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_spender\",\"type\":\"address\"},{\"name\":\"_value\",\"type\":\"uint256\"}],\"name\":\"approve\",\"outputs\":[{\"name\":\"success\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"totalSupply\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"batFund\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_from\",\"type\":\"address\"},{\"name\":\"_to\",\"type\":\"address\"},{\"name\":\"_value\",\"type\":\"uint256\"}],\"name\":\"transferFrom\",\"outputs\":[{\"name\":\"success\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"decimals\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"tokenExchangeRate\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"finalize\",\"outputs\":[],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"version\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"refund\",\"outputs\":[],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"tokenCreationCap\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_owner\",\"type\":\"address\"}],\"name\":\"balanceOf\",\"outputs\":[{\"name\":\"balance\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"isFinalized\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"fundingEndBlock\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"symbol\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"ethFundDeposit\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_to\",\"type\":\"address\"},{\"name\":\"_value\",\"type\":\"uint256\"}],\"name\":\"transfer\",\"outputs\":[{\"name\":\"success\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"createTokens\",\"outputs\":[],\"payable\":true,\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"tokenCreationMin\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"fundingStartBlock\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_owner\",\"type\":\"address\"},{\"name\":\"_spender\",\"type\":\"address\"}],\"name\":\"allowance\",\"outputs\":[{\"name\":\"remaining\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"},{\"inputs\":[{\"name\":\"_ethFundDeposit\",\"type\":\"address\"},{\"name\":\"_batFundDeposit\",\"type\":\"address\"},{\"name\":\"_fundingStartBlock\",\"type\":\"uint256\"},{\"name\":\"_fundingEndBlock\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":true,\"name\":\"_to\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"_value\",\"type\":\"uint256\"}],\"name\":\"LogRefund\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":true,\"name\":\"_to\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"_value\",\"type\":\"uint256\"}],\"name\":\"CreateBAT\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":true,\"name\":\"_from\",\"type\":\"address\"},{\"indexed\":true,\"name\":\"_to\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"_value\",\"type\":\"uint256\"}],\"name\":\"Transfer\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":true,\"name\":\"_owner\",\"type\":\"address\"},{\"indexed\":true,\"name\":\"_spender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"_value\",\"type\":\"uint256\"}],\"name\":\"Approval\",\"type\":\"event\"}]";
		Map<String, Object> map = objectMapper.readValue(abi, new TypeReference<Map<String,Object>>(){});
		System.out.println(map.get("type"));
	}

	@SuppressWarnings("Index")
	static void test2() throws IOException, ExecutionException, InterruptedException {
		BasicConfigurator.configure();

		Web3j web3a=Web3j.build(new HttpService("HTTP://127.0.0.1:7545"));
		EthAccounts accounts=web3a.ethAccounts().send();
		// list all the accounts
		System.out.println(accounts.getAccounts());
		EthGetBalance ethGetBalance= web3a.ethGetBalance(receivingAddress,DefaultBlockParameterName.LATEST).sendAsync().get();

		System.out.println(ethGetBalance.getBalance());


		BigInteger value=new BigInteger("100");
		BigInteger nonce=new BigInteger("3");
		BigInteger gasPrice=new BigInteger("20000000");
		BigInteger gasLimit=new BigInteger("30000");


		Credentials credentials=Credentials.create("4d9b6a18dd42c142cce1784b36f97c2093176793c087bf1d96e13a8af63ef43d");
		RawTransaction rawTransaction=RawTransaction.createEtherTransaction(nonce,gasPrice,gasLimit,receivingAddress,value);
		byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction,credentials);
		String hexValue = Numeric.toHexString(signedMessage);
		EthSendTransaction ethSendTransaction = web3a.ethSendRawTransaction(hexValue).send();
		Response.Error error=ethSendTransaction.getError();
		String transactionHash = ethSendTransaction.getTransactionHash();

		System.out.println(transactionHash);

		web3a.shutdown();

		System.out.println("shutdown");
	}

	static void test3() {
		System.out.println("Connecting to Ethereum ...");
		Web3j web3 = Web3j.build(new HttpService("http://localhost:7545"));
		System.out.println("Successfuly connected to Ethereum");

		try {
			// web3_clientVersion returns the current client version.
			Web3ClientVersion clientVersion = web3.web3ClientVersion().send();

			// eth_blockNumber returns the number of most recent block.
			EthBlockNumber blockNumber = web3.ethBlockNumber().send();

			// eth_gasPrice, returns the current price per gas in wei.
			EthGasPrice gasPrice = web3.ethGasPrice().send();

			// Print result
			System.out.println("Client version: " + clientVersion.getWeb3ClientVersion());
			System.out.println("Block number: " + blockNumber.getBlockNumber());
			System.out.println("Gas price: " + gasPrice.getGasPrice());

		} catch (IOException ex) {
			throw new RuntimeException("Error whilst sending json-rpc requests", ex);
		}
	}

}
