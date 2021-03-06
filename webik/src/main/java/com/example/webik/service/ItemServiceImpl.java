package com.example.webik.service;

import com.example.webik.models.Item;
import com.example.webik.repository.BasketRepo;
import com.example.webik.repository.ItemHibernateRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class ItemServiceImpl implements ItemService{
    private final ItemHibernateRepo itemRepository;
    private final BasketRepo basketRepository;
    private final SessionFactory sessionFactory;

    public ItemServiceImpl(ItemHibernateRepo itemRepository,
                           BasketRepo basketRepository, SessionFactory sessionFactory) {
        this.itemRepository = itemRepository;
        this.basketRepository = basketRepository;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Item create(Item item) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        itemRepository.insert(item);
        basketRepository.getBasket(null);

        transaction.commit();
        session.close();
        return item;
    }

    @Override
    public Item update(Item item) {
        return itemRepository.update(item);
    }

    @Override
    public boolean delete(Long id) {
        return itemRepository.deleteById(id);
    }

    @Override
    public Optional<Item> getItem(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public List<? extends Item> getAll() {
        return itemRepository.getAllItems();
    }
}
