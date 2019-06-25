package ua.ternopil.igorbendera.service.impl;

import ua.ternopil.igorbendera.dao.MagazineDao;
import ua.ternopil.igorbendera.dao.impl.MagazineDaoImpl;
import ua.ternopil.igorbendera.domain.Magazine;
import ua.ternopil.igorbendera.service.MagazineService;

import java.sql.SQLException;
import java.util.List;

public class MagazineServiceImpl implements MagazineService {
    private MagazineDao magazineDao;

    public MagazineServiceImpl() {
        try {
            magazineDao = new MagazineDaoImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Magazine create(Magazine magazine) {
        return magazineDao.create(magazine);
    }

    @Override
    public Magazine read(Integer id) {
        return magazineDao.read(id);
    }

    @Override
    public Magazine update(Magazine magazine) {
        return magazineDao.update(magazine);
    }

    @Override
    public void delete(Integer id) {
        magazineDao.delete(id);
    }

    @Override
    public List<Magazine> readAll() {
        return magazineDao.readAll();
    }
}
