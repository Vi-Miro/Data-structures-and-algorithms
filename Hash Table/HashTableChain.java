import java.util.LinkedList;
import java.util.Iterator;


public class HashTableChain<K,V> {
    // Внутренний класс для представления узла хеш-таблицы
    private static class HashNode<K, V> {
        K key; // Ключ узла
        V value; // Значение узла

        HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<HashNode<K, V>>[] table; // Массив списков для цепочек
    private int capacity; // Вместимость хеш-таблицы
    private int size; // Текущее количество элементов в хеш-таблице

    // Конструктор хеш-таблицы
    @SuppressWarnings("unchecked")
    public HashTableChain(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>(); // Инициализация каждого элемента массива пустым списком
        }
    }

    // Хеш-функция для вычисления индекса
    private int getHash(K key) {
        return Math.abs(key.hashCode() % capacity); // Возвращаем положительный индекс
    }

    // Метод для вставки новой пары ключ-значение
    public void insert(K key, V value) {
        int index = getHash(key);
        for (HashNode<K, V> node : table[index]) {
            if (node.key.equals(key)) {
                node.value = value; // Обновляем значение, если ключ уже существует
                return;
            }
        }
        table[index].add(new HashNode<>(key, value)); // Добавляем новый узел в цепочку
        size++; // Увеличиваем размер таблицы
    }

    // Метод для поиска значения по ключу
    public V search(K key) {
        int index = getHash(key);
        for (HashNode<K, V> node : table[index]) {
            if (node.key.equals(key)) {
                return node.value; // Возвращаем значение, если ключ найден
            }
        }
        return null; // Если ключ не найден, возвращаем null
    }

    // Метод для удаления элемента по ключу
    public void delete(K key) {
        int index = getHash(key);
        Iterator<HashNode<K, V>> iterator = table[index].iterator();
        while (iterator.hasNext()) {
            HashNode<K, V> node = iterator.next();
            if (node.key.equals(key)) {
                iterator.remove(); // Удаляем узел из списка
                size--; // Уменьшаем размер таблицы
                return;
            }
        }
    }

    // Метод для получения текущего количества элементов в таблице
    public int size() {
        return size;
    }

    // Метод для проверки, пуста ли таблица
    public boolean isEmpty() {
        return size == 0; // Возвращаем true, если размер равен 0
    }

    // Пример использования хеш-таблицы
    public static void main(String[] args) {
        HashTableChain<String, Integer> hashTable = new HashTableChain<>(10);
        hashTable.insert("one", 1);
        hashTable.insert("five", 5);
        hashTable.insert("ten", 7);

        System.out.println("Поиск 'one': " + hashTable.search("one"));
        System.out.println("Поиск 'five': " + hashTable.search("five"));

        System.out.println("Удвление 'one': ");

        hashTable.delete("one");
        System.out.println("Поиск 'one': " + hashTable.search("one"));
        System.out.println("Поиск 'five': " + hashTable.search("five"));
    }

}
