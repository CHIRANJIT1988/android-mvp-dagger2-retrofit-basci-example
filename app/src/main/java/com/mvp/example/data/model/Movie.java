package com.mvp.example.data.model;


public class Movie
{
    private String name;
    private String realname;
    private String team;
    private String firstappearance;
    private String createdby;
    private String publisher;
    private String imageurl;


    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getRealName()
    {
        return this.realname;
    }

    public void setRealname(String realname)
    {
        this.realname = realname;
    }

    public String getTeam()
    {
        return this.team;
    }

    public void setTeam(String team)
    {
        this.team = team;
    }

    public String getFirstAppearance()
    {
        return this.firstappearance;
    }

    public void setFirstAppearance(String firstappearance)
    {
        this.firstappearance = firstappearance;
    }

    public String getCreatedBy()
    {
        return this.createdby;
    }

    public void setCreatedBy(String createdby)
    {
        this.createdby = createdby;
    }

    public String getPublisher()
    {
        return this.publisher;
    }

    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    public String getImageUrl()
    {
        return this.imageurl;
    }

    public void setImageUrl(String imageurl)
    {
        this.imageurl = imageurl;
    }
}