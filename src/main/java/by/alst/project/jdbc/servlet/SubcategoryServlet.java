package by.alst.project.jdbc.servlet;

import by.alst.project.jdbc.service.CategoryService;
import by.alst.project.jdbc.service.SubcategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/subcategory")
public class SubcategoryServlet extends HttpServlet {

    private final SubcategoryService subcategoryService = SubcategoryService.getInstance();
    private final CategoryService categoryService = CategoryService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        Integer categoryId = Integer.valueOf(req.getParameter("categoryId"));

        try (var writer = resp.getWriter()) {
            writer.write("<h1>%s:</h1>".formatted(categoryService.findById(categoryId).category()));
            writer.write("<ul>");
            subcategoryService.findAllByCategoryId(categoryId).forEach(subcategoryDto ->
                    writer.write("""
                            <li>
                            <a href='/productGroup?subcategoryId=%d'>%s</a>
                            </li>
                            """.formatted(subcategoryDto.id(), subcategoryDto.subcategory())));
            writer.write("</ul>");
        }
    }
}
