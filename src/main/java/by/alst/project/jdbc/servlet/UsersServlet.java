package by.alst.project.jdbc.servlet;

import by.alst.project.jdbc.service.InformationService;
import by.alst.project.jdbc.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();
    private final InformationService informationService = InformationService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (var writer = resp.getWriter()) {
            writer.write("<h1>Пользователи:</h1>");
            writer.write("<ul>");

            userService.findAll().forEach(userDto ->
                    writer.write("""
                            <li>
                            <a href='/user?usersId=%d'>%s %s %s</a>
                            </li>
                            """.formatted(userDto.id(), informationService.findById(userDto.id()).lastName(),
                            informationService.findById(userDto.id()).firstName(),
                            informationService.findById(userDto.id()).secondName())));
            writer.write("</ul>");
        }
    }
}