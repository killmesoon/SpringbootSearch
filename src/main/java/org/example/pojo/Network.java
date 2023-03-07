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
public class Network {
    @Id
    private String networkId;

    @Field
    private String name;

    @Field
    private String ip;

    @Field
    private String gateway;
}
