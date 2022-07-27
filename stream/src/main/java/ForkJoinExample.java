import java.util.concurrent.*;
import java.util.stream.LongStream;

/**
 * @Description fork/join 框架计算
 * @Author hq
 * @Date 2022/7/26 19:57
 * @Version 1.0
 */
public class ForkJoinExample extends RecursiveTask<Integer> {

    public static final int threshold = 2;
    private int start;
    private int end;
   public ForkJoinExample(int start,int end){
       this.start = start;
       this.end   = end;
   }

    @Override
    protected Integer compute() {
       int sum = 0;
       boolean flag = (end - start) <= threshold;
        if (flag){
            for (int i = start; i <= end ; i++) {
                 sum += i;
            }
        }else {
            int middle = (end + start) / 2;
            ForkJoinExample leftTask = new ForkJoinExample(start, middle);
            ForkJoinExample rightTask = new ForkJoinExample(middle + 1, end);
            leftTask.fork();
            rightTask.fork();

            Integer leftResult = leftTask.join();
            Integer rightResult = rightTask.join();
            sum  = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        //fork/join 框架
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinExample task = new ForkJoinExample(1, 100);
        Future<Integer> future = pool.submit(task);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //并行流
        System.out.println(LongStream.rangeClosed(0, 100L).parallel().reduce(0, Long::sum));
    }
}
