package by.alst.project.jdbc.servlet;

import by.alst.project.jdbc.service.ProductGroupService;
import by.alst.project.jdbc.service.SubcategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/productGroup")
public class ProductGroupServlet extends HttpServlet {

    private final ProductGroupService productGroupService = ProductGroupService.getInstance();
    private final SubcategoryService subcategoryService = SubcategoryService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        Integer subcategoryId = Integer.valueOf(req.getParameter("subcategoryId"));

        try (var writer = resp.getWriter()) {
            writer.write("<h1>%s:</h1>".formatted(subcategoryService.findById(subcategoryId).subcategory()));
            writer.write("<ul>");
            productGroupService.findAllBySubcategoryId(subcategoryId).forEach(productGroupDto ->
                    writer.write("""
                            <li>
                            <a href='/products?productGroupId=%d'>%s</a>
                            </li>
                            """.formatted(productGroupDto.id(), productGroupDto.productGroup())));
            writer.write("</ul>");
        }
    }
}