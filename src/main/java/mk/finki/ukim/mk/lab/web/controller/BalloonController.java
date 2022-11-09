package mk.finki.ukim.mk.lab.web.controller;


import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/balloons")
public class BalloonController {

    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model) {
        if (error!=null && !error.equals(""))
        {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Balloon> balloonList = this.balloonService.listAll();
        model.addAttribute( "balloons", balloonList );
        return "listBalloons";
    }

    public String saveBalloon(@RequestParam String name, @RequestParam String description, @RequestParam Long manufacturer) {
        this.balloonService.save(name, description, manufacturer);
        return "redirect:/balloons";
    }

    @DeleteMapping("/balloons/delete/{id}")
    public String deleteBalloon(@PathVariable Long id) {

        this.balloonService.deleteById(id);

        return "redirect:/listBalloons";

    }

}
