package geekbrains_course.Seminar6;

import java.util.*;

class Laptop {
    private String brand;
    private String model;
    private int ram;
    private int hddCapacity;
    private String os;
    private String color;

    public Laptop(String brand, String model, int ram, int hddCapacity, String os, String color) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.hddCapacity = hddCapacity;
        this.os = os;
        this.color = color;
    }

    public int getRam() {
        return ram;
    }

    public int getHddCapacity() {
        return hddCapacity;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    } 
    
    @Override
    public String toString() {
        return brand + ", " + model + ", " + ram + ", " + hddCapacity + ", " + os + ", " + color;
    }

}

public class LaptopStore {
    private Set<Laptop> laptops;

    public LaptopStore() {
        this.laptops = new HashSet<>();
    }

    public void addLaptop(Laptop laptop) {
        laptops.add(laptop);
    }

    public void filterLaptops(Map<String, Object> filters) {
        for (Laptop laptop : laptops) {
            boolean passFilter = true;
            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                switch (key) {
                    case "RAM":
                        if (laptop.getRam() < (int) value) {
                            passFilter = false;
                        }
                        break;
                    case "HDDCapacity":
                        if (laptop.getHddCapacity() < (int) value) {
                            passFilter = false;
                        }
                        break;
                    case "OS":
                        if (!laptop.getOs().equalsIgnoreCase((String) value)) {
                            passFilter = false;
                        }
                        break;
                    case "Color":
                        if (!laptop.getColor().equalsIgnoreCase((String) value)) {
                            passFilter = false;
                        }
                        break;
                }
            }
            if (passFilter) {
                System.out.println(laptop);
            }
        }
    }

    public static void main(String[] args) {
        LaptopStore store = new LaptopStore();
        store.addLaptop(new Laptop("Dell", "XPS 13", 16, 512, "Windows 10", "Silver"));
        store.addLaptop(new Laptop("Apple", "MacBook Pro", 8, 256, "macOS", "Space Gray"));

        Map<String, Object> filters = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("�������� �������� ����������:");
        System.out.println("1 - ���");
        System.out.println("2 - ����� ��");
        System.out.println("3 - ������������ �������");
        System.out.println("4 - ����");
        System.out.print("������� ����� ��������: ");
        int criterion = scanner.nextInt();
        switch (criterion) {
            case 1:
                System.out.print("����������� ����� ���: ");
                int minRam = scanner.nextInt();
                filters.put("RAM", minRam);
                break;
            case 2:
                System.out.print("����������� ����� ��: ");
                int minHddCapacity = scanner.nextInt();
                filters.put("HDDCapacity", minHddCapacity);
                break;
            case 3:
                System.out.print("������������ �������: ");
                String os = scanner.next();
                filters.put("OS", os);
                break;
            case 4:
                System.out.print("����: ");
                String color = scanner.next();
                filters.put("Color", color);
                break;
            default:
                System.out.println("������������ ����� ��������");
                break;
        }

        System.out.println("��������� ��������:");
        store.filterLaptops(filters);
    }
}
