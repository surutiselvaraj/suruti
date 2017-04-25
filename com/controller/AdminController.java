package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/admin")
public class AdminController {
	@Autowired
            
	 AdminDao adminDao;
                
             
                	@RequestMapping(value = "/viewhotels" , method = RequestMethod.GET )

                    public List<HotelBean> viewHotelDetail() {

                 

                          ArrayList list = adminDao.viewHotelDetails();

                  return list;

                }
                	


                }


