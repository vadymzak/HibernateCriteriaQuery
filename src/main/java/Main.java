
import models.Product;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        List<Product> products = null;
        try {
            session.beginTransaction();

            //Criteria criteria = session.createCriteria(Product.class);
           // criteria.add(Restrictions.eq("title", "Lenovo A6020"));

            /*SELECT * FROM product WHERE title = "Lenovo A6020"*/
            //criteria.add(Restrictions.between("price", 10, 1000));

            //criteria.add(Restrictions.like("title", "Lenovo A6020"));
            /*SELECT * FROM product WHERE title like "%Lenovo A6020%"*/

           /* Object [] mas = {1L,2L,4L,5L};
            criteria.add(Restrictions.like("title", "Lenovo A6020"));
            criteria.add(Restrictions.or(Restrictions.not(Restrictions.in("id", mas ))));
            //SELECT * FROM product  WHERE title like "%Lenovo A6020%" AND id NOT in (1,2,4,5)*/

            //criteria.addOrder(Order.desc("id"));

            Criteria criteria = session.createCriteria(Product.class, "product");
            criteria.createCriteria("product.productCategory", "productCategory");
            criteria.add(Restrictions.eq("product.title", "Lenovo A6020"));
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            products = criteria.list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
        for (Product product : products) {
            System.out.println(product);
        }
        /*
        * SQL: SELECT * FROM product p INNER JOIN product_category pc ON p.product_category_id = pc.id
        *
        * HQL: FROM product p INNER JOIN FETCH p.productCategory as pc
        *
        * */
        /*
         *session.save(product);
         *session.update(product);
         *session.delete(product);
         *session.uniqueResult();
         * */

    }
}
