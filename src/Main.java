import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();

        ExecutorService pool = Executors.newFixedThreadPool(4);
        for (int i=1; i <= 100; i++){
            list.add(i);
        }
        for(int i = 0; i<4; i++){
            int x = i * 25;
            int y = x + 25;
            pool.execute(new OrderMatic(list.subList(x,y)));
            Thread.sleep(1000);
        }
        pool.shutdown();
        try{
            pool.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println("Threads are completed");
        }catch (InterruptedException e){
            System.out.println(e.toString());
        }

        System.out.println("Odd Numbers: " + OrderMatic.oddNumbers());
        System.out.println("Even Numbers: " + OrderMatic.evenNumbers());
        OrderMatic.getListSize();

    }
}
