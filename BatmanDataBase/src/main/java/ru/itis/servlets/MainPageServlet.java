package ru.itis.servlets;

import lombok.SneakyThrows;
import ru.itis.models.*;
import ru.itis.repositories.*;
import ru.itis.services.EditService;
import ru.itis.services.EditServiceImpl;
import ru.itis.services.InformationService;
import ru.itis.services.InformationServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

public class MainPageServlet extends HttpServlet {
    private InformationService informationService;
    private EditService editService;

    @SneakyThrows
    @Override
    public void init(ServletConfig config) {
        ServletContext context = config.getServletContext();
        DataSource dataSource = (DataSource) context.getAttribute("dataSource");

        informationService = new InformationServiceImpl(new SubjectsRepositoryJdbcImpl(),
                new WeaponRepositoryJdbcImpl(), new AmmoRepositoryJdbcImpl(),
                new EquipmentRepositoryJdbcImpl(), new TransportRepositoryImpl(),
                new ExpensesRepositoryJdbcImpl());

        editService = new EditServiceImpl(new SubjectsRepositoryJdbcImpl(),
                new WeaponRepositoryJdbcImpl(), new AmmoRepositoryJdbcImpl(),
                new EquipmentRepositoryJdbcImpl(), new TransportRepositoryImpl(),
                new ExpensesRepositoryJdbcImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Subject> subjectList = informationService.getAllSubjects();
        req.setAttribute("subjectList", subjectList);

        List<Weapon> weaponList = informationService.getAllWeapon();
        req.setAttribute("weaponList", weaponList);

        List<Ammo> ammoList = informationService.getAllAmmo();
        req.setAttribute("ammoList", ammoList);

        List<Equipment> equipmentList = informationService.getAllEquipment();
        req.setAttribute("equipmentList", equipmentList);

        List<Transport> transportList = informationService.getAllTransport();
        req.setAttribute("transportList", transportList);

        List<Expenses> expensesList = informationService.getAllExpenses();
        req.setAttribute("expensesList", expensesList);

        req.getRequestDispatcher("/ftl/mainPage.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("entity_id");
        Long id = null;
        if (idStr != null) {
            id = Long.valueOf(idStr);
        }
        String tableName = req.getParameter("table_name");

        String action = req.getParameter("action");

        if (action.equals("delete")) {
            if (editService.deleteEntity(tableName, id)) {
                resp.setStatus(200);
                return;
            }
        } else if (action.equals("add")) {
            String[] entity = req.getParameterValues("entity[]");
            switch (tableName) {
                case "subject":
                    editService.saveSubject(entity);
                    resp.setStatus(200);
                    break;
                case "weapon":
                    editService.saveWeapon(entity);
                    resp.setStatus(200);
                    break;
                case "equipment":
                    editService.saveEquipment(entity);
                    resp.setStatus(200);
                    break;
                case "transport":
                    editService.saveTransport(entity);
                    break;
                case "expense":
                    editService.saveExpense(entity);
                    break;
            }
        }
    }
}
