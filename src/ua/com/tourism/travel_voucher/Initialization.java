package ua.com.tourism.travel_voucher;

import java.util.ArrayList;
import java.util.List;

import static ua.com.tourism.travel_voucher.TravelVoucherTest.*;
import static ua.com.tourism.travel_voucher.VouchersListProcessing.*;


/**
 * For initialization
 *
 * @author Sergey Korotenko
 */

public class Initialization {
    public static void main(String[] args) {
        List<TravelVoucher> travelList = new ArrayList<TravelVoucher>();
        vouchersInitialization(travelList);

        sortVouchersList(travelList, TravelVoucher.FoodType.NA);
        printVouchersList(travelList);

        sortVouchersList(travelList, TravelVoucher.TransportationType.AirTransport);
        printVouchersList(travelList);

        sortVouchersList(travelList, TravelVoucher.VoucherType.Shopping);
        printVouchersList(travelList);

        testSort();
        testSetPrise();
        testSearchTourByPriceAndDays();


    }
}


