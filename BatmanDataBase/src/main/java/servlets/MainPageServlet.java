package servlets;

import lombok.SneakyThrows;
import models.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repositories.*;
import services.EditService;
import services.EditServiceImpl;
import services.InformationService;
import services.InformationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MainPageServlet extends HttpServlet {
    private InformationService informationService;
    private EditService editService;

    @SneakyThrows
    @Override
    public void init() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("Metallica1981");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/batman_db");

        informationService = new InformationServiceImpl(new SubjectsRepositoryJdbcImpl(dataSource),
                new WeaponRepositoryJdbcImpl(dataSource), new AmmoRepositoryJdbcImpl(dataSource),
                new EquipmentRepositoryJdbcImpl(dataSource), new TransportRepositoryImpl(dataSource),
                new ExpensesRepositoryJdbcImpl(dataSource));

        editService = new EditServiceImpl(new SubjectsRepositoryJdbcImpl(dataSource),
                new WeaponRepositoryJdbcImpl(dataSource), new AmmoRepositoryJdbcImpl(dataSource),
                new EquipmentRepositoryJdbcImpl(dataSource), new TransportRepositoryImpl(dataSource),
                new ExpensesRepositoryJdbcImpl(dataSource));
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
        Long id = Long.valueOf(req.getParameter("entity_id"));
        String tableName = req.getParameter("table_name");

        String action = req.getParameter("action");

        if (action.equals("delete")) {
            if (editService.deleteEntity(tableName, id)) {
                System.out.println("SUCCESS DELETE");
                resp.setStatus(200);
            }
        }
    }
}
