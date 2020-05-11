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

@WebServlet(name = "confirmation-info-servlet", urlPatterns = "/confirmationInfo.do")
public class ConfirmationInfo extends HttpServlet {

    private final PizzaService pizzaService;
    private final OrderService orderService;
    private final SpringTemplateEngine springTemplateEngine;

    public ConfirmationInfo(PizzaService pizzaService, OrderService orderService, SpringTemplateEngine springTemplateEngine){
        this.pizzaService = pizzaService;
        this.orderService = orderService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {



        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        String clientName = req.getParameter("clientName");
        String clientAddress = req.getParameter("clientAddress");

        HttpSession session = req.getSession();
        Order order = (Order) session.getAttribute("order");

        order = orderService.placeOrder(order.getPizzaType(),order.getPizzaSize(),clientName,clientAddress);
        session.setAttribute("order",order);

        String ip = req.getRemoteAddr();
        String userAgent = req.getHeader("User-Agent");
        String browser = this.getBrowser(userAgent);
        String os = this.getOs(userAgent);

        webContext.setVariable("ip",ip);
        webContext.setVariable("browser",browser);
        webContext.setVariable("os", os);
        webContext.setVariable("order", order);
        resp.setContentType("text/html; charset=UTF-8");
        this.springTemplateEngine.process("confirmationInfo.html", webContext, resp.getWriter());
    }


    private String getBrowser(String userAgent) {
        String browserType = "";
        String browserVersion = "";
        if (userAgent.contains("Edge/")) {
            browserType = "Edge";
            browserVersion = userAgent.substring(userAgent.indexOf("Edge")).split("/")[1];

        } else if (userAgent.contains("Safari/") && userAgent.contains("Version/")) {
            browserType = "Safari";
            browserVersion = userAgent.substring(userAgent.indexOf("Version/")+8).split(" ")[0];

        } else if (userAgent.contains("OPR/") || userAgent.contains("Opera/")) {
            browserType = "Opera";
            browserVersion = userAgent.substring(userAgent.indexOf("OPR")).split("/")[1];

        } else if (userAgent.contains("Chrome/")) {
            browserType = "Chrome";
            browserVersion = userAgent.substring(userAgent.indexOf("Chrome")).split("/")[1];
            browserVersion = browserVersion.split(" ")[0];

        } else if (userAgent.contains("Firefox/")) {
            browserType = "Firefox";
            browserVersion = userAgent.substring(userAgent.indexOf("Firefox")).split("/")[1];
        }

        return browserType + " " + browserVersion;
    }

    private String getOs(String userAgent) {
        String osType = "";
        String osVersion = "";

        if (userAgent.contains("Windows NT")) {
            osType = "Windows";
            osVersion = userAgent.substring(userAgent.indexOf("Windows NT ")+11, userAgent.indexOf(";"));

        } else if (userAgent.contains("Mac OS")) {
            osType = "Mac";
            osVersion = userAgent.substring(userAgent.indexOf("Mac OS ")+7, userAgent.indexOf(")"));

        } else if (userAgent.contains("X11")) {
            osType = "Unix";
            osVersion = "Unknown";

        } else if (userAgent.contains("android")) {
            osType = "Android";
            osVersion = "Unknown";
        }

        return osType + " " + osVersion;
    }

}
