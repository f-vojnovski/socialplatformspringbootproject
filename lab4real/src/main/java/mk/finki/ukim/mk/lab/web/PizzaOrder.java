package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.service.OrderService;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "order-pizza-servlet", urlPatterns = "/orderPizza.do")
public class PizzaOrder extends HttpServlet {

    private final PizzaService pizzaService;
    private final OrderService orderService;
    private final SpringTemplateEngine springTemplateEngine;

    public PizzaOrder(PizzaService pizzaService, OrderService orderService, SpringTemplateEngine springTemplateEngine){
        this.pizzaService = pizzaService;
        this.orderService = orderService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        String pizzaSize = req.getParameter("pizza_size");

        HttpSession session = req.getSession();
        Order order = (Order) session.getAttribute("order");
        order.setPizzaSize(pizzaSize);
        session.setAttribute("order",order);

        webContext.setVariable("order", order);
        resp.setContentType("text/html; charset=UTF-8");
        this.springTemplateEngine.process("deliveryInfo.html", webContext, resp.getWriter());
    }
}
