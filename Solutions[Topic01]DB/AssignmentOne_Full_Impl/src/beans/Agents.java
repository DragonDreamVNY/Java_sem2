package beans;

/**
 *
 * @author alan.ryan
 */
public class Agents {
    
    private int agentID;
    private String name;
    private String phone;
    private String fax;
    private String email;
    private String username;
    private String password;
    private String agentImage;

    public Agents() {
    }

    public Agents(int agentID, String name, String phone, String fax, String email, String username, String password, String agentImage) {
        this.agentID = agentID;
        this.name = name;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.username = username;
        this.password = password;
        this.agentImage = agentImage;
    }

  
    /**
     * @return the agentID
     */
    public int getAgentID() {
        return agentID;
    }

    /**
     * @param agentID the agentID to set
     */
    public void setAgentID(int agentID) {
        this.agentID = agentID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the agentImage
     */
    public String getAgentImage() {
        return agentImage;
    }

    /**
     * @param agentImage the agentImage to set
     */
    public void setAgentImage(String agentImage) {
        this.agentImage = agentImage;
    }
    
    
}
