package product.com.product_management.fomat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import product.com.product_management.model.Category;
import product.com.product_management.service.category.ICategoryService;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

public class FomatProduct implements Formatter<Category> {
    private ICategoryService iCategoryService;
    @Autowired
    public FomatProduct(ICategoryService iCategoryService) {
        this.iCategoryService = iCategoryService;
    }
    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        return iCategoryService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Category object, Locale locale) {
        return "["+object.getId()+","+object.getName()+"]";
    }
}
