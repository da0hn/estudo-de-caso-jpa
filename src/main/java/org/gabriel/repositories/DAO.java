package org.gabriel.repositories;

import org.gabriel.model.ValueObject;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author daohn on 30/07/2020
 * @project ExercicioMapeamentoJPA
 */
public class DAO<VO extends ValueObject> {

    private final EntityManager manager;
    private final Class<VO> valueObject;

    public DAO(EntityManager manager) {
       this.manager = manager;
       this.valueObject = (Class<VO>) ValueObject.class;
    }

    DAO(EntityManager manager, Class<VO> valueObject) {
        this.manager = manager;
        this.valueObject = valueObject;
    }

    public DAO<VO> begin() {
        manager.getTransaction().begin();
        return this;
    }

    public DAO<VO> commit() {
        manager.getTransaction().commit();
        return this;
    }

    public DAO<VO> undo() {
        manager.getTransaction().rollback();
        return this;
    }

    public VO findById(Integer id) {
        return manager.find(valueObject, id);
    }

    public DAO<VO> save(VO vo) {
        manager.persist(vo);
        return this;
    }

    public DAO<VO> save(List<VO> vos) {
        vos.forEach(this::save);
        return this;
    }

    public DAO<VO> update(VO vo) {
        manager.merge(vo);
        return this;
    }

    public DAO<VO> delete(VO vo) {
        manager.remove(vo);
        return this;
    }

    public List<VO> findAll(int limit, int offset) {
        if(valueObject == null) throw new UnsupportedOperationException("Classe nula.");
        String query = "select vo from " + this.valueObject.getName() + " vo";
        return manager.createQuery(query, valueObject)
                .setMaxResults(limit)
                .setFirstResult(offset)
                .getResultList();
    }

    public List<VO> findAll() {
        return findAll(10, 0);
    }

    public void fechar() {
        manager.close();
    }
}
