package by.alst.project.jdbc.servlet;

import by.alst.project.jdbc.dto.InformationDto;
import by.alst.project.jdbc.dto.UserDto;
import by.alst.project.jdbc.service.GenderService;
import by.alst.project.jdbc.service.InformationService;
import by.alst.project.jdbc.service.RoleService;
import by.alst.project.jdbc.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();
    private final InformationService informationService = InformationService.getInstance();
    private final RoleService roleService = RoleService.getInstance();
    private final GenderService genderService = GenderService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        Integer usersId = Integer.valueOf(req.getParameter("usersId"));
        UserDto userDto = userService.findById(usersId);
        InformationDto informationDto = informationService.findById(usersId);

        try (var writer = resp.getWriter()) {
            writer.write("<h1>%s %s %s</h1>".formatted(informationDto.lastName(),
                    informationDto.firstName(), informationDto.secondName()));
            writer.write("<ul>");

            writer.write("<h2>e-mail: %s</h2>".formatted(userDto.email()));
            writer.write("<h2>password: %s</h2>".formatted(userDto.password()));
            writer.write("<h2>Адрес: %s</h2>".formatted(informationDto.address()));
            writer.write("<h2>Телефон: %s</h2>".formatted(informationDto.phone()));
            writer.write("<h2>Роль: %s</h2>".formatted(roleService.findById(userDto.roleId()).role()));
            writer.write("<h2>Пол: %s</h2>".formatted(genderService.findById(userDto.genderId()).gender()));

            writer.write("""
                    <h2>
                    <li>
                    <a href='/checkout?usersId=%d'>%s</a>
                    </li>
                    </h2>
                    """.formatted(usersId, "Дата и время оформленных покупок"));
            writer.write("</ul>");
        }
    }
}
