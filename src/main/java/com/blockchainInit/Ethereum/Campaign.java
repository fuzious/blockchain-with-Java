package com.blockchainInit.Ethereum;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.10.
 */
@SuppressWarnings("rawtypes")
public class Campaign extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b50604051610b94380380610b948339818101604052604081101561003357600080fd5b810190808051906020019092919080519060200190929190505050806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550816001819055505050610aee806100a66000396000f3fe6080604052600436106100865760003560e01c806382fde0931161005957806382fde093146102795780638a9cfd55146102a4578063937e09b114610396578063d7bb99ba146103c1578063d7d1bbdb146103cb57610086565b8063034410061461008b5780630a144391146100b9578063481c6a751461012257806381d12c5814610179575b600080fd5b6100b7600480360360208110156100a157600080fd5b8101908080359060200190929190505050610406565b005b3480156100c557600080fd5b50610108600480360360208110156100dc57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610547565b604051808215151515815260200191505060405180910390f35b34801561012e57600080fd5b50610137610567565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561018557600080fd5b506101b26004803603602081101561019c57600080fd5b810190808035906020019092919050505061058c565b60405180806020018681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200184151515158152602001838152602001828103825287818151815260200191508051906020019080838360005b8381101561023a57808201518184015260208101905061021f565b50505050905090810190601f1680156102675780820380516001836020036101000a031916815260200191505b50965050505050505060405180910390f35b34801561028557600080fd5b5061028e610694565b6040518082815260200191505060405180910390f35b3480156102b057600080fd5b50610394600480360360608110156102c757600080fd5b81019080803590602001906401000000008111156102e457600080fd5b8201836020820111156102f657600080fd5b8035906020019184600183028401116401000000008311171561031857600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f82011690508083019250505050505050919291929080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061069a565b005b3480156103a257600080fd5b506103ab61080d565b6040518082815260200191505060405180910390f35b6103c9610813565b005b3480156103d757600080fd5b50610404600480360360208110156103ee57600080fd5b810190808035906020019092919050505061088d565b005b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461045f57600080fd5b60006003828154811061046e57fe5b9060005260206000209060050201905060026004548161048a57fe5b048160030154101561049b57600080fd5b8060020160149054906101000a900460ff16156104b757600080fd5b8060020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc82600101549081150290604051600060405180830381858888f19350505050158015610525573d6000803e3d6000fd5b5060018160020160146101000a81548160ff0219169083151502179055505050565b60026020528060005260406000206000915054906101000a900460ff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6003818154811061059957fe5b9060005260206000209060050201600091509050806000018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156106455780601f1061061a57610100808354040283529160200191610645565b820191906000526020600020905b81548152906001019060200180831161062857829003601f168201915b5050505050908060010154908060020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060020160149054906101000a900460ff16908060030154905085565b60045481565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146106f357600080fd5b6106fb6109cd565b6040518060a001604052808581526020018481526020018373ffffffffffffffffffffffffffffffffffffffff16815260200160001515815260200160008152509050600381908060018154018082558091505090600182039060005260206000209060050201600090919290919091506000820151816000019080519060200190610788929190610a14565b506020820151816001015560408201518160020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060608201518160020160146101000a81548160ff0219169083151502179055506080820151816003015550505050505050565b60015481565b600154341161082157600080fd5b6001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff021916908315150217905550600460008154809291906001019190505550565b60006003828154811061089c57fe5b90600052602060002090600502019050600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff1661090257600080fd5b8060040160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff161561095b57600080fd5b60018160040160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555080600301600081548092919060010191905055505050565b6040518060a001604052806060815260200160008152602001600073ffffffffffffffffffffffffffffffffffffffff168152602001600015158152602001600081525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610a5557805160ff1916838001178555610a83565b82800160010185558215610a83579182015b82811115610a82578251825591602001919060010190610a67565b5b509050610a909190610a94565b5090565b610ab691905b80821115610ab2576000816000905550600101610a9a565b5090565b9056fea265627a7a723158202b865efe8858329fdb966de37f70a308d4ee5af8f177d22ae1b7edd9f90c169364736f6c634300050c0032";

    public static final String FUNC_APPROVERS = "approvers";

    public static final String FUNC_APPROVERSCOUNT = "approversCount";

    public static final String FUNC_MANAGER = "manager";

    public static final String FUNC_MINIMUMCONTRIBUTION = "minimumContribution";

    public static final String FUNC_REQUESTS = "requests";

    public static final String FUNC_CONTRIBUTE = "contribute";

    public static final String FUNC_CREATEREQUEST = "createRequest";

    public static final String FUNC_APPROVEREQUEST = "approveRequest";

    public static final String FUNC_FINALIZEREQUEST = "finalizeRequest";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected Campaign(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Campaign(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Campaign(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Campaign(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Boolean> approvers(String param0) {
        final Function function = new Function(FUNC_APPROVERS, 
                Arrays.<Type>asList(new Address(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> approversCount() {
        final Function function = new Function(FUNC_APPROVERSCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> manager() {
        final Function function = new Function(FUNC_MANAGER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> minimumContribution() {
        final Function function = new Function(FUNC_MINIMUMCONTRIBUTION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple5<String, BigInteger, String, Boolean, BigInteger>> requests(BigInteger param0) {
        final Function function = new Function(FUNC_REQUESTS, 
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple5<String, BigInteger, String, Boolean, BigInteger>>(function,
                new Callable<Tuple5<String, BigInteger, String, Boolean, BigInteger>>() {
                    @Override
                    public Tuple5<String, BigInteger, String, Boolean, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<String, BigInteger, String, Boolean, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (Boolean) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> contribute(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_CONTRIBUTE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> createRequest(String description, BigInteger value, String recipient) {
        final Function function = new Function(
                FUNC_CREATEREQUEST, 
                Arrays.<Type>asList(new Utf8String(description),
                new Uint256(value),
                new Address(recipient)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> approveRequest(BigInteger index) {
        final Function function = new Function(
                FUNC_APPROVEREQUEST, 
                Arrays.<Type>asList(new Uint256(index)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> finalizeRequest(BigInteger index, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_FINALIZEREQUEST, 
                Arrays.<Type>asList(new Uint256(index)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    @Deprecated
    public static Campaign load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Campaign(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Campaign load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Campaign(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Campaign load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Campaign(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Campaign load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Campaign(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Campaign> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger minimum, String creator) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Uint256(minimum),
                new Address(creator)));
        return deployRemoteCall(Campaign.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Campaign> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger minimum, String creator) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Uint256(minimum),
                new Address(creator)));
        return deployRemoteCall(Campaign.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Campaign> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger minimum, String creator) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Uint256(minimum),
                new Address(creator)));
        return deployRemoteCall(Campaign.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Campaign> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger minimum, String creator) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Uint256(minimum),
                new Address(creator)));
        return deployRemoteCall(Campaign.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
