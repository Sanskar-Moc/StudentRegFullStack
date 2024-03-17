package com.wileyedge;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.wileyedge.service.IService;

@Controller
public class StudentController {
	@Autowired
	private IService service;

	@GetMapping(value = "/getform.htm")
	public String showStudentForm(Map<String,Student> map) {
		System.out.println("Inside showStudentForm()");
		map.put("student", new Student());
		return "studentForm";
	}
	//	public String persistEmp(@RequestParam("empid") int id,String fname,String lname,Map<String,Employee> map) {
	@PostMapping(value = "/savestudent.htm")
	public String persistStudent(@ModelAttribute("student") Student e,BindingResult br,Map<String,Student> map) {
		System.out.println("Inside persistStudent()");
		System.out.println("name "+e.getName()+" age "+e.getAge()+" mobile "+e.getMobile());
		List<Student>list=new ArrayList<>();
		list.add(e);
		
		if(br.hasErrors()) {
			return "studentForm";
		}
		service.saveStudents(list);

		return "success";
	}
//	@RequestMapping(value = "/changeLocale.htm", method=RequestMethod.GET)
//	public String changeLocale(String lang,HttpServletRequest req,Model model) {
//		System.out.println("Inside changeLocale() "+lang);
//		HttpSession session=req.getSession();
//		session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale(lang));
//		model.addAttribute("emp", new Student());
//		return "redirect:getform.htm";
//	}

}
