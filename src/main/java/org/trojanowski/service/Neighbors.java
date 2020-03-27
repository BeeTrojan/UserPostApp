package org.trojanowski.service;

public class Neighbors {
    Long id;
    Long idNeighbor;


    Neighbors(Long id, Long idNeighbor){
        this.id=id;
        this.idNeighbor=idNeighbor;
    }

    boolean checkKey(Long id){

        return this.id.equals(id) || this.idNeighbor.equals(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Neighbors that = (Neighbors) o;


        return (((id.equals(that.id)) && (idNeighbor.equals(that.idNeighbor)))||(((idNeighbor.equals(that.id)) && (id.equals(that.idNeighbor)))));
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = result + idNeighbor.hashCode();
        return result;
    }
}