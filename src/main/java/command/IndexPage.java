package command;

import model.Container;
import model.Port;
import model.enums.CompanyType;
import model.Сompany;
import services.interfaces.CompanyService;
import services.interfaces.ContainerService;
import services.interfaces.PortService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class IndexPage implements Command {
    private PortService portService;
    private CompanyService companyService;
    private ContainerService containerService;

    public IndexPage(PortService portService, CompanyService companyService, ContainerService containerService) {
        this.portService = portService;
        this.companyService = companyService;
        this.containerService = containerService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Port> ports = portService.findAll();
        request.setAttribute("ports", ports);

        List<Сompany> companiesLand = companyService.findByCompanyType(CompanyType.LAND.toString());
        List<Сompany> companiesSea = companyService.findByCompanyType(CompanyType.SEA.toString());
       List<Container> containers = containerService.findAll();
        request.setAttribute("companiesLand", companiesLand);
        request.setAttribute("companiesSea", companiesSea);
        request.setAttribute("containers", containers);

        request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
    }
}
