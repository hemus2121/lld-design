package co.in.lld.netflix.models;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name= "users")
public class Users  extends  BaseModel{

    private String email;
    private String password;

    @OneToMany (mappedBy = "users")
    private List<Profile> profileList;
}
