package main;


import org.apache.commons.codec.digest.DigestUtils;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import resourceServer.ResourceServer;
import resourceServer.ResourceServerController;
import resourceServer.ResourceServerControllerMBean;
import servlets.ResourceServlet;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.management.ManagementFactory;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

import static main.Guard.Guardo;


/**
 * Created by FPC on 01.03.2016.
 */
public class Main {
    static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        ResourceServer resourceServer = new ResourceServer();

        ResourceServerControllerMBean serverStatistics = new ResourceServerController(resourceServer);
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("Admin:type=ResourceServerController");
        mbs.registerMBean(serverStatistics, name);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new ResourceServlet(resourceServer)), ResourceServlet.PAGE_URL);




        Guardo();













            //key = prefs.get("keyssss", "");
            //System.out.println("key - "+key);



        //props.getProperty("os.name");





        //System.out.println(System.getenv("PROCESSOR_IDENTIFIER"));
        //System.out.println(System.getenv("PROCESSOR_ARCHITECTURE"));
       // System.getProperties().list(System.out);


        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        logger.info("Server started");
        server.join();
    }
}
