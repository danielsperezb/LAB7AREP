package com.mycompany.securespark;

import static spark.Spark.*;

/**
 * Clase principal que inicia un segundo servidor Spark seguro.
 * Se proporcionan dos endpoints: "/hello" que realiza una solicitud a una URL externa,
 * y "/goodbye" que simplemente devuelve un mensaje de despedida.
 * @author daniel.perez-b
 */
public class SecureSpark2 {

    /**
     * Método principal que inicia el segundo servidor Spark seguro.
     * @param args Argumentos de línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {

        // Configuración del puerto del servidor
        port(getPort());

        // Configuración de seguridad con keystore
        secure("keystore/ecikeystore2.p12", "password", null, null);

        // Definición del endpoint "/hello" que realiza una solicitud a una URL externa
        get("/hello", (req, res) -> URLReader.urlReader(getUrl(), "keystore/myTrustStore.p12", "password"));

        // Definición del endpoint "/goodbye" que simplemente devuelve un mensaje de despedida
        get("/goodbye", (req, res) -> "GoodBye World from Server 2");

    }

    /**
     * Obtiene el puerto del entorno o utiliza un puerto predeterminado si no está configurado.
     * @return Puerto del servidor.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5001; // Retorna el puerto predeterminado si la variable de entorno no está configurada (por ejemplo, en localhost)
    }

    /**
     * Obtiene la URL del entorno o utiliza una URL predeterminada si no está configurada.
     * @return URL a la que se realizará la solicitud en el endpoint "/hello".
     */
    static String getUrl() {
        if (System.getenv("URL") != null) {
            return System.getenv("URL");
        }
        return "https://ec2-54-88-80-32.compute-1.amazonaws.com:5000/hello";
    }

}
