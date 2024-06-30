package org.creational.builder;

public class QueryDirector
{
    public SQLQuery constructSimpleQuery()
    {
        return new SQLQuery.Builder()
                .select("*")
                .from("employees")
                .build();
    }

    public SQLQuery constructComplexQuery()
    {
        return new SQLQuery.Builder()
                .select("name, salary")
                .from("employees")
                .where("salary > 50000")
                .groupBy("department")
                .having("COUNT(*) > 1")
                .orderBy("salary DESC")
                .build();
    }
}
