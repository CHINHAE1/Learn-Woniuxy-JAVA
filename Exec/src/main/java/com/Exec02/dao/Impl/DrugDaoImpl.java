package com.Exec02.dao.Impl;

import com.Exec02.dao.DrugDao;
import com.Exec02.domain.Drug;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/18 09:46
 * @version: 1.0
 */

public class DrugDaoImpl implements DrugDao {
  private List<Drug> drugList;

  public DrugDaoImpl() {
    drugList = new ArrayList<>();
    loadInitialData();
  }

  private void loadInitialData() {
    drugList.add(new Drug("230714204045", "盖中盖", "南京", 18, 88, 998));
    drugList.add(new Drug("230714204110", "新盖中盖", "南京", 28, 188, 1000));
    drugList.add(new Drug("230714204101", "巨能钙", "上海", 26, 200, 1200));
    drugList.add(new Drug("230714204052", "六味地黄丸", "南京", 12, 30, 2000));
    drugList.add(new Drug("230714204050", "999感冒灵", "广州", 5, 15, 1210));
  }


  /**
   * 获取所有药品信息
   * @return 包含所有药品信息的列表
   */
  @Override
  public List<Drug> getAllDrugs() {
    return drugList;
  }

  /**
   * 添加药品信息
   * @param drug 需要添加的药品对象
   */
  @Override
  public void addDrug(Drug drug) {
    drugList.add(drug);
  }

  /**
   * 根据药品编号更新药品信息
   * @param id 药品编号
   * @param newPrice 新的单价
   * @param newStock 新的库存
   * @param newOrigin 新的产地
   */
  @Override
  public void updateDrug(String id, double newPrice, int newStock, String newOrigin) {
    for (Drug drug : drugList) {
      if (drug.getId().equals(id)) {
        drug.setSellingPrice(newPrice);
        drug.setStock(newStock);
        drug.setOrigin(newOrigin);
        return;
      }
    }
  }

  /**
   * 根据药品编号删除药品信息
   * @param id 药品编号
   */
  @Override
  public void deleteDrug(String id) {
    drugList.removeIf(drug -> drug.getId().equals(id));
  }

  /**
   * 根据药品编号查询药品信息
   * @param id 药品编号
   * @return 对应药品编号的药品对象，如果未找到则返回null
   */
  @Override
  public Drug getDrugById(String id) {
    for (Drug drug : drugList) {
      if (drug.getId().equals(id)) {
        return drug;
      }
    }
    return null;
  }

  /**
   * 获取进价高于指定价格并且产地为指定地点的药品信息
   * @param price 指定的价格
   * @param origin 指定的产地
   * @return 符合条件的药品信息列表
   */

  @Override
  public List<Drug> getDrugsByPriceAndOrigin(double price, String origin) {
    List<Drug> result = new ArrayList<>();
    for (Drug drug : drugList) {
      if (drug.getPurchasePrice() > price && drug.getOrigin().equals(origin)) {
        result.add(drug);
      }
    }
    return result;
  }

  /**
   * 获取指定产地的药品售卖平均价格
   * @param origin 指定的产地
   * @return 指定产地药品的售卖平均价格
   */
  @Override
  public double getAveragePriceByOrigin(String origin) {
    double sum = 0;
    int count = 0;
    for (Drug drug : drugList) {
      if (drug.getOrigin().equals(origin)) {
        sum += drug.getSellingPrice();
        count++;
      }
    }
    return count > 0 ? sum / count : 0;
  }

  /**
   * 获取售卖价格最高的药品信息
   * @return 售卖价格最高的药品对象
   */
  @Override
  public Drug getHighestSellingPriceDrug() {
    Drug highest = null;
    for (Drug drug : drugList) {
      if (highest == null || drug.getSellingPrice() > highest.getSellingPrice()) {
        highest = drug;
      }
    }
    return highest;
  }

  /**
   * 根据药品的进价进行升序排序
   * @return 按进价升序排序后的药品信息列表
   */
  @Override
  public List<Drug> sortDrugsByPurchasePrice() {
    List<Drug> sortedList = new ArrayList<>(drugList);
    sortedList.sort(Comparator.comparingDouble(Drug::getPurchasePrice));
    return sortedList;
  }

  /**
   * 统计不同产地的药品信息
   * @return 按产地分组的药品信息列表
   */
  @Override
  public List<Drug> getDrugsGroupedByOrigin() {
    return drugList;
  }
}
