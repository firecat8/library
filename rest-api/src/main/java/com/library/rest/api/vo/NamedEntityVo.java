package com.library.rest.api.vo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author gdimitrova
 */
public class NamedEntityVo extends AbstractVo {

    private String name;

    public NamedEntityVo() {
    }

    public NamedEntityVo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NamedEntityVo other = (NamedEntityVo) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public Set<String> validate() {
        Set<String> errors = new HashSet<>();
        if (name == null) {
            errors.add("Name is null.");
            return errors;
        }
        if (name.isEmpty()) {
            errors.add("Empty name.");
        }
        return errors;
    }

}
