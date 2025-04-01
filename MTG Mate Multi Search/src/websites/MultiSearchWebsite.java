package websites;

public abstract class MultiSearchWebsite {
    //Variable(s)
    String websiteURL;

    //Constructor
    public MultiSearchWebsite(String websiteURL){
        this.websiteURL = websiteURL;
    }

    //Method(s)
    public String getWebsiteURL(){
        return (websiteURL);
    }
}
