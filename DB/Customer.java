package mydb;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


public class Customer{
	
    private int id;
    private String name;
    private Set<Service> services = new HashSet<Service>();

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
    
    @ManyToMany
    @JoinTable(name = "service_customer", joinColumns = { @JoinColumn(name = "customer_id") }, inverseJoinColumns = {
            @JoinColumn(name = "service_id") })
    public Set<Service> getAllServices() {
        return services;
    }

    public void setAllServices(Set<Service> services) {
        this.services = services;
    }
    
    public void setService(Service s) {
    	this.services.add(s);
    }
    
    public void removeService(Service s) {
    	for(Service ss : this.allService) {
    		if(ss.getId() == s.getId) {
    			this.allService.remove(ss);
    			return;
    		}
    	}
    }
    
    public void modifyService(Service oldService, Service newService) {
    	for(Service ss : this.allService) {
    		if(ss.getId() == oldService.getId()) {
    			this.services.remove(ss);
    			this.allService.add(newService);
    		}
    	}
    }
    
    public String toString()
    {
        return "Customer£º" + this.id + ", name£º"+this.name;
    }
}
