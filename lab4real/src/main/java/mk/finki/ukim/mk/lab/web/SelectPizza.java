package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "select-pizza-servlet", urlPatterns = "/selectPizza.do")
public class SelectPizza extends HttpServlet {

    private final PizzaService pizzaService;
    private final SpringTemplateEngine springTemplateEngine;

    public SelectPizza(PizzaService pizzaService, SpringTemplateEngine springTemplateEngine){
        this.pizzaService = pizzaService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        String pizzaType = req.getParameter("pizza");

        Order order = new Order();
        order.setPizzaType(pizzaType);

        HttpSession session = req.getSession();
        session.setAttribute("order", order);

        webContext.setVariable("pizzaType", pizzaType);
        resp.setContentType("text/html; charset=UTF-8");
        this.springTemplateEngine.process("selectPizzaSize.html", webContext, resp.getWriter());
    }
}
