package org.creational.builder;

public class Client
{
    public static void main(String[] args)
    {
        QueryDirector director = new QueryDirector();

        SQLQuery simpleQuery = director.constructSimpleQuery();
        System.out.println("Simple Query: " + simpleQuery);

        SQLQuery complexQuery = director.constructComplexQuery();
        System.out.println("Complex Query: " + complexQuery);
    }
}
