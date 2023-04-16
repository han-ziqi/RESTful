package com.ziqi.controller;

import com.ziqi.rest.domain.Thingstodo;
import com.ziqi.util.jsonResult;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;


@RestController //@Controller + @ResponseBody
@RequestMapping("things")
public class TodoController {

    @GetMapping
    public List<Thingstodo> list(){

        // Search MySQL
        // Pretend to have searched
        List<Thingstodo> list = Arrays.asList(new Thingstodo(1L,"Breakfast",1), new Thingstodo(2L,"Reading",2));
        return list;
    }

    @GetMapping("/{id}")
    public Thingstodo detail(@PathVariable("id") Long id){

        return new Thingstodo(id, "Reading",2);
    }

    @PostMapping
    public Thingstodo save(Thingstodo thingstodo){

        //pretended to successful
        thingstodo.setId(1L);
        return thingstodo;
    }

    @PutMapping
    public Thingstodo update(Thingstodo thingstodo){

        //pretended to successful
        thingstodo.setName(thingstodo.getName()+"_update");
        return thingstodo;
    }

    @DeleteMapping
    public jsonResult delete(Long id){

        //pretended to delete successful

        return jsonResult.success();
    }

}
