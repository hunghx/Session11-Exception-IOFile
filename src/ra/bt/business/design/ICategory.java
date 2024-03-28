package ra.bt.business.design;

import ra.bt.business.entity.Category;

import java.util.List;

public interface ICategory {
    List<Category> findAll(); // lay ra danh sach danh muc
    Category findById(int id); // tim kiem danh muc theo id
    void save(Category category); // them hoac cap nhat danh muc
    void deleteById(int id); // xoa theo id
}
