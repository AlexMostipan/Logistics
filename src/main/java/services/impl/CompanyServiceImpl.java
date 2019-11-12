package services.impl;

import dao.TransactionManager;
import dao.interfaces.CompanyDao;
import model.Сompany;
import services.interfaces.CompanyService;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {
    private CompanyDao companyDao;
    private TransactionManager transactionManager;

    public CompanyServiceImpl(CompanyDao companyDao, TransactionManager transactionManager) {
        this.companyDao = companyDao;
        this.transactionManager = transactionManager;
    }

    @Override
    public int create(Сompany port) {
        return 0;
    }

    @Override
    public boolean update(Сompany port) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Сompany> findAll() {
        transactionManager.getConnection();
        try {
            return companyDao.findAll();
        } finally {
            transactionManager.closeConnection();
        }
    }

    @Override
    public List<Сompany> findByCompanyType(String companyType) {
        transactionManager.getConnection();
        try {
            return companyDao.findByCompanyType(companyType);
        } finally {
            transactionManager.closeConnection();
        }
    }
}
