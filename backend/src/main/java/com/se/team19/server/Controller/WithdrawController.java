package com.se.team19.server.Controller;

import com.se.team19.server.Entity.*;
import com.se.team19.server.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class WithdrawController {

    @Autowired
    private WithdrawRepository withdrawRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    public WithdrawController(WithdrawRepository withdrawRepository, CategoryRepository categoryRepository,StockRepository stockRepository,StaffRepository staffRepository,DepartmentRepository departmentRepository){
        this.withdrawRepository = withdrawRepository;
        this.categoryRepository = categoryRepository;
        this.departmentRepository = departmentRepository;
        this.stockRepository = stockRepository;
        this.staffRepository = staffRepository;
    }
    //  <!========== CategoryCombobox ==========!>
    @GetMapping(path ="/WithdrawCategory", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Category> Category() {
        return categoryRepository.findAll().stream().collect(Collectors.toList());
    }

    //  <!========== ItemNameCombobox ==========!>
    @GetMapping(path ="/WithdrawItemName/{category}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Stock> Stock(@PathVariable String category) {
        Category wategory= categoryRepository.findBycategoryName(category);
        Collection <Stock> stock =  stockRepository.findByCategoryName(wategory);
        return stock;
    }

    //  <!========== DepartmentCombobox ==========!>
    @GetMapping(path ="/WithdrawDepartment", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Department> Department() {
        return departmentRepository.findAll().stream().collect(Collectors.toList());
    }
    //  <!========== UpdateToStock || SaveToWithdraw==========!>
    @RequestMapping(path = "/WithdrawStock/{category}/{itemname}/{amount}/{department}/{description}/{username}/{password}")
    public Withdraw newWithdraw(Withdraw withdraw, Stock newStock, @PathVariable String category, @PathVariable String itemname, @PathVariable Integer amount, @PathVariable String department, @PathVariable String description, @PathVariable String username, @PathVariable String password) {
        Category cat = categoryRepository.findBycategoryName(category);
        Stock Sid = stockRepository.findByCategoryNameAndProductName(cat,itemname);
        Staff userandpass = staffRepository.findByUsernameAndPassword(username,password);
        Department de = departmentRepository.findByDepartmentName(department);
        Date date = new Date();
        String dateInString = "dd.MM.yyyy HH:mm:ss";
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
        }
        //        <!========== UpdateToStock ===========!>
        if (Sid.getAmountTotal() >= amount && Sid.getAmountTotal() > 0 && amount > 0) {
            stockRepository.findById(Sid.getStockId())
                    .map(update -> {
                        update.setAmountTotal(Sid.getAmountTotal() - amount);
                        return stockRepository.save(update);
                    }
                    ).orElseGet(() -> {
                    newStock.setStockId(Sid.getStockId());
                    return stockRepository.save(newStock);
                });
            //        <!========== SaveToWithdraw ===========!>
            withdraw.setWithdrawName(itemname);
            withdraw.setWithdrawAmount(amount);
            withdraw.setWithdrawDate(date);
            withdraw.setWithdrawDescrition(description);
            withdraw.setDepartmentName(de);
            withdraw.setCategoryName(cat);
            withdraw.setStaffName(userandpass);
            withdraw.setStockName(Sid);
            return withdrawRepository.save(withdraw);
        }
        return withdraw;
        }

    //  <!========== ShowTableAddProduct ==========!>
    @GetMapping(path ="/ShowWithdraw", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Withdraw> Withdraw() {
        long num = withdrawRepository.count();
        Collection<Withdraw> withdrawLast = withdrawRepository.findByWithdrawId(num);
        return withdrawLast;
    }

    //  <!========== ShowTableStock ==========!>
    @GetMapping(path ="/WithdrawStock", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Stock> Stock() {
        return stockRepository.findAll().stream().collect(Collectors.toList());
    }

}
