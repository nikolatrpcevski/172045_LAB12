package mk.finki.ukim.mk.lab.web.servlet;

import mk.finki.ukim.mk.lab.service.BalloonService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ConfirmationInfoServlet", urlPatterns = "/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {

    private final BalloonService balloonService;
    private final SpringTemplateEngine templateEngine;

    public ConfirmationInfoServlet(BalloonService balloonService, SpringTemplateEngine templateEngine) {
        this.balloonService = balloonService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext = new WebContext(req, resp, req.getServletContext());

        webContext.setVariable("nameClient", req.getSession().getAttribute("name"));
        webContext.setVariable("addressClient", req.getSession().getAttribute("address"));
        webContext.setVariable("balloonColor", req.getSession().getAttribute("color"));
        webContext.setVariable("ballonSize", req.getSession().getAttribute("size"));
    }

}
