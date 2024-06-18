package com.Exec02.dao;

import com.Exec02.domain.Drug;

import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/18 09:47
 * @version: 1.0
 */
public interface DrugDao {
        List<Drug> getAllDrugs();
        void addDrug(Drug drug);
        void updateDrug(String id, double newPrice, int newStock, String newOrigin);
        void deleteDrug(String id);
        Drug getDrugById(String id);
        List<Drug> getDrugsByPriceAndOrigin(double price, String origin);
        double getAveragePriceByOrigin(String origin);
        Drug getHighestSellingPriceDrug();
        List<Drug> sortDrugsByPurchasePrice();
        List<Drug> getDrugsGroupedByOrigin();

}
