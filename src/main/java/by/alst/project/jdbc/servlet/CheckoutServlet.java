package by.alst.project.jdbc.servlet;

import by.alst.project.jdbc.dto.CheckoutDto;
import by.alst.project.jdbc.dto.InformationDto;
import by.alst.project.jdbc.dto.OrderDto;
import by.alst.project.jdbc.service.CheckoutService;
import by.alst.project.jdbc.service.InformationService;
import by.alst.project.jdbc.service.OrderService;
import by.alst.project.jdbc.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    private final CheckoutService checkoutService = CheckoutService.getInstance();
    private final InformationService informationService = InformationService.getInstance();
    private final OrderService orderService = OrderService.getInstance();
    private final ProductService productService = ProductService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        Integer usersId = Integer.valueOf(req.getParameter("usersId"));
        InformationDto informationDto = informationService.findById(usersId);

        try (var writer = resp.getWriter()) {
            writer.write("<h1>%s %s %s</h1>".formatted(informationDto.lastName(),
                    informationDto.firstName(), informationDto.secondName()));
            writer.write("<h2>Оформленные покупки:</h2>");
            writer.write("<ul>");

            BigDecimal totalCheckoutsCost = BigDecimal.ZERO;
            List<CheckoutDto> checkoutDtoList = checkoutService.findAllByUsersId(usersId);

            for (CheckoutDto checkoutDto : checkoutDtoList) {
                List<OrderDto> orderDtoList = orderService.findAllByCheckoutId(checkoutDto.id());
                BigDecimal checkoutCost = orderDtoList.stream().map(orderDto ->
                        orderDto.productAmount().multiply(productService.findById(orderDto.productId())
                                .productCost())).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
                totalCheckoutsCost = totalCheckoutsCost.add(checkoutCost);
                writer.write("""
                        <li>
                        <a href='/order?usersId=%d&checkoutId=%d'>%s в %s Стоимость: %s руб.</a>
                        </li>
                        """.formatted(usersId, checkoutDto.id(), checkoutDto.checkoutTime().toLocalDate().toString(),
                        checkoutDto.checkoutTime().toLocalTime().toString(), checkoutCost.toString()));
            }
            writer.write("</ul>");
            writer.write("<h2>Общая стоимость покупок: %s руб.</h2>".formatted(totalCheckoutsCost.toString()));
        }
    }
}
