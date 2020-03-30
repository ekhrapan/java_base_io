package academy.belhard;

import academy.belhard.entity.Person;
import academy.belhard.io.DataReader;
import academy.belhard.io.DataWriter;
import academy.belhard.io.IOConstants;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        writeObjectsToFile();

        readObjectsToFile();
    }

    public static void writeObjectsToFile() {
        /**
         * Создание и инициализация объектов
         */
        Person person1 = new Person("Harry", "Potter", "harry.potter@mail.com", 17);
        Person person2 = new Person("Hermione", "Granger ", "hermione.granger@mail.com", 17);
        Person person3 = new Person("Ronald", "Ronald", "ronald.weasley@mail.com", 17);

        /**
         * Создаем коллекцию на основе созданных объектов
         * Внимание конструкция List.of(...) создает неизменяемую коллекцию
         * (вы не сможете добавлять и удалять объекты из коллекции)
         */
        List<Person> persons = List.of(person1, person2, person3);

        /**
         * Инициализация объекта инкапсулирующего логикузаписи в файл
         */
        DataWriter dataWriter = new DataWriter(IOConstants.FILENAME);
        try {
            /**
             * Вызов метода записывающего данные в файл
             */
            dataWriter.writeToFile(persons);
            System.out.println("Объекты записаны в файл");
        } catch (IOException e) {
            /**
             * Обработка ошибки ввода/вывода
             */
            e.printStackTrace();
        }
    }

    public static void readObjectsToFile() {
        DataReader dataReader = new DataReader(IOConstants.FILENAME);
        try {
            /**
             * Чтение (парсинг) объектов из файла
             */
            List<Person> personsFromFile = dataReader.readFromFile();

            /**
             * Вывод коллекции объектов на экран
             */
            System.out.println(personsFromFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
