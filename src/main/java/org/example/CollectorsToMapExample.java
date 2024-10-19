package org.example;

import com.example.unit_and_component_test_demo.model.Book;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsToMapExample {
    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("The Fellowship of the Ring", 1955, "0395489318"));
        bookList.add(new Book("The Two Towers", 1955, "0345339711"));
        bookList.add(new Book("The Return of the King", 1954, "0618129111"));

//        System.out.println("listToMap \n" + listToMap(bookList));

//        System.out.println("listToMapSolvingKeyConflicts \n" + listToMapSolvingKeyConflicts(bookList));

//        System.out.println("differentMapTypeReturned \n" + differentMapTypeReturned(bookList));

        System.out.println("sortedMap \n" + sortedMap(bookList));

    }

    static Map<String, Integer> listToMap(List<Book> bookList) {
        return bookList.stream().collect(Collectors.toMap(Book::name, Book::releaseYear));
    }

    static Map<Integer, String> listToMapSolvingKeyConflicts(List<Book> bookList) {
        //Exception in thread "main" java.lang.IllegalStateException: Duplicate key 1954 (attempted merging values The Fellowship of the Ring and The Two Towers)
        //For the below code above exception will be thrown so let's solve it
        //return bookList.stream().collect(Collectors.toMap(Book::releaseYear, Book::name));
        return bookList.stream().collect(Collectors.toMap(Book::releaseYear, Book::name, (firstFound, duplicateOfFirst) -> firstFound));
    }

    static TreeMap<String, Integer> differentMapTypeReturned(List<Book> bookList) {
        //TreeMap is sorted hence sending that
        return bookList.stream().collect(Collectors.toMap(Book::name, Book::releaseYear,
                (firstFound, duplicateOfFirst) -> firstFound, TreeMap::new));
    }

    static TreeMap<Integer, String> sortedMap(List<Book> bookList) {
        return bookList.stream().collect(Collectors.toMap(Book::releaseYear, Book::name,
                (firstFound, duplicateOfFirst) -> firstFound, TreeMap::new));
    }

}
