package ua.ternopil.igorbendera.service.impl;

import ua.ternopil.igorbendera.dao.SubscribeDao;
import ua.ternopil.igorbendera.dao.impl.SubscribeDaoImpl;
import ua.ternopil.igorbendera.domain.Subscribe;
import ua.ternopil.igorbendera.service.SubscribeService;

import java.sql.SQLException;
import java.util.List;

public class SubscribeServiceImpl implements SubscribeService {
    private SubscribeDao subscribeDao;

    public SubscribeServiceImpl() {
        try {
            subscribeDao = new SubscribeDaoImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Subscribe create(Subscribe subscribe) {
        return subscribeDao.create(subscribe);
    }

    @Override
    public Subscribe read(Integer id) {
        return subscribeDao.read(id);
    }

    @Override
    public Subscribe update(Subscribe subscribe) {
        return subscribeDao.update(subscribe);
    }

    @Override
    public void delete(Integer id) {
        subscribeDao.delete(id);
    }

    @Override
    public List<Subscribe> readAll() {
        return subscribeDao.readAll();
    }
}
