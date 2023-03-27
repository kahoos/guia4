package org.ean;

import org.ean.cruds.AspiranteCRUD;
public class Main {
    public static void main(String[] args) {
        AspiranteCRUD aspiranteCRUD = new AspiranteCRUD();

        /** Escoger opción:
         *  1. Agregar una nueva hoja de vida.
         *  2. Mostrar las cédulas de los aspirantes.
         *  3. Mostrar la información detallada de un aspirante a partir de su cédula.
         *  4. Buscar por nombre del aspirante.
         *  5. Ordenar la lista de aspirantes por años de experiencia, edad y profesion.
         *  6. Consultar el aspirante con mayor experiencia.
         *  7. Consultar el aspirante más joven.
         *  8. Contratar un aspirante.
         *  9. Eliminar un aspirante con menos de cierta experiencia.
         *  10. Mostrar promedio de edad de aspirantes.
         *  11. (Adicional) Actualizar información de un aspirante usando su cédula.;
         *  12. (Adicional) Mostrar la información de todos los aspirantes.;
         * */
        final int OPCION = 2;


        switch (OPCION){

            case 1:
                System.out.println("Agregando una nueva hoja de vida...\n");
                aspiranteCRUD.agregarHojaDeVida(
                        486,
                        "Pedro Martinez",
                        30,
                        15,
                        "Abogado",
                        "48975"
                );
                break;

            case 2:
                System.out.println("Mostrando las cédulas de los aspirantes...\n");
                aspiranteCRUD.mostrarCedulasDeAspirantes();
                break;

            case 3:
                System.out.println("Mostrando la información detallada de un aspirante a partir de su cédula...\n");
                aspiranteCRUD.consultarAspirantePorCedula(
                        15000
                );
                break;

            case 4:
                System.out.println("Buscando por nombre del aspirante...\n");
                aspiranteCRUD.consultarAspirantesPorNombre(
                        "Pedro Perez"
                );
                break;

            case 5:
                System.out.println("Ordenando la lista de aspirantes por años de experiencia, edad y profesion...\n");
                //TODO
                break;

            case 6:
                System.out.println("Consultando el aspirante con mayor experiencia...\n");
                aspiranteCRUD.consultarAspiranteConMayorExperiencia();
                break;

            case 7:
                System.out.println("Consultando el aspirante más joven...\n");
                aspiranteCRUD.consultarAspiranteMasJoven();
                break;

            case 8:
                System.out.println("Contratando un aspirante...\n");
                aspiranteCRUD.contratarAspirante(
                        15000
                );
                break;

            case 9:
                System.out.println("Eliminar un aspirante con menos de cierta experiencia\n");
                aspiranteCRUD.eliminarAspirantesConMenosExperienciaQue(
                        7
                );
                break;

            case 10:
                System.out.println("Mostrando promedio de edad de aspirantes...\n");
                aspiranteCRUD.calcularPromedioDeEdad();
                break;

            case 11:
                System.out.println("Actualizando información de un aspirante usando su cédula...\n");
                aspiranteCRUD.actualizarHojaDeVida(
                        123,
                        "Fernando",
                        66,
                        40,
                        "Pensionado",
                        "310000"
                );
                break;

            case 12:
                System.out.println("Mostrando la información de todos los aspirantes...\n");
                aspiranteCRUD.consultarTodosLosAspirantes();
                break;
        }
    }
}