package org.ean.cruds;

import org.ean.entities.Aspirante;
import org.ean.queries.AspiranteQuery;

import java.util.List;

public class AspiranteCRUD {

    private AspiranteQuery aspiranteQuery = new AspiranteQuery();
    private Aspirante aspirante;
    private List<Aspirante> listaAspirantes;

    public void agregarHojaDeVida(int cedula, String nombre, int edad, int aniosxp, String profesion, String telefono){
        aspirante = new Aspirante();
        aspirante.setCedula(cedula);
        aspirante.setNombre(nombre);
        aspirante.setEdad(edad);
        aspirante.setAniosexp(aniosxp);
        aspirante.setProfesion(profesion);
        aspirante.setTelefono(telefono);

        int respuesta = aspiranteQuery.inscribirAspirante(aspirante);

        if (respuesta != -1){
            System.out.println("\nAspirante " + aspirante.getNombre() +"(CC: "+ aspirante.getCedula()+ ")" + " inscrito.");
        }
        else {
            System.out.println("\nEl aspirante no pudo inscribirse.");
        }
    }

    public void mostrarCedulasDeAspirantes(){
        listaAspirantes = aspiranteQuery.traerTodosLosAspirantes();
        for(Aspirante aspiranteActual : listaAspirantes){
            System.out.println( aspiranteActual.getCedula() );
        }
    }

    public void consultarAspirantePorCedula(int cedula){
        aspirante = aspiranteQuery.traerAspirantePorCedula(cedula);
        if(aspirante != null){
            aspirante.mostrarInformacion();
        } else {
            System.out.println("No se encontró aspirante con cédula " + cedula);
        }
    }

    //todo el caso 5

    public void consultarAspirantesPorNombre(String nombre){
        listaAspirantes = aspiranteQuery.traerAspirantesPorNombre(nombre);
        for(Aspirante aspiranteActual : listaAspirantes){
            aspiranteActual.mostrarInformacion();
        }
    }

    public void consultarAspiranteConMayorExperiencia(){
        int mayorExperiencia = 0;
        Aspirante aspiranteMayorExperiencia = null;
        listaAspirantes = aspiranteQuery.traerTodosLosAspirantes();
        for(Aspirante aspiranteActual : listaAspirantes){
            if(aspiranteActual.getAniosexp() >= mayorExperiencia){
                aspiranteMayorExperiencia = aspiranteActual;
                mayorExperiencia = aspiranteActual.getAniosexp();
            }
        }
        aspiranteMayorExperiencia.mostrarInformacion();
    }

    public void consultarAspiranteMasJoven(){
        int menorEdad = 999;
        Aspirante aspiranteMasJoven = null;
        listaAspirantes = aspiranteQuery.traerTodosLosAspirantes();
        for(Aspirante aspiranteActual : listaAspirantes){
            if(aspiranteActual.getEdad() <= menorEdad){
                aspiranteMasJoven = aspiranteActual;
                menorEdad = aspiranteActual.getEdad();
            }
        }
        aspiranteMasJoven.mostrarInformacion();
    }

    public void contratarAspirante(int cedula){

        int respuesta = aspiranteQuery.eliminarAspirante(cedula);

        switch (respuesta){
            case 1:
                System.out.println("El aspirante con CC: " + cedula + " se ha contratado." );
                break;
            case -1:
                System.out.println("El aspirante con CC: " + cedula + "NO se ha contratado." );
                break;
            case 0:
                System.out.println("No se encontró el aspirante con CC: " + cedula );
                break;
        }
    }

    public void eliminarAspirantesConMenosExperienciaQue(int aniosLimite){

        listaAspirantes = aspiranteQuery.traerTodosLosAspirantes();

        for (Aspirante aspiranteActual : listaAspirantes){
            if(aspiranteActual.getAniosexp() < aniosLimite){
                aspiranteQuery.eliminarAspirante( aspiranteActual.getCedula() );
                System.out.println("El aspirante con CC: " + aspiranteActual.getCedula() + " ha sido eliminado.");
            }
        }

    }

    public void calcularPromedioDeEdad(){

        listaAspirantes = aspiranteQuery.traerTodosLosAspirantes();
        int cantidadDeAspirantes = listaAspirantes.size();
        int promedioEdad = 0;

        for(Aspirante aspiranteActual : listaAspirantes){
            promedioEdad += aspiranteActual.getEdad() / cantidadDeAspirantes;
        }

        System.out.println("El promedio de edad es de: " + promedioEdad + " anios.");
    }

    public void consultarTodosLosAspirantes(){
        listaAspirantes = aspiranteQuery.traerTodosLosAspirantes();
        if(listaAspirantes.size() != 0){
            for(Aspirante aspiranteActual : listaAspirantes){
                aspiranteActual.mostrarInformacion();
            }
        } else {
            System.out.println("No se encontraron aspirantes.");
        }
    }

    public void actualizarHojaDeVida(int cedula, String nombre, int edad, int aniosxp, String profesion, String telefono){
        aspirante = new Aspirante();
        aspirante.setCedula(cedula);
        aspirante.setNombre(nombre);
        aspirante.setEdad(edad);
        aspirante.setAniosexp(aniosxp);
        aspirante.setProfesion(profesion);
        aspirante.setTelefono(telefono);

        int respuesta = aspiranteQuery.actualizarAspirante(aspirante);

        switch (respuesta){
            case 1:
                System.out.println("El aspirante con CC: " + aspirante.getCedula() + " se ha actualizado." );
                break;
            case -1:
                System.out.println("El aspirante con CC: " + aspirante.getCedula() + "NO se ha actualizado." );
                break;
            case 0:
                System.out.println("No se encontró el aspirante con CC: " + aspirante.getCedula() );
                break;
        }
    }


}
