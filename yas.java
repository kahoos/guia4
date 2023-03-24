import javax.swing.*;

public class guia4 {

public static void main(String[] args) {
    JOptionPane.showMessageDialog(null, "bienvenido a la base de datos para la bolsa de empleo!", "bienvenido", JOptionPane.QUESTION_MESSAGE);
    return; Cedula();
}
    public static void Bienvenida(){
        JOptionPane.showInputDialog(null, "bienvenido a la base de datos para la bolsa de empleo!",
                "bienvenido",
                JOptionPane.QUESTION_MESSAGE);
    }
    public static void Cedula(String[] args) {
        JOptionPane.showInputDialog(null, "Número de cédula:", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void Nombre_completo(String[] args){
        JOptionPane.showInputDialog(null, "Nombre completo", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void Edad(String[] args) {
        JOptionPane.showInputDialog(null, "Edad", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void Experiencia(String[] args) {
        JOptionPane.showInputDialog(null, "Experiencia (en años)", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void Profesion(String[] args) {
        JOptionPane.showInputDialog(null, "Profesión", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void Telefono(String[] args) {
        JOptionPane.showInputDialog(null, "Teléfono", JOptionPane.INFORMATION_MESSAGE);
    }

}
