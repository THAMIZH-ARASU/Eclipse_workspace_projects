package com.microsoft.DAO;

import java.util.List;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.microsoft.model.Student;
import com.microsoft.util.HibernateUtil;
import com.microsoft.DAO.*;

public class StudentDAO implements IStudent{
	@SuppressWarnings("deprecation")
	public void saveStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();

			// save student object
			session.save(student);

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/* (non-Javadoc)
	 * @see net.javaguides.hibernate.dao.IStudentDao#updateStudent(net.javaguides.hibernate.model.Student)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void updateStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();

			// save student object
			session.saveOrUpdate(student);

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/* (non-Javadoc)
	 * @see net.javaguides.hibernate.dao.IStudentDao#getStudentById(long)
	 */
	@Override
	public Student getStudentById(long id) {
		Transaction transaction = null;
		Student student = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();

			// get student object
			student = session.get(Student.class, id);
			//student = session.load(Student.class, id);
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return student;
	}

	/* (non-Javadoc)
	 * @see net.javaguides.hibernate.dao.IStudentDao#getAllStudents()
	 */
	@Override
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List < Student > getAllStudents() {
		Transaction transaction = null;
		List < Student > students = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();

			// get students
			students = session.createQuery("from Student").list();
			//student = session.load(Student.class, id);
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return students;
	}

	/* (non-Javadoc)
	 * @see net.javaguides.hibernate.dao.IStudentDao#deleteStudent(long)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void deleteStudent(long id) {
		Transaction transaction = null;
		Student student = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();

			student = session.get(Student.class, id);
			// get student object
			session.delete(student);
			//student = session.load(Student.class, id);
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}}