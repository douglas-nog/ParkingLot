package br.com.dwn.smartcities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.dwn.smartcities.dao.ParkingDAO;
import br.com.dwn.smartcities.entity.Parking;

@Controller
@RequestMapping("parking")
public class ParkingController {

	@Autowired
	private ParkingDAO dao;
	
	@Transactional
	@PostMapping("delete")
	public ModelAndView delete(int code, RedirectAttributes attr) {
		try {
			dao.delete(code);
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView().addObject("msg", e.getMessage());
		}
		attr.addFlashAttribute("msg", "Removed!");
		return new ModelAndView("redirect:/parking/listAll");
	}
	
	@GetMapping("edit/{id}")
	public ModelAndView openFormEdit(@PathVariable("id") int code) {
		return new ModelAndView("parking/edit")
				.addObject("parking", dao.read(code));
	}
	
	@PostMapping("edit")
	@Transactional
	public ModelAndView processFormEdit(Parking parking, RedirectAttributes redirect) {
		try {
			dao.update(parking);
			redirect.addFlashAttribute("msg", "Edited successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("parking/edit");
		}
		return new ModelAndView("redirect:/parking/listAll");
	}

	@GetMapping("subscribe")
	public String openForm(Parking parking) {
		return "parking/subscribe";
	}

	@PostMapping("subscribe")
	@Transactional
	public ModelAndView processForm(Parking parking, RedirectAttributes redirect) {
		try {
			dao.create(parking);
			redirect.addFlashAttribute("msg", "registered successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("parking/subscribe");
			// here we can use -> .addbject("msg", e.getMessage()); to show the error message to the user.
		}
		return new ModelAndView("redirect:/parking/subscribe");
	}
	
	@GetMapping("listAll")
	public ModelAndView listAll() {
		return new ModelAndView("parking/listAll").addObject("parkings", dao.listAll());
	}

}
