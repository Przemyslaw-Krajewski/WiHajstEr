package com.przemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "item", schema = "przemo")
public class Item
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="itemgenerator")
    @SequenceGenerator(name = "itemgenerator",schema = "przemo", sequenceName = "itemseq", allocationSize = 1)
    Long id;

    String name;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
