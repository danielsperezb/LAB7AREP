package com.mycompany.securespark;

/**
 *
 * @author daniel.perez-b
 */

import static spark.Spark.*;

public class SecureSpark {

    public static void main(String[] args) {

      
        port(getPort());

        secure("keystore/ecikeystore.p12", "password", null, null);

        get("/hello", (req, res) -> "Hello Wolrd");

    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost) 
    }

}
