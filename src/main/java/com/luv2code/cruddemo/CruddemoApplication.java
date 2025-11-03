package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createInstructor(appDAO);
//			findInstructorById(appDAO);
//			deleteInstructorById(appDAO);
//			findInstructorDetailById(appDAO);
//			deleteInstructorDetailById(appDAO);
            createInstructorwithCourse(appDAO);
		};
	}

    private void createInstructorwithCourse(AppDAO appDAO) {
        // create the instructor

        Instructor tempInstructor = new Instructor("Asad","Ali","aliasad@gmail.com");

        // create the instructor detail

        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.aliasad.com",
                "Gaming");

        // associate the objects

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // create some courses
        Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
        Course tempCourse2 = new Course("The Pin Ball MasterClass");

        // add courses to instructor
        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

        // save the instructor
        //
        // NOTE: this willl also save the courses
        // because of CascadeType.PERSIST
        System.out.println("Saving instructor: " + tempInstructor);
        System.out.println("The courses: " + tempInstructor.getCourses());
        appDAO.save(tempInstructor);
        System.out.println("Done!");
    }

    private void deleteInstructorDetailById(AppDAO appDAO) {

        int theId = 7;
        System.out.println("Deleting instructor detail id: " + theId);
        appDAO.deleteInstructorDetailById(theId);
        System.out.println("Done!");
    }

    private void findInstructorDetailById(AppDAO appDAO) {

        // get the instructor detail object
		int id = 1;
		System.out.println("Retrieving InstructorDetail by Id " + id);
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(id);
        // print the instructor detail object
		System.out.println("Retrieved Instructor: " + tempInstructorDetail);
        // print the associated instructor
		System.out.println("The associated instructor only: " + tempInstructorDetail.getInstructor());
        System.out.println("Done!");
	}

	private void deleteInstructorById(AppDAO appDAO) {

		int id = 3;
		System.out.println("Deleting instructor against id: " + id);
		appDAO.deleteInstructorById(id);
		System.out.println("Deletion successful!");
	}

	private void findInstructorById(AppDAO appDAO) {

		int id = 1;
		System.out.println("Retrieving Instructor by Id " + id);
		Instructor retrieveInstructor = appDAO.findInstructorById(id);
		System.out.println("Retrieved Instructor: " + retrieveInstructor);
		System.out.println("the associated instructorDetail only: " + retrieveInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		// create the instructor
		/*
		Instructor tempInstructor = new Instructor("Chad","Darby","darby@luv2code.com");

		// create the instructor detail

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube",
				"luv2code");


		 */

		// create the instructor

		Instructor tempInstructor = new Instructor("Mohid","Suri","suri@gmail.com");

		// create the instructor detail

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com",
				"Guitar");

		// associate the objects

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor

		// Note: this will also save the details object because of CascadeType.ALL

		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

}
