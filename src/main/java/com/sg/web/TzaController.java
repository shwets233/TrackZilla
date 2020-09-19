package com.sg.web;

import com.sg.entity.Application;
import com.sg.entity.Release;
import com.sg.entity.Ticket;
import com.sg.service.ApplicationService;
import com.sg.service.ReleaseService;
import com.sg.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
public class TzaController {
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private ReleaseService releaseService;

    @Autowired
    public void setApplicationService(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Autowired
    public void setReleaseService(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @GetMapping("/applications")
    public String retrieveApplications(Model model){
        model.addAttribute("applications", applicationService.listApplications());
        return "applications";
    }

    @RequestMapping("/applications/new")
    public String showNewApplicationPage(Model model) {
        Application application=new Application();
        model.addAttribute("application",application);
        return "new_application";
    }
    @RequestMapping(value = "/saveApplication", method = RequestMethod.POST)
    public String saveApplication(@ModelAttribute("application") Application application) {
        applicationService.saveApplication(application);
        return "redirect:/";
    }

    @RequestMapping("/applications/edit/{id}")
    public ModelAndView showEditApplicationPage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("edit_application");
        Application application = applicationService.getApplication(id);
        mav.addObject("application", application);

        return mav;
    }
    @RequestMapping ("/applications/delete/{id}")
    public String deleteApplication(@PathVariable(name = "id") long id) {
        applicationService.deleteApplication(id);
        return "redirect:/";
    }

    @GetMapping("/tickets")
    public String retrieveTickets(Model model){
        try {
            System.out.println("Retrive Tickets"+ticketService.listTickets());
            model.addAttribute("tickets", ticketService.listTickets());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return "tickets";
    }

    @RequestMapping("/tickets/new")
    public String showNewTicketPage(Model model)
    {
        try {
            Ticket ticket = new Ticket();
            System.out.println("Start: " + ticket.toString());
            List<Application> application = new LinkedList<>();
            List<Release> releaseList = new LinkedList<>();
            for (Application a : applicationService.listApplications()) {
                application.add(a);
                System.out.print(application);
            }
            for (Release r : releaseService.listReleases()) {
                releaseList.add(r);
                System.out.println(releaseList);
            }
            model.addAttribute("ticket", ticket);
            model.addAttribute("applications", application);
            model.addAttribute("releases", releaseList);
            //return "new_ticket";
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return "new_ticket";
    }

    @RequestMapping(value = "/saveTicket", method = RequestMethod.POST)
    public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
        try {
            System.out.println("SaveTicket"+ticket.toString());
            ticketService.saveTicket(ticket);
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }

        return "redirect:/";
    }

    @RequestMapping("/tickets/edit/{id}")
    public ModelAndView showEditTicketPage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("edit_ticket");
        Ticket ticket = ticketService.getTicket(id);
        mav.addObject("ticket", ticket);
        List<Application> applications = new LinkedList<>();
        for (Application a : applicationService.listApplications()) {
            applications.add(a);
            System.out.print(applications);
        }
        mav.addObject("applications", applications);

        return mav;
    }


    @RequestMapping("/tickets/delete/{id}")
    public String deleteTicket(@PathVariable(name = "id") long id) {
        ticketService.deleteTicket(id);
        return "redirect:/";
    }

    @GetMapping("/releases")
    public String retrieveReleases(Model model){
        model.addAttribute("releases", releaseService.listReleases());
        return "releases";
    }

    @RequestMapping("/releases/new")
    public String showNewReleasePage(Model model) {
        Release release=new Release();
        model.addAttribute("release",release);
        return "new_release";
    }
    @RequestMapping(value = "/saveRelease", method = RequestMethod.POST)
    public String saveRelease(@ModelAttribute("release") Release release) {
        releaseService.saveRelease(release);

        return "redirect:/";
    }

    @RequestMapping("/releases/edit/{id}")
    public ModelAndView showEditReleasePage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("edit_release");
        Release release = releaseService.getRelease(id);
        mav.addObject("release", release);

        return mav;
    }
    @RequestMapping("/releases/delete/{id}")
    public String deleteRelease(@PathVariable(name = "id") long id) {
        releaseService.deleteRelease(id);
        return "redirect:/";
    }
}