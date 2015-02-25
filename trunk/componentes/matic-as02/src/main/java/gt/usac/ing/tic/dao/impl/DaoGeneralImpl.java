package gt.usac.ing.tic.dao.impl;

import gt.usac.ing.tic.dao.DaoGeneral;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("daoGeneralImpl")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class DaoGeneralImpl  implements DaoGeneral, Serializable{
	/**
     * <p>Numero de version de la clase</p>
     */
    private static final long serialVersionUID = 1L;
    
  //______________________________________________________________________________
    /**
     * <p>Mantiene la conexion con la base de datos.</p>
     */
    @Autowired
    protected SessionFactory sessionFactory;
//______________________________________________________________________________
    /**
     * <p>Constructor predeterminado de la clase.</p>
     */
    public DaoGeneralImpl() {    }
//______________________________________________________________________________
    /**
     * <p>Retorna la sesion actual con la que se esta trabajando.</p>
     * 
     * @return Session
     * @throws HibernateException Si ocurre algun error con el acceso a la BD
     */
    protected Session getCurrentSession() throws HibernateException {
        return this.sessionFactory.getCurrentSession();
    }
    
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
    @Override
    @Transactional(readOnly = true)
    public <T> List<T> findByNamedQuery(String queryName, Object... values) {
        Query query = this.getCurrentSession().getNamedQuery(queryName);
        if(values != null) {
            for(int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        final List<T> entidades = query.list();
        return entidades;
    }
}
