package service.logic;

import java.util.List;

import dao.ClientDao;
import entity.Client;
import exceptions.DaoException;
import exceptions.ServiceException;
import service.ClientService;

public class ClientServiceImpl implements ClientService {

	private ClientDao dao;

	public ClientDao getDao() {
		return this.dao;
	}

	public void setClientDao(ClientDao dao) {
		this.dao = dao;
	}

	@Override
	public void save(Client client) throws ServiceException {
		try {
			if (client.getId() != null) {
				if (dao.chechUnique(client.getPhone())) {
					long id = dao.create(client);
					client.setId(id);
				} else {
					long id = client.getId();
					dao.update(client, id);
				}
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void delete(Long id) throws ServiceException {
		try {
			dao.delete(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Client> readAllClient() throws ServiceException {
		try {
			return dao.readAll();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Client> readClientByName(String name, String surname) throws ServiceException {
		try {
			return dao.readByName(name, surname);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean UniqueClient(String phone) throws ServiceException {
		try {
			return dao.chechUnique(phone);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
}
