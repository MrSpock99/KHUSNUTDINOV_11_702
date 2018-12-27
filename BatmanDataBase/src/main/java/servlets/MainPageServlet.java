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
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class MainPageServlet extends HttpServlet {
    private InformationService informationService;
    private EditService editService;

    @SneakyThrows
    @Override
    public void init() {
        Properties properties = new Properties();
        properties.load(new FileReader("C:\\Users\\khusn\\Desktop\\University\\KHUSNUTDINOV_11_702\\BatmanDataBase\\src\\main\\resources\\ru.itis\\application.properties"));

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername(properties.getProperty("db.user"));
        dataSource.setPassword(properties.getProperty("db.password"));
        dataSource.setUrl(properties.getProperty("db.url"));

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
