package ru.netology.repository;


import lombok.SneakyThrows;
import ru.netology.Exceptions.NotFoundException;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.manager.ProductManager;

public class ProductRepository {
    ProductManager manager = new ProductManager();
    private Product[] items = new Product[0];
    Book book = new Book();

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }


    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
    public void removeById ( int id) {
        if (findById(id) == null) {
            throw new NotFoundException("====> Element with id: " + id + " not found <====");
        }
            int length = items.length - 1;
            Product[] tmp = new Product[length];
            int index = 0;
            for (Product item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;

        }
    }
