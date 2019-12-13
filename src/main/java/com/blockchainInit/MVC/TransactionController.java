package com.blockchainInit.MVC;

import com.blockchainInit.Ethereum.Application;
import com.blockchainInit.Ethereum.HelloWorld_sol_HelloWorld;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/counter")
public class TransactionController {
	HelloWorld_sol_HelloWorld contract;
	Application app = new Application();
	@PostConstruct
	public void contractDeployer() throws Exception {

		contract=app.run();
	}

	@RequestMapping("/show")
	public String showCounter(Model theModel,@ModelAttribute("x") Operation x) {
		theModel.addAttribute("operationType",x);
		return "counter";
	}



	@RequestMapping("/operation")
	public String operation(@ModelAttribute("operationType") String x,Model theModel) throws Exception {
		String out=app.action(contract,x);
		if(x.equals("getValue")) {
			theModel.addAttribute("counter", out);
			return "getCounter";
		}
		else
			return "redirect:show";
	}
}
