package com.challenging.controller;

import com.challenging.domain.Book;
import com.challenging.domain.Customer;
import com.challenging.service.BookService;
import com.challenging.service.CustomerService;
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
@SessionAttributes(value = {"customer"}, types = {Customer.class})
@RequestMapping(value = "customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private BookService bookService;



    @RequestMapping(value = "")
    public String index(Model model){
        return "customer/login";
    }

    @RequestMapping(value="customer-login", method = RequestMethod.POST)
    public String login(Model model,
                        @RequestParam("email") String email,
                        @RequestParam("password") String password,
                        RedirectAttributes redirectAttributes
    ){

        if (customerService.validateLogin(email,password)) {
            redirectAttributes.addFlashAttribute("customer",customerService.queryByEmail(email));
            return "redirect:customerInfo";
        }
        return "customer/loginFailed";
    }

    @RequestMapping(value="customerInfo")
    public String customerInfo(){
        return "customer/customerInfo";
    }

    @RequestMapping(value="register")
    public String register(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/register";
    }

    @RequestMapping(value = "new_account")
    public String createNewAccount(@Valid @ModelAttribute Customer customer,
                                   BindingResult bindingResult,RedirectAttributes redirectAttributes,
                                   Model model){

        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            System.out.println(fieldError.toString());
            return "customer/register";
        }

        else if (customerService.queryByEmail(customer.getEmail()) ==null) {
            customerService.createNewAccount(customer);
            redirectAttributes.addFlashAttribute("customer", customer);
            return "redirect:registerSuccess";
        }
        else{
            redirectAttributes.addFlashAttribute("customer", customer);
            return "redirect:registerFailed";
        }
    }

    @RequestMapping(value="query/{id}")
    public String queryById(Model model, @PathVariable Integer id){
        model.addAttribute("customer", customerService.queryById(id));
        return "admin/customerInfo";
    }

    @RequestMapping(value = "registerSuccess")
    public String registerSuccess(){
        return "customer/registerSuccess";
    }

    @RequestMapping(value = "registerFailed")
    public String registerFailed(){
        return "customer/registerFailed";
    }

    @RequestMapping(value = "updateInfo")
    public String updateInfo(){
        return "customer/updateInfo";
    }

    @RequestMapping(value="submitInfo")
    public String submitInfo(@Valid @ModelAttribute Customer customer,
                             BindingResult bindingResult,RedirectAttributes redirectAttributes,
                             Model model){
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            System.out.println(fieldError.toString());
            return "customer/updateInfo";
        }
        else if (customerService.queryByEmail(customer.getEmail()) ==null || Objects.equals(customerService.queryByEmail(customer.getEmail()).getId(), customer.getId())) {
            customerService.updateCustomer(customer);
            redirectAttributes.addFlashAttribute("customer", customer);
            return "redirect:customerInfo";
        }
        else{
            redirectAttributes.addFlashAttribute("customer", customer);
            return "customer/updateInfoFailed";
        }
    }

    @RequestMapping(value = "updatePassword")
    public String updatePassword(){
        return "customer/updatePassword";
    }

    @RequestMapping(value="submitPassword")
    public String submitPassword(@Valid @ModelAttribute Customer customer,
                                 BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            System.out.println(fieldError.toString());
            return "customer/updatePassword";
        }
        customerService.updatePassword(customer);
        return "customer/login";
    }

    @RequestMapping(value="books")
    public String Books(Model model, @ModelAttribute Customer customer){
        List<Book> books = customerService.books(customer.getId());
        model.addAttribute("books", books);
        return "/customer/books";
    }

    @RequestMapping(value="books/{bookId}")
    public String bookInfo(Model model, @PathVariable int bookId){
        Book book = bookService.queryById(bookId);
        model.addAttribute(book);
        return "/customer/bookInfo";
    }

    @RequestMapping(value="returnBook/{bookId}")
    public String returnBook(Model model, @PathVariable int bookId, @ModelAttribute Customer customer){
        customerService.returnBook(bookId, customer.getId());
        model.addAttribute("message", "归还成功!");
        return "customer/borrowInfo";
    }

    @RequestMapping(value="allBooks")
    public String allBooks(Model model){
        model.addAttribute("books", bookService.queryAllBook());
        return "customer/allBooks";
    }

    @RequestMapping(value = "borrowBook/{bookId}")
    public String borrowBook(Model model, @PathVariable int bookId, @ModelAttribute Customer customer){
        String message;
        int info = customerService.borrowBook(bookId, customer.getId());
        if (info == 1){
            message = "借阅成功";
        }
        else if(info == 0){
            message = "借阅失败,您已借阅本图书";
        }
        else if(info==2){
            message ="本图书库存不足";
        }
        else{
            message="出问题了,请稍后尝试";
        }
        model.addAttribute("message", message);
        return "customer/borrowInfo";

    }

}
