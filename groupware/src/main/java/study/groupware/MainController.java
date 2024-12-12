package study.groupware;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String main(HttpServletRequest request, Model model) {

        model.addAttribute("uri", request.getRequestURI());
        return "home";
    }
}
