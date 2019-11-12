package command;

import model.DeliveryLand;

import model.DeliverySea;
import model.enums.CompanyType;
import model.Сompany;
import services.interfaces.CompanyService;
import services.interfaces.DeliveryLandService;
import services.interfaces.DeliverySeaService;
import services.interfaces.PortService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class Recount implements Command {
    private DeliveryLandService deliveryLandService;
    private DeliverySeaService deliverySeaService;
    private CompanyService companyService;

    public Recount(DeliveryLandService deliveryLandService, DeliverySeaService deliverySeaService, CompanyService companyService) {
        this.deliveryLandService = deliveryLandService;
        this.deliverySeaService = deliverySeaService;
        this.companyService = companyService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Сompany> companiesLand = companyService.findByCompanyType(CompanyType.LAND.toString());
        List<Сompany> companiesSea = companyService.findByCompanyType(CompanyType.SEA.toString());
        request.setAttribute("companiesLand", companiesLand);
        request.setAttribute("companiesSea", companiesSea);
        String companyLand = request.getParameter("companyLand");
        String companySea = request.getParameter("companySea");
        int distancePorts = (Integer) session.getAttribute("distancePorts");
        int distanceToPort = (Integer) session.getAttribute("distanceToPort");
        int unloadingCost = (Integer) session.getAttribute("unloadingCost");
        int loadingCost = (Integer) session.getAttribute("loadingCost");
        String typeContainer = (String) session.getAttribute("typeContainer");
        DeliveryLand deliveryLand = deliveryLandService.findByContainerTypeAndCompany(typeContainer, companyLand);
        DeliverySea deliverySea = deliverySeaService.findByContainerTypeAndCompany(typeContainer, companySea);

        int costLandDeliverynew = distanceToPort * deliveryLand.getCost();
        int costSeaDelivery = distancePorts * deliverySea.getCost() / 16;
        int allCost = loadingCost + unloadingCost + costLandDeliverynew + costSeaDelivery;
        session.setAttribute("costLandDelivery", costLandDeliverynew);
        session.setAttribute("costSeaDelivery", costSeaDelivery);
        session.setAttribute("allCost", allCost);
//

        request.getRequestDispatcher("/pages/order.jsp").forward(request, response);

    }
}

