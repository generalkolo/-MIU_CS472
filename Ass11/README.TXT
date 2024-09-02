- Servlets serve as the computational brains, while JSPs play the role of artistic faces in a web application. Behind the scenes, servlets manage complex operations and data, while JSPs blend Java code with HTML to bring dynamic content to the user's screen. Deploying a web app on a real server involves creating an environment where your app can run. This includes configuring the web server and servlet container (like Tomcat) to handle your app. The server readies itself to execute servlets and JSPs, listens for incoming requests, and directs them to the appropriate component. It's akin to preparing a concert venue for a performance.

- NetBeans stands as your ultimate partner in web development. It maintains project organization, identifies coding errors, and offers a visual design tool for crafting web pages. Think of it as a tech-savvy friend who's in tune with servers like Tomcat. It enables you to watch your website take form as you build. And when changes occur, NetBeans steps up to streamline deployment, eliminating manual complexities. It's the code conductor. Working behind the scenes, NetBeans acts as your development assistant, making your journey smoother. It oversees project structure, pinpoints coding issues, and integrates web design tools. When you click "Run" in NetBeans, it handles app building and deployment on a server, showcasing your work in action. Grasping the magic of NetBeans aids you in troubleshooting and navigating uncharted situations, offering insights into your development environment. It's the companion guiding you on this coding expedition.

===================================================================================================


Question: Purpose of directory structure on p. 30: management ?
Answer: It organizes project files for better

Question: Purpose of directory structure on p. 31 ?
Answer: Organizes source code and resources for the web app.

Question: Need to be in project1 directory for step 5?
Answer: Ensures proper execution context for compiling.

Question: Necessity of copying in step 6.?
Answer: Moves compiled files to server's location for access.

Question: Defining web app name?
Answer: Defined in "web.xml," changing affects app's URL and behavior.

Question: Necessity of step 9?
Answer: Restarts server, applying changes to the deployed app.

Question: Steps for browser changes?
Answer: Recompile, redeploy, refresh page to see updates.

Question: Interesting problem and solution?
Answer: No, I didn't notice any problems or encounter any issues


======================================== Junit test class ========================================

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.List;

public class BeerExpertTest {

    @Test
    public void testGetBrandsForAmberColor() {
        BeerExpert beerExpert = new BeerExpert();
        List<String> brands = beerExpert.getBrands("amber");

        assertEquals(2, brands.size());
        assertEquals("Jack AMber", brands.get(0));
        assertEquals("Red Moose", brands.get(1));
    }

    @Test
    public void testGetBrandsForOtherColors() {
        BeerExpert beerExpert = new BeerExpert();
        List<String> brands = beerExpert.getBrands("other");

        assertEquals(2, brands.size());
        assertEquals("Jail Pale Ale", brands.get(0));
        assertEquals("Gout Stout", brands.get(1));
    }
}
