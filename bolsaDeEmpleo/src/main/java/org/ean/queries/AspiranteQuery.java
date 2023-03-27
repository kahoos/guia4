package org.ean.queries;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.ean.entities.Aspirante;
import org.ean.utils.JPAManager;

import java.util.List;

public class AspiranteQuery {

    private JPAManager jpaManager = new JPAManager();
    private EntityManager manager;
    private Aspirante aspirante;
    private List<Aspirante> listaAspirantes;
    private EntityTransaction transaction;

    public AspiranteQuery(){
        manager = jpaManager.getEntityManager();
        transaction = manager.getTransaction();
    }

    public List<Aspirante> traerTodosLosAspirantes(){
        listaAspirantes = manager.createQuery("FROM aspirante").getResultList();
        return listaAspirantes;
    }

    public List<Aspirante> traerAspirantesPorNombre(String nombre){
        listaAspirantes = manager.createQuery("FROM aspirante WHERE nombre= :nombre")
                .setParameter("nombre",nombre).getResultList();
        return listaAspirantes;
    }

    public Aspirante traerAspirantePorCedula(int cedula){
        aspirante = manager.find(Aspirante.class, cedula);
        return aspirante;
    }

    public int inscribirAspirante(Aspirante aspirante){
        transaction.begin();
        manager.persist(aspirante);
        try {
            transaction.commit();
            return 1;
        }
        catch (Exception e) {
            transaction.rollback();
            return -1;
        }
    }

    public int actualizarAspirante(Aspirante aspiranteNuevo){

        aspirante = traerAspirantePorCedula( aspiranteNuevo.getCedula() );

        if(aspirante != null){
            aspirante.setNombre( aspiranteNuevo.getNombre() );
            aspirante.setEdad( aspiranteNuevo.getEdad() );
            aspirante.setAniosexp( aspiranteNuevo.getAniosexp() );
            aspirante.setProfesion( aspiranteNuevo.getProfesion() );
            aspirante.setTelefono( aspiranteNuevo.getTelefono() );

            transaction.begin();
            manager.merge(aspirante);

            try {
                transaction.commit();
                return 1;
            } catch (Exception e) {
                transaction.rollback();
                return -1;
            }
        }
        else {
            return 0;
        }
    }

    public int eliminarAspirante(int cedula){
        aspirante = traerAspirantePorCedula(cedula);

        if(aspirante != null){
            transaction.begin();
            manager.remove(aspirante);

            try{
                transaction.commit();
                return 1;
            }
            catch (Exception e){
                transaction.rollback();
                return -1;
            }
        }
        else {
            return 0;
        }
    }

}
