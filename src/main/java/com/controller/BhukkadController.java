package com.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.database.DaoQuery;
import com.tables.Clogin;
import com.tables.Cregister;
import com.tables.Map;
import com.tables.Menu;
import com.tables.Order;
import com.tables.Orderlist;
import com.tables.Otp;
import com.tables.Review;
import com.tables.Rlogin;
import com.tables.Rregister;
import com.tables.Cart;
import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  
 

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
public class BhukkadController {
	
	
	/*Customer register*/
	@RequestMapping("/register.bhukkad")
	public ModelAndView register(@RequestParam("fname") String fname, @RequestParam("sname") String sname, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("phone") BigDecimal phone)
	{
		Cregister user=new Cregister();
		user.setFname(fname);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		user.setSname(sname);
		
		ModelAndView mv= new ModelAndView();
		DaoQuery db=new DaoQuery();
		int i=db.register(user);
		if(i==1)
		{
			String msg="successful";
			mv.addObject("ans",msg);
			mv.setViewName("result.jsp");
		}
		return mv;
				
	}
	
	/* Customer login */
	@RequestMapping("/login.bhukkad")
	public ModelAndView login(HttpServletRequest request,@RequestParam("email") String email, @RequestParam("password") String password)
	{
		System.out.println("hello");
		Cregister user=new Cregister();
		user.setEmail(email);
		Clogin user1=new Clogin();
		user1.setCustomerreg(user);
		System.out.println(user1.getCustomerreg().getEmail());
		user1.setPassword(password);
		List<Clogin> list=new ArrayList();
		DaoQuery db=new DaoQuery();
		list=db.login(user1);
		ModelAndView mv=new ModelAndView();
		String result="Not Successful";
		if(!(list.isEmpty()))
		{
			HttpSession sc=request.getSession(true);
			sc.setAttribute("email", email);
			Cregister cr=new Cregister();
			cr.setEmail(email);
		
			List<Cregister> ll=new ArrayList();
			DaoQuery dq=new DaoQuery();
			ll=dq.getUserDetails(cr);
			for(Cregister fo:ll)
			sc.setAttribute("name", fo.getFname());
			result="successful";
			mv.addObject("result", result);
			mv.setViewName("xyz.jsp");
	
		}
		else
		{
			mv.addObject("result", result);
			mv.setViewName("xyz.jsp");
		
		}
		
		
		return mv;
		
	}
	/*customer logout */
	@RequestMapping("/logout.bhukkad")
	public ModelAndView logout(HttpServletRequest request)
	{
		HttpSession sc=request.getSession();
		String email=((String)sc.getAttribute("email"));
		if(sc.getAttribute("name")!=null)
		{
			DaoQuery dq=new DaoQuery();
			Cart user=new Cart();
			user.setEmail(email);
			int i=dq.deletecart(user);
			
			sc.invalidate();
			
			
			
			
		}
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}
	
