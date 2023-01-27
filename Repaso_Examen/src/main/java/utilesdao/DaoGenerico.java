package utilesdao;

import java.io.Serializable;
import java.util.List;

import excepcions.BusinessException;

public class DaoGenerico<T, ID extends Serializable> implements InterfaceDaoGenerico<T, ID> {

	public void grabar(T objeto) throws BusinessException {
		throw new RuntimeException();

	}

	public void actualizar(T objeto) throws BusinessException {
		throw new RuntimeException();

	}

	public void borrar(ID id) throws BusinessException {
		throw new RuntimeException();

	}

	public T buscarPorId(ID id) throws BusinessException {
		throw new RuntimeException();
	}

}
