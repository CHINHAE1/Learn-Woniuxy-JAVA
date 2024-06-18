package com.Exec02.service;

import com.Exec02.domain.Drug;

import java.util.List;
import java.util.Map;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/18 09:44
 * @version: 1.0
 */
public interface DrugService {
    List<Drug> getAllDrugs();
    boolean addDrug(Drug drug);
    boolean updateDrug(String id, double newPrice, int newStock, String newOrigin);
    boolean deleteDrug(String id);
    Drug getDrugById(String id);
    List<Drug> getDrugsByPriceAndOrigin(double price, String origin);
    double getAveragePriceByOrigin(String origin);
    Drug getHighestSellingPriceDrug();
    List<Drug> sortDrugsByPurchasePrice();
    Map<String, List<Drug>> getDrugsGroupedByOrigin();

}
