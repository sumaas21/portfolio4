package com.Portfolio.controller;

import com.Portfolio.payload.EmailBody;
import com.Portfolio.services.PortfolioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@Controller
public class Portfoliocontroller {

    @Autowired
    private PortfolioServices portfolioServices;

    @RequestMapping("/")
    public String indexPage() {
        return "index.html";
    }

    @RequestMapping("/home")
    public String indexPage2() {
        return "index.html";
    }

    @RequestMapping("/redirectToLinkedin")
    public String redirectToLinkedin() {
        return "http://www.linkedin.com/in/sameeroddin-kazi";
    }

    @RequestMapping("/healthServicesApplication")
    public String HealthServicesApplicationView() {
        return "HealthServices.html";
    }

    @RequestMapping("/FlightReservationApplication")
    public String FlightReservationApplicationView() {
        return "FlightReservationApplication.html";
    }

    @RequestMapping("/RealEstateApplication")
    public String RealEstateApplicationView() {
        return "RealEstateApplication.html";
    }

    @RequestMapping("/ChatApplication")
    public String ChatApplicationView() {
        return "ChatApplication.html";
    }

    @RequestMapping("/BloggingApplication")
    public String BloggingApplicationView() {
        return "BloggingApplication.html";
    }

    @RequestMapping("/WeatherApplication")
    public String WeatherApplicationView() {
        return "WeatherApplication.html";
    }

    @RequestMapping("/HealthProjectGitHub")
    public String HealthProjectGitHub() {
        return "redirect:https://github.com/sumaas21/HealthApplication";
    }

    @RequestMapping("/flightProjectGithub")
    public String flightProjectGithub() {
        return "redirect:https://github.com/sumaas21/FlightBooking";
    }

    @RequestMapping("/RealestateProjectGithub")
    public String RealestateProjectGithub() {
        return "redirect:https://github.com/sumaas21/Real-Estate";
    }

    @RequestMapping("/ChatProjectGithub")
    public String ChatProjectGithub() {
        return "redirect: https://github.com/sumaas21/ChatApp";
    }

    @RequestMapping("/BlogProjectGithub")
    public String BlogProjectGithub() {
        return "redirect:https://github.com/sumaas21/BlogPost";
    }

    @RequestMapping("/WeatherProjectGithub")
    public String WeatherProjectGithub() {
        return "redirect:https://github.com/sumaas21/WeatherApp";
    }

    @GetMapping("/downloadCV")
    public ResponseEntity<byte[]> downloadPdf() throws IOException {
        ResponseEntity<byte[]> responseEntity;
        try {
            responseEntity = portfolioServices.DownloadCVRequest();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return responseEntity;
    }

    @PostMapping("/sendEmail")
    public String getFormData(
            @RequestParam("Name") String name,
            @RequestParam("Email") String email,
            @RequestParam("Message") String message) {
        EmailBody emailBody = new EmailBody();
        emailBody.setSenderName(name);
        emailBody.setSenderEmail(email);
        emailBody.setMessage(message);
        portfolioServices.sendEmailToS7M1R(emailBody);
        return "redirect:/home";
    }

}
