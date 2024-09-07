package by.alst.project.jdbc.servlet;

import by.alst.project.jdbc.service.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {

    private final CategoryService categoryService = CategoryService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (var writer = resp.getWriter()) {
            writer.write("<h1>Категории товаров:</h1>");
            writer.write("<ul>");

            categoryService.findAll().forEach(categoryDto ->
                    writer.write("""
                            <li>
                            <a href='/subcategory?categoryId=%d'>%s</a>
                            </li>
                            """.formatted(categoryDto.id(), categoryDto.category())));
            writer.write("</ul>");
        }
    }
}
