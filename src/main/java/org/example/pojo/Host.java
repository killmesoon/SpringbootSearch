package org.example.pojo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@Indexed
public class Host {
    @Id
    private String hostId;
    @Field
    private String ip;
    @Field
    private String name;
}
