
import models.Product;
import models.ProductCategory;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        List<Object[]> products = null;
        try {
            session.beginTransaction();

            SQLQuery queryUpdate = session.createSQLQuery("UPDATE product SET price = :pricce WHERE id = :id");
            queryUpdate.setParameter("pricce", "750");
            queryUpdate.setParameter("id", "2");
            queryUpdate.executeUpdate();

            SQLQuery query = session.createSQLQuery("Select p.*, pc.* FROM product AS p INNER JOIN product_category AS pc ON p.product_category_id  = pc.id");

            query.addEntity("p", Product.class);
            query.addJoin("pc", "p.productCategory");

            products = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
        for (Object[] obj : products) {
            ProductCategory pc = (ProductCategory) obj[1];
            System.out.println(obj[0].toString() + " " + pc.getTitle_category());
        }
    }
}
