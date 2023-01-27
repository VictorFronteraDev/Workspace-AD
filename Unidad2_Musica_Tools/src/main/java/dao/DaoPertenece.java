package dao;

import java.util.logging.Logger;

import pojos.Pertenece;
import pojos.PerteneceId;

public class DaoPertenece
	extends DaoGenericoHibernate<Pertenece,PerteneceId> {
	private final static Logger 
	LOGGER=Logger.getLogger(DaoPertenece.class.getName());

}