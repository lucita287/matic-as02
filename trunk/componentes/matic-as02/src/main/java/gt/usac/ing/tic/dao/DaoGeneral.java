package gt.usac.ing.tic.dao;

import java.util.List;

public interface DaoGeneral {

	//______________________________________________________________________________
    /**
     * 
     * @param <T> Se utiliza para establecer el tipo de la instancia de entidad
     *        que sera retornada
     * @param queryName Nombre de la consulta
     * @param values Listado con los parametros que utiliza la consulta, se deben
     *        de colocar en el mismo orden en que aparecen en la consulta. Se
     *        puede colocar {@code null} en el caso que la consulta no tenga
     *        parametros
     * @return List Listado que contiene objetos del mismo tipo que se define
     *         en el parametro {@code T}
     */
    <T> List<T> findByNamedQuery(String queryName, Object... values);
}
