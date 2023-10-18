package com.mycompany.securespark;

import static spark.Spark.*;

/**
 * Clase principal que inicia un servidor Spark seguro.
 * Se proporciona un endpoint "/hello" y "/goodbye".
 * El endpoint "/goodbye" realiza una solicitud a una URL externa utilizando un truststore personalizado.
 * @author daniel.perez-b
 */
public class SecureSpark {

    /**
     * Método principal que inicia el servidor Spark seguro.
     * @param args Argumentos de línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {

        // Configuración del puerto del servidor
        port(getPort());

        // Configuración de seguridad con keystore
        secure("keystore/ecikeystore.p12", "password", null, null);

        // Definición del endpoint "/hello" que retorna un saludo
        get("/hello", (req, res) -> "Hello World from Server 1");

        // Definición del endpoint "/goodbye" que realiza una solicitud a una URL externa
        get("/goodbye", (req, res) -> URLReader.urlReader(getUrl(), "keystore/myTrustStore2.p12", "password"));

    }

    /**
     * Obtiene el puerto del entorno o utiliza un puerto predeterminado si no está configurado.
     * @return Puerto del servidor.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; // Retorna el puerto predeterminado si la variable de entorno no está configurada (por ejemplo, en localhost)
    }

    /**
     * Obtiene la URL del entorno o utiliza una URL predeterminada si no está configurada.
     * @return URL a la que se realizará la solicitud en el endpoint "/goodbye".
     */
    static String getUrl() {
        if (System.getenv("URL") != null) {
            return System.getenv("URL");
        }
        return "https://ec2-54-82-184-135.compute-1.amazonaws.com:5001/goodbye";
    }
}
