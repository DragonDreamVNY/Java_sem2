
package src;

import java.util.Date;


/**
 *
 * @author Alan.Ryan
 */
public class Prices  {
   
    private int companynum;
    private String company;
    private double currentPrice;
    private double yesterdaysPrice;
    private int sharesTradedYesterday;
    private double yearlyLow;
    private double yearlyHigh;
    private Date listingDate;

    public Prices() {
    }

    public Prices(int companynum, String company, double currentPrice, double yesterdaysPrice, int sharesTradedYesterday, double yearlyLow, double yearlyHigh, Date listingDate) {
        this.companynum = companynum;
        this.company = company;
        this.currentPrice = currentPrice;
        this.yesterdaysPrice = yesterdaysPrice;
        this.sharesTradedYesterday = sharesTradedYesterday;
        this.yearlyLow = yearlyLow;
        this.yearlyHigh = yearlyHigh;
        this.listingDate = listingDate;
    }

  

 

    @Override
    public String toString() {
        return "src.Prices[ companynum=" + getCompanynum() + " ]";
    }

    public String formatAllCompanys() {
        return String.format("%-5d%-50s%-12.2f%-12.2f%-10d%-10.2f%-11.2f%-25s", getCompanynum(), 
                getCompany(), getCurrentPrice(), getYesterdaysPrice(), getSharesTradedYesterday(), 
                getYearlyLow(), getYearlyHigh(), getListingDate().toString());
    }
    /**
     * @return the yesterdaysPrice
     */
    public double getYesterdaysPrice() {
        return yesterdaysPrice;
    }

    /**
     * @param yesterdaysPrice the yesterdaysPrice to set
     */
    public void setYesterdaysPrice(double yesterdaysPrice) {
        this.yesterdaysPrice = yesterdaysPrice;
    }

    /**
     * @return the sharesTradedYesterday
     */
    public int getSharesTradedYesterday() {
        return sharesTradedYesterday;
    }

    /**
     * @param sharesTradedYesterday the sharesTradedYesterday to set
     */
    public void setSharesTradedYesterday(int sharesTradedYesterday) {
        this.sharesTradedYesterday = sharesTradedYesterday;
    }

    /**
     * @return the yearlyLow
     */
    public double getYearlyLow() {
        return yearlyLow;
    }

    /**
     * @param yearlyLow the yearlyLow to set
     */
    public void setYearlyLow(double yearlyLow) {
        this.yearlyLow = yearlyLow;
    }

    /**
     * @return the yearlyHigh
     */
    public double getYearlyHigh() {
        return yearlyHigh;
    }

    /**
     * @param yearlyHigh the yearlyHigh to set
     */
    public void setYearlyHigh(double yearlyHigh) {
        this.yearlyHigh = yearlyHigh;
    }

    /**
     * @return the listingDate
     */
    public Date getListingDate() {
        return listingDate;
    }

    /**
     * @param listingDate the listingDate to set
     */
    public void setListingDate(Date listingDate) {
        this.listingDate = listingDate;
    }

    /**
     * @return the companynum
     */
    public int getCompanynum() {
        return companynum;
    }

    /**
     * @param companynum the companynum to set
     */
    public void setCompanynum(int companynum) {
        this.companynum = companynum;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the currentPrice
     */
    public double getCurrentPrice() {
        return currentPrice;
    }

    /**
     * @param currentPrice the currentPrice to set
     */
    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
    
}
