package resourceServer;

import resources.TestResource;


public class ResourceServer {
    private TestResource testResource;

    public ResourceServer(TestResource testResource) {
        this.testResource = testResource;
    }

    public ResourceServer() {testResource = null;}

    public String getName() {
        if (testResource != null)
            return this.testResource.getName();
        else
            return new String();
    }

    public int getAge() {
        if (testResource != null)
            return this.testResource.getAge();
        else
            return 0;
    }

    public void setResource (TestResource testResource) {
        this.testResource = testResource;
    }
}
