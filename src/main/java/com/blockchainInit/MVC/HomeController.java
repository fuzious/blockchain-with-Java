package com.blockchainInit.MVC;

import com.blockchainInit.Ethereum.Application;
import com.blockchainInit.Ethereum.HelloWorld_sol_HelloWorld;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.PostConstruct;

@Controller
public class HomeController {
    HelloWorld_sol_HelloWorld visitor;
    Application app=new Application();
    @RequestMapping("/")
    public String showPage() throws Exception {
        app.action(visitor,"increment");
        return "main-menu";
    }
    @PostConstruct
    public void visitCounterInit() throws Exception {
        visitor=app.run();
    }
    @RequestMapping("/visitor")
    public String visitor(Model theModel) throws Exception {
        String out=app.action(visitor,"getValue");
        theModel.addAttribute("number",Integer.parseInt(out)-6+"");  //subtracting 5 since the solidty code contained the initial global variable value as 1
        return "visitor";
    }
}
