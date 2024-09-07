package by.alst.project.jdbc.servlet;

import by.alst.project.jdbc.dto.ProductDto;
import by.alst.project.jdbc.service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    private final ProductService productService = ProductService.getInstance();
    private final ProducerService producerService = ProducerService.getInstance();
    private final CountryService countryService = CountryService.getInstance();
    private final UnitService unitService = UnitService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        Integer productId = Integer.valueOf(req.getParameter("productId"));
        ProductDto productDto = productService.findById(productId);

        try (var writer = resp.getWriter()) {
            writer.write("<h1>%s</h1>".formatted(productDto.productName()));
            writer.write("<ul>");
            writer.write("<h2>%s</h2>".formatted(productDto.productDescription()));
            writer.write("<h2>Цена: %s руб.</h2>".formatted(String.valueOf(productDto.productCost())));
            writer.write("<h2>Остаток %s %s.</h2>".formatted(String.valueOf(String.valueOf(productDto.productAmount())),
                    unitService.findById(productDto.productUnitId()).unit()));
            writer.write("<h2>Товар поступил: %s в %s</h2>".formatted(productDto.productArrivalDate().toLocalDate().toString(),
                    productDto.productArrivalDate().toLocalTime().toString()));
            writer.write("<h2>Производитель: %s</h2>"
                    .formatted(producerService.findById(productDto.productProducerId()).producerName()));
            writer.write("<h2>Адрес производства: %s</h2>"
                    .formatted(producerService.findById(productDto.productProducerId()).producerAddress()));
            writer.write("<h2>Страна производства: %s</h2>"
                    .formatted(countryService.findById(productDto.countryOriginId()).country()));
            writer.write("</ul>");
        }
    }
}
