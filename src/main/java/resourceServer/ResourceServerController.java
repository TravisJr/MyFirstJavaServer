package resourceServer;


public class ResourceServerController implements ResourceServerControllerMBean {
    private ResourceServer resourceServer;
    public String name;
    public int age;

    public ResourceServerController(ResourceServer resourceServer) {
        this.resourceServer = resourceServer;
        this.name = this.getName();
        this.age = this.getAge();
    }

    @Override
    public String getName() {
        return resourceServer.getName();
    }

    @Override
    public int getAge() {
        return resourceServer.getAge();
    }
}
