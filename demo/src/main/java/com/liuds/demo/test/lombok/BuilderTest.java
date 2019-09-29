package com.liuds.demo.test.lombok;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author liuds
 * @date 2019-09-29 10:28
 */
public class BuilderTest {

    @Setter
    @Getter
    @ToString
    @Builder
    static class User{
        private Integer id;

        private String name;

        private String sex;
    }

    public static void main(String[] args) {
        User user = User.builder().id(1).name("liuds").sex("男").build();
        System.out.println(user);
    }
}
