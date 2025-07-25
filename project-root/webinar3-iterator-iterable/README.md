## Вебинар_3_Iterable_Iterator ##

Iterable – это интерфейс, который позволяет объектам быть перебираемыми (итерируемыми), то есть,  
по ним можно последовательно перемещаться и получать элементы.   
Интерфейс Iterable определяет единственный метод iterator(), который возвращает объект типа Iterator.   
Iterator же предоставляет методы для навигации по коллекции и получения элементов.   

Одним из ключевых методов интерфейса Collection является метод Iterator<E> iterator().   
Он возвращает итератор - то есть объект, реализующий интерфейс Iterator.  

Интерфейс Iterator имеет следующее определение:   
```Java
public interface Iterator <E>{
     
    E next();
    boolean hasNext();
    void remove();
}
```
Реализация интерфейса предполагает, что с помощью вызова метода next() можно получить следующий элемент.   
С помощью метода hasNext() можно узнать, есть ли следующий элемент, и не достигнут ли конец коллекции.   
И если элементы еще имеются, то hasNext() вернет значение true. Метод hasNext() следует вызывать перед методом next(),
так как при достижении конца коллекции метод next() выбрасывает исключение NoSuchElementException.   
Метод remove() удаляет текущий элемент, который был получен последним вызовом next().   

Используем итератор для перебора коллекции ArrayList:

```Java
import java.util.*;

public class Program {

    public static void main(String[] args) {

        ArrayList<String> states = new ArrayList<String>();
        states.add("Germany");
        states.add("France");
        states.add("Italy");
        states.add("Spain");

        Iterator<String> iter = states.iterator();
        while(iter.hasNext()){

            System.out.println(iter.next());
        }
    }
}
```
Интерфейс Iterator предоставляет ограниченный функционал. Гораздо больший набор методов предоставляет другой итератор - интерфейс ListIterator.  
Данный итератор используется классами, реализующими интерфейс List, то есть классами LinkedList, ArrayList и др.  

Интерфейс ListIterator расширяет интерфейс Iterator и определяет ряд дополнительных методов:
   * void add(E obj): вставляет объект obj перед элементом, который должен быть возвращен следующим вызовом next()
   * boolean hasNext(): возвращает true, если в коллекции имеется следующий элемент, иначе возвращает false
   * boolean hasPrevious(): возвращает true, если в коллекции имеется предыдущий элемент, иначе возвращает false
   * E next(): возвращает текущий элемент и переходит к следующему, если такого нет, то генерируется исключение NoSuchElementException
   * E previous(): возвращает текущий элемент и переходит к предыдущему, если такого нет, то генерируется исключение NoSuchElementException
   * int nextIndex(): возвращает индекс следующего элемента. Если такого нет, то возвращается размер списка
   * int previousIndex(): возвращает индекс предыдущего элемента. Если такого нет, то возвращается число -1
   * void remove(): удаляет текущий элемент из списка. Таким образом, этот метод должен быть вызван после методов next() или previous(),  
 иначе будет сгенерировано исключение IlligalStateException
   * void set(E obj): присваивает текущему элементу, выбранному вызовом методов next() или previous(), ссылку на объект obj

Используем ListIterator:

```Java
import java.util.*;

public class Program {

    public static void main(String[] args) {

        ArrayList<String> states = new ArrayList<String>();
        states.add("Germany");
        states.add("France");
        states.add("Italy");
        states.add("Spain");

        ListIterator<String> listIter = states.listIterator();

        while(listIter.hasNext()){

            System.out.println(listIter.next());
        }
        // сейчас текущий элемент - Испания
        // изменим значение этого элемента
        listIter.set("Португалия");
        // пройдемся по элементам в обратном порядке
        while(listIter.hasPrevious()){

            System.out.println(listIter.previous());
        }
    }
}
```