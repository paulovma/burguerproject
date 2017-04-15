package br.com.entelgy.burguerproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

@SpringBootApplication
public class WebApplication
{

   public static void main(String[] args)
   {
      SpringApplication.run(WebApplication.class, args);
   }

}
