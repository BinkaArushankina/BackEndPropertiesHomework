import de.ait.config.ApplicationConfig;
import de.ait.services.ProductsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.Scanner;
@Controller
public class ProductController {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ProductsService productsService = context.getBean(ProductsService.class);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. add product");
            System.out.println("2. get all products");
            System.out.println("0. exit");

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1 -> {
                    String name = scanner.nextLine();
                    String quantity = scanner.nextLine();

                    productsService.signUp(name,quantity);
                }
                case 2 -> System.out.println(productsService.getAllProducts());
                case 0 -> System.exit(0);
            }
        }
    }
}
