package com.database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tables.Cart;
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


public class DaoQuery {
	
	/* customer register */
	public int register(Cregister user)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		int i=0;
		System.out.println("hi");
		try
		{
		et.begin();
		em.persist(user);
		Clogin user1=new Clogin();
		user1.setCustomerreg(user);
		user1.setPassword(user.getPassword());
		em.persist(user1);
		et.commit();
		
		i=1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	/* customer login */
	public List<Clogin> login(Clogin user1) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		List<Clogin> list=new ArrayList();
		
		try
		{
			Query query = em.createQuery("from Clogin e where e.customerreg=:em and e.password=:pass").setParameter("em",user1.getCustomerreg()).setParameter("pass", user1.getPassword());
			list = query.getResultList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
/* customer details */
	public List<Cregister> getUserDetails(Cregister cr) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		List<Cregister> list=new ArrayList();
		try
		{
			Query query = em.createQuery("from Cregister e where e.email=:em").setParameter("em",cr.getEmail());
			list = query.getResultList();
		}
		catch(Exception e)
		{
			
		}
		return list;
	}

	/* restaurant register */
	public int resRegister(Rregister user) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		int i=0;
		System.out.println("hi");
		try
		{
			et.begin();
			em.merge(user);
			Rlogin user1=new Rlogin();
			user1.setRregister(user);
			user1.setPassword(user.getPassword());
			em.merge(user1);
			Map mp=new Map();
			mp.setRregister(user);
			em.merge(mp);
			et.commit();
			i=1;
			System.out.println("xx");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return i;
	}

	/*restaurant login */
	public List<Rlogin> reslogin(Rlogin user1) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		List<Rlogin> list = new ArrayList();
		try
		{
			Query query = em.createQuery("from Rlogin e where e.rregister=:em and e.password=:pass").setParameter("em",user1.getRregister()).setParameter("pass", user1.getPassword());
			list = query.getResultList();
			for(Rlogin ff:list) {
				System.out.println(ff.getId());
			System.out.println(ff.getPassword());
			System.out.println(ff.getRregister().getRsid());}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

		
		return list;
	}
/* restaurant details */
	public List<Rregister> getResDetails(Rregister cr) {
		System.out.println("dao");
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		List<Rregister> list=new ArrayList();
		try
		{
			Query query = em.createQuery("from Rregister e where e.rsid=:em").setParameter("em",cr.getRsid());
			list = query.getResultList();
			for(Rregister ff:list)
			{
				System.out.println(ff.getArea());
				System.out.println(ff.getRname());
				System.out.println(ff.getPhone());
			}
		}
		catch(Exception e)
		{
			System.out.print("jj");
			e.printStackTrace();
		}
		return list;
		
	}

	/* insert menu */
	public int insertMenu(Menu mn) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		int i=0;
		try
		{
			et.begin();
			em.persist(mn);
			et.commit();
			i=1;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	public int updateName(Rregister user) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		int i=0;
		try
		{
			et.begin();
			Query q=em.createQuery("update Rregister e set e.rname=:rname where e.rsid=:em").setParameter("rname", user.getRname()).setParameter("em", user.getRsid());
			i=q.executeUpdate();
			et.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	public int updateArea(Rregister user) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		int i=0;
		try
		{
			et.begin();
			Query q=em.createQuery("update Rregister e set e.area=:rname where e.rsid=:em").setParameter("rname", user.getArea()).setParameter("em", user.getRsid());
			i=q.executeUpdate();
			et.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}
	

	public int updatePassword(Rregister user) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		int i=0;
		try
		{
			et.begin();
			Query q=em.createQuery("update Rregister e set e.password=:rname where e.rsid=:em").setParameter("rname", user.getPassword()).setParameter("em", user.getRsid());
			i=q.executeUpdate();
			et.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	public int updatePhone(Rregister user) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		int i=0;
		try
		{
			et.begin();
			Query q=em.createQuery("update Rregister e set e.phone=:rname where e.rsid=:em").setParameter("rname", user.getPhone()).setParameter("em", user.getRsid());
			i=q.executeUpdate();
			et.commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	

	public int changeLoginPassword(Rlogin user1) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		int i=0;
		try
		{
			et.begin();
			Query q=em.createQuery("update Rlogin e set e.password=:rname where e.rregister=:em").setParameter("rname", user1.getPassword()).setParameter("em", user1.getRregister());
			i=q.executeUpdate();
			et.commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	public int insertMap(Map mp) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		int i=0;
		try
		{
			et.begin();
			Query q=em.createQuery("update Map e set e.latitude=:la, e.longitude=:lo where e.rregister=:rsid").setParameter("la",mp.getLatitude()).setParameter("lo", mp.getLongitude()).setParameter("rsid", mp.getRregister());
			i=q.executeUpdate();
			et.commit();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	public List<Menu> getMenu(Menu mn) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		List<Menu> list=new ArrayList();
		try
		{
			Query q=em.createQuery("from Menu m where m.rsid=:rsid").setParameter("rsid", mn.getRsid());
			list=q.getResultList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	public List<Rregister> getrestaurantlist(Rregister rr) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		List<Rregister> list=new ArrayList();
		try
		{
			Query q=em.createQuery("from Rregister r where r.searchname like '%"+rr.getSearchname()+"%'");
			list=q.getResultList();
			for(Rregister ff:list)
			{
				System.out.println(ff.getArea());
				System.out.println(ff.getRname());
				System.out.println(ff.getPhone());
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	public int updateaveragecost(Rregister user) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		int i=0;
		try
		{
			et.begin();
			Query q=em.createQuery("update Rregister e set e.averagecost=:rname where e.rsid=:em").setParameter("rname", user.getAveragecost()).setParameter("em", user.getRsid());
			i=q.executeUpdate();
			et.commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	

	public List<Map> getLocation(Map mp) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		List<Map> list=new ArrayList();
		try
		{
			Query q=em.createQuery("from Map m where m.rsid=:rsid").setParameter("rsid", mp.getRregister());
			list=q.getResultList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	public List<Menu> getcart(Menu mn) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		List<Menu> list=new ArrayList();
		System.out.println(mn.getId());
		try
		{
			Query q=em.createQuery("from Menu m where m.id=:id").setParameter("id", mn.getId());
			System.out.println(mn.getId());
			list=q.getResultList();
			for(Menu m:list)
			{
				System.out.println(m.getMenucat());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	public int addtocart(Cart c) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		int i=0;
		try
		{
			et.begin();
			em.merge(c);
			et.commit();
			i=1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	public List<Cart> getcartdetails(Cart c) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		List<Cart> list=new ArrayList();
		
		try
		{
			Query q=em.createQuery("from Cart c where c.email=:email").setParameter("email", c.getEmail());
			
			list=q.getResultList();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	public int deletecart(Cart user) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		int i=0;
		try
		{
			et.begin();
			Query q=em.createQuery("delete from Cart c where c.email=:email").setParameter("email", user.getEmail());
			i=q.executeUpdate();
			et.commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	public List<Cart> alreadycart(Cart c) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		List<Cart> list=new ArrayList();
		try
		{
			
			Query q=em.createQuery("from Cart c where c.id=:id and c.email=:email").setParameter("id", c.getId()).setParameter("email", c.getEmail());
			list=q.getResultList();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	public int deletealreadycart(Cart c) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		int i=0;
		try
		{
			et.begin();
			Query q=em.createQuery("delete from Cart c where c.email=:email and c.id=:id").setParameter("email", c.getEmail()).setParameter("id", c.getId());
			i=q.executeUpdate();
			et.commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	
	}

	public int updatecart(Cart c) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		int i=0;
		try
		{
			et.begin();
			Query q=em.createQuery("update Cart e set e.quantity=:la, e.total=:lo where e.email=:rsid").setParameter("la",c.getQuantity()).setParameter("lo", c.getTotal()).setParameter("rsid", c.getEmail());
			i=q.executeUpdate();
			et.commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	public int addorder(Order or) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		int i=0;
		System.out.println("hi");
		try
		{
		et.begin();
		em.merge(or);
		et.commit();
		i=1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
		
	}

	public int addorderlist(Orderlist ol) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		int i=0;
		
		try
		{
		et.begin();
		em.persist(ol);
		et.commit();
		i=1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	public List<Order> getOrders(Order or) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		List<Order> list=new ArrayList();
		try
		{
			System.out.println("list");
			System.out.println(or.getRsid());
			Query q=em.createQuery("from Order o where o.rsid=:rsid").setParameter("rsid", or.getRsid());
			list=q.getResultList();
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	public List<Orderlist> getOrderslist(Orderlist ol) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		List<Orderlist> list=new ArrayList();
		try
		{
			
			Query q=em.createQuery("from Orderlist o where o.order=:rsid").setParameter("rsid", ol.getOrder());
			list=q.getResultList();
			if(!(list.isEmpty()))
			{
				System.out.println("hi");
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	public List<Cregister> checkuser(Cregister user) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
		EntityManager em=emf.createEntityManager();
		List<Cregister> list=new ArrayList();
		try
		{
			
			Query q=em.createQuery("from Cregister r where r.email=:email").setParameter("email", user.getEmail());
			list=q.getResultList();
			if(!(list.isEmpty()))
			{
				System.out.println("hi");
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	
	
public List<Order> getOrders1(Order or) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
	EntityManager em=emf.createEntityManager();
	List<Order> list=new ArrayList();
	try
	{
		System.out.println("list");
		System.out.println(or.getRsid());
		Query q=em.createQuery("from Order o where o.email=:email").setParameter("email", or.getEmail());
		list=q.getResultList();
		
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}

public int updatemyfname(Cregister user) {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	int i=0;
	try
	{
		et.begin();
		Query q=em.createQuery("update Cregister e set e.fname=:fname where e.email=:em").setParameter("fname", user.getFname()).setParameter("em", user.getEmail());
		i=q.executeUpdate();
		et.commit();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return i;
}

public int updatemysname(Cregister user) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	int i=0;
	try
	{
		et.begin();
		Query q=em.createQuery("update Cregister e set e.sname=:sname where e.email=:em").setParameter("sname", user.getSname()).setParameter("em", user.getEmail());
		i=q.executeUpdate();
		et.commit();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return i;
}

public int updatemypassword(Cregister user) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	int i=0;
	try
	{
		et.begin();
		Query q=em.createQuery("update Cregister e set e.password=:password where e.email=:em").setParameter("password", user.getPassword()).setParameter("em", user.getEmail());
		i=q.executeUpdate();
		et.commit();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return i;
}

public int upadatemypasswordlogin(Clogin cl) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	int i=0;
	try
	{
		et.begin();
		Query q=em.createQuery("update Clogin e set e.password=:password where e.customerreg=:em").setParameter("password", cl.getPassword()).setParameter("em", cl.getCustomerreg());
		i=q.executeUpdate();
		et.commit();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return i;
}

public int updatemyphone(Cregister user) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	int i=0;
	try
	{
		et.begin();
		Query q=em.createQuery("update Cregister e set e.phone=:phone where e.email=:em").setParameter("phone", user.getPhone()).setParameter("em", user.getEmail());
		i=q.executeUpdate();
		et.commit();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return i;
}

public int addotp(Otp oo) {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	int i=0;
	
	try
	{
	et.begin();
	em.persist(oo);
	et.commit();
	
	i=1;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return i;
}
public int feedback_form(Review rev)
{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();

	int i=0;
	try
	{
	et.begin();
	em.persist(rev);
	et.commit();
	i=1;
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	System.out.println(i);
	return i;
}

public List<Review> feedback() {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("bhukkad");
	EntityManager em=emf.createEntityManager();
	
	List<Review> l1=new ArrayList();
	try
	{
		Query q= em.createQuery("select c from Review c");
		l1 = q.getResultList();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return l1;
}

}


	

	

