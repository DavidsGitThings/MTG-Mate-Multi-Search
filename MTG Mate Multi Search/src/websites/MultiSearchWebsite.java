package websites;

public abstract class MultiSearchWebsite {
    //Variable(s)
    String websiteURL;
    String websiteImgDir;

    //Constructor
    public MultiSearchWebsite(String websiteURL, String websiteImgDir){
        this.websiteURL = websiteURL;
        this.websiteImgDir = websiteImgDir;
    }

    //Method(s)
    public String getWebsiteURL(){
        return (websiteURL);
    }
    public String getWebsiteImgDir(){
        return websiteImgDir;
    }
}
