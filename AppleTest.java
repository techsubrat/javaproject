package behavior.parameterization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppleTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Apple apple = new Apple("red",100);
        Apple apple1 = new Apple("green",150);
        Apple apple2 = new Apple("pink",100);
        Apple apple3 = new Apple("green",200);
        Apple apple4 = new Apple("red",100);
        Apple apple5 = new Apple("green",100);
        Apple apple6 = new Apple("green",170);
        Apple apple7 = new Apple("red",200);
        
        List<Apple> appleList = new ArrayList<>();
        appleList.add(apple);
        appleList.add(apple1);
        appleList.add(apple2);
        appleList.add(apple3);
        appleList.add(apple4);
        appleList.add(apple5);
        appleList.add(apple6);
        appleList.add(apple7);
        
        /*System.out.println(filterGreenApples(appleList));
        System.out.println(filterApplesByColor(appleList, "green"));
        System.out.println(filterApples(appleList, new AppleGreenColorPredicate()));
        System.out.println(filterApplesByColor(appleList, "red"));
        System.out.println(filterApplesByWeight(appleList, 150));
        System.out.println(filterApples(appleList, "green", 150, false));
        System.out.println(filterApples(appleList, new AppleHeavyWeightPredicate()));
        System.out.println(filterApples(appleList, new AppleRedAndHeavyPredicate()));*/
        List<Apple> result = filterApples(appleList, (Apple app) -> ("red".equals(app.getColor()) && (app.getWeight() > 150)));
        System.out.println(result);
        /*result = filterApples(result, (Apple app) -> (app.getWeight() > 150));
        System.out.println(result);*/

    }
    
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<Apple>();
        
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }
    
    
    
    
    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }
    
    
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }
    
    
    public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag &&  apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }
    
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate applePredicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (applePredicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

}
