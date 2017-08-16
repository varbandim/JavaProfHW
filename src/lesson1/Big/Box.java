package lesson1.Big;

import java.util.ArrayList;

/*
        Большая задача:
        1. Есть классы Fruit -> Apple, Orange; (больше фруктов не надо). ++выполнено

        2. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
        поэтому в одну коробку нельзя сложить и яблоки, и апельсины;  ++выполнено

        3. Для хранения фруктов внутри коробки можете использовать ArrayList; ++выполнено

        4. Сделать метод getWeight() который высчитывает вес коробки,
        зная кол-во фруктов и вес одного фрукта
        (вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах
        (Вес фруктов определяется внутри класса фрукта)); ++выполнено

        5. Внутри класса коробка сделать метод compare, который позволяет сравнить
        текущую коробку с той, которую подадут в compare в качестве параметра,
        true - если их веса равны, false в противной случае(коробки с
        яблоками мы можем сравнивать с коробками с апельсинами); ++выполнено

        6. Написать метод, который позволяет пересыпать фрукты из текущей коробки
        в другую коробку (помним про сортировку фруктов, нельзя яблоки высыпать
        в коробку с апельсинами), соответственно в текущей коробке фруктов не остается,
        а в другую перекидываются объекты, которые были в этой коробке;

        7. Ну и не забываем про метод добавления фрукта в коробку; ++выполнено
        8. В коробке, в листе с фруктами должны храниться именно отдельные экземпляры
        объектов фруктов  ++выполнено
        */
//2
public class Box<T extends Fruit> {

    private ArrayList<T> list = new ArrayList<>();//3

    public Box(ArrayList<T> list) {
        this.list = list;
    }
    //7
    public void addFruitIntoBox(T t) {
        list.add(t);//8
    }
    //4
    public float getWeightBox(){
        float numberOfFruitsInBox = 0;
        for (int i = 0; i < list.size(); i++) {
            numberOfFruitsInBox++;
        }
        return list.size() * numberOfFruitsInBox;
    }

    //5
    boolean compareTwoBoxes(Box box) {
        if (this.getWeightBox() == box.getWeightBox()) return true;
        else return false;
    }


    public void exchangeBox(Box box){
        if (list.getClass().equals(box.list.getClass())) {
            for (int i = 0; i < box.list.size(); i++) {
                list.add((T) box.list.get(i));
            }
        }else System.out.println("В коробку можно класть только одинаковые фрукты");
    }
}
