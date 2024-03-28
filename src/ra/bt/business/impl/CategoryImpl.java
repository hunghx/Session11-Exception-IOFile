package ra.bt.business.impl;

import ra.bt.business.design.ICategory;
import ra.bt.business.entity.Category;
import ra.bt.util.IOFile;

import java.util.List;

public class CategoryImpl implements ICategory {
    private static List<Category> categories;
    public static final String RA_BT_DATA_CATEGORY_TXT = "C:\\Users\\AD\\IdeaProjects\\Session11-Exception-IOFIle\\src\\ra\\bt\\data\\category.txt";

    static {
        categories = IOFile.readFromFile(RA_BT_DATA_CATEGORY_TXT);
    }

    @Override
    public List<Category> findAll() {
        return categories;
    }

    @Override
    public Category findById(int id) {
        for (Category cat : categories){
            if (cat.getId()==id){
                return cat;
            }
        }
        return null;
    }

    @Override
    public void save(Category category) {
        if (findById(category.getId())==null){
            // them moi
            categories.add(category);
        }else {
            categories.set(categories.indexOf(findById(category.getId())),category);
        }
        IOFile.writeToFile(RA_BT_DATA_CATEGORY_TXT,categories);
    }

    @Override
    public void deleteById(int id) {
        if (findById(id)!=null){
            categories.remove(findById(id));
            IOFile.writeToFile(RA_BT_DATA_CATEGORY_TXT,categories);
        }
    }
}
