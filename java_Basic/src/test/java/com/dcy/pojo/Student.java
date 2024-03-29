package com.dcy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Cloneable{
    private Integer id;
    private Integer classId;
    private String name;
    private Integer age;

    public Object clone() {
        try {
            Student student = (Student) super.clone();
            return student;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
}
