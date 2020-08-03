package mydb;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


public class Service{
	
    private int id;
	private String name;
    private Set<Customer> customers = new HashSet<Customer>();
     
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
     
    public void setName(String name) {
        this.name = name;
    }
     
    @ManyToMany(mappedBy = "service")
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
     
    public String toString()
    {
        return "Service£º"+this.name +",Id£º"+this.id;
    }
}
