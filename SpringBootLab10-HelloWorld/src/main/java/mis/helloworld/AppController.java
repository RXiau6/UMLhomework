/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mis.helloworld;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author rxiau6-PC
 */
@Controller
public class AppController {

    @RequestMapping("/")
    public String homeFirst() {
        return "home-first.html";
    }

    @RequestMapping("/showtime")
    public String currentTime(Model model) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String current_time = dateFormat.format(date);
        System.out.println("Now time : " + current_time);

        model.addAttribute("currentTime", current_time);
        System.out.println(model.toString());
        return "show-current-time.html";
    }

    @RequestMapping("/inputname")
    public String homeInputName() {
        return "home-input-name.html";
    }

    @RequestMapping(value = "/showname")
   public String showName(String name, Model model) {
        System.out.println(name);
        String response = "同學您好!" + name;
        model.addAttribute("msg", response);
        return "show-name.html";
    }

}
