package month2.day18;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        int pro, con;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入生产者数量:");
        pro = sc.nextInt();
        System.out.print("请输入消费者数量:");
        con = sc.nextInt();
        for (int i = 0; i < pro; i++) {
            new Thread(new Producer(), "生产者" + Integer.toString(i) + "号").start();
        }
        for (int i = 0; i < con; i++) {
            new Thread(new Consumer(), "消费者" + Integer.toString(i) + "号").start();
        }
    }
}

class Global {
    public static Semaphore empty = new Semaphore(3);
    public static Semaphore full = new Semaphore(0);
    public static Semaphore mutex = new Semaphore(1);
    public static int i = 0;

    public static void timingwait() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

}

class Producer implements Runnable {

    @Override
    public void run() {
        Global.timingwait();
        System.out.print(Thread.currentThread().getName() + "  生产出一个商品...");
        Global.empty.P();
        Global.mutex.P();
        Global.timingwait();
        System.out.print(Thread.currentThread().getName() + "将产品放入缓冲区" + (++Global.i) + "个产品");
        Global.mutex.V();
        Global.full.V();
    }
}

class Consumer implements Runnable {
    @Override
    public void run() {
        Global.timingwait();
        Global.full.P();//获取满缓冲区单元
        Global.mutex.P();//进入临界区
        Global.timingwait();
        System.out.println(Thread.currentThread().getName() + "  从缓冲区取出一个产品--缓冲区剩余 " + (--Global.i) + " 个产品");
        Global.mutex.V();//离开临界区，释放互斥信号量
        Global.empty.V();//空缓冲区加一
        System.out.println(Thread.currentThread().getName() + "  消费一个商品...");
    }
}


//信号量
class Semaphore {
    public int value;

    public Semaphore(int value) {
        super();
        this.value = value;
    }

    //P操作
    public synchronized final void P()//使用synchronized修饰的方法,叫做同步方法,保证A线程执行该方法的时,其他线程只能在方法外等着.
    {//被final修饰的方法是一个最终方法，不能被重写,重写会报错
        value--;
        if (value < 0) {
            try {
                this.wait();//当缓冲区已满/空时，生产者或消费者线程停止自己的执行，释放锁，使自己处于等待状态，让其它线程执行
            } catch (InterruptedException e)//当使用java.lang.Thread类的 wait方法时，可能会导致线程阻塞，需要抛出InterruptedException(中断异常)异常
            {
                e.printStackTrace();
            }
        }
    }

    //V操作
    public synchronized final void V() {
        value++;
        if (value <= 0) {
            this.notify();//当生产者或消费者向缓冲区放入或取出一个产品时，向其他等待的线程发出通知，同时释放锁，使自己处于等待状态，让其它线程执行。
        }
    }
}


