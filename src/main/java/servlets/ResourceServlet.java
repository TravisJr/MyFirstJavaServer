package servlets;

import resourceServer.ResourceServer;
import resources.TestResource;
import sax.ReadXMLFileSAX;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ResourceServlet extends HttpServlet {
    public static String PAGE_URL = "/resources";
    private ResourceServer resourceServer;

    public ResourceServlet(ResourceServer resourceServer) {
        this.resourceServer = resourceServer;
    }

/*    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        String path = request.getParameter("path");
        TestResource testResource = (TestResource) ReadXMLFileSAX.readXML(path);
        resourceServer.setResource(testResource);
        response.getWriter().println(resourceServer.getName());
        response.getWriter().println(resourceServer.getAge());
    }
*/
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String path = request.getParameter("path");
        TestResource testResource = (TestResource) ReadXMLFileSAX.readXML(path);
        resourceServer.setResource(testResource);
    }
}
