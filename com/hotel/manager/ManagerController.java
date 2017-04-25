package com.hotel.manager;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.HotelBean;
import com.hotel.admin.AdminDao;

@RestController
@RequestMapping(value = "/stocks")
public class ManagerController {
	@RequestMapping(value = "/all" , method = RequestMethod.GET )

    public List<HotelBean> viewHotelDetail() {

  AdminDao adminDao=new AdminDao();

          ArrayList list = adminDao.viewHotelDetails();

          

  return list;

}


	
	/*@RequestMapping(value="/insert",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces={ MediaType.APPLICATION_JSON_VALUE})

    public DoctorBean insertDoctor(@RequestBody DoctorBean dbean)

    {

            DoctorDao ddao=new DoctorDao();

            ddao.insertDetails(dbean);

            return dbean;

    }*/


}
