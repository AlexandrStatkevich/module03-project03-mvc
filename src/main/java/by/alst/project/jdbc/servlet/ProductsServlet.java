package by.alst.project.jdbc.servlet;

import by.alst.project.jdbc.service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {

    private final ProductService productService = ProductService.getInstance();
    private final ProductGroupService productGroupService = ProductGroupService.getInstance();
    private final UnitService unitService = UnitService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        Integer productGroupId = Integer.valueOf(req.getParameter("productGroupId"));

        try (var writer = resp.getWriter()) {
            writer.write("<h1>%s:</h1>".formatted(productGroupService.findById(productGroupId).productGroup()));
            writer.write("<ul>");
            productService.findAllByProductGroupId(productGroupId).forEach(productDto ->
                    writer.write("""
                            <li>
                            <a href='/product?productId=%d'>%s - Цена: %s руб. - В наличии: %s %s.</a>
                            </li>
                            """.formatted(productDto.id(), productDto.productName(),
                            String.valueOf(productDto.productCost()),
                            String.valueOf(productDto.productAmount()),
                            unitService.findById(productDto.productUnitId()).unit())));
            writer.write("</ul>");
        }
    }
}