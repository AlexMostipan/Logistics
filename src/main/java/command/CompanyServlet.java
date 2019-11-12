package command;

import model.enums.CompanyType;
import services.interfaces.CompanyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.Сompany;

public class CompanyServlet implements Command {
    private CompanyService companyService;

    public CompanyServlet(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Сompany> companiesLand = companyService.findByCompanyType(CompanyType.LAND.toString());
        List<Сompany> companiesSea = companyService.findByCompanyType(CompanyType.SEA.toString());
        request.setAttribute("companiesLand", companiesLand);
        request.setAttribute("companiesSea", companiesSea);
        request.getRequestDispatcher("/pages/index.jsp").forward(request, response);

    }
}
