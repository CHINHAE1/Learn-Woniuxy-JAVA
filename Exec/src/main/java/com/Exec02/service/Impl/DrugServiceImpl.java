package com.Exec02.service.Impl;

import com.Exec02.dao.DrugDao;
import com.Exec02.domain.Drug;
import com.Exec02.service.DrugService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/18 09:45
 * @version: 1.0
 */
public class DrugServiceImpl implements DrugService {
  private DrugDao drugDao;

  public DrugServiceImpl(DrugDao drugDao) {
    this.drugDao = drugDao;
  }

  /**
   * 获取所有药品信息
   * @return 包含所有药品信息的列表
   */
  @Override
  public List<Drug> getAllDrugs() {
    return drugDao.getAllDrugs();
  }

  /**
   * 添加药品信息
   * @param drug 需要添加的药品对象
   * @return 是否成功添加药品
   */
  @Override
  public boolean addDrug(Drug drug) {
    // 检查药品编号是否已存在
    if (drugDao.getDrugById(drug.getId()) != null) {
      return false; // 药品编号已存在，添加失败
    }
    drugDao.addDrug(drug); // 添加药品
    return true; // 添加成功
  }

  /**
   * 根据药品编号更新药品信息
   * @param id 药品编号
   * @param newPrice 新的单价
   * @param newStock 新的库存
   * @param newOrigin 新的产地
   * @return 是否成功更新药品信息
   */
  @Override
  public boolean updateDrug(String id, double newPrice, int newStock, String newOrigin) {
    Drug drug = drugDao.getDrugById(id);
    // 检查药品是否存在
    if (drug == null) {
      return false; // 药品编号不存在，更新失败
    }
    drugDao.updateDrug(id, newPrice, newStock, newOrigin); // 更新药品信息
    return true; // 更新成功
  }

  /**
   * 根据药品编号删除药品信息
   * @param id 药品编号
   * @return 是否成功删除药品信息
   */
  @Override
  public boolean deleteDrug(String id) {
    Drug drug = drugDao.getDrugById(id);
    if (drug == null) {
      return false;
    }
    drugDao.deleteDrug(id);// 删除药品信息
    return true; // 删除成功
  }

  /**
   * 根据药品编号查询药品信息
   * @param id 药品编号
   * @return 对应药品编号的药品对象，如果未找到则返回null
   */
  @Override
  public Drug getDrugById(String id) {
    return drugDao.getDrugById(id);
  }

  /**
   * 获取进价高于指定价格并且产地为指定地点的药品信息
   * @param price 指定的价格
   * @param origin 指定的产地
   * @return 符合条件的药品信息列表
   */
  @Override
  public List<Drug> getDrugsByPriceAndOrigin(double price, String origin) {
    return drugDao.getDrugsByPriceAndOrigin(price, origin);
  }

  /**
   * 获取指定产地的药品售卖平均价格
   * @param origin 指定的产地
   * @return 指定产地药品的售卖平均价格
   */
  @Override
  public double getAveragePriceByOrigin(String origin) {
    return drugDao.getAveragePriceByOrigin(origin);
  }

  /**
   * 获取售卖价格最高的药品信息
   * @return 售卖价格最高的药品对象
   */
  @Override
  public Drug getHighestSellingPriceDrug() {
    return drugDao.getHighestSellingPriceDrug();
  }

  /**
   * 根据药品的进价进行升序排序
   * @return 按进价升序排序后的药品信息列表
   */
  @Override
  public List<Drug> sortDrugsByPurchasePrice() {
    return drugDao.sortDrugsByPurchasePrice();
  }

  /**
   * 统计不同产地的药品信息
   * @return 按产地分组的药品信息列表
   */
  @Override
  public Map<String, List<Drug>> getDrugsGroupedByOrigin() {
    return drugDao.getAllDrugs().stream()
            .collect(Collectors.groupingBy(Drug::getOrigin));
  }
}
