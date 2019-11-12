package command;

import model.Port;
import services.interfaces.PortService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ExportPorts  implements Command {
    private PortService portService;

    public ExportPorts(PortService portService) {
        this.portService = portService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country = "UA";
        List<Port> ports = portService.findByCountry(country);
        request.setAttribute("ports", ports);
        request.getRequestDispatcher("/pages/index.jsp").forward(request, response);

    }
}
