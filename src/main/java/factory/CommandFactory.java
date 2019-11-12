package factory;

import command.*;
import org.json.JSONException;
import services.interfaces.*;
import util.UrlRequests;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private final Map<String, Command> commandMap = new HashMap<>();


    public CommandFactory(PortService portService, CompanyService companyService , UnloadingService unloadingService , LoadingService loadingService, DeliveryLandService deliveryLandService , DeliverySeaService deliverySeaService, ContainerService containerService) {

        commandMap.put(UrlRequests.HOME_PAGE, new IndexPage(portService, companyService , containerService));
        commandMap.put("/allPorts", new AllPorts(portService));
        commandMap.put("/exportPorts", new ExportPorts(portService));
        commandMap.put("/calculateCost", new CalculateServlet(unloadingService, loadingService, deliverySeaService, deliveryLandService , companyService));
        commandMap.put("/recount", new Recount(deliveryLandService,deliverySeaService, companyService));
        commandMap.put("/pdf", new Pdf());

    }

    public void perform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, JSONException {
        String requestURI = request.getRequestURI();
        String uri = requestURI.substring(requestURI.lastIndexOf(UrlRequests.SITE) + UrlRequests.SITE.length());
        Command command = commandMap.get(uri);
        if (command == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            command.execute(request, response);
        }
    }
}
