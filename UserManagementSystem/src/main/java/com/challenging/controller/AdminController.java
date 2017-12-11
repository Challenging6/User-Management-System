package com.challenging.controller;


import com.challenging.domain.Admin;
import com.challenging.domain.Book;
import com.challenging.domain.Customer;
import com.challenging.service.AdminService;
import com.challenging.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Controller
@SessionAttributes(value = {"admin"}, types = {Admin.class})
@RequestMapping(value = "admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "admin-login",method = RequestMethod.POST)
    public String AdminLogin(Model model,
                             @RequestParam("email") String email,
                             @RequestParam("password") String password,
                             RedirectAttributes redirectAttributes
    ) {

        if (adminService.validateLogin(email, password)) {
            redirectAttributes.addFlashAttribute("admin", adminService.queryByEmail(email));
            return "redirect:adminInfo";
        }
        return "admin/adminLoginFailed";
    }

    @RequestMapping(value="adminInfo")
    public String adminInfo(){
        return "admin/adminInfo";
    }


    @RequestMapping(value = "updateInfo")
    public String updateInfo(){
        return "admin/updateInfo";
    }

    @RequestMapping(value="submitInfo")
    public String submitInfo(@Valid @ModelAttribute Admin admin,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes,
                             Model model){
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            System.out.println(fieldError.toString());
            return "admin/updateInfo";
        }
        else if (adminService.queryByEmail(admin.getEmail()) ==null || Objects.equals(adminService.queryByEmail(admin.getEmail()).getId(), admin.getId())) {
            adminService.updateAdmin(admin);
            redirectAttributes.addFlashAttribute("admin", admin);
            return "redirect:adminInfo";
        }
        else{
            redirectAttributes.addFlashAttribute("admin", admin);
            return "admin/updateInfoFailed";
        }
    }

    @RequestMapping(value = "updatePassword")
    public String updatePassword(){
        return "admin/updatePassword";
    }

    @RequestMapping(value="submitPassword")
    public String submitPassword(@Valid @ModelAttribute Admin admin,
                                 BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            System.out.println(fieldError.toString());
            return "admin/updatePassword";
        }
        adminService.updatePassword(admin);
        return "admin/login";
    }

    @RequestMapping(value="viewAllCustomer")
    public String viewAllCustomer(Model model){
        List<Customer> customers = adminService.queryAllCustomer();
        model.addAttribute("customers", customers);
        return "admin/viewAllCustomer";
    }

    @RequestMapping(value = "allBooks")
    public String allBooks(Model model){
        model.addAttribute("books", bookService.queryAllBook());
        return "admin/manageBooks";
    }

    @RequestMapping(value="books/{bookId}")
    public String bookInfo(Model model, @PathVariable int bookId){
        Book book = bookService.queryById(bookId);
        model.addAttribute(book);
        return "admin/bookInfo";
    }

    @RequestMapping(value="updateBook/{bookId}")
    public String updateBook(Model model, @PathVariable int bookId){
        Book book = bookService.queryById(bookId);
        model.addAttribute(book);
        return "admin/updateBook";
    }


    @RequestMapping(value="submitUpdateBook")
    public String submitUpdateBook(@Valid @ModelAttribute Book book,
                                   BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            System.out.println(fieldError.toString());
            return "admin/updateBook";
        }
        bookService.updateBook(book);
        return "redirect:books/"+book.getBookId();

    }

    @RequestMapping(value = "addBook")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        return "admin/addBook";
    }

    @RequestMapping(value="submitAddBook")
    public String submitAddBook(@Valid @ModelAttribute Book book,
                                   BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            System.out.println(fieldError.toString());
            return "admin/addBook";
        }
        bookService.insertBook(book);
        model.addAttribute("book", book);
        return "admin/bookInfo";

    }
}

