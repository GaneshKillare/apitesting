package test;

import com.github.javafaker.Faker;
import endpoints.ActivitiesEndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payload.Activities;
import utilities.RetryAnalyzer;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TC_Activities {

    Activities activities;
    Faker faker;

    @BeforeClass
    public void setData() {

        faker = new Faker();
        activities = new Activities();
        activities.setId(faker.number().numberBetween(1, 30));
        activities.setTitle(faker.hobbit().character() + " " + faker.color().name() + "  " + faker.company().name());
        activities.setDueDate(ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT));
        activities.setStatus(true);

        System.out.println(this.activities.getId());

    }

    @Test(priority = 1)
    public void test_Get_All_Activities() {

        Response response = ActivitiesEndPoints.getAllActivities();

        Assert.assertEquals(response.getStatusCode(), 200, "Response code mis-Match");

    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void test_post_Activities() {

        Response response = ActivitiesEndPoints.postActivities(activities);

        Assert.assertEquals(response.getStatusCode(), 200, "Response code mis-Match");

    }

    @Test(priority = 3, dependsOnMethods = "test_post_Activities")
    public void test_get_Activities() {
        Response response = ActivitiesEndPoints.getActivities(this.activities.getId());

        Assert.assertEquals(response.getStatusCode(), 200, "Response code mis-Match");

    }

    @Test(priority = 4, dependsOnMethods = "test_post_Activities")
    public void test_Update_Activities() {

// Update data
        activities.setId(faker.number().numberBetween(1, 30));
        activities.setTitle(faker.hobbit().character() + " " + faker.color().name() + "  " + faker.company().name());
        activities.setDueDate(ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT));
        activities.setStatus(true);


        Response response = ActivitiesEndPoints.updateActivities(this.activities.getId(), activities);
        System.out.println(activities.getId());
        Assert.assertEquals(response.getStatusCode(), 200, "Response code mis-Match");

    }

    @Test(priority = 5, dependsOnMethods = "test_Update_Activities")
    public void test_get_Activities_After_Put() {
        //  activities.setId(10);
        Response response = ActivitiesEndPoints.getActivities(this.activities.getId());

        Assert.assertEquals(response.getStatusCode(), 200, "Response code mis-Match");

    }

    @Test(priority = 6, dependsOnMethods = "test_get_Activities_After_Put")
    public void test_Delete_Activities() {

        Response response = ActivitiesEndPoints.deleteActivities(this.activities.getId());

        Assert.assertEquals(response.getStatusCode(), 200, "Response code mis-Match");

    }

}
