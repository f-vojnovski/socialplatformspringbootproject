package mk.finki.ukim.mk.lab.web;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "thymeleaf", urlPatterns = "*.html")
public class ThymeleafBasicServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;

    public ThymeleafBasicServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        WebContext webContext = new WebContext(request, response, request.getServletContext());
        webContext.setVariable("recipient", session.getAttribute("username"));
        webContext.setVariable("ipaddress", request.getRemoteHost());
        this.springTemplateEngine.process("thymeleaf-index.html", webContext, response.getWriter());
    }


}
