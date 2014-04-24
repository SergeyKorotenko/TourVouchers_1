package ua.com.tourism.travel_voucher;

import java.util.ArrayList;
import java.util.List;

/**
 * Used for tests
 *
 * @author Sergey Korotenko
 */
public class TravelVoucherTest {

    /**
     * Test method sortVouchersList
     */
    public static void testSort() {
        List<TravelVoucher> travelList = new ArrayList<TravelVoucher>();
        VouchersListProcessing.vouchersInitialization(travelList);
        VouchersListProcessing.sortVouchersList(travelList, TravelVoucher.FoodType.DNR);
        System.out.println("\'sort by DNR!\'");
        VouchersListProcessing.printVouchersList(travelList);
    }

    /**
     * Test for setPrice
     */
    public static void testSetPrise() {
        TravelVoucher voucher1 = new TravelVoucher();
        voucher1.setId(4332);
        try {
            voucher1.setPrice(-200.00);
            System.out.println("test \'Set Price\' - False!");
        } catch (IllegalArgumentException e) {
            System.out.println("test \'Set Price\' - OK!    " + e);
        }
    }

    /**
     * Test method choiceVouchersFromList
     */
    public static void testSearchTourByPriceAndDays() {
        List<TravelVoucher> travelList = new ArrayList<TravelVoucher>();
        VouchersListProcessing.vouchersInitialization(travelList);
        for (TravelVoucher travelVoucher :
                VouchersListProcessing.choiceVouchersFromList(travelList, 1000, 1200, null, null, 20, 21, null)) {
            if (travelVoucher.getId() == travelList.get(1).getId()) {
                System.out.println("test \'Search Tour by prise and days\' - OK! ");
            } else {
                System.out.println("test \'Search Tour by price and days\' - False!");
            }
        }
    }
}
