package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.HotelBean;
import com.hotel.RoomBean;
import com.hotel.admin.AdminDao;
import com.hotel.manager.ManagerDao;



@RestController
@RequestMapping(value = "/roomdetails")
public class ManagerController {
                ManagerDao md=new ManagerDao();
                @RequestMapping(value = "/insert", method = RequestMethod.PUT)
                public int   roomdetails(@RequestBody RoomBean rb) throws SQLException 
                {
                                System.out.println("inserting");
                                int d=0;
                               md.insertRoom(rb);
                                return d;
                
                }
                
             
              /*  @RequestMapping(value = "/all" , method = RequestMethod.GET )

                public List<HotelBean> viewHotelDetail() {

             AdminDao adminDao=new AdminDao();

                      ArrayList list = adminDao.viewHotelDetails();

              return list;

            }*/


                }


