package org.example.pojo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Indexed
@Table(name = "vm_info")
public class VmInfo {
    @Id
    private String vmId;
    @Field(store = Store.YES)
    private String name;
    @Field
    private String description;
}
