package com.weijiekeji.cube.Restful.controller;

import com.weijiekeji.kociemba.twophase.SearchThreadSafe;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

@RestController
public class CubeController {
  @Data
  static class CubeRequest{
    private String cubeStr;
  }
  @GetMapping("/kociemba/get/solve/{cubeStr}")
  @ApiOperation(value = "解密魔方get", notes = "通过输入魔方序列返回解密序列")
  public JsonResult CubeStrSearchThreadSafe(@PathVariable String cubeStr) {

    Long starttime = System.currentTimeMillis();
    String cstr = new SearchThreadSafe().solution(cubeStr.toUpperCase() ,22, 5, false);
    System.out.println(Thread.currentThread().getName()+" solution "+SearchThreadSafe.total+"=>" + (System.currentTimeMillis() - starttime));
    return new JsonResult<String>(cstr);
  }

  @PostMapping("/kociemba/post/json/solve")
  @ApiOperation(value = "解密魔方postjson", notes = "通过输入魔方序列返回解密序列 json结构")
  public JsonResult CubeStrSearchThreadSafePostPostJson(@RequestBody CubeRequest body) {
    String cubeStr = body.getCubeStr();
    Long starttime = System.currentTimeMillis();
    System.out.println("cubeStr=>" + cubeStr);
    String cstr = new SearchThreadSafe().solution(cubeStr.toUpperCase() ,22, 5, false);
    System.out.println(Thread.currentThread().getName()+" solution "+SearchThreadSafe.total+"=>" + (System.currentTimeMillis() - starttime));
    return new JsonResult<String>(cstr);
  }

  @PostMapping("/kociemba//post/form/solve")
  @ApiOperation(value = "解密魔方postform", notes = "通过输入魔方序列返回解密序列")
  public JsonResult CubeStrSearchThreadSafePost(@RequestParam String cubeStr) {
    Long starttime = System.currentTimeMillis();
    System.out.println("cubeStr=>" + cubeStr);
    String cstr = new SearchThreadSafe().solution(cubeStr.toUpperCase() ,22, 5, false);
    System.out.println(Thread.currentThread().getName()+" solution "+SearchThreadSafe.total+"=>" + (System.currentTimeMillis() - starttime));
    return new JsonResult<String>(cstr);
  }
}
