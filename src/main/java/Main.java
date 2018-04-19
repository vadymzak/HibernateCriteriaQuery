
import models.Product;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        List<Product> products = null;
        try {
            session.beginTransaction();

            Query queryHQLSelect = session.createQuery("FROM Product AS p INNER JOIN FETCH p.productCategory AS pc");
            products = queryHQLSelect.list();
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
