package com.projectzaliczemie.blog.Controller;

import com.projectzaliczemie.blog.models.Tours;
import com.projectzaliczemie.blog.repo.ToursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {

    @Autowired
    private ToursRepository toursRepository;

    @GetMapping("/Booking")
    public String booking(Model model) {
        Iterable<Tours> tours = toursRepository.findAll();
        model.addAttribute("Tours", tours);
        return "Booking";
    }

    @GetMapping("/YourApplication")
    public String yourApplication(Model model) {
        return "YourApplication";
    }

    @PostMapping("/YourApplication")
    public String yourApplication(
            @RequestParam String country,
            @RequestParam String city,
            @RequestParam int nights,
            @RequestParam String meals,
            @RequestParam int adults,
            @RequestParam String children,
            @RequestParam String departureDate,
            @RequestParam String contact,
            Model model) {
        Tours tour = new Tours(country, city, nights, meals, adults, children, departureDate, contact);
        toursRepository.save(tour);
        return "redirect:/Booking";
    }
}
