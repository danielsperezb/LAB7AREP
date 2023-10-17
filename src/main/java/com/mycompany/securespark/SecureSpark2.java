package com.mycompany.securespark;

/**
 *
 * @author daniel.perez-b
 */

import static spark.Spark.*;

public class SecureSpark2 {

    public static void main(String[] args) {

      
        port(getPort());

        secure("keystore/ecikeystore2.p12", "password", null, null);

        get("/goodbye", (req, res) -> "GoodBye Wolrd");
        
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5001; //returns default port if heroku-port isn't set (i.e. on localhost) 
    }

}
