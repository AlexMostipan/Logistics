package servlet;

import dao.DefaultTransactionManager;

import dao.JdbcImpl.*;

import dao.TransactionManager;
import dao.dbcp.ConnectionManager;
import dao.dbcp.MySqlConnectionManager;

import dao.interfaces.*;

import factory.CommandFactory;

import org.json.JSONException;
import services.impl.*;

import services.interfaces.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class DispatcherServlet extends HttpServlet {
    private CommandFactory commandFactory;

    @Override
    public void init() {
        ConnectionManager connectionManager = new MySqlConnectionManager();
        TransactionManager transactionManager = new DefaultTransactionManager(connectionManager);


        PortDao portDao = new PortSqlDao(transactionManager);
        PortService portService = new PortServiceImpl(portDao, transactionManager);

        DeliverySeaDao deliverySeaDao = new DeliverySeaSqlDao(transactionManager);
        DeliverySeaService deliverySeaService = new DeliverySeaServiceIml(deliverySeaDao, transactionManager);
        DeliveryLandDao deliveryLandDao = new DeliveryLandSqlDao(transactionManager);
        DeliveryLandService deliveryLandService = new DeliveryLandServiceImpl(deliveryLandDao, transactionManager);
        UnloadingDao unloadingDao = new UnloadingSqlDao(transactionManager);
        UnloadingService unloadingService = new UnloadingServiceIml(unloadingDao, transactionManager);
        LoadingDao loadingDao = new LoadingSqlDao(transactionManager);
        LoadingService loadingService = new LoadingServiceImpl(loadingDao, transactionManager);
        ContainerDao containerDao = new ContainerSqlDao(transactionManager);
        ContainerService containerService = new ContainerServiceImpl(containerDao, transactionManager);

        CompanyDao companyDao = new CompanySqlDao(transactionManager);
        CompanyService companyService = new CompanyServiceImpl(companyDao, transactionManager);
        commandFactory = new CommandFactory(portService, companyService, unloadingService, loadingService, deliveryLandService, deliverySeaService, containerService);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            commandFactory.perform(req, resp);
        } catch (SQLException | JSONException e) {
            e.printStackTrace();
        }
     }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            commandFactory.perform(req, resp);
        } catch (SQLException | JSONException e) {
            e.printStackTrace();
        }
    }
}
