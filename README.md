# Gameloft

For the database you have to setup your own. I chose a PostgreSQL database, but as the service uses Hibernate & JPA you can use any database you want as long as you import the dependencies and setup your database

The code seems fine, but I encountered a problem. The relations are mapped in the database using JPA, but for some reason at @ManyToMany it doesn't take the data from join (you can see the query being correct when using the #spring.jpa.show-sql=true, but for some reason it doesn't take the data and I didn't find the problem yet.
