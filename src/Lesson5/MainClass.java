package Lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

import static Lesson5.MainClass.CARS_COUNT;

public class MainClass{

    public static final int CARS_COUNT = 4;

    public static void main(String[] args){

        CyclicBarrier barier = new CyclicBarrier(CARS_COUNT,
                () -> {
                    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!");
                });

        CountDownLatch latch = new CountDownLatch(CARS_COUNT);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!");
        Race race = new Race(new Road(60), new Tunnel(15), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race,20 + (int)(Math.random() * 10), barier, latch);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!");
    }
}

class Car implements Runnable{

    private static int LOCAL_CARS_COUNT;
    private CyclicBarrier barrier;
    private CountDownLatch latch;

    static{
        LOCAL_CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private static AtomicBoolean bool = new AtomicBoolean(false);

    public String getName(){
        return name;
    }

    public int getSpeed(){
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier barrier, CountDownLatch latch){
        this.race = race;
        this.speed = speed;
        LOCAL_CARS_COUNT++;
        this.name = "Участник #" + LOCAL_CARS_COUNT;
        this.barrier = barrier;
        this.latch = latch;
    }

    @Override
    public void run(){
        try{
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)Math.random() * 800);
            System.out.println(this.name + " готов");
            barrier.await();
        } catch(Exception e){
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        latch.countDown();

        if (!bool.getAndSet(true)) {
            System.out.println(name + " победил!");
        }
    }
}

abstract class Stage{
    protected int length;
    protected String description;

    public String getDescription(){
        return description;
    }

    public abstract void go(Car c);
}

class Road extends Stage{

    public Road(int length){
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try{
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}

class Tunnel extends Stage{

    private Semaphore semaphore = new Semaphore(CARS_COUNT / 2);

    public Tunnel(int length){
        this.length = length;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try{
            try{
                System.out.println(c.getName() + " готовится к этапу (ждёт): " + description);
                semaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
                semaphore.release();
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally{
                System.out.println(c.getName() + " закончил этап: " + description);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Race{

    private ArrayList<Stage> stages;

    public ArrayList<Stage> getStages(){
        return  stages;
    }

    public Race(Stage ... stages){
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}