package com.blockchainInit.webservice.rest;

import com.blockchainInit.webservice.entity.Block;
import com.blockchainInit.webservice.entity.Chain;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.hash.Hashing;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BlockRestController {

	@GetMapping("/hash")
	public String getHash () {
		Chain x=new Chain();
		x.addBlock(new Block("0","Udacity Blockchain Developer",1538509789));
		x.addBlock(new Block("1" ,"Udacity Blockchain Developer Rock!",1538509789));
		return (getHash(x.getChain().get(1)));
	}

	@PostMapping("/hash")
	public String postHash () {
		return getHash();
	}

	public String getHash( Block x) {
		ObjectMapper objectMapper=new ObjectMapper();
		String jsonString="";
		try {
			jsonString = objectMapper.writeValueAsString(x);
			System.out.println(jsonString);
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		finally {
			return Hashing.sha256().hashString(jsonString, StandardCharsets.UTF_8).toString();
		}
	}
}
