package com.weijiekeji.cube.Restful;

import com.weijiekeji.kociemba.twophase.CoordCube;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * emil:410758717@qq.com
 * Created by togger on 2021/4/29.
 */

@SpringBootApplication
//独立扩展基类方法使用

public class CubeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CubeApplication.class,args);
        new CoordCube();//初始化话魔方类静态变量
    }
}
