package com.Exec02.controller;

import com.Exec02.domain.Drug;
import com.Exec02.service.DrugService;

import java.util.List;
import java.util.Map;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/18 09:43
 * @version: 1.0
 */
public class DrugController {
  private DrugService drugService;

  public DrugController(DrugService drugService) {
    this.drugService = drugService;
  }

  /**
   * 获取所有药品信息并打印
   */
  public void getAllDrugs() {
    List<Drug> allDrugs = drugService.getAllDrugs();
    System.out.println("所有药品信息:");
    for (Drug drug : allDrugs) {
      System.out.println(drug);
    }
  }

  /**
   * 添加药品信息并打印结果
   * @param drug 需要添加的药品对象
   */
  public void addDrug(Drug drug) {
    boolean success = drugService.addDrug(drug);
    if (success) {
      System.out.println("药品添加成功");
    } else {
      System.out.println("药品编号已存在，添加失败");
    }
  }

  /**
   * 根据药品编号更新药品信息并打印结果
   * @param id 药品编号
   * @param newPrice 新的单价
   * @param newStock 新的库存
   * @param newOrigin 新的产地
   */
  public void updateDrug(String id, double newPrice, int newStock, String newOrigin) {
    boolean success = drugService.updateDrug(id, newPrice, newStock, newOrigin);
    if (success) {
      System.out.println("药品信息更新成功");
    } else {
      System.out.println("未找到药品编号，更新失败");
    }
  }

  /**
   * 根据药品编号删除药品信息并打印结果
   * @param id 药品编号
   */
  public void deleteDrug(String id) {
    boolean success = drugService.deleteDrug(id);
    if (success) {
      System.out.println("药品删除成功");
    } else {
      System.out.println("未找到药品编号，删除失败");
    }
  }

  /**
   * 根据药品编号查询药品信息并打印结果
   * @param id 药品编号
   */
  public void getDrugById(String id) {
    Drug drug = drugService.getDrugById(id);
    if (drug != null) {
      System.out.println(drug);
    } else {
      System.out.println("未找到药品");
    }
  }

  /**
   * 获取进价高于指定价格并且产地为指定地点的药品信息并打印结果
   * @param price 指定的价格
   * @param origin 指定的产地
   */
  public void getDrugsByPriceAndOrigin(double price, String origin) {
    List<Drug> drugs = drugService.getDrugsByPriceAndOrigin(price, origin);
    System.out.println("进价高于" + price + "元在" + origin + "生产的药品信息:");
    for (Drug drug : drugs) {
      System.out.println(drug);
    }
  }

  /**
   * 获取指定产地的药品售卖平均价格并打印结果
   * @param origin 指定的产地
   */
  public void getAveragePriceByOrigin(String origin) {
    double avgPrice = drugService.getAveragePriceByOrigin(origin);
    System.out.println(origin + "地区药品的售卖平均价格: " + avgPrice);
  }

  /**
   * 获取售卖价格最高的药品信息并打印结果
   */
  public void getHighestSellingPriceDrug() {
    Drug highestPriceDrug = drugService.getHighestSellingPriceDrug();
    System.out.println("售卖价格最高的药品信息: " + highestPriceDrug);
  }

  /**
   * 根据药品的进价进行升序排序并打印结果
   */
  public void sortDrugsByPurchasePrice() {
    List<Drug> sortedDrugs = drugService.sortDrugsByPurchasePrice();
    System.out.println("根据进价升序排序的药品信息:");
    for (Drug drug : sortedDrugs) {
      System.out.println(drug);
    }
  }

  /**
   * 统计不同产地的药品信息并打印结果
   */
  public void getDrugsGroupedByOrigin() {
    Map<String, List<Drug>> groupedDrugs = drugService.getDrugsGroupedByOrigin();
    for (Map.Entry<String, List<Drug>> entry : groupedDrugs.entrySet()) {
      String origin = entry.getKey();
      List<Drug> drugs = entry.getValue();
      System.out.println("生产地在 " + origin + " 的药品总共有 " + drugs.size() + " 种,详情如下:");
      for (Drug drug : drugs) {
        System.out.println("\t" + drug);
      }
    }
  }
}
