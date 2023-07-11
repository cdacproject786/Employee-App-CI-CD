package com.cockroachdb.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmployee is a Querydsl query type for Employee
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEmployee extends EntityPathBase<Employee> {

    private static final long serialVersionUID = -1188527951L;

    public static final QEmployee employee = new QEmployee("employee");

    public final StringPath department = createString("department");

    public final StringPath email = createString("email");

    public final NumberPath<Long> empId = createNumber("empId", Long.class);

    public final StringPath fname = createString("fname");

    public final StringPath lname = createString("lname");

    public final StringPath phone = createString("phone");

    public final NumberPath<Integer> salary = createNumber("salary", Integer.class);

    public QEmployee(String variable) {
        super(Employee.class, forVariable(variable));
    }

    public QEmployee(Path<? extends Employee> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmployee(PathMetadata metadata) {
        super(Employee.class, metadata);
    }

}

