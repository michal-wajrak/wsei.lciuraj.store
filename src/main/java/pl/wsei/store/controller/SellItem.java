package pl.wsei.store.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.wsei.store.service.BasketService;

import java.io.IOException;

@WebServlet(name = "SellItemServlet", value = "/sell-item")
public class SellItem extends HttpServlet {

    private final BasketService basketService = new BasketService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String item = request.getParameter("item");
        String inputQuantity = request.getParameter("quantity");

        int quantity;

        try {
            quantity = Integer.parseInt(inputQuantity);
        } catch (NumberFormatException e) {
            quantity = 1;
        }

        try {
            basketService.sellItem(item, quantity);
            response.sendRedirect(request.getContextPath() + "/basket-servlet");
        } catch (Exception e) {
            throw new ServletException("Error processing request", e);
        }
    }
}
