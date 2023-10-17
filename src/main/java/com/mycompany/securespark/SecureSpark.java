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

        get("/hello", (req, res) -> "Hello World from Server 1");
        get("/goodbye", (req, res) -> URLReader.urlReader(getUrl(),"keystore/ecikeystore2.p12", "password"));
        
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost) 
    }
    
    static String getUrl() {
        if (System.getenv("URL") != null) {
            return System.getenv("URL");
        }
        return "https://ec2-54-87-148-26.compute-1.amazonaws.com:5001/goodbye";
    }

}
