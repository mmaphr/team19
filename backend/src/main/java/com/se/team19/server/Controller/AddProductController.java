package com.se.team19.server.Controller;

import com.se.team19.server.Entity.AddProducts;
import com.se.team19.server.Entity.Category;
import com.se.team19.server.Entity.Note;
import com.se.team19.server.Entity.Stock;
import com.se.team19.server.Repository.AddProductsRepository;
import com.se.team19.server.Repository.CategoryRepository;
import com.se.team19.server.Repository.NoteRepository;
import com.se.team19.server.Repository.StockRepository;
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
//ng serve --disable-host-check
public class AddProductController {

    @Autowired
    private AddProductsRepository addProductsRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private StockRepository stockRepository;

    @Autowired
    public AddProductController(AddProductsRepository addProductsRepository,CategoryRepository categoryRepository,NoteRepository noteRepository,StockRepository stockRepository){
        this.addProductsRepository = addProductsRepository;
        this.categoryRepository = categoryRepository;
        this.noteRepository = noteRepository;
        this.stockRepository = stockRepository;

    }

    //  <!========== CategoryCombobox ==========!>
    @GetMapping(path ="/Category", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Category> Category() {
        return categoryRepository.findAll().stream().collect(Collectors.toList());
    }

    //  <!========== NoteCombobox ==========!>
    @GetMapping(path ="/Note", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Note> Note() {
        return noteRepository.findAll().stream().collect(Collectors.toList());
    }

    //  <!========== SaveAndUpdateToStock || SavetoAddProduct==========!>
    @RequestMapping(path = "/AddStock/{category}/{itemname}/{amount}/{noteitem}")
    public AddProducts newAddProducts(AddProducts addProducts, Stock newStock, @PathVariable String category, @PathVariable String itemname, @PathVariable Long amount, @PathVariable String noteitem) {
        Category cat = categoryRepository.findBycategoryName(category);
        Stock Sid = stockRepository.findByCategoryNameAndProductName(cat,itemname);
        Note newnote = noteRepository.findBynoteName(noteitem);
        Date date = new Date();
        String dateInString = "dd.MM.yyyy HH:mm:ss";
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
        }
//        <!========== SaveToStock ===========!>
        if(Sid == null){
            newStock.setCategoryName(cat);
            newStock.setProductName(itemname);
            newStock.setAmountTotal(amount);
            stockRepository.save(newStock);

        }
        //        <!========== UpdateToStock ===========!>
        else if(Sid != null){
            stockRepository.findById(Sid.getStockId())
                    .map(update ->{
                                update.setAmountTotal(Sid.getAmountTotal()+amount);
                                return stockRepository.save(update);
                            }
                    ).orElseGet(() ->{
                newStock.setStockId(Sid.getStockId());
                return stockRepository.save(newStock);
            });
        }
//        <!========== SaveToAddProduct ===========!>
        Stock Aid = stockRepository.findByCategoryNameAndProductName(cat,itemname);
        addProducts.setCategoryName(cat);
        addProducts.setAddProductName(itemname);
        addProducts.setAddAmount(amount);
        addProducts.setNoteName(newnote);
        addProducts.setAddDate(date);
        addProducts.setStockName(Aid);
        return addProductsRepository.save(addProducts);
    }

    //  <!========== ShowTableAddProduct ==========!>
    @GetMapping(path ="/ShowAddItem", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<AddProducts> AddProducts() {
        long num = addProductsRepository.count();
        Collection<AddProducts> addLast = addProductsRepository.findByAddProductId(num);
        return addLast;
    }

    //  <!========== ShowTableStock ==========!>
    @GetMapping(path ="/Stock", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Stock> Stock() {
        return stockRepository.findAll().stream().collect(Collectors.toList());
    }
}
