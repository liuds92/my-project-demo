package com.liuds.demo.test.lombok;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author liuds
 * @date 2019-09-29 10:28
 */

public class AccessorsTest {

    @Setter
    @Getter
    @ToString
    @Accessors(chain = true)
    static class User {

        private Integer id;

        private String name;

        private String sex;
    }

    public static void main(String[] args) {
        User user = new User().setId(1).setName("liuds").setSex("男");
        System.out.println(user);
    }
}
