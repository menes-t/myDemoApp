package com.mycompany.app;

import static spark.Spark.*;

import java.util.*;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

/**
 * Hello world!
 *
 */
public class App 
{
        public static int summary(ArrayList<Integer> arr,int i1,int i2){

                //the array must be assigned
                if(arr == null){
                        return 0;
                }

                /*
                   int f,s;
                //whether index values are really integers,
                try{
                f = Integer.parseInt(i1);
                s = Integer.parseInt(i2);
                }catch(Exception e){
                return 0;
                }
                 */

                //the array must contain at least two integers
                if(arr.size() == 0 || arr.size() == 1){
                        return 0;
                }

                //the integers must be positive and smaller than the size of array
                if(i1 < 0 || i2 < 0 || i1 >= arr.size() || i2 >= arr.size()){
                        return 0;
                }

                return arr.get(i1)+arr.get(i2);

                /*
                   int first,second;
                //whether the value of integers are really integers,
                try{
                first = Integer.parseInt(arr[f]);
                second = Integer.parseInt(arr[s]);
                }catch(Exception e){
                return 0;
                }
                 */

                //return first+second;
        }
        public static void main(String[] args) {
                port(getHerokuAssignedPort());

                get("/", (req, res) -> "Hello, World");

                post("/compute", (req, res) -> {
                                //System.out.println(req.queryParams("input1"));
                                //System.out.println(req.queryParams("input2"));

                                String input1 = req.queryParams("input1");
                                java.util.Scanner sc1 = new java.util.Scanner(input1);
                                sc1.useDelimiter("[;\r\n]+");
                                java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
                                while (sc1.hasNext())
                                {
                                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                                inputList.add(value);
                                }
                                System.out.println(inputList);


                                String input2 = req.queryParams("input2").replaceAll("\\s","");
                                int input2AsInt = Integer.parseInt(input2);
                                
                                String input3 = req.queryParams("input3").replaceAll("\\s","");
                                int input3AsInt = Integer.parseInt(input3);
                     

                                int result = App.summary(inputList, input2AsInt, input3AsInt);

                                Map map = new HashMap();
                                map.put("result", result);
                                return new ModelAndView(map, "compute.mustache");
                }, new MustacheTemplateEngine());


                get("/compute",
                                (rq, rs) -> {
                                Map map = new HashMap();
                                map.put("result", "not computed yet!");
                                return new ModelAndView(map, "compute.mustache");
                                },
                                new MustacheTemplateEngine());
        }

        static int getHerokuAssignedPort() {
                ProcessBuilder processBuilder = new ProcessBuilder();
                if (processBuilder.environment().get("PORT") != null) {
                        return Integer.parseInt(processBuilder.environment().get("PORT"));
                }
                return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
        }


}
