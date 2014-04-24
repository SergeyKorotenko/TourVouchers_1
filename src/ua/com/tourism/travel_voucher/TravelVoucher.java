package ua.com.tourism.travel_voucher;

/**
 * class Tour Voucher
 *
 * @author Sergey Korotenko
 */
public class TravelVoucher {

    /**
     * type of voucher(Shopping, Excursion..)
     */
    private VoucherType voucherType;

    /**
     * type of transportation(Recreation, Excursion..)
     */
    private TransportationType transportationType;

    /**
     * type of food(NA, ALL, DNR..)
     */
    private FoodType foodType;

    /**
     * identification vouchers
     */
    private int id;

    /**
     * price of the voucher
     */
    private double price;

    /**
     * number of days of tour
     */
    private int numberOfDays;


    /**
     * Vouchers type that can be selected
     */
    enum VoucherType {

        /**
         * Recreation voucher type
         */
        Recreation,

        /**
         * Excursion voucher type
         */
        Excursion,

        /**
         * Treatment voucher type
         */
        Treatment,

        /**
         * Shopping voucher type
         */
        Shopping,

        /**
         * Cruise voucher type
         */
        Cruise;
    }

    /**
     * Type of food that can be selected
     */
    enum FoodType {
        NA("Not Available"), BB("Bed and Breakfast"),
        CBF("Continental Breakfast"), BBF("Buffet Breakfast"),
        DNR("Dinner"), FB("Full Board"), ALL("All Inclusive"),
        UAI("Ultra All Inclusive");

        /**
         * description of food type
         */
        private String description;

        /**
         * Set description of type of food
         * @param description
         */
        FoodType(String description) {
            this.description = description;
        }

        /**
         * Get description of type of food
         * @return  description about type of food
         */
        String getDescription() {
            return " " + "(" + description + ")";
        }
    }

    /**
     * Type of transportation that can be selected
     */
    enum TransportationType {

        /**
         * Road transport
         */
        RoadTransport,

        /**
         * Water transport
         */
        WaterTransport,

        /**
         * Rail transport
         */
        RailTransport,

        /**
         * Air transport
         */
        AirTransport;

    }

    /**
     * Default class constructor
     */
    public TravelVoucher() {
    }

    /**
     * Class constructor.
     *
     * @param id
     * @param voucherType
     * @param transportationType
     * @param numberOfDays
     * @param price
     * @param foodType
     * @see   #setPrice(double)
     */
    public TravelVoucher(int id, VoucherType voucherType,
                         TransportationType transportationType,
                         int numberOfDays, double price, FoodType foodType) {
        this.id = id;
        this.voucherType = voucherType;
        this.transportationType = transportationType;
        this.numberOfDays = numberOfDays;
        setPrice(price);
        this.foodType = foodType;
    }

    /**
     * Get voucher id
     * @return  number of voucher
     */
    public int getId() {
        return id;
    }

    /**
     * Get voucher price
     * @return price of voucher
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get number of days
     * @return Number of days in travel voucher
     */
    public int getNumberOfDays() {
        return numberOfDays;
    }

    /**
     *
     * @return type of transportation
     */
    public TransportationType getTransportation() {
        return transportationType;
    }

    /**
     *
     * @return type of voucher
     */
    public VoucherType getVoucherType() {
        return voucherType;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param voucherType
     */
    public void setVoucherType(VoucherType voucherType) {
        this.voucherType = voucherType;
    }

    /**
     *
     * @param transportationType
     */
    public void setTransportation(TransportationType transportationType) {
        this.transportationType = transportationType;
    }

    /**
     *
     * @return type of food
     */
    public FoodType getFoodType() {
        return foodType;
    }

    /**
     *
     * @param price
     * @throws IllegalArgumentException If price < 0
     */
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else throw new IllegalArgumentException("Illeagal Arguments in voucher - " + getId());


    }

    /**
     *
     * @param numberOfDays
     */
    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    /**
     *
     * @return object's params converted to String
     */
    @Override
    public String toString() {
        return " Voucher number = " + id + "\n"
                + " Type Of Voucher = " + voucherType + "\n"
                + " Type Of Transportation = " + transportationType + "\n"
                + " Number Of Days = " + numberOfDays + "\n"
                + " Price = " + price + "$" + "\n"
                + " Type OF Food = " + foodType + foodType.getDescription() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TravelVoucher)) return false;

        TravelVoucher that = (TravelVoucher) o;

        if (id != that.id) return false;
        if (numberOfDays != that.numberOfDays) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (foodType != that.foodType) return false;
        if (transportationType != that.transportationType) return false;
        if (voucherType != that.voucherType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = voucherType != null ? voucherType.hashCode() : 0;
        result = 31 * result + (transportationType != null ? transportationType.hashCode() : 0);
        result = 31 * result + id;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + numberOfDays;
        result = 31 * result + (foodType != null ? foodType.hashCode() : 0);
        return result;
    }
}
