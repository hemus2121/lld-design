package co.in.lld.netflix.models;

import co.in.lld.netflix.models.enums.VideoStatusEnum;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity(name = "video_profile")
public class VideoProfile  extends BaseModel{

    private Date lastPausedAt;
    private VideoStatusEnum videoStatus;

    @ManyToOne
    private Profile profile;

    @ManyToOne
    private Video video;


}