	/*restaurant logout */
	@RequestMapping("/reslogout.bhukkad")
	public ModelAndView reslogout(HttpServletRequest request)
	{
		HttpSession sc=request.getSession();
		if(sc.getAttribute("rname")!=null)
		{
			sc.invalidate();
		}
		ModelAndView mv=new ModelAndView();
		mv.setViewName("partners/index1.jsp");
		return mv;
	}
	
	
	/*  Restaurant register */
	@RequestMapping("/resRegister.bhukkad")
	public ModelAndView resRegister(@RequestParam("rname") String rname, @RequestParam("area") String area,@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("phone") BigDecimal phone)
	{
		
		
		String rsid=email;
		Rregister user=new Rregister();
		user.setRname(rname);
		user.setArea(area);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		user.setRsid(rsid);
		String searchname=rname.toUpperCase();
		user.setSearchname(searchname);
		
		DaoQuery dq=new DaoQuery();
		
		int i=dq.resRegister(user);
		ModelAndView mv=new ModelAndView();
		
		if(i==1)
				{
			String msg="successful";
			mv.addObject("ans",msg);
			mv.setViewName("result.jsp");
		}
	
		return mv;
		
	}
	/* restaurant login */
	@RequestMapping("/reslogin.bhukkad")
	public ModelAndView resLogin(HttpServletRequest request,@RequestParam("rsid") String rsid, @RequestParam("password") String password)
	{
		Rregister user=new Rregister();
		user.setRsid(rsid);
		Rlogin user1=new Rlogin();
		user1.setRregister(user);
		user1.setPassword(password);
		DaoQuery dq=new DaoQuery();
		List<Rlogin> list=new ArrayList();
		list=dq.reslogin(user1);
		ModelAndView mv=new ModelAndView();
		if(!(list.isEmpty()))
		{
			
			HttpSession sc=request.getSession(true);
			sc.setAttribute("rsid", rsid);
			Rregister cr=new Rregister();
			cr.setRsid(rsid);
			
		
			List<Rregister> ll=new ArrayList();
			DaoQuery dq1=new DaoQuery();
			ll=dq1.getResDetails(cr);
			Order or=new Order();
			List<Order> list1=new ArrayList();
			or.setRsid(rsid);
			
			list1=dq.getOrders(or);
			for(Order o:list1)
			{
			System.out.println(o.getOid());
			}
			mv.addObject("orderlist", list1);
			
			for(Rregister fo:ll)
			sc.setAttribute("rname", fo.getRname());
			
			mv.setViewName("/partners/home.jsp");
	System.out.println("last");
			
		}
		else
		{
			mv.setViewName("partners/check.jsp");
		}
	
		
		return mv;
	}
	/* Update menu */
	@RequestMapping("/updateMenu")
	public ModelAndView updateMenu(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("partners/updateMenu.jsp");
		return mv;
	}
	/* insert menu */
	@RequestMapping("/insertMenu")
	public ModelAndView insertMenu(HttpServletRequest request, @RequestParam("menu") String menu, @RequestParam("menuitem") String menuitem, @RequestParam("price") long price)
	{
		String menucat=request.getParameter("menucat");
		
		if(menucat!=null)
			menu=menucat;
		Menu mn=new Menu();
		HttpSession sc=request.getSession();
		String rsid=(String) sc.getAttribute("rsid");
		mn.setMenucat(menu);
		mn.setMenuitem(menuitem);
		mn.setPrice(price);
		mn.setRsid(rsid);
		DaoQuery dq=new DaoQuery();
		int i=dq.insertMenu(mn);
		ModelAndView mv=new ModelAndView();
		if(i==1)
		{
			String msg="Menu successfully added";
			mv.addObject("msg",msg);
			mv.setViewName("partners/updateMenu.jsp");
		}
		
		return mv;
	}
	

/* update restaurant details */
@RequestMapping("/updateDetail.bhukkad")
public ModelAndView updateDetail(HttpServletRequest request)
{
ModelAndView mv=new ModelAndView();
Rregister user=new Rregister();
HttpSession sc=request.getSession();
user.setRsid((String)sc.getAttribute("rsid"));
List<Rregister> list=new ArrayList();
DaoQuery dq=new DaoQuery();
list=dq.getResDetails(user);
mv.addObject("list",list);
mv.setViewName("partners/editprofile.jsp");
 return mv;	
}
@RequestMapping("/updateName.bhukkad")
public ModelAndView updateName(HttpServletRequest request,@RequestParam("rname") String rname)
{ 
	HttpSession sc=request.getSession();
	String rsid=((String)sc.getAttribute("rsid"));
	Rregister user=new Rregister();
	user.setRsid(rsid);
	user.setRname(rname);
	DaoQuery dq=new DaoQuery();
	int i=dq.updateName(user);
	ModelAndView mv=new ModelAndView();
	if(i==1)
	{
		sc.setAttribute("rname", rname);
		
		List<Rregister> list=new ArrayList();
		
		list=dq.getResDetails(user);
		mv.addObject("list",list);
		mv.setViewName("partners/editprofile.jsp");
		
	}
	
	return mv;
}
@RequestMapping("/updateaveragecost.bhukkad")
public ModelAndView updateaveragecost(HttpServletRequest request, @RequestParam("averagecost") String averagecost)
{
	ModelAndView mv=new ModelAndView();
	HttpSession sc= request.getSession();
	String rsid=((String)sc.getAttribute("rsid"));
	Rregister user=new Rregister();
	user.setRsid(rsid);
	user.setAveragecost(averagecost);
	DaoQuery dq= new DaoQuery();
	
	int i=dq.updateaveragecost(user);
	if(i>0)
	{
		List<Rregister> list=new ArrayList();
		list=dq.getResDetails(user);
		mv.addObject("list",list);
		mv.setViewName("partners/editprofile.jsp");
	}
	
	
	
	return mv;
}
@RequestMapping("/updateArea")
public ModelAndView updateArea(HttpServletRequest request, @RequestParam("area") String area)
{
	HttpSession sc=request.getSession();
	String rsid=((String)sc.getAttribute("rsid"));
	Rregister user=new Rregister();
	user.setRsid(rsid);
	user.setArea(area);
	DaoQuery dq=new DaoQuery();
	int i=dq.updateArea(user);
	ModelAndView mv=new ModelAndView();
	if(i==1)
	{
		
		List<Rregister> list=new ArrayList();
		list=dq.getResDetails(user);
		mv.addObject("list",list);
		mv.setViewName("partners/editprofile.jsp");
		
	}
	
	return mv;
	
	
}
@RequestMapping("/updatePassword.bhukkad")
public ModelAndView updatePassword(HttpServletRequest request, @RequestParam("password") String password)
{
	HttpSession sc=request.getSession();
	String rsid=((String)sc.getAttribute("rsid"));
	Rregister user=new Rregister();
	user.setRsid(rsid);
	user.setPassword(password);
	DaoQuery dq=new DaoQuery();
	int i=dq.updatePassword(user);
	ModelAndView mv=new ModelAndView();
	if(i==1)
	{
		Rlogin user1=new Rlogin();
		user1.setRregister(user);
		user1.setPassword(password);
		int j=dq.changeLoginPassword(user1);
		if(j==1)
		{
		List<Rregister> list=new ArrayList();
		list=dq.getResDetails(user);
		mv.addObject("list",list);
		mv.setViewName("partners/editprofile.jsp");
		}
		
	}
	
	return mv;
	
	
}
@RequestMapping("/updatePhone.bhukkad")
public ModelAndView updatePassword(HttpServletRequest request, @RequestParam("phone") BigDecimal phone)
{
	HttpSession sc=request.getSession();
	String rsid=((String)sc.getAttribute("rsid"));
	Rregister user=new Rregister();
	user.setRsid(rsid);
	user.setPhone(phone);
	DaoQuery dq=new DaoQuery();
	int i=dq.updatePhone(user);
	ModelAndView mv=new ModelAndView();
	if(i==1)
	{
		
		List<Rregister> list=new ArrayList();
		list=dq.getResDetails(user);
		mv.addObject("list",list);
		mv.setViewName("partners/editprofile.jsp");
		
	}
	
	return mv;
}
@RequestMapping("/updateLocation.bhukkad")
public ModelAndView updateLocation(HttpServletRequest request, @RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude)
{
	HttpSession sc=request.getSession();
	String rsid=((String)sc.getAttribute("rsid"));
	Rregister user=new Rregister();
	user.setRsid(rsid);
	System.out.println("rsid");
	System.out.println(latitude);
	Map mp=new Map();
	mp.setRregister(user);
	mp.setLatitude(latitude);
	mp.setLongitude(longitude);
	DaoQuery dq=new DaoQuery();
	
	int i=dq.insertMap(mp);
	ModelAndView mv=new ModelAndView();
	if(i>0)
	{
		String msg="Location updated!";
		mv.addObject("msg",msg);
		/*BhukkadController bc=new BhukkadController();
		bc.updateDetail(request);*/
		mv.setViewName("partners/editprofile.jsp");
	}
	return mv;
}
/*view menu*/
@RequestMapping("viewMenu.bhukkad")
public ModelAndView viewMenu(HttpServletRequest request)
{
	HttpSession sc=request.getSession();
	ModelAndView mv=new ModelAndView();
	Menu mn=new Menu();
	mn.setRsid((String)sc.getAttribute("rsid"));
	DaoQuery dq=new DaoQuery();
	List<Menu> list=new ArrayList();
	list=dq.getMenu(mn);
	if(!(list.isEmpty()))
	{
		mv.addObject("list", list);
		mv.setViewName("partners/viewmenu.jsp");
		
	}
	return mv;
}
@RequestMapping("orders.bhukkad")
public ModelAndView order(HttpServletRequest request)
{
	
	ModelAndView mv=new ModelAndView();
	Order or=new Order();
	HttpSession sc=request.getSession();
	String rsid=((String)sc.getAttribute("rsid"));
	List<Order> list1=new ArrayList();
	or.setRsid(rsid);
	DaoQuery dq=new DaoQuery();
	list1=dq.getOrders(or);
	for(Order o:list1)
	{
	System.out.println(o.getOid());
	}
	mv.addObject("orderlist", list1);
	mv.setViewName("/partners/home.jsp");
	return mv;
}
@RequestMapping("viewRestaurants.bhukkad")
public ModelAndView viewRestaurants(HttpServletRequest request,@RequestParam("searchname") String searchname)
{
	System.out.println("viewres");
	HttpSession sc=request.getSession();
	ModelAndView mv=new ModelAndView();
	Rregister rr=new Rregister();
	rr.setSearchname(searchname.toUpperCase());
	DaoQuery dq=new DaoQuery();
	List<Rregister> list=new ArrayList();
	list=dq.getrestaurantlist(rr);
	if(!(list.isEmpty()))
	{
		mv.addObject("list", list);
		mv.setViewName("viewrestaurants.jsp");
	}
	else
	{
		mv.setViewName("index.jsp");
	}
	return mv;
}
@RequestMapping("viewalldetails.bhukkad")
public ModelAndView viewalldetails(HttpServletRequest request, @RequestParam("rsid") String rsid)
{
	ModelAndView mv=new ModelAndView();
	HttpSession sc=request.getSession();
	sc.setAttribute("rsid", rsid);
	Rregister user=new Rregister();
	Map mp=new Map();
	Menu mn=new Menu();
	user.setRsid(rsid);
	mp.setRregister(user);
	mn.setRsid(rsid);
	DaoQuery dq=new DaoQuery();
	List<Rregister> list=new ArrayList();
	List<Menu> list1=new ArrayList();
	List<Map> list2=new ArrayList();
	list=dq.getResDetails(user);
	list1=dq.getMenu(mn);
	list2=dq.getLocation(mp);
	if(!(list.isEmpty()))
	{
		String lat="";
		String lon="";
		mv.addObject("detaillist",list);
		mv.addObject("menulist", list1);
		mv.addObject("maplist", list2);
		for(Map ff:list2)
		{
			lat=ff.getLatitude();
			lon=ff.getLongitude();
		}
		mv.addObject("lat", lat);
		
		mv.addObject("lon", lon);
		mv.setViewName("viewalldetails.jsp");
	}
	return mv;
}
@RequestMapping("OrderOnline.bhukkad")
public ModelAndView OrderOnline(HttpServletRequest request)
{
	ModelAndView mv=new ModelAndView();
	Menu mn=new Menu();
	HttpSession sc=request.getSession();
	String rsid=(String)sc.getAttribute("rsid");
	mn.setRsid(rsid);
	DaoQuery dq= new DaoQuery();
	List<Menu> list=new ArrayList();
	list=dq.getMenu(mn);
	if(!(list.isEmpty()))
	{
		mv.addObject("menulist", list);
		mv.setViewName("viewmenu.jsp");
		
	}
	
	return mv;
}
@RequestMapping("cart.bhukkad")
public ModelAndView Cart(HttpServletRequest request, @RequestParam("quantity") long quantity, @RequestParam("id") long id)
{
	ModelAndView mv=new ModelAndView();
	HttpSession sc=request.getSession();
	String email=(String) sc.getAttribute("email");
	List<Cart> cartlist=new ArrayList();
	
	
	Menu mn=new Menu();
	mn.setId(id);
	DaoQuery dq=new DaoQuery();
	List<Menu> list=new ArrayList();
	list=dq.getcart(mn);
	int i=0;
	int j=0;
	List<Cart> ll=new ArrayList();
	for(Menu oo:list)
	{
		Cart c=new Cart();
		long id1=oo.getId();
		String menuitem=oo.getMenuitem();
		String menucat=oo.getMenucat();
		long price=oo.getPrice();
		long total=quantity*price;
		c.setId(id1);
		c.setMenucat(menucat);
		c.setMenuitem(menuitem);
		c.setPrice(price);
		c.setQuantity(quantity);
		c.setTotal(total);
		c.setEmail(email);
		ll=dq.alreadycart(c);
		if(!(ll.isEmpty()))
		{
			
			long q = 0;
			for(Cart cc:ll) {
			q=cc.getQuantity();
			}
			long newq=q+quantity;
			total=newq*price;
			c.setId(id1);
			c.setMenucat(menucat);
			c.setMenuitem(menuitem);
			c.setPrice(price);
			c.setQuantity(newq);
			c.setTotal(total);
			c.setEmail(email);
			
			j=dq.deletealreadycart(c);
			i=dq.addtocart(c);	
		}
		else
		{
			i=dq.addtocart(c);
		}
		
	}
	if(i>0)
	{
		Cart c=new Cart();
		c.setEmail(email);
		cartlist=dq.getcartdetails(c);
	sc.setAttribute("cartlist", cartlist);
mv.setViewName("cart.jsp");
	}
	return mv;
}
@RequestMapping("cartview.bhukkad")
public ModelAndView cartview(HttpServletRequest request)
{
	ModelAndView mv=new ModelAndView();
	Cart c=new Cart();
	DaoQuery dq=new DaoQuery();
	HttpSession sc=request.getSession();
	String email=(String) sc.getAttribute("email");
	List<Cart> cartlist=new ArrayList();
	c.setEmail(email);
	cartlist=dq.getcartdetails(c);
	sc.setAttribute("cartlist", cartlist);
	mv.setViewName("cart.jsp");
	return mv;
}
@RequestMapping("checkout.bhukkad")
public ModelAndView checkoutpage(HttpServletRequest request, @RequestParam("gtotal") long gtotal, @RequestParam("address") String address, @RequestParam("phone") long phone)
{
	ModelAndView mv=new ModelAndView();
	HttpSession sc=request.getSession();
	sc.setAttribute("deliveryadd", address);
	sc.setAttribute("deliveryphone", phone);
	mv.addObject("gtotal", gtotal);

	mv.setViewName("payment.jsp");
	return mv;
}@RequestMapping("ordercomplete.bhukkad")
public ModelAndView ordercomplete(HttpServletRequest request, @RequestParam("OID") String oid)
{
	ModelAndView mv=new ModelAndView();
	HttpSession sc=request.getSession();
	String email=((String)sc.getAttribute("email"));
	String rsid=((String)sc.getAttribute("rsid"));
	String address=((String)sc.getAttribute("deliveryadd"));
	long phone=(Long) sc.getAttribute("deliveryphone");
	DaoQuery dq=new DaoQuery();
	Order or=new Order();
	or.setAddress(address);
	or.setPhone(phone);
	or.setOid(oid);
	or.setEmail(email);
	or.setRsid(rsid);
	int i=dq.addorder(or);
	int j=0;
	if(i>0)
	{
		Cart c=new Cart();
		c.setEmail(email);
		List<Cart> list=new ArrayList();
		list=dq.getcartdetails(c);
		
		for(Cart cc:list)
		{
			Orderlist ol=new Orderlist();
			String items=cc.getMenuitem();
			long quantity=cc.getQuantity();
			System.out.println(items);
			ol.setOrder(or);
			ol.setItems(items);
			ol.setQuantity(quantity);
			j=dq.addorderlist(ol);
		}
	}
	
	if(j>0)
	{
		Cart user=new Cart();
		user.setEmail(email);
		int k=dq.deletecart(user);
		if(k>0) {
		
		
		mv.addObject("oid", oid);
		mv.setViewName("orderstatus.jsp");
		}
	}
	
	
	
	return mv;
	
}
@RequestMapping("vieworderdetails.bhukkad")
public ModelAndView vieworderdetails(HttpServletRequest request, @RequestParam("OID") String oid)
{
	ModelAndView mv=new ModelAndView();
	HttpSession sc=request.getSession();
	String rsid=((String)sc.getAttribute("rsid"));
	Order or=new Order();
	or.setOid(oid);
	Orderlist ol=new Orderlist();
	ol.setOrder(or);
	List<Orderlist> list=new ArrayList();
	
	
	DaoQuery dq=new DaoQuery();
	list=dq.getOrderslist(ol);
	
	for(Orderlist oo:list)
	{
		System.out.println(oo.getItems());
	}
	if(!(list.isEmpty()))
	{
		
		mv.addObject("orderitems", list);
		mv.setViewName("partners/vieworderdetails.jsp");
	}
	
	return mv;
}
@RequestMapping("checkuser.bhukkad")
public ModelAndView checkuser(@RequestParam("email") String email)
{
	ModelAndView mv=new ModelAndView();
	Cregister user=new Cregister();
	user.setEmail(email);
	DaoQuery dq=new DaoQuery();
	List<Cregister> list=dq.checkuser(user);
	String msg=" ";
	if(!(list.isEmpty()))
		
		msg="email already registered";
	mv.addObject("msg", msg);
	mv.setViewName("ajaxresponse.jsp");
		
	
	return mv;
}
@RequestMapping("viewmyorders.bhukkad")
public ModelAndView viewmyorders(HttpServletRequest request)
{
	ModelAndView mv=new ModelAndView();
	HttpSession sc=request.getSession();
	String email=((String)sc.getAttribute("email"));
	Order or=new Order();
	List<Order> list1=new ArrayList();
	DaoQuery dq=new DaoQuery();
	or.setEmail(email);
	list1=dq.getOrders1(or);
	mv.addObject("orders", list1);
	mv.setViewName("viewmyorders.jsp");
	return mv;
}
@RequestMapping("viewmyorderdetails.bhukkad")
public ModelAndView viewmyorderdetails(HttpServletRequest request, @RequestParam("OID") String oid)
{
	ModelAndView mv=new ModelAndView();
	HttpSession sc=request.getSession();
	String email=((String)sc.getAttribute("email"));
	Order or=new Order();
	or.setOid(oid);
	Orderlist ol=new Orderlist();
	ol.setOrder(or);
	List<Orderlist> list=new ArrayList();
	
	
	DaoQuery dq=new DaoQuery();
	list=dq.getOrderslist(ol);
	
	for(Orderlist oo:list)
	{
		System.out.println(oo.getItems());
	}
	if(!(list.isEmpty()))
	{
		
		mv.addObject("orderitems", list);
		mv.setViewName("viewmyorderdetails.jsp");
	}
	
	return mv;
}
@RequestMapping("editmyprofile.bhukkad")
public ModelAndView editmyprofile(HttpServletRequest request)
{
	HttpSession sc=request.getSession();
	ModelAndView mv=new ModelAndView();
	String email=((String)sc.getAttribute("email"));
	Cregister cr=new Cregister();
	cr.setEmail(email);
	List<Cregister> list=new ArrayList();
	DaoQuery dq=new DaoQuery();
	list=dq.getUserDetails(cr);
	if(!(list.isEmpty()))
	{
		mv.addObject("list", list);
		mv.setViewName("editmyprofile.jsp");
	}
	return mv;
}
@RequestMapping("updatemyfname.bhukkad")
public ModelAndView upadatemyfname(HttpServletRequest request, @RequestParam("fname") String fname)
{
	ModelAndView mv=new ModelAndView();
	HttpSession sc=request.getSession();
	String email=((String)sc.getAttribute("email"));
	Cregister user=new Cregister();
	user.setEmail(email);
	user.setFname(fname);
	DaoQuery dq=new DaoQuery();
	int i=dq.updatemyfname(user);
	if(i>0)
	{
		String msg="Profile updated succesfully";
		mv.addObject("updatemsg", msg);
		mv.setViewName("editmyprofile.jsp");
		
	}
	return mv;
}
@RequestMapping("updatemysname.bhukkad")
public ModelAndView upadatemysname(HttpServletRequest request, @RequestParam("sname") String sname)
{
	ModelAndView mv=new ModelAndView();
	HttpSession sc=request.getSession();
	String email=((String)sc.getAttribute("email"));
	Cregister user=new Cregister();
	user.setEmail(email);
	user.setSname(sname);
	DaoQuery dq=new DaoQuery();
	int i=dq.updatemysname(user);
	if(i>0)
	{
		String msg="Profile updated succesfully";
		mv.addObject("updatemsg", msg);
		mv.setViewName("editmyprofile.jsp");
		
	}
	return mv;
}
@RequestMapping("updatemypassword.bhukkad")
public ModelAndView upadatemypassword(HttpServletRequest request, @RequestParam("password") String password)
{
	ModelAndView mv=new ModelAndView();
	HttpSession sc=request.getSession();
	String email=((String)sc.getAttribute("email"));
	Cregister user=new Cregister();
	user.setEmail(email);
	user.setPassword(password);
	DaoQuery dq=new DaoQuery();
	int i=dq.updatemypassword(user);
	if(i>0)
	{
		Clogin cl=new Clogin();
		cl.setCustomerreg(user);
		cl.setPassword(password);
		int j=dq.upadatemypasswordlogin(cl);
		if(j>0) {
		String msg="Profile updated succesfully";
		mv.addObject("updatemsg", msg);
		mv.setViewName("editmyprofile.jsp");
		}
		
	}
	return mv;
}
@RequestMapping("updatemyphone.bhukkad")
public ModelAndView upadatemyphone(HttpServletRequest request, @RequestParam("phone") BigDecimal phone)
{
	ModelAndView mv=new ModelAndView();
	HttpSession sc=request.getSession();
	String email=((String)sc.getAttribute("email"));
	Cregister user=new Cregister();
	user.setEmail(email);
	user.setPhone(phone);
	DaoQuery dq=new DaoQuery();
	int i=dq.updatemyphone(user);
	if(i>0)
	{
		String msg="Profile updated succesfully";
		mv.addObject("updatemsg", msg);
		mv.setViewName("editmyprofile.jsp");
		
	}
	return mv;
}
@RequestMapping("forgotpassword")
public ModelAndView forgotpassword() 
{
ModelAndView mv=new ModelAndView();
mv.setViewName("forgotpassword.jsp");
return mv;
}
@RequestMapping("checkotp")
public ModelAndView checkotp(HttpServletRequest request,@RequestParam("email") String email)
{
	ModelAndView mv=new ModelAndView();
	DaoQuery dq=new DaoQuery();
	Cregister user=new Cregister();
	user.setEmail(email);
	List<Cregister> list=new ArrayList();
	list=dq.checkuser(user);
	if(!(list.isEmpty()))
	{
	double d=Math.random();
	d=(d*90000)+10000;
	double a=Math.floor(d);
	int b=(int) a;
	String password = String.valueOf(b);
	Otp oo=new Otp();
	oo.setPassword(password);
	oo.setEmail(email);
	int i=dq.addotp(oo);
	if(i>0)
	{
		HttpSession sc=request.getSession(true);
		sc.setAttribute("email", email);
		Mailer m=new Mailer();
		
		String sub="Password Change";
		String msg="Dear Customer, your One Time Password : "+password;
		Mailer.send("cavik1994@gmail.com", sub, msg);
		mv.setViewName("confirmotp.jsp");
	}
	}
	return mv;
}
@RequestMapping("/feedback.bhukkad")
public ModelAndView feed(@RequestParam("FeedbackName") String feedname,@RequestParam("FeedbackComment") String feedcomment)
{
	
	ModelAndView mv=new ModelAndView();
	
	Review rev=new Review();
	
	rev.setFeedname(feedname);
	rev.setFeedcomment(feedcomment);
	DaoQuery dq=new DaoQuery();
	int i=dq.feedback_form(rev);
	if(i>0)
	mv.setViewName("/Review.jsp");
	
	
	return mv;
}
@RequestMapping("/getreview.bhukkad")
public ModelAndView getreview()
{
	
	ModelAndView mv=new ModelAndView();
	

	DaoQuery dq=new DaoQuery();
	
	List<Review> l1=dq.feedback();
	
	mv.addObject("List", l1);
		
		mv.setViewName("/ajax.jsp");
	
	
	return mv;
}
}
