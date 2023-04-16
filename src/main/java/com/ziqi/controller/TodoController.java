package com.ziqi.controller;

import com.ziqi.rest.domain.Thingstodo;
import com.ziqi.util.jsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * Todo interface
 * todo controller
 *
 */
@Controller
public class TodoController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "ok";
    }

    /**
     *  Get all the things
     * 1. Request: confirm resources: /todoList
     * 2. Method:Get
     * 3. Parameter: none
     * 4. Response: list<Todo>, json
     */
    @RequestMapping(value = "/things", method = RequestMethod.GET)
    @ResponseBody
    public List<Thingstodo> list(){

        // Search MySQL
        // Pretend to have searched
        List<Thingstodo> list = Arrays.asList(new Thingstodo(1L,"Breakfast",1), new Thingstodo(2L,"Reading",2));
        return list;
    }

    /**
     * Ambiguous mapping
     * Get all /things: GET
     * Get Certain /thing: GET
     * two mapping and Request method same, SpringMVC thinks it is same interface, how to do?
     * Solution:
     * 1.Use many layers eg. /things/detail
     * 2. Use parameter eg. /things/{id}  -> Make a path as part of the request's parameters
     *
     * Client: http://localhost:8080/thing/1      1 is {id}
     *
     * NOTE: @PathVariable make SpringMVC extract paramaters and to give value
     */

    /**
     *  Get Certain the things
     * 1. Request: confirm resources: /todoList
     * 2. Method:Get
     * 3. Parameter: id
     * 4. Response: certain <thing>, json
     */
    @RequestMapping(value = "/things/{eid}", method = RequestMethod.GET)
    @ResponseBody
    public Thingstodo detail(@PathVariable("eid") Long id){

        return new Thingstodo(id, "Reading",2);
    }






    /**
     *  Add a new todoList
     * 1. Request: confirm resources: /todoList
     * 2. Method: Post
     * 3. Parameter: name,time
     * 4. Response: todoList, json
     */
    @RequestMapping(value = "/things", method = RequestMethod.POST)
    @ResponseBody
    public Thingstodo save(Thingstodo thingstodo){

        //pretended to successful
        thingstodo.setId(1L);
        return thingstodo;
    }

    /**
     *  Update a new todoList
     * 1. Request: confirm resources: /todoList
     * 2. Method: PUT
     * 3. Parameter: name,time
     * 4. Response: changed todoList, json
     */
    @RequestMapping(value = "/things", method = RequestMethod.PUT)
    @ResponseBody
    public Thingstodo update(Thingstodo thingstodo){

        //pretended to successful
        thingstodo.setName(thingstodo.getName()+"_update");
        return thingstodo;
    }

    /**
     *  Delete a exist todoList
     * 1. Request: confirm resources: /todoList
     * 2. Method: DELETE
     * 3. Parameter: id
     * 4. Response: status after delete: jsonResult
     */
    @RequestMapping(value = "/things", method = RequestMethod.DELETE)
    @ResponseBody
    public jsonResult delete(Long id){

        //pretended to delete successful

        return jsonResult.success();
    }

}
