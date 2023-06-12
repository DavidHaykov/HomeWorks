package telran.library.entities;


import org.junit.jupiter.api.Test;


public enum BooksReturnCode {
    OK, BOOK_ITEM_EXISTS, PICK_PERIOD_GREATER_MAX, PICK_PERIOD_LESS_MIN, READER_EXISTS, BOOK_IN_USE, NO_READER, NO_BOOK_ITEM
}
