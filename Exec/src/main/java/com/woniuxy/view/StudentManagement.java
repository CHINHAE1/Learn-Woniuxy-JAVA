package com.woniuxy.view;


import com.woniuxy.domain.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/17 08:52
 * @version: 1.0
 */



class CarManager {
    private List<Car> cars = new ArrayList<>();

    public CarManager(String[] carData) {
        for (String data : carData) {
            String[] parts = data.split("-");
            cars.add(new Car(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
        }
    }

    //  查询所有车
    public List<String> getAllCars() {
        List<String> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(car.toString());
        }
        return result;
    }

    //  按照车牌查询车
    public void addCar(String plate, String carType, String color, int price, String brand) {
        cars.add(new Car(plate, carType, color, price, brand));
    }

    //  按照车牌更新车信息
    public boolean updateCar(String plate, String carType, String color, int price, String brand) {
        for (Car car : cars) {
            if (car.getPlate().equals(plate)) {
                car.setCarType(carType);
                car.setColor(color);
                car.setPrice(price);
                car.setBrand(brand);
                return true;
            }
        }
        return false;
    }

    //  按照车牌删除车
    public boolean deleteCar(String plate) {
        return cars.removeIf(car -> car.getPlate().equals(plate));
    }

    //  按照车型查询车
    public Car queryCar(String plate) {
        for (Car car : cars) {
            if (car.getPlate().equals(plate)) {
                return car;
            }
        }
        return null;
    }

    //  根据四川查询车
    public List<Car> getSichuanSedans() {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPlate().startsWith("川") && car.getCarType().equals("轿车")) {
                result.add(car);
            }
        }
        return result;
    }

    //  按照价格范围查询宝马车
    public List<Car> getBMWsInPriceRange(int minPrice, int maxPrice) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getBrand().equals("宝马") && car.getPrice() >= minPrice && car.getPrice() <= maxPrice) {
                result.add(car);
            }
        }
        return result;
    }

    //  按照价格排序车
    public void sortCarsByPrice() {
        cars.sort(Comparator.comparingInt(Car::getPrice));
    }

    //  按照品牌排序车
    public Map<String, Integer> countCarsByType() {
        Map<String, Integer> result = new HashMap<>();
        for (Car car : cars) {
            //如果result中没有car.getCarType()这个key,则返回0,否则返回对应的值
            result.put(car.getCarType(), result.getOrDefault(car.getCarType(), 0) + 1);
        }
        return result;
    }

    /*public List<CarTypeCount> countCarsByType() {
        List<CarTypeCount> carTypeCounts = new ArrayList<>();
        for (Car car : cars) {
            boolean found = false;
            for (CarTypeCount carTypeCount : carTypeCounts) {
                if (carTypeCount.getCarType().equals(car.getCarType())) {
                    carTypeCount.increment();
                    found = true;
                    break;
                }
            }
            if (!found) {
                CarTypeCount newCount = new CarTypeCount(car.getCarType());
                newCount.increment();
                carTypeCounts.add(newCount);
            }
        }
        return carTypeCounts;
    }*/



    public static void main(String[] args) {
        String[] carsData = {
                "川A55532-轿车-黑色-235000-宝马",
                "川A55577-SUV-黑色-370000-奔驰",
                "川A55566-轿车-红色-157000-宝马",
                "苏A55599-SUV-黑色-210000-比亚迪"
        };

        CarManager manager = new CarManager(carsData);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("车辆管理系统菜单:");
            System.out.println("1. 查询所有汽车信息");
            System.out.println("2. 添加一条车辆信息");
            System.out.println("3. 根据车牌号修改车辆部分信息");
            System.out.println("4. 根据车牌号删除车辆信息");
            System.out.println("5. 根据车牌号查询车辆信息");
            System.out.println("6. 查询所有四川牌照的轿车信息");
            System.out.println("7. 查找价格在20万 - 40万之间的宝马汽车");
            System.out.println("8. 根据车辆价格对所有车辆进行升序排序");
            System.out.println("9. 统计不同类型的车辆总数");
            System.out.println("0. 退出");
            System.out.print("请选择操作: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符

            switch (choice) {
                //  1. 查询所有汽车信息
                case 1:
                    queryAllInfo(manager);
                    break;
                case 2:
                    //  2. 添加一条车辆信息
                    addCarInfo(scanner, manager);
                    break;
                case 3:
                    //  3. 根据车牌号修改车辆部分信息
                    modifyInfo(scanner, manager);
                    break;
                case 4:
                    //  4. 根据车牌号删除车辆信息
                    deleteinfo(scanner, manager);
                    break;
                case 5:
                    //  5. 根据车牌号查询车辆信息
                    queryByIdInfo(scanner, manager);
                    break;
                case 6:
                    //  6. 查询所有四川牌照的轿车信息
                    queryCarInfoAllSichuanInfo(manager);
                    break;
                case 7:
                    //  7. 查找价格在20万 - 40万之间的宝马汽车
                    findBmwCarsPricedBetween200KAnd400K(manager);
                    break;
                case 8:
                    //  8. 根据车辆价格对所有车辆进行升序排序
                    sortAllVehiclesInAscendingOrderAccordingToPrice(manager);
                    break;
                case 9:
                    //  9. 统计不同类型的车辆总数
                    countTotalOfTypes(manager);
                    break;
                case 0:
                    System.out.println("退出系统.");
                    scanner.close();
                    return;
                default:
                    System.out.println("无效的选择，请重新输入.");
            }
        }
    }

    //  9. 统计不同类型的车辆总数
    private static void countTotalOfTypes(CarManager manager) {
        System.out.println("不同类型的车辆总数:");
        //统计不同类型的车辆总数
        Map<String, Integer> carCountByType = manager.countCarsByType();
        //  遍历map集合中的元素
        for (Map.Entry<String, Integer> entry : carCountByType.entrySet()) {
            //  输出key和value
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    //  8. 根据车辆价格对所有车辆进行升序排序
    private static void sortAllVehiclesInAscendingOrderAccordingToPrice(CarManager manager) {
        System.out.println("根据价格升序排序所有车辆:");
        manager.sortCarsByPrice();
        for (String car : manager.getAllCars()) {
            System.out.println(car);
        }
    }

    //  7. 查找价格在20万 - 40万之间的宝马汽车
    private static void findBmwCarsPricedBetween200KAnd400K(CarManager manager) {
        System.out.println("价格在20万 - 40万之间的宝马汽车:");
        for (Car car : manager.getBMWsInPriceRange(200000, 400000)) {
            System.out.println(car);
        }
    }

    //  6. 查询所有四川牌照的轿车信息
    private static void queryCarInfoAllSichuanInfo(CarManager manager) {
        System.out.println("所有四川牌照的轿车信息:");
        for (Car car : manager.getSichuanSedans()) {
            System.out.println(car);
        }
    }

    //  5. 根据车牌号查询车辆信息
    private static void queryByIdInfo(Scanner scanner, CarManager manager) {
        System.out.print("请输入要查询的车牌号: ");
        String queryPlate = scanner.nextLine();
        Car queriedCar = manager.queryCar(queryPlate);
        if (queriedCar != null) {
            System.out.println("查询结果: " + queriedCar);
        } else {
            System.out.println("未找到指定车牌号的车辆.");
        }
    }

    //  4. 根据车牌号删除车辆信息
    private static void deleteinfo(Scanner scanner, CarManager manager) {
        System.out.print("请输入要删除的车牌号: ");
        String deletePlate = scanner.nextLine();
        if (manager.deleteCar(deletePlate)) {
            System.out.println("车辆删除成功!");
        } else {
            System.out.println("未找到指定车牌号的车辆.");
        }
    }

    //  3. 根据车牌号修改车辆部分信息
    private static void modifyInfo(Scanner scanner, CarManager manager) {
        System.out.print("请输入要修改的车牌号: ");
        String updatePlate = scanner.nextLine();
        System.out.print("请输入新的汽车类型: ");
        String updateCarType = scanner.nextLine();
        System.out.print("请输入新的颜色: ");
        String updateColor = scanner.nextLine();
        System.out.print("请输入新的价格: ");
        int updatePrice = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符
        System.out.print("请输入新的品牌: ");
        String updateBrand = scanner.nextLine();
        if (manager.updateCar(updatePlate, updateCarType, updateColor, updatePrice, updateBrand)) {
            System.out.println("车辆信息更新成功!");
        } else {
            System.out.println("未找到指定车牌号的车辆.");
        }
    }

    //  2. 添加一条车辆信息
    private static void addCarInfo(Scanner scanner, CarManager manager) {
        System.out.print("请输入车牌号: ");
        String plate = scanner.nextLine();
        System.out.print("请输入汽车类型: ");
        String carType = scanner.nextLine();
        System.out.print("请输入颜色: ");
        String color = scanner.nextLine();
        System.out.print("请输入价格: ");
        int price = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符
        System.out.print("请输入品牌: ");
        String brand = scanner.nextLine();
        manager.addCar(plate, carType, color, price, brand);
        System.out.println("车辆添加成功!");
    }

    //  1. 查询所有汽车信息
    private static void queryAllInfo(CarManager manager) {
        System.out.println("所有车辆信息:");
        for (String car : manager.getAllCars()) {
            System.out.println(car);
        }
    }
}


