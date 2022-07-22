package co.in.lld.netflix.models;

import co.in.lld.netflix.models.enums.ProfileTypeEnum;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity (name ="profile")
public class Profile extends  BaseModel{
    private String name;
    private ProfileTypeEnum profileTypeEnum;

    @ManyToOne
    private Users users;

    @OneToMany (mappedBy =  "profile")
    private List<VideoProfile> videoProfileList;
}
