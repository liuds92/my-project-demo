package com.liuds.demo.test.lombok;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author liuds
 * @date 2019-09-29 10:28
 */
public class RequiredArgsConstructorTest {

    @Setter
    @Getter
    @ToString
    @Accessors(chain = true)
    @RequiredArgsConstructor(staticName = "of")
    static class User{

        @NonNull
        private Integer id;

        @NonNull
        private String name;

        private String sex;
    }

    public static void main(String[] args) {
        User user = User.of(1, "liuds");
        System.out.println(user);
    }
}
