package hu.progmatic.orders.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_records")
public class OrderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String store;

    @Column(nullable = false, length = 255)
    private String item;

    @Column(nullable = false)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;


    public Long getId() {
        return id;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public OrderRecord(String store, String item, int price, Person person) {
        this.store = store;
        this.item = item;
        this.price = price;
        this.person = person;
    }

    @Override
    public String toString() {
        return "OrderRecord{" +
                "id=" + id +
                ", store='" + store + '\'' +
                ", item='" + item + '\'' +
                ", price=" + price +
                '}';
    }

    public OrderRecord() {

    }

}




