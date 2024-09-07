package by.alst.project.jdbc.servlet;

import by.alst.project.jdbc.dto.CheckoutDto;
import by.alst.project.jdbc.dto.DeliveryDto;
import by.alst.project.jdbc.dto.InformationDto;
import by.alst.project.jdbc.service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    private final CheckoutService checkoutService = CheckoutService.getInstance();
    private final InformationService informationService = InformationService.getInstance();
    private final OrderService orderService = OrderService.getInstance();
    private final ProductService productService = ProductService.getInstance();
    private final DeliveryService deliveryService = DeliveryService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        Integer usersId = Integer.valueOf(req.getParameter("usersId"));
        Integer checkoutId = Integer.valueOf(req.getParameter("checkoutId"));
        InformationDto informationDto = informationService.findById(usersId);
        CheckoutDto checkoutDto = checkoutService.findById(checkoutId);
        DeliveryDto deliveryDto = deliveryService.findById(checkoutId);

        try (var writer = resp.getWriter()) {
            writer.write("<h1>%s %s %s</h1>".formatted(informationDto.lastName(),
                    informationDto.firstName(), informationDto.secondName()));
            writer.write("<h2>Телефон: %s</h2>".formatted(informationDto.phone()));
            writer.write("<h2>Оформлено: %s в %s</h2>".formatted(checkoutDto.checkoutTime().toLocalDate().toString(),
                    checkoutDto.checkoutTime().toLocalTime().toString()));
            writer.write("<h2>Доставка по адресу %s</h2>".formatted(deliveryDto.deliveryAddress()));
            writer.write("<h2>Дата и время доставки: %s к %s</h2>".formatted(deliveryDto.deliveryDateTime()
                    .toLocalDate().toString(), deliveryDto.deliveryDateTime().toLocalTime().toString()));
            writer.write("<ul>");

            orderService.findAllByCheckoutId(checkoutId).forEach(orderDto ->
                    writer.write("""
                            <li>
                            <a>%s Цена: %s руб. Количество: %s Стоимость: %s руб.</a>
                            </li>
                            """.formatted(productService.findById(orderDto.productId()).productName(),
                            productService.findById(orderDto.productId()).productCost().toString(),
                            orderDto.productAmount(), productService.findById(orderDto.productId()).productCost()
                                    .multiply(orderDto.productAmount()).toString())));
            writer.write("</ul>");

            BigDecimal checkoutCost = orderService.findAllByCheckoutId(checkoutId).stream().map(orderDto ->
                            orderDto.productAmount().multiply(productService.findById(orderDto.productId()).productCost()))
                    .reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
            writer.write("<h2>Общая стоимость покупки: %s руб.</h2>".formatted(checkoutCost.toString()));
        }
    }
}