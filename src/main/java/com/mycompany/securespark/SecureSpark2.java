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

        get("/hello", (req, res) -> URLReader.urlReader(getUrl(),"keystore/ecikeystore.p12", "password"));
        get("/goodbye", (req, res) -> "GoodBye Wolrd from Server 2");
        
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5001; //returns default port if heroku-port isn't set (i.e. on localhost) 
    }
    
    static String getUrl() {
        if (System.getenv("URL") != null) {
            return System.getenv("URL");
        }
        return "https://localhost:5000/hello";
    }

}
