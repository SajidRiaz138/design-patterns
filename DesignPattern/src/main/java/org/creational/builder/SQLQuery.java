package org.creational.builder;

public class SQLQuery
{
    private final String select;
    private final String from;
    private final String where;
    private final String groupBy;
    private final String having;
    private final String orderBy;

    private SQLQuery(Builder builder)
    {
        this.select = builder.select;
        this.from = builder.from;
        this.where = builder.where;
        this.groupBy = builder.groupBy;
        this.having = builder.having;
        this.orderBy = builder.orderBy;
    }

    @Override
    public String toString()
    {
        return "SELECT " + select + " FROM " + from +
                (where != null ? " WHERE " + where : "") +
                (groupBy != null ? " GROUP BY " + groupBy : "") +
                (having != null ? " HAVING " + having : "") +
                (orderBy != null ? " ORDER BY " + orderBy : "");
    }

    public static class Builder
    {
        private String select;
        private String from;
        private String where;
        private String groupBy;
        private String having;
        private String orderBy;

        public Builder select(String fields)
        {
            this.select = fields;
            return this;
        }

        public Builder from(String table)
        {
            this.from = table;
            return this;
        }

        public Builder where(String conditions)
        {
            this.where = conditions;
            return this;
        }

        public Builder groupBy(String fields)
        {
            this.groupBy = fields;
            return this;
        }

        public Builder having(String conditions)
        {
            this.having = conditions;
            return this;
        }

        public Builder orderBy(String fields)
        {
            this.orderBy = fields;
            return this;
        }

        public SQLQuery build()
        {
            return new SQLQuery(this);
        }
    }
}
