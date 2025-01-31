public class Hash_Table {
    private Integer[] table; // Массив хеш-таблицы
    private int capacity; // Общая емкость хеш-таблицы
    private int size; // Текущее количество элементов в хеш-таблице


    // Конструктор хеш-таблицы
    public Hash_Table(int capacity) {
        this.capacity = capacity;
        this.table = new Integer[capacity];
        this.size = 0;
    }
    // Хэш-функция
    private int hash(int key) {
        return key % capacity;
    }
    // Вставка элемента в хеш-таблицу
    public void insert(int key) {
        if (size >= capacity / 2) {
            resize();
        }
        int index = hash(key);
        while (table[index] != null) {
            index = (index + 1) % capacity; // Линейное пробирование
        }
        table[index] = key;
        size++;
    }
    // Поиск элемента в хеш-таблице
    public boolean search(int key) {
        int index = hash(key);
        while (table[index] != null) {
            if (table[index].equals(key)) {
                return true;
            }
            index = (index + 1) % capacity; // Линейное пробирование
        }
        return false;
    }
    // Удаление элемента из хеш-таблицы
    public void delete(int key) {
        int index = hash(key);
        while (table[index] != null) {
            if (table[index].equals(key)) {
                table[index] = null;
                size--;
                return;
            }
            index = (index + 1) % capacity; // Линейное пробирование
        }
    }
    // Увеличение размера хеш-таблицы
    private void resize() {
        int newCapacity = capacity * 2;
        Integer[] newTable = new Integer[newCapacity];
        // Перехеширование существующих элементов
        for (Integer key : table) {
            if (key != null) {
                int index = key % newCapacity;
                while (newTable[index] != null) {
                    index = (index + 1) % newCapacity;
                }
                newTable[index] = key;
            }
        }
        table = newTable;
        capacity = newCapacity;
    }
    // Текущий размер хеш-таблицы
    public int size() {
        return size;
    }
    // Проверка, пуста ли хеш-таблица
    public boolean isEmpty() {
        return size == 0;
    }
    // Вывод текущего состояния хеш-таблицы
    public void printTable() {
        System.out.println("ИндексvЗначение");
        for (int i = 0; i < capacity; i++) {
            System.out.print(i + "v");
            if (table[i] != null) {
                System.out.println(table[i]);
            } else {
                System.out.println("null");
            }
        }
    }

    public static void main(String[] args) {
        Hash_Table hashTable = new Hash_Table(10);
        hashTable.insert(5);
        hashTable.insert(10);
        hashTable.insert(15);
        hashTable.insert(50);
        System.out.println("Состояние хеш-таблицы после вставки: \n");
        hashTable.printTable();
        System.out.println("Поиск 15: " + hashTable.search(15) + "\n"); // true
        System.out.println("Поиск 50: " + hashTable.search(50) + "\n"); // false
        hashTable.delete(15);
        System.out.println("Состояние хеш-таблицы после удаления 15:" + "\n");
        hashTable.printTable();
        System.out.println("Поиск 15 после удаления: " + hashTable.search(15) + "\n"); // false
    }
}
