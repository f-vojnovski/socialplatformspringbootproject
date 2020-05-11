package mk.finki.ukim.mk.lab.web;



import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "list-pizzas-service", urlPatterns = "/showPizza")
public class ShowPizza extends HttpServlet {
    private final PizzaService pizzaService;
    private final SpringTemplateEngine springTemplateEngine;

    public ShowPizza(SpringTemplateEngine springTemplateEngine, PizzaService pizzaService) {
        this.springTemplateEngine = springTemplateEngine;
        this.pizzaService = pizzaService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        List<Pizza> pizzas = pizzaService.listPizzas();
        webContext.setVariable("pizzas", pizzas);
        resp.setContentType("text/html; charset=UTF-8");
        this.springTemplateEngine.process("templates/listPizzas.html", webContext, resp.getWriter());
        }
    }
