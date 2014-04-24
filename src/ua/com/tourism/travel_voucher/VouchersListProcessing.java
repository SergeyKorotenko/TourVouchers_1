package ua.com.tourism.travel_voucher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Used for voucher list processing
 *
 * @author Korotenko Segey
 */
public  class VouchersListProcessing {

    /**
     * Initialization of five vouchers
     * @param travelList
     */
    public static void vouchersInitialization(List<TravelVoucher> travelList) {
        TravelVoucher voucher0 = new TravelVoucher(7021, TravelVoucher.VoucherType.Excursion,
                TravelVoucher.TransportationType.RoadTransport,
                7, 800, TravelVoucher.FoodType.DNR);
        TravelVoucher voucher1 = new TravelVoucher(8096, TravelVoucher.VoucherType.Cruise,
                TravelVoucher.TransportationType.WaterTransport,
                21, 1200, TravelVoucher.FoodType.ALL);
        TravelVoucher voucher2 = new TravelVoucher(7021, TravelVoucher.VoucherType.Excursion,
                TravelVoucher.TransportationType.RoadTransport,
                7, 800, TravelVoucher.FoodType.DNR);
        TravelVoucher voucher3 = new TravelVoucher(3245, TravelVoucher.VoucherType.Recreation,
                TravelVoucher.TransportationType.AirTransport,
                14, 900, TravelVoucher.FoodType.ALL);
        TravelVoucher voucher4 = new TravelVoucher(2342, TravelVoucher.VoucherType.Shopping,
                TravelVoucher.TransportationType.RoadTransport,
                2, 200, TravelVoucher.FoodType.NA);

        travelList.add(voucher0);
        travelList.add(voucher1);
        travelList.add(voucher2);
        travelList.add(voucher3);
        travelList.add(voucher4);
    }

    /**
     * Sort vouchers list by a transportation type
     * @param travelList
     * @param transportationType
     */
    public static void sortVouchersList(List<TravelVoucher> travelList,
                                        final TravelVoucher.TransportationType transportationType) {
        Collections.sort(travelList, new Comparator<TravelVoucher>() {
            @Override
            public int compare(TravelVoucher o1, TravelVoucher o2) {
                if (o1.getTransportation() == transportationType) {
                    return -1;
                } else return 1;
            }
        });
    }

    /**
     * Sort vouchers list by a food type
     * @param travelList
     * @param foodType
     */
    public static void sortVouchersList(List<TravelVoucher> travelList,
                                        final TravelVoucher.FoodType foodType) {
        Collections.sort(travelList, new Comparator<TravelVoucher>() {
            @Override
            public int compare(TravelVoucher o1, TravelVoucher o2) {
                if (o1.getFoodType() == foodType) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
    }

    /**
     * Sort vouchers list by a voucher type
     * @param travelList
     * @param voucherType
     */
    public static void sortVouchersList(List<TravelVoucher> travelList,
                                        final TravelVoucher.VoucherType voucherType) {
        Collections.sort(travelList, new Comparator<TravelVoucher>() {
            @Override
            public int compare(TravelVoucher o1, TravelVoucher o2) {
                if (o1.getVoucherType() == voucherType) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
    }

    /**
     * Choice vouchers from vouchers list for parameters
     * @param travelList
     * @param minPrice
     * @param maxPrice
     * @param voucherType
     * @param transportationType
     * @param minNumberOfDays
     * @param maxNumberOfDays
     * @param foodType
     * @return list of selected vouchers
     */
    public static List<TravelVoucher> choiceVouchersFromList(List<TravelVoucher> travelList, double minPrice, double maxPrice,
                                                             TravelVoucher.VoucherType voucherType,
                                                             TravelVoucher.TransportationType transportationType,
                                                             int minNumberOfDays, int maxNumberOfDays,
                                                             TravelVoucher.FoodType foodType) {

        List<TravelVoucher> choicedVouchers = new ArrayList<TravelVoucher>();
        for (TravelVoucher travelVoucher : travelList) {
            if (((travelVoucher.getPrice() >= minPrice) && (travelVoucher.getPrice() <= maxPrice))
                    && ((travelVoucher.getVoucherType() == voucherType) || (voucherType == null))
                    && ((travelVoucher.getTransportation() == transportationType) || (transportationType == null))
                    && ((travelVoucher.getNumberOfDays() >= minNumberOfDays))
                    && (travelVoucher.getNumberOfDays() <= maxNumberOfDays)
                    && ((travelVoucher.getFoodType() == foodType) || (foodType == null))) {
                choicedVouchers.add(travelVoucher);
            }
        }
        return choicedVouchers;
    }

    /**
     * Print voucher list to console
     * @param travelList
     */
    public static void printVouchersList(List<TravelVoucher> travelList) {
        for(TravelVoucher s: travelList) {
            System.out.println("---------------------------------");
            System.out.println(s.toString());
        }
        System.out.println("---------END-----------");
    }
}
