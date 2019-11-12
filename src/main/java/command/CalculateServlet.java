package command;

import model.*;
import model.enums.CompanyType;
import org.json.JSONException;
import services.interfaces.*;
import util.IntParser;
import util.MapsGoogle;
import util.PortDistance;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class CalculateServlet implements Command {
    private UnloadingService unloadingService;
    private LoadingService loadingService;
    private DeliverySeaService deliverySeaService;
    private DeliveryLandService deliveryLandService;
    private CompanyService companyService;

    public CalculateServlet(UnloadingService unloadingService, LoadingService loadingService, DeliverySeaService deliverySeaService, DeliveryLandService deliveryLandService, CompanyService companyService) {
        this.unloadingService = unloadingService;
        this.loadingService = loadingService;
        this.deliverySeaService = deliverySeaService;
        this.deliveryLandService = deliveryLandService;
        this.companyService = companyService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, JSONException {
        List<Сompany> companiesLand = companyService.findByCompanyType(CompanyType.LAND.toString());
        List<Сompany> companiesSea = companyService.findByCompanyType(CompanyType.SEA.toString());

        request.setAttribute("companiesLand", companiesLand);
        request.setAttribute("companiesSea", companiesSea);

        HttpSession session = request.getSession();
        String container = request.getParameter("container");
        String citySender = request.getParameter("citySender");
        String cityRecipient = request.getParameter("cityRecipient");
        String portSender = request.getParameter("portSender");
        String portRecipient = request.getParameter("portRecipient");
        String typeContainer = request.getParameter("typeContainer");
        String companyLand = request.getParameter("companyLand");
        String companySea = request.getParameter("companySea");


        Unloading unloading = unloadingService.findByContainerTypeAndPort(typeContainer, portRecipient);
        Loading loading = loadingService.findByContainerTypeAndPort(typeContainer, portSender);
        DeliveryLand deliveryLand = deliveryLandService.findByContainerTypeAndCompany(typeContainer, companyLand);
        DeliverySea deliverySea = deliverySeaService.findByContainerTypeAndCompany(typeContainer, companySea);

       final int distanceToPort ;
        String inlineRadioOptions = request.getParameter("inlineRadioOptions") ;
        if(inlineRadioOptions.equals("export")){

            distanceToPort = IntParser.Parse(MapsGoogle.calculateDistance(citySender, portSender));
            session.setAttribute("citySender", citySender);
            session.setAttribute("portSender", portSender);
        }
        else {
            distanceToPort = IntParser.Parse(MapsGoogle.calculateDistance(portRecipient, cityRecipient));
            session.setAttribute("citySender", cityRecipient);
            session.setAttribute("portSender", portRecipient);
        }

        int distancePorts = PortDistance.Calculate(portSender, portRecipient);
        int unloadingCost = unloading.getCost();
        int loadingCost = loading.getCost();

        int costLandDelivery = distanceToPort * deliveryLand.getCost();
        int costSeaDelivery = distancePorts * deliverySea.getCost() /16;
        int allCost = loadingCost+unloadingCost+costLandDelivery+costSeaDelivery;

        int weight = Integer.parseInt(request.getParameter("weight"));
        String typeCargo = request.getParameter("typeCargo");

        session.setAttribute("distancePorts", distancePorts);
        session.setAttribute("distanceToPort", distanceToPort);

        session.setAttribute("unloadingCost", unloadingCost);
        session.setAttribute("loadingCost", loadingCost);
        session.setAttribute("costLandDelivery", costLandDelivery);
        session.setAttribute("costSeaDelivery", costSeaDelivery);
        session.setAttribute("typeContainer", typeContainer);
        session.setAttribute("allCost", allCost);

        request.getRequestDispatcher("/pages/order.jsp").forward(request, response);

    }
}
