package beans;

/**
 *
 * @author alan.ryan
 */
public class Properties {
    
    private int id;
    private String street;
    private String bedrooms;
    private String bathrooms;
    private String description;
    private String agentId;
    private String photo;
    private String squareFootage;
    private double price;

    public Properties() {
       
    }

    public Properties(String street, String bedrooms, String bathrooms, String description, String photo, double price) {
        this.street = street;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.description = description;
        this.photo = photo;
        this.price = price;
        
       
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the bedrooms
     */
    public String getBedrooms() {
        return bedrooms;
    }

    /**
     * @param bedrooms the bedrooms to set
     */
    public void setBedrooms(String bedrooms) {
        this.bedrooms = bedrooms;
    }

    /**
     * @return the bathrooms
     */
    public String getBathrooms() {
        return bathrooms;
    }

    /**
     * @param bathrooms the bathrooms to set
     */
    public void setBathrooms(String bathrooms) {
        this.bathrooms = bathrooms;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the agentID
     */
    public String getAgentId() {
        return agentId;
    }


    /**
     * @return the squareFootage
     */
    public String getSquareFootage() {
        return squareFootage;
    }

    /**
     * @param squareFootage the squareFootage to set
     */
    public void setSquareFootage(String squareFootage) {
        this.squareFootage = squareFootage;
    }
    
  }//end class Properties
