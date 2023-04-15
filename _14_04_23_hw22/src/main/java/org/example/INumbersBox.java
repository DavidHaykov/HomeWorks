package org.example;

public interface INumbersBox {
    void addNumber(int number);
    void removeNumber(int number);
    boolean containsNumber(int number);
    void removeRepeated();
    void removeDividedBy(int number);
    int size();
    void removeInRange(int fromInclusive, int toExclusive);
}


/*Реализаций этого интерфейса будет 4, и в основе каждой будет лежать сооветствующая коллекция.

1. NumberBoxArrayList
2. NumberBoxLinkedList
3. NumberBoxHashSet
4. NumberBoxTreeSet

Ваша задача не только реализовать эти методы для 4 коллекций,
 но и правильно построить архитектуру аппликации, чтобы одинаковый код не повторялся,
 т.е. создать промежуточные абстрактные классы, которые будут содержать повторяющийся код.
 */