package utilesDao;

import java.io.Serializable;
import java.util.List;

import excepcions.BusinessException;

public interface InterfaceDaoGenerico <T, ID extends Serializable> {
	
	public void grabar(T objeto) throws BusinessException;
	
	public void actualizar(T objeto) throws BusinessException;
	
	public T buscarPorId(ID id) throws BusinessException;

}
