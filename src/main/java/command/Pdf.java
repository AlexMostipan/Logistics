package command;

import model.Client;
import util.PrintReport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Pdf implements Command {
    public Pdf() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int unloadingCost = (Integer) session.getAttribute("unloadingCost");
        int loadingCost = (Integer) session.getAttribute("loadingCost");
        int costLandDelivery = (Integer) session.getAttribute("costLandDelivery");
        int costSeaDelivery = (Integer) session.getAttribute("costSeaDelivery");
        int allCost = (Integer) session.getAttribute("allCost");

        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        Client client = new Client(fullName,email,phone);
        String pdfName = "Order.pdf";
       PrintReport.createPDF(pdfName,client,costLandDelivery,costSeaDelivery,unloadingCost,loadingCost,allCost);
        int BUFF_SIZE = 1024;
        byte[] buffer = new byte[BUFF_SIZE];
        response.setContentType("application/pdf");
        response.setHeader("Content-Type", "application/pdf");
        File filePDF = new File("/home/alex/IdeaProjects/NikoLogistics/docs/"+pdfName);
        FileInputStream fis = new FileInputStream(filePDF);
        OutputStream os = response.getOutputStream();
        try
        {
            response.setContentLength((int) filePDF.length());
            int byteRead = 0;
            while ((byteRead = fis.read()) != -1)
            {
                os.write(byteRead);
            }
            os.flush();
        }
        catch (Exception excp)
        {
            excp.printStackTrace();
        }
        finally
        {
            os.close();
            fis.close();
        }
    }
}

