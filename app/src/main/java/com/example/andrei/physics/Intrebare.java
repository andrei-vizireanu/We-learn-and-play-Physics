package com.example.andrei.physics;

/**
 * Created by Andrei on 11/10/2016.
 */

public class Intrebare {
    private String intrebare, raspuns1, raspuns2, raspuns3, raspuns4;
    int corect;
    public Intrebare(String intrebare, String raspuns1, String raspuns2, String raspuns3, String raspuns4,int corect)
    {
        this.intrebare=intrebare;
        this.raspuns1=raspuns1;
        this.raspuns2=raspuns2;
        this.raspuns3=raspuns3;
        this.raspuns4=raspuns4;
        this.corect=corect;
    }
    public void setIntrebare(String intrebare)
    {
        this.intrebare=intrebare;
    }
    public String getIntrebare()
    {
        return intrebare;
    }
    public void setRaspuns1(String raspuns1)
    {
        this.raspuns1=raspuns1;
    }
    public String getRaspuns1()
    {
        return raspuns1;
    }
    public void setRaspuns2(String raspuns2)
    {
        this.raspuns2=raspuns2;
    }
    public String getRaspuns2()
    {
        return raspuns2;
    }
    public void setRaspuns3(String raspuns3)
    {
        this.raspuns3=raspuns3;
    }
    public String getRaspuns3()
    {
        return raspuns3;
    }
    public void setRaspuns4(String raspuns4)
    {
        this.raspuns4=raspuns4;
    }
    public String getRaspuns4()
    {
        return raspuns4;
    }
    public void setCorect(int corect)
    {
        this.corect=corect;
    }
    public int getCorect()
    {
        return corect;
    }
}
