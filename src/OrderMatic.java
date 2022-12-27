import java.util.ArrayList;
import java.util.List;

public class OrderMatic implements Runnable{
    private List<Integer> list = new ArrayList<>();
    private final Object LOCK = new Object();
    private static List<Integer> evenList = new ArrayList<>();
    private static List<Integer> oddList = new ArrayList<>();

    public OrderMatic(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        orderMatic();
    }

    public void orderMatic(){
        for(Integer i : list){
            if(i%2 == 0){
                evenList.add(i);
            }else {
                oddList.add(i);
            }
        }
    }

    public static List<Integer> oddNumbers(){
        return oddList;
    }
    public static List<Integer> evenNumbers(){
        return evenList;
    }


    public static void getListSize(){
        System.out.println("Even numbers size: " + evenList.size());
        System.out.println("Odd numbers size: " + oddList.size());
    }


}
