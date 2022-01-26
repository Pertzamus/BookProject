package Projekti.Bookstore.web;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

	@RequestMapping("index")
	public String showBooks(Model model) {
		
		
	return "Booklist";
	}
	
}
