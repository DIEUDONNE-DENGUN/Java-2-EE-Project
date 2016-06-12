package com.ulibrary.relationships;

import com.ulibrary.relationships.Author;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-06-02T22:40:20")
@StaticMetamodel(Book2.class)
public class Book2_ { 

    public static volatile SetAttribute<Book2, Author> authors;
    public static volatile SingularAttribute<Book2, String> name;
    public static volatile SingularAttribute<Book2, Integer> bookId;

}