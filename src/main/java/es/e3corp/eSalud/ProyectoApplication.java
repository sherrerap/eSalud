package es.e3corp.eSalud; // NOPMD by sergi on 27/11/19 18:53

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase lanzadora de la aplicación.
 * 
 * @author e3corp
 *
 */
@SpringBootApplication
public class ProyectoApplication { // NOPMD by sergi on 27/11/19 18:53

  /**
   * Método principal que lanza la aplicación web.
   * 
   * @param args no se usa
   */
  public static void main(String[] args) {
    SpringApplication.run(ProyectoApplication.class, args);
  }

}
