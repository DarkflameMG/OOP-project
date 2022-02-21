package com.carin.interfaces;

public interface AntiBodyUnit extends Unit{
    /**
     * transform this Antibody to virus
     */
    void transform();

    /**
     * this Antibody recovery hp
     * effect : hp increase
     */
    void recovery();
}
