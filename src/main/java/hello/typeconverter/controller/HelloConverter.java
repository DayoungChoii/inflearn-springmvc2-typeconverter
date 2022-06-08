package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloConverter {

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        String data = request.getParameter("data");
        Integer intVal = Integer.valueOf(data);
        System.out.println("intValue = " + intVal);
        return "ok";
    }

    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data) {
        System.out.println("data = " + data);
        return "ok";
    }

    @GetMapping("/ip-port")
    public String ipPort(@RequestParam IpPort ipPort) {
        System.out.println("ipPort IP = " + ipPort.getIp());
        System.out.println("ipPort Port = " +ipPort.getPort());
        return "ok";
    }
}
