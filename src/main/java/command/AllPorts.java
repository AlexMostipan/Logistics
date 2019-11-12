package command;

import com.google.gson.Gson;
import model.Port;
import services.interfaces.PortService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AllPorts implements Command {
    private PortService portService;

    public AllPorts(PortService portService) {
        this.portService = portService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Port> ports = portService.findAll();
        request.setAttribute("ports", ports);
        request.getRequestDispatcher("/pages/index.jsp").forward(request, response);

    }
    }


