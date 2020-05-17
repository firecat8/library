package com.library.domain;

/**
 *
 * @author gdimitrova
 */
public abstract class NamedEntity extends Entity{
    
    private String name;

    public NamedEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
