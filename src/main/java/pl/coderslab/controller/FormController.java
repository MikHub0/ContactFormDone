package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.component.EmailServiceImpl;
import pl.coderslab.model.ContactForm;
import pl.coderslab.repository.ContactFormRepository;

@Controller
public class FormController {

    @Autowired
    private ContactFormRepository contactFormRepository;
    @Autowired
    private EmailServiceImpl emailService;

    @GetMapping("/")
    public String showContactForm(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "index";
    }

    @PostMapping("/submit")
    public String submitContactForm(@ModelAttribute ContactForm contactForm, Model model) {
        // Save the form data to the repository (optional)
        contactFormRepository.save(contactForm);

        // Send the email
        emailService.sendSimpleMessage(
                contactForm.getEmail(),
                "New Contact Form Submission",
                "Name: " + contactForm.getName() +
                        "\nEmail: " + contactForm.getEmail() +
                        "\nMessage: " + contactForm.getMsg()
        );


        // Add a success message
        model.addAttribute("message", "Your message has been sent successfully!");

        return "index";

    }
}


//    @PostMapping("/submit")
//    public String submitContactForm(@ModelAttribute ContactForm contactForm, Model model) {
//        contactFormRepository.save(contactForm);
//
//        sendEmail(contactForm);
//
//        model.addAttribute("message", "Your message has been sent successfully!");
//
//        return "index";
//    }
//
//    private void sendEmail(ContactForm contactForm) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo("testowankomjupku@gmail.com");
//        message.setSubject("New Contact Form Submission");
//        message.setText("Name: " + contactForm.getName() +
//                "\nEmail: " + contactForm.getEmail() +
//                "\nMessage: " + contactForm.getMsg());
//
//        mailSender.send(message);
//    }


